/*


   Authors: @Patrick_Hennessey, @Gregory_Ortlip, @Mike_Sers
   
   Project: Jeopardy CIS111B Final Project
   
   Purpose: Clue Object
   
   
*/

public class Clue
   
   {
      
      private String clueText;
      
      private String answerA;
      
      private String answerB;
      
      private String answerX;
      
      private String answerY;
      
      private String answerCorrect;
      
      private int pointValue;
      
      private String wolfKeyword;
      
      
      public Clue (String infoClue, String infoA, String infoB, String infoX, String infoY, String infoCorrect, int infoPoints, String infoKeyword)
         
         {
            clueText = infoClue;
            
            answerA = infoA;
            
            answerB = infoB;
            
            answerX = infoX;
            
            answerY = infoY;
            
            answerCorrect = infoCorrect;
            
            pointValue = infoPoints;
            
            wolfKeyword = infoKeyword;
            
         }
         
      public String getClueText()
         
         {
         
            return clueText;
         
         }
         
      public String getAnswerA()
         
         {
         
            return answerA;
         
         }
      
      public String getAnswerB()
         
         {
         
            return answerB;
         
         }
         
      public String getAnswerX()
         
         {
         
            return answerX;
            
         }
         
      public String getAnswerY()
         
         {
            
            return answerY;
            
         }
         
      public String getAnswerCorrect()
         
         {
            
            return answerCorrect;
            
         }
         
      public void setPointValue(int infoPoints)
         
         {
         
           pointValue = infoPoints; 
         
         }
      
      public int getPointValue()
         
         {
            
            return pointValue;
            
         }
            
      public String getWolfKeyword()
      
         {
            
            return wolfKeyword;
            
         }

         
   }
              