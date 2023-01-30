package com.pooespol.tandazopauleth.proyectotandazo;

import Cliente.Cliente;
import static com.pooespol.tandazopauleth.proyectotandazo.App.listaUsuarios;
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
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
/**
 * Clase que contiene el controller de la ventana principal
 * @author marle
 */
public class PrincipalController implements Initializable {

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

    @FXML
    private Label lblMensajeUsuario;
    @FXML
    private TextField txtUsuario;
    @FXML
    private PasswordField txtContraseña;

    /**
     * Método que se encargara de carga la vista cada que se aplaste en el boton
     * Ingresar
     *
     * @param event recibe como parametro un ActionEvent
     * @throws IOException lanza una excepción verificada
     */
    @FXML
    public void Ingresar(ActionEvent event) throws IOException {

        App.usuario = verificarUsuario(txtUsuario.getText(), txtContraseña.getText());
        if (App.usuario != null) {
            Node source = (Node) event.getSource();     //Me devuelve el elemento al que hice click
            Stage stage = (Stage) source.getScene().getWindow();    //Me devuelve la ventana donde se encuentra el elemento
            stage.close();
            Stage s = new Stage();
            FXMLLoader fxmlloader = new FXMLLoader(App.class.getResource("Bienvenida.fxml"));
            Parent root = fxmlloader.load();
            Scene scene = new Scene(root, 640, 400);
            s.setScene(scene);
            s.setTitle("Página de Bienvenida");
            s.show();

            System.out.println(App.usuario.getUser());
        } else {
            txtUsuario.clear();
            txtContraseña.clear();
            txtUsuario.requestFocus();
            lblMensajeUsuario.setText("Usuario no encontrado");
        }

    }

    /**
     * Método estático que valida al usuario
     *
     * @param user recibe como parametro un String
     * @param password recibe como parametro un String
     * @return retorna un cliente
     */
    public static Cliente verificarUsuario(String user, String password) {
        for (Cliente usuario : listaUsuarios) {
            if (usuario.getUser().equals(user) && usuario.getPassword().equals(password)) {
                System.out.println(usuario);
                System.out.println("Usuario verificado");
                return usuario;
            }
        }
        System.out.println("No se encuentra el usuario, por favor vuelva a ingresar");
        System.out.println("");
        return null;
    }

}
