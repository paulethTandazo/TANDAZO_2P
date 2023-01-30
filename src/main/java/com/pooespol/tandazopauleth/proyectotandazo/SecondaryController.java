package com.pooespol.tandazopauleth.proyectotandazo;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * Clase SecondaryController
 *
 * @author marle
 */
public class SecondaryController implements Initializable {

    @FXML
    private Label lblNombreUsuario;
    @FXML
    private Button btnPedido;
    @FXML
    private Button btnLocal;

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
        lblNombreUsuario.setText("Bienvenid@" + "  " + App.usuario.getNombre());
//        lblNombreUsuario.setTextFill(Color.WHITE);
    }

    /**
     * Método que se encargara de cambiar de vista cuando se presione en el
     * boton encontrarLocal
     *
     * @param event1 recibe como parametro un evento
     * @throws IOException lanza una excepcion verificada
     */
    @FXML
    public void encontrarLocal(ActionEvent event1) throws IOException {
        Stage s = new Stage();
        FXMLLoader fxmlloader = new FXMLLoader(App.class.getResource("Local.fxml"));
        Parent root = fxmlloader.load();
        Scene scene = new Scene(root, 1200, 600);
        s.setScene(scene);
        s.setTitle("Local");
        s.show();
        Node source = (Node) event1.getSource();     //Me devuelve el elemento al que hice click
        Stage stage = (Stage) source.getScene().getWindow();    //Me devuelve la ventana donde se encuentra el elemento
        stage.close();
    }

    /**
     * Metodo que se encarga de cambiar de vista cuando se presione el boton
     * realizarPedido
     *
     * @param event2 recibe como parametro un ActionEvent
     */
    @FXML
    public void realizarPedido(ActionEvent event2) {
        try {
            Node source = (Node) event2.getSource();     //Me devuelve el elemento al que hice click
            Stage stage = (Stage) source.getScene().getWindow();    //Me devuelve la ventana donde se encuentra el elemento
            stage.close();
            Stage s = new Stage();
            FXMLLoader fxmlloader = new FXMLLoader(App.class.getResource("Pedido.fxml"));
            Parent root = fxmlloader.load();
            Scene scene = new Scene(root, 800, 500);
            s.setScene(scene);
            s.setResizable(false);
            s.setTitle("Pedido");
            s.show();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
