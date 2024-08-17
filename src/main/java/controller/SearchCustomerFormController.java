package controller;

import com.jfoenix.controls.JFXTextField;
import db.ThogakadePOS;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import model.Customer;
import starter.DashBoard;
import starter.Starter;


public class SearchCustomerFormController {

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
            } else {
                Alert a = new Alert(Alert.AlertType.ERROR);
                a.setContentText("Invalid ID!");
                a.show();
                txtId.setText(null);
            }
        }
    }


    private void setDetails( Customer customer) {
        lblTitle.setText(customer.getTitle());
        lblName.setText(customer.getName());
        lblAddress.setText(customer.getAddress());
        lblContact.setText(customer.getContact());
        lblDob.setText(customer.getDateOfBirth());
    }

}
