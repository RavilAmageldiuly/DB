package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class Controller implements Initializable {


    @FXML
    private ImageView imageV_1;

    @FXML
    private Label labelName1;

    @FXML
    private Button viewMore1;

    @FXML
    private ImageView imageV_2;

    @FXML
    private Label labelName2;

    @FXML
    private Button viewMore2;

    @FXML
    private ImageView imageV_3;

    @FXML
    private Label labelName3;

    @FXML
    private Button viewMore3;

    @FXML
    private TextArea searchedText;







    String[][]links;
    int[] randomSan;
    ResultSet resultSet;

    String[]years = new String[]{};

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        ImageView[] imageViews = new ImageView[]{imageV_1,imageV_2,imageV_3};
        Label[]labels = new Label[]{labelName1,labelName2,labelName3};
        randomSan =new int[3];
        String link = null;
        String SQL = "SELECT * FROM sorted_movies Where  ";
        for (int i = 0; i <randomSan.length ; i++) {
            randomSan[i] =(int) (Math.random()*500)+1;
            if (i!=0){
                SQL+=" OR ID = "+ randomSan[i];
            }else{
                SQL+="ID = "+ randomSan[i];
            }
            System.out.println(randomSan[i]);
        }
        try {
            DatabaseConnection databaseConnection = new DatabaseConnection();
            ResultSet resultSet = databaseConnection.getSet(SQL);
//            this.resultSet = stmt.executeQuery(SQL);
            int i =0;
            links = new String[3][15];
            while (resultSet.next()){
                for (int j = 1; j <=14; j++) {
                    links[i][j] = resultSet.getString(j);
                }
                imageViews[i].setImage(new Image(links[i][12]));
                labels[i].setText(links[i][2]);
//                System.out.println(link);
                i++;
            }
        } catch (SQLException e) {
            System.out.println("Oops, error!");
            e.printStackTrace();
        }

    }
    public void viewMore1() throws IOException {
        viewMore(0);
    }
    public void viewMore2() throws IOException {
        viewMore(1);
    }
    public void viewMore3() throws IOException {
        viewMore(2);
    }
    public void viewMore(int a) throws IOException {
        Stage primaryStage = new Stage();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("film_info.fxml"));
        Parent root = fxmlLoader.load();

        SearchController searchController = fxmlLoader.getController();
        int i =0;
        searchController.setMovieName(links[a][2]);
        searchController.setMovieAge(links[a][5]);
        searchController.setMovieView(links[a][12]);
        searchController.setGenresInfo(links[a][8]);
        searchController.setDirectorInfo1(links[a][7]);
        searchController.setLanguageInfo1(links[a][10]);
        searchController.setYearInfo1(links[a][3]);
        searchController.setCountryInfo1(links[a][9]);
        searchController.setRuntimeInfo1(links[a][11]);
        System.out.println("123");
//            i++;



        primaryStage.setTitle("Receptionist");

        primaryStage.setScene(new Scene(root, 1280, 750));
        primaryStage.show();
//        SearchController searchController = new SearchController(randomSan[0]);
    }
    private int a =0;
    public void searcing() throws IOException, SQLException {
        int a =0;
        String searching = searchedText.getText();
        String SQL = "SELECT * FROM sorted_movies Where title LIKE  '%"+searching+"%'";
        String[][] info = new String[1][15];
        ResultSet resultSet = null;
        try {
            DatabaseConnection databaseConnection = new DatabaseConnection();
            resultSet = databaseConnection.getSet(SQL);
        } catch (SQLException e) {
            System.out.println("Oops, error!");
            e.printStackTrace();
        }

            while (resultSet.next()){
                for (int i = 1; i <=14 ; i++) {
                    info[0][i] = resultSet.getString(i);
                }
                if (this.a==a){
                    this.a++;
                    break;
                }
                a++;
            }


        if (info[0][1]==null){
            return;
        }

        Stage primaryStage = new Stage();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("film_info.fxml"));
        Parent root = fxmlLoader.load();

        SearchController searchController = fxmlLoader.getController();

        searchController.setMovieName(info[0][2]);
        searchController.setMovieAge(info[0][5]);
        searchController.setMovieView(info[0][12]);
        searchController.setGenresInfo(info[0][8]);
        searchController.setDirectorInfo1(info[0][7]);
        searchController.setLanguageInfo1(info[0][10]);
        searchController.setYearInfo1(info[0][3]);
        searchController.setCountryInfo1(info[0][9]);
        searchController.setRuntimeInfo1(info[0][11]);
        System.out.println("123");

        primaryStage.setTitle("Receptionist");

        primaryStage.setScene(new Scene(root, 1280, 750));
        primaryStage.show();


    }

    public void yearFilter(){


    }





}
