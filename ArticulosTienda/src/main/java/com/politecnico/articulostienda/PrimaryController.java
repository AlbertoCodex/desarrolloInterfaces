/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.politecnico.articulostienda;

import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import com.politecnico.articulostienda.Articulo;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author alberto
 */
public class PrimaryController {

    @FXML
    private TableView<?> tablaDatos;
    @FXML
    private TableColumn<?, ?> columnaCodigo;
    @FXML
    private TableColumn<?, ?> columnaDescripcion;
    @FXML
    private TableColumn<?, ?> columnaFabricante;
    @FXML
    private TableColumn<?, ?> columnaCategoria;
    @FXML
    private Button nuevoArticulo;
    @FXML
    private Button editarArticulo;
    @FXML
    private Button borrarArticulo;
    @FXML
    private Label codigoLabel;
    @FXML
    private Label descripcionLabel;
    @FXML
    private Label fabricanteLabel;
    @FXML
    private Label categoriaLabel;
    @FXML
    private Label precioLabel;
    // Referencia a la clase principal
    private App app;
    
    public PrimaryController() {}
    
    @FXML
    private void initialize() {
        String codigo = "Codigo";
        String descripcion = "Descripcion";
        String fabricante = "Fabricante";
        String categoria = "Categoria";
        columnaCodigo.setCellValueFactory(new PropertyValueFactory<>(codigo));
        columnaDescripcion.setCellValueFactory(new PropertyValueFactory<>(descripcion));
        columnaFabricante.setCellValueFactory(new PropertyValueFactory<>(fabricante));
        columnaCategoria.setCellValueFactory(new PropertyValueFactory<>(categoria));
        
        mostrarDetallesArticulo(null);
        tablaDatos.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> mostrarDetallesArticulo((Articulo) newValue));
    }  
    
    public void setApp(App app) {
        this.app = app;
        //Añado la lista obervable a la tabla
        tablaDatos.setItems(app.getDatosArticulo());
    }
    
    //Muestra los detalles del articulo seleccionado
    private void mostrarDetallesArticulo(Articulo articulo) {
        if (articulo != null) {
            //Relleno los labels desde el objeto persona
            codigoLabel.setText(articulo.getCodigo());
            descripcionLabel.setText(articulo.getDescripcion());
            fabricanteLabel.setText(articulo.getFabricante());
            categoriaLabel.setText(articulo.getCategoria());
            precioLabel.setText(Integer.toString(articulo.getPrecio()));
        } else {
            //Persona es null, vacío todos los labels.
            codigoLabel.setText("");
            descripcionLabel.setText("");
            fabricanteLabel.setText("");
            categoriaLabel.setText("");
            precioLabel.setText("");
        }
    }
    //Borro la persona seleccionada cuando el usuario hace clic en el botón de Borrar
    @FXML
    private void borrarPersona() {
        //Capturo el indice seleccionado y borro su item asociado de la tabla
        int indiceSeleccionado = tablaDatos.getSelectionModel().getSelectedIndex();
        if (indiceSeleccionado >= 0){
            //Borro item
            tablaDatos.getItems().remove(indiceSeleccionado);
        } else {
            //Muestro alerta
            Alert alerta = new Alert(AlertType.WARNING);
            alerta.setTitle("Atención");
            alerta.setHeaderText("Persona no seleccionada");
            alerta.setContentText("Por favor, selecciona una persona de la tabla");
            alerta.showAndWait();
        }
    }
    
    //Muestro el diálogo editar persona cuando el usuario hace clic en el botón de Crear
    @FXML
    private void crearPersona() {
        Articulo temporal = new Articulo();
        boolean guardarClicked = app.muestraEditarArticulo(temporal);
        if (guardarClicked) {
            app.getDatosArticulo().add(temporal);
        }
    }
    
    //Muestro el diálogo editar persona cuando el usuario hace clic en el botón de Editar
    @FXML
    private void editarPersona() {
        Articulo seleccionada = (Articulo) tablaDatos.getSelectionModel().getSelectedItem();
        if (seleccionada != null) {
            boolean guardarClicked = app.muestraEditarArticulo(seleccionada);
            if (guardarClicked) {
                mostrarDetallesArticulo(seleccionada);
            }
        } else {
        //Muestro alerta
        Alert alerta = new Alert(Alert.AlertType.WARNING);
        alerta.setTitle("Alerta");
        alerta.setHeaderText("Persona no seleccionada");
        alerta.setContentText("Por favor, selecciona una persona");
        alerta.showAndWait();
        }
    }
}
