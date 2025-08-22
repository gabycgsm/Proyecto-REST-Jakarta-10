/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.epn.concurrencia;

import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.annotation.Resource;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.concurrent.ManagedExecutorService;

@Singleton
@Startup
public class ServicioNativo {

    // Inyección del servicio gestionado por Payara
    @Resource
    private ManagedExecutorService executor;

    @PostConstruct
    public void init() {
        System.out.println("Enviando tarea con ManagedExecutorService...");

        executor.submit(() -> {
            try {
                System.out.println("Tarea gestionada inició...");
                Thread.sleep(3000);
                System.out.println("Tarea gestionada terminó.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
}

