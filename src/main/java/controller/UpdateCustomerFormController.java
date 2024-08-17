package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import db.ThogakadePOS;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import model.Customer;
import starter.DashBoard;
import starter.Starter;

import java.awt.event.KeyEvent;
import java.util.List;

public class UpdateCustomerFormController {

    @FXML
    private JFXTextField txtAddress;

    @FXML
    private JFXTextField txtContact;

    @FXML
    private JFXTextField txtDob;

    @FXML
    private JFXTextField txtId;

    @FXML
    private JFXTextField txtName;

    @FXML
    private JFXTextField txtTitle;

    @FXML
    private JFXButton btnUpdate;

    private final DashBoard form = new DashBoard();

    @FXML
    void btnCancelOnAction(ActionEvent event) {
        Stage stage = ThogakadePOS.getInstance().getStage();
        stage.close();
        form.newForm(new Stage());
    }

    @FXML
    void btnSearchOnAction(ActionEvent event) {
        String id  = txtId.getText();
        if (id != null) {
            if (Validation.isValidID(id)) {
                setDetails(Validation.getCustomer(txtId.getText()));
                txtId.setEditable(false);
                btnUpdate.setDisable(false);
            } else {
                Alert a = new Alert(Alert.AlertType.ERROR);
                a.setContentText("Invalid ID!");
                a.show();
                txtId.setText(null);
            }
        }
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        List<Customer> customerList = ThogakadePOS.getInstance().getConnection();
        Customer set = new Customer(
                txtId.getText(),
                txtTitle.getText(),
                txtName.getText(),
                txtAddress.getText(),
                txtContact.getText(),
                txtDob.getText()
        );
        customerList.set(customerList.indexOf(Validation.getCustomer(txtId.getText())),set);
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setContentText("Customer Details Updated Successfully!");
        a.show();
        clearTxt();
        txtId.setEditable(true);
        btnUpdate.setDisable(true);
    }
    private void setDetails( Customer customer) {
        txtTitle.setText(customer.getTitle());
        txtName.setText(customer.getName());
        txtAddress.setText(customer.getAddress());
        txtContact.setText(customer.getContact());
        txtDob.setText(customer.getDateOfBirth());
    }

    private void clearTxt() {
        txtId.setText(null);
        txtTitle.setText(null);
        txtName.setText(null);
        txtAddress.setText(null);
        txtContact.setText(null);
        txtDob.setText(null);
    }
}
