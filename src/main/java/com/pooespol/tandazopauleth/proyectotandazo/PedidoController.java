/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.pooespol.tandazopauleth.proyectotandazo;

import Excecpcion.ValorInsuficienteException;
import Menu.Menu;
import Menu.tipoMenu;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
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
    private ComboBox<String> cbxOrdenar;
    @FXML
    private VBox vboxmenu;
    @FXML
    private Label descripcion;
    @FXML
    private Label precio;
    @FXML
    private TextField cantidad;
    @FXML
    private Button botonAgregar;
    @FXML
    private TableView tablaPedidos;
    @FXML
    private Button botonLimpiar;
    @FXML
    private Button botonContinuar;
    @FXML
    private Label subtotal;
    @FXML
    private Label iva;
    @FXML
    Label total;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        cbxTipo.getItems().add("Plato Fuerte");
        cbxTipo.getItems().add("Postre");
        cbxTipo.getItems().add("Bebida");
        cbxTipo.getItems().add("Piqueo");
        cbxTipo.addEventHandler(ActionEvent.ACTION, E -> {
            vboxmenu.getChildren().clear();
            vboxmenu.setSpacing(10);
            if (cbxTipo.getValue() != null) {

                switch (cbxTipo.getValue()) {
                    case "Plato Fuerte":

                        for (Menu menu : CrearMenu("F")) {
                            HBox cas1 = CrearHboxMenu(menu);
                            vboxmenu.getChildren().add(cas1);
                        }
                        break;
                    case "Postre":

                        for (Menu menu : CrearMenu("P")) {
                            HBox cas1 = CrearHboxMenu(menu);
                            vboxmenu.getChildren().add(cas1);
                        }
                        break;
                    case "Bebida":
                        for (Menu menu : CrearMenu("B")) {
                            HBox cas1 = CrearHboxMenu(menu);
                            vboxmenu.getChildren().add(cas1);

                        }
                        break;
                    case "Piqueo":
                        for (Menu menu : CrearMenu("Q")) {
                            HBox cas1 = CrearHboxMenu(menu);
                            vboxmenu.getChildren().add(cas1);
                        }
                        break;
                    default:
                        break;
                }
            } else {

            }
        });

//        botonAgregar.addEventHandler(ActionEvent.ACTION, E -> {
//
//            try {
//                if (Integer.parseInt(cantidad.getText()) <= 0) {
//                    throw new ValorInsuficienteException("Ingrese una cantidad válida");
//                } else {
//                    ObservableList<Pedido> pedidos = FXCollections.observableArrayList();
//                    Pedido pedido = new Pedido(descripcion.getText(), Double.parseDouble(cantidad.getText()), Double.parseDouble(precio.getText()));
//                    pedidos.add(pedido);
//                    tablaPedidos.setItems(pedidos);
//                }
//            } catch (ValorInsuficienteException e) {
//                e.getMessage();
//            }
//        });

    }

    private HBox CrearHboxMenu(Menu menu) {
        HBox cas1 = new HBox();
        descripcion = new Label(menu.getDescripcion());
        descripcion.setPrefWidth(152);
        precio = new Label(String.valueOf(menu.getPrecio()));
        precio.setPrefWidth(46);
        cantidad = new TextField("");
        cantidad.setPrefWidth(65);
        botonAgregar = new Button("Agregar");
        botonAgregar.setPrefWidth(62);
        cas1.getChildren().addAll(descripcion, precio, cantidad, botonAgregar);
        cas1.setSpacing(40);
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
    @FXML
    public void limpiar(ActionEvent event1) {
        cantidad.clear();
        subtotal.setText("0.00");
        iva.setText("0.00");
        total.setText("0.00");
        tablaPedidos.getItems().clear();
    }

    @FXML
    public void continuar(ActionEvent event2) {

    }
}
