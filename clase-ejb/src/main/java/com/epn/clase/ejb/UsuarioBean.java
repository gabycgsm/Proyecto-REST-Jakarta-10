/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.epn.clase.ejb;

import com.epn.clase.ejb.local.UsuarioBeanLocal;
import com.epn.clase.jpa.Usuarios;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

/**
 *
 * @author CEC
 */
@Stateless
public class UsuarioBean implements UsuarioBeanLocal{
    
    @PersistenceContext(unitName = "clientesPU")
    private EntityManager em;

    @Override
    public boolean validarUsuario(Usuarios usuario) {
        Usuarios usuarioBD = em.find(Usuarios.class, usuario.getUsuario());
        if(usuarioBD != null){
            return usuarioBD.getClave().equals(usuario.getClave());
        }else{
            return false;
        }
    }
    
}
