package org.example.demo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class RepositorioBocatas {
    private static final ObservableList<Bocata> bocatas = FXCollections.observableArrayList();

    public static ObservableList<Bocata> getBocatas(){
        return bocatas;
    }

    public static void insertarBocatas(Bocata bocata){
        bocatas.add(bocata);
    }
}
