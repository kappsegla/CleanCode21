package testdemo.ssb;

import java.util.Random;
import java.util.Scanner;

class Score {
    int computerScore;
    int playerScore;
}


public class Stepsons {
    public static final Scanner SCANNER = new Scanner(System.in);
    static Random ran = new Random();
    static ConsolePresenter consolePresenter = new ConsolePresenter();

    static void setRandom(Random random){
        ran = random;
    }

    static void stenSaxPåse(){

        Score score = new Score();
        int computerChoice;
        int playerInput;

        System.out.println("Välkommen till Sten Sax Påse");

        while (score.computerScore < 3 && score.playerScore < 3) {

            System.out.println("Skriv 1 för Sten, 2 för Sax och 3 för Påse");

            try {
                playerInput = SCANNER.nextInt();
            } catch (Exception e){
                System.out.println("Error fel input! Du måste skriva 1, 2 eller 3");
                break;
            }

            computerChoice = ran.nextInt(3) + 1;

            if (1 == (playerInput) || 2 == (playerInput) || 3 == (playerInput)) {
                calculateScore(score, computerChoice, playerInput);
            } else {
                System.out.println("Error fel input! Du måste skriva 1, 2 eller 3");
            }
        }

        consolePresenter.presentTotalWinner(score.computerScore, score.playerScore);

    }

    private static void calculateScore(Score score, int computerChoice, int playerInput) {
        if (((playerInput == 1) && (computerChoice == 2)) || ((playerInput == 2) && (computerChoice == 3))
                || ((playerInput == 3) && (computerChoice == 1))) {

            score.playerScore++;
            consolePresenter.presentRoundWinner(score, "\nDu vann!");
        } else if (((playerInput == 2) && (computerChoice == 1)) || ((playerInput == 3) && (computerChoice == 2))
                || ((playerInput == 1) && (computerChoice == 3))) {

            score.computerScore++;

            consolePresenter.presentRoundWinner(score, "\nDatorn vann!");
        } else {

            consolePresenter.presentRoundWinner(score, "\nOavgjort!");
        }
    }

}