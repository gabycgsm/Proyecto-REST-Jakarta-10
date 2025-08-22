/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.epn.clase.ejb;

import com.epn.clase.ejb.local.TareaBeanLocal;
import com.epn.clase.jpa.Tareas;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

/**
 *
 * @author CEC
 */
@Stateless
public class TareaBean implements TareaBeanLocal{
    
    @PersistenceContext(unitName = "clientesPU")
    private EntityManager em;

    @Override
    public Tareas obtenerTareas() {
        return em.createQuery("SELECT t FROM Tareas t", Tareas.class).getSingleResult();
    }
    
}
