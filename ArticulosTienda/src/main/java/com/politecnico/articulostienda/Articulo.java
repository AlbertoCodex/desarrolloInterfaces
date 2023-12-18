/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.politecnico.articulostienda;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author alberto
 */
public class Articulo {
    private final StringProperty codigo;
    private final StringProperty descripcion;
    private final StringProperty fabricante;
    private final StringProperty categoria;
    private final IntegerProperty precio;

    public Articulo() {
        this(null, null, null, null, null);
    }
    
    public Articulo(String codigo, String descripcion,String fabricante,String categoria, Integer precio) {
        this.codigo = new SimpleStringProperty(codigo);
        this.descripcion = new SimpleStringProperty(descripcion);
        this.fabricante = new SimpleStringProperty(fabricante);
        this.categoria = new SimpleStringProperty(categoria);
        this.precio = new SimpleIntegerProperty(precio);
    }

    public String getCodigo() {
        return codigo.get();
    }
    public void setCodigo(String codigo) {
        this.codigo.set(codigo);
    }
    public StringProperty codigoProperty() {
        return codigo;
    }
    public String getDescripcion() {
        return descripcion.get();
    }
    public void setDescripcion(String descripcion) {
        this.descripcion.set(descripcion);
    }
    public StringProperty descripcionProperty() {
        return descripcion;
    }
    public String getFabricante() {
        return fabricante.get();
    }
    public void setFabricante(String fabricante) {
        this.fabricante.set(fabricante);
    }
    public StringProperty fabricanteProperty() {
        return fabricante;
    }
    public String getCategoria() {
        return categoria.get();
    }
    public void setCategoria(String categoria) {
        this.categoria.set(categoria);
    }
    public StringProperty categoriaProperty() {
        return categoria;
    }
    public int getPrecio() {
        return precio.get();
    }
    public void setPrecio(int precio) {
        this.precio.set(precio);
    }
    public IntegerProperty precioProperty() {
        return precio;
    }
    
}
