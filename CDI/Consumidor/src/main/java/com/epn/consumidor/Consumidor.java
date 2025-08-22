/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.epn.consumidor;

import com.epn.productor.Cliente;
import com.epn.productor.NombreEspecial;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

/**
 *
 * @author ricardo
 */
@Stateless
public class Consumidor {

    @Inject
    private String nombres;
    
     @Inject
    @NombreEspecial
    private String apellido; // Inyección con qualifier -> Samsung Galaxy
    
     @Inject
     @NombreEspecial
    private Cliente clienteDto; 
    

    public void mostrarNombre() {
        System.out.println("Nombres: " + nombres);
         System.out.println("Apellidos: " + apellido);
         System.out.println("com.epn.consumidor.Consumidor.mostrarNombre()" + clienteDto.getNombre() + " " + clienteDto.getApellido());
    }
    
    
}
