/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.epn.concurrencia;

import com.epn.clase.ejb.local.ClienteBeanLocal;
import com.epn.clase.ejb.local.TareaBeanLocal;
import com.epn.clase.jpa.Clientes;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.annotation.Resource;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.concurrent.ManagedExecutorService;
import jakarta.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@Singleton
@Startup
public class ServicioManaged {

    // Inyección del servicio gestionado por Payara
    @Resource
    private ManagedExecutorService executor;

    @Inject
    private ClienteBeanLocal clienteLocal;
    
    

    @PostConstruct
    public void init() {
        System.out.println("Enviando tarea con ManagedExecutorService...");

        executor.submit(() -> {
            try {

                System.out.println("Tarea gestionada inició...");
                Thread.sleep(3000);
                List<Clientes> listaClientes = new ArrayList();
                
                for (int i = 0; i <= 5000; i++) {
                    Clientes clientes = new Clientes();
                    //clientes.setId(Long.valueOf(String.valueOf(i)));
                    clientes.setNombre("cliente" + String.valueOf(i));
                    clientes.setTelefono(String.valueOf(i));
                    clientes.setEmail("cliente" + String.valueOf(i) + "@gmail.com");
                    clienteLocal.agregarCliente(clientes);  
                    System.out.println("Inserta los clientes.");
                }                
                System.out.println("Tarea gestionada terminó.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
}
