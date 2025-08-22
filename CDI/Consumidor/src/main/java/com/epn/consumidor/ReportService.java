/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.epn.consumidor;

import jakarta.annotation.Resource;
import jakarta.ejb.Stateless;
import jakarta.enterprise.concurrent.ContextService;
import jakarta.enterprise.concurrent.ManagedExecutorService;
import jakarta.enterprise.concurrent.ManagedScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author CEC
 */
@Stateless
public class ReportService {
    
    @Resource
    private ContextService contextService;
    
    @Resource
    private ManagedExecutorService executor;
    
    @Resource
    private ManagedScheduledExecutorService scheduler;
    
    public void generateReport(){
        //Tarea concurrente gestionada por el contenedor
        executor.submit(() -> {System.out.println("Generando reporte en segundo plano..");
        });
        
    }        
    
    public void monitor(){
        scheduler.scheduleAtFixedRate(()->{System.out.println("Chequeo de sistema cada 5 segundos");}, 0, 5, TimeUnit.SECONDS);
    }
    
    public void runSecureTask(){
        Runnable task = () -> {
            System.out.println("Tarea ejecutada con contexto de seguridad y transacciones.");
        };
        
        Runnable contextualTask = contextService.createContextualProxy(task, Runnable.class);
        executor.submit(contextualTask);
    }
    
    
}
