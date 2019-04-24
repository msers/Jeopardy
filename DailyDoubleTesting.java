

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.BorderPane;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;

import javax.swing.*;

//SQL imports
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class DailyDoubleTesting extends Application

   {
      //////////////////
      
      // Variable Declaration. 
      
      //////////////////
      
      public static void main(String[] args)
      
         {
         
            launch(args);  //  Launches the application.
         }
      
      public void start(Stage window) throws Exception
      
         {
         
               Label dailyDoubleScene2Label = new Label("How much would you like to wager? \nAll wagers must be positive whole numbers \nequal to or less than your current total.");
               
               Label dailyDoubleWagerLabel = new Label("This is the Daily Double Wager Label. This will change when running properly.");
               
               Button dailyDoubleWager1 = new Button ("   1   ");
               
               Button dailyDoubleWager2 = new Button ("   2   ");
               
               Button dailyDoubleWager3 = new Button ("   3   ");
               
               Button dailyDoubleWager4 = new Button ("   4   ");
               
               Button dailyDoubleWager5 = new Button ("   5   ");
               
               Button dailyDoubleWager6 = new Button ("   6   ");
               
               Button dailyDoubleWager7 = new Button ("   7   ");
               
               Button dailyDoubleWager8 = new Button ("   8   ");
               
               Button dailyDoubleWager9 = new Button ("   9   ");
               
               Button dailyDoubleWager0 = new Button ("   0   ");
               
               Button dailyDoubleWagerEnterButton = new Button("Enter");
               
               Button dailyDoubleWagerClearButton = new Button("Clear");
               
               GridPane dailyDoubleWagerGridPane = new GridPane();
               
               dailyDoubleWagerGridPane.add(dailyDoubleWager1, 0, 0);
               
               dailyDoubleWagerGridPane.add(dailyDoubleWager2, 1, 0);
               
               dailyDoubleWagerGridPane.add(dailyDoubleWager3, 2, 0);
               
               dailyDoubleWagerGridPane.add(dailyDoubleWager4, 0, 1);
               
               dailyDoubleWagerGridPane.add(dailyDoubleWager5, 1, 1);
               
               dailyDoubleWagerGridPane.add(dailyDoubleWager6, 2, 1);
               
               dailyDoubleWagerGridPane.add(dailyDoubleWager7, 0, 2);
               
               dailyDoubleWagerGridPane.add(dailyDoubleWager8, 1, 2);
               
               dailyDoubleWagerGridPane.add(dailyDoubleWager9, 2, 2);
               
               dailyDoubleWagerGridPane.add(dailyDoubleWagerClearButton, 0, 3);
               
               dailyDoubleWagerGridPane.add(dailyDoubleWager0, 1, 3);
               
               dailyDoubleWagerGridPane.add(dailyDoubleWagerEnterButton, 2, 3); 
               
               VBox dailyDoubleScene2VBox = new VBox(dailyDoubleScene2Label, dailyDoubleWagerLabel, dailyDoubleWagerGridPane); 
               
               BorderPane dailyDoubleScene2BorderPane = new BorderPane();
               
               dailyDoubleScene2BorderPane.setCenter(dailyDoubleScene2VBox);
               
               Scene dailyDoubleScene2 = new Scene(dailyDoubleScene2BorderPane, 1280, 720);
               
               window.setScene(dailyDoubleScene2);
                     
               window.setTitle("Jeopardy!");
                     
               window.show();
         
         }
         
    }