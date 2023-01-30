/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.pooespol.tandazopauleth.proyectotandazo;

import Excecpcion.ValorInsuficienteException;
import Menu.Menu;
import Menu.tipoMenu;
import Pedido.NuevoPedido;
import Pedido.Pedido;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Set;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Clase que contiene los controllers que intervienen en la interfaz
 *
 * @author marle
 */
public class PedidoController implements Initializable, Serializable {

    @FXML
    private ComboBox<String> cbxTipo;
    @FXML
    private ComboBox<String> cbxOrdenar;
    @FXML
    private VBox vboxmenu;
    @FXML
    private Button botonLimpiar;
    @FXML
    private Button botonContinuar;
    @FXML
    private Label subtotal;
    @FXML
    private Label iva;
    @FXML
    private Label total;
    @FXML
    private VBox rootTabla;
    @FXML
    private VBox rootPedido;
    private static TableView<Pedido> tablaPedidos = new TableView<>();
    private static ArrayList<Pedido> listaPedidos = new ArrayList<>();
    private double subtotalValue = 0;
    private double ivaValue = 0;
    public static double totalValue = 0;
    public static NuevoPedido nuevopedido;

    /**
     * Método que se encarga de crear una tabla, donde definimos los valores de
     * las columnas y agregamos filas y todo esto se hace en root del grafo de
     * escena
     */
    private void llenarTabla() {

        TableColumn<Pedido, String> tcDescripcion = new TableColumn<>("Descrpcion");
        TableColumn<Pedido, String> tcCantidad = new TableColumn<>("Cantidad");
        TableColumn<Pedido, String> tcPrecio = new TableColumn<>("Precio");
        tcDescripcion.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDescripcion()));
        tcCantidad.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getCantidad())));
        tcPrecio.setCellValueFactory(cellData -> new SimpleStringProperty("$" + String.valueOf(cellData.getValue().getPrecio())));
        tcDescripcion.setPrefWidth(152);
        tcCantidad.setPrefWidth(75);
        tcPrecio.setPrefWidth(70);
        tablaPedidos.getColumns().addAll(tcDescripcion, tcCantidad, tcPrecio);

        rootTabla.getChildren().add(tablaPedidos);

    }

    /**
     * Metódo que se encarga de mostrar los pedidos dentro de la tabla pedidos
     * en la vista Pedido.fxml
     *
     * @param pedidos recibe como parametro de tipo pedido
     */
    private void mostrarPedido(Pedido pedidos) {
        tablaPedidos.getItems().add(pedidos);
        tablaPedidos.refresh();

    }

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
        // TODO
        llenarTabla();
        cbxOrdenar.getItems().add("Ordenar por precios");
        cbxOrdenar.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                String opcionElegida = cbxOrdenar.getValue();

                if ("Ordenar por precios".equals(opcionElegida)) {
                    Collections.sort(listaPedidos);
                }
            }
        });
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
        }
        );

    }

    /**
     * Método que encargara de crear un Hbox dentro de nuestra vista Pedido.fxml
     *
     * @param menu recine como parametro un tipo menu
     * @return un HBox
     */
    private HBox CrearHboxMenu(Menu menu) {
        HBox cas1 = new HBox();
        Label lbldescripcion = new Label(menu.getDescripcion());
        lbldescripcion.setPrefWidth(152);
        Label lblprecio = new Label(String.valueOf(menu.getPrecio()));
        lblprecio.setPrefWidth(46);
        TextField txtcantidad = new TextField("");
        txtcantidad.setPrefWidth(65);
        Button botonAgregar = new Button("Agregar");
        botonAgregar.addEventHandler(ActionEvent.ACTION, E -> {
            if (!(txtcantidad.getText().isBlank()) && Integer.parseInt(txtcantidad.getText()) > 0) {
                Pedido pedido = new Pedido(lbldescripcion.getText(), Integer.parseInt(txtcantidad.getText()), Double.parseDouble(lblprecio.getText()));
                mostrarPedido(pedido);
                CalcularPago();

            } else {
                try {

                    throw new ValorInsuficienteException("Ingresar una cantidad válida");

                } catch (ValorInsuficienteException ex) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Advertencia");
                    alert.setHeaderText("Ingrese una cantidad válida");
                    ButtonType buttonTypeOne = new ButtonType("Aceptar");

                    alert.getButtonTypes().setAll(buttonTypeOne);
                    alert.showAndWait();
                    txtcantidad.setText("");
                    txtcantidad.requestFocus();
                    System.out.println(ex.getMessage());
                }
            }

        });
        botonAgregar.setPrefWidth(62);
        cas1.getChildren().addAll(lbldescripcion, lblprecio, txtcantidad, botonAgregar);
        cas1.setSpacing(40);
