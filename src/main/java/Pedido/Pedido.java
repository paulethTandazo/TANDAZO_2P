/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pedido;

import Cliente.Cliente;

/**
 *
 * @author marle
 */
public class Pedido {
    private String idPedido;
    private String descripcion;
    private double cantidad;
    private double precio;
    private Cliente nombreCliente;
    private double total;

    public Pedido(String idPedido, Cliente nombreCliente, double total) {
        this.idPedido = idPedido;
        this.nombreCliente = nombreCliente;
        this.total = total;
    }

    public Pedido(String descripcion, double cantidad, double precio) {
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Pedido{" + "idPedido=" + idPedido + ", descripcion=" + descripcion + ", cantidad=" + cantidad + ", precio=" + precio + ", nombreCliente=" + nombreCliente + ", total=" + total + '}';
    }

 
    
}
