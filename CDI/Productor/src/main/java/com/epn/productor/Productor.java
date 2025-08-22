/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.epn.productor;

import jakarta.ejb.Stateless;
import jakarta.enterprise.inject.Produces;

/**
 *
 * @author ricardo
 */
@Stateless
public class Productor {

    @Produces
    public String crearNombres() {
        return "Ricardo Vicente";
    }

    @Produces
    @NombreEspecial
    public String crearApelldos() {
        return "Granja Requelme";
    }
    
    @Produces
    public Cliente obtenerCliente(){
        String nombre = "Cristina";
        String apellido = "Saavedra";
        Cliente clienteCreado = new Cliente(nombre, apellido);
        return clienteCreado;
        
    }
    
    @Produces
    @NombreEspecial
    public Cliente obtenerCliente2(){
        String nombre = "Cristina Gabriela";
        String apellido = "Saavedra Martínez";
        Cliente clienteCreado = new Cliente(nombre, apellido);
        return clienteCreado;
        
    }
}
