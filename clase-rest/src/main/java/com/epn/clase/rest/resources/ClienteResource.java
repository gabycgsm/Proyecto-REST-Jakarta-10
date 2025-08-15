/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.epn.clase.rest.resources;

import com.epn.clase.ejb.remoto.ClienteBeanRemoto;
import com.epn.clase.jpa.Clientes;
import com.epn.clase.rest.Secured;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

/**
 *
 * @author ricardo
 */
@Path("/clientes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RequestScoped  // agrega esto
public class ClienteResource {

    @EJB
    private ClienteBeanRemoto clienteBean;

    @POST
    @Secured
    public void agregarCliente(Clientes cliente) {
        clienteBean.agregarCliente(cliente);
    }

    @GET
    @Secured
    public List<Clientes> obtenerClientes() {
        return clienteBean.obtenerClientes();
    }

    @GET
    @Path("/{id}")
    public Clientes obtenerClientePorId(@PathParam("id") Long id) {
        return clienteBean.obtenerClientePorId(id);
    }

    @DELETE
    @Path("/{id}")
    public void eliminarCliente(@PathParam("id") Long id) {
        clienteBean.eliminarCliente(id);
    }
}
