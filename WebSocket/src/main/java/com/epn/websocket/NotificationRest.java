/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.epn.websocket;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.RequestScoped;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

/**
 *
 * @author ricardo
 */
@Path("/notificaciones")
@ApplicationScoped
public class NotificationRest {
    @POST
    @Consumes(MediaType.TEXT_PLAIN)
    public Response recibirNotificacion(String mensaje) {
        System.out.println("Recibido mensaje REST: " + mensaje);

        // Llamada a WebSocket
        try {
            ChatEndpoint.sendNotification(mensaje);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Responder inmediatamente
        return Response.ok("Notificación enviada").build();
    }

}
