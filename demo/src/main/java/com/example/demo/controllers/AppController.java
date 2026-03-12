package com.example.demo.controllers;

import com.example.demo.Services.PersonService;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.List;

public class AppController {
    @FXML
    private Label lblMsg;

    @FXML
    private ListView<String> listView;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtAge;

    private ObservableList<String> data = FXCollections.observableArrayList();
    PersonService service = new PersonService();

    @FXML
    public void initialize(){
        listView.setItems(data);
        loadFromFile();
    }

    @FXML
    public void onReload(){
        loadFromFile();
    }

    @FXML
    public void onAddPerson(){

        try {
            String name= txtNombre.getText();
            String email= txtEmail.getText();
            String age= txtAge.getText();

            service.addPerson(name,email, age);
            lblMsg.setText("Usuario Creado Correctamente");
            lblMsg.setStyle("-fx-text-fill: green");
            txtNombre.clear();
            txtEmail.clear();
            txtAge.clear();
            loadFromFile();

        } catch (IOException e) {
            lblMsg.setText("Error de archivo" +e.getMessage());
            lblMsg.setStyle("-fx-text-fill: red");

        } catch (Exception e) {
            lblMsg.setText("Error de datos"+ e.getMessage());
            lblMsg.setStyle("-fx-text-fill: red");

        }
    }

    private void loadFromFile(){
        try{
            List<String> items = service.loadForListView();
            data.setAll();
            lblMsg.setText("Datos cargados correctamente");
            lblMsg.setStyle("-fx-text-fill: green");
        } catch (IOException e) {
            lblMsg.setText("Error: " + e.getMessage());
            lblMsg.setStyle("-fx-text-fill: red");
        }
    }

}
