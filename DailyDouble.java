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
      
      int dailyDoubleCounter;

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

      
       

         
   }
    