//        cas1.getChildren().addAll(descripcion, precio, cantidad, botonAgregar);
        return cas1;
    }

    /**
     * Método que se encargada de calcular el pago a partir de los datos
     * ingresados por el tableView
     */
    private void CalcularPago() {
        Platform.runLater(() -> {
            for (Pedido pedido : tablaPedidos.getItems()) {
                subtotalValue += pedido.getPrecio() * pedido.getCantidad();
            }
            ivaValue = Math.round(subtotalValue * 0.12 * 100.0) / 100.0;
            totalValue = Math.round((subtotalValue + ivaValue) * 100.0) / 100.0;
            subtotal.setText("$" + String.valueOf(subtotalValue));
            iva.setText("$" + String.valueOf(ivaValue));
            total.setText("$" + String.valueOf(totalValue));

        });
    }

    /**
     * Método que retorna una lista de tipo menu y se encarga de crear un Menu a
     * partir de esta lista
     *
     * @param Tipo recibe como parametro un String
     * @return una lista de tipo menu
     */
    private ArrayList<Menu> CrearMenu(String Tipo) {
        ArrayList<Menu> menuTipo = new ArrayList<>();
        for (Menu menu : App.listaMenu) {
            if (menu.getTipo().equals(tipoMenu.valueOf(Tipo))) {
                menuTipo.add(menu);
            }

        }
        return menuTipo;
    }

    /**
     * Método que se encarga de limpiar todo lo del grafo de escena: Labels,
     * TableView, ComboBox
     *
     * @param event1 como parametro de un ActionEvent
     */
    @FXML
    public void limpiar(ActionEvent event1) {
        subtotal.setText("$0.00");
        iva.setText("$0.00");
        total.setText("$0.00");
        vboxmenu.getChildren().clear();
        tablaPedidos.getItems().clear();
        cbxTipo.getSelectionModel().clearSelection();
        cbxOrdenar.getSelectionModel().clearSelection();
    }

    /**
     * Método que se encarga de cambiar la escena siempre y cuando se aplazte el
     * Boton continuar
     *
     * @param event2 como parametro de un ActionEvent
     */
    private boolean rootPedidoEstaLleno() {
        boolean estaLleno = true;
        for (Node elemento : rootTabla.getChildren()) {
            if (elemento instanceof TableView) {
                if (((TableView) elemento).getItems().isEmpty()) {
                    estaLleno = false;
                    break;
                }
            }
        }
        return estaLleno;
    }
    private static Set<Integer> usedNumbers = new HashSet<>();
    private static Random random = new Random();

    /**
     * Método que genera aID aletorios
     *
     * @return retorna una string de numeros enteros
     */
    public static String crearID() {
        String cod = "";
        Random rd = new Random();
        for (int i = 0; i < 10; i++) {
            int numero = rd.nextInt(10);
            String num = String.valueOf(numero);
            cod += num;
        }
        return cod;
    }

    /**
     * Método que se encargara de cambiar de vista siempre y cuando el if
     * verifique que los datos de la tabla esten llenos caso contrario no se
     * cambiara de escena en su caso se mostrara un mensaje de alerta
     *
     * @param event2 recibe como parametro un ActionEvent
     * @throws IOException lanza una excepcion verificada
     */
    @FXML
    public void continuar(ActionEvent event2) throws IOException {
        System.out.println("twenty one");
        if (rootPedidoEstaLleno()) {
            System.out.println("ola 56");
            Scene scene = null;
            Node source = (Node) event2.getSource();     //Me devuelve el elemento al que hice click
            Stage stage = (Stage) source.getScene().getWindow();    //Me devuelve la ventana donde se encuentra el elemento
            stage.close();
            Stage s = new Stage();
            FXMLLoader fxmlloader = new FXMLLoader(App.class.getResource("DireccionPago.fxml"));
            Parent root = fxmlloader.load();
            scene = new Scene(root, 600, 500);
            s.setScene(scene);
            s.setTitle("Pago");
            s.show();
            ObservableList<Pedido> data = tablaPedidos.getItems();

            if (!data.isEmpty()) {
                ArrayList<Pedido> listaPedidos = new ArrayList<>(data);

                nuevopedido = new NuevoPedido(listaPedidos, crearID(), null, ivaValue, subtotalValue, App.usuario, totalValue);
                System.out.println(nuevopedido);
                try ( BufferedWriter bf = new BufferedWriter(new FileWriter("src/main/resources/Archivos/pedidos.txt",true))) {
                    bf.write(nuevopedido.getIDPedido() + "," + nuevopedido.getNombreCliente().getNombre() + "," + nuevopedido.getTotal());

                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                try ( ObjectOutputStream obj = new ObjectOutputStream(new FileOutputStream("pedido" + nuevopedido.getIDPedido() + ".bin"))) {
                    obj.writeObject(nuevopedido);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            } else {
                System.out.println("ola");
            }

        } else {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Por favor, complete su pedido");
            alert.showAndWait();
        }
    }
}
