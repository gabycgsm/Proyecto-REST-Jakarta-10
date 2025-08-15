/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.epn.clase.rest;

import com.epn.clase.rest.JwtUtil.JwtUtil;
import io.jsonwebtoken.io.IOException;
import jakarta.annotation.Priority;
import jakarta.ws.rs.Priorities;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.Provider;

/**
 *
 * @author ricardo
 */
@Provider
@Priority(Priorities.AUTHENTICATION)
@Secured // nuestra anotación personalizada
public class JwtFilter   implements ContainerRequestFilter {

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        String path = requestContext.getUriInfo().getPath();
        // Permitir el login y WADL sin token
        if (path.startsWith("api/auth/login") || path.contains("application.wadl")) {
            return;
        }

        String header = requestContext.getHeaderString("Authorization");
        if (header == null || !header.startsWith("Bearer ")) {
            requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED)
                    .entity("Falta encabezado Authorization: Bearer <token>").build());
            return;
        }
        String token = header.substring("Bearer".length()).trim();
        try {
            String user = JwtUtil.validarToken(token);
            // Podrías setear un SecurityContext aquí si lo necesitas
        } catch (Exception ex) {
            requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED)
                    .entity("Token inválido o expirado").build());
        }
    }
}
