/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.epn.concurrencia;

import com.epn.clase.ejb.local.TareaBeanLocal;
import com.epn.clase.jpa.Tareas;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.annotation.Resource;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.concurrent.ManagedScheduledExecutorService;
import jakarta.inject.Inject;
import java.util.concurrent.TimeUnit;

@Singleton
@Startup
public class ServicioScheduler {

    @Resource
    private ManagedScheduledExecutorService scheduler;
    
    @Inject
    private TareaBeanLocal tareaLocal;        

    @PostConstruct
    public void init() {
        System.out.println("Programando tarea periódica...");

//        scheduler.scheduleAtFixedRate(() -> {
//            System.out.println("Tarea programada ejecutándose cada 10 segundos...");
//        }, 0, 10, TimeUnit.SECONDS);

        Tareas tarea = tareaLocal.obtenerTareas();  
        System.out.println("com.epn.concurrencia.ServicioScheduler.init()" + tarea.getTiempo() + tarea.getValor());

        scheduler.scheduleAtFixedRate(() -> {
            System.out.println("Tarea programada ejecutándose desde la base cada"+tarea.getValor()+" segundos...");
        }, 0, Long.parseLong(tarea.getValor()) , tarea.getTiempo());
    }
}
