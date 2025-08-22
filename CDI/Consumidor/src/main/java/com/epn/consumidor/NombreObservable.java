/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.epn.consumidor;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;

/**
 *
 * @author ricardo
 */
   @ApplicationScoped
 
public class NombreObservable {

 

        public void escucharEvento(@Observes String nombre) {
            System.out.println("📢 Observador detectó un nombre: " + nombre);
        }
    }

