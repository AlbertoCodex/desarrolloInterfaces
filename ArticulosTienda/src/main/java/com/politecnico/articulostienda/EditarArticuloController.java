/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.politecnico.articulostienda;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author alberto
 */
public class EditarArticuloController {

    //TextField para los campos
    @FXML
    private TextField codigoTextField;
    @FXML
    private TextField descripcionTextField;
    @FXML
    private TextField fabricanteTextField;
    @FXML
    private TextField categoriaTextField;
    @FXML
    private TextField precioTextField;
    private Stage escenarioEdicion; //Escenario de edición
    private Articulo articulo; // Referencia a la clase persona
    private boolean guardarClicked = false;
    
    @FXML
    private void initialize() {
        // TODO
    }    
    
    public void setEscenarioEdicion(Stage escenarioEdicion) {
        this.escenarioEdicion = escenarioEdicion;
    }
    
    //Establece la persona a editar
    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
        codigoTextField.setText(articulo.getCodigo());
        descripcionTextField.setText(articulo.getDescripcion());
        fabricanteTextField.setText(articulo.getFabricante());
        categoriaTextField.setText(articulo.getCategoria());
        precioTextField.setText(Integer.toString(articulo.getPrecio()));
    }
    
    public boolean isGuardarClicked() {
        return guardarClicked;
    }
    
    //LLamado cuando se pulsa Guardar
    @FXML
    private void guardar() {
        if (datosValidos()) {
            //Asigno datos a propiedades de persona
            articulo.setCodigo(codigoTextField.getText());
            articulo.setDescripcion(descripcionTextField.getText());
            articulo.setFabricante(fabricanteTextField.getText());
            articulo.setCategoria(categoriaTextField.getText());
            articulo.setPrecio(Integer.parseInt(precioTextField.getText()));
            guardarClicked = true; //Cambio valor booleano
            escenarioEdicion.close(); //Cierro el escenario de edición
        }
    }
    
    //LLamado cuando se pulsa Cancelar
    @FXML
    private void cancelar() {
        escenarioEdicion.close();
    }
    
    //Validación de datos
    private boolean datosValidos(){
        //Inicializo string para mensajes
        String mensajeError = "";
        //Compruebo los campos
        if (codigoTextField.getText() == null || codigoTextField.getText().length() == 0) {
            mensajeError += "Codigo no válido.\n";
        }
        if (descripcionTextField.getText() == null || descripcionTextField.getText().length() == 0) {
            mensajeError += "Codigo no válido.\n";
        }
        if (fabricanteTextField.getText() == null || fabricanteTextField.getText().length() == 0) {
            mensajeError += "Fabricante no válido.\n";
        }
        if (categoriaTextField.getText() == null || categoriaTextField.getText().length() == 0) {
            mensajeError += "Categoria no válida.\n";
        }
        if (precioTextField.getText() == null || precioTextField.getText().length() == 0) {
            mensajeError += "Precio no válido.\n";
        } 
        //Si no hay errores devuelvo true, si no, una alerta con los errores y false
        if (mensajeError.length() == 0) {
            return true;
        } else {
            //Muestro alerta y devuelvo false
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Error");
            alerta.setHeaderText("Datos no válidos");
            alerta.setContentText("Por favor, corrige los errores");
            alerta.showAndWait();
            return false;
        }
    }
}
