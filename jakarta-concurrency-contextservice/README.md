# Jakarta Concurrency + ContextService (Payara 6 / Jakarta EE 10)

Proyecto de ejemplo que demuestra ejecución asincrónica controlada usando:
- `ManagedExecutorService` para ejecutar tareas.
- `ContextService` para propagar seguridad/JNDI y permitir uso de JTA en el hilo gestionado.
- JPA para persistir entidades.

## Módulos principales
- `PedidoResource` (JAX-RS): endpoint para disparar el proceso.
- `PedidoAsyncService` (EJB): arma la tarea asincrónica y la ejecuta con contexto.
- `PedidoDAO` (EJB): persistencia con JPA.
- `Pedido` (Entidad): entidad simple.

## Despliegue (Payara 6 / NetBeans 15)
1. Importa el proyecto Maven.
2. Asegúrate de tener un datasource por defecto (`jdbc/__default`).
3. Ejecuta en Payara 6.

## Probar
- URL base: `http://localhost:8080/jakarta-concurrency-contextservice/api`
- Crear un pedido asíncrono:
  ```bash
  curl "http://localhost:8080/jakarta-concurrency-contextservice/api/pedidos/nuevo?producto=Honeywell%20MPD31D&cantidad=3"
  ```

Revisa `server.log` para ver los mensajes de la tarea asincrónica.
