package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Films {
//    String image;
    String title;
    String age_rating;
    int year;
    String genres;


    public Films(){

    }
    public Films( String title, String age_rating, int year, String genres) {
//        this.image = image;
        this.title = title;
        this.age_rating = age_rating;
        this.year = year;
        this.genres = genres;
    }


    ObservableList<Films>observableList;


    public  ObservableList<Films> getObservableList(String query) {
        observableList =FXCollections.observableArrayList();
        DatabaseConnection databaseConnection = new DatabaseConnection();
        ResultSet resultSet = null;
        try {
            resultSet = databaseConnection.getSet(query);
            if (resultSet.next()){
                while (resultSet.next()){
                    Films films = new Films(resultSet.getString("Title"),resultSet.getString("Age_rating"),Integer.parseInt(resultSet.getString("Year")) ,resultSet.getString("Genres"));
                    System.out.println(resultSet.getString("Title")+"  " +resultSet.getString("Age_rating")+" "+resultSet.getString("Year")+" "+resultSet.getString("Genres"));
                    observableList.add(films);
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return observableList;
    }



}
