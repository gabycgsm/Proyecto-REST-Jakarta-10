/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.epn.clase.ejb.local;

import com.epn.clase.jpa.Tareas;
import jakarta.ejb.Local;
import java.util.List;

/**
 *
 * @author CEC
 */
@Local
public interface TareaBeanLocal {
    
    Tareas obtenerTareas();
    
}
