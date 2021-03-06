/*
   Authors: @Patrick_Hennessey, @Gregory_Ortlip, @Mike_Sers
   
   Project: Jeopardy CIS111B Final Project
   
   Purpose: Daily Double Object
   
   
*/

public class DailyDouble
   
   {
   
      private int dailyDoubleValueA;
      
      private int dailyDoubleValueB;
      
      private int dailyDoubleValueC;
      
      private int dailyDoubleCounter;
      
      private int dailyDoubleWager;
      
      private int answerInteger;
      
      private int gamePhase;
      
      private int turnTracker;
      
      private int cluePoints;
      
      private int incorrectTracker;
      
      private int finalJeopardyTracker;
      
      
      public DailyDouble()
      
         {
         

         
         }
      
      public void setValueA(int valueA)
      
         {
         
            Die die = new Die(25);
         
            die.roll();
            
            valueA = die.getValue();
            
            dailyDoubleValueA = valueA + 4;
         
         }
        
         
      public int getValueA() 
                
         {
         
            return dailyDoubleValueA;   
         
         }
         
      public void setValueB(int valueB)
      
         {
         
            Die die = new Die(29);
         
            die.roll();
            
            valueB = die.getValue();
            
            dailyDoubleValueB = valueB + 30;
         
         }
        
         
      public int getValueB()  
         
         {
         
            return dailyDoubleValueB;   
         
         }
         
      public void setValueC(int valueC)
      
         {
         
            Die die = new Die(29);
         
            die.roll();
            
            valueC = die.getValue();
            
            dailyDoubleValueC = valueC + 30;
         
         }
        
         
      public int getValueC()  
         
         {
         
            return dailyDoubleValueC;   
         
         }
         
         
      public void plusCounter()
      
         {
         
            dailyDoubleCounter++;
         
         }
         
      public int getCounter()
         
         {
         
            return dailyDoubleCounter;
         
         }
         
      public void resetCounter()
         
         {
         
            dailyDoubleCounter = 0;
         
         }
         
      public void setAnswerInt( int answerInt)
         
         {
         
            answerInteger = answerInt;
         
         }
         
      public int getAnswerInt()
         
         {
         
            return answerInteger;
         
         }

      public void addDigit (int digitToAdd)
         
         {
         
            int addingDigit = digitToAdd;
            
            dailyDoubleWager = dailyDoubleWager * 10;
            
            dailyDoubleWager = dailyDoubleWager + addingDigit;
            
            
            
            if (dailyDoubleWager >=100001) //The highest ever successful daily double bet was $25,000. Just in case we have a Jeopardy Genius at TechConnect, we have the max set to 100,000.
               
               {
               
                  dailyDoubleWager = 100000;
               
               }
               
            
         
         }
         
      public void resetWager()
         
         {
         
            dailyDoubleWager = 0;
         
         }
         
      public void setWager(int wagerValue)
         
         {
         
            dailyDoubleWager = wagerValue;
         
         }
         
      public int getWager()
         
         {
         
            return dailyDoubleWager;
         
         }
         
      public String getWagerString()
         
         {
         
            String dailyDoubleWagerString = ("" + dailyDoubleWager);
            
            return dailyDoubleWagerString;         
         }
      
      public void plusGamePhase()
      
         {
         
            gamePhase++;
         
         }
         
      public int getGamePhase()
         
         {
         
            return gamePhase;
         
         }
         
      public void setTurn (int turnTrackerInt)
      
         {
            
            turnTracker = turnTrackerInt;
         
         }
         
      public void changeTurn()
         
         {
         
            turnTracker++;
            
            //0=player1
            //1=player2
            //2=player3
            
            if (turnTracker == 3)
               
               {
               
                  turnTracker = 0;
               
               }
         
         }
            
      public int getTurn()
         
         {
         
            return turnTracker;
         
         }
         
      public void setCluePoints (int cluePointsInt)
         
         {
         
            cluePoints = cluePointsInt;
         
         }
         
      public int getCluePoints()
         
         {
         
            return cluePoints;
         
         }
      
      public void setIncorrectTurn (int incorrectTrackerInt)
      
         {
            
            incorrectTracker = incorrectTrackerInt;
         
         }
         
      public void plusIncorrectTracker()
         
         {
         
            incorrectTracker++;
            
         }
            
      public int getIncorrectTracker()
         
         {
         
            return incorrectTracker;
         
         }
         
      public void resetIncorrectTracker()
         
         {
               
            incorrectTracker = 0;
               
         }
         
      public void plusFinalJeopardyTracker()
         
         {
          
            finalJeopardyTracker++;
            
         }
         
      public int getFinalJeopardyTracker()
         
         {
            
            return finalJeopardyTracker;
            
         }
      
       

         
   }
    
