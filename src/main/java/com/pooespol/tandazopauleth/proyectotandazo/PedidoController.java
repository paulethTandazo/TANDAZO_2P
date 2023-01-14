/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.pooespol.tandazopauleth.proyectotandazo;

import Menu.Menu;
import Menu.tipoMenu;
import static com.pooespol.tandazopauleth.proyectotandazo.App.crearListaMenu;
import static com.pooespol.tandazopauleth.proyectotandazo.App.listaMenu;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author marle
 */
public class PedidoController implements Initializable {

    /**
     * Initializes
     */
    @FXML
    private ComboBox<String> cbxTipo;
    @FXML
    private VBox vboxmenu;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        cbxTipo.getItems().add("Plato Fuerte");
        cbxTipo.getItems().add("Postre");
        cbxTipo.getItems().add("Bebida");
        cbxTipo.getItems().add("Piqueo");
        cbxTipo.addEventHandler(ActionEvent.ACTION, E -> {
            vboxmenu.getChildren().clear();
            if (cbxTipo.getValue() != null) {

                switch (cbxTipo.getValue()) {
                    case "Plato Fuerte":

                        for (Menu menu : CrearMenu("F")) {
                            GridPane cas1 = CrearHboxMenu(menu);
                            vboxmenu.getChildren().add(cas1);
                        }
                        break;
                    case "Postre":

                        for (Menu menu : CrearMenu("P")) {
                            GridPane cas1 = CrearHboxMenu(menu);
                            vboxmenu.getChildren().add(cas1);
                        }
                        break;
                    case "Bebida":
                        for (Menu menu : CrearMenu("B")) {
                            GridPane cas1 = CrearHboxMenu(menu);
                            vboxmenu.getChildren().add(cas1);
                        }
                        break;
                    case "Piqueo":
                        for (Menu menu : CrearMenu("Q")) {
                            GridPane cas1 = CrearHboxMenu(menu);
                            vboxmenu.getChildren().add(cas1);
                        }
                        break;
                    default:
                        break;
                }
            } else {

            }
        });
    }

    private GridPane CrearHboxMenu(Menu menu) {
        GridPane cas1 = new GridPane();
        Label descripcion = new Label(menu.getDescripcion());
        Label precio = new Label(String.valueOf(menu.getPrecio()));
        TextField cantidad = new TextField("");

        Button botonAgregar = new Button("Agregar");
        cas1.addRow(0, descripcion, precio, cantidad, botonAgregar);
        cas1.setAlignment(Pos.CENTER);

//        cas1.getChildren().addAll(descripcion, precio, cantidad, botonAgregar);
        return cas1;
    }

    private ArrayList<Menu> CrearMenu(String Tipo) {
        ArrayList<Menu> menuTipo = new ArrayList<>();
        for (Menu menu : App.listaMenu) {
            if (menu.getTipo().equals(tipoMenu.valueOf(Tipo))) {
                menuTipo.add(menu);
            }

        }
        return menuTipo;
    }

    //primero tengo que 
}
