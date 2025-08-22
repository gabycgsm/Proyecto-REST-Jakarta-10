/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.epn.clase.rest.resources;

import com.epn.clase.rest.JwtUtil.JwtUtil;
import com.epn.clase.rest.dto.Credenciales;
import com.epn.clase.rest.dto.TokenResponse;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

/**
 *
 * @author ricardo
 */
@Path("/auth")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AuthResource {

    private static final String SECRET_KEY = "ClaveSuperSecretaParaFirmarJWT";

    @POST
    @Path("/login")    
    public Response login(Credenciales cred) {
        // Validar usuario (aquí puedes consultar la BD vía EJB)
        if ("admin".equals(cred.getUsuario()) && "1234".equals(cred.getPassword())) {
            String token = JwtUtil.generarToken(cred.getUsuario());
            return Response.ok(new TokenResponse(token)).build();
        } else {
            return Response.status(Response.Status.UNAUTHORIZED).entity("Credenciales inválidas").build();
        }
    }
}