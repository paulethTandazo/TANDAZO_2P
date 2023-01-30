/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.pooespol.tandazopauleth.proyectotandazo;

import Local.Local;
import java.io.FileInputStream;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author marle
 */
public class LocalController implements Initializable {

    /**
     * Método initialize se invoca automáticamente cuando la vista está cargada
     * y se utiliza para inicializar los componentes y asignarles los valores o
     * eventos necesarios antes de que la vista sea mostrada al usuario
     *
     * @param url recibe un URl como parametro
     * @param rb recibe un ResourceBundle como parametro
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cargarPuntosMapa();

    }
    @FXML
    private Pane paneRoot;
    private Random rd = new Random();

    /**
     * El método "cargarPuntosMapa()" es un método que crea un hilo de ejecución
     * "Thread" y define una tarea (runnable) que realiza varias acciones en un
     * bucle. Para cada "Local" en la lista "App.listLocales", crea una nueva
     * vista de imagen (ImageView), establece un controlador de eventos de clic
     * de ratón en la vista de imagen para mostrar una ventana emergente (Stage)
     * con información sobre el local, y agrega la vista de imagen al contenedor
     * principal (paneRoot). La ventana emergente muestra nombre, dirección y
     * hora del local, así como un contador de tiempo que cierra la ventana
     * después de 5 segundos. La tarea del hilo espera un tiempo aleatorio antes
     * de procesar el siguiente local. La tarea de la ventana emergente también
     * se realiza en un hilo independiente.
     */
    public void cargarPuntosMapa() {

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {

                for (Local listLocal : App.listLocales) {
                    System.out.println(listLocal);
                    ImageView img = new ImageView();
                    img.setOnMouseClicked(e -> {
                        Stage s = new Stage();
                        Label lblNombre = new Label(listLocal.getNombre());
                        lblNombre.setFont(Font.font("SansSerif", FontWeight.BOLD, 1.0));
                        Label lblDireccion = new Label(listLocal.getDireccion());
                        System.out.println(listLocal.getDireccion());
                        lblDireccion.setFont(Font.font("SansSerif", FontWeight.BOLD, 12.0));
                        Label lblHora = new Label(listLocal.getHora());
                        lblHora.setFont(Font.font("SansSerif", FontWeight.BOLD, 12.0));
                        Label tiempoPantalla = new Label("Mostrando 5 segundos...");
                        tiempoPantalla.setFont(Font.font("SansSerif", FontWeight.BOLD, 12.0));
                        Button btnAceptar = new Button("Aceptar");
                        btnAceptar.setFont(Font.font("SansSerif", FontWeight.BOLD, 12.0));
                        btnAceptar.setOnMouseClicked(l -> {
                            s.close();
                        });
                        VBox contenedorRestaurante = new VBox();
                        contenedorRestaurante.setAlignment(Pos.CENTER);
                        contenedorRestaurante.setSpacing(20);
                        contenedorRestaurante.setStyle("-fx-background-color: #ed9700;");
                        HBox contenedorCierre = new HBox();
                        contenedorCierre.setSpacing(15);
                        contenedorCierre.getChildren().addAll(tiempoPantalla, btnAceptar);
                        contenedorCierre.setAlignment(Pos.CENTER);
                        Scene scene = new Scene(contenedorRestaurante, 250, 200);
                        s.setScene(scene);
                        s.initStyle(StageStyle.UNDECORATED);
                        s.show();
                        Thread t1 = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                for (int i = 5; i >= 0; i--) {
                                    int contador = i;
                                    Platform.runLater(() -> {
                                        tiempoPantalla.setText("Mostrando " + contador + " segundos...");
                                        if (contador == 0) {

                                            s.close();
                                        }

                                    });
                                    try {
                                        Thread.sleep(1000);
                                    } catch (InterruptedException ex) {
                                        ex.printStackTrace();
                                    }
                                }
                            }
                        });
                        contenedorRestaurante.getChildren().addAll(lblDireccion,lblNombre, lblHora, contenedorCierre);

                        t1.start();
                    });
                    try ( FileInputStream fb = new FileInputStream("src/main/resources/Imagenes/restaurantePin.png")) {
                        Image iv = new Image(fb);
                        img.setImage(iv);
                        img.setFitHeight(50);
                        img.setFitWidth(50);
                        img.setLayoutX(listLocal.getCoordenadaX());
                        img.setLayoutY(listLocal.getCoordenadaY());

                    } catch (Exception e) {
                        System.out.println("No hay imagen");
                    }
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            paneRoot.getChildren().add(img);
                        }

                    });

                    try {
                        Thread.sleep((rd.nextInt(10) + 1) * 1000);
                    } catch (InterruptedException ex) {
                        System.out.println(ex.getMessage());
                    }
                }
            }

        });
        t.start();
    }

}
