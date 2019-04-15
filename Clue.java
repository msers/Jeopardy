/*


   Authors: @Patrick_Hennessey, @Gregory_Ortlip, @Mike_Sers
   
   Project: Jeopardy CIS111B Final Project
   
   Purpose: Clue Object
   
   
*/

public class Clue
   
   {
      
      private String clueText;   // text for the clue
      
      private String answerA;    // text for answer A
      
      private String answerB;    // text for answer B
      
      private String answerX;    // text for answer X
      
      private String answerY;    // text for answer Y
            
      private int pointValue; // point value for each clue
      
      private String wolfKeyword;   // the keyword used for the wolfram search
      
      
      public Clue (String infoClue, String infoA, String infoB, String infoX, String infoY, int infoPoints, String infoKeyword)
         
         {
            clueText = infoClue;
            
            answerA = infoA;
            
            answerB = infoB;
            
            answerX = infoX;
            
            answerY = infoY;
            
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
              
