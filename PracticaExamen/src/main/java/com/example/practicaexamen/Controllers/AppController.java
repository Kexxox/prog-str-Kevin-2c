package com.example.practicaexamen.Controllers;

import com.example.practicaexamen.Contact.Contacto;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.util.ArrayList;

public class AppController {

    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtTelefono;
    @FXML
    private ComboBox<String> cmbParentesco;
    @FXML
    private ListView<Contacto> listView;
    @FXML
    private Label lblMsg;

    private ArrayList<Contacto> listaContactos = new ArrayList<>();

    private String[] opcionesParentesco = {"Padre", "Madre", "Hermano", "Hermana", "Abuelo", "Abuela", "Tío", "Tía"};

    @FXML
    public void initialize() {
        cmbParentesco.getItems().addAll(opcionesParentesco);
    }

    @FXML
    public void onAgregar() {
        if (!validarCampos()) return;

        String nombre = txtNombre.getText();

        if (buscarNombre(nombre) != null) {
            lblMsg.setText("Ya existe un contacto con ese nombre");
            lblMsg.setStyle("-fx-text-fill: red;");
            return;
        }

        Contacto nuevo = new Contacto(nombre, txtTelefono.getText(), cmbParentesco.getValue());
        listaContactos.add(nuevo);
        listView.getItems().clear();
        listView.getItems().addAll(listaContactos);
        onLimpiar();
        lblMsg.setText("Contacto agregado correctamente.");
        lblMsg.setStyle("-fx-text-fill: green;");
    }

    @FXML
    public void onBuscar() {
        String nombreABuscar = txtNombre.getText();
        Contacto encontrado = buscarNombre(nombreABuscar);

        if (encontrado != null) {
            txtNombre.setText(encontrado.getNombre());
            txtTelefono.setText(encontrado.getTelefono());
            cmbParentesco.setValue(encontrado.getParentesco());

            lblMsg.setText("Contacto encontrado.");
            lblMsg.setStyle("-fx-text-fill: green;");
        } else {
            lblMsg.setText("No se encontró el contacto.");
            lblMsg.setStyle("-fx-text-fill: red;");
        }
    }

    @FXML
    public void onActualizar() {
        if (!validarCampos()) return;

        String nombre = txtNombre.getText();
        Contacto contacto = buscarNombre(nombre);

        if (contacto != null) {
            contacto.setTelefono(txtTelefono.getText());
            contacto.setParentesco(cmbParentesco.getValue());
            listView.getItems().clear();
            listView.getItems().addAll(listaContactos);
            lblMsg.setText("Contacto actualizado correctamente.");
            lblMsg.setStyle("-fx-text-fill: green;");
        } else {
            lblMsg.setText("Busca un contacto primero para actualizarlo.");
            lblMsg.setStyle("-fx-text-fill: red;");
        }
    }

    @FXML
    public void onEliminar() {
        String nombre = txtNombre.getText();
        Contacto contacto = buscarNombre(nombre);

        if (contacto != null) {
            listaContactos.remove(contacto);
            listView.getItems().clear();
            listView.getItems().addAll(listaContactos);
            onLimpiar();
            lblMsg.setText("Contacto eliminado correctamente.");
            lblMsg.setStyle("-fx-text-fill: green;");
        } else {
            lblMsg.setText("No se encontró para eliminar.");
            lblMsg.setStyle("-fx-text-fill: red;");
        }
    }

    @FXML
    public void onLimpiar() {
        txtNombre.setText("");
        txtTelefono.setText("");
        cmbParentesco.setValue(null);
        lblMsg.setText("");
    }

    private Contacto buscarNombre(String nombre) {
        for (Contacto contactar : listaContactos) {
            if (contactar.getNombre().equalsIgnoreCase(nombre)) {
                return contactar;
            }
        }
        return null;
    }

    private boolean validarCampos() {
        if (txtNombre.getText().isEmpty()) {
            lblMsg.setText("El nombre no puede estar vacío.");
            lblMsg.setStyle("-fx-text-fill: red;");
            return false;
        }
        if (txtTelefono.getText().isEmpty() || txtTelefono.getText().length() != 10) {
            lblMsg.setText("El teléfono debe tener 10 dígitos.");
            lblMsg.setStyle("-fx-text-fill: red;");
            return false;
        }
        if (cmbParentesco.getValue() == null) {
            lblMsg.setText("Selecciona un parentesco.");
            lblMsg.setStyle("-fx-text-fill: red;");
            return false;
        }
        return true;
    }
}