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


public class JeopardyTesting2 extends Application

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
      
            
            
            ////////////////// Beginning of Gameboard Button Creation
            
               // Category A
            
                  Button categoryAInfo = new Button("aInfo"); 
                  
                  Button categoryA100 = new Button("a$100");
                  
                  Button categoryA200 = new Button("a$200");
                  
                  Button categoryA300 = new Button("a$300");
                  
                  Button categoryA400 = new Button("a$400");
                  
                  Button categoryA500 = new Button("a$500");
                  
               
               // Category B
               
                  Button categoryBInfo = new Button("bInfo"); 
                  
                  Button categoryB100 = new Button("b$100");
                  
                  Button categoryB200 = new Button("b$200");
                  
                  Button categoryB300 = new Button("b$300");
                  
                  Button categoryB400 = new Button("b$400");
                  
                  Button categoryB500 = new Button("b$500");
               
                           
               
               // Category C
               
                  Button categoryCInfo = new Button("cInfo"); 
                  
                  Button categoryC100 = new Button("c$100");
                  
                  Button categoryC200 = new Button("c$200");
                  
                  Button categoryC300 = new Button("c$300");
                  
                  Button categoryC400 = new Button("c$400");
                  
                  Button categoryC500 = new Button("c$500");
               
                           
               // Category D
               
                  Button categoryDInfo = new Button("dInfo"); 
                  
                  Button categoryD100 = new Button("d$100");
                  
                  Button categoryD200 = new Button("d$200");
                  
                  Button categoryD300 = new Button("d$300");
                  
                  Button categoryD400 = new Button("d$400");
                  
                  Button categoryD500 = new Button("d$500");
               
                          
               // Category E 
               
                  Button categoryEInfo = new Button("eInfo"); 
                  
                  Button categoryE100 = new Button("e$100");
                  
                  Button categoryE200 = new Button("e$200");
                  
                  Button categoryE300 = new Button("e$300");
                  
                  Button categoryE400 = new Button("e$400");
                  
                  Button categoryE500 = new Button("e$500");
                  
                           
               // Category F
               
                  Button categoryFInfo = new Button("fInfo"); 
                  
                  Button categoryF100 = new Button("f$100");
                  
                  Button categoryF200 = new Button("f$200");
                  
                  Button categoryF300 = new Button("f$300");
                  
                  Button categoryF400 = new Button("f$400");
                  
                  Button categoryF500 = new Button("f$500");
            
            
            ////////////////// End of Gameboard Button Creation
            
            ///
            
            ////////////////// Start of Gameboard Setup
            
            
               GridPane gameboard = new GridPane();
               
               gameboard.setAlignment(Pos.CENTER);
               
               gameboard.setHgap(15);
               
               gameboard.setVgap(10);
               
               gameboard.setPadding(new Insets(10));
               
                  //////////////////   Start of adding Gameboard Buttons to the Gameboard Gridpane
                  
                     /////////   Category A Buttons
                  
                        gameboard.add(categoryAInfo, 0, 0);
                        
                        gameboard.add(categoryA100, 0, 1);
                        
                        gameboard.add(categoryA200, 0, 2);
                        
                        gameboard.add(categoryA300, 0, 3);
                        
                        gameboard.add(categoryA400, 0, 4);
                        
                        gameboard.add(categoryA500, 0, 5);
                     
                     /////////   Category B Buttons
                     
                        gameboard.add(categoryBInfo, 1, 0);
                        
                        gameboard.add(categoryB100, 1, 1);
                        
                        gameboard.add(categoryB200, 1, 2);
                        
                        gameboard.add(categoryB300, 1, 3);
                        
                        gameboard.add(categoryB400, 1, 4);
                        
                        gameboard.add(categoryB500, 1, 5);
                     
                     /////////   Category C Buttons
                     
                        gameboard.add(categoryCInfo, 2, 0);
                        
                        gameboard.add(categoryC100, 2, 1);
                        
                        gameboard.add(categoryC200, 2, 2);
                        
                        gameboard.add(categoryC300, 2, 3);
                        
                        gameboard.add(categoryC400, 2, 4);
                        
                        gameboard.add(categoryC500, 2, 5);
                     
                     /////////   Category D Buttons
                     
                        gameboard.add(categoryDInfo, 3, 0);
                        
                        gameboard.add(categoryD100, 3, 1);
                        
                        gameboard.add(categoryD200, 3, 2);
                        
                        gameboard.add(categoryD300, 3, 3);
                        
                        gameboard.add(categoryD400, 3, 4);
                        
                        gameboard.add(categoryD500, 3, 5);
                     
                     /////////   Category E Buttons
                     
                        gameboard.add(categoryEInfo, 4, 0);
                        
                        gameboard.add(categoryE100, 4, 1);
                        
                        gameboard.add(categoryE200, 4, 2);
                        
                        gameboard.add(categoryE300, 4, 3);
                        
                        gameboard.add(categoryE400, 4, 4);
                        
                        gameboard.add(categoryE500, 4, 5);
                     
                     /////////   Category F Buttons
                     
                        gameboard.add(categoryFInfo, 5, 0);
                        
                        gameboard.add(categoryF100, 5, 1);
                        
                        gameboard.add(categoryF200, 5, 2);
                        
                        gameboard.add(categoryF300, 5, 3);
                        
                        gameboard.add(categoryF400, 5, 4);
                        
                        gameboard.add(categoryF500, 5, 5);
                        
                     /////////   Adding gameboard to gameboardBorderPane
                     
                        BorderPane gameboardBorderPane = new BorderPane();
               
                        gameboardBorderPane.setCenter(gameboard);
               
               //////////////////   End of adding Gameboard Buttons to the Gameboard Gridpane
               
               /////////
               
               //////////////////   Start of Scene Creation
                  
                  /////////   Main Gameboard Scene
            
                     Scene gameboardScene = new Scene(gameboardBorderPane, 1280, 720);  // scene for the gameboard
                     
                     window.setScene(gameboardScene);
                     
                     window.setTitle("Jeopardy!");
                     
                     window.show();
                     
                  /////////   Category Info Scene
                  
                     BorderPane categoryInfoBorderPane = new BorderPane();
                     
                     Button categoryBack = new Button ("Back");            
            
                     Label categoryText = new Label("If you are seeing this either the getText method isn't being used or this is still being tested.");
            
                     categoryInfoBorderPane.setCenter(categoryText);
                     
                     categoryInfoBorderPane.setLeft(categoryBack);
                                 
                     Scene categoryInfoScene = new Scene(categoryInfoBorderPane, 1280, 720);
                  
                  /////////   Clue Scene
            
            //Disregard what the buttons do below, it was for testing purposes.
            
            
            ///////////////// Start of Button Programming.  
            
               /////////   Extra Buttons
                  
               categoryBack.setOnAction( e ->  
                  
                  {
                  
                     window.setScene(gameboardScene);
                  
                  });
            
               /////////   Category A Buttons
               
               categoryAInfo.setOnAction( e ->  //this button will go back and forth between the gameboardScene and the categoryInfomation scene
                  
                  {
                     
                     categoryText.setText("You are in the categoryInfoScene. \nYou arrived here via categoryAInfo.");
                     
                     
                     window.setScene(categoryInfoScene);
                  
                  });
                  
               categoryA100.setOnAction( e ->  
                  
                  {
                  
                     System.out.println("Yeet");
                  
                  });
                  
               categoryA200.setOnAction( e ->  
                  
                  {
                  
                     System.out.println("Yeet");
                  
                  });
                  
               categoryA300.setOnAction( e ->  
                  
                  {
                  
                     System.out.println("Yeet");
                  
                  });
                  
               categoryA400.setOnAction( e ->  
                  
                  {
                  
                     System.out.println("Yeet");
                  
                  });
                  
               categoryA500.setOnAction( e ->  
                  
                  {
                  
                     System.out.println("Yeet");
                  
                  });
               
               
               /////////   Category B Buttons
            
               categoryBInfo.setOnAction( e ->  //this button will go back and forth between the gameboardScene and the categoryInfomation scene
                  
                  {
                     
                     categoryText.setText("You are in the categoryInfoScene. \nYou arrived here via categoryBInfo.");;
                     
                     window.setScene(categoryInfoScene);
                  
                  });
                  
               categoryB100.setOnAction( e ->  
                  
                  {
                  
                     System.out.println("Yeet");
                  
                  });
                  
               categoryB200.setOnAction( e ->  
                  
                  {
                  
                     System.out.println("Yeet");
                  
                  });
                  
               categoryB300.setOnAction( e ->  
                  
                  {
                  
                     System.out.println("Yeet");
                  
                  });
                  
               categoryB400.setOnAction( e ->  
                  
                  {
                  
                     System.out.println("Yeet");
                  
                  });
                  
               categoryB500.setOnAction( e ->  
                  
                  {
                  
                     System.out.println("Yeet");
                  
                  });
                  
               
               /////////   Category C Buttons
               
               categoryCInfo.setOnAction( e ->  //this button will go back and forth between the gameboardScene and the categoryInfomation scene
                  
                  {
                  
                     categoryText.setText("You are in the categoryInfoScene. \nYou arrived here via categoryCInfo.");
                     
                     
                     window.setScene(categoryInfoScene);
                  
                  });
                  
               categoryC100.setOnAction( e ->  
                  
                  {
                  
                     System.out.println("Yeet");
                  
                  });
                  
               categoryC200.setOnAction( e ->  
                  
                  {
                  
                     System.out.println("Yeet");
                  
                  });
                  
               categoryC300.setOnAction( e ->  
                  
                  {
                  
                     System.out.println("Yeet");
                  
                  });
                  
               categoryC400.setOnAction( e ->  
                  
                  {
                  
                     System.out.println("Yeet");
                  
                  });
                  
               categoryC500.setOnAction( e ->  
                  
                  {
                  
                     System.out.println("Yeet");
                  
                  });
                  
              
               /////////   Category D Buttons
               
               categoryDInfo.setOnAction( e ->  //this button will go back and forth between the gameboardScene and the categoryInfomation scene
                  
                  {
                  
                     categoryText.setText("You are in the categoryInfoScene. \nYou arrived here via categoryDInfo.");
                     
                     
                     window.setScene(categoryInfoScene);
                  
                  });
                  
               categoryD100.setOnAction( e ->  
                  
                  {
                  
                     System.out.println("Yeet");
                  
                  });
                  
               categoryD200.setOnAction( e ->  
                  
                  {
                  
                     System.out.println("Yeet");
                  
                  });
                  
               categoryD300.setOnAction( e ->  
                  
                  {
                  
                     System.out.println("Yeet");
                  
                  });
                  
               categoryD400.setOnAction( e ->  
                  
                  {
                  
                     System.out.println("Yeet");
                  
                  });
                  
               categoryD500.setOnAction( e ->  
                  
                  {
                  
                     System.out.println("Yeet");
                  
                  });
                  
               
               /////////   Category E Buttons
               
               categoryEInfo.setOnAction( e ->  //this button will go back and forth between the gameboardScene and the categoryInfomation scene
                  
                  {
                  
                     categoryText.setText("You are in the categoryInfoScene. \nYou arrived here via categoryEInfo.");
                     
                     
                     window.setScene(categoryInfoScene);
                  
                  });
                  
               categoryE100.setOnAction( e ->  
                  
                  {
                  
                     System.out.println("Yeet");
                  
                  });
                  
               categoryE200.setOnAction( e ->  
                  
                  {
                  
                     System.out.println("Yeet");
                  
                  });
                  
               categoryE300.setOnAction( e ->  
                  
                  {
                  
                     System.out.println("Yeet");
                  
                  });
                  
               categoryE400.setOnAction( e ->  
                  
                  {
                  
                     System.out.println("Yeet");
                  
                  });
                  
               categoryE500.setOnAction( e ->  
                  
                  {
                  
                     System.out.println("Yeet");
                  
                  });
                  
                  
               /////////   Category F Buttons
               
               categoryFInfo.setOnAction( e ->  //this button will go back and forth between the gameboardScene and the categoryInfomation scene
                  
                  {
                  
                     categoryText.setText("You are in the categoryInfoScene. \nYou arrived here via categoryFInfo.");
                     
                     
                     window.setScene(categoryInfoScene);
                  
                  });
                  
               categoryF100.setOnAction( e ->  
                  
                  {
                  
                     System.out.println("Yeet");
                  
                  });
                  
               categoryF200.setOnAction( e ->  
                  
                  {
                  
                     System.out.println("Yeet");
                  
                  });
                  
               categoryF300.setOnAction( e ->  
                  
                  {
                  
                     System.out.println("Yeet");
                  
                  });
                  
               categoryF400.setOnAction( e ->  
                  
                  {
                  
                     System.out.println("Yeet");
                  
                  });
                  
               categoryF500.setOnAction( e ->  
                  
                  {
                  
                     System.out.println("Yeet");
                  
                  });
                  
            ///////////////// End of Button Programming.
                  
               
         }
         
   }