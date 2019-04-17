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


public class JeopardyTesting extends Application

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
                  
                  Button categoryA100 = new Button(" 100 ");
                  
                  Button categoryA200 = new Button(" 200 ");
                  
                  Button categoryA300 = new Button(" 300 ");
                  
                  Button categoryA400 = new Button(" 400 ");
                  
                  Button categoryA500 = new Button(" 500 ");
                  
               
               // Category B
               
                  Button categoryBInfo = new Button("bInfo"); 
                  
                  Button categoryB100 = new Button(" 100 ");
                  
                  Button categoryB200 = new Button(" 200 ");
                  
                  Button categoryB300 = new Button(" 300 ");
                  
                  Button categoryB400 = new Button(" 400 ");
                  
                  Button categoryB500 = new Button(" 500 ");
               
                           
               
               // Category C
               
                  Button categoryCInfo = new Button("cInfo"); 
                  
                  Button categoryC100 = new Button(" 100 ");
                  
                  Button categoryC200 = new Button(" 200 ");
                  
                  Button categoryC300 = new Button(" 300 ");
                  
                  Button categoryC400 = new Button(" 400 ");
                  
                  Button categoryC500 = new Button(" 500 ");
               
                           
               // Category D
               
                  Button categoryDInfo = new Button("dInfo"); 
                  
                  Button categoryD100 = new Button(" 100 ");
                  
                  Button categoryD200 = new Button(" 200 ");
                  
                  Button categoryD300 = new Button(" 300 ");
                  
                  Button categoryD400 = new Button(" 400 ");
                  
                  Button categoryD500 = new Button(" 500 ");
               
                          
               // Category E 
               
                  Button categoryEInfo = new Button("eInfo"); 
                  
                  Button categoryE100 = new Button(" 100 ");
                  
                  Button categoryE200 = new Button(" 200 ");
                  
                  Button categoryE300 = new Button(" 300 ");
                  
                  Button categoryE400 = new Button(" 400 ");
                  
                  Button categoryE500 = new Button(" 500 ");
                  
                           
               // Category F
               
                  Button categoryFInfo = new Button("fInfo"); 
                  
                  Button categoryF100 = new Button(" 100 ");
                  
                  Button categoryF200 = new Button(" 200 ");
                  
                  Button categoryF300 = new Button(" 300 ");
                  
                  Button categoryF400 = new Button(" 400 ");
                  
                  Button categoryF500 = new Button(" 500 ");
            
            
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
                  
                     Label clueText = new Label("Put the text for the clue here.");
                     
                     Button answerA = new Button("A: Answer A");
                     
                     Button answerB = new Button("B: Answer B");
                     
                     Button answerX = new Button("X: Answer X");
                     
                     Button answerY = new Button("Y: Answer Y");
                     
                     Button clueBackButton = new Button("Back");
                     
                     GridPane clueGridPane = new GridPane();
                     
                     clueGridPane.add(answerA, 0, 0);
                     
                     clueGridPane.add(answerB, 1, 0);
                     
                     clueGridPane.add(answerX, 0, 1);
                     
                     clueGridPane.add(answerY, 1, 1);
                     
                     VBox clueSceneVBox = new VBox(clueText, clueGridPane, clueBackButton);
                     
                     BorderPane clueSceneBorderPane = new BorderPane();
                     
                     clueSceneVBox.setAlignment(Pos.CENTER);
                     
                     clueGridPane.setAlignment(Pos.BOTTOM_CENTER);
                     
                     clueSceneBorderPane.setLeft(clueBackButton);
                     
                     clueSceneBorderPane.setCenter(clueSceneVBox);
                     
                     Scene clueScene = new Scene(clueSceneBorderPane, 1280, 720);
                     
                     
            
            //Disregard what the buttons do below, it was for testing purposes.
            
            
            ///////////////// Start of Button Programming.  
            
               /////////   Extra Buttons
                  
               categoryBack.setOnAction( e ->  
                  
                  {
                  
                     window.setScene(gameboardScene);
                  
                  });
                  
               clueBackButton.setOnAction( e ->  
                  
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
                     
                     clueText.setText("Put the text for the clue here.\nYou got here from categoryA100.");
                     
                     window.setScene(clueScene);
                     
                     categoryA100.setDisable(true);
                     
                     categoryA100.setText("        ");
                  
                  });
                  
               categoryA200.setOnAction( e ->  
                  
                  {
                  
                     System.out.println("Yeet");
                     
                     clueText.setText("Put the text for the clue here.\nYou got here from categoryA200.");
                     
                     window.setScene(clueScene);
                     
                     categoryA200.setDisable(true);
                     
                     categoryA200.setText("        ");
                  
                  });
                  
               categoryA300.setOnAction( e ->  
                  
                  {
                  
                     System.out.println("Yeet");
                     
                     clueText.setText("Put the text for the clue here.\nYou got here from categoryA300.");
                     
                     window.setScene(clueScene);
                     
                     categoryA300.setDisable(true);
                     
                     categoryA300.setText("        ");
                  
                  });
                  
               categoryA400.setOnAction( e ->  
                  
                  {
                  
                     System.out.println("Yeet");
                     
                     clueText.setText("Put the text for the clue here.\nYou got here from categoryA400.");
                     
                     window.setScene(clueScene);
                     
                     categoryA400.setDisable(true);
                     
                     categoryA400.setText("        ");
                  
                  });
                  
               categoryA500.setOnAction( e ->  
                  
                  {
                  
                     System.out.println("Yeet");
                     
                     clueText.setText("Put the text for the clue here.\nYou got here from categoryA500.");
                     
                     window.setScene(clueScene);
                     
                     categoryA500.setDisable(true);
                     
                     categoryA500.setText("        ");
                  
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
                     
                     clueText.setText("Put the text for the clue here.\nYou got here from categoryB100.");
                     
                     window.setScene(clueScene);
                     
                     categoryB100.setDisable(true);
                     
                     categoryB100.setText("        ");
                  
                  });
                  
               categoryB200.setOnAction( e ->  
                  
                  {
                  
                     System.out.println("Yeet");
                     
                     clueText.setText("Put the text for the clue here.\nYou got here from categoryB200.");
                     
                     window.setScene(clueScene);
                     
                     categoryB200.setDisable(true);
                     
                     categoryB200.setText("        ");
                  
                  });
                  
               categoryB300.setOnAction( e ->  
                  
                  {
                  
                     System.out.println("Yeet");
                     
                     clueText.setText("Put the text for the clue here.\nYou got here from categoryB300.");
                     
                     window.setScene(clueScene);
                     
                     categoryB300.setDisable(true);
                     
                     categoryB300.setText("        ");
                  
                  });
                  
               categoryB400.setOnAction( e ->  
                  
                  {
                  
                     System.out.println("Yeet");
                     
                     clueText.setText("Put the text for the clue here.\nYou got here from categoryB400.");
                     
                     window.setScene(clueScene);
                     
                     categoryB400.setDisable(true);
                     
                     categoryB400.setText("        ");
                  
                  });
                  
               categoryB500.setOnAction( e ->  
                  
                  {
                  
                     System.out.println("Yeet");
                     
                     clueText.setText("Put the text for the clue here.\nYou got here from categoryB500.");
                     
                     window.setScene(clueScene);
                     
                     categoryB500.setDisable(true);
                     
                     categoryB500.setText("        ");
                  
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
                     
                     clueText.setText("Put the text for the clue here.\nYou got here from categoryC100.");
                     
                     window.setScene(clueScene);
                     
                     categoryC100.setDisable(true);
                     
                     categoryC100.setText("        ");
                  
                  });
                  
               categoryC200.setOnAction( e ->  
                  
                  {
                  
                     System.out.println("Yeet");
                     
                     clueText.setText("Put the text for the clue here.\nYou got here from categoryC200.");
                     
                     window.setScene(clueScene);
                     
                     categoryC200.setDisable(true);
                     
                     categoryC200.setText("        ");
                  
                  });
                  
               categoryC300.setOnAction( e ->  
                  
                  {
                  
                     System.out.println("Yeet");
                     
                     clueText.setText("Put the text for the clue here.\nYou got here from categoryC300.");
                     
                     window.setScene(clueScene);
                     
                     categoryC300.setDisable(true);
                     
                     categoryC300.setText("        ");
                  
                  });
                  
               categoryC400.setOnAction( e ->  
                  
                  {
                  
                     System.out.println("Yeet");
                     
                     clueText.setText("Put the text for the clue here.\nYou got here from categoryC400.");
                     
                     window.setScene(clueScene);
                     
                     categoryC400.setDisable(true);
                     
                     categoryC400.setText("        ");
                  
                  });
                  
               categoryC500.setOnAction( e ->  
                  
                  {
                  
                     System.out.println("Yeet");
                     
                     clueText.setText("Put the text for the clue here.\nYou got here from categoryC500.");
                     
                     window.setScene(clueScene);
                     
                     categoryC500.setDisable(true);
                     
                     categoryC500.setText("        ");
                  
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
                     
                     clueText.setText("Put the text for the clue here.\nYou got here from categoryD100.");
                     
                     window.setScene(clueScene);
                     
                     categoryD100.setDisable(true);
                     
                     categoryD100.setText("        ");
                  
                  });
                  
               categoryD200.setOnAction( e ->  
                  
                  {
                  
                     System.out.println("Yeet");
                     
                     clueText.setText("Put the text for the clue here.\nYou got here from categoryD200.");
                     
                     window.setScene(clueScene);
                     
                     categoryD200.setDisable(true);
                     
                     categoryD200.setText("        ");
                  
                  });
                  
               categoryD300.setOnAction( e ->  
                  
                  {
                  
                     System.out.println("Yeet");
                     
                     clueText.setText("Put the text for the clue here.\nYou got here from categoryD300.");
                     
                     window.setScene(clueScene);
                     
                     categoryD300.setDisable(true);
                     
                     categoryD300.setText("        ");
                  
                  });
                  
               categoryD400.setOnAction( e ->  
                  
                  {
                  
                     System.out.println("Yeet");
                     
                     clueText.setText("Put the text for the clue here.\nYou got here from categoryD400.");
                     
                     window.setScene(clueScene);
                     
                     categoryD400.setDisable(true);
                     
                     categoryD400.setText("        ");
                  
                  });
                  
               categoryD500.setOnAction( e ->  
                  
                  {
                  
                     System.out.println("Yeet");
                     
                     clueText.setText("Put the text for the clue here.\nYou got here from categoryD500.");
                     
                     window.setScene(clueScene);
                     
                     categoryD500.setDisable(true);
                     
                     categoryD500.setText("        ");
                  
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
                     
                     clueText.setText("Put the text for the clue here.\nYou got here from categoryE100.");
                     
                     window.setScene(clueScene);
                     
                     categoryE100.setDisable(true);
                     
                     categoryE100.setText("        ");
                  
                  });
                  
               categoryE200.setOnAction( e ->  
                  
                  {
                  
                     System.out.println("Yeet");
                     
                     clueText.setText("Put the text for the clue here.\nYou got here from categoryE200.");
                     
                     window.setScene(clueScene);
                     
                     categoryE200.setDisable(true);
                     
                     categoryE200.setText("        ");
                  
                  });
                  
               categoryE300.setOnAction( e ->  
                  
                  {
                  
                     System.out.println("Yeet");
                     
                     clueText.setText("Put the text for the clue here.\nYou got here from categoryE300.");
                     
                     window.setScene(clueScene);
                     
                     categoryE300.setDisable(true);
                     
                     categoryE300.setText("        ");
                  
                  });
                  
               categoryE400.setOnAction( e ->  
                  
                  {
                  
                     System.out.println("Yeet");
                     
                     clueText.setText("Put the text for the clue here.\nYou got here from categoryE400.");
                     
                     window.setScene(clueScene);
                     
                     categoryE400.setDisable(true);
                     
                     categoryE400.setText("        ");
                  
                  });
                  
               categoryE500.setOnAction( e ->  
                  
                  {
                  
                     System.out.println("Yeet");
                     
                     clueText.setText("Put the text for the clue here.\nYou got here from categoryE500.");
                     
                     window.setScene(clueScene);
                     
                     categoryE500.setDisable(true);
                     
                     categoryE500.setText("        ");
                  
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
                     
                     clueText.setText("Put the text for the clue here.\nYou got here from categoryF100.");
                     
                     window.setScene(clueScene);
                     
                     categoryF100.setDisable(true);
                     
                     categoryF100.setText("        ");
                  
                  });
                  
               categoryF200.setOnAction( e ->  
                  
                  {
                  
                     System.out.println("Yeet");
                     
                     clueText.setText("Put the text for the clue here.\nYou got here from categoryF200.");
                     
                     window.setScene(clueScene);
                     
                     categoryF200.setDisable(true);
                     
                     categoryF200.setText("        ");
                  
                  });
                  
               categoryF300.setOnAction( e ->  
                  
                  {
                  
                     System.out.println("Yeet");
                     
                     clueText.setText("Put the text for the clue here.\nYou got here from categoryF300.");
                     
                     window.setScene(clueScene);
                                          
                     categoryF300.setDisable(true);
                     
                     categoryF300.setText("        ");
                  
                  });
                  
               categoryF400.setOnAction( e ->  
                  
                  {
                  
                     System.out.println("Yeet");
                     
                     clueText.setText("Put the text for the clue here.\nYou got here from categoryF400.");
                     
                     window.setScene(clueScene);
                     
                     categoryF400.setDisable(true);
                     
                     categoryF400.setText("        ");
                  
                  });
                  
               categoryF500.setOnAction( e ->  
                  
                  {
                  
                     System.out.println("Yeet");
                     
                     clueText.setText("Put the text for the clue here.\nYou got here from categoryF500.");
                     
                     window.setScene(clueScene);
                     
                     categoryF500.setDisable(true);
                     
                     categoryF500.setText("        ");
                  
                  });
                  
            ///////////////// End of Button Programming.
                  
               
         }
         
   }