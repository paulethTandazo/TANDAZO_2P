/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.pooespol.tandazopauleth.proyectotandazo;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author marle
 */
public class PantallaCieerreController implements Initializable {

    /**
     * Initializes the controller class.
     */
   @FXML
    private Label lblCierre;
   @FXML
   private Label lblOrdenMensaje;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lblOrdenMensaje.setText("Su pedido NRO "+PedidoController.nuevopedido.getIDPedido()+" ha sido pagado y ahora empezaremos a prepararlo.");
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 5; i >=0; i--) {
                    int contador = i;

                    Platform.runLater(new Runnable() {

                        @Override
                        public void run() {
                            if (contador ==0) {
                                DireccionPagoController.finalStage.close();
                            }
                            
                            lblCierre.setText("Cerrando en: " + contador + "....");

                        }

                    });
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        System.out.println(ex.getMessage());
                    } catch (NullPointerException e) {
                        System.out.println("excepcion: " + e.getMessage());
                    }
                }

            }
        });
        t.start();

    }

}
