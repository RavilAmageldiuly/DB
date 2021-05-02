package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.*;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setScene(new Scene(root, 1280, 800));
        primaryStage.show();
    }
    


//    public static void main(String[] args) {
//        String dbURL = "jdbc:oracle:thin:@localhost:1521:xe";
//        String username = "hr";
//        String password = "hr";
//        String SQL = "filter_procedure('Inception')";
//        try {
//            Connection connection = DriverManager.getConnection(dbURL,username,password);
//            System.out.println("Connected to Oracle database server");
//            Statement stmt=connection.createStatement();
//            ResultSet resultSet = stmt.executeQuery(SQL);
//            while (resultSet.next()){
//                String n = resultSet.getString(1) +" "+resultSet.getString(2)  ;
//                System.out.println(n);
//            }
//        } catch (SQLException e) {
//            System.out.println("Oops, error!");
//            e.printStackTrace();
//        }
//    }
}
