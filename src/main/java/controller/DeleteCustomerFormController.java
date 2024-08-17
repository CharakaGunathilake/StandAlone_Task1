package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import db.ThogakadePOS;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import model.Customer;
import starter.DashBoard;
import starter.Starter;

import java.awt.event.KeyEvent;
import java.util.List;

public class DeleteCustomerFormController {

    @FXML
    private Label lblAddress;

    @FXML
    private Label lblContact;

    @FXML
    private Label lblDob;

    @FXML
    private Label lblName;

    @FXML
    private Label lblTitle;

    @FXML
    private JFXTextField txtId;

    @FXML
    private JFXButton btnDelete;

    private final DashBoard form = new DashBoard();

    @FXML
    void btnCancelOnAction(ActionEvent event) {
        Stage stage = ThogakadePOS.getInstance().getStage();
        stage.close();
        form.newForm(new Stage());
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        List<Customer> customerList = ThogakadePOS.getInstance().getConnection();
        customerList.remove(Validation.getCustomer(txtId.getText()));
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setContentText("Customer Deleted Successfully!");
        a.show();
        clearTxt();
        btnDelete.setDisable(true);
    }

    @FXML
    void btnSearchOnAction(ActionEvent event) {
        String id  = txtId.getText();
        if (id != null) {
            if (Validation.isValidID(id)) {
                setDetails(Validation.getCustomer(txtId.getText()));
                btnDelete.setDisable(false);
                txtId.setEditable(false);
            } else {
                Alert a = new Alert(Alert.AlertType.ERROR);
                a.setContentText("Invalid ID!");
                a.show();
                txtId.setText(null);
            }
        }
    }
    private void setDetails(Customer customer) {
        lblTitle.setText(customer.getTitle());
        lblName.setText(customer.getName());
        lblAddress.setText(customer.getAddress());
        lblContact.setText(customer.getContact());
        lblDob.setText(customer.getDateOfBirth());
    }

    private void clearTxt() {
        txtId.setText(null);
        lblTitle.setText(null);
        lblName.setText(null);
        lblAddress.setText(null);
        lblContact.setText(null);
        lblDob.setText(null);
    }
}
