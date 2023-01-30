/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Local;

/**
 *
 * @author marle
 */
public class Local {
   
    private double coordenadaX;
    private double coordenadaY;
     private String direccion;
     private String nombre;
     private String hora;
/**
 * Constructor de la clase local
 * @param coordenadaX parametro coordenadax
 * @param coordenadaY parametro coordenaday
 * @param direccion parametro direccion
 * @param nombre parametro nombre
 * @param hora parametro hora
 */
    public Local(double coordenadaX, double coordenadaY, String direccion, String nombre, String hora) {
        this.coordenadaX = coordenadaX;
        this.coordenadaY = coordenadaY;
        this.direccion = direccion;
        this.nombre = nombre;
        this.hora = hora;
    }
/**
 * meotod que retorna la coordenada x
 * @return retorna coordenada x
 */
    public double getCoordenadaX() {
        return coordenadaX;
    }
/**
 * metodo que actualiza la coordenada x 
 * @param coordenadaX parametro coordenada x
 */
    public void setCoordenadaX(double coordenadaX) {
        this.coordenadaX = coordenadaX;
    }
/**
 * metodo que retorna la coordenada y
 * @return retorna coordenada y
 */
    public double getCoordenadaY() {
        return coordenadaY;
    }
/**
 * metodo que actualiza la coordenada y
 * @param coordenadaY coordenada y
 */
    public void setCoordenadaY(double coordenadaY) {
        this.coordenadaY = coordenadaY;
    }
/**
 * metodo que retorna la direccion
 * @return retorna la direccion
 */
    public String getDireccion() {
        return direccion;
    }
/**
 * metodo que actualiza la direccion
 * @param direccion parametro de la direccion
 */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
/**
 * metodo que retorna el nombre
 * @return retorna el nombre
 */
    public String getNombre() {
        return nombre;
    }
/**
 * metodo que actualiza el nombre
 * @param nombre parametro del nombre
 */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
/**
 * metodo que retorna la hora
 * @return retorna la hora
 */
    public String getHora() {
        return hora;
    }
/**
 * metodo que actualiza la hora
 * @param hora parametro de la hora
 */
    public void setHora(String hora) {
        this.hora = hora;
    }
/**
 * metodo toString de la clase Local
 * @return retorna formato con los atributos
 */
    @Override
    public String toString() {
        return "Local{" + "coordenadaX=" + coordenadaX + ", coordenadaY=" + coordenadaY + ", direccion=" + direccion + ", nombre=" + nombre + ", hora=" + hora + '}';
    }

      
    
}
