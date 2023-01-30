/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pedido;

import java.io.Serializable;

/**
 * Clase pedido que contiene atributos:
 * idPedido,descripcion,cantidad,precio,nombreCliente y total.
 *
 * @author marle
 */
public class Pedido implements Comparable<Pedido>, Serializable{


    private String descripcion;
    private double cantidad;
    private double precio;

    /**
     * Constructor de la clase pedido 
     *
     * @param descripcion recibe como parametro un string
     * @param cantidad recibe como parametro un double
     * @param precio recibe como parametro un double
     */
    public Pedido(String descripcion, double cantidad, double precio) {
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.precio = precio;
    }
  
    /**
     * Método que retorna la descripcion
     *
     * @return retorna una descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Método que actualiza la descripcion
     *
     * @param descripcion recibe como parametro un string
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Método que retorna la cantidad
     *
     * @return retorna la cantidad
     */
    public double getCantidad() {
        return cantidad;
    }

    /**
     * Método que actualiza la cantidad
     *
     * @param cantidad recibe como parametro un double
     */
    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * Método que retorna un precio
     *
     * @return retorna un precio
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * Método que actualiza el precio
     *
     * @param precio recibe como parametro un double
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }


 

    /**
     * Método toString que se encargara de darle un formato al momento de querer
     * acceder a los atributos de clase, ya que si no realiza este metodo se
     * mostraran como una referencia
     *
     * @return retorna un String con el formato de los atributos de la clase
     * pedido
     */
 
    @Override
    public String toString() {
     return "Pedido{" + "descripcion=" + descripcion + ", cantidad=" + cantidad + ", precio=" + precio + '}';
    }

    @Override
    public int compareTo(Pedido o) {
        return Double.compare(this.precio, o.precio);
    }

}
