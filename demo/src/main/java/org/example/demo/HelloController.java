package org.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;

public class HelloController {

    static int contador = 0;
    @FXML
    private Label welcomeText;
    @FXML
    private Button contar;
    @FXML
    private Label etiqueta_contador;

    @FXML
    public void initialize(){

        Contador contador = new Contador();

        contar.setOnAction(e -> {
            contador.contar();
            System.out.println(contador.getContador());
            etiqueta_contador.setText(String.valueOf((contador.getContador())));
        });


    }
    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    public void IrAPantalla2() throws IOException {
        HelloApplication.setRoot("pantalla2");
    }
}