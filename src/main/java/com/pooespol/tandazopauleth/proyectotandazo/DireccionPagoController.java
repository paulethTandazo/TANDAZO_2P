/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.pooespol.tandazopauleth.proyectotandazo;

import Pago.Pago;
import static com.pooespol.tandazopauleth.proyectotandazo.PedidoController.nuevopedido;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author marle
 */
public class DireccionPagoController implements Initializable {

    @FXML
    private TextField txtDireccion;

    @FXML
    private RadioButton rbEfectivo;
    @FXML
    private RadioButton rbTarjeta;
    @FXML
    private Button btnContinuar;
    @FXML
    private Button btnLimpiar;
    @FXML
    private VBox vboxPago;
    @FXML
    private HBox rootDireccion;
    @FXML
    private HBox rootBotones;
    @FXML
    private VBox rootCierre;
    public static Stage finalStage;
    public static double totalValueR = 0;
    ToggleGroup pagos = new ToggleGroup();

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

    }

    /**
     * Este método verifica que el contenedor que contiene el control
     * "txtDireccion" se haya llenando correctamente
     *
     * @return retorna una variable "estaLLeno" en estado true o false si es que
     * el control ha sido llenado o no ha sido llenado por el usuario
     */
    public boolean verificarContenedores() {
        boolean estaLleno = true;
        for (Node elemento : rootDireccion.getChildren()) {
            if (elemento instanceof TextField) {
                if (((TextField) elemento).getText().isEmpty()) {
                    estaLleno = false;
                    break;
                }
            }

        }
        return estaLleno;
    }

    /**
     * Método que se encarga de verificar si los radioButton han sido
     * seleccionados
     *
     * @return retorna una variable lleno en false o true dependiendo si el
     * radioButton ha sido seleccionado
     */
    public boolean verificarRaddioButton() {
        boolean lleno = false;
        for (Node elemento : rootBotones.getChildren()) {
            if (elemento instanceof RadioButton) {
                if (((RadioButton) elemento).isSelected()) {
                    lleno = true;
                    break;
                }

            }
        }
        return lleno;
    }

    /**
     * Método que se encarga de cargar los controls dentro de un contenedor en
     * el caso de que se seleccione el radioButton "rbTarjeta"
     *
     * @param e1 recibe como parametro un ActionEvent
     */
    @FXML
    public void PagarTarjeta(ActionEvent e1) {
        rbTarjeta.setToggleGroup(pagos);
        if (rbTarjeta.isSelected()) {
            vboxPago.getChildren().clear();
            HBox cas1 = new HBox();
            Label lblTitular = new Label("Titular:");
            lblTitular.setPrefWidth(152);
            TextField txtTitular = new TextField("");
            txtTitular.setPrefWidth(162);
            cas1.getChildren().addAll(lblTitular, txtTitular);
            HBox cas2 = new HBox();
            Label lblNumero = new Label("Número: ");
            lblNumero.setPrefWidth(152);
            TextField txtNumero = new TextField("");
            txtNumero.setPrefWidth(162);
            cas2.getChildren().addAll(lblNumero, txtNumero);
            HBox cas3 = new HBox();
            Label lblCaducidad = new Label("Caducidad: ");
            lblCaducidad.setPrefWidth(152);
            TextField txtCaducidad = new TextField("");
            txtCaducidad.setPrefWidth(162);
            cas3.getChildren().addAll(lblCaducidad, txtCaducidad);
            HBox cas4 = new HBox();
            Label lblCvv = new Label("CVV");
            lblCvv.setPrefWidth(152);
            TextField txtCvv = new TextField("");
            txtCvv.setPrefWidth(162);
            HBox cas5 = new HBox();
            totalValueR = Math.round(((PedidoController.totalValue * 0.05) + PedidoController.totalValue) * 100.0 / 100.0);
//            ((subtotalValue + ivaValue) * 100.0) / 100.0
            Label totalTarjeta = new Label("Tendrá que pagar un total de $ " + totalValueR + " dolares por el incremento del 5% por uso de su tarjeta");
            cas5.getChildren().add(totalTarjeta);
            cas4.getChildren().addAll(lblCvv, txtCvv);
            cas2.prefHeight(20);
            cas4.prefHeight(20);
            vboxPago.setSpacing(10);
            vboxPago.getChildren().addAll(cas1, cas2, cas3, cas4, cas5);

        }

    }

    /**
     * Método que se encarga de cargar los controls dentro de un contenedor al
     * momento de que se seleccione el radioButton "rbEfectivo"
     *
     * @param e2 recibe como parametro un ActionEvent
     */
    @FXML
    public void PagarEfectivo(ActionEvent e2) {
        rbEfectivo.setToggleGroup(pagos);
        if (rbEfectivo.isSelected()) {
            vboxPago.getChildren().clear();
            HBox cas1 = new HBox();
            totalValueR=PedidoController.totalValue;
            Label total = new Label("Tendrá que pagar un total de $ " +totalValueR);
            HBox cas2 = new HBox();
            Label descripcion = new Label("Asegurese de tener dinero completo por si el repartidor no tiene cambio");
            cas1.getChildren().add(total);
            cas2.getChildren().add(descripcion);
            vboxPago.setSpacing(10);
            vboxPago.getChildren().addAll(cas1, cas2);
        }

    }

    /**
     * Método que se encargara de limpiar el contenido de mi interfaz
     *
     * @param e3 recibe como parametro un ActionEvent
     */
    @FXML
    public void Limpiar(ActionEvent e3) {
        rbEfectivo.setSelected(false);
        rbTarjeta.setSelected(false);
        txtDireccion.setText("");
        txtDireccion.requestFocus();
        vboxPago.getChildren().clear();
    }

    /**
     * Método que se encarga de validar si es que los metodos
     * verificarContenedores() y verificarRaddioButton() han sido llenados y
     * seleccionados previamente caso contrario entra al else donde envirara una
     * Alerta de advertencia para el usuario llene los campos
     *
     * @param e4 recibe como parametro un Action Event
     * @throws IOException lanzando una excepcion de tipo Verificada
     */
    @FXML
    public void Continuar(ActionEvent e4) throws IOException {
        System.out.println("twasdfghhgfdsa");
        if (verificarContenedores() && verificarRaddioButton()) {
//  public Pago(String Idpago, String idpedido, Cliente nombreCLiente, double totalValue, Date fecha, tipoMenu tipo) {
            String tipo = null;
            if (pagos.getSelectedToggle() != null) {
                
                Toggle l = pagos.getSelectedToggle();
                if (l instanceof RadioButton) {
                    RadioButton rb = (RadioButton) l;
                    if (rb.getText().equals("Tarjeta de crédito")) {
                        tipo = "Tarjeta de crédito";
                    } else if (rb.getText().equals("Efectivo")) {
                        tipo= "Efectivo";
                    }
                }
            }
            System.out.println(tipo);
            System.out.println(PedidoController.crearID());
            System.out.println(PedidoController.nuevopedido);
            System.out.println(PedidoController.nuevopedido.getNombreCliente());
            System.out.println( PedidoController.totalValue);
            System.out.println(LocalDate.now());
            Pago nuevoPago = new Pago(PedidoController.crearID(), PedidoController.nuevopedido.getIDPedido(), PedidoController.nuevopedido.getNombreCliente(),totalValueR, LocalDate.now(), tipo);
            try ( BufferedWriter archivo = new BufferedWriter(new FileWriter("src/main/resources/Archivos/pagos.txt",true))) {
                archivo.write(nuevoPago.getIdpago()+","+nuevoPago.getIdpedido()+","+ nuevoPago.getNombreCLiente().getNombre()+","+nuevoPago.getTotalValue()+","+nuevoPago.getFecha()+"," + nuevoPago.getTipo());
            }catch (IOException ex) {
                        ex.printStackTrace();
             }

                Scene scene = null;
                Node source = (Node) e4.getSource();
                Stage stage = (Stage) source.getScene().getWindow();

                stage.close();
                finalStage = new Stage();
                FXMLLoader fxmlloader = new FXMLLoader(App.class.getResource("PantallaCieerre.fxml"));
                Parent root = fxmlloader.load();
                scene = new Scene(root, 600, 500);
                finalStage.setScene(scene);
                finalStage.setTitle("Pago");
                finalStage.show();
            }else {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Por favor, llene los campos");
                alert.showAndWait();
                txtDireccion.requestFocus();
            }

        }
    }
