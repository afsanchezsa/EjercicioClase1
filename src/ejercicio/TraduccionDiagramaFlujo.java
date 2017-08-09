/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio;

import java.util.Scanner;

/**
 *
 * @author USUARIO
 */
public class TraduccionDiagramaFlujo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    int playAgain=1;
    Scanner entrada=new Scanner(System.in);
   // playAgain=entrada.nextInt();
    while((playAgain!=1)==false){
    GuessingGame();
        System.out.println("Would you like to play another game (1/0):");
        playAgain=entrada.nextInt();
    }
    
    }
    public static void GuessingGame(){
    int answer=(int)Math.floor((Math.random()*100));
    int guess=0;
    int numGuesses;
    Scanner entrada=new Scanner(System.in);
    for(numGuesses=1;(numGuesses>7||guess==answer)==false;numGuesses=numGuesses+1){
        System.out.println("Guess a number");
        guess=entrada.nextInt();
        if(guess<answer){
            System.out.println("Higher...");
        }else{
        if(guess>answer){
            System.out.println("Lower...");
        }else{
            System.out.println("You Win...");
        }
        }
        
    }
    if(numGuesses>7){
        System.out.println("You Loser...");
    }else{
    }
    
            }
    
}
