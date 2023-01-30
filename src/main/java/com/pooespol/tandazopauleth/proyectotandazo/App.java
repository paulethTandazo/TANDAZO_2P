package com.pooespol.tandazopauleth.proyectotandazo;

import Cliente.Cliente;
import Local.Local;
import Menu.Menu;
import Menu.tipoMenu;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * CLase App
 *
 * @author marle
 */
public class App extends Application {

    private static Scene scene;
    public static Cliente usuario = null;
    public static ArrayList<Cliente> listaUsuarios = crearListaUsuario("src/main/resources/Archivos/Clientes.txt");
    public static ArrayList<Local> listLocales = crearListaLocales("src/main/resources/Archivos/locales.txt");
    public static ArrayList<Menu> listaMenu = crearListaMenu("src/main/resources/Archivos/menu.txt");

    /**
     * Método start que desencadena el ciclo de vida la Aplicación JavaFx
     *
     * @param s parametro de tipo Stage
     * @throws IOException lanza una IOException
     */
    @Override
    public void start(Stage s) throws IOException {
        FXMLLoader fxmlloader = new FXMLLoader(App.class.getResource("Principal.fxml"));
        Parent root = fxmlloader.load();
        scene = new Scene(root, 640, 400);
        s.setScene(scene);
        s.setTitle("Página de Inicio");
        s.show();
        System.out.println(listaUsuarios);
    }

    /**
     * Método que creara una lista de tipo usuarios
     *
     * @param archivo recibe como parametro un String
     * @return un arraylist de tipo cliente
     */
    public static ArrayList<Cliente> crearListaUsuario(String archivo) {
        ArrayList<String> lineas = new ArrayList<>();
        ArrayList<Cliente> clientes = new ArrayList<>();
        try ( BufferedReader br = new BufferedReader(new FileReader(archivo, StandardCharsets.UTF_8))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                lineas.add(linea);
            }
        } catch (FileNotFoundException e1) {
            System.out.println("No se encuentra el archivo");
        } catch (IOException e2) {
            System.out.println(e2.getMessage());
        }
        for (int i = 1; i < lineas.size(); i++) {
            String[] Listalineas = lineas.get(i).split(",");
            String username = Listalineas[0];
            String nombre = Listalineas[1];
            String password = Listalineas[2];
            clientes.add(new Cliente(username, nombre, password));
        }
        return clientes;
    }

    /**
     * Método que crea una lista de locales a partir de un archivo
     *
     * @param archivo recibe como parametro un tipo String
     * @return una lista de tipo local
     */
    public static ArrayList<Local> crearListaLocales(String archivo) {
        ArrayList<String> lineas = new ArrayList<>();
        ArrayList<Local> locales = new ArrayList<>();
        try ( BufferedReader br = new BufferedReader(new FileReader(archivo,StandardCharsets.UTF_8))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                lineas.add(linea);
            }
        } catch (FileNotFoundException e1) {
            System.out.println("No se encuentra el archivo");
        } catch (IOException e2) {
            System.out.println(e2.getMessage());
        }
        for (int i = 0; i < lineas.size(); i++) {
            String[] Listalineas = lineas.get(i).split(",");
           double coordenadaX = Double.parseDouble(Listalineas[0]);
            double coordenadaY = Double.parseDouble(Listalineas[1]);
            String direccion= Listalineas[2];
            String nombre= Listalineas[3];
            String hora = Listalineas[4];
            System.out.println(Listalineas[2]);
            
            locales.add(new Local(coordenadaX, coordenadaY,nombre, direccion, hora));
        }
        return locales;
    }

    /**
     * Metodo que crea una lista de tipo menu a partir de la lectura de un
     * archivo
     *
     * @param archivo recibe como parametro un tipo String
     * @return retorna una lista de tipo Menu
     */
    public static ArrayList<Menu> crearListaMenu(String archivo) {
        ArrayList<String> lineas = new ArrayList<>();
        ArrayList<Menu> menus = new ArrayList<>();
        try ( BufferedReader br = new BufferedReader(new FileReader(archivo, StandardCharsets.UTF_8))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                lineas.add(linea);
            }
        } catch (FileNotFoundException e1) {
            System.out.println("No se encuentra el archivo");
        } catch (IOException e2) {
            System.out.println(e2.getMessage());
        }
        for (int i = 1; i < lineas.size(); i++) {
            String[] Listalineas = lineas.get(i).split(",");
            String descrpcion = Listalineas[0];
            double precio = Double.parseDouble(Listalineas[1]);
            String tipo = Listalineas[2];
            menus.add(new Menu(descrpcion, precio, tipoMenu.valueOf(tipo)));
        }
        return menus;
    }

   /**
    * Metodo que carga una imagen a un imageview
    * @param rutaImagen ruta de la imagen
    * @return  retorna un Imageview
    */
    public static ImageView cargarImagenes(String rutaImagen)  {
        ImageView iv = new ImageView();
        try(FileInputStream fb= new FileInputStream(new File(rutaImagen))){
            Image image = new Image(fb);
            iv.setFitHeight(50);
            iv.setFitWidth(50);
            iv.setImage(image);
        } catch (FileNotFoundException e) {
            System.out.println("No se encontró la imagen: " + rutaImagen);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return iv;
    }
/**
 * Metodo que permite la ejecución de la vista principal
 * @param args parametros args
 */
    public static void main(String[] args) {
        launch();
    }
}
