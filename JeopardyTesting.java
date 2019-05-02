import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
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
            
                  Button categoryAInfo = new Button("Category\n A".toUpperCase()); 
                  
                  Button categoryA100 = new Button("100");
                  
                  Button categoryA200 = new Button("200");
                  
                  Button categoryA300 = new Button("300");
                  
                  Button categoryA400 = new Button("400");
                  
                  Button categoryA500 = new Button("500");
                  
               
               // Category B
               
                  Button categoryBInfo = new Button("Category\n B".toUpperCase()); 
                  
                  Button categoryB100 = new Button("100");
                  
                  Button categoryB200 = new Button("200");
                  
                  Button categoryB300 = new Button("300");
                  
                  Button categoryB400 = new Button("400");
                  
                  Button categoryB500 = new Button("500");
               
                           
               
               // Category C
               
                  Button categoryCInfo = new Button("Category\n C".toUpperCase()); 
                  
                  Button categoryC100 = new Button("100");
                  
                  Button categoryC200 = new Button("200");
                  
                  Button categoryC300 = new Button("300");
                  
                  Button categoryC400 = new Button("400");
                  
                  Button categoryC500 = new Button("500");
               
                           
               // Category D
               
                  Button categoryDInfo = new Button("Category\n D".toUpperCase()); 
                  
                  Button categoryD100 = new Button("100");
                  
                  Button categoryD200 = new Button("200");
                  
                  Button categoryD300 = new Button("300");
                  
                  Button categoryD400 = new Button("400");
                  
                  Button categoryD500 = new Button("500");
               
                          
               // Category E 
               
                  Button categoryEInfo = new Button("Category\n E".toUpperCase()); 
                  
                  Button categoryE100 = new Button("100");
                  
                  Button categoryE200 = new Button("200");
                  
                  Button categoryE300 = new Button("300");
                  
                  Button categoryE400 = new Button("400");
                  
                  Button categoryE500 = new Button("500");
                  
                           
               // Category F
               
                  Button categoryFInfo = new Button("Category\n F".toUpperCase()); 
                  
                  Button categoryF100 = new Button("100");
                  
                  Button categoryF200 = new Button("200");
                  
                  Button categoryF300 = new Button("300");
                  
                  Button categoryF400 = new Button("400");
                  
                  Button categoryF500 = new Button("500");
            
            
            ////////////////// End of Gameboard Button Creation
            
            ///
            
            ////////////////// Start of Gameboard Setup
            
            
               GridPane gameboard = new GridPane();
               
               gameboard.setAlignment(Pos.CENTER);
               
               gameboard.setHgap(5);
               
               gameboard.setVgap(5);
               
               //gameboard.setPadding(new Insets(10));
               
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
                        
                     ///   Testing Buttons. This will get commented out on the final version. These where used to directly access the daily double and final jeopardy scenes.
                        
                        Button dailyDoubleTestButton = new Button("Daily Double Test");   // This button will eventually get deleted
                        
                        Button finalJeopardyTestButton = new Button("Final Jeopardy Test");
                        
                        HBox testingHBox = new HBox(10, dailyDoubleTestButton, finalJeopardyTestButton);
               
                        //gameboardBorderPane.setCenter(gameboard);
                        
                        gameboardBorderPane.setBottom(testingHBox); // This line of code will eventually get deleted
               
               //////////////////   End of adding Gameboard Buttons to the Gameboard Gridpane
               
               /////////   Scoreboard creation
                  
                  Label player1ScoreLabel = new Label("Player 1:\n" + player1.getScore());
                  
                  Label player2ScoreLabel = new Label("Player 2:\n" + player2.getScore());
                  
                  Label player3ScoreLabel = new Label("Player 3:\n" + player3.getScore());
                  
                  Label gameboardTurnTrackerLabel = new Label("Player 1 \nControls The Board");
                     
                  gameboardTurnTrackerLabel.setStyle(" -fx-font-size: 30pt; -fx-text-fill: gold;");
                  
                  HBox scoreboard = new HBox (325, player1ScoreLabel, player2ScoreLabel, player3ScoreLabel);
                  
                  VBox gameboardVBox = new VBox(50, gameboard, scoreboard, gameboardTurnTrackerLabel);
                  
                  gameboardVBox.setAlignment(Pos.CENTER);
                  
                  scoreboard.setAlignment(Pos.CENTER);
                  
                  gameboardBorderPane.setCenter(gameboardVBox);
                  
                  
               //////////////////   Start of Scene Creation
                  
                  /////////   Main Gameboard Scene
                  
                     Scene gameboardScene = new Scene(gameboardBorderPane, 1920, 980, Color.BLUE);  // scene for the gameboard
                     
                     gameboardScene.getStylesheets().add("gameboard.css"); 
                     
                     window.setScene(gameboardScene);
                     
                     window.setTitle("Jeopardy!");
                     
                     window.show();
                     
                  /////////   Category Info Scene
                  
                     BorderPane categoryInfoBorderPane = new BorderPane();
                     
                     Button categoryBack = new Button ("Back");            
            
                     Label categoryText = new Label("If you are seeing this either the getText method isn't being used or this is still being tested.");
            
                     categoryInfoBorderPane.setCenter(categoryText);
                     
                     categoryInfoBorderPane.setBottom(categoryBack);
                                 
                     Scene categoryInfoScene = new Scene(categoryInfoBorderPane, 1920, 980);
                     
                     categoryInfoScene.getStylesheets().add("gameboard.css");
                  
                  /////////   Clue Scene
                  
                     Label clueText = new Label("Put the text for the clue here.".toUpperCase());
                     
                     Button answerA = new Button("A: Answer A".toUpperCase());
                     
                     Button answerB = new Button("B: Answer B".toUpperCase());
                     
                     Button answerX = new Button("X: Answer X".toUpperCase());
                     
                     Button answerY = new Button("Y: Answer Y".toUpperCase());
                     
                     Button clueBackButton = new Button("Back");
                     
                     GridPane clueGridPane = new GridPane();
                     
                     Label clueTurnTrackerLabel = new Label("Player 1 \nControls The Board");
                     
                     clueTurnTrackerLabel.setStyle(" -fx-font-size: 30pt; -fx-text-fill: gold;");
                     
                     clueGridPane.add(answerA, 0, 0);
                     
                     clueGridPane.add(answerB, 1, 0);
                     
                     clueGridPane.add(answerX, 0, 1);
                     
                     clueGridPane.add(answerY, 1, 1);
                     
                     clueGridPane.setHgap(5);
                     
                     clueGridPane.setVgap(5);
                     
                     VBox clueSceneVBox = new VBox(clueText, clueGridPane, clueTurnTrackerLabel, clueBackButton);
                     
                     BorderPane clueSceneBorderPane = new BorderPane();
                     
                     clueGridPane.setAlignment(Pos.BOTTOM_CENTER);
                     
                     clueSceneVBox.setAlignment(Pos.CENTER);
                     
                     clueSceneBorderPane.setBottom(clueBackButton);
                     
                     clueSceneBorderPane.setCenter(clueSceneVBox);
                     
                     Scene clueScene = new Scene(clueSceneBorderPane, 1920, 980);
                     
                     clueScene.getStylesheets().add("Clue.css");
                     
                  /////////   Daily Double Scenes. ONE Daily Double in Regular Jeopardy, TWO Daily Doubles in Double Jeopardy.
                  
                     //////   Daily Double Scene 1
                           
                        Label dailyDoubleScene1Label = new Label("DAILY \nDOUBLE");
                        
                        Button dailyDoubleScene1Button = new Button ("Next");
                        
                        VBox dailyDoubleScene1VBox = new VBox(dailyDoubleScene1Label,dailyDoubleScene1Button);
                        
                        dailyDoubleScene1VBox.setAlignment(Pos.CENTER);
                        
                        BorderPane dailyDoubleScene1BorderPane = new BorderPane();
                        
                        dailyDoubleScene1BorderPane.setCenter(dailyDoubleScene1VBox);
                        
                        Scene dailyDoubleScene1 = new Scene(dailyDoubleScene1BorderPane, 1920, 980);
                        
                        dailyDoubleScene1.getStylesheets().add("DDFJSplash.css");
                        
                     //////   Daily Double Scene 2
                     
                        ///   This scene is used for the player to enter their wager during the daily double. As of 4/26/2019, the highest daily double wager was $25,000 which was set on April 9th, 2018. Because of this, we maxed out the bet at $25,001.
                     
                        Label dailyDoubleScene2Label = new Label("How much would you like to wager? \nAll wagers must be equal to or \nless than your current score. \nIf your wager is too high, it will be changed to your score. \nIf your score is negative, your wager \nwill be set to the regular value for the question.");
               
                        Label dailyDoubleWagerLabel = new Label("Wager: 0");
                        
                        Button dailyDoubleWager1 = new Button ("1");
                        
                        Button dailyDoubleWager2 = new Button ("2");
                        
                        Button dailyDoubleWager3 = new Button ("3");
                        
                        Button dailyDoubleWager4 = new Button ("4");
                        
                        Button dailyDoubleWager5 = new Button ("5");
                        
                        Button dailyDoubleWager6 = new Button ("6");
                        
                        Button dailyDoubleWager7 = new Button ("7");
                        
                        Button dailyDoubleWager8 = new Button ("8");
                        
                        Button dailyDoubleWager9 = new Button ("9");
                        
                        Button dailyDoubleWager0 = new Button ("0");
                        
                        Button dailyDoubleWagerEnterButton = new Button("Enter");
                        
                        Button dailyDoubleWagerClearButton = new Button("Clear");
                        
                        GridPane dailyDoubleWagerGridPane = new GridPane();
                        
                        dailyDoubleWagerGridPane.setHgap(5);
                        
                        dailyDoubleWagerGridPane.setVgap(5);
                        
                        dailyDoubleWagerGridPane.setAlignment(Pos.CENTER);
                        
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
                        
                        dailyDoubleScene2VBox.setAlignment(Pos.CENTER);
                        
                        BorderPane dailyDoubleScene2BorderPane = new BorderPane();
                        
                        dailyDoubleScene2BorderPane.setCenter(dailyDoubleScene2VBox);
                        
                        Scene dailyDoubleScene2 = new Scene(dailyDoubleScene2BorderPane, 1920, 980);
                        
                        dailyDoubleScene2.getStylesheets().add("gameboard.css");
                        
                        
                     //////   Daily Double Clue Scene
                     
                        Label clueTextDD = new Label("Put the text for the clue here.".toUpperCase());
                     
                        Button answerADD = new Button("A: Answer A".toUpperCase());
                     
                        Button answerBDD = new Button("B: Answer B".toUpperCase());
                     
                        Button answerXDD = new Button("X: Answer X".toUpperCase());
                     
                        Button answerYDD = new Button("Y: Answer Y".toUpperCase());
                     
                        Button clueBackButtonDD = new Button("Back");
                     
                        GridPane clueGridPaneDD = new GridPane();
                        
                        clueGridPaneDD.setAlignment(Pos.CENTER);
                     
                        clueGridPaneDD.add(answerADD, 0, 0);
                     
                        clueGridPaneDD.add(answerBDD, 1, 0);
                     
                        clueGridPaneDD.add(answerXDD, 0, 1);
                     
                        clueGridPaneDD.add(answerYDD, 1, 1);
                        
                        clueGridPaneDD.setHgap(5);
                        
                        clueGridPaneDD.setVgap(5);
                     
                        VBox clueSceneVBoxDD = new VBox(clueTextDD, clueGridPaneDD);
                     
                        BorderPane clueSceneBorderPaneDD = new BorderPane();
                     
                        clueSceneVBoxDD.setAlignment(Pos.CENTER);
                     
                        clueGridPaneDD.setAlignment(Pos.CENTER);
                     
                        clueSceneBorderPaneDD.setBottom(clueBackButtonDD);
                     
                        clueSceneBorderPaneDD.setCenter(clueSceneVBoxDD);
                     
                        Scene dailyDoubleClueScene = new Scene(clueSceneBorderPaneDD, 1920, 980);
                        
                        dailyDoubleClueScene.getStylesheets().add("Clue.css");
                  
                  /////////   Final Jeopardy Scenes
                     
                     //////   FJ Scene 1
                           
                        Label finalJeopardyScene1Label = new Label("Final \nJeopardy".toUpperCase());
                        
                        Button finalJeopardyScene1Button = new Button ("Next");
                        
                        VBox finalJeopardyScene1VBox = new VBox(finalJeopardyScene1Label, finalJeopardyScene1Button);
                        
                        finalJeopardyScene1VBox.setAlignment(Pos.CENTER);
                        
                        BorderPane finalJeopardyScene1BorderPane = new BorderPane();
                        
                        finalJeopardyScene1BorderPane.setCenter(finalJeopardyScene1VBox);
                        
                        Scene finalJeopardyScene1 = new Scene(finalJeopardyScene1BorderPane, 1920, 980);
                        
                        finalJeopardyScene1.getStylesheets().add("DDFJSplash.css");
                        
                     //////   FJ Scene 2 
                     
                        Label finalJeopardyScene2Label = new Label("How much would you like to wager? \nThe minimum wager is 5. \nThe max is equal to either your point total or 60,014, whichever one is lower.");
               
                        Label finalJeopardyWagerLabel = new Label("Player 1 Wager: 0");
                        
                        Button finalJeopardyWager1 = new Button ("1");
                        
                        Button finalJeopardyWager2 = new Button ("2");
                        
                        Button finalJeopardyWager3 = new Button ("3");
                        
                        Button finalJeopardyWager4 = new Button ("4");
                        
                        Button finalJeopardyWager5 = new Button ("5");
                        
                        Button finalJeopardyWager6 = new Button ("6");
                        
                        Button finalJeopardyWager7 = new Button ("7");
                        
                        Button finalJeopardyWager8 = new Button ("8");
                        
                        Button finalJeopardyWager9 = new Button ("9");
                        
                        Button finalJeopardyWager0 = new Button ("0");
                        
                        Button finalJeopardyWagerEnterButton = new Button("Enter");
                        
                        Button finalJeopardyWagerClearButton = new Button("Clear");
                        
                        GridPane finalJeopardyWagerGridPane = new GridPane();
                        
                        finalJeopardyWagerGridPane.setHgap(5);
                        
                        finalJeopardyWagerGridPane.setVgap(5);
                        
                        finalJeopardyWagerGridPane.setAlignment(Pos.CENTER);
                        
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
                        
                        finalJeopardyScene2VBox.setAlignment(Pos.CENTER); 
                        
                        BorderPane finalJeopardyScene2BorderPane = new BorderPane();
                        
                        finalJeopardyScene2BorderPane.setCenter(finalJeopardyScene2VBox);
                        
                        Scene finalJeopardyScene2 = new Scene(finalJeopardyScene2BorderPane, 1920, 980);
                        
                        finalJeopardyScene2.getStylesheets().add("gameboard.css");
                        
                  // FJ Category Scene
                                                
                        Label finalJeopardyCategorySceneLabel = new Label("Final Jeopardy Category: \n“Noble Words of Westeros” \nGame of Thrones \nNoble House Mottos".toUpperCase());
                        
                        Button finalJeopardyCategorySceneButton = new Button ("Next");
                        
                        VBox finalJeopardyCategorySceneVBox = new VBox(finalJeopardyCategorySceneLabel,finalJeopardyCategorySceneButton);
                        
                        finalJeopardyCategorySceneVBox.setAlignment(Pos.CENTER);
                        
                        BorderPane finalJeopardyCategorySceneBorderPane = new BorderPane();
                        
                        finalJeopardyCategorySceneBorderPane.setCenter(finalJeopardyCategorySceneVBox);
                        
                        Scene finalJeopardyCategoryScene = new Scene(finalJeopardyCategorySceneBorderPane, 1920, 980);
                        
                        finalJeopardyCategoryScene.getStylesheets().add("FJCatScene.css");
                        
                  // FJ Clue Scene
                  
                        Label clueTextFJ = new Label("Here Me Roar!".toUpperCase());
                     
                        Button answerAFJ = new Button("House Targaryen".toUpperCase());
                     
                        Button answerBFJ = new Button("House Lannister".toUpperCase());
                     
                        Button answerXFJ = new Button("House Umber".toUpperCase());
                     
                        Button answerYFJ = new Button("House Royce".toUpperCase());
                        
                        dailyDouble.setAnswerInt(1);
                        
                        GridPane clueGridPaneFJ = new GridPane();
                        
                        clueGridPaneFJ.setHgap(5);
                        
                        clueGridPaneFJ.setVgap(5);
                        
                        clueGridPaneFJ.setAlignment(Pos.CENTER);
                     
                        clueGridPaneFJ.add(answerAFJ, 0, 0);
                     
                        clueGridPaneFJ.add(answerBFJ, 1, 0);
                     
                        clueGridPaneFJ.add(answerXFJ, 0, 1);
                     
                        clueGridPaneFJ.add(answerYFJ, 1, 1);
                     
                        VBox clueSceneVBoxFJ = new VBox(clueTextFJ, clueGridPaneFJ);
                     
                        BorderPane clueSceneBorderPaneFJ = new BorderPane();
                     
                        clueSceneVBoxFJ.setAlignment(Pos.CENTER);
                     
                        clueGridPaneFJ.setAlignment(Pos.CENTER);
                     
                        clueSceneBorderPaneFJ.setCenter(clueSceneVBoxFJ);
                     
                        Scene finalJeopardyClueScene = new Scene(clueSceneBorderPaneFJ, 1920, 980);
                        
                        finalJeopardyClueScene.getStylesheets().add("Clue.css");
            
            
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
                                       categoryA100.setText("200");
                                       
                                       categoryA200.setDisable(false);
                                       categoryA200.setText("400");
                                       
                                       categoryA300.setDisable(false);
                                       categoryA300.setText("600");
                                       
                                       categoryA400.setDisable(false);
                                       categoryA400.setText("800");
                                       
                                       categoryA500.setDisable(false);
                                       categoryA500.setText("1000");
                                    
                                    
                                    // Category B
                                    
                                       categoryB100.setDisable(false);
                                       categoryB100.setText("200");
                                       
                                       categoryB200.setDisable(false);
                                       categoryB200.setText("400");
                                       
                                       categoryB300.setDisable(false);
                                       categoryB300.setText("600");
                                       
                                       categoryB400.setDisable(false);
                                       categoryB400.setText("800");
                                       
                                       categoryB500.setDisable(false);
                                       categoryB500.setText("1000");
                                    
                                    
                                    // Category C
                                    
                                       categoryC100.setDisable(false);
                                       categoryC100.setText("200");
                                    
                                       categoryC200.setDisable(false);
                                       categoryC200.setText("400");
                                       
                                       categoryC300.setDisable(false);
                                       categoryC300.setText("600");
                                       
                                       categoryC400.setDisable(false);
                                       categoryC400.setText("800");
                                    
                                       categoryC500.setDisable(false);
                                       categoryC500.setText("1000");
                                       
                                       
                                    // Category D
                                    
                                       categoryD100.setDisable(false);
                                       categoryD100.setText("200");
                                    
                                       categoryD200.setDisable(false);
                                       categoryD200.setText("400");
                                       
                                       categoryD300.setDisable(false);
                                       categoryD300.setText("600");
                                       
                                       categoryD400.setDisable(false);
                                       categoryD400.setText("800");
                                    
                                       categoryD500.setDisable(false);
                                       categoryD500.setText("1000");
                                       
                                       
                                    // Category E
                                    
                                       categoryE100.setDisable(false);
                                       categoryE100.setText("200");
                                    
                                       categoryE200.setDisable(false);
                                       categoryE200.setText("400");
                                       
                                       categoryE300.setDisable(false);
                                       categoryE300.setText("600");
                                       
                                       categoryE400.setDisable(false);
                                       categoryE400.setText("800");
                                    
                                       categoryE500.setDisable(false);
                                       categoryE500.setText("1000");
                                       
                                    
                                    // Category F
                                       
                                       categoryF100.setDisable(false);
                                       categoryF100.setText("200");
                                    
                                       categoryF200.setDisable(false);
                                       categoryF200.setText("400");
                                       
                                       categoryF300.setDisable(false);
                                       categoryF300.setText("600");
                                       
                                       categoryF400.setDisable(false);
                                       categoryF400.setText("800");
                                    
                                       categoryF500.setDisable(false);
                                       categoryF500.setText("1000");
                                       
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
               
               finalJeopardyTestButton.setOnAction ( e ->
                  
                  {
                  
                     dailyDouble.plusGamePhase();
                     
                     dailyDouble.plusGamePhase();
                     
                     window.setScene(finalJeopardyScene1);
                  
                  });
               
               finalJeopardyScene1Button.setOnAction ( e ->
                  
                  {
                  
                     dailyDouble.resetWager();
                     
                     window.setScene(finalJeopardyScene2);
                  
                  });
                  
               finalJeopardyCategorySceneButton.setOnAction ( e ->
                  
                  {
                  
                     window.setScene(finalJeopardyClueScene);
                  
                  });
                  
               // Final Jeopardy Wager Scene Buttons
               
               finalJeopardyWagerEnterButton.setOnAction ( e ->
                  
                  {
                  
                     dailyDouble.plusGamePhase();
                     
                     if (dailyDouble.getGamePhase() == 3)
                     
                        {
                        
                           finalJeopardyWagerLabel.setText("Player 2 Wager: 0");   
                        
                        }
                        
                     if (dailyDouble.getGamePhase() == 4)
                     
                        {
                        
                           finalJeopardyWagerLabel.setText("Player 3 Wager: 0");   
                        
                        }
                        
                     if (dailyDouble.getGamePhase() == 5)
                     
                        {
                           
                           window.setScene(finalJeopardyCategoryScene);   
                        
                        }
                  
                  });
                  
                  
               finalJeopardyWagerClearButton.setOnAction( e ->  
                  
                  {
                  
                     if (dailyDouble.getGamePhase() == 2)
                        
                        {
                           
                           player1.resetWager();
                           
                           finalJeopardyWagerLabel.setText("Player 1 Wager: 0");
                           
                        }
                        
                     if (dailyDouble.getGamePhase() == 3)
                        
                        {
                           
                           player2.resetWager();
                           
                           finalJeopardyWagerLabel.setText("Player 2 Wager: 0");
                           
                        }
                        
                     if (dailyDouble.getGamePhase() == 4)
                        
                        {
                           
                           player3.resetWager();
                           
                           finalJeopardyWagerLabel.setText("Player 3 Wager: 0");
                           
                        }
                     
                    });
                    
                  
               finalJeopardyWager1.setOnAction( e ->  
                  
                  {
                  
                     if (dailyDouble.getGamePhase() == 2)
                        
                        {
                           
                           player1.addDigit(1);
                           
                           finalJeopardyWagerLabel.setText("Player 1 Wager: " + player1.getWagerString());
                           
                        }
                        
                     if (dailyDouble.getGamePhase() == 3)
                        
                        {
                           
                           player2.addDigit(1);
                           
                           finalJeopardyWagerLabel.setText("Player 2 Wager: " + player2.getWagerString());
                           
                        }
                        
                     if (dailyDouble.getGamePhase() == 4)
                        
                        {
                           
                           player3.addDigit(1);
                           
                           finalJeopardyWagerLabel.setText("Player 3 Wager: " + player3.getWagerString());
                           
                        }
                     
                    });
                    
                    
               finalJeopardyWager2.setOnAction( e ->  
               
                  {
                  
                     if (dailyDouble.getGamePhase() == 2)
                        
                        {
                           
                           player1.addDigit(2);
                           
                           finalJeopardyWagerLabel.setText("Player 1 Wager: " + player1.getWagerString());
                           
                        }
                        
                     if (dailyDouble.getGamePhase() == 3)
                        
                        {
                           
                           player2.addDigit(2);
                           
                           finalJeopardyWagerLabel.setText("Player 2 Wager: " + player2.getWagerString());
                           
                        }
                        
                     if (dailyDouble.getGamePhase() == 4)
                        
                        {
                           
                           player3.addDigit(2);
                           
                           finalJeopardyWagerLabel.setText("Player 3 Wager: " + player3.getWagerString());
                           
                        }
                     
                    });
                
                    
               finalJeopardyWager3.setOnAction( e ->  
               
                  {
                  
                     if (dailyDouble.getGamePhase() == 2)
                        
                        {
                           
                           player1.addDigit(3);
                           
                           finalJeopardyWagerLabel.setText("Player 1 Wager: " + player1.getWagerString());
                           
                        }
                        
                     if (dailyDouble.getGamePhase() == 3)
                        
                        {
                           
                           player2.addDigit(3);
                           
                           finalJeopardyWagerLabel.setText("Player 2 Wager: " + player2.getWagerString());
                           
                        }
                        
                     if (dailyDouble.getGamePhase() == 4)
                        
                        {
                           
                           player3.addDigit(3);
                           
                           finalJeopardyWagerLabel.setText("Player 3 Wager: " + player3.getWagerString());
                           
                        }
                     
                    });
                    
                    
               finalJeopardyWager4.setOnAction( e ->  
               
                  {
                  
                     if (dailyDouble.getGamePhase() == 2)
                        
                        {
                           
                           player1.addDigit(4);
                           
                           finalJeopardyWagerLabel.setText("Player 1 Wager: " + player1.getWagerString());
                           
                        }
                        
                     if (dailyDouble.getGamePhase() == 3)
                        
                        {
                           
                           player2.addDigit(4);
                           
                           finalJeopardyWagerLabel.setText("Player 2 Wager: " + player2.getWagerString());
                           
                        }
                        
                     if (dailyDouble.getGamePhase() == 4)
                        
                        {
                           
                           player3.addDigit(4);
                           
                           finalJeopardyWagerLabel.setText("Player 3 Wager: " + player3.getWagerString());
                           
                        }
                     
                    });
                    
                    
               finalJeopardyWager5.setOnAction( e ->  
               
                  {
                  
                     if (dailyDouble.getGamePhase() == 2)
                        
                        {
                           
                           player1.addDigit(5);
                           
                           finalJeopardyWagerLabel.setText("Player 1 Wager: " + player1.getWagerString());
                           
                        }
                        
                     if (dailyDouble.getGamePhase() == 3)
                        
                        {
                           
                           player2.addDigit(5);
                           
                           finalJeopardyWagerLabel.setText("Player 2 Wager: " + player2.getWagerString());
                           
                        }
                        
                     if (dailyDouble.getGamePhase() == 4)
                        
                        {
                           
                           player3.addDigit(5);
                           
                           finalJeopardyWagerLabel.setText("Player 3 Wager: " + player3.getWagerString());
                           
                        }
                     
                    });
                    
                    
               finalJeopardyWager6.setOnAction( e ->  
               
                  {
                  
                     if (dailyDouble.getGamePhase() == 2)
                        
                        {
                           
                           player1.addDigit(6);
                           
                           finalJeopardyWagerLabel.setText("Player 1 Wager: " + player1.getWagerString());
                           
                        }
                        
                     if (dailyDouble.getGamePhase() == 3)
                        
                        {
                           
                           player2.addDigit(6);
                           
                           finalJeopardyWagerLabel.setText("Player 2 Wager: " + player2.getWagerString());
                           
                        }
                        
                     if (dailyDouble.getGamePhase() == 4)
                        
                        {
                           
                           player3.addDigit(6);
                           
                           finalJeopardyWagerLabel.setText("Player 3 Wager: " + player3.getWagerString());
                           
                        }
                     
                    });
                    
                    
               finalJeopardyWager7.setOnAction( e ->  
               
                  {
                  
                     if (dailyDouble.getGamePhase() == 2)
                        
                        {
                           
                           player1.addDigit(7);
                           
                           finalJeopardyWagerLabel.setText("Player 1 Wager: " + player1.getWagerString());
                           
                        }
                        
                     if (dailyDouble.getGamePhase() == 3)
                        
                        {
                           
                           player2.addDigit(7);
                           
                           finalJeopardyWagerLabel.setText("Player 2 Wager: " + player2.getWagerString());
                           
                        }
                        
                     if (dailyDouble.getGamePhase() == 4)
                        
                        {
                           
                           player3.addDigit(7);
                           
                           finalJeopardyWagerLabel.setText("Player 3 Wager: " + player3.getWagerString());
                           
                        }
                     
                    });
                    
                    
               finalJeopardyWager8.setOnAction( e ->  
               
                  {
                  
                     if (dailyDouble.getGamePhase() == 2)
                        
                        {
                           
                           player1.addDigit(8);
                           
                           finalJeopardyWagerLabel.setText("Player 1 Wager: " + player1.getWagerString());
                           
                        }
                        
                     if (dailyDouble.getGamePhase() == 3)
                        
                        {
                           
                           player2.addDigit(8);
                           
                           finalJeopardyWagerLabel.setText("Player 2 Wager: " + player2.getWagerString());
                           
                        }
                        
                     if (dailyDouble.getGamePhase() == 4)
                        
                        {
                           
                           player3.addDigit(8);
                           
                           finalJeopardyWagerLabel.setText("Player 3 Wager: " + player3.getWagerString());
                           
                        }
                     
                    });
                    
                    
               finalJeopardyWager9.setOnAction( e ->  
               
                  {
                  
                     if (dailyDouble.getGamePhase() == 2)
                        
                        {
                           
                           player1.addDigit(9);
                           
                           finalJeopardyWagerLabel.setText("Player 1 Wager: " + player1.getWagerString());
                           
                        }
                        
                     if (dailyDouble.getGamePhase() == 3)
                        
                        {
                           
                           player2.addDigit(9);
                           
                           finalJeopardyWagerLabel.setText("Player 2 Wager: " + player2.getWagerString());
                           
                        }
                        
                     if (dailyDouble.getGamePhase() == 4)
                        
                        {
                           
                           player3.addDigit(9);
                           
                           finalJeopardyWagerLabel.setText("Player 3 Wager: " + player3.getWagerString());
                           
                        }
                     
                    });
                    
                    
               finalJeopardyWager0.setOnAction( e ->  
               
                  {
                  
                     if (dailyDouble.getGamePhase() == 2)
                        
                        {
                           
                           player1.addDigit(0);
                           
                           finalJeopardyWagerLabel.setText("Player 1 Wager: " + player1.getWagerString());
                           
                        }
                        
                     if (dailyDouble.getGamePhase() == 3)
                        
                        {
                           
                           player2.addDigit(0);
                           
                           finalJeopardyWagerLabel.setText("Player 2 Wager: " + player2.getWagerString());
                           
                        }
                        
                     if (dailyDouble.getGamePhase() == 4)
                        
                        {
                           
                           player3.addDigit(0);
                           
                           finalJeopardyWagerLabel.setText("Player 3 Wager: " + player3.getWagerString());
                           
                        }
                     
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
                                       categoryA100.setText("200");
                                       
                                       categoryA200.setDisable(false);
                                       categoryA200.setText("400");
                                       
                                       categoryA300.setDisable(false);
                                       categoryA300.setText("600");
                                       
                                       categoryA400.setDisable(false);
                                       categoryA400.setText("800");
                                       
                                       categoryA500.setDisable(false);
                                       categoryA500.setText("1000");
                                    
                                    
                                    // Category B
                                    
                                       categoryB100.setDisable(false);
                                       categoryB100.setText("200");
                                       
                                       categoryB200.setDisable(false);
                                       categoryB200.setText("400");
                                       
                                       categoryB300.setDisable(false);
                                       categoryB300.setText("600");
                                       
                                       categoryB400.setDisable(false);
                                       categoryB400.setText("800");
                                       
                                       categoryB500.setDisable(false);
                                       categoryB500.setText("1000");
                                    
                                    
                                    // Category C
                                    
                                       categoryC100.setDisable(false);
                                       categoryC100.setText("200");
                                    
                                       categoryC200.setDisable(false);
                                       categoryC200.setText("400");
                                       
                                       categoryC300.setDisable(false);
                                       categoryC300.setText("600");
                                       
                                       categoryC400.setDisable(false);
                                       categoryC400.setText("800");
                                    
                                       categoryC500.setDisable(false);
                                       categoryC500.setText("1000");
                                       
                                       
                                    // Category D
                                    
                                       categoryD100.setDisable(false);
                                       categoryD100.setText("200");
                                    
                                       categoryD200.setDisable(false);
                                       categoryD200.setText("400");
                                       
                                       categoryD300.setDisable(false);
                                       categoryD300.setText("600");
                                       
                                       categoryD400.setDisable(false);
                                       categoryD400.setText("800");
                                    
                                       categoryD500.setDisable(false);
                                       categoryD500.setText("1000");
                                       
                                       
                                    // Category E
                                    
                                       categoryE100.setDisable(false);
                                       categoryE100.setText("200");
                                    
                                       categoryE200.setDisable(false);
                                       categoryE200.setText("400");
                                       
                                       categoryE300.setDisable(false);
                                       categoryE300.setText("600");
                                       
                                       categoryE400.setDisable(false);
                                       categoryE400.setText("800");
                                    
                                       categoryE500.setDisable(false);
                                       categoryE500.setText("1000");
                                       
                                    
                                    // Category F
                                       
                                       categoryF100.setDisable(false);
                                       categoryF100.setText("200");
                                    
                                       categoryF200.setDisable(false);
                                       categoryF200.setText("400");
                                       
                                       categoryF300.setDisable(false);
                                       categoryF300.setText("600");
                                       
                                       categoryF400.setDisable(false);
                                       categoryF400.setText("800");
                                    
                                       categoryF500.setDisable(false);
                                       categoryF500.setText("1000");
                                       
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
                  
                     if (dailyDouble.getTurn() == 0)
                        
                        {
                     
                           dailyDoubleScene2Label.setText(dailyDoubleScene2Label.getText() + "\nPlayer 1 Score: " + player1.getScore());
                     
                        }
                        
                     if (dailyDouble.getTurn() == 1)
                        
                        {
                     
                           dailyDoubleScene2Label.setText(dailyDoubleScene2Label.getText() + "\nPlayer 2 Score: " + player2.getScore());
                     
                        }
                        
                     if (dailyDouble.getTurn() == 2)
                        
                        {
                     
                           dailyDoubleScene2Label.setText(dailyDoubleScene2Label.getText() + "\nPlayer 3 Score: " + player3.getScore());
                     
                        }
                     
                     
                     
                     window.setScene(dailyDoubleScene2);
                     
                     dailyDoubleWagerLabel.setText("Wager: 0");
                     
                     dailyDouble.resetWager();
                     
                     
                  
                  });
            
               dailyDoubleWager1.setOnAction( e ->  
                  
                  {
                  
                     dailyDouble.addDigit(1);
                           
                     dailyDoubleWagerLabel.setText("Wager: " + dailyDouble.getWagerString());
                  
                  });
                  
                  
               dailyDoubleWager2.setOnAction( e ->  
                  
                  {
                  
                     dailyDouble.addDigit(2);
                           
                     dailyDoubleWagerLabel.setText("Wager: " + dailyDouble.getWagerString());

                  
                  });
                  
                  
               dailyDoubleWager3.setOnAction( e ->  
                  
                  {
                  
                     dailyDouble.addDigit(3);
                           
                     dailyDoubleWagerLabel.setText("Wager: " + dailyDouble.getWagerString());
                  
                  });
                  
                  
               dailyDoubleWager4.setOnAction( e ->  
                  
                  {
                  
                     dailyDouble.addDigit(4);
                           
                     dailyDoubleWagerLabel.setText("Wager: " + dailyDouble.getWagerString());

                  
                  });
                  
                  
               dailyDoubleWager5.setOnAction( e ->  
                  
                  {
                  
                     dailyDouble.addDigit(5);
                           
                     dailyDoubleWagerLabel.setText("Wager: " + dailyDouble.getWagerString());   
                  
                  });
                  
                  
               dailyDoubleWager6.setOnAction( e ->  
                  
                  {
                  
                     dailyDouble.addDigit(6);
                           
                     dailyDoubleWagerLabel.setText("Wager: " + dailyDouble.getWagerString());
                  
                  });
                  
                  
               dailyDoubleWager7.setOnAction( e ->  
                  
                  {
                  
                     dailyDouble.addDigit(7);
                           
                     dailyDoubleWagerLabel.setText("Wager: " + dailyDouble.getWagerString());
                  
                  });
                  
                  
               dailyDoubleWager8.setOnAction( e ->  
                  
                  {
                  
                     dailyDouble.addDigit(8);
                           
                     dailyDoubleWagerLabel.setText("Wager: " + dailyDouble.getWagerString());
                  
                  });
                  
                  
               dailyDoubleWager9.setOnAction( e ->  
                  
                  {
                  
                     dailyDouble.addDigit(9);
                           
                     dailyDoubleWagerLabel.setText("Wager: " + dailyDouble.getWagerString());
                  
                  });
                  
                  
               dailyDoubleWager0.setOnAction( e ->  
                  
                  {
                  
                     dailyDouble.addDigit(0);
                           
                     dailyDoubleWagerLabel.setText("Wager: " + dailyDouble.getWagerString());
                  
                  });
                  
               dailyDoubleWagerClearButton.setOnAction( e ->  
                  
                  {
                  
                     dailyDouble.resetWager();  
                     
                     dailyDoubleWagerLabel.setText("Wager: " + dailyDouble.getWagerString()); 
                  
                  });
                  
               
               dailyDoubleWagerEnterButton.setOnAction( e ->  
                  
                  {
                  
                     answerADD.setDisable(false); 
                     
                     answerBDD.setDisable(false);
                     
                     answerXDD.setDisable(false);
                     
                     answerYDD.setDisable(false);
                     
                     if (dailyDouble.getTurn() == 0)  //Handles Player 1
                        
                        {
                        
                           if (dailyDouble.getWager() > 0 && dailyDouble.getWager() <= player1.getScore())
                              
                              {
                              
                                 window.setScene(dailyDoubleClueScene);   
                              
                              }
                              
                           else if(player1.getScore() == dailyDouble.getWager())
                              
                              {
                              
                                 dailyDouble.setWager(player1.getScore());
                                 
                                 window.setScene(dailyDoubleClueScene);
                              
                              }
                           
                           else if (player1.getScore() < 0)
                              
                              {
                              
                                 dailyDouble.setWager(dailyDouble.getCluePoints());
                                 
                                 window.setScene(dailyDoubleClueScene);
                              
                              }
                           
                           else if (player1.getScore() < dailyDouble.getWager())
                              
                              {
                              
                                 dailyDouble.setWager(player1.getScore()); 
                                 
                                 window.setScene(dailyDoubleClueScene);     
                              
                              }
                              
                           
                        
                        }
                        
                     else if (dailyDouble.getTurn() == 1)  //Handles Player 2
                        
                        {
                        
                           if (dailyDouble.getWager() > 0 && dailyDouble.getWager() <= player2.getScore())
                              
                              {
                              
                                 window.setScene(dailyDoubleClueScene);   
                              
                              }
                              
                           else if(player2.getScore() == dailyDouble.getWager())
                              
                              {
                              
                                 dailyDouble.setWager(player2.getScore());
                                 
                                 window.setScene(dailyDoubleClueScene);
                              
                              }
                           
                           else if (player2.getScore() < 0)
                              
                              {
                              
                                 dailyDouble.setWager(dailyDouble.getCluePoints());
                                 
                                 window.setScene(dailyDoubleClueScene);
                              
                              }
                           
                           else if (player2.getScore() < dailyDouble.getWager())
                              
                              {
                              
                                 dailyDouble.setWager(player2.getScore()); 
                                 
                                 window.setScene(dailyDoubleClueScene);     
                              
                              }
                        
                        }
                        
                     else if (dailyDouble.getTurn() == 2)  //Handles Player 3
                        
                        {
                        
                           if (dailyDouble.getWager() > 0 && dailyDouble.getWager() <= player3.getScore())
                              
                              {
                              
                                 window.setScene(dailyDoubleClueScene);   
                              
                              }
                           
                           else if(player3.getScore() == dailyDouble.getWager())
                              
                              {
                              
                                 dailyDouble.setWager(player3.getScore());
                                 
                                 window.setScene(dailyDoubleClueScene);
                              
                              }
                           
                           else if (player3.getScore() < 0)
                              
                              {
                              
                                 dailyDouble.setWager(dailyDouble.getCluePoints());
                                 
                                 window.setScene(dailyDoubleClueScene);
                              
                              }
                           
                           else if (player3.getScore() < dailyDouble.getWager())
                              
                              {
                              
                                 dailyDouble.setWager(player3.getScore()); 
                                 
                                 window.setScene(dailyDoubleClueScene);     
                              
                              }
                        
                        }
                     
                     //window.setScene(dailyDoubleClueScene); 
                  
                  });   
               
                  
               dailyDoubleTestButton.setOnAction( e -> //   This Button will eventually get deleted. 
                  
                  {
                  
                     window.setScene(dailyDoubleScene1);
                  
                  });
               
               /////////   Category A Buttons
               
               categoryAInfo.setOnAction( e ->  
                                 
                  {
                     if(dailyDouble.getGamePhase() == 0)
                     {
                        
                        categoryText.setText("Hello World: \nJava Facts.".toUpperCase()); //Category: Hello World
                     }
                     
                     if(dailyDouble.getGamePhase() == 1)
                     {
                     
                        categoryText.setText("Giants of Our Time \nFamous Figures.".toUpperCase()); //Category: Giants of Our Time
                     
                     }
                     window.setScene(categoryInfoScene);
                  
                  });
                  
               categoryA100.setOnAction( e ->  
                  
                  {
                     answerA.setDisable(false); 
                     
                     answerB.setDisable(false);
                     
                     answerX.setDisable(false);
                     
                     answerY.setDisable(false);
                     
                     dailyDouble.resetIncorrectTracker();

                     dailyDouble.plusCounter();
                     
                     System.out.println("The daily double counter is currently at ".toUpperCase() + dailyDouble.getCounter() + ".");
                     
                     if(dailyDouble.getGamePhase() == 0)
                     {
                     
                     clueText.setText("Named after the tree that stood \noutside its creator’s office, this was the original \nname for the Java Programming Language.".toUpperCase());
                     
                     answerA.setText("Pine");
                     
                     answerB.setText("Birch");
                     
                     answerX.setText("Oak");
                     
                     answerY.setText("Maple");
                     
                     dailyDouble.setAnswerInt(2); //Oak
                     
                     dailyDouble.setCluePoints(100); 
                     }
                     
                     if(dailyDouble.getGamePhase() == 1)
                     {
                     
                     clueText.setText("In the late 19th Century, this inventor \nperfected the design of the light bulb.  ".toUpperCase());
                     
                     answerA.setText("Thomas Edison");
                     
                     answerB.setText("Albert Einstein");
                     
                     answerX.setText("Nikola Tesla");
                     
                     answerY.setText("Charles Proteus Steinmetz");
                     
                     dailyDouble.setAnswerInt(0); //Thomas Edison
                     
                     dailyDouble.setCluePoints(200); 
                     
                     }
                     if (dailyDouble.getCounter() == dailyDouble.getValueA() || dailyDouble.getCounter() == dailyDouble.getValueB() || dailyDouble.getCounter() == dailyDouble.getValueC())
                        
                        {
                        
                           clueTextDD.setText(clueText.getText());
                           
                           answerADD.setText(answerA.getText());
                           
                           answerBDD.setText(answerB.getText());
                           
                           answerXDD.setText(answerX.getText());
                           
                           answerYDD.setText(answerY.getText());
                           

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
                     answerA.setDisable(false); 
                     
                     answerB.setDisable(false);

                     answerX.setDisable(false);

                     answerY.setDisable(false);

                     dailyDouble.resetIncorrectTracker();

                     dailyDouble.plusCounter();
                     
                     System.out.println("The daily double counter is currently at ".toUpperCase() + dailyDouble.getCounter() + ".".toUpperCase());
                    if(dailyDouble.getGamePhase() == 0)
                    {
                    
                        clueText.setText("This company, founded in \nFebruary 1982 originally developed Java.".toUpperCase());
                     
                        answerA.setText("Sun Microsystems");
                     
                        answerB.setText("Oracle Corporation");
                     
                        answerX.setText("Sunopsis");
                     
                        answerY.setText("Roots & Ladders LLC");
                     
                        dailyDouble.setAnswerInt(0); //Sun Microsystems
                        
                        dailyDouble.setCluePoints(200); 
                    }
                    
                    if(dailyDouble.getGamePhase() == 1)
                    {
                    
                        clueText.setText("Five years after the\n first solo flight across the Atlantic,\n this pilot became the second person\n to complete the same feat.".toUpperCase());
                     
                        answerA.setText("Charles Lindbergh");
                     
                        answerB.setText("Amelia Earhart");
                     
                        answerX.setText("Arthur Brown");
                     
                        answerY.setText("John Alcock");
                     
                        dailyDouble.setAnswerInt(1); //Amelia Earhart
                        
                        dailyDouble.setCluePoints(400);
                        
                    }
                     if (dailyDouble.getCounter() == dailyDouble.getValueA() || dailyDouble.getCounter() == dailyDouble.getValueB() || dailyDouble.getCounter() == dailyDouble.getValueC())
                        
                        {
                        
                           clueTextDD.setText(clueText.getText());
                           
                           answerADD.setText(answerA.getText());
                           
                           answerBDD.setText(answerB.getText());
                           
                           answerXDD.setText(answerX.getText());
                           
                           answerYDD.setText(answerY.getText());
                          
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
                     answerA.setDisable(false); 
                     
                     answerB.setDisable(false);
                     
                     answerX.setDisable(false);
                     
                     answerY.setDisable(false);
                     
                     dailyDouble.resetIncorrectTracker();

                     dailyDouble.plusCounter();
                     
                     System.out.println("The daily double counter is currently at ".toUpperCase() + dailyDouble.getCounter() + ".".toUpperCase());
                    if(dailyDouble.getGamePhase() == 0)
                    { 
                     clueText.setText("Occurring to Oracle, ATMs, PCs,\nBlu-Ray Players, and Servers help make \nup the _________ number of devices that run Java.".toUpperCase());
                     
                     answerA.setText("15,000,000");
                     
                     answerB.setText("150,000,000");
                     
                     answerX.setText("1,500,000,000");
                     
                     answerY.setText("15,000,000,000");
                     
                     dailyDouble.setAnswerInt(3); //15,000,000,000
                     
                     dailyDouble.setCluePoints(300);
                   
                    }
                    
                    if(dailyDouble.getGamePhase() == 1)
                    {
                     clueText.setText("A fan of ancient indian poetry,\nthis physicist quotes the Bhagavad Gita, stating \n“Now I am become Death, the destroyer of worlds.”".toUpperCase());
                     
                     answerA.setText("J. Robert Oppenheimer");
                     
                     answerB.setText("Werner Heisenberg");
                     
                     answerX.setText("Albert Einstein");
                     
                     answerY.setText("Richard Feynman");
                     
                     dailyDouble.setAnswerInt(0); //J. Robert Oppenheimer
                     
                     dailyDouble.setCluePoints(600);
                    
                    }
                    
                    
                     if (dailyDouble.getCounter() == dailyDouble.getValueA() || dailyDouble.getCounter() == dailyDouble.getValueB() || dailyDouble.getCounter() == dailyDouble.getValueC())
                        
                        {
                        
                           clueTextDD.setText(clueText.getText());
                           
                           answerADD.setText(answerA.getText());
                           
                           answerBDD.setText(answerB.getText());
                           
                           answerXDD.setText(answerX.getText());
                           
                           answerYDD.setText(answerY.getText());
                           
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
                     answerA.setDisable(false); 
                     
                     answerB.setDisable(false);
                     
                     answerX.setDisable(false);
                     
                     answerY.setDisable(false);
                     
                     dailyDouble.resetIncorrectTracker();

                     dailyDouble.plusCounter();
                     
                     System.out.println("The daily double counter is currently at ".toUpperCase() + dailyDouble.getCounter() + ".".toUpperCase());
                    if(dailyDouble.getGamePhase() == 0)
                    {
                    
                        clueText.setText("First released in on a device in 2008,\n this operating system is mostly written Java..".toUpperCase());
                     
                        answerA.setText("Android");
                     
                        answerB.setText("iOS");
                     
                        answerX.setText("FireOS");
                     
                        answerY.setText("Linux");
                     
                        dailyDouble.setAnswerInt(0); //Android
                        
                        dailyDouble.setCluePoints(400);
                    
                    }
                    
                    if(dailyDouble.getGamePhase() == 1)
                    {
                    
                        clueText.setText("One of the co-founders of Microsoft, \nthis man unfortunately lost his battle\n with cancer in 2018.  ".toUpperCase());
                     
                        answerA.setText("Paul Allen");
                     
                        answerB.setText("Bill Gates");
                     
                        answerX.setText("Steve Wozniak");
                     
                        answerY.setText("Tim Cook");
                     
                        dailyDouble.setAnswerInt(0); //Paul Allen
                        
                        dailyDouble.setCluePoints(800);
                    
                    }
                    
                     if (dailyDouble.getCounter() == dailyDouble.getValueA() || dailyDouble.getCounter() == dailyDouble.getValueB() || dailyDouble.getCounter() == dailyDouble.getValueC())
                        
                        {
                        
                           clueTextDD.setText(clueText.getText());
                           
                           answerADD.setText(answerA.getText());
                           
                           answerBDD.setText(answerB.getText());
                           
                           answerXDD.setText(answerX.getText());
                           
                           answerYDD.setText(answerY.getText());
                           
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
                     answerA.setDisable(false); 
                     
                     answerB.setDisable(false);
                     
                     answerX.setDisable(false);
                     
                     answerY.setDisable(false);
                     
                     dailyDouble.resetIncorrectTracker();

                     dailyDouble.plusCounter();
                     
                     System.out.println("The daily double counter is currently at ".toUpperCase() + dailyDouble.getCounter() + ".".toUpperCase());
                    if(dailyDouble.getGamePhase() == 0)
                    {
                     clueText.setText("An Officer in the Order of Canada,\nthis man founded Java.".toUpperCase());
                     
                     answerA.setText("James Gosling");
                     
                     answerB.setText("Andy Jassy");
                     
                     answerX.setText("Ronald Wyane");
                     
                     answerY.setText("Phil Spencer"); //James Gosling
                     
                     dailyDouble.setAnswerInt(0);
                    
                     dailyDouble.setCluePoints(500);
                    
                    }
                    
                    if(dailyDouble.getGamePhase() == 1)
                    
                    {
                     clueText.setText("This scotsman is credited with \ncreating the world's first antibiotic.  ".toUpperCase());
                     
                     answerA.setText("Alexander Fleming");
                     
                     answerB.setText("George Beadle");
                     
                     answerX.setText("Erwin Chargaff");
                     
                     answerY.setText("Norton Zinder");
                     
                     dailyDouble.setAnswerInt(0); //Alexander Fleming
                     
                     dailyDouble.setCluePoints(1000);
                    
                    
                    }
                     
                     if (dailyDouble.getCounter() == dailyDouble.getValueA() || dailyDouble.getCounter() == dailyDouble.getValueB() || dailyDouble.getCounter() == dailyDouble.getValueC())
                        
                        {
                        
                           clueTextDD.setText(clueText.getText());
                           
                           answerADD.setText(answerA.getText());
                           
                           answerBDD.setText(answerB.getText());
                           
                           answerXDD.setText(answerX.getText());
                           
                           answerYDD.setText(answerY.getText());
                           
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
                     if(dailyDouble.getGamePhase() == 0)
                     {
                        categoryText.setText("This Land is Your Land: \nU.S. Landmarks.".toUpperCase());; //Category: This Land is Your Land
                     }
                     
                     if(dailyDouble.getGamePhase() == 1)
                     {
                        categoryText.setText("Ready Player One: \nVideo Games.".toUpperCase());; //Category: Ready Player One
                     }
                     
                     window.setScene(categoryInfoScene);
                  
                  });
                  
               categoryB100.setOnAction( e ->  
                  
                  {
                     answerA.setDisable(false); 
                     
                     answerB.setDisable(false);
                     
                     answerX.setDisable(false);
                     
                     answerY.setDisable(false);
                     
                     dailyDouble.resetIncorrectTracker();

                     dailyDouble.plusCounter();
                     
                     System.out.println("The daily double counter is currently at ".toUpperCase() + dailyDouble.getCounter() + ".".toUpperCase());
                     
                    if(dailyDouble.getGamePhase() == 0)
                    {
                    
                        clueText.setText("Opened in 1937, the Golden Gate Bridge\nconnects the city of San Francisco, CA \nto this county.".toUpperCase());
                     
                        answerA.setText("Alameda County");
                     
                        answerB.setText("Napa County");
                     
                        answerX.setText("Marin County");
                     
                        answerY.setText("San Mateo County");
                     
                        dailyDouble.setAnswerInt(2); //Marin County
                        
                        dailyDouble.setCluePoints(100);
                    
                    }
                    
                    if(dailyDouble.getGamePhase() == 1)
                    
                    {
                    
                     clueText.setText("In the 2013 smash hit Grand Theft Auto V,\n players can travel and interact\n in a virtual parody of this US City.".toUpperCase());
                     
                     answerA.setText("Los Angeles");
                     
                     answerB.setText("Las Vegas");
                     
                     answerX.setText("New York City");
                     
                     answerY.setText("Miami");
                     
                     dailyDouble.setAnswerInt(0); //Los Angeles
                     
                     dailyDouble.setCluePoints(200);
                    
                    }
                    
                     if (dailyDouble.getCounter() == dailyDouble.getValueA() || dailyDouble.getCounter() == dailyDouble.getValueB() || dailyDouble.getCounter() == dailyDouble.getValueC())
                        
                        {
                        
                           clueTextDD.setText(clueText.getText());
                           
                           answerADD.setText(answerA.getText());
                           
                           answerBDD.setText(answerB.getText());
                           
                           answerXDD.setText(answerX.getText());
                           
                           answerYDD.setText(answerY.getText());
                           
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
                     answerA.setDisable(false); 
                     
                     answerB.setDisable(false);
                     
                     answerX.setDisable(false);
                     
                     answerY.setDisable(false);
                     
                     dailyDouble.resetIncorrectTracker();

                     dailyDouble.plusCounter();
                     
                     System.out.println("The daily double counter is currently at ".toUpperCase() + dailyDouble.getCounter() + ".".toUpperCase());
                    if(dailyDouble.getGamePhase() == 0)
                    {
                     clueText.setText("Once the world’s largest\n the Georgia aquarium is located in this city?".toUpperCase());
                     
                     answerA.setText("Savannah");
                     
                     answerB.setText("Athens");
                     
                     answerX.setText("Columbus");
                     
                     answerY.setText("Atlanta");
                     
                     dailyDouble.setAnswerInt(3); //Atlanta
                     
                     dailyDouble.setCluePoints(200);
                    
                    }
                    
                    if(dailyDouble.getGamePhase() == 1)
                    {
                     clueText.setText("The names of the Ghosts from 1980’s Pac Man\n are Binky, Pinky, Inky, and _______. ".toUpperCase());
                     
                     answerA.setText("Ricky");
                     
                     answerB.setText("Kyle");
                     
                     answerX.setText("Clyde");
                     
                     answerY.setText("Winky");
                     
                     dailyDouble.setAnswerInt(2); //Clyde
                     
                     dailyDouble.setCluePoints(400);
                    
                    }
                    
                     if (dailyDouble.getCounter() == dailyDouble.getValueA() || dailyDouble.getCounter() == dailyDouble.getValueB() || dailyDouble.getCounter() == dailyDouble.getValueC())
                        
                        {
                        
                           clueTextDD.setText(clueText.getText());
                           
                           answerADD.setText(answerA.getText());
                           
                           answerBDD.setText(answerB.getText());
                           
                           answerXDD.setText(answerX.getText());
                           
                           answerYDD.setText(answerY.getText());
                           
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
                     answerA.setDisable(false); 
                     
                     answerB.setDisable(false);
                     
                     answerX.setDisable(false);
                     
                     answerY.setDisable(false);
                     
                     dailyDouble.resetIncorrectTracker();

                     dailyDouble.plusCounter();
                     
                     System.out.println("The daily double counter is currently at ".toUpperCase() + dailyDouble.getCounter() + ".".toUpperCase());
                    if(dailyDouble.getGamePhase() == 0)
                    {
                    
                        clueText.setText("Given as a token of friendship between two nations,\nthe Statue of Liberty was given\nto the United States from this nation. ".toUpperCase());
                     
                        answerA.setText("Spain");
                     
                        answerB.setText("France");
                     
                        answerX.setText("Germany");
                     
                        answerY.setText("Great Britain");
                     
                        dailyDouble.setAnswerInt(1); //France
                        
                        dailyDouble.setCluePoints(300);
                        
                    }
                    
                    if(dailyDouble.getGamePhase() == 1)
                    {
                    
                        clueText.setText("Since release, this MMORPG has made over\n $9,000,000,000 in revenue. ".toUpperCase());
                     
                        answerA.setText("Grand Theft Auto V");
                     
                        answerB.setText("Minecraft");
                     
                        answerX.setText("World of Warcraft");
                     
                        answerY.setText("Sims");
                     
                        dailyDouble.setAnswerInt(2); //World of Warcraft
                        
                        dailyDouble.setCluePoints(600);
                    
                    }
                     if (dailyDouble.getCounter() == dailyDouble.getValueA() || dailyDouble.getCounter() == dailyDouble.getValueB() || dailyDouble.getCounter() == dailyDouble.getValueC())
                        
                        {
                        
                           clueTextDD.setText(clueText.getText());
                           
                           answerADD.setText(answerA.getText());
                           
                           answerBDD.setText(answerB.getText());
                           
                           answerXDD.setText(answerX.getText());
                           
                           answerYDD.setText(answerY.getText());
                           
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
                     answerA.setDisable(false); 
                     
                     answerB.setDisable(false);
                     
                     answerX.setDisable(false);
                     
                     answerY.setDisable(false);
                     
                     dailyDouble.resetIncorrectTracker();

                     dailyDouble.plusCounter();
                     
                     System.out.println("The daily double counter is currently at ".toUpperCase() + dailyDouble.getCounter() + ".".toUpperCase());
                    if(dailyDouble.getGamePhase() == 0)
                    {
                     clueText.setText("Once called the Sears Tower,\nthe Willis Tower is the tallest \nskyscraper in this midwest city.".toUpperCase());
                     
                     answerA.setText("Indianapolis, Indiana");
                     
                     answerB.setText("Detroit, Michigan");
                     
                     answerX.setText("Chicago, Illinois");
                     
                     answerY.setText("Omaha, Nebraska");
                     
                     dailyDouble.setAnswerInt(2); //Chicago, Illinois
                    
                     dailyDouble.setCluePoints(400);
                    
                    
                    }
                    
                    if(dailyDouble.getGamePhase() == 1)
                    {
                     clueText.setText("Well before making video games and consoles,\n Nintendo first started producing _______ in 1889.".toUpperCase());
                     
                     answerA.setText("Food");
                     
                     answerB.setText("Playing Cards");
                     
                     answerX.setText("Dice");
                     
                     answerY.setText("Clothing");
                     
                     dailyDouble.setAnswerInt(1); //Playing Cards
                    
                     dailyDouble.setCluePoints(800);
                    
                    
                    }
                    
                     if (dailyDouble.getCounter() == dailyDouble.getValueA() || dailyDouble.getCounter() == dailyDouble.getValueB() || dailyDouble.getCounter() == dailyDouble.getValueC())
                        
                        {
                        
                           clueTextDD.setText(clueText.getText());
                           
                           answerADD.setText(answerA.getText());
                           
                           answerBDD.setText(answerB.getText());
                           
                           answerXDD.setText(answerX.getText());
                           
                           answerYDD.setText(answerY.getText());
                           
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
                     answerA.setDisable(false); 
                     
                     answerB.setDisable(false);
                     
                     answerX.setDisable(false);
                     
                     answerY.setDisable(false);
                     
                     dailyDouble.resetIncorrectTracker();

                     dailyDouble.plusCounter();
                     
                     System.out.println("The daily double counter is currently at ".toUpperCase() + dailyDouble.getCounter() + ".".toUpperCase());
                     
                     if(dailyDouble.getGamePhase() == 0)
                     {
                    
                        clueText.setText("The first national monument,\nDevils Tower National Monument,\ncan be found in this state.".toUpperCase());
                     
                        answerA.setText("Colorado");
                     
                        answerB.setText("California");
                     
                        answerX.setText("Montana");
                     
                        answerY.setText("Wyoming");
                     
                        dailyDouble.setAnswerInt(3); //Wyoming
                        
                        dailyDouble.setCluePoints(500);
                     
                     }
                    
                     if(dailyDouble.getGamePhase() == 1)
                     
                     {
                    
                        clueText.setText("With over 150 Million consoles sold, \nthis system is the best selling game\n console of all time. ".toUpperCase());
                     
                        answerA.setText("Playstation 2");
                     
                        answerB.setText("Xbox 360");
                     
                        answerX.setText("Nitendo Wii");
                     
                        answerY.setText("Playstation 4");
                     
                        dailyDouble.setAnswerInt(0); //Playstation 2
                        
                        dailyDouble.setCluePoints(1000);
                    
                    
                    
                    }
                    
                    if (dailyDouble.getCounter() == dailyDouble.getValueA() || dailyDouble.getCounter() == dailyDouble.getValueB() || dailyDouble.getCounter() == dailyDouble.getValueC())
                        
                        {
                        
                           clueTextDD.setText(clueText.getText());
                           
                           answerADD.setText(answerA.getText());
                           
                           answerBDD.setText(answerB.getText());
                           
                           answerXDD.setText(answerX.getText());
                           
                           answerYDD.setText(answerY.getText());
                           
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
                     if(dailyDouble.getGamePhase() == 0)
                     {
                        categoryText.setText("Chips, Discs, and Peripherals: \nComputer Hardware Acronyms".toUpperCase()); //Category: Chips, Discs, and Peripherals
                     }
                     
                     if(dailyDouble.getGamePhase() == 1)
                     {
                        categoryText.setText("The Boys Club: \nU.S. Presidents".toUpperCase()); //Category: The Boys Club
                     }
                     
                     window.setScene(categoryInfoScene);
                  
                  });
                  
               categoryC100.setOnAction( e ->  
                  
                  {
                     answerA.setDisable(false); 
                     
                     answerB.setDisable(false);
                     
                     answerX.setDisable(false);
                     
                     answerY.setDisable(false);
                     
                     dailyDouble.resetIncorrectTracker();

                     dailyDouble.plusCounter();
                     
                     System.out.println("The daily double counter is currently at ".toUpperCase() + dailyDouble.getCounter() + ".".toUpperCase());
                    if(dailyDouble.getGamePhase() == 0)
                    {
                     clueText.setText("USB".toUpperCase());
                     
                     answerA.setText("United Serial Bus");
                     
                     answerB.setText("Universal Storage Bus");
                     
                     answerX.setText("United Storage Bus");
                     
                     answerY.setText("Universal Serial Bus");
                     
                     dailyDouble.setAnswerInt(3); //Universal Serial Bus
                     
                     dailyDouble.setCluePoints(100);
                    
                    
                    
                    
                    }
                    
                    if(dailyDouble.getGamePhase() == 1)
                    {
                     clueText.setText("While they all share a spot on Mt. Rushmore,\n this US President does not appear on paper currency.".toUpperCase());
                     
                     answerA.setText("Theodore Roosevelt");
                     
                     answerB.setText("Abraham Lincoln");
                     
                     answerX.setText("George Washington");
                     
                     answerY.setText("Thomas Jefferson");
                     
                     dailyDouble.setAnswerInt(0); //Theodore Roosevelt
                     
                     dailyDouble.setCluePoints(200);
                    
                    
                    
                    }
                    
                     if (dailyDouble.getCounter() == dailyDouble.getValueA() || dailyDouble.getCounter() == dailyDouble.getValueB() || dailyDouble.getCounter() == dailyDouble.getValueC())
                        
                        {
                        
                           clueTextDD.setText(clueText.getText());
                           
                           answerADD.setText(answerA.getText());
                           
                           answerBDD.setText(answerB.getText());
                           
                           answerXDD.setText(answerX.getText());
                           
                           answerYDD.setText(answerY.getText());
                           
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
                     answerA.setDisable(false); 
                     
                     answerB.setDisable(false);
                     
                     answerX.setDisable(false);
                     
                     answerY.setDisable(false);
                     
                     dailyDouble.resetIncorrectTracker();

                     dailyDouble.plusCounter();
                     
                     System.out.println("The daily double counter is currently at ".toUpperCase() + dailyDouble.getCounter() + ".".toUpperCase());
                    if(dailyDouble.getGamePhase() == 0)
                    {
                     clueText.setText("RAM".toUpperCase());
                     
                     answerA.setText("Random Access Memory");
                     
                     answerB.setText("Readable Access Memory");
                     
                     answerX.setText("Random Action Matrix");
                     
                     answerY.setText("Random Action Memory");
                     
                     dailyDouble.setAnswerInt(0); //Random Access Memory
                     
                     dailyDouble.setCluePoints(200);
                    
                    
                    
                    }
                    
                    if(dailyDouble.getGamePhase() == 1)
                    {
                     clueText.setText("Walt Whitman's poem, 'Oh Captain, My Captain'\n was written about this President. ".toUpperCase());
                     
                     answerA.setText("Abraham Lincoln");
                     
                     answerB.setText("Ulysses S. Grant");
                     
                     answerX.setText("George Washington");
                     
                     answerY.setText("John Adams");
                     
                     dailyDouble.setAnswerInt(0); //Abraham Lincoln
                    
                     dailyDouble.setCluePoints(400);
                    
                    
                    
                    }
                    
                     if (dailyDouble.getCounter() == dailyDouble.getValueA() || dailyDouble.getCounter() == dailyDouble.getValueB() || dailyDouble.getCounter() == dailyDouble.getValueC())
                        
                        {
                        
                           clueTextDD.setText(clueText.getText());
                           
                           answerADD.setText(answerA.getText());
                           
                           answerBDD.setText(answerB.getText());
                           
                           answerXDD.setText(answerX.getText());
                           
                           answerYDD.setText(answerY.getText());
                           
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
                     answerA.setDisable(false); 
                     
                     answerB.setDisable(false);
                     
                     answerX.setDisable(false);
                     
                     answerY.setDisable(false);
                     
                     dailyDouble.resetIncorrectTracker();

                     dailyDouble.plusCounter();
                     
                     System.out.println("The daily double counter is currently at ".toUpperCase() + dailyDouble.getCounter() + ".".toUpperCase());
                    if(dailyDouble.getGamePhase() == 0)
                    { 
                     clueText.setText("HDD".toUpperCase());
                     
                     answerA.setText("Hard Disk Drive");
                     
                     answerB.setText("Hard Drive Disk");
                     
                     answerX.setText("High Definition Disk");
                     
                     answerY.setText("High Definition Driver");
                     
                     dailyDouble.setAnswerInt(0); //Hard Disk Drive
                    
                     dailyDouble.setCluePoints(300);
                    
                    
                    }
                    
                    if(dailyDouble.getGamePhase() == 1)
                    {
                     clueText.setText("This U.S. President won a Pulitzer Prize\n for his book Profiles in Courage.".toUpperCase());
                     
                     answerA.setText("Bill Clinton");
                     
                     answerB.setText("Richard Nixon");
                     
                     answerX.setText("John F. Kennedy");
                     
                     answerY.setText("Lyndon B. Johnson");
                     
                     dailyDouble.setAnswerInt(2); //John F. Kennedy
                    
                     dailyDouble.setCluePoints(600);
                    
                    
                    
                    }
                    
                     if (dailyDouble.getCounter() == dailyDouble.getValueA() || dailyDouble.getCounter() == dailyDouble.getValueB() || dailyDouble.getCounter() == dailyDouble.getValueC())
                        
                        {
                        
                           clueTextDD.setText(clueText.getText());
                           
                           answerADD.setText(answerA.getText());
                           
                           answerBDD.setText(answerB.getText());
                           
                           answerXDD.setText(answerX.getText());
                           
                           answerYDD.setText(answerY.getText());
                           
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
                     answerA.setDisable(false); 
                     
                     answerB.setDisable(false);
                     
                     answerX.setDisable(false);
                     
                     answerY.setDisable(false);
                     
                     dailyDouble.resetIncorrectTracker();

                     dailyDouble.plusCounter();
                     
                     System.out.println("The daily double counter is currently at ".toUpperCase() + dailyDouble.getCounter() + ".".toUpperCase());
                    if(dailyDouble.getGamePhase() == 0)
                    {
                     clueText.setText("SSD".toUpperCase());
                     
                     answerA.setText("Solid-Silent Drive");
                     
                     answerB.setText("Silent-State Drive");
                     
                     answerX.setText("Solid-State Drive");
                     
                     answerY.setText("Serial-State Drive");
                     
                     dailyDouble.setAnswerInt(2); //Solid-State Drive
                    
                     dailyDouble.setCluePoints(400);
                    
                    
                    
                    
                    }
                    
                    if(dailyDouble.getGamePhase() == 1)
                    {
                     clueText.setText("Among the 44 men who have been president,\n only this one had a Phd. ".toUpperCase());
                     
                     answerA.setText("Zachary Taylor");
                     
                     answerB.setText("George H. W. Bush");
                     
                     answerX.setText("Ronald Reagan");
                     
                     answerY.setText("Woodrow Wilson");
                     
                     dailyDouble.setAnswerInt(3); //Woodrow Wilson
                    
                     dailyDouble.setCluePoints(800);
                    
                    
                    }
                     
                     if (dailyDouble.getCounter() == dailyDouble.getValueA() || dailyDouble.getCounter() == dailyDouble.getValueB() || dailyDouble.getCounter() == dailyDouble.getValueC())
                        
                        {
                        
                           clueTextDD.setText(clueText.getText());
                           
                           answerADD.setText(answerA.getText());
                           
                           answerBDD.setText(answerB.getText());
                           
                           answerXDD.setText(answerX.getText());
                           
                           answerYDD.setText(answerY.getText());
                           
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
                     answerA.setDisable(false); 
                     
                     answerB.setDisable(false);
                     
                     answerX.setDisable(false);
                     
                     answerY.setDisable(false);
                     
                     dailyDouble.resetIncorrectTracker();

                     dailyDouble.plusCounter();
                     
                     System.out.println("The daily double counter is currently at ".toUpperCase() + dailyDouble.getCounter() + ".".toUpperCase());
                    
                    if(dailyDouble.getGamePhase() == 0)
                    { 
                     clueText.setText("GPU".toUpperCase());
                     
                     answerA.setText("Graphics Processing Utility");
                     
                     answerB.setText("Graphics Processing Unit");
                     
                     answerX.setText("Graphic Procedural Unit ");
                     
                     answerY.setText("Generating Processing Utility");
                     
                     dailyDouble.setAnswerInt(1); //Graphics Processing Unit
                    
                     dailyDouble.setCluePoints(500);
                    
                    
                    }
                    
                    if(dailyDouble.getGamePhase() == 1)
                    {
                     clueText.setText("This President was the first to be born a US Citizen.".toUpperCase());
                     
                     answerA.setText("John Quincy Adams");
                     
                     answerB.setText("Martin Van Buren");
                     
                     answerX.setText("William Henry Harrison");
                     
                     answerY.setText("Woodrow Wilson");
                     
                     dailyDouble.setAnswerInt(1); //Martin Van Buren
                    
                     dailyDouble.setCluePoints(1000);
                    
                    
                    }
                     
                     if (dailyDouble.getCounter() == dailyDouble.getValueA() || dailyDouble.getCounter() == dailyDouble.getValueB() || dailyDouble.getCounter() == dailyDouble.getValueC())
                        
                        {
                        
                           clueTextDD.setText(clueText.getText());
                           
                           answerADD.setText(answerA.getText());
                           
                           answerBDD.setText(answerB.getText());
                           
                           answerXDD.setText(answerX.getText());
                           
                           answerYDD.setText(answerY.getText());
                           
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
                  
                  
                     if(dailyDouble.getGamePhase() == 0)
                     {
                     
                        categoryText.setText("Spitting Bars! (Music)".toUpperCase()); //Category: Spitting Bars!
                        
                     }
                     
                     if(dailyDouble.getGamePhase() == 1)
                     {
                     
                        categoryText.setText("Eureka! (Science)".toUpperCase()); //Category: Eureka!
                     
                     }
                     
                     
                     window.setScene(categoryInfoScene);
                     
                     
                  });
                  
               categoryD100.setOnAction( e ->  
                  
                  {
                  
                     answerA.setDisable(false); 
                     
                     answerB.setDisable(false);
                     
                     answerX.setDisable(false);
                     
                     answerY.setDisable(false);
                     
                     dailyDouble.resetIncorrectTracker();
                  
                     dailyDouble.plusCounter();
                     
                     System.out.println("The daily double counter is currently at ".toUpperCase() + dailyDouble.getCounter() + ".".toUpperCase());
                     
                     if(dailyDouble.getGamePhase() == 0)
                     {
                     
                        clueText.setText("This Musician was awarded the very first \n gold record from the \n Recording Industry Association of America".toUpperCase());   //BARS
                     
                        answerA.setText("Nat King Cole");
                     
                        answerB.setText("The Beatles");
                     
                        answerX.setText("Elvis Presley");
                     
                        answerY.setText("Perry Como");
                     
                        dailyDouble.setAnswerInt(3); //Perry Como
                        
                        dailyDouble.setCluePoints(100); //if it is in a catN100
                        
                     }
                     
                     if(dailyDouble.getGamePhase() == 1)
                     {
                     
                        clueText.setText("In 1911 this person became\n the only Nobel Laureate to win \n the award in the two different sciences ".toUpperCase());
                     
                        answerA.setText("Frederick Sanger");
                     
                        answerB.setText("Linus Pauling");
                     
                        answerX.setText("Marie Curie");
                     
                        answerY.setText("John Bardeen");
                        
                        dailyDouble.setAnswerInt(2); //Marie Curie
                        
                        dailyDouble.setCluePoints(200); //if it is in a catN100
                     
                     }
                     
                                          
                     if (dailyDouble.getCounter() == dailyDouble.getValueA() || dailyDouble.getCounter() == dailyDouble.getValueB() || dailyDouble.getCounter() == dailyDouble.getValueC())
                        
                        {
                        
                           clueTextDD.setText(clueText.getText());
                           
                           answerADD.setText(answerA.getText());
                           
                           answerBDD.setText(answerB.getText());
                           
                           answerXDD.setText(answerX.getText());
                           
                           answerYDD.setText(answerY.getText());
                           
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
                     
                     answerA.setDisable(false); 
                     
                     answerB.setDisable(false);
                     
                     answerX.setDisable(false);
                     
                     answerY.setDisable(false);
                     
                     dailyDouble.resetIncorrectTracker();
                     
                     dailyDouble.plusCounter();
                     
                     System.out.println("The daily double counter is currently at ".toUpperCase() + dailyDouble.getCounter() + ".".toUpperCase());
                     
                     if(dailyDouble.getGamePhase() == 0)
                     {
                     
                        clueText.setText("This is the oldest surviving musical instrument".toUpperCase());
                        
                        answerA.setText("Drum");
                        
                        answerB.setText("Lyre");
                        
                        answerX.setText("Flute");
                        
                        answerY.setText("Trumpet");
                        
                        dailyDouble.setAnswerInt(2); //Flute
                        
                        dailyDouble.setCluePoints(200); //if it is in a catN100
                     
                     }
                     
                     if(dailyDouble.getGamePhase() == 1)
                     {
                     
                        clueText.setText("The fifth planet \n from the Sun, _________ has the most moons \n in its orbit with 79".toUpperCase());
                        
                        answerA.setText("Jupiter");
                        
                        answerB.setText("Saturn");
                        
                        answerX.setText("Uranus");
                        
                        answerY.setText("Mars");
                        
                        dailyDouble.setAnswerInt(0); //Jupiter
                        
                        dailyDouble.setCluePoints(400); //if it is in a catN100
                     
                     
                     }
                     
                     
                     
                     if (dailyDouble.getCounter() == dailyDouble.getValueA() || dailyDouble.getCounter() == dailyDouble.getValueB() || dailyDouble.getCounter() == dailyDouble.getValueC())
                        
                        {
                        
                           clueTextDD.setText(clueText.getText());
                           
                           answerADD.setText(answerA.getText());
                           
                           answerBDD.setText(answerB.getText());
                           
                           answerXDD.setText(answerX.getText());
                           
                           answerYDD.setText(answerY.getText());
                           
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
                  
                     answerA.setDisable(false); 
                     
                     answerB.setDisable(false);
                     
                     answerX.setDisable(false);
                     
                     answerY.setDisable(false);
                     
                     dailyDouble.resetIncorrectTracker();
                     
                     dailyDouble.plusCounter();
                     
                     System.out.println("The daily double counter is currently at ".toUpperCase() + dailyDouble.getCounter() + ".".toUpperCase());
                     
                     if(dailyDouble.getGamePhase() == 0)
                     {
                     
                        clueText.setText("The World Record for the most\n words in a hit single \n is held by this Musician ".toUpperCase());
                        
                        answerA.setText("Kayne West");
                        
                        answerB.setText("Eminem");
                        
                        answerX.setText("Busta Rhymes");
                        
                        answerY.setText("50 Cent");
                        
                        dailyDouble.setAnswerInt(1); //Eminem
                        
                        dailyDouble.setCluePoints(300);
                        
                     }
                     
                     if(dailyDouble.getGamePhase() == 1)
                     {
                     
                        clueText.setText("Born at the San Francisco Zoo, \n this Gorilla gained international attention after \n being taught sign language ".toUpperCase());
                        
                        answerA.setText("Chloe");
                        
                        answerB.setText("Koko");
                        
                        answerX.setText("Carly");
                        
                        answerY.setText("Katie");
                        
                        dailyDouble.setAnswerInt(1); //Koko
                        
                        dailyDouble.setCluePoints(600);
                     
                     }
                     
                     
                     if (dailyDouble.getCounter() == dailyDouble.getValueA() || dailyDouble.getCounter() == dailyDouble.getValueB() || dailyDouble.getCounter() == dailyDouble.getValueC())
                        
                        {
                        
                           clueTextDD.setText(clueText.getText());
                           
                           answerADD.setText(answerA.getText());
                           
                           answerBDD.setText(answerB.getText());
                           
                           answerXDD.setText(answerX.getText());
                           
                           answerYDD.setText(answerY.getText());

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
                  
                     answerA.setDisable(false); 
                     
                     answerB.setDisable(false);
                     
                     answerX.setDisable(false);
                     
                     answerY.setDisable(false);
                     
                     dailyDouble.resetIncorrectTracker();
                  
                     dailyDouble.plusCounter();
                     
                     System.out.println("The daily double counter is currently at ".toUpperCase() + dailyDouble.getCounter() + ".".toUpperCase());
                     
                     if(dailyDouble.getGamePhase() == 0)
                     {
                     
                        clueText.setText("In 2016, they became the first Musician to win the\n Nobel Prize for having created new poetic\n expression within the great \n American song tradition ".toUpperCase());
                     
                        answerA.setText("Arehta Franklin");
                     
                        answerB.setText("Neil Young");
                     
                        answerX.setText("Bob Dylan");
                     
                        answerY.setText("Chuck Berry");
                     
                        dailyDouble.setAnswerInt(2); //Bob Dylan
                        
                        dailyDouble.setCluePoints(400);
                  
                     }
                     
                     if(dailyDouble.getGamePhase() == 1)
                     {
                     
                        clueText.setText("Appearing on Earth over\n 400 Million Years ago, this group of animals\n are older than trees".toUpperCase());
                     
                        answerA.setText("Alligators");
                     
                        answerB.setText("Lice");
                     
                        answerX.setText("Sharks");
                     
                        answerY.setText("Cockroaches");
                     
                        dailyDouble.setAnswerInt(2); //Sharks
                        
                        dailyDouble.setCluePoints(800);
                     
                     }
                     
                     if (dailyDouble.getCounter() == dailyDouble.getValueA() || dailyDouble.getCounter() == dailyDouble.getValueB() || dailyDouble.getCounter() == dailyDouble.getValueC())
                        
                        {
                        
                           clueTextDD.setText(clueText.getText());
                           
                           answerADD.setText(answerA.getText());
                           
                           answerBDD.setText(answerB.getText());
                           
                           answerXDD.setText(answerX.getText());
                           
                           answerYDD.setText(answerY.getText());
                           
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
                  
                     answerA.setDisable(false); 
                     
                     answerB.setDisable(false);
                     
                     answerX.setDisable(false);
                     
                     answerY.setDisable(false);
                     
                     dailyDouble.resetIncorrectTracker();
                  
                     dailyDouble.plusCounter();
                     
                     System.out.println("The daily double counter is currently at ".toUpperCase() + dailyDouble.getCounter() + ".".toUpperCase());
                     
                     if(dailyDouble.getGamePhase() == 0)
                     {
                     
                        clueText.setText("This brass instrument, despite its appearance,\n is a member of the Woodwind family".toUpperCase());
                     
                        answerA.setText("Trombone");
                     
                        answerB.setText("Trumpet");
                     
                        answerX.setText("Saxaphone");
                     
                        answerY.setText("French Horn");
                     
                        dailyDouble.setAnswerInt(2); //Saxophone
                        
                        dailyDouble.setCluePoints(500);
                        
                     }
                     
                     if(dailyDouble.getGamePhase() == 1)
                     {
                        
                        
                        clueText.setText("Devil's Tower in Black Hills, Wyoming and Obsidian\n are both made of this rock".toUpperCase());
                     
                        answerA.setText("Sedimentary");
                     
                        answerB.setText("Igneous");
                     
                        answerX.setText("Metamorphic");
                     
                        answerY.setText("Phyllite");
                     
                        dailyDouble.setAnswerInt(1); //Igneous
                        
                        dailyDouble.setCluePoints(1000);
                        
                     }
                     
                     if (dailyDouble.getCounter() == dailyDouble.getValueA() || dailyDouble.getCounter() == dailyDouble.getValueB() || dailyDouble.getCounter() == dailyDouble.getValueC())
                        
                        {
                        
                           clueTextDD.setText(clueText.getText());
                           
                           answerADD.setText(answerA.getText());
                           
                           answerBDD.setText(answerB.getText());
                           
                           answerXDD.setText(answerX.getText());
                           
                           answerYDD.setText(answerY.getText());
                           
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
                  
                     if(dailyDouble.getGamePhase() == 0)
                     {
                     
                        categoryText.setText("Excelsior! (Comic Books)".toUpperCase()); //Category: Excelsior!
                        
                     }
                     
                     if(dailyDouble.getGamePhase() == 1)
                     {
                     
                        categoryText.setText("Vroom Vroom! (Cars)".toUpperCase()); //Category: Vroom Vroom!
                     
                     }
                     
                     window.setScene(categoryInfoScene);
                  
                  });
                  
               categoryE100.setOnAction( e ->  
                  
                  {  
                  
                     answerA.setDisable(false); 
                     
                     answerB.setDisable(false);
                     
                     answerX.setDisable(false);
                     
                     answerY.setDisable(false);
                     
                     dailyDouble.resetIncorrectTracker();
                  
                     dailyDouble.plusCounter();
                     
                     System.out.println("The daily double counter is currently at ".toUpperCase() + dailyDouble.getCounter() + ".".toUpperCase());
                     
                     if(dailyDouble.getGamePhase() == 0)
                     {
                     
                        clueText.setText("First appearing in 1936, this character is \nconsidered the first costumed superhero".toUpperCase());
                     
                        answerA.setText("Superman");
                     
                        answerB.setText("Arrow");
                     
                        answerX.setText("Crimson Avenger");
                     
                        answerY.setText("The Phantom");
                     
                        dailyDouble.setAnswerInt(3); //The Phantom
                        
                        dailyDouble.setCluePoints(100);
                        
                     }   
                     
                     if(dailyDouble.getGamePhase() == 1)
                     {
                     
                        clueText.setText("First Introduced in 1953, this vehicle\n earned the title 'America's Sports Car'".toUpperCase());
                     
                        answerA.setText("Challenger");
                     
                        answerB.setText("Corvette");
                     
                        answerX.setText("Camaro");
                     
                        answerY.setText("Charger");
                     
                        dailyDouble.setAnswerInt(1); //Corvette
                        
                        dailyDouble.setCluePoints(200);
                     
                     }
                     
                     if (dailyDouble.getCounter() == dailyDouble.getValueA() || dailyDouble.getCounter() == dailyDouble.getValueB() || dailyDouble.getCounter() == dailyDouble.getValueC())
                        
                        {
                        
                           clueTextDD.setText(clueText.getText());
                           
                           answerADD.setText(answerA.getText());
                           
                           answerBDD.setText(answerB.getText());
                           
                           answerXDD.setText(answerX.getText());
                           
                           answerYDD.setText(answerY.getText());
                           
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
                     
                     answerA.setDisable(false); 
                     
                     answerB.setDisable(false);
                     
                     answerX.setDisable(false);
                     
                     answerY.setDisable(false);
                     
                     dailyDouble.resetIncorrectTracker();
                  
                     dailyDouble.plusCounter();
                     
                     System.out.println("The daily double counter is currently at ".toUpperCase() + dailyDouble.getCounter() + ".".toUpperCase());
                     
                     if(dailyDouble.getGamePhase() == 0)
                     {
                     
                        clueText.setText("This actor was the first person to be\n hired to play a role in the \nMarvel Cinematic Universe".toUpperCase());
                        
                        answerA.setText("Terrence Howard");
                        
                        answerB.setText("Robert Downey Jr.");
                        
                        answerX.setText("Gwyneth Paltrow");
                        
                        answerY.setText("Jeff Bridges");
                        
                        dailyDouble.setAnswerInt(0); //Terrence Howard 
                        
                        dailyDouble.setCluePoints(200);
                        
                     }  
                     
                     if(dailyDouble.getGamePhase() == 1)
                     {
                     
                        clueText.setText("Made in Detroit, Michigan, this vehicle\n was the first mass produced \nautomobile in America".toUpperCase());
                        
                        answerA.setText("Model T");
                        
                        answerB.setText("Model A");
                        
                        answerX.setText("Parkard");
                        
                        answerY.setText("Benz Patent-Motorwagen");
                        
                        dailyDouble.setAnswerInt(0); //Model T
                        
                        dailyDouble.setCluePoints(400);
                        
                     } 
                     
                     if (dailyDouble.getCounter() == dailyDouble.getValueA() || dailyDouble.getCounter() == dailyDouble.getValueB() || dailyDouble.getCounter() == dailyDouble.getValueC())
                        
                        {
                        
                           clueTextDD.setText(clueText.getText());
                           
                           answerADD.setText(answerA.getText());
                           
                           answerBDD.setText(answerB.getText());
                           
                           answerXDD.setText(answerX.getText());
                           
                           answerYDD.setText(answerY.getText());
                           
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
                  
                     answerA.setDisable(false); 
                     
                     answerB.setDisable(false);
                     
                     answerX.setDisable(false);
                     
                     answerY.setDisable(false);
                     
                     dailyDouble.resetIncorrectTracker();
                  
                     dailyDouble.plusCounter();
                     
                     System.out.println("The daily double counter is currently at ".toUpperCase() + dailyDouble.getCounter() + ".".toUpperCase());
                     
                     if(dailyDouble.getGamePhase() == 0)
                     {
                     
                        clueText.setText("This building served as the original\n headquarters for Fantastic Four".toUpperCase());
                        
                        answerA.setText("Baxter Building");
                        
                        answerB.setText("Titans Tower");
                        
                        answerX.setText("Stark Tower");
                        
                        answerY.setText("Four Freedom Plaza");
                        
                        dailyDouble.setAnswerInt(0); //Baxter Building
                        
                        dailyDouble.setCluePoints(300);
                        
                     }
                     
                     if(dailyDouble.getGamePhase() == 1)
                     {
                     
                        clueText.setText("This Hot-Hatch was driven\n in Ken Block's famous Gymkhana 9 ".toUpperCase());
                        
                        answerA.setText("Hyundai Veloster N");
                        
                        answerB.setText("Ford Focus RS RX");
                        
                        answerX.setText("Toyota Corolla iM");
                        
                        answerY.setText("Subaru WRX");
                        
                        dailyDouble.setAnswerInt(1); //Ford Focus RS RX
                        
                        dailyDouble.setCluePoints(600);
                     
                     }
                     
                     
                     if (dailyDouble.getCounter() == dailyDouble.getValueA() || dailyDouble.getCounter() == dailyDouble.getValueB() || dailyDouble.getCounter() == dailyDouble.getValueC())
                        
                        {
                        
                           clueTextDD.setText(clueText.getText());
                           
                           answerADD.setText(answerA.getText());
                           
                           answerBDD.setText(answerB.getText());
                           
                           answerXDD.setText(answerX.getText());
                           
                           answerYDD.setText(answerY.getText());
                           
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
                  
                     answerA.setDisable(false); 
                     
                     answerB.setDisable(false);
                     
                     answerX.setDisable(false);
                     
                     answerY.setDisable(false);
                     
                     dailyDouble.resetIncorrectTracker();
                     
                     dailyDouble.plusCounter();
                     
                     System.out.println("The daily double counter is currently at ".toUpperCase() + dailyDouble.getCounter() + ".".toUpperCase());
                     
                     if(dailyDouble.getGamePhase() == 0)
                     {
                     
                        clueText.setText("This Japanese comic series\n is known for having over 200 musical references \nspread across its 30 plus year print run".toUpperCase());
                        
                        answerA.setText("Golgo 13");
                        
                        answerB.setText("One Piece");
                        
                        answerX.setText("Dragon Ball Franchise");
                        
                        answerY.setText("JoJo's Bizarre Adventure");
                        
                        dailyDouble.setAnswerInt(3); //Jojo's Bizzare Adventure 
                        
                        dailyDouble.setCluePoints(400);
                     
                     }
                     
                     if(dailyDouble.getGamePhase() == 1)
                     {
                     
                        clueText.setText("This was the first commercially available\n hybrid gasoline-electric in\n the United States".toUpperCase());
                        
                        answerA.setText("Ford Escape Hybrid");
                        
                        answerB.setText("Tesla Model 3");
                        
                        answerX.setText("Toyota Prius");
                        
                        answerY.setText("Honda Insight");
                        
                        dailyDouble.setAnswerInt(3); //Honda Insight
                        
                        dailyDouble.setCluePoints(800);
                     
                     }
                     
                     if (dailyDouble.getCounter() == dailyDouble.getValueA() || dailyDouble.getCounter() == dailyDouble.getValueB() || dailyDouble.getCounter() == dailyDouble.getValueC())
                        
                        {
                        
                           clueTextDD.setText(clueText.getText());
                           
                           answerADD.setText(answerA.getText());
                           
                           answerBDD.setText(answerB.getText());
                           
                           answerXDD.setText(answerX.getText());
                           
                           answerYDD.setText(answerY.getText());
                           
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
                  
                     answerA.setDisable(false); 
                     
                     answerB.setDisable(false);
                     
                     answerX.setDisable(false);
                     
                     answerY.setDisable(false);
                     
                     dailyDouble.resetIncorrectTracker();
                  
                     dailyDouble.plusCounter();
                     
                     System.out.println("The daily double counter is currently at ".toUpperCase() + dailyDouble.getCounter() + ".".toUpperCase());
                     
                     if(dailyDouble.getGamePhase() == 0)
                     {
                     
                        clueText.setText("While well known today as a big Green Giant, \n the Incredible Hulk' skin was originally\n printed this color".toUpperCase());
                        
                        answerA.setText("White");
                        
                        answerB.setText("Grey");
                        
                        answerX.setText("Purple");
                        
                        answerY.setText("Red");
                        
                        dailyDouble.setAnswerInt(1); //Grey
                        
                        dailyDouble.setCluePoints(500);
                     
                     }
                     
                     if(dailyDouble.getGamePhase() == 1)
                     {
                     
                        clueText.setText("Selling more than one million units in 1965, \n this car set a record that\n still stands today".toUpperCase());
                        
                        answerA.setText("Buick Wildcat");
                        
                        answerB.setText("Pontiac GTO");
                        
                        answerX.setText("Ford Thunderbird");
                        
                        answerY.setText("Chevrolet Impala");
                        
                        dailyDouble.setAnswerInt(3); // Chevrolet Impala
                        
                        dailyDouble.setCluePoints(1000);
                     
                     
                     }
                     
                     if (dailyDouble.getCounter() == dailyDouble.getValueA() || dailyDouble.getCounter() == dailyDouble.getValueB() || dailyDouble.getCounter() == dailyDouble.getValueC())
                        
                        {
                        
                           clueTextDD.setText(clueText.getText());
                           
                           answerADD.setText(answerA.getText());
                           
                           answerBDD.setText(answerB.getText());
                           
                           answerXDD.setText(answerX.getText());
                           
                           answerYDD.setText(answerY.getText());
                           
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
                  
                     if(dailyDouble.getGamePhase() == 0)
                     {
                     
                        categoryText.setText("G.O.A.T \n Record Setting Teams/Players".toUpperCase()); //Category: G.O.A.T
                     
                     }
                     
                     if(dailyDouble.getGamePhase() == 1)
                     {
                        
                        categoryText.setText("Higher Learning (Universities)".toUpperCase()); //Category: Higher Learning
                     
                     }
                     
                     window.setScene(categoryInfoScene);
                  
                  });
                  
               categoryF100.setOnAction( e ->  
                  
                  {  
                  
                     answerA.setDisable(false); 
                     
                     answerB.setDisable(false);
                     
                     answerX.setDisable(false);
                     
                     answerY.setDisable(false);
                     
                     dailyDouble.resetIncorrectTracker();
                  
                     dailyDouble.plusCounter();
                     
                     System.out.println("The daily double counter is currently at ".toUpperCase() + dailyDouble.getCounter() + ".".toUpperCase());
                     
                     if(dailyDouble.getGamePhase() == 0)
                     {
                     
                        clueText.setText("This pitcher holds the record for the most\n complete games in an MLB career".toUpperCase());
                        
                        answerA.setText("Roy Halladay");
                        
                        answerB.setText("Nolan Ryan");
                        
                        answerX.setText("Cy Young");
                        
                        answerY.setText("Don Sutton");
                        
                        dailyDouble.setAnswerInt(2); //Cy Young
                        
                        dailyDouble.setCluePoints(100);
                     }
                     
                     if(dailyDouble.getGamePhase() == 1)
                     {
                        
                        clueText.setText("This institution is the second-oldest\n college in the United States".toUpperCase());
                        
                        answerA.setText("Washington and Lee University");
                        
                        answerB.setText("Brown University");
                        
                        answerX.setText("College of William and Mary");
                        
                        answerY.setText("University of Virginia");
                        
                        dailyDouble.setAnswerInt(1); //Brown University
                        
                        dailyDouble.setCluePoints(200);
                     
                     }
                     
                     if (dailyDouble.getCounter() == dailyDouble.getValueA() || dailyDouble.getCounter() == dailyDouble.getValueB() || dailyDouble.getCounter() == dailyDouble.getValueC())
                        
                        {
                        
                           clueTextDD.setText(clueText.getText());
                           
                           answerADD.setText(answerA.getText());
                           
                           answerBDD.setText(answerB.getText());
                           
                           answerXDD.setText(answerX.getText());
                           
                           answerYDD.setText(answerY.getText());
                           
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
                  
                     answerA.setDisable(false); 
                     
                     answerB.setDisable(false);
                     
                     answerX.setDisable(false);
                     
                     answerY.setDisable(false);
                     
                     dailyDouble.resetIncorrectTracker();
                  
                     dailyDouble.plusCounter();
                     
                     System.out.println("The daily double counter is currently at ".toUpperCase() + dailyDouble.getCounter() + ".".toUpperCase());
                     
                     if(dailyDouble.getGamePhase() == 0)
                     {
                     
                        clueText.setText("This player was the only player in the NBA \n history to be named the Most Valuable \n Player, Coach of the Year, and\n executive of the Year".toUpperCase());
                        
                        answerA.setText("Phil Jackson");
                        
                        answerB.setText("Magic Johnson");
                        
                        answerX.setText("Michael Jordan");
                        
                        answerY.setText("Larry Bird");
                        
                        dailyDouble.setAnswerInt(3); //Larry Bird
                        
                        dailyDouble.setCluePoints(200);
                     
                     }
                     
                     if(dailyDouble.getGamePhase() == 1)
                     {
                     
                        clueText.setText("Established in 1636, this institution\n has had more US Presidents graduate\n from it than any other school".toUpperCase());
                        
                        answerA.setText("Yale University");
                        
                        answerB.setText("Harvard University");
                        
                        answerX.setText("Georgetown University");
                        
                        answerY.setText("Standford University");
                        
                        dailyDouble.setAnswerInt(1); //Harvard University
                        
                        dailyDouble.setCluePoints(400);
                     
                     }
                     
                     if (dailyDouble.getCounter() == dailyDouble.getValueA() || dailyDouble.getCounter() == dailyDouble.getValueB() || dailyDouble.getCounter() == dailyDouble.getValueC())
                        
                        {
                        
                           clueTextDD.setText(clueText.getText());
                           
                           answerADD.setText(answerA.getText());
                           
                           answerBDD.setText(answerB.getText());
                           
                           answerXDD.setText(answerX.getText());
                           
                           answerYDD.setText(answerY.getText());
                           
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
                  
                     answerA.setDisable(false); 
                     
                     answerB.setDisable(false);
                     
                     answerX.setDisable(false);
                     
                     answerY.setDisable(false);
                     
                     dailyDouble.resetIncorrectTracker();
                  
                     dailyDouble.plusCounter();
                     
                     System.out.println("The daily double counter is currently at ".toUpperCase() + dailyDouble.getCounter() + ".".toUpperCase());
                     
                     if(dailyDouble.getGamePhase() == 0)
                     {
                     
                        clueText.setText("This American Olympian is the most\n decorated olympic athlete of all time".toUpperCase());
                        
                        answerA.setText("Carl Lewis");
                        
                        answerB.setText("Mary Lou Retton");
                        
                        answerX.setText("Michael Phelps");
                        
                        answerY.setText("Paavo Nurmi");
                        
                        dailyDouble.setAnswerInt(2); //Michael Phelps
                        
                        dailyDouble.setCluePoints(300);
                     
                     }
                     
                     if(dailyDouble.getGamePhase() == 1)
                     {
                     
                        clueText.setText("This country is the number one country of\n origin for foreign students in the US".toUpperCase());
                     
                        answerA.setText("India");
                     
                        answerB.setText("China");
                     
                        answerX.setText("South Korea");
                     
                        answerY.setText("Vietnam");
                     
                        dailyDouble.setAnswerInt(1); //China
                        
                        dailyDouble.setCluePoints(600);
                        
                     }
                     
                     if (dailyDouble.getCounter() == dailyDouble.getValueA() || dailyDouble.getCounter() == dailyDouble.getValueB() || dailyDouble.getCounter() == dailyDouble.getValueC())
                        
                        {
                        
                           clueTextDD.setText(clueText.getText());
                           
                           answerADD.setText(answerA.getText());
                           
                           answerBDD.setText(answerB.getText());
                           
                           answerXDD.setText(answerX.getText());
                           
                           answerYDD.setText(answerY.getText());
                           
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
                  
                     answerA.setDisable(false); 
                     
                     answerB.setDisable(false);
                     
                     answerX.setDisable(false);
                     
                     answerY.setDisable(false);
                     
                     dailyDouble.resetIncorrectTracker();
                     
                     dailyDouble.plusCounter();
                     
                     System.out.println("The daily double counter is currently at ".toUpperCase() + dailyDouble.getCounter() + ".".toUpperCase());
                     
                     if(dailyDouble.getGamePhase() == 0)
                     {
                     
                        clueText.setText("During the 1992 Olympic Games, the US\n Men's Basketball 'Dream Team'\n played against this country in the gold \n medal match, winning 117-85 ".toUpperCase());
                        
                        answerA.setText("Brazil");
                        
                        answerB.setText("Croatia");
                        
                        answerX.setText("Puerto Rico");
                        
                        answerY.setText("Germany");
                        
                        dailyDouble.setAnswerInt(1); //Croatia
                        
                        dailyDouble.setCluePoints(400);
                     }
                     
                     if(dailyDouble.getGamePhase() == 1)
                     {
                     
                        clueText.setText("Located in Blue Blue Pennsylvania, \n Montgomery County Community College had \nits original location in \nthis Philly Suburb ".toUpperCase());
                        
                        answerA.setText("Plymouth Meeting");
                        
                        answerB.setText("Montgomeryville");
                        
                        answerX.setText("Conshohocken");
                        
                        answerY.setText("King of Prussia");
                        
                        dailyDouble.setAnswerInt(2); //Conshohocken
                        
                        dailyDouble.setCluePoints(800);
                     
                     }
                     
                     if (dailyDouble.getCounter() == dailyDouble.getValueA() || dailyDouble.getCounter() == dailyDouble.getValueB() || dailyDouble.getCounter() == dailyDouble.getValueC())
                        
                        {
                        
                           clueTextDD.setText(clueText.getText());
                           
                           answerADD.setText(answerA.getText());
                           
                           answerBDD.setText(answerB.getText());
                           
                           answerXDD.setText(answerX.getText());
                           
                           answerYDD.setText(answerY.getText());
                           
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
                     
                     answerA.setDisable(false); 
                     
                     answerB.setDisable(false);
                     
                     answerX.setDisable(false);
                     
                     answerY.setDisable(false);
                     
                     dailyDouble.resetIncorrectTracker();
                  
                     dailyDouble.plusCounter();
                     
                     System.out.println("The daily double counter is currently at ".toUpperCase() + dailyDouble.getCounter() + ".".toUpperCase());
                     
                     if(dailyDouble.getGamePhase() == 0)
                     {
                     
                     
                        clueText.setText("This MLB player holds the record for\n most Grand Slams in one inning".toUpperCase());
                        
                        answerA.setText("Barry Bonds");
                        
                        answerB.setText("Fernando Tatis");
                        
                        answerX.setText("Mark Mcgwire");
                        
                        answerY.setText("Babe Ruth");

                        dailyDouble.setAnswerInt(1); // Fernando Tatis
                        
                        dailyDouble.setCluePoints(500);
                     
                     }
                     
                     if(dailyDouble.getGamePhase() == 1)
                     {
                     
                        clueText.setText("With 11 championships, this school's \n basketball team has won the NCAA Division I Men's \n Basketball Tournament more than any other teams".toUpperCase());
                        
                        answerA.setText("UCLA");
                        
                        answerB.setText("Duke University");
                        
                        answerX.setText("Villanova");
                        
                        answerY.setText("UNC");

                        dailyDouble.setAnswerInt(0); //UCLA
                        
                        dailyDouble.setCluePoints(1000);
                     
                     }
                     
                     
                     if (dailyDouble.getCounter() == dailyDouble.getValueA() || dailyDouble.getCounter() == dailyDouble.getValueB() || dailyDouble.getCounter() == dailyDouble.getValueC())
                        
                        {
                        
                           clueTextDD.setText(clueText.getText());
                           
                           answerADD.setText(answerA.getText());
                           
                           answerBDD.setText(answerB.getText());
                           
                           answerXDD.setText(answerX.getText());
                           
                           answerYDD.setText(answerY.getText());
                           
                           window.setScene(dailyDoubleScene1);

                        
                        }
                        
                     else
                        
                        {
                        
                        window.setScene(clueScene);
                        
                        }
                     
                     categoryF500.setDisable(true);
                     
                     categoryF500.setText("        ");
                  
                  });

               answerA.setOnAction( e ->  
                  
                  {
                  
                     if (dailyDouble.getTurn() == 0)  //This if statement handles player 1
                        
                        {
                        
                           if (dailyDouble.getAnswerInt() == 0)
                              
                              {
                              
                                  answerA.setText(answerA.getText() + "\nCorrect!");
                                  
                                  answerB.setDisable(true); //prevents the other buttons from being pressed, that way the player can't select a wrong answer after selecting the right answer.
                                  
                                  answerX.setDisable(true); 
                                  
                                  answerY.setDisable(true);  
                                  
                                  player1.plusScore(dailyDouble.getCluePoints());
                                  
                                  player1ScoreLabel.setText("Player 1:\n" + player1.getScore());
                                  
                                  
                              
                              }
                              
                           else 
                              
                              {
                              
                                 
                                 
                                 answerA.setText(answerA.getText() + "\nIncorrect");
                                 
                                 answerA.setDisable(true);
                                 
                                 player1.minusScore(dailyDouble.getCluePoints());
                                 
                                 player1ScoreLabel.setText("Player 1:\n" + player1.getScore());
                                 
                                 dailyDouble.changeTurn();
                                 
                                 gameboardTurnTrackerLabel.setText("Player 2 \nControls The Board");
                                 
                                 clueTurnTrackerLabel.setText("Player 2 \nControls The Board");
                                 
                                 dailyDouble.plusIncorrectTracker();
                                 
                                 if (dailyDouble.getIncorrectTracker() == 3)
                                    
                                    {
                                    
                                       dailyDouble.resetIncorrectTracker();
                                       
                                       answerA.setDisable(true);
                                       answerB.setDisable(true);
                                       answerX.setDisable(true);
                                       answerY.setDisable(true);
                                       
                                    }
                              
                              }
                           
                        
                        }
                        
                     
                     else if (dailyDouble.getTurn() == 1)  //This if statement handles player 2
                        
                        {
                        
                           if (dailyDouble.getAnswerInt() == 0)
                              
                              {
                              
                                  answerA.setText(answerA.getText() + "\nCorrect!");
                                  
                                  answerB.setDisable(true); //prevents the other buttons from being pressed, that way the player can't select a wrong answer after selecting the right answer.
                                  
                                  answerX.setDisable(true); 
                                  
                                  answerY.setDisable(true);  
                                  
                                  player2.plusScore(dailyDouble.getCluePoints());
                                  
                                  player2ScoreLabel.setText("Player 2:\n" + player2.getScore());
                                  
                                  
                              
                              }
                              
                           else 
                              
                              {
                              
                                 
                                 
                                 answerA.setText(answerA.getText() + "\nIncorrect");
                                 
                                 answerA.setDisable(true);
                                 
                                 player2.minusScore(dailyDouble.getCluePoints());
                                 
                                 player2ScoreLabel.setText("Player 2:\n" + player2.getScore());
                                 
                                 dailyDouble.changeTurn();
                                 
                                 gameboardTurnTrackerLabel.setText("Player 3 \nControls The Board");
                                 
                                 clueTurnTrackerLabel.setText("Player 3 \nControls The Board");
                                 
                                 dailyDouble.plusIncorrectTracker();
                                 
                                 if (dailyDouble.getIncorrectTracker() == 3)
                                    
                                    {
                                    
                                       dailyDouble.resetIncorrectTracker();
                                       
                                       answerA.setDisable(true);
                                       answerB.setDisable(true);
                                       answerX.setDisable(true);
                                       answerY.setDisable(true);
                                       
                                    }
                              
                              }
                           
                        
                        }
                        
                        
                        
                     else if (dailyDouble.getTurn() == 2)  //This if statement handles player 3
                        
                        {
                        
                           if (dailyDouble.getAnswerInt() == 0)
                              
                              {
                              
                                  answerA.setText(answerA.getText() + "\nCorrect!");
                                  
                                  answerB.setDisable(true); //prevents the other buttons from being pressed, that way the player can't select a wrong answer after selecting the right answer.
                                  
                                  answerX.setDisable(true); 
                                  
                                  answerY.setDisable(true);  
                                  
                                  player3.plusScore(dailyDouble.getCluePoints());
                                  
                                  player3ScoreLabel.setText("Player 3:\n" + player3.getScore());
                                  
                                  
                              
                              }
                              
                           else 
                              
                              {
                              
                                 
                                 
                                 answerA.setText(answerA.getText() + "\nIncorrect");
                                 
                                 answerA.setDisable(true);
                                 
                                 player3.minusScore(dailyDouble.getCluePoints());
                                 
                                 player3ScoreLabel.setText("Player 3:\n" + player3.getScore());
                                 
                                 dailyDouble.changeTurn();
                                 
                                 gameboardTurnTrackerLabel.setText("Player 1 \nControls The Board");
                                 
                                 clueTurnTrackerLabel.setText("Player 1 \nControls The Board");
                                 
                                 dailyDouble.plusIncorrectTracker();
                                 
                                 if (dailyDouble.getIncorrectTracker() == 3)
                                    
                                    {
                                    
                                       dailyDouble.resetIncorrectTracker();
                                       
                                       answerA.setDisable(true);
                                       answerB.setDisable(true);
                                       answerX.setDisable(true);
                                       answerY.setDisable(true);
                                       
                                    }
                              
                              }
                        
                        }
                        
                        
                  
                  });
                  
                  answerB.setOnAction( e ->  
                  
                  {
                  
                     if (dailyDouble.getTurn() == 0)  //This if statement handles player 1
                        
                        {
                        
                           if (dailyDouble.getAnswerInt() == 1)
                              
                              {
                              
                                  answerB.setText(answerB.getText() + "\nCorrect!");
                                  
                                  answerA.setDisable(true); //prevents the other buttons from being pressed, that way the player can't select a wrong answer after selecting the right answer.
                                  
                                  answerX.setDisable(true); 
                                  
                                  answerY.setDisable(true);  
                                  
                                  player1.plusScore(dailyDouble.getCluePoints());
                                  
                                  player1ScoreLabel.setText("Player 1:\n" + player1.getScore());
                                  
                                  
                              
                              }
                              
                           else 
                              
                              {
                              
                                 
                                 
                                 answerB.setText(answerB.getText() + "\nIncorrect");
                                 
                                 answerB.setDisable(true);
                                 
                                 player1.minusScore(dailyDouble.getCluePoints());
                                 
                                 player1ScoreLabel.setText("Player 1:\n" + player1.getScore());
                                 
                                 dailyDouble.changeTurn();
                                 
                                 gameboardTurnTrackerLabel.setText("Player 2 \nControls The Board");
                                 
                                 clueTurnTrackerLabel.setText("Player 2 \nControls The Board");
                                 
                                 dailyDouble.plusIncorrectTracker();
                                 
                                 if (dailyDouble.getIncorrectTracker() == 3)
                                    
                                    {
                                    
                                       dailyDouble.resetIncorrectTracker();
                                       
                                       answerA.setDisable(true);
                                       answerB.setDisable(true);
                                       answerX.setDisable(true);
                                       answerY.setDisable(true);
                                       
                                    }
                              
                              }
                           
                        
                        }
                        
                     
                     else if (dailyDouble.getTurn() == 1)  //This if statement handles player 2
                        
                        {
                        
                           if (dailyDouble.getAnswerInt() == 1)
                              
                              {
                              
                                  answerB.setText(answerB.getText() + "\nCorrect!");
                                  
                                  answerA.setDisable(true); //prevents the other buttons from being pressed, that way the player can't select a wrong answer after selecting the right answer.
                                  
                                  answerX.setDisable(true); 
                                  
                                  answerY.setDisable(true);  
                                  
                                  player2.plusScore(dailyDouble.getCluePoints());
                                  
                                  player2ScoreLabel.setText("Player 2:\n" + player2.getScore());
                                  
                                  
                              
                              }
                              
                           else 
                              
                              {
                              
                                 
                                 
                                 answerB.setText(answerB.getText() + "\nIncorrect");
                                 
                                 answerB.setDisable(true);
                                 
                                 player2.minusScore(dailyDouble.getCluePoints());
                                 
                                 player2ScoreLabel.setText("Player 2:\n" + player2.getScore());
                                 
                                 dailyDouble.changeTurn();
                                 
                                 gameboardTurnTrackerLabel.setText("Player 3 \nControls The Board");
                                 
                                 clueTurnTrackerLabel.setText("Player 3 \nControls The Board");
                                 
                                 dailyDouble.plusIncorrectTracker();
                                 
                                 if (dailyDouble.getIncorrectTracker() == 3)
                                    
                                    {
                                    
                                       dailyDouble.resetIncorrectTracker();
                                       
                                       answerA.setDisable(true);
                                       answerB.setDisable(true);
                                       answerX.setDisable(true);
                                       answerY.setDisable(true);
                                       
                                    }
                              
                              }
                           
                        
                        }
                        
                        
                        
                     else if (dailyDouble.getTurn() == 2)  //This if statement handles player 3
                        
                        {
                        
                           if (dailyDouble.getAnswerInt() == 1)
                              
                              {
                              
                                  answerB.setText(answerB.getText() + "\nCorrect!");
                                  
                                  answerA.setDisable(true); //prevents the other buttons from being pressed, that way the player can't select a wrong answer after selecting the right answer.
                                  
                                  answerX.setDisable(true); 
                                  
                                  answerY.setDisable(true);  
                                  
                                  player3.plusScore(dailyDouble.getCluePoints());
                                  
                                  player3ScoreLabel.setText("Player 3:\n" + player3.getScore());
                                  
                                  
                              
                              }
                              
                           else 
                              
                              {
                              
                                 
                                 
                                 answerB.setText(answerB.getText() + "\nIncorrect");
                                 
                                 answerB.setDisable(true);
                                 
                                 player3.minusScore(dailyDouble.getCluePoints());
                                 
                                 player3ScoreLabel.setText("Player 3:\n" + player3.getScore());
                                 
                                 dailyDouble.changeTurn();
                                 
                                 gameboardTurnTrackerLabel.setText("Player 1 \nControls The Board");
                                 
                                 clueTurnTrackerLabel.setText("Player 1 \nControls The Board");
                                 
                                 dailyDouble.plusIncorrectTracker();
                                 
                                 if (dailyDouble.getIncorrectTracker() == 3)
                                    
                                    {
                                    
                                       dailyDouble.resetIncorrectTracker();
                                       
                                       answerA.setDisable(true);
                                       answerB.setDisable(true);
                                       answerX.setDisable(true);
                                       answerY.setDisable(true);
                                       
                                    }
                              
                              }
                        
                        }
                        
                        
                  
                  }); 
                  
                  answerX.setOnAction( e ->  
                  
                  {
                  
                     if (dailyDouble.getTurn() == 0)  //This if statement handles player 1
                        
                        {
                        
                           if (dailyDouble.getAnswerInt() == 2)
                              
                              {
                              
                                  answerX.setText(answerX.getText() + "\nCorrect!");
                                  
                                  answerA.setDisable(true); //prevents the other buttons from being pressed, that way the player can't select a wrong answer after selecting the right answer.
                                  
                                  answerB.setDisable(true); 
                                  
                                  answerY.setDisable(true);  
                                  
                                  player1.plusScore(dailyDouble.getCluePoints());
                                  
                                  player1ScoreLabel.setText("Player 1:\n" + player1.getScore());
                                  
                                  
                              
                              }
                              
                           else 
                              
                              {
                              
                                 
                                 
                                 answerX.setText(answerX.getText() + "\nIncorrect");
                                 
                                 answerX.setDisable(true);
                                 
                                 player1.minusScore(dailyDouble.getCluePoints());
                                 
                                 player1ScoreLabel.setText("Player 1:\n" + player1.getScore());
                                 
                                 dailyDouble.changeTurn();
                                 
                                 gameboardTurnTrackerLabel.setText("Player 2 \nControls The Board");
                                 
                                 clueTurnTrackerLabel.setText("Player 2 \nControls The Board");
                                 
                                 dailyDouble.plusIncorrectTracker();
                                 
                                 if (dailyDouble.getIncorrectTracker() == 3)
                                    
                                    {
                                    
                                       dailyDouble.resetIncorrectTracker();
                                       
                                       answerA.setDisable(true);
                                       answerB.setDisable(true);
                                       answerX.setDisable(true);
                                       answerY.setDisable(true);
                                       
                                    }
                              
                              }
                           
                        
                        }
                        
                     
                     else if (dailyDouble.getTurn() == 1)  //This if statement handles player 2
                        
                        {
                        
                           if (dailyDouble.getAnswerInt() == 2)
                              
                              {
                              
                                  answerX.setText(answerX.getText() + "\nCorrect!");
                                  
                                  answerB.setDisable(true); //prevents the other buttons from being pressed, that way the player can't select a wrong answer after selecting the right answer.
                                  
                                  answerA.setDisable(true); 
                                  
                                  answerY.setDisable(true);  
                                  
                                  player2.plusScore(dailyDouble.getCluePoints());
                                  
                                  player2ScoreLabel.setText("Player 2:\n" + player2.getScore());
                                  
                                  
                              
                              }
                              
                           else 
                              
                              {
                              
                                 
                                 
                                 answerX.setText(answerX.getText() + "\nIncorrect");
                                 
                                 answerX.setDisable(true);
                                 
                                 player2.minusScore(dailyDouble.getCluePoints());
                                 
                                 player2ScoreLabel.setText("Player 2:\n" + player2.getScore());
                                 
                                 dailyDouble.changeTurn();
                                 
                                 gameboardTurnTrackerLabel.setText("Player 3 \nControls The Board");
                                 
                                 clueTurnTrackerLabel.setText("Player 3 \nControls The Board");
                                 
                                 dailyDouble.plusIncorrectTracker();
                                 
                                 if (dailyDouble.getIncorrectTracker() == 3)
                                    
                                    {
                                    
                                       dailyDouble.resetIncorrectTracker();
                                       
                                       answerA.setDisable(true);
                                       answerB.setDisable(true);
                                       answerX.setDisable(true);
                                       answerY.setDisable(true);
                                       
                                    }
                              
                              }
                           
                        
                        }
                        
                        
                        
                     else if (dailyDouble.getTurn() == 2)  //This if statement handles player 3
                        
                        {
                        
                           if (dailyDouble.getAnswerInt() == 2)
                              
                              {
                              
                                  answerX.setText(answerX.getText() + "\nCorrect!");
                                  
                                  answerB.setDisable(true); //prevents the other buttons from being pressed, that way the player can't select a wrong answer after selecting the right answer.
                                  
                                  answerA.setDisable(true); 
                                  
                                  answerY.setDisable(true);  
                                  
                                  player3.plusScore(dailyDouble.getCluePoints());
                                  
                                  player3ScoreLabel.setText("Player 3:\n" + player3.getScore());
                                  
                                  
                              
                              }
                              
                           else 
                              
                              {
                              
                                 
                                 
                                 answerX.setText(answerX.getText() + "\nIncorrect");
                                 
                                 answerX.setDisable(true);
                                 
                                 player3.minusScore(dailyDouble.getCluePoints());
                                 
                                 player3ScoreLabel.setText("Player 3:\n" + player3.getScore());
                                 
                                 dailyDouble.changeTurn();
                                 
                                 gameboardTurnTrackerLabel.setText("Player 1 \nControls The Board");
                                 
                                 clueTurnTrackerLabel.setText("Player 1 \nControls The Board");
                                 
                                 dailyDouble.plusIncorrectTracker();
                                 
                                 if (dailyDouble.getIncorrectTracker() == 3)
                                    
                                    {
                                    
                                       dailyDouble.resetIncorrectTracker();
                                       
                                       answerA.setDisable(true);
                                       answerB.setDisable(true);
                                       answerX.setDisable(true);
                                       answerY.setDisable(true);
                                       
                                    }
                              
                              }
                        
                        }
                        
                        
                  
                  });    
                  
                  
                  answerY.setOnAction( e ->  
                  
                  {
                  
                     if (dailyDouble.getTurn() == 0)  //This if statement handles player 1
                        
                        {
                        
                           if (dailyDouble.getAnswerInt() == 3)
                              
                              {
                              
                                  answerY.setText(answerY.getText() + "\nCorrect!");
                                  
                                  answerB.setDisable(true); //prevents the other buttons from being pressed, that way the player can't select a wrong answer after selecting the right answer.
                                  
                                  answerX.setDisable(true); 
                                  
                                  answerA.setDisable(true);  
                                  
                                  player1.plusScore(dailyDouble.getCluePoints());
                                  
                                  player1ScoreLabel.setText("Player 1:\n" + player1.getScore());
                                  
                                  
                              
                              }
                              
                           else 
                              
                              {
                              
                                 
                                 
                                 answerY.setText(answerY.getText() + "\nIncorrect");
                                 
                                 answerY.setDisable(true);
                                 
                                 player1.minusScore(dailyDouble.getCluePoints());
                                 
                                 player1ScoreLabel.setText("Player 1:\n" + player1.getScore());
                                 
                                 dailyDouble.changeTurn();
                                 
                                 gameboardTurnTrackerLabel.setText("Player 2 \nControls The Board");
                                 
                                 clueTurnTrackerLabel.setText("Player 2 \nControls The Board");
                                 
                                 dailyDouble.plusIncorrectTracker();
                                 
                                 if (dailyDouble.getIncorrectTracker() == 3)
                                    
                                    {
                                    
                                       dailyDouble.resetIncorrectTracker();
                                       
                                       answerA.setDisable(true);
                                       answerB.setDisable(true);
                                       answerX.setDisable(true);
                                       answerY.setDisable(true);
                                       
                                    }
                              
                              }
                           
                        
                        }
                        
                     
                     else if (dailyDouble.getTurn() == 1)  //This if statement handles player 2
                        
                        {
                        
                           if (dailyDouble.getAnswerInt() == 3)
                              
                              {
                              
                                  answerY.setText(answerY.getText() + "\nCorrect!");
                                  
                                  answerB.setDisable(true); //prevents the other buttons from being pressed, that way the player can't select a wrong answer after selecting the right answer.
                                  
                                  answerX.setDisable(true); 
                                  
                                  answerA.setDisable(true);  
                                  
                                  player2.plusScore(dailyDouble.getCluePoints());
                                  
                                  player2ScoreLabel.setText("Player 2:\n" + player2.getScore());
                                  
                                  
                              
                              }
                              
                           else 
                              
                              {
                              
                                 
                                 
                                 answerY.setText(answerY.getText() + "\nIncorrect");
                                 
                                 answerY.setDisable(true);
                                 
                                 player2.minusScore(dailyDouble.getCluePoints());
                                 
                                 player2ScoreLabel.setText("Player 2:\n" + player2.getScore());
                                 
                                 dailyDouble.changeTurn();
                                 
                                 gameboardTurnTrackerLabel.setText("Player 3 \nControls The Board");
                                 
                                 clueTurnTrackerLabel.setText("Player 3 \nControls The Board");
                                 
                                 dailyDouble.plusIncorrectTracker();
                                 
                                 if (dailyDouble.getIncorrectTracker() == 3)
                                    
                                    {
                                    
                                       dailyDouble.resetIncorrectTracker();
                                       
                                       answerA.setDisable(true);
                                       answerB.setDisable(true);
                                       answerX.setDisable(true);
                                       answerY.setDisable(true);
                                       
                                    }
                              
                              }
                           
                        
                        }
                        
                        
                        
                     else if (dailyDouble.getTurn() == 2)  //This if statement handles player 3
                        
                        {
                        
                           if (dailyDouble.getAnswerInt() == 3)
                              
                              {
                              
                                  answerY.setText(answerY.getText() + "\nCorrect!");
                                  
                                  answerB.setDisable(true); //prevents the other buttons from being pressed, that way the player can't select a wrong answer after selecting the right answer.
                                  
                                  answerX.setDisable(true); 
                                  
                                  answerA.setDisable(true);  
                                  
                                  player3.plusScore(dailyDouble.getCluePoints());
                                  
                                  player3ScoreLabel.setText("Player 3:\n" + player3.getScore());
                                  
                                  
                              
                              }
                              
                           else 
                              
                              {
                              
                                 
                                 
                                 answerY.setText(answerY.getText() + "\nIncorrect");
                                 
                                 answerY.setDisable(true);
                                 
                                 player3.minusScore(dailyDouble.getCluePoints());
                                 
                                 player3ScoreLabel.setText("Player 3:\n" + player3.getScore());
                                 
                                 dailyDouble.changeTurn();
                                 
                                 gameboardTurnTrackerLabel.setText("Player 1 \nControls The Board");
                                 
                                 clueTurnTrackerLabel.setText("Player 1 \nControls The Board");
                                 
                                 dailyDouble.plusIncorrectTracker();
                                 
                                 if (dailyDouble.getIncorrectTracker() == 3)
                                    
                                    {
                                    
                                       dailyDouble.resetIncorrectTracker();
                                       
                                       answerA.setDisable(true);
                                       answerB.setDisable(true);
                                       answerX.setDisable(true);
                                       answerY.setDisable(true);
                                       
                                    }
                              
                              }
                        
                        }
                        
                        
                  
                  });
                  
            //Daily Double Clue Scene Buttons
               
               
               answerADD.setOnAction( e ->  
                  
                  {
                  
                     if (dailyDouble.getTurn() == 0)  //This if statement handles player 1
                        
                        {
                        
                           if (dailyDouble.getAnswerInt() == 0)
                              
                              {
                              
                                  answerADD.setText(answerADD.getText() + "\nCorrect!");
                                  
                                  answerBDD.setDisable(true); //prevents the other buttons from being pressed, that way the player can't select a wrong answer after selecting the right answer.
                                  
                                  answerXDD.setDisable(true); 
                                  
                                  answerYDD.setDisable(true);  
                                  
                                  player1.plusScore(dailyDouble.getWager());
                                  
                                  player1ScoreLabel.setText("Player 1:\n" + player1.getScore());
                                  
                                  
                              
                              }
                              
                           else 
                              
                              {
                              
                                 
                                 
                                 answerADD.setText(answerADD.getText() + "\nIncorrect");
                                 
                                 player1.minusScore(dailyDouble.getWager());
                                 
                                 player1ScoreLabel.setText("Player 1:\n" + player1.getScore());
                                 
                                 answerADD.setDisable(true);
                                 answerBDD.setDisable(true);
                                 answerXDD.setDisable(true);
                                 answerYDD.setDisable(true);
                              }
                           
                        
                        }
                        
                     
                     else if (dailyDouble.getTurn() == 1)  //This if statement handles player 2
                        
                        {
                        
                           if (dailyDouble.getAnswerInt() == 0)
                              
                              {
                              
                                  answerADD.setText(answerADD.getText() + "\nCorrect!");
                                  
                                  answerBDD.setDisable(true); //prevents the other buttons from being pressed, that way the player can't select a wrong answer after selecting the right answer.
                                  
                                  answerXDD.setDisable(true); 
                                  
                                  answerYDD.setDisable(true);  
                                  
                                  player2.plusScore(dailyDouble.getWager());
                                  
                                  player2ScoreLabel.setText("Player 2:\n" + player2.getScore());
                                  
                              }
                              
                           else 
                              
                              {
                              
                                 answerADD.setText(answerADD.getText() + "\nIncorrect");
                                 
                                 player2.minusScore(dailyDouble.getWager());
                                 
                                 player2ScoreLabel.setText("Player 2:\n" + player2.getScore());
                                 
                                 answerADD.setDisable(true);
                                 answerBDD.setDisable(true);
                                 answerXDD.setDisable(true);
                                 answerYDD.setDisable(true);
                                 
                              }
                           
                        
                        }
                        
                        
                        
                     else if (dailyDouble.getTurn() == 2)  //This if statement handles player 3
                        
                        {
                        
                           if (dailyDouble.getAnswerInt() == 0)
                              
                              {
                              
                                  answerADD.setText(answerADD.getText() + "\nCorrect!");
                                  
                                  answerBDD.setDisable(true); //prevents the other buttons from being pressed, that way the player can't select a wrong answer after selecting the right answer.
                                  
                                  answerXDD.setDisable(true); 
                                  
                                  answerYDD.setDisable(true);  
                                  
                                  player3.plusScore(dailyDouble.getWager());
                                  
                                  player3ScoreLabel.setText("Player 3:\n" + player3.getScore());
                                  
                              }
                              
                           else 
                              
                              {
                              
                                 answerADD.setText(answerADD.getText() + "\nIncorrect");
                                 
                                 player3.minusScore(dailyDouble.getWager());
                                 
                                 player3ScoreLabel.setText("Player 3:\n" + player3.getScore());
                                 
                                 answerA.setDisable(true);
                                 answerB.setDisable(true);
                                 answerX.setDisable(true);
                                 answerY.setDisable(true);
                                 
                              }
                        
                        }
                        
                        
                  
                  });
                  
               answerBDD.setOnAction( e ->  
                  
                  {
                  
                     if (dailyDouble.getTurn() == 0)  //This if statement handles player 1
                        
                        {
                        
                           if (dailyDouble.getAnswerInt() == 1)
                              
                              {
                              
                                  answerBDD.setText(answerBDD.getText() + "\nCorrect!");
                                  
                                  answerADD.setDisable(true); //prevents the other buttons from being pressed, that way the player can't select a wrong answer after selecting the right answer.
                                  
                                  answerXDD.setDisable(true); 
                                  
                                  answerYDD.setDisable(true);  
                                  
                                  player1.plusScore(dailyDouble.getWager());
                                  
                                  player1ScoreLabel.setText("Player 1:\n" + player1.getScore());
                                  
                                  
                              
                              }
                              
                           else 
                              
                              {
                              
                                 
                                 
                                 answerBDD.setText(answerBDD.getText() + "\nIncorrect");
                                 
                                 player1.minusScore(dailyDouble.getWager());
                                 
                                 player1ScoreLabel.setText("Player 1:\n" + player1.getScore());
                                 
                                 answerADD.setDisable(true);
                                 answerBDD.setDisable(true);
                                 answerXDD.setDisable(true);
                                 answerYDD.setDisable(true);
                              }
                           
                        
                        }
                        
                     
                     else if (dailyDouble.getTurn() == 1)  //This if statement handles player 2
                        
                        {
                        
                           if (dailyDouble.getAnswerInt() == 1)
                              
                              {
                              
                                  answerBDD.setText(answerBDD.getText() + "\nCorrect!");
                                  
                                  answerADD.setDisable(true); //prevents the other buttons from being pressed, that way the player can't select a wrong answer after selecting the right answer.
                                  
                                  answerXDD.setDisable(true); 
                                  
                                  answerYDD.setDisable(true);  
                                  
                                  player2.plusScore(dailyDouble.getWager());
                                  
                                  player2ScoreLabel.setText("Player 2:\n" + player2.getScore());
                                  
                              }
                              
                           else 
                              
                              {
                              
                                 answerBDD.setText(answerBDD.getText() + "\nIncorrect");
                                 
                                 player2.minusScore(dailyDouble.getWager());
                                 
                                 player2ScoreLabel.setText("Player 2:\n" + player2.getScore());
                                 
                                 answerADD.setDisable(true);
                                 answerBDD.setDisable(true);
                                 answerXDD.setDisable(true);
                                 answerYDD.setDisable(true);
                                 
                              }
                           
                        
                        }
                        
                        
                        
                     else if (dailyDouble.getTurn() == 2)  //This if statement handles player 3
                        
                        {
                        
                           if (dailyDouble.getAnswerInt() == 1)
                              
                              {
                              
                                  answerBDD.setText(answerBDD.getText() + "\nCorrect!");
                                  
                                  answerADD.setDisable(true); //prevents the other buttons from being pressed, that way the player can't select a wrong answer after selecting the right answer.
                                  
                                  answerXDD.setDisable(true); 
                                  
                                  answerYDD.setDisable(true);  
                                  
                                  player3.plusScore(dailyDouble.getWager());
                                  
                                  player3ScoreLabel.setText("Player 3:\n" + player3.getScore());
                                  
                              }
                              
                           else 
                              
                              {
                              
                                 answerBDD.setText(answerBDD.getText() + "\nIncorrect");
                                 
                                 player3.minusScore(dailyDouble.getWager());
                                 
                                 player3ScoreLabel.setText("Player 3:\n" + player3.getScore());
                                 
                                 answerA.setDisable(true);
                                 answerB.setDisable(true);
                                 answerX.setDisable(true);
                                 answerY.setDisable(true);
                                 
                              }
                        
                        }
                        
                        
                  
                  });
                  
               answerXDD.setOnAction( e ->  
                  
                  {
                  
                     if (dailyDouble.getTurn() == 0)  //This if statement handles player 1
                        
                        {
                        
                           if (dailyDouble.getAnswerInt() == 2)
                              
                              {
                              
                                  answerXDD.setText(answerXDD.getText() + "\nCorrect!");
                                  
                                  answerADD.setDisable(true); //prevents the other buttons from being pressed, that way the player can't select a wrong answer after selecting the right answer.
                                  
                                  answerBDD.setDisable(true); 
                                  
                                  answerYDD.setDisable(true);  
                                  
                                  player1.plusScore(dailyDouble.getWager());
                                  
                                  player1ScoreLabel.setText("Player 1:\n" + player1.getScore());
                                  
                                  
                              
                              }
                              
                           else 
                              
                              {
                              
                                 
                                 
                                 answerXDD.setText(answerXDD.getText() + "\nIncorrect");
                                 
                                 player1.minusScore(dailyDouble.getWager());
                                 
                                 player1ScoreLabel.setText("Player 1:\n" + player1.getScore());
                                 
                                 answerADD.setDisable(true);
                                 answerBDD.setDisable(true);
                                 answerXDD.setDisable(true);
                                 answerYDD.setDisable(true);
                              }
                           
                        
                        }
                        
                     
                     else if (dailyDouble.getTurn() == 1)  //This if statement handles player 2
                        
                        {
                        
                           if (dailyDouble.getAnswerInt() == 2)
                              
                              {
                              
                                  answerXDD.setText(answerXDD.getText() + "\nCorrect!");
                                  
                                  answerADD.setDisable(true); //prevents the other buttons from being pressed, that way the player can't select a wrong answer after selecting the right answer.
                                  
                                  answerBDD.setDisable(true); 
                                  
                                  answerYDD.setDisable(true);  
                                  
                                  player2.plusScore(dailyDouble.getWager());
                                  
                                  player2ScoreLabel.setText("Player 2:\n" + player2.getScore());
                                  
                              }
                              
                           else 
                              
                              {
                              
                                 answerXDD.setText(answerXDD.getText() + "\nIncorrect");
                                 
                                 player2.minusScore(dailyDouble.getWager());
                                 
                                 player2ScoreLabel.setText("Player 2:\n" + player2.getScore());
                                 
                                 answerADD.setDisable(true);
                                 answerBDD.setDisable(true);
                                 answerXDD.setDisable(true);
                                 answerYDD.setDisable(true);
                                 
                              }
                           
                        
                        }
                        
                        
                        
                     else if (dailyDouble.getTurn() == 2)  //This if statement handles player 3
                        
                        {
                        
                           if (dailyDouble.getAnswerInt() == 2)
                              
                              {
                              
                                  answerXDD.setText(answerXDD.getText() + "\nCorrect!");
                                  
                                  answerADD.setDisable(true); //prevents the other buttons from being pressed, that way the player can't select a wrong answer after selecting the right answer.
                                  
                                  answerBDD.setDisable(true); 
                                  
                                  answerYDD.setDisable(true);  
                                  
                                  player3.plusScore(dailyDouble.getWager());
                                  
                                  player3ScoreLabel.setText("Player 3:\n" + player3.getScore());
                                  
                              }
                              
                           else 
                              
                              {
                              
                                 answerXDD.setText(answerXDD.getText() + "\nIncorrect");
                                 
                                 player3.minusScore(dailyDouble.getWager());
                                 
                                 player3ScoreLabel.setText("Player 3:\n" + player3.getScore());
                                 
                                 answerADD.setDisable(true);
                                 answerBDD.setDisable(true);
                                 answerXDD.setDisable(true);
                                 answerYDD.setDisable(true);
                                 
                              }
                        
                        }
                        
                        
                  
                  });
                  
               answerYDD.setOnAction( e ->  
                  
                  {
                  
                     if (dailyDouble.getTurn() == 0)  //This if statement handles player 1
                        
                        {
                        
                           if (dailyDouble.getAnswerInt() == 3)
                              
                              {
                              
                                  answerYDD.setText(answerYDD.getText() + "\nCorrect!");
                                  
                                  answerADD.setDisable(true); //prevents the other buttons from being pressed, that way the player can't select a wrong answer after selecting the right answer.
                                  
                                  answerBDD.setDisable(true); 
                                  
                                  answerXDD.setDisable(true);  
                                  
                                  player1.plusScore(dailyDouble.getWager());
                                  
                                  player1ScoreLabel.setText("Player 1:\n" + player1.getScore());
                                  
                                  
                              
                              }
                              
                           else 
                              
                              {
                              
                                 
                                 
                                 answerYDD.setText(answerYDD.getText() + "\nIncorrect");
                                 
                                 player1.minusScore(dailyDouble.getWager());
                                 
                                 player1ScoreLabel.setText("Player 1:\n" + player1.getScore());
                                 
                                 answerADD.setDisable(true);
                                 answerBDD.setDisable(true);
                                 answerXDD.setDisable(true);
                                 answerYDD.setDisable(true);
                              }
                           
                        
                        }
                        
                     
                     else if (dailyDouble.getTurn() == 1)  //This if statement handles player 2
                        
                        {
                        
                           if (dailyDouble.getAnswerInt() == 3)
                              
                              {
                              
                                  answerYDD.setText(answerYDD.getText() + "\nCorrect!");
                                  
                                  answerADD.setDisable(true); //prevents the other buttons from being pressed, that way the player can't select a wrong answer after selecting the right answer.
                                  
                                  answerXDD.setDisable(true); 
                                  
                                  answerBDD.setDisable(true);  
                                  
                                  player2.plusScore(dailyDouble.getWager());
                                  
                                  player2ScoreLabel.setText("Player 2:\n" + player2.getScore());
                                  
                              }
                              
                           else 
                              
                              {
                              
                                 answerYDD.setText(answerYDD.getText() + "\nIncorrect");
                                 
                                 player2.minusScore(dailyDouble.getWager());
                                 
                                 player2ScoreLabel.setText("Player 2:\n" + player2.getScore());
                                 
                                 answerADD.setDisable(true);
                                 answerBDD.setDisable(true);
                                 answerXDD.setDisable(true);
                                 answerYDD.setDisable(true);
                                 
                              }
                           
                        
                        }
                        
                        
                        
                     else if (dailyDouble.getTurn() == 2)  //This if statement handles player 3
                        
                        {
                        
                           if (dailyDouble.getAnswerInt() == 3)
                              
                              {
                              
                                  answerYDD.setText(answerYDD.getText() + "\nCorrect!");
                                  
                                  answerADD.setDisable(true); //prevents the other buttons from being pressed, that way the player can't select a wrong answer after selecting the right answer.
                                  
                                  answerBDD.setDisable(true); 
                                  
                                  answerXDD.setDisable(true);  
                                  
                                  player3.plusScore(dailyDouble.getWager());
                                  
                                  player3ScoreLabel.setText("Player 3:\n" + player3.getScore());
                                  
                              }
                              
                           else 
                              
                              {
                              
                                 answerYDD.setText(answerYDD.getText() + "\nIncorrect");
                                 
                                 player3.minusScore(dailyDouble.getWager());
                                 
                                 player3ScoreLabel.setText("Player 3:\n" + player3.getScore());
                                 
                                 answerADD.setDisable(true);
                                 answerBDD.setDisable(true);
                                 answerXDD.setDisable(true);
                                 answerYDD.setDisable(true);
                                 
                              }
                        
                        }
                        
                        
                  
                  });


            ///////////////// End of Button Programming.
                  
               
         }
         
     
         
   }
