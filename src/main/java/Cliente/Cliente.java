/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cliente;

import java.io.Serializable;

/**
 * Clase cliente
 * @author marle
 */
public class Cliente implements Serializable{

    private String user;
    private String nombre;
    private String password;
/**
 * constructor de la clase Cliente
 * @param user parametro de usuario
 * @param nombre parametro del nombre
 * @param password parametro de la contraseña
 */
    public Cliente(String user, String nombre, String password) {
        this.user = user;
        this.nombre=nombre;
        this.password = password;
    }
/**
 * metodo que retorna el usuario
 * @return retorna el usuario
 */
    public String getUser() {
        return user;
    }
/**
 * Metodo para actualizar el usuario
 * @param user parametro del usuario
 */
    public void setUser(String user) {
        this.user = user;
    }
/**
 * Metodo que retorna el nombre
 * @return retorna el nombre
 */
    public String getNombre() {
        return nombre;
    }
/**
 * Metodo que actualiza el nombre 
 * @param nombre parametro del nombre
 */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
/**
 * Metodo que retorna la contraseña
 * @return retorna la contraseña;
 */
    public String getPassword() {
        return password;
    }
/**
 * Metodo que actualiza la contraseña
 * @param password parametro contraseña
 */
    public void setPassword(String password) {
        this.password = password;
    }
/**
 * Metodo con el formato toString de los atributos de la clase
 * @return retorna el formato con los valores de los atributos 
 */
    @Override
    public String toString() {
        return "Cliente{" + "user=" + user + ", nombre=" + nombre + ", password=" + password + '}';
    }

  
    
}
