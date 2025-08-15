/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.epn.clase.ejb.remoto;

import com.epn.clase.jpa.Contactos;
import jakarta.ejb.Remote;
import java.util.List;

/**
 *
 * @author CEC
 */
@Remote
public interface ContactoBeanRemoto {
    void agregarContacto(Contactos contacto);
    List<Contactos> obtenerContactos();
    void eliminarContacto(Long id);

    Contactos obtenerContactoPorId(Long id);
    
}
