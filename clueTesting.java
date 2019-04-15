
public class clueTesting

   {
      public static void main(String[] args)
      
         {
         
            Clue cluetest = new Clue("Yeet it works", "A", "B", "X", "Y", 420, "WOLFRAM");
            
            System.out.println(cluetest.getClueText());
            
            System.out.println(cluetest.getAnswerA());
            
            System.out.println(cluetest.getAnswerB());
            
            System.out.println(cluetest.getAnswerX());
            
            System.out.println(cluetest.getAnswerY());
            
            System.out.println(cluetest.getPointValue());
            
            cluetest.setPointValue(69);
            
            System.out.println(cluetest.getPointValue());
            
            System.out.println(cluetest.getWolfKeyword());
            
         }
         
   }
