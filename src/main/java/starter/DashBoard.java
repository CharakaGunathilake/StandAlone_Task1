package starter;

import db.ThogakadePOS;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Customer;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class DashBoard {
    public void newForm(Stage stage){
        Scanner input = new Scanner(System.in);
        System.out.println("Dash Board\n");
        System.out.println("\t1. Add Customer");
        System.out.println("\t2. Search Customer");
        System.out.println("\t3. Update Customer");
        System.out.println("\t4. Delete Customer");
        System.out.println("\t5. View Customers");
        System.out.println("\t6. Exit\n");
        System.out.print("Select an Option -> ");
        int choice = input.nextInt();

        switch (choice) {
            case 1:
                System.out.println("Running Add Customer Form;");
                stage = ThogakadePOS.getInstance().getStage();
                try {
                    stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/add_customer_form.fxml"))));
                    stage.initStyle(StageStyle.UNDECORATED);
                    stage.show();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }catch (IllegalStateException ex){
                    stage.show();
                }
                break;
            case 2:
                System.out.println("Running Search Customer Form;");
                stage = ThogakadePOS.getInstance().getStage();
                try {
                    stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/search_customer_form.fxml"))));
                    stage.initStyle(StageStyle.UNDECORATED);
                    stage.show();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }catch (IllegalStateException ex){
                    stage.show();
                }
                break;
            case 3:
                System.out.println("Running Update Customer Form;");
                stage = ThogakadePOS.getInstance().getStage();
                try {
                    stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/update_customer_form.fxml"))));
                    stage.initStyle(StageStyle.UNDECORATED);
                    stage.show();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }catch (IllegalStateException ex){
                    stage.show();
                }
                break;
            case 4:
                System.out.println("Running Delete Customer Form;");
                stage = ThogakadePOS.getInstance().getStage();
                try {
                    stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/delete_customer_form.fxml"))));
                    stage.initStyle(StageStyle.UNDECORATED);
                    stage.show();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }catch (IllegalStateException ex){
                    stage.show();
                }
                break;
            case 5:
                showData();
                break;
            case 6:
                Platform.exit();
                break;
            default:
                System.out.println("Unexpected value: " + choice);
        }
    }

    private void showData() {
        Scanner input = new Scanner(System.in);
        try {
            List<Customer> customerList = ThogakadePOS.getInstance().getConnection();
            System.out.print("\n");
            if (!customerList.isEmpty()) {
                customerList.forEach(customer -> {
                    System.out.println("\t" + customer);
                });
            }else {
                System.out.println("No Data Added Yet!");
            }
        }catch(RuntimeException ex){
            System.out.println(ex.getMessage());
        }finally{
            System.out.print("\nReturn to DashBoard (Y/N) -> ");
            char letter = input.next().charAt(0);
            if(letter == 'y' || letter == 'Y'){
                newForm(new Stage());
            } else if (letter == 'n' || letter == 'N') {
                Platform.exit();
            }
        }
    }
}
