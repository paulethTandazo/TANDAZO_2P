/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Menu;

/**
 * Clase que contiene los atributos del MENU
 * @author marle
 */
public class Menu {
    private String descripcion;
    private double precio;
    private tipoMenu tipo;
/**
 * constructor de la clase menu
 * @param descripcion parametro de descripcion
 * @param precio parametro del precio
 * @param tipo parametro del tipo
 */
    public Menu(String descripcion, double precio, tipoMenu tipo) {
        this.descripcion = descripcion;
        this.precio = precio;
        this.tipo = tipo;
    }
/**
 * meotod que retorna la descrpcioon
 * @return retorna la descripcion
 */
    public String getDescripcion() {
        return descripcion;
    }
/**
 * metodo que actualiza la descrpcion
 * @param descripcion parametro de la descripcion
 */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
/**
 * metodo que retorna el precio
 * @return reotrna el precio
 */
    public double getPrecio() {
        return precio;
    }
/**
 * metodo que actualiza el precio
 * @param precio parametro del precio
 */
    public void setPrecio(double precio) {
        this.precio = precio;
    }
/**
 * metodo que retorna el tipo
 * @return retorna el tipo
 */
    public tipoMenu getTipo() {
        return tipo;
    }
/**
 * metodo que actualiza el tipo
 * @param tipo parametro del tipo
 */
    public void setTipo(tipoMenu tipo) {
        this.tipo = tipo;
    }
/**
 * metodo toString de la clase MENU
 * @return retorna el formato con los atributos
 */
    @Override
    public String toString() {
        return "Menu{" + "descripcion=" + descripcion + ", precio=" + precio + ", tipo=" + tipo + '}';
    }

}
