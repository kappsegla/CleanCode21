package testdemo.ssb;

import java.util.Random;
import java.util.Scanner;

public class stepsons {

static void stenSaxPåse(){

        Scanner scanner = new Scanner(System.in);
        Random ran = new Random();

        int computerScore = 0;
        int playerScore = 0;
        int computerChoice;
        int playerInput;

        System.out.println("Välkommen till Sten Sax Påse");

        while (computerScore < 3 && playerScore < 3) {

            System.out.println("Skriv 1 för Sten, 2 för Sax och 3 för Påse");

            try {
                playerInput = scanner.nextInt();
            } catch (Exception e){
                System.out.println("Error fel input! Du måste skriva 1, 2 eller 3");
                break;
            }

            computerChoice = ran.nextInt(3) + 1;

            if (1 == (playerInput) || 2 == (playerInput) || 3 == (playerInput)) {
                if (((playerInput == 1) && (computerChoice == 2)) || ((playerInput == 2) && (computerChoice == 3))
                        || ((playerInput == 3) && (computerChoice == 1))) {

                    playerScore++;

                    System.out.println("\nDu vann!");
                    System.out.println("Du har: " + playerScore + " poäng.\nDatorn har: " + computerScore);
                } else if (((playerInput == 2) && (computerChoice == 1)) || ((playerInput == 3) && (computerChoice == 2))
                        || ((playerInput == 1) && (computerChoice == 3))) {

                    computerScore++;

                    System.out.println("\nDatorn vann!");
                    System.out.println("Du har: " + playerScore + " poäng.\nDatorn har: " + computerScore);
                } else if (((playerInput == 1) && (computerChoice == 1)) || ((playerInput == 2) && (computerChoice == 2))
                        || ((playerInput == 3) && (computerChoice == 3))) {

                    System.out.println("\nOavgjort!");
                    System.out.println("Du har: " + playerScore + " poäng.\nDatorn har: " + computerScore);
                }
            } else {
                System.out.println("Error fel input! Du måste skriva 1, 2 eller 3");
            }
        }

        if (playerScore == 3){
            System.out.println("\nGrattis! Du fick: " + playerScore +  "\nDatorn fick: " + computerScore + "\nDu vann över Datorn!\n");
        } else if (computerScore == 3){
            System.out.println("\nGrattis datorn! Datorn fick: " + computerScore +  "\nDu fick: " + playerScore + "\nDatorn vann över dig!\n");
        }

    }
}