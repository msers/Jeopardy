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
            
            if (finalJeopardyWager >=60015)  //The highest ever successful final jeopardy bet was $60,013. So, since nothing higher than this has happened, we set the max to be 60014, as we don't think our players will get to that point.
               
               {
               
                  finalJeopardyWager = 60014;
               
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
