package org.example.demo;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.io.IO;
import java.io.IOException;

public class Pantalla2Controller {

    @FXML
    private TextField NombreTextField;
    @FXML
    private TextField PrecioTextField;
    @FXML
    private TableColumn<Bocata, String> nombreTableColumn;
    @FXML
    private TableColumn<Bocata, Double> precioTableColumn;
    @FXML
    private TableView<Bocata> tablaBocatas;

    private ObservableList<Bocata> listaBocatas = FXCollections.observableArrayList();


    @FXML
    public void initialize(){

        nombreTableColumn.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getNombre()));
        precioTableColumn.setCellValueFactory(data -> new javafx.beans.property.SimpleObjectProperty<>(data.getValue().getPrecio()));

        tablaBocatas.setItems(RepositorioBocatas.getBocatas());
    }

    @FXML
    public void IrAPantalla1() throws IOException {
        HelloApplication.setRoot("hello-view");
    }

    @FXML
    public void guardarBocata() throws IOException {
        String nombre = NombreTextField.getText();

        double precio;

        try {
            precio = Double.parseDouble(PrecioTextField.getText());
        }catch (NumberFormatException e){
            System.out.println("Precio inválido");
            PrecioTextField.clear();
            return;
        }

        Bocata bocata = new Bocata(nombre,precio);

        RepositorioBocatas.insertarBocatas(bocata);

        System.out.println("Bocadillo creado: "+ bocata.getNombre() +"con precio: "+bocata.getPrecio()+"€");

        NombreTextField.clear();
        PrecioTextField.clear();
    }
}
