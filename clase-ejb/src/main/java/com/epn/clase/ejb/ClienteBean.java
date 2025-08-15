package com.epn.clase.ejb;

import com.epn.clase.jpa.Clientes;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;
import com.epn.clase.ejb.remoto.ClienteBeanRemoto;
import com.epn.clase.ejb.local.ClienteBeanLocal;

/**
 *
 * @author ricardo
 */
@Stateless
public class ClienteBean implements ClienteBeanLocal, ClienteBeanRemoto {

    @PersistenceContext(unitName = "clientesPU")
    private EntityManager em;

    @Override
    public void agregarCliente(Clientes cliente) {
        em.persist(cliente);
    }

    @Override
    public List<Clientes> obtenerClientes() {
        return em.createQuery("SELECT c FROM Clientes c", Clientes.class).getResultList();
    }

    @Override
    public void eliminarCliente(Long id) {
        Clientes cliente = em.find(Clientes.class, id);
        if (cliente != null) {
            em.remove(cliente);
        }
    }

    @Override
    public Clientes obtenerClientePorId(Long id) {
        return em.find(Clientes.class, id);
    }
}
