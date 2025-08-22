package com.ricardo.async.control;

import com.ricardo.async.entity.Pedido;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
public class PedidoDAO {

    @PersistenceContext(unitName = "clientesPU")
    private EntityManager em;

    public void crear(Pedido p) {
        em.persist(p);
    }
}
