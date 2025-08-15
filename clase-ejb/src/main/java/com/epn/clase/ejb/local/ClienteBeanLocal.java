/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.epn.clase.ejb.local;

import com.epn.clase.jpa.Clientes;
import jakarta.ejb.Local;
import java.util.List;



/**
 *
 * @author ricardo
 */

@Local
public interface ClienteBeanLocal {
    
    void agregarCliente(Clientes cliente);
    
    List<Clientes> obtenerClientes();
    
    void eliminarCliente(Long id);

    Clientes obtenerClientePorId(Long id);


    
}
