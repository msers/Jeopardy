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
      
      private int gamePhase;
      
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

      public void addDigit (int digitToAdd)
         
         {
         
            int addingDigit = digitToAdd;
            
            dailyDoubleWager = dailyDoubleWager * 10;
            
            dailyDoubleWager = dailyDoubleWager + addingDigit;
            
            if (dailyDoubleWager >=25002)
               
               {
               
                  dailyDoubleWager = 25001;
               
               }
         
         }
         
      public void resetWager()
         
         {
         
            dailyDoubleWager = 0;
         
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

      
       

         
   }
    
