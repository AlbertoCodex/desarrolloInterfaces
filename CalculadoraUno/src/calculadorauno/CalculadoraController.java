/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package calculadorauno;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author Alberto
 */
public class CalculadoraController implements Initializable {

    @FXML
    private Label labPantalla;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void clic_siete(ActionEvent event) {
        digitoPantalla("7");
    }

    @FXML
    private void clic_ocho(ActionEvent event) {
        digitoPantalla("8");
    }

    @FXML
    private void clic_nueve(ActionEvent event) {
        digitoPantalla("9");
    }

    @FXML
    private void clic_neutro(ActionEvent event) {
        
    }

    @FXML
    private void clic_flecha(ActionEvent event) {
        
    }

    @FXML
    private void clic_cuatro(ActionEvent event) {
        digitoPantalla("4");
    }

    @FXML
    private void clic_cinco(ActionEvent event) {
        digitoPantalla("5");
    }

    @FXML
    private void clic_seis(ActionEvent event) {
        digitoPantalla("6");
    }

    @FXML
    private void clic_multiplicar(ActionEvent event) {
        
    }

    @FXML
    private void clic_dividir(ActionEvent event) {
        digitoPantalla("/");
    }

    @FXML
    private void clic_uno(ActionEvent event) {
        digitoPantalla("1");
    }

    @FXML
    private void clic_dos(ActionEvent event) {
        digitoPantalla("2");
    }

    @FXML
    private void clic_tres(ActionEvent event) {
        digitoPantalla("3");
    }

    @FXML
    private void clic_restar(ActionEvent event) {
        
    }

    @FXML
    private void clic_c(ActionEvent event) {
    }

    @FXML
    private void clic_cero(ActionEvent event) {
        digitoPantalla("0");
    }

    @FXML
    private void clic_punto(ActionEvent event) {
        if(!punto && !digito) {
            labPantalla.setText("0.");
            digito = true;
        } else if(!punto) {
            String valActual = labPantalla.getText();
            labPantalla.setText(valActual + ".");
        }
        punto = true;
    }

    @FXML
    private void clic_sumar(ActionEvent event) {
        
    }

    @FXML
    private void clic_igual(ActionEvent event) {
        
    }
    
    private boolean digito = false;
    private boolean punto = false;
    private int numOperandos = 0;
    private double operando1, operando2;
    private char operador = ' ';
    
    private void digitoPantalla(String numero) {
        if(!digito && numero.equals("0")) {return;}
        if(!digito){labPantalla.setText(""); punto = false;}
        String valActual = labPantalla.getText();
        labPantalla.setText(valActual + numero);
        digito = true;
    }
    
}
