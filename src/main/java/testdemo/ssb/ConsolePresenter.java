package testdemo.ssb;

public class ConsolePresenter {
    void presentRoundWinner(Score score, String s) {
        System.out.println(s);
        System.out.println("Du har: " + score.playerScore + " poäng.\nDatorn har: " + score.computerScore);
    }

    void presentTotalWinner(int computerScore, int playerScore) {
        if (playerScore == 3) {
            System.out.println("\nGrattis! Du fick: " + playerScore + "\nDatorn fick: " + computerScore + "\nDu vann över Datorn!\n");
        } else if (computerScore == 3) {
            System.out.println("\nGrattis datorn! Datorn fick: " + computerScore + "\nDu fick: " + playerScore + "\nDatorn vann över dig!\n");
        }
    }
}