/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.firstproject;

/**
 *
 * @author Lenovo
 */
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FirstProject extends Application {

    @Override
    public void start(Stage stage) {
        try {
            // Pastikan file homePage.fxml ada di src/view/homePage.fxml
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/homePage.fxml"));
            Parent root = loader.load();
            
            Scene scene = new Scene(root);
            stage.setTitle("Aplikasi Catatan Kesehatan Harian");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}