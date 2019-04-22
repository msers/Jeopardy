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
         
         int valueA = dailyDoubleValueA;
         
         int valueB = dailyDoubleValueB;
         
         int valueC = dailyDoubleValueC;
         
         }
      
      public void setValueA()
      
         {
         
            Die die = new Die(29);
         
            die.roll();
            
            valueA = die.getValue();
         
         }
      
      public int getValueA()
         
         {
         
            
            
            return valueA;
         
         } 

         
   }
    