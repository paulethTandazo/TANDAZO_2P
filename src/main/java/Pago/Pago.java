/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pago;

import Cliente.Cliente;
import Menu.tipoMenu;
import java.time.LocalDate;
import java.util.Date;

/**
 * clase del pago
 *
 * @author marle
 */
public class Pago {

    private String Idpago;
    private String idpedido;
    private Cliente nombreCLiente;
    private double totalValue;
    private LocalDate fecha;
    private String tipo;

    /**
     *
     * @param Idpago parametro del IDPAGO
     * @param idpedido parametro DEL IDPEDIDO
     * @param nombreCLiente parametro nombrecliente
     * @param totalValue parametro totalvalue
     * @param fecha parametro de la fecha
     * @param tipo parametro del tipo de pago
     */
    public Pago(String Idpago, String idpedido, Cliente nombreCLiente, double totalValue, LocalDate fecha, String tipo) {
        this.Idpago = Idpago;
        this.idpedido = idpedido;
        this.nombreCLiente = nombreCLiente;
        this.totalValue = totalValue;
        this.fecha = fecha;
        this.tipo = tipo;
    }

    /**
     * metodo que retorna un idpago
     *
     * @return retorna un idpago
     */
    public String getIdpago() {
        return Idpago;
    }

    /**
     * metodo que actualiza el idpago
     *
     * @param Idpago recibe como parametro un idpago
     */
    public void setIdpago(String Idpago) {
        this.Idpago = Idpago;
    }

    /**
     * metodo que retorna un idpedido
     *
     * @return retorna un idpedido
     */
    public String getIdpedido() {
        return idpedido;
    }

    /**
     * metodo que actualiza un idpedido
     *
     * @param idpedido parametro del idpedido
     */
    public void setIdpedido(String idpedido) {
        this.idpedido = idpedido;
    }

    /**
     * metodo que retorna un nombre cliente
     *
     * @return retorna un nombre cleinte
     */
    public Cliente getNombreCLiente() {
        return nombreCLiente;
    }

    /**
     * metodo que actualiza el nombre del cliente
     *
     * @param nombreCLiente recibe como parametro el nombre dle cliente
     */
    public void setNombreCLiente(Cliente nombreCLiente) {
        this.nombreCLiente = nombreCLiente;
    }

    /**
     * metodo que retorna el total
     *
     * @return retorna el total
     */
    public double getTotalValue() {
        return totalValue;
    }

    /**
     * metodo que actualiza el total
     *
     * @param totalValue parametro del total
     */
    public void setTotalValue(double totalValue) {
        this.totalValue = totalValue;
    }

    /**
     * metodo que retorna la fecha
     *
     * @return retorna la fecha
     */
    public LocalDate getFecha() {
        return fecha;
    }

    /**
     * metodo que actualiza la fecga
     *
     * @param fecha parametro de fecha
     */
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    /**
     * metodo que retorna el tipo
     *
     * @return retorna el tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * metodo que actualiza el tipo
     *
     * @param tipo parametro del tipo
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Método override de la clase pago
     *
     * @return el string con los datos
     */
    @Override
    public String toString() {
        return "Pago{" + "Idpago=" + Idpago + ", idpedido=" + idpedido + ", nombreCLiente=" + nombreCLiente + ", totalValue=" + totalValue + ", fecha=" + fecha + ", tipo=" + tipo + '}';
    }

}
