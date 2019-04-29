public class Player
   
   {
   
      private int score;
      
      private int finalJeopardyWager;
      
      private int gamePhase;
      
      public Player()
      
         {
         

         
         }
      
      public void plusScore (int pointsToAdd)
               
         {
         
            int addingPoints = pointsToAdd;
            
            score = score + addingPoints;   
         
         }
      
      public void minusScore (int pointsToSubtract)
               
         {
         
            int subtractingPoints = pointsToSubtract;
            
            score = score - subtractingPoints;   
         
         }
               
      public int getScore()
         
         {
         
            return score;
         
         }
      
      public void addDigit (int digitToAdd)
               
         {
         
            int addingDigit = digitToAdd;
            
            finalJeopardyWager = finalJeopardyWager * 10;
            
            finalJeopardyWager = finalJeopardyWager + addingDigit;
            
            if (finalJeopardyWager >=25002)
               
               {
               
                  finalJeopardyWager = 25001;
               
               }
         
         }
               
      public void resetWager()
         
         {
         
            finalJeopardyWager = 0;
         
         }
         
      public int getWager()
         
         {
         
            return finalJeopardyWager;
         
         }
         
      public String getWagerString()
         
         {
         
            String finalJeopardyWagerString = ("" + finalJeopardyWager);
            
            return finalJeopardyWagerString;         
            
         }
               
   }