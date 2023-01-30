/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pedido;

import Cliente.Cliente;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author marle
 */
public class NuevoPedido implements Serializable {
    private ArrayList<Pedido> listaPedidos;
    private String IDPedido;
    private String direccion;
    private double iva;
    private double subtotal;
    private Cliente nombreCliente;
    private double total;
/**
 * COnstructor de la clase nuevo pedido
 * @param listaPedidos parametro de la lista pedidos
 * @param IDPedido parametro idpedido
 * @param direccion parametro de direccion
 * @param iva parametro del iva
 * @param subtotal parametro del subtotal
 * @param nombreCliente parametro del nombre cliente
 * @param total parametro total
 */
    public NuevoPedido(ArrayList<Pedido> listaPedidos, String IDPedido, String direccion, double iva, double subtotal, Cliente nombreCliente, double total) {
        this.listaPedidos = listaPedidos;
        this.IDPedido = IDPedido;
        this.direccion = direccion;
        this.iva = iva;
        this.subtotal = subtotal;
        this.nombreCliente = nombreCliente;
        this.total = total;
    }

/**
 * Metodo que retorna el id pedido
 * @return retorna id pedido
 */
    public String getIDPedido() {
        return IDPedido;
    }
/**
 * Metodo que actualiza el id pedido
 * @param IDPedido  parmaetro id pedido
 */
    public void setIDPedido(String IDPedido) {
        this.IDPedido = IDPedido;
    }
/**
 * Metodo que retorna el nombre del cliente
 * @return retorna nombre cliente
 */
    public Cliente getNombreCliente() {
        return nombreCliente;
    }
/**
 * metodo que actualiza el nombre del cliente
 * @param nombreCliente parametro nombre del cliente
 */
    public void setNombreCliente(Cliente nombreCliente) {
        this.nombreCliente = nombreCliente;
    }
/**
 * metodo que retorna el total 
 * @return retorna el total
 */
    public double getTotal() {
        return total;
    }
/**
 * metodo que actualiza el total
 * @param total parametro total
 */
    public void setTotal(double total) {
        this.total = total;
    }
/**
 * metodo que retorna un arraylist de los pedidos
 * @return retorna una lista pedidos
 */
    public ArrayList<Pedido> getListaPedidos() {
        return listaPedidos;
    }
/**
 * metodo que actualiza la lista de pedidos
 * @param listaPedidos retorna listapedidos
 */
    public void setListaPedidos(ArrayList<Pedido> listaPedidos) {
        this.listaPedidos = listaPedidos;
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
 * metodo que retorna el iva
 * @return retorna el iva
 */
    public double getIva() {
        return iva;
    }
/**
 * metodo que actualiza el iva
 * @param iva parametro del iva
 */
    public void setIva(double iva) {
        this.iva = iva;
    }
/**
 * metodo que retorna el subtotal
 * @return retorno el subtotal
 */
    public double getSubtotal() {
        return subtotal;
    }
/**
 * metodo que actualiza el subtotal
 * @param subtotal parametro el subtotal
 */
    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }
/**
 * Metodo toString de la clase nuevo pedido
 * @return retorna el formato con todos los atributos
 */
    @Override
    public String toString() {
        return "NuevoPedido{" + "listaPedidos=" + listaPedidos + ", IDPedido=" + IDPedido + ", direccion=" + direccion + ", iva=" + iva + ", subtotal=" + subtotal + ", nombreCliente=" + nombreCliente + ", total=" + total + '}';
    }


    
}
