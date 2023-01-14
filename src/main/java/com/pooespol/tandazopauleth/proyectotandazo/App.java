package com.pooespol.tandazopauleth.proyectotandazo;

import Cliente.Cliente;
import Local.Local;
import Menu.Menu;
import Menu.tipoMenu;
import java.io.BufferedReader;
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

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    public static Cliente usuario = null;
    public static ArrayList<Cliente> listaUsuarios = crearListaUsuario("src/main/resources/Archivos/Clientes.txt");
    public static ArrayList<Local> listLocales= crearListaLocales("src/main/resources/Archivos/locales.txt");
    public static ArrayList<Menu> listaMenu=crearListaMenu("src/main/resources/Archivos/menu.txt");
    public void start(Stage s) throws IOException {
        FXMLLoader fxmlloader = new FXMLLoader(App.class.getResource("Principal.fxml"));
        Parent root = fxmlloader.load();
        scene = new Scene(root, 640, 400);
        s.setScene(scene);
        s.setTitle("Página de Inicio");
        s.show();
        System.out.println(listaUsuarios);
    }

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
            String nombre= Listalineas[1];
            String password = Listalineas[2];
            clientes.add(new Cliente(username,nombre, password));
        }
        return clientes;
    }
       public static ArrayList<Local> crearListaLocales(String archivo) {
        ArrayList<String> lineas = new ArrayList<>();
        ArrayList<Local> locales = new ArrayList<>();
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
            String coordenadaX = Listalineas[0];
            String coordenadaY= Listalineas[1];
            String direccion = Listalineas[2];
            locales.add(new Local(direccion,coordenadaX,coordenadaY));
        }
        return locales;
    }
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
            double precio= Double.parseDouble(Listalineas[1]);
            String tipo = Listalineas[2];
            menus.add(new Menu(descrpcion,precio,tipoMenu.valueOf(tipo)));
        }
        return menus;
    }
    public static void main(String[] args) {
        launch();
    }
}
