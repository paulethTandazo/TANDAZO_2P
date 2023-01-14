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

public class SecondaryController implements Initializable {

    @FXML
    private Label lblNombreUsuario;
    @FXML
    private Button btnPedido;
    @FXML
    private Button btnLocal;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lblNombreUsuario.setText("Bienvenid@" + "  " + App.usuario.getNombre());
//        lblNombreUsuario.setTextFill(Color.WHITE);
    }

    @FXML
    public void encontrarLocal(ActionEvent event1) throws IOException {
        Stage s = new Stage();
        FXMLLoader fxmlloader = new FXMLLoader(App.class.getResource("Local.fxml"));
        Parent root = fxmlloader.load();
        Scene scene = new Scene(root, 640, 400);
        s.setScene(scene);
        s.setTitle("Local");
        s.show();
        Node source = (Node) event1.getSource();     //Me devuelve el elemento al que hice click
        Stage stage = (Stage) source.getScene().getWindow();    //Me devuelve la ventana donde se encuentra el elemento
        stage.close();
    }

    @FXML
    public void realizarPedido(ActionEvent event2) throws IOException {
        Node source = (Node) event2.getSource();     //Me devuelve el elemento al que hice click
        Stage stage = (Stage) source.getScene().getWindow();    //Me devuelve la ventana donde se encuentra el elemento
        stage.close();
        Stage s = new Stage();
        FXMLLoader fxmlloader = new FXMLLoader(App.class.getResource("Pedido.fxml"));
        Parent root = fxmlloader.load();
        Scene scene = new Scene(root, 700, 560);
        s.setScene(scene);
        s.setTitle("Pedido");
        s.show();
    }
}
