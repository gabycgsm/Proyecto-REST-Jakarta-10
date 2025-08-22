/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.epn.concurrencia;

import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.inject.Inject;

/**
 *
 * @author ricardo
 */
@Singleton
@Startup
public class Concurrencia {

    
     @Inject
    private ServicioManaged servicioManaged;

    @PostConstruct
    public void iniciar() {
        servicioManaged.init();
    }
    
    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}
