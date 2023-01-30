/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Excecpcion;

import java.io.IOException;

/**
 * Clase que genera una excepcion propia 
 * @author marle
 */
public class ValorInsuficienteException extends Exception{
    public ValorInsuficienteException(String message){
        super(message);
    }
}
