package controller;

import com.jfoenix.controls.JFXTextField;
import db.ThogakadePOS;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.stage.Stage;
import model.Customer;
import starter.DashBoard;
import starter.Starter;

import java.util.List;

public class AddCustomerFormController {

    @FXML
    private DatePicker dtDatePicker;

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

    private final DashBoard form = new DashBoard();

    @FXML
    void btnDatePickerOnAction(ActionEvent event) {
        txtDob.setText("" + dtDatePicker.getValue());
    }

    @FXML
    void btnAddOnAction(ActionEvent event) {
        if (Validation.isValidID(txtId.getText())){
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("Id Already Exists!");
            a.show();
        }else {
            List<Customer> customerList = ThogakadePOS.getInstance().getConnection();
            customerList.add(new Customer(
                    txtId.getText(),
                    txtTitle.getText(),
                    txtName.getText(),
                    txtAddress.getText(),
                    txtContact.getText(),
                    txtDob.getText()
            ));
            clearTxt();
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setContentText("Customer Added Successfully");
            a.show();
        }
    }

    @FXML
    void btnClearOnAction(ActionEvent event) {
        clearTxt();
    }

    @FXML
    void btnExitOnAction(ActionEvent event) {
        Stage stage = ThogakadePOS.getInstance().getStage();
        stage.close();
        form.newForm(new Stage());
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
