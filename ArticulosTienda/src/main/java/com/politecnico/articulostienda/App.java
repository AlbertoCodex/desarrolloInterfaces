package com.politecnico.articulostienda;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.net.URL;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;

/**
 * JavaFX App
 */
public class App extends Application {
    
    private ObservableList datosArticulo = FXCollections.observableArrayList();
    private Stage escenarioPrincipal;
    private BorderPane layoutPrincipal;
    private AnchorPane vistaArticulos;
    private AnchorPane editarArticulo;
    
    public App() {
        datosArticulo.add(new Articulo("CodigoTest", "DescipcionTest",
                "FabricanteTest", "CategoriaTest", 1234));
        datosArticulo.add(new Articulo("CodigoTest", "DescipcionTest",
                "FabricanteTest", "CategoriaTest", 1234));
    }
    
    
    
    @Override
    public void start(Stage escenarioPrincipal) {
        //Debo hacerlo para que luego me funcione en l carga de escenas
        this.escenarioPrincipal = escenarioPrincipal;
        //Establezco el título
        this.escenarioPrincipal.setTitle("Lista de articulos");
        //Inicializo el layout principal
        initLayoutPrincipal();
        //Muestro la vista persona
        muestraVistaArticulo();
    }
    
    public void initLayoutPrincipal(){
        //Cargo el layout principal a partir de la vista VistaPrincipal.fxml
        FXMLLoader loader = new FXMLLoader();
        URL location = App.class.getResource("secondary.fxml");
        loader.setLocation(location);
        try {
            layoutPrincipal = loader.load();
        } catch (IOException ex) {
           
        }
        //Cargo y muestro la escena que contiene ese layout principal
        Scene escena = new Scene(layoutPrincipal);
        escenarioPrincipal.setScene(escena);
        escenarioPrincipal.show();
    }
    
    public void muestraVistaArticulo(){
        //Cargo la vista persona a partir de primary.fxml
        FXMLLoader loader = new FXMLLoader();
        URL location = App.class.getResource("primary.fxml");
        loader.setLocation(location);
        try {
        vistaArticulos = loader.load();
        } catch (IOException ex) {
        }
        //Añado la vista al centro del layoutPrincipal
        layoutPrincipal.setCenter(vistaArticulos);
        
        //Doy acceso al controlador VistaPersonaCOntroller a LibretaDirecciones
        PrimaryController controller = loader.getController();
        controller.setApp(this);
    }
    
    //Vista editarPersona
    public boolean muestraEditarArticulo(Articulo articulo) {
        //Cargo la vista persona a partir de VistaPersona.fxml
        FXMLLoader loader = new FXMLLoader();
        URL location = App.class.getResource("EditarArticulo.fxml");
        loader.setLocation(location);
        try {
            editarArticulo = loader.load();
        } catch (IOException ex) {
            return false;
        }
        //Creo el escenario de edición (con modal) y establezco la escena
        Stage escenarioEdicion = new Stage();
        escenarioEdicion.setTitle("Editar Articulo");
        escenarioEdicion.initModality(Modality.WINDOW_MODAL);
        escenarioEdicion.initOwner(escenarioPrincipal);
        Scene escena = new Scene(editarArticulo);
        escenarioEdicion.setScene(escena);
        
        //Asigno el escenario de edición y el articulo seleccionado al controlador
        EditarArticuloController controller = loader.getController();
        controller.setEscenarioEdicion(escenarioEdicion);
        controller.setArticulo(articulo);
        //Muestro el diálogo hasta que el usuario lo cierre
        escenarioEdicion.showAndWait();
        //devuelvo el botón pulsado
        return controller.isGuardarClicked();
    }
    
    public Stage getPrimaryStage() {
        return escenarioPrincipal;
    }
    
    //Método main
    public static void main(String[] args) {
        launch(args);
    }
    
    public ObservableList getDatosArticulo() {
        return datosArticulo;
    }
}