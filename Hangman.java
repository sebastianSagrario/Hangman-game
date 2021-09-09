/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package New6;

import java.util.Arrays;

/**
 *
 * @author sebag
 */
public class Hangman {
   
   private static final String [] WORDbANK={"cucamunga","guitar","conga","formula","cat","trunk","goblin","cellphone"};

   private int lives;
   private int lettersRemaining;
   private char[] word;
   private char [] hideWord;
    public Hangman() {
        int randomWord=(int) (Math.random() * WORDbANK.length);    
        lives = 6;        
        word = WORDbANK[randomWord].toCharArray();
        lettersRemaining=word.length;
        hideWord=new char[word.length];
        Arrays.fill(hideWord, '_');
    }
    
  /**
   * reveals the hideword partialy
   * @param letter 
   */  
 public void refreshHideWord(char letter)
 {
     for (int i=0;i<word.length;i++)
     {
     
         if (word[i]==letter)
         {
             hideWord[i]=word[i];
         }
     }
 }

 
 public char[] getHideWord() {
        return hideWord;
    }
    
public void drawHangMan()
    {
        
        drawZeroLine();
        switch (lives)
        {
            case 6:  
                  drawEmptyHang(lives);
                break;
            case 5:
                drawHeadLine();
                drawEmptyHang(lives);
                break;
            case 4 :
                drawHeadLine();
                drawTorsoLine(lives);
                drawEmptyHang(lives);
                break;
            case 3:
                drawHeadLine();
                drawTorsoLine(lives);
                drawEmptyHang(lives);
                break;
            case 2:
                drawHeadLine();
                drawTorsoLine(lives);
                drawEmptyHang(lives);
                break;
            case 1:
                drawHeadLine();
                drawTorsoLine(2);
                drawFootLine(lives);
                drawEmptyHang(lives);
                break;
            case 0:                
                drawHeadLine();
                drawTorsoLine(2);
                drawFootLine(0);
                drawEmptyHang(lives);
                break;
                
        }     

    }

    private void drawZeroLine()
    {
        int j;
        for (j=0;j<6;j++)
               {
                   if (j==0)
                   {
                       System.out.print("|");
                   }
                   else 
                   {
                       System.out.print("-");
                   }
               }
        System.out.println("");
    }




    private void drawHeadLine()
    {
        System.out.print("|");
        System.out.print("   ");
        System.out.println("O");        
    }
    private void drawTorsoLine(int lives)
    {
        switch (lives)
        {
            case 4: 
                System.out.println("|   I");
                break;
            case 3:
                System.out.println("| / I ");
                break;
            case 2:
                System.out.println("| / I  / ");
                break;
        }
    }
    private void drawFootLine(int lives)
    {
        switch (lives)
        {
            case 1:System.out.println("|  /");
            break;
            case 0: System.out.println("|  / /");
        }
    }   
    private void drawEmptyHang(int lives)
    {   int j;
        switch (lives)
        {   case 6:
                System.out.println("|");                               
            case 5:
                System.out.println("|");                               
            case 4:
                System.out.println("|");                
            case 3:
                System.out.println("|");
            case 2 :
                System.out.println("|");
            case 1:
                System.out.println("|");
            default: 
                for (j=0;j<6;j++)
                {
                    System.out.print("_");
                }
        }
        System.out.println("");
    }



    

    
    
    /**
     * 
     * @param letter to be found at the word
     * 
     * @return the ocurrence of the letter in the word 
     */
    public int searchOccurrences(char letter)
    {
        int occurrence;
        occurrence=0;
        for (int i=0;i<word.length;i++)
        {
            if (word[i]==letter)
            {
                occurrence++;
            }
        }
        return occurrence;
    }

    
    public boolean isAlive()
    {
        return lives>0;
    }
    
    
    public boolean wordIsFound()
    {
        return lettersRemaining<=0;
    }
    
    public void looseLife()
    {
        if (lives>0)
        {
            lives--;     
        }
    }
    
    /*
    *  discount the amount of  ocurrences of a found letter to the remaining letter amount 
    
    */
    
    public void foundLetter(int ocurrences)
    {
        lettersRemaining-=ocurrences;
    }

    public int getLettersRemaining()
    {
        return lettersRemaining;
    }
    public int getLenght()
    {
        return word.length;
    }

    public int getLives() {
        return lives;
    }

    public char[] getWord() {
        return word;
    }

    public static String[] getWORDbANK() {
        return WORDbANK;
    }
     
    
    
    
    
    
    
    
    
    
   
    
   
   
   
}
