package com.ricardo.async.control;

import com.ricardo.async.entity.Pedido;
import jakarta.annotation.Resource;
import jakarta.ejb.Stateless;
import jakarta.enterprise.concurrent.ContextService;
import jakarta.enterprise.concurrent.ManagedExecutorService;
import jakarta.inject.Inject;

import java.util.logging.Logger;

@Stateless
public class PedidoAsyncService {

    private static final Logger LOG = Logger.getLogger(PedidoAsyncService.class.getName());

    @Resource(lookup = "java:comp/DefaultManagedExecutorService")
    private ManagedExecutorService executor;

    @Resource(lookup = "java:comp/DefaultContextService")
    private ContextService contextService;

    @Inject
    private PedidoDAO pedidoDAO;

    public void procesarAsync(String producto, int cantidad) {
        Runnable tarea = () -> {
            try {
                LOG.info(() -> "⏳ Procesando pedido en hilo: " + Thread.currentThread().getName());
                Pedido p = new Pedido(producto, cantidad);
                pedidoDAO.crear(p); // CMT @Stateless -> abre/gestiona la transacción
                LOG.info(() -> "✅ Pedido creado: " + producto + " x" + cantidad);
            } catch (Exception e) {
                LOG.severe("❌ Error en tarea asincrónica: " + e.getMessage());
            }
        };

        // Propagar contexto (seguridad/JNDI) a la tarea
        Runnable tareaConContexto = contextService.contextualRunnable(tarea);

        // Ejecutar en hilos gestionados por el contenedor
        executor.execute(tareaConContexto);
    }
}
