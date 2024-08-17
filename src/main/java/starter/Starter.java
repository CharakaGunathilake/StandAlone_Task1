package starter;

import javafx.application.Application;
import javafx.stage.Stage;

import java.util.Scanner;

public class Starter extends Application{
    private DashBoard form = new DashBoard();
    public static void main(String[] args) {
        launch();
    }
    @Override
    public void start(Stage stage) throws Exception {
        form.newForm(stage);
    }

}
