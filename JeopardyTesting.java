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
      
            ////////////////// Setting Up player objects. 
            
            Player player1 = new Player();
            
            Player player2 = new Player();
            
            Player player3 = new Player();
                           
            
            
            ////////////////// Setting Up DailyDouble. 
                           
            
            DailyDouble dailyDouble = new DailyDouble(); //    The DailyDouble class is used for several features inside of Jeopardy. 
                                                         //    It handles the randomization of the daily double positions in both regular and double jeopardy along with the wager each player makes. It also helps us keep track of what phase of the game we are currently in.
            
            dailyDouble.setValueA(0);  /// ValueA is the daily double question for regular jeopardy, while ValueB and ValueC are for double jeopardy
            
            dailyDouble.setValueB(0);
            
            dailyDouble.setValueC(0);
            
            while (dailyDouble.getValueB() == dailyDouble.getValueC())  // simple while loop that prevents both daily doubles in double jeopardy from being the same position.
               
               {
               
                  dailyDouble.setValueC(0);
               
               }
            
            System.out.println("The daily double counter is currently at " + dailyDouble.getCounter() + ".");  // Console outputs used in testing. These let us know that the counter we use to trigger the daily double is working.
            
            System.out.println("The daily double will trigger on question " + dailyDouble.getValueA() + "."); //  This tells us the daily double position in regular jeopardy.
            
            System.out.println("The two double jeopardy daily doubles will trigger on questions " + dailyDouble.getValueB() + " and " + dailyDouble.getValueC()); // Same as above, however with the two different daily doubles in double jeopardy.
            
            
            
            ////////////////// Beginning of Gameboard Button Creation
            
               // Jeopardy has six different categories on the gameboard at all times, so we have them sorted by Category A-F. We created each group of buttons for each category seperately from the other categories in order. 
               
               // The spacing with any of the numberical buttons is there for appearences sake during development. *******TWEAK THIS LINE BEFORE SUBMISSION******* The CSS stylesheet changes the look of the buttons so this becomes unnessessary.
            
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
                        
                        Button dailyDoubleTestButton = new Button("Daily Double Test");   // This button will eventually get deleted
               
                        gameboardBorderPane.setCenter(gameboard);
                        
                        gameboardBorderPane.setBottom(dailyDoubleTestButton); // This line of code will eventually get deleted
               
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
                     
                  /////////   Daily Double Scenes. ONE Daily Double in Regular Jeopardy, TWO Daily Doubles in Double Jeopardy.
                  
                     //////   Daily Double Scene 1
                           
                        Label dailyDoubleScene1Label = new Label("Daily \nDouble");
                        
                        Button dailyDoubleScene1Button = new Button ("Next");
                        
                        VBox dailyDoubleScene1VBox = new VBox(dailyDoubleScene1Label,dailyDoubleScene1Button);
                        
                        BorderPane dailyDoubleScene1BorderPane = new BorderPane();
                        
                        dailyDoubleScene1BorderPane.setCenter(dailyDoubleScene1VBox);
                        
                        Scene dailyDoubleScene1 = new Scene(dailyDoubleScene1BorderPane, 1280, 720);
                        
                     //////   Daily Double Scene 2
                     
                        ///   This scene is used for the player to enter their wager during the daily double. As of 4/26/2019, the highest daily double wager was $25,000 which was set on April 9th, 2018. Because of this, we maxed out the bet at $25,001.
                     
                        Label dailyDoubleScene2Label = new Label("How much would you like to wager? \nAll wagers must be positive whole numbers \nequal to or less than your current total.");
               
                        Label dailyDoubleWagerLabel = new Label("Wager: 0");
                        
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
                        
                        //window.setScene(dailyDoubleScene2);
                        
                     //////   Daily Double Clue Scene
                     
                        Label clueTextDD = new Label("Put the text for the clue here.");
                     
                        Button answerADD = new Button("A: Answer A");
                     
                        Button answerBDD = new Button("B: Answer B");
                     
                        Button answerXDD = new Button("X: Answer X");
                     
                        Button answerYDD = new Button("Y: Answer Y");
                     
                        Button clueBackButtonDD = new Button("Back");
                     
                        GridPane clueGridPaneDD = new GridPane();
                     
                        clueGridPaneDD.add(answerADD, 0, 0);
                     
                        clueGridPaneDD.add(answerBDD, 1, 0);
                     
                        clueGridPaneDD.add(answerXDD, 0, 1);
                     
                        clueGridPaneDD.add(answerYDD, 1, 1);
                     
                        VBox clueSceneVBoxDD = new VBox(clueTextDD, clueGridPaneDD, clueBackButtonDD);
                     
                        BorderPane clueSceneBorderPaneDD = new BorderPane();
                     
                        clueSceneVBoxDD.setAlignment(Pos.CENTER);
                     
                        clueGridPaneDD.setAlignment(Pos.BOTTOM_CENTER);
                     
                        clueSceneBorderPaneDD.setLeft(clueBackButtonDD);
                     
                        clueSceneBorderPaneDD.setCenter(clueSceneVBoxDD);
                     
                        Scene dailyDoubleClueScene = new Scene(clueSceneBorderPaneDD, 1280, 720);
      
                  
                  /////////   Final Jeopardy Scenes
                     
                     //////   FJ Scene 1
                           
                        Label finalJeopardyScene1Label = new Label("Final \nJeopardy");
                        
                        Button finalJeopardyScene1Button = new Button ("Next");
                        
                        VBox finalJeopardyScene1VBox = new VBox(finalJeopardyScene1Label, finalJeopardyScene1Button);
                        
                        BorderPane finalJeopardyScene1BorderPane = new BorderPane();
                        
                        finalJeopardyScene1BorderPane.setCenter(finalJeopardyScene1VBox);
                        
                        Scene finalJeopardyScene1 = new Scene(finalJeopardyScene1BorderPane, 1280, 720);
                        
                     //////   FJ Scene 2 
                     
                        Label finalJeopardyScene2Label = new Label("How much would you like to wager? \nAll wagers must be positive whole numbers \nequal to or less than your current total.");
               
                        Label finalJeopardyWagerLabel = new Label("Wager: 0");
                        
                        Button finalJeopardyWager1 = new Button ("   1   ");
                        
                        Button finalJeopardyWager2 = new Button ("   2   ");
                        
                        Button finalJeopardyWager3 = new Button ("   3   ");
                        
                        Button finalJeopardyWager4 = new Button ("   4   ");
                        
                        Button finalJeopardyWager5 = new Button ("   5   ");
                        
                        Button finalJeopardyWager6 = new Button ("   6   ");
                        
                        Button finalJeopardyWager7 = new Button ("   7   ");
                        
                        Button finalJeopardyWager8 = new Button ("   8   ");
                        
                        Button finalJeopardyWager9 = new Button ("   9   ");
                        
                        Button finalJeopardyWager0 = new Button ("   0   ");
                        
                        Button finalJeopardyWagerEnterButton = new Button("Enter");
                        
                        Button finalJeopardyWagerClearButton = new Button("Clear");
                        
                        GridPane finalJeopardyWagerGridPane = new GridPane();
                        
                        finalJeopardyWagerGridPane.add(finalJeopardyWager1, 0, 0);
                        
                        finalJeopardyWagerGridPane.add(finalJeopardyWager2, 1, 0);
                        
                        finalJeopardyWagerGridPane.add(finalJeopardyWager3, 2, 0);
                        
                        finalJeopardyWagerGridPane.add(finalJeopardyWager4, 0, 1);
                        
                        finalJeopardyWagerGridPane.add(finalJeopardyWager5, 1, 1);
                        
                        finalJeopardyWagerGridPane.add(finalJeopardyWager6, 2, 1);
                        
                        finalJeopardyWagerGridPane.add(finalJeopardyWager7, 0, 2);
                        
                        finalJeopardyWagerGridPane.add(finalJeopardyWager8, 1, 2);
                        
                        finalJeopardyWagerGridPane.add(finalJeopardyWager9, 2, 2);
                        
                        finalJeopardyWagerGridPane.add(finalJeopardyWagerClearButton, 0, 3);
                        
                        finalJeopardyWagerGridPane.add(finalJeopardyWager0, 1, 3);
                        
                        finalJeopardyWagerGridPane.add(finalJeopardyWagerEnterButton, 2, 3); 
                        
                        VBox finalJeopardyScene2VBox = new VBox(finalJeopardyScene2Label, finalJeopardyWagerLabel, finalJeopardyWagerGridPane); 
                        
                        BorderPane finalJeopardyScene2BorderPane = new BorderPane();
                        
                        finalJeopardyScene2BorderPane.setCenter(finalJeopardyScene2VBox);
                        
                        Scene finalJeopardyScene2 = new Scene(finalJeopardyScene2BorderPane, 1280, 720);
                     
                     
                     
            
           
            
            
            ///////////////// Start of Button Programming.  
            
               /////////   Extra Buttons
                  
               categoryBack.setOnAction( e ->  
                  
                  {
                  
                     window.setScene(gameboardScene);
                  
                  });
                  
               clueBackButton.setOnAction( e ->  
                  
                  {
                     
                     if (dailyDouble.getCounter() == 30 || dailyDouble.getCounter() == 60)
                        
                        {       
                        
                        
                           dailyDouble.plusGamePhase();  // increases the value for the gamePhase, which is used to track which part of the game we are in.
                                                         // gamePhase zero is regular jeopardy, gamePhase one is double jeopardy, gamePhase two is final jeopardy
                           
                              if (dailyDouble.getGamePhase() == 1)
                                 
                                 {
                           
                                    ///   Resets the Gameboard and prepares it for Double Jeopardy. 
                                    
                                    // Category A
                                    
                                       categoryA100.setDisable(false);
                                       categoryA100.setText(" 200 ");
                                       
                                       categoryA200.setDisable(false);
                                       categoryA200.setText(" 400 ");
                                       
                                       categoryA300.setDisable(false);
                                       categoryA300.setText(" 600 ");
                                       
                                       categoryA400.setDisable(false);
                                       categoryA400.setText(" 800 ");
                                       
                                       categoryA500.setDisable(false);
                                       categoryA500.setText(" 1000 ");
                                    
                                    
                                    // Category B
                                    
                                       categoryB100.setDisable(false);
                                       categoryB100.setText(" 200 ");
                                       
                                       categoryB200.setDisable(false);
                                       categoryB200.setText(" 400 ");
                                       
                                       categoryB300.setDisable(false);
                                       categoryB300.setText(" 600 ");
                                       
                                       categoryB400.setDisable(false);
                                       categoryB400.setText(" 800 ");
                                       
                                       categoryB500.setDisable(false);
                                       categoryB500.setText(" 1000 ");
                                    
                                    
                                    // Category C
                                    
                                       categoryC100.setDisable(false);
                                       categoryC100.setText(" 200 ");
                                    
                                       categoryC200.setDisable(false);
                                       categoryC200.setText(" 400 ");
                                       
                                       categoryC300.setDisable(false);
                                       categoryC300.setText(" 600 ");
                                       
                                       categoryC400.setDisable(false);
                                       categoryC400.setText(" 800 ");
                                    
                                       categoryC500.setDisable(false);
                                       categoryC500.setText(" 1000 ");
                                       
                                       
                                    // Category D
                                    
                                       categoryD100.setDisable(false);
                                       categoryD100.setText(" 200 ");
                                    
                                       categoryD200.setDisable(false);
                                       categoryD200.setText(" 400 ");
                                       
                                       categoryD300.setDisable(false);
                                       categoryD300.setText(" 600 ");
                                       
                                       categoryD400.setDisable(false);
                                       categoryD400.setText(" 800 ");
                                    
                                       categoryD500.setDisable(false);
                                       categoryD500.setText(" 1000 ");
                                       
                                       
                                    // Category E
                                    
                                       categoryE100.setDisable(false);
                                       categoryE100.setText(" 200 ");
                                    
                                       categoryE200.setDisable(false);
                                       categoryE200.setText(" 400 ");
                                       
                                       categoryE300.setDisable(false);
                                       categoryE300.setText(" 600 ");
                                       
                                       categoryE400.setDisable(false);
                                       categoryE400.setText(" 800 ");
                                    
                                       categoryE500.setDisable(false);
                                       categoryE500.setText(" 1000 ");
                                       
                                    
                                    // Category F
                                       
                                       categoryF100.setDisable(false);
                                       categoryF100.setText(" 200 ");
                                    
                                       categoryF200.setDisable(false);
                                       categoryF200.setText(" 400 ");
                                       
                                       categoryF300.setDisable(false);
                                       categoryF300.setText(" 600 ");
                                       
                                       categoryF400.setDisable(false);
                                       categoryF400.setText(" 800 ");
                                    
                                       categoryF500.setDisable(false);
                                       categoryF500.setText(" 1000 ");
                                       
                                       window.setScene(gameboardScene);
                                       
                                 }
                                 
                              else if (dailyDouble.getGamePhase() == 2)
                                 
                                 {
                                 
                                    // future final jeopardy code goes here.
                                    
                                    window.setScene(finalJeopardyScene1);
                                 
                                 }
                          
                        }
                                 
                     else
                        
                        {
                  
                           window.setScene(gameboardScene);
               
                        }  
                        
                     
                  
                  });
                  
               
               // Final Jeopardy Buttons
               
               finalJeopardyScene1Button.setOnAction ( e ->
                  
                  {
                  
                     dailyDouble.resetWager();
                     
                     window.setScene(finalJeopardyScene2);
                  
                  });
                  
               finalJeopardyWager1.setOnAction( e ->  
                  
                  {
                  
                     if (dailyDouble.getGamePhase() == 2)
                        
                        {
                           
                           player1.addDigit(1);
                           
                           finalJeopardyWagerLabel.setText("Wager: " + player1.getWagerString());
                           
                        }
                        
                     if (dailyDouble.getGamePhase() == 3)
                        
                        {
                           
                           player2.addDigit(1);
                           
                           finalJeopardyWagerLabel.setText("Wager: " + player2.getWagerString());
                           
                        }
                        
                     if (dailyDouble.getGamePhase() == 4)
                        
                        {
                           
                           player3.addDigit(1);
                           
                           finalJeopardyWagerLabel.setText("Wager: " + player3.getWagerString());
                           
                        }
                     
                     /*
                     
                     if (finalJeopardy.getWager() == 0)
                        
                        {
                        
                           finalJeopardy.addDigit(1);
                           
                           finalJeopardyWagerLabel.setText("Wager: " + finalJeopardy.getWagerString());
                        
                        }
                        
                     else
                        
                        {
                        
                           finalJeopardy.addDigit(1);
                           
                           finalJeopardyWagerLabel.setText("Wager: " + finalJeopardy.getWagerString());
                        
                        }
                        
                     */
                  
                  });
                  
                  
               
               
               
               // Daily Double Buttons
               
               clueBackButtonDD.setOnAction( e ->  
                  
                  {
                  
                      if (dailyDouble.getCounter() == 30 || dailyDouble.getCounter() == 60)
                        
                        {       
                        
                        
                           dailyDouble.plusGamePhase();  // increases the value for the gamePhase, which is used to track which part of the game we are in.
                                                         // gamePhase zero is regular jeopardy, gamePhase one is double jeopardy, gamePhase two is final jeopardy
                           
                              if (dailyDouble.getGamePhase() == 1)
                                 
                                 {
                           
                                    ///   Resets the Gameboard and prepares it for Double Jeopardy. 
                                    
                                    // Category A
                                    
                                       categoryA100.setDisable(false);
                                       categoryA100.setText(" 200 ");
                                       
                                       categoryA200.setDisable(false);
                                       categoryA200.setText(" 400 ");
                                       
                                       categoryA300.setDisable(false);
                                       categoryA300.setText(" 600 ");
                                       
                                       categoryA400.setDisable(false);
                                       categoryA400.setText(" 800 ");
                                       
                                       categoryA500.setDisable(false);
                                       categoryA500.setText(" 1000 ");
                                    
                                    
                                    // Category B
                                    
                                       categoryB100.setDisable(false);
                                       categoryB100.setText(" 200 ");
                                       
                                       categoryB200.setDisable(false);
                                       categoryB200.setText(" 400 ");
                                       
                                       categoryB300.setDisable(false);
                                       categoryB300.setText(" 600 ");
                                       
                                       categoryB400.setDisable(false);
                                       categoryB400.setText(" 800 ");
                                       
                                       categoryB500.setDisable(false);
                                       categoryB500.setText(" 1000 ");
                                    
                                    
                                    // Category C
                                    
                                       categoryC100.setDisable(false);
                                       categoryC100.setText(" 200 ");
                                    
                                       categoryC200.setDisable(false);
                                       categoryC200.setText(" 400 ");
                                       
                                       categoryC300.setDisable(false);
                                       categoryC300.setText(" 600 ");
                                       
                                       categoryC400.setDisable(false);
                                       categoryC400.setText(" 800 ");
                                    
                                       categoryC500.setDisable(false);
                                       categoryC500.setText(" 1000 ");
                                       
                                       
                                    // Category D
                                    
                                       categoryD100.setDisable(false);
                                       categoryD100.setText(" 200 ");
                                    
                                       categoryD200.setDisable(false);
                                       categoryD200.setText(" 400 ");
                                       
                                       categoryD300.setDisable(false);
                                       categoryD300.setText(" 600 ");
                                       
                                       categoryD400.setDisable(false);
                                       categoryD400.setText(" 800 ");
                                    
                                       categoryD500.setDisable(false);
                                       categoryD500.setText(" 1000 ");
                                       
                                       
                                    // Category E
                                    
                                       categoryE100.setDisable(false);
                                       categoryE100.setText(" 200 ");
                                    
                                       categoryE200.setDisable(false);
                                       categoryE200.setText(" 400 ");
                                       
                                       categoryE300.setDisable(false);
                                       categoryE300.setText(" 600 ");
                                       
                                       categoryE400.setDisable(false);
                                       categoryE400.setText(" 800 ");
                                    
                                       categoryE500.setDisable(false);
                                       categoryE500.setText(" 1000 ");
                                       
                                    
                                    // Category F
                                       
                                       categoryF100.setDisable(false);
                                       categoryF100.setText(" 200 ");
                                    
                                       categoryF200.setDisable(false);
                                       categoryF200.setText(" 400 ");
                                       
                                       categoryF300.setDisable(false);
                                       categoryF300.setText(" 600 ");
                                       
                                       categoryF400.setDisable(false);
                                       categoryF400.setText(" 800 ");
                                    
                                       categoryF500.setDisable(false);
                                       categoryF500.setText(" 1000 ");
                                       
                                       window.setScene(gameboardScene);
                                       
                                 }
                                 
                              else if (dailyDouble.getGamePhase() == 2)
                                 
                                 {
                                 
                                    window.setScene(finalJeopardyScene1);
                                 
                                 }
                           }
                     else
                        
                        {
                     
                           window.setScene(gameboardScene);
                     
                        }

                  
                  });
                  
               dailyDoubleScene1Button.setOnAction( e ->  
                  
                  {
                  
                     window.setScene(dailyDoubleScene2);
                     
                     dailyDoubleWagerLabel.setText("Wager: 0");
                     
                     dailyDouble.resetWager();
                     
                     
                  
                  });
            
               dailyDoubleWager1.setOnAction( e ->  
                  
                  {
                  
                     if (dailyDouble.getWager() == 0)
                        
                        {
                        
                           dailyDouble.addDigit(1);
                           
                           dailyDoubleWagerLabel.setText("Wager: " + dailyDouble.getWagerString());
                        
                        }
                        
                     else
                        
                        {
                        
                           dailyDouble.addDigit(1);
                           
                           dailyDoubleWagerLabel.setText("Wager: " + dailyDouble.getWagerString());
                        
                        }
                  
                  });
                  
                  
               dailyDoubleWager2.setOnAction( e ->  
                  
                  {
                  
                     if (dailyDouble.getWager() == 0)
                        
                        {
                        
                           dailyDouble.addDigit(2);
                           
                           dailyDoubleWagerLabel.setText("Wager: " + dailyDouble.getWagerString());
                        
                        }
                        
                     else
                        
                        {
                        
                           dailyDouble.addDigit(2);
                           
                           dailyDoubleWagerLabel.setText("Wager: " + dailyDouble.getWagerString());
                        
                        }
                  
                  });
                  
                  
               dailyDoubleWager3.setOnAction( e ->  
                  
                  {
                  
                     if (dailyDouble.getWager() == 0)
                        
                        {
                        
                           dailyDouble.addDigit(3);
                           
                           dailyDoubleWagerLabel.setText("Wager: " + dailyDouble.getWagerString());
                        
                        }
                        
                     else
                        
                        {
                        
                           dailyDouble.addDigit(3);
                           
                           dailyDoubleWagerLabel.setText("Wager: " + dailyDouble.getWagerString());
                        
                        }
                  
                  });
                  
                  
               dailyDoubleWager4.setOnAction( e ->  
                  
                  {
                  
                     if (dailyDouble.getWager() == 0)
                        
                        {
                        
                           dailyDouble.addDigit(4);
                           
                           dailyDoubleWagerLabel.setText("Wager: " + dailyDouble.getWagerString());
                        
                        }
                        
                     else
                        
                        {
                        
                           dailyDouble.addDigit(4);
                           
                           dailyDoubleWagerLabel.setText("Wager: " + dailyDouble.getWagerString());
                        
                        }
                  
                  });
                  
                  
               dailyDoubleWager5.setOnAction( e ->  
                  
                  {
                  
                     if (dailyDouble.getWager() == 0)
                        
                        {
                        
                           dailyDouble.addDigit(5);
                           
                           dailyDoubleWagerLabel.setText("Wager: " + dailyDouble.getWagerString());
                        
                        }
                        
                     else
                        
                        {
                        
                           dailyDouble.addDigit(5);
                           
                           dailyDoubleWagerLabel.setText("Wager: " + dailyDouble.getWagerString());
                        
                        }
                  
                  });
                  
                  
               dailyDoubleWager6.setOnAction( e ->  
                  
                  {
                  
                     if (dailyDouble.getWager() == 0)
                        
                        {
                        
                           dailyDouble.addDigit(6);
                           
                           dailyDoubleWagerLabel.setText("Wager: " + dailyDouble.getWagerString());
                        
                        }
                        
                     else
                        
                        {
                        
                           dailyDouble.addDigit(6);
                           
                           dailyDoubleWagerLabel.setText("Wager: " + dailyDouble.getWagerString());
                        
                        }
                  
                  });
                  
                  
               dailyDoubleWager7.setOnAction( e ->  
                  
                  {
                  
                     if (dailyDouble.getWager() == 0)
                        
                        {
                        
                           dailyDouble.addDigit(7);
                           
                           dailyDoubleWagerLabel.setText("Wager: " + dailyDouble.getWagerString());
                        
                        }
                        
                     else
                        
                        {
                        
                           dailyDouble.addDigit(7);
                           
                           dailyDoubleWagerLabel.setText("Wager: " + dailyDouble.getWagerString());
                        
                        }
                  
                  });
                  
                  
               dailyDoubleWager8.setOnAction( e ->  
                  
                  {
                  
                     if (dailyDouble.getWager() == 0)
                        
                        {
                        
                           dailyDouble.addDigit(8);
                           
                           dailyDoubleWagerLabel.setText("Wager: " + dailyDouble.getWagerString());
                        
                        }
                        
                     else
                        
                        {
                        
                           dailyDouble.addDigit(8);
                           
                           dailyDoubleWagerLabel.setText("Wager: " + dailyDouble.getWagerString());
                        
                        }
                  
                  });
                  
                  
               dailyDoubleWager9.setOnAction( e ->  
                  
                  {
                  
                     if (dailyDouble.getWager() == 0)
                        
                        {
                        
                           dailyDouble.addDigit(9);
                           
                           dailyDoubleWagerLabel.setText("Wager: " + dailyDouble.getWagerString());
                        
                        }
                        
                     else
                        
                        {
                        
                           dailyDouble.addDigit(9);
                           
                           dailyDoubleWagerLabel.setText("Wager: " + dailyDouble.getWagerString());
                        
                        }
                  
                  });
                  
                  
               dailyDoubleWager0.setOnAction( e ->  
                  
                  {
                  
                     if (dailyDouble.getWager() == 0)
                        
                        {
                        
                           dailyDouble.addDigit(0);
                           
                           dailyDoubleWagerLabel.setText("Wager: " + dailyDouble.getWagerString());
                        
                        }
                        
                     else
                        
                        {
                        
                           dailyDouble.addDigit(0);
                           
                           dailyDoubleWagerLabel.setText("Wager: " + dailyDouble.getWagerString());
                        
                        }
                  
                  });
                  
               dailyDoubleWagerClearButton.setOnAction( e ->  
                  
                  {
                  
                     dailyDouble.resetWager();  
                     
                     dailyDoubleWagerLabel.setText("Wager: " + dailyDouble.getWagerString()); 
                  
                  });
                  
               
               dailyDoubleWagerEnterButton.setOnAction( e ->  
                  
                  {
                  
                     window.setScene(dailyDoubleClueScene); 
                  
                  });   
               
                  
               dailyDoubleTestButton.setOnAction( e -> //   This Button will eventually get deleted. 
                  
                  {
                  
                     window.setScene(dailyDoubleScene1);
                  
                  });
               
               /////////   Category A Buttons
               
               categoryAInfo.setOnAction( e ->  
                                 
                  {
                     
                     categoryText.setText("You are in the categoryInfoScene. \nYou arrived here via categoryAInfo.");
                     
                     
                     window.setScene(categoryInfoScene);
                  
                  });
                  
               categoryA100.setOnAction( e ->  
                  
                  {
                  
                     dailyDouble.plusCounter();
                     
                     System.out.println("The daily double counter is currently at " + dailyDouble.getCounter() + ".");
                     
                     clueText.setText("Put the text for the clue here.\nYou got here from categoryA100.");
                     
                     if (dailyDouble.getCounter() == dailyDouble.getValueA() || dailyDouble.getCounter() == dailyDouble.getValueB() || dailyDouble.getCounter() == dailyDouble.getValueC())
                        
                        {
                        
                           clueTextDD.setText(clueText.getText());
                           
                           window.setScene(dailyDoubleScene1);
                        
                        }
                        
                     else
                        
                        {
                        
                        window.setScene(clueScene);
                        
                        }
                        
                      categoryA100.setDisable(true);
                     
                      categoryA100.setText("        ");
                  
                  });
                  
               categoryA200.setOnAction( e ->  
                  
                  {
                  
                     dailyDouble.plusCounter();
                     
                     System.out.println("The daily double counter is currently at " + dailyDouble.getCounter() + ".");
                     
                     clueText.setText("Put the text for the clue here.\nYou got here from categoryA200.");
                     
                     if (dailyDouble.getCounter() == dailyDouble.getValueA() || dailyDouble.getCounter() == dailyDouble.getValueB() || dailyDouble.getCounter() == dailyDouble.getValueC())
                        
                        {
                        
                           clueTextDD.setText(clueText.getText());
                           
                           window.setScene(dailyDoubleScene1);
                        
                        }
                        
                     else
                        
                        {
                        
                        window.setScene(clueScene);
                        
                        }
                     
                     categoryA200.setDisable(true);
                     
                     categoryA200.setText("        ");
                  
                  });
                  
               categoryA300.setOnAction( e ->  
                  
                  {
                  
                     dailyDouble.plusCounter();
                     
                     System.out.println("The daily double counter is currently at " + dailyDouble.getCounter() + ".");
                     
                     clueText.setText("Put the text for the clue here.\nYou got here from categoryA300.");
                     
                     if (dailyDouble.getCounter() == dailyDouble.getValueA() || dailyDouble.getCounter() == dailyDouble.getValueB() || dailyDouble.getCounter() == dailyDouble.getValueC())
                        
                        {
                        
                           clueTextDD.setText(clueText.getText());
                           
                           window.setScene(dailyDoubleScene1);
                        
                        }
                        
                     else
                        
                        {
                        
                        window.setScene(clueScene);
                        
                        }
                     
                     categoryA300.setDisable(true);
                     
                     categoryA300.setText("        ");
                  
                  });
                  
               categoryA400.setOnAction( e ->  
                  
                  {
                  
                     dailyDouble.plusCounter();
                     
                     System.out.println("The daily double counter is currently at " + dailyDouble.getCounter() + ".");
                     
                     clueText.setText("Put the text for the clue here.\nYou got here from categoryA400.");
                     
                     if (dailyDouble.getCounter() == dailyDouble.getValueA() || dailyDouble.getCounter() == dailyDouble.getValueB() || dailyDouble.getCounter() == dailyDouble.getValueC())
                        
                        {
                        
                           clueTextDD.setText(clueText.getText());
                           
                           window.setScene(dailyDoubleScene1);
                        
                        }
                        
                     else
                        
                        {
                        
                        window.setScene(clueScene);
                        
                        }
                     
                     categoryA400.setDisable(true);
                     
                     categoryA400.setText("        ");
                  
                  });
                  
               categoryA500.setOnAction( e ->  
                  
                  {
                  
                     dailyDouble.plusCounter();
                     
                     System.out.println("The daily double counter is currently at " + dailyDouble.getCounter() + ".");
                     
                     clueText.setText("Put the text for the clue here.\nYou got here from categoryA500.");
                     
                     if (dailyDouble.getCounter() == dailyDouble.getValueA() || dailyDouble.getCounter() == dailyDouble.getValueB() || dailyDouble.getCounter() == dailyDouble.getValueC())
                        
                        {
                        
                           clueTextDD.setText(clueText.getText());
                           
                           window.setScene(dailyDoubleScene1);
                        
                        }
                        
                     else
                        
                        {
                        
                        window.setScene(clueScene);
                        
                        }
                     
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
                  
                     dailyDouble.plusCounter();
                     
                     System.out.println("The daily double counter is currently at " + dailyDouble.getCounter() + ".");
                     
                     clueText.setText("Put the text for the clue here.\nYou got here from categoryB100.");
                     
                     if (dailyDouble.getCounter() == dailyDouble.getValueA() || dailyDouble.getCounter() == dailyDouble.getValueB() || dailyDouble.getCounter() == dailyDouble.getValueC())
                        
                        {
                        
                           clueTextDD.setText(clueText.getText());
                           
                           window.setScene(dailyDoubleScene1);
                        
                        }
                        
                     else
                        
                        {
                        
                        window.setScene(clueScene);
                        
                        }
                        
                      categoryB100.setDisable(true);
                     
                      categoryB100.setText("        ");
                  
                  });
                  
               categoryB200.setOnAction( e ->  
                  
                  {
                  
                     dailyDouble.plusCounter();
                     
                     System.out.println("The daily double counter is currently at " + dailyDouble.getCounter() + ".");
                     
                     clueText.setText("Put the text for the clue here.\nYou got here from categoryB200.");
                     
                     if (dailyDouble.getCounter() == dailyDouble.getValueA() || dailyDouble.getCounter() == dailyDouble.getValueB() || dailyDouble.getCounter() == dailyDouble.getValueC())
                        
                        {
                        
                           clueTextDD.setText(clueText.getText());
                           
                           window.setScene(dailyDoubleScene1);
                        
                        }
                        
                     else
                        
                        {
                        
                        window.setScene(clueScene);
                        
                        }
                     
                     categoryB200.setDisable(true);
                     
                     categoryB200.setText("        ");
                  
                  });
                  
               categoryB300.setOnAction( e ->  
                  
                  {
                  
                     dailyDouble.plusCounter();
                     
                     System.out.println("The daily double counter is currently at " + dailyDouble.getCounter() + ".");
                     
                     clueText.setText("Put the text for the clue here.\nYou got here from categoryB300.");
                     
                     if (dailyDouble.getCounter() == dailyDouble.getValueA() || dailyDouble.getCounter() == dailyDouble.getValueB() || dailyDouble.getCounter() == dailyDouble.getValueC())
                        
                        {
                        
                           clueTextDD.setText(clueText.getText());
                           
                           window.setScene(dailyDoubleScene1);
                        
                        }
                        
                     else
                        
                        {
                        
                        window.setScene(clueScene);
                        
                        }
                     
                     categoryB300.setDisable(true);
                     
                     categoryB300.setText("        ");
                  
                  });
                  
               categoryB400.setOnAction( e ->  
                  
                  {
                  
                     dailyDouble.plusCounter();
                     
                     System.out.println("The daily double counter is currently at " + dailyDouble.getCounter() + ".");
                     
                     clueText.setText("Put the text for the clue here.\nYou got here from categoryB400.");
                     
                     if (dailyDouble.getCounter() == dailyDouble.getValueA() || dailyDouble.getCounter() == dailyDouble.getValueB() || dailyDouble.getCounter() == dailyDouble.getValueC())
                        
                        {
                        
                           clueTextDD.setText(clueText.getText());
                           
                           window.setScene(dailyDoubleScene1);
                        
                        }
                        
                     else
                        
                        {
                        
                        window.setScene(clueScene);
                        
                        }
                     
                     categoryB400.setDisable(true);
                     
                     categoryB400.setText("        ");
                  
                  });
                  
               categoryB500.setOnAction( e ->  
                  
                  {
                  
                     dailyDouble.plusCounter();
                     
                     System.out.println("The daily double counter is currently at " + dailyDouble.getCounter() + ".");
                     
                     clueText.setText("Put the text for the clue here.\nYou got here from categoryB500.");
                     
                     if (dailyDouble.getCounter() == dailyDouble.getValueA() || dailyDouble.getCounter() == dailyDouble.getValueB() || dailyDouble.getCounter() == dailyDouble.getValueC())
                        
                        {
                        
                           clueTextDD.setText(clueText.getText());
                           
                           window.setScene(dailyDoubleScene1);
                        
                        }
                        
                     else
                        
                        {
                        
                        window.setScene(clueScene);
                        
                        }
                     
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
                  
                     dailyDouble.plusCounter();
                     
                     System.out.println("The daily double counter is currently at " + dailyDouble.getCounter() + ".");
                     
                     clueText.setText("Put the text for the clue here.\nYou got here from categoryC100.");
                     
                     if (dailyDouble.getCounter() == dailyDouble.getValueA() || dailyDouble.getCounter() == dailyDouble.getValueB() || dailyDouble.getCounter() == dailyDouble.getValueC())
                        
                        {
                        
                           clueTextDD.setText(clueText.getText());
                           
                           window.setScene(dailyDoubleScene1);
                        
                        }
                        
                     else
                        
                        {
                        
                        window.setScene(clueScene);
                        
                        }
                        
                      categoryC100.setDisable(true);
                     
                      categoryC100.setText("        ");
                  
                  });
                  
               categoryC200.setOnAction( e ->  
                  
                  {
                  
                     dailyDouble.plusCounter();
                     
                     System.out.println("The daily double counter is currently at " + dailyDouble.getCounter() + ".");
                     
                     clueText.setText("Put the text for the clue here.\nYou got here from categoryC200.");
                     
                     if (dailyDouble.getCounter() == dailyDouble.getValueA() || dailyDouble.getCounter() == dailyDouble.getValueB() || dailyDouble.getCounter() == dailyDouble.getValueC())
                        
                        {
                        
                           clueTextDD.setText(clueText.getText());
                           
                           window.setScene(dailyDoubleScene1);
                        
                        }
                        
                     else
                        
                        {
                        
                        window.setScene(clueScene);
                        
                        }
                     
                     categoryC200.setDisable(true);
                     
                     categoryC200.setText("        ");
                  
                  });
                  
               categoryC300.setOnAction( e ->  
                  
                  {
                  
                     dailyDouble.plusCounter();
                     
                     System.out.println("The daily double counter is currently at " + dailyDouble.getCounter() + ".");
                     
                     clueText.setText("Put the text for the clue here.\nYou got here from categoryC300.");
                     
                     if (dailyDouble.getCounter() == dailyDouble.getValueA() || dailyDouble.getCounter() == dailyDouble.getValueB() || dailyDouble.getCounter() == dailyDouble.getValueC())
                        
                        {
                        
                           clueTextDD.setText(clueText.getText());
                           
                           window.setScene(dailyDoubleScene1);
                        
                        }
                        
                     else
                        
                        {
                        
                        window.setScene(clueScene);
                        
                        }
                     
                     categoryC300.setDisable(true);
                     
                     categoryC300.setText("        ");
                  
                  });
                  
               categoryC400.setOnAction( e ->  
                  
                  {
                  
                     dailyDouble.plusCounter();
                     
                     System.out.println("The daily double counter is currently at " + dailyDouble.getCounter() + ".");
                     
                     clueText.setText("Put the text for the clue here.\nYou got here from categoryC400.");
                     
                     if (dailyDouble.getCounter() == dailyDouble.getValueA() || dailyDouble.getCounter() == dailyDouble.getValueB() || dailyDouble.getCounter() == dailyDouble.getValueC())
                        
                        {
                        
                           clueTextDD.setText(clueText.getText());
                           
                           window.setScene(dailyDoubleScene1);
                        
                        }
                        
                     else
                        
                        {
                        
                        window.setScene(clueScene);
                        
                        }
                     
                     categoryC400.setDisable(true);
                     
                     categoryC400.setText("        ");
                  
                  });
                  
               categoryC500.setOnAction( e ->  
                  
                  {
                  
                     dailyDouble.plusCounter();
                     
                     System.out.println("The daily double counter is currently at " + dailyDouble.getCounter() + ".");
                     
                     clueText.setText("Put the text for the clue here.\nYou got here from categoryC500.");
                     
                     if (dailyDouble.getCounter() == dailyDouble.getValueA() || dailyDouble.getCounter() == dailyDouble.getValueB() || dailyDouble.getCounter() == dailyDouble.getValueC())
                        
                        {
                        
                           clueTextDD.setText(clueText.getText());
                           
                           window.setScene(dailyDoubleScene1);
                        
                        }
                        
                     else
                        
                        {
                        
                        window.setScene(clueScene);
                        
                        }
                     
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
                  
                     dailyDouble.plusCounter();
                     
                     System.out.println("The daily double counter is currently at " + dailyDouble.getCounter() + ".");
                     
                     clueText.setText("Put the text for the clue here.\nYou got here from categoryD100.");
                     
                     if (dailyDouble.getCounter() == dailyDouble.getValueA() || dailyDouble.getCounter() == dailyDouble.getValueB() || dailyDouble.getCounter() == dailyDouble.getValueC())
                        
                        {
                        
                           clueTextDD.setText(clueText.getText());
                           
                           window.setScene(dailyDoubleScene1);
                        
                        }
                        
                     else
                        
                        {
                        
                        window.setScene(clueScene);
                        
                        }
                        
                      categoryD100.setDisable(true);
                     
                      categoryD100.setText("        ");
                  
                  });
                  
               categoryD200.setOnAction( e ->  
                  
                  {
                  
                     dailyDouble.plusCounter();
                     
                     System.out.println("The daily double counter is currently at " + dailyDouble.getCounter() + ".");
                     
                     clueText.setText("Put the text for the clue here.\nYou got here from categoryD200.");
                     
                     if (dailyDouble.getCounter() == dailyDouble.getValueA() || dailyDouble.getCounter() == dailyDouble.getValueB() || dailyDouble.getCounter() == dailyDouble.getValueC())
                        
                        {
                        
                           clueTextDD.setText(clueText.getText());
                           
                           window.setScene(dailyDoubleScene1);
                        
                        }
                        
                     else
                        
                        {
                        
                        window.setScene(clueScene);
                        
                        }
                     
                     categoryD200.setDisable(true);
                     
                     categoryD200.setText("        ");
                  
                  });
                  
               categoryD300.setOnAction( e ->  
                  
                  {
                  
                     dailyDouble.plusCounter();
                     
                     System.out.println("The daily double counter is currently at " + dailyDouble.getCounter() + ".");
                     
                     clueText.setText("Put the text for the clue here.\nYou got here from categoryD300.");
                     
                     if (dailyDouble.getCounter() == dailyDouble.getValueA() || dailyDouble.getCounter() == dailyDouble.getValueB() || dailyDouble.getCounter() == dailyDouble.getValueC())
                        
                        {
                        
                           clueTextDD.setText(clueText.getText());
                           
                           window.setScene(dailyDoubleScene1);
                        
                        }
                        
                     else
                        
                        {
                        
                        window.setScene(clueScene);
                        
                        }
                     
                     categoryD300.setDisable(true);
                     
                     categoryD300.setText("        ");
                  
                  });
                  
               categoryD400.setOnAction( e ->  
                  
                  {
                  
                     dailyDouble.plusCounter();
                     
                     System.out.println("The daily double counter is currently at " + dailyDouble.getCounter() + ".");
                     
                     clueText.setText("Put the text for the clue here.\nYou got here from categoryD400.");
                     
                     if (dailyDouble.getCounter() == dailyDouble.getValueA() || dailyDouble.getCounter() == dailyDouble.getValueB() || dailyDouble.getCounter() == dailyDouble.getValueC())
                        
                        {
                        
                           clueTextDD.setText(clueText.getText());
                           
                           window.setScene(dailyDoubleScene1);
                        
                        }
                        
                     else
                        
                        {
                        
                        window.setScene(clueScene);
                        
                        }
                     
                     categoryD400.setDisable(true);
                     
                     categoryD400.setText("        ");
                  
                  });
                  
               categoryD500.setOnAction( e ->  
                  
                  {
                  
                     dailyDouble.plusCounter();
                     
                     System.out.println("The daily double counter is currently at " + dailyDouble.getCounter() + ".");
                     
                     clueText.setText("Put the text for the clue here.\nYou got here from categoryD500.");
                     
                     if (dailyDouble.getCounter() == dailyDouble.getValueA() || dailyDouble.getCounter() == dailyDouble.getValueB() || dailyDouble.getCounter() == dailyDouble.getValueC())
                        
                        {
                        
                           clueTextDD.setText(clueText.getText());
                           
                           window.setScene(dailyDoubleScene1);
                        
                        }
                        
                     else
                        
                        {
                        
                        window.setScene(clueScene);
                        
                        }
                     
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
                  
                     dailyDouble.plusCounter();
                     
                     System.out.println("The daily double counter is currently at " + dailyDouble.getCounter() + ".");
                     
                     clueText.setText("Put the text for the clue here.\nYou got here from categoryE100.");
                     
                     if (dailyDouble.getCounter() == dailyDouble.getValueA() || dailyDouble.getCounter() == dailyDouble.getValueB() || dailyDouble.getCounter() == dailyDouble.getValueC())
                        
                        {
                        
                           clueTextDD.setText(clueText.getText());
                           
                           window.setScene(dailyDoubleScene1);
                        
                        }
                        
                     else
                        
                        {
                        
                        window.setScene(clueScene);
                        
                        }
                        
                      categoryE100.setDisable(true);
                     
                      categoryE100.setText("        ");
                  
                  });
                  
               categoryE200.setOnAction( e ->  
                  
                  {
                  
                     dailyDouble.plusCounter();
                     
                     System.out.println("The daily double counter is currently at " + dailyDouble.getCounter() + ".");
                     
                     clueText.setText("Put the text for the clue here.\nYou got here from categoryE200.");
                     
                     if (dailyDouble.getCounter() == dailyDouble.getValueA() || dailyDouble.getCounter() == dailyDouble.getValueB() || dailyDouble.getCounter() == dailyDouble.getValueC())
                        
                        {
                        
                           clueTextDD.setText(clueText.getText());
                           
                           window.setScene(dailyDoubleScene1);
                        
                        }
                        
                     else
                        
                        {
                        
                        window.setScene(clueScene);
                        
                        }
                     
                     categoryE200.setDisable(true);
                     
                     categoryE200.setText("        ");
                  
                  });
                  
               categoryE300.setOnAction( e ->  
                  
                  {
                  
                     dailyDouble.plusCounter();
                     
                     System.out.println("The daily double counter is currently at " + dailyDouble.getCounter() + ".");
                     
                     clueText.setText("Put the text for the clue here.\nYou got here from categoryE300.");
                     
                     if (dailyDouble.getCounter() == dailyDouble.getValueA() || dailyDouble.getCounter() == dailyDouble.getValueB() || dailyDouble.getCounter() == dailyDouble.getValueC())
                        
                        {
                        
                           clueTextDD.setText(clueText.getText());
                           
                           window.setScene(dailyDoubleScene1);
                        
                        }
                        
                     else
                        
                        {
                        
                        window.setScene(clueScene);
                        
                        }
                     
                     categoryE300.setDisable(true);
                     
                     categoryE300.setText("        ");
                  
                  });
                  
               categoryE400.setOnAction( e ->  
                  
                  {
                  
                     dailyDouble.plusCounter();
                     
                     System.out.println("The daily double counter is currently at " + dailyDouble.getCounter() + ".");
                     
                     clueText.setText("Put the text for the clue here.\nYou got here from categoryE400.");
                     
                     if (dailyDouble.getCounter() == dailyDouble.getValueA() || dailyDouble.getCounter() == dailyDouble.getValueB() || dailyDouble.getCounter() == dailyDouble.getValueC())
                        
                        {
                        
                           clueTextDD.setText(clueText.getText());
                           
                           window.setScene(dailyDoubleScene1);
                        
                        }
                        
                     else
                        
                        {
                        
                        window.setScene(clueScene);
                        
                        }
                     
                     categoryE400.setDisable(true);
                     
                     categoryE400.setText("        ");
                  
                  });
                  
               categoryE500.setOnAction( e ->  
                  
                  {
                  
                     dailyDouble.plusCounter();
                     
                     System.out.println("The daily double counter is currently at " + dailyDouble.getCounter() + ".");
                     
                     clueText.setText("Put the text for the clue here.\nYou got here from categoryE500.");
                     
                     if (dailyDouble.getCounter() == dailyDouble.getValueA() || dailyDouble.getCounter() == dailyDouble.getValueB() || dailyDouble.getCounter() == dailyDouble.getValueC())
                        
                        {
                        
                           clueTextDD.setText(clueText.getText());
                           
                           window.setScene(dailyDoubleScene1);
                        
                        }
                        
                     else
                        
                        {
                        
                        window.setScene(clueScene);
                        
                        }
                     
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
                  
                     dailyDouble.plusCounter();
                     
                     System.out.println("The daily double counter is currently at " + dailyDouble.getCounter() + ".");
                     
                     clueText.setText("Put the text for the clue here.\nYou got here from categoryF100.");
                     
                     if (dailyDouble.getCounter() == dailyDouble.getValueA() || dailyDouble.getCounter() == dailyDouble.getValueB() || dailyDouble.getCounter() == dailyDouble.getValueC())
                        
                        {
                        
                           clueTextDD.setText(clueText.getText());
                           
                           window.setScene(dailyDoubleScene1);
                        
                        }
                        
                     else
                        
                        {
                        
                        window.setScene(clueScene);
                        
                        }
                        
                      categoryF100.setDisable(true);
                     
                      categoryF100.setText("        ");
                  
                  });
                  
               categoryF200.setOnAction( e ->  
                  
                  {
                  
                     dailyDouble.plusCounter();
                     
                     System.out.println("The daily double counter is currently at " + dailyDouble.getCounter() + ".");
                     
                     clueText.setText("Put the text for the clue here.\nYou got here from categoryF200.");
                     
                     if (dailyDouble.getCounter() == dailyDouble.getValueA() || dailyDouble.getCounter() == dailyDouble.getValueB() || dailyDouble.getCounter() == dailyDouble.getValueC())
                        
                        {
                        
                           clueTextDD.setText(clueText.getText());
                           
                           window.setScene(dailyDoubleScene1);
                        
                        }
                        
                     else
                        
                        {
                        
                        window.setScene(clueScene);
                        
                        }
                     
                     categoryF200.setDisable(true);
                     
                     categoryF200.setText("        ");
                  
                  });
                  
               categoryF300.setOnAction( e ->  
                  
                  {
                  
                     dailyDouble.plusCounter();
                     
                     System.out.println("The daily double counter is currently at " + dailyDouble.getCounter() + ".");
                     
                     clueText.setText("Put the text for the clue here.\nYou got here from categoryF300.");
                     
                     if (dailyDouble.getCounter() == dailyDouble.getValueA() || dailyDouble.getCounter() == dailyDouble.getValueB() || dailyDouble.getCounter() == dailyDouble.getValueC())
                        
                        {
                        
                           clueTextDD.setText(clueText.getText());
                           
                           window.setScene(dailyDoubleScene1);
                        
                        }
                        
                     else
                        
                        {
                        
                        window.setScene(clueScene);
                        
                        }
                     
                     categoryF300.setDisable(true);
                     
                     categoryF300.setText("        ");
                  
                  });
                  
               categoryF400.setOnAction( e ->  
                  
                  {
                  
                     dailyDouble.plusCounter();
                     
                     System.out.println("The daily double counter is currently at " + dailyDouble.getCounter() + ".");
                     
                     clueText.setText("Put the text for the clue here.\nYou got here from categoryF400.");
                     
                     if (dailyDouble.getCounter() == dailyDouble.getValueA() || dailyDouble.getCounter() == dailyDouble.getValueB() || dailyDouble.getCounter() == dailyDouble.getValueC())
                        
                        {
                        
                           clueTextDD.setText(clueText.getText());
                           
                           window.setScene(dailyDoubleScene1);
                        
                        }
                        
                     else
                        
                        {
                        
                        window.setScene(clueScene);
                        
                        }
                     
                     categoryF400.setDisable(true);
                     
                     categoryF400.setText("        ");
                  
                  });
                  
               categoryF500.setOnAction( e ->  
                  
                  {
                  
                     dailyDouble.plusCounter();
                     
                     System.out.println("The daily double counter is currently at " + dailyDouble.getCounter() + ".");
                     
                     clueText.setText("Put the text for the clue here.\nYou got here from categoryF500.");
                     
                     if (dailyDouble.getCounter() == dailyDouble.getValueA() || dailyDouble.getCounter() == dailyDouble.getValueB() || dailyDouble.getCounter() == dailyDouble.getValueC())
                        
                        {
                        
                           clueTextDD.setText(clueText.getText());
                           
                           window.setScene(dailyDoubleScene1);
                        
                        }
                        
                     else
                        
                        {
                        
                        window.setScene(clueScene);
                        
                        }
                     
                     categoryF500.setDisable(true);
                     
                     categoryF500.setText("        ");
                  
                  });
                  
            ///////////////// End of Button Programming.
                  
               
         }
         
     
         
   }
