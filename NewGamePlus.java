/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package New6;

import java.util.Scanner;

/**
 *
 * @author sebag
 */
public class NewGamePlus {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        gameStart();
        System.out.println("thanks for playing");
    }
    
    public static void gameStart()
    {
        Scanner r=new Scanner(System.in);
        int ocurrences;
        char letter;
        int trys;
        Hangman hg=new Hangman();
        System.out.println(hg.getWord());
        do
        {
            System.out.println("enter a letter");
            letter=r.next().charAt(0);
            ocurrences=hg.searchOccurrences(letter);
            if (ocurrences<=0)
            {
                System.out.println("the letter "+letter+" doesn+t belong to the word");
                hg.looseLife();
                System.out.println("life remaining "+hg.getLives());
            } 
            else 
            {
                hg.refreshHideWord(letter);
                System.out.println(" the letter "+letter+ " appears "+ ocurrences);
                hg.foundLetter(ocurrences);
            }   
            
            hg.drawHangMan();
            System.out.println("remaining");
            System.out.println(hg.getHideWord()); 
        }while(hg.isAlive() && ! hg.wordIsFound());
        
        if (hg.isAlive())
        {
            System.out.println(" word finded! good joob BOX BOX");
        } 
        else
        {
            System.out.println("too bad the word was "+hg.getWord());
        }
        
    }
    
}

    

