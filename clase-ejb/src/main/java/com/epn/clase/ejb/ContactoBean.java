/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.epn.clase.ejb;

import com.epn.clase.ejb.remoto.ContactoBeanRemoto;
import com.epn.clase.jpa.Contactos;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

/**
 *
 * @author CEC
 */
public class ContactoBean implements ContactoBeanRemoto{
    
    @PersistenceContext(unitName = "clientesPU")
    private EntityManager em;

    @Override
    public void agregarContacto(Contactos contacto) {
        em.persist(contacto);
    }

    @Override
    public List<Contactos> obtenerContactos() {
        return em.createQuery("SELECT c FROM Contactos c", Contactos.class).getResultList();
    }

    @Override
    public void eliminarContacto(Long id) {
        Contactos contacto = em.find(Contactos.class, id);
        if(contacto != null){
            em.remove(contacto);
        }
    }

    @Override
    public Contactos obtenerContactoPorId(Long id) {
        return em.find(Contactos.class, id);
    }
    
}
