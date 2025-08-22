package com.ricardo.async.boundary;

import com.ricardo.async.control.PedidoAsyncService;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.Produces;

@Path("pedidos")
@Produces(MediaType.TEXT_PLAIN)
public class PedidoResource {

    @Inject
    private PedidoAsyncService service;

    @GET
    @Path("nuevo")
    public String nuevo(@QueryParam("producto") String producto,
                        @QueryParam("cantidad") Integer cantidad) {
        if (producto == null || producto.isBlank()) {
            producto = "Producto Demo";
        }
        if (cantidad == null || cantidad <= 0) {
            cantidad = 1;
        }
        service.procesarAsync(producto, cantidad);
        return "📨 Pedido recibido (" + producto + " x" + cantidad + "). Se procesa en segundo plano...";
    }
}
