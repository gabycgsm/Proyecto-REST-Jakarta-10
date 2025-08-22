/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.epn.consumidor;

import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.enterprise.event.Event;
import jakarta.inject.Inject;
import java.util.logging.Logger;

/**
 *
 * @author ricardo
 */
@Singleton
@Startup
public class AppStarter {

    private static final Logger LOG = Logger.getLogger(AppStarter.class.getName());

    @Inject
    private Consumidor consumidor;

    @Inject
    private Event<String> event; // Para disparar eventos CDI
    
    @Inject
    private ReportService report;

    @PostConstruct
    public void init() {
        LOG.info("🚀 AppStarter inicializado");
        
        consumidor.mostrarNombre();
        
        report.generateReport();
        
        report.monitor();
        
        report.runSecureTask();
        
        event.fire("Juan Perez");
    }

}
