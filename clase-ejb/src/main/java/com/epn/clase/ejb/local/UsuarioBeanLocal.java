/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.epn.clase.ejb.local;

import com.epn.clase.jpa.Usuarios;
import jakarta.ejb.Local;

/**
 *
 * @author CEC
 */
@Local
public interface UsuarioBeanLocal {
    
    boolean validarUsuario(Usuarios usuario);
}
