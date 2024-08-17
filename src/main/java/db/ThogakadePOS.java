package db;

import javafx.stage.Stage;
import lombok.Getter;
import model.Customer;

import java.util.ArrayList;
import java.util.List;

@Getter
public class ThogakadePOS {
    private final Stage stage;
    private static ThogakadePOS instance;
    private final List<Customer> customerList;

    private ThogakadePOS(){
        customerList = new ArrayList<>();
        stage = new Stage();
    }
    public static ThogakadePOS getInstance(){
        if (instance == null) return instance = new ThogakadePOS();
        return instance;
    }

    public List<Customer> getConnection(){
        return customerList;
    }

}
