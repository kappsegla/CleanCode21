package trivia;

import java.util.ArrayList;
import java.util.List;

import static trivia.Category.*;


public class GameBetter implements IGame {
    List<Player> players = new ArrayList<>();
    int[] purses = new int[6];
    boolean[] inPenaltyBox = new boolean[6];

    List<String> popQuestions = new ArrayList<>();
    List<String> scienceQuestions = new ArrayList<>();
    List<String> sportsQuestions = new ArrayList<>();
    List<String> rockQuestions = new ArrayList<>();

    int currentPlayer = 0;
    boolean isGettingOutOfPenaltyBox;

    public GameBetter() {
        for (int i = 0; i < 50; i++) {
            popQuestions.add("Pop Question " + i);
            scienceQuestions.add(("Science Question " + i));
            sportsQuestions.add(("Sports Question " + i));
            rockQuestions.add(createRockQuestion(i));
        }
    }

    public String createRockQuestion(int index) {
        return "Rock Question " + index;
    }

    public boolean add(String playerName) {
        players.add(new Player(playerName));
        purses[howManyPlayers()] = 0;
        inPenaltyBox[howManyPlayers()] = false;

        System.out.println(playerName + " was added");
        System.out.println("They are player number " + players.size());
        return true;
    }

    public int howManyPlayers() {
        return players.size();
    }

    public void roll(int roll) {
        String currentPlayerName = players.get(currentPlayer).getName();

        System.out.println(currentPlayerName + " is the current player");
        System.out.println("They have rolled a " + roll);

        if (inPenaltyBox[currentPlayer]) {
            if (roll % 2 != 0) {
                isGettingOutOfPenaltyBox = true;

                System.out.println(currentPlayerName + " is getting out of the penalty box");
                players.get(currentPlayer).setPlace(players.get(currentPlayer).getPlace() + roll);

                if (players.get(currentPlayer).getPlace() > 11)
                    players.get(currentPlayer).setPlace(players.get(currentPlayer).getPlace() - 12);

                System.out.println(currentPlayerName
                        + "'s new location is "
                        + players.get(currentPlayer).getPlace());

                System.out.println("The category is " + currentCategory());
                System.out.println(askQuestion());
            } else {
                System.out.println(currentPlayerName + " is not getting out of the penalty box");
                isGettingOutOfPenaltyBox = false;
            }

        } else {

            players.get(currentPlayer).setPlace(players.get(currentPlayer).getPlace() + roll);

            if (players.get(currentPlayer).getPlace() > 11)
                players.get(currentPlayer).setPlace(players.get(currentPlayer).getPlace() - 12);

            System.out.println(currentPlayerName
                    + "'s new location is "
                    + players.get(currentPlayer).getPlace());
            System.out.println("The category is " + currentCategory());
            System.out.println(askQuestion());
        }

    }

    private String askQuestion() {
        return switch (currentCategory()) {
            case POP -> popQuestions.remove(0);
            case SCIENCE -> scienceQuestions.remove(0);
            case SPORTS -> sportsQuestions.remove(0);
            case ROCK -> rockQuestions.remove(0);
        };
    }


    private Category currentCategory() {
        //alt enter, byt till switch :))
        if (players.get(currentPlayer).getPlace() == 0) return POP;
        if (players.get(currentPlayer).getPlace() == 4) return POP;
        if (players.get(currentPlayer).getPlace() == 8) return POP;
        if (players.get(currentPlayer).getPlace() == 1) return SCIENCE;
        if (players.get(currentPlayer).getPlace() == 5) return SCIENCE;
        if (players.get(currentPlayer).getPlace() == 9) return SCIENCE;
        if (players.get(currentPlayer).getPlace() == 2) return SPORTS;
        if (players.get(currentPlayer).getPlace() == 6) return SPORTS;
        if (players.get(currentPlayer).getPlace() == 10) return SPORTS;
        return ROCK;
    }

    public boolean wasCorrectlyAnswered() {
        if (inPenaltyBox[currentPlayer]) {
            if (isGettingOutOfPenaltyBox) {
                System.out.println("Answer was correct!!!!");
                purses[currentPlayer]++;
                System.out.println(players.get(currentPlayer).getName()
                        + " now has "
                        + purses[currentPlayer]
                        + " Gold Coins.");

                boolean winner = didPlayerWin();
                currentPlayer++;
                if (currentPlayer == players.size()) currentPlayer = 0;

                return winner;
            } else {
                currentPlayer++;
                if (currentPlayer == players.size()) currentPlayer = 0;
                return true;
            }


        } else {

            System.out.println("Answer was corrent!!!!");
            purses[currentPlayer]++;
            System.out.println(players.get(currentPlayer).getName()
                    + " now has "
                    + purses[currentPlayer]
                    + " Gold Coins.");

            boolean winner = didPlayerWin();
            currentPlayer++;
            if (currentPlayer == players.size()) currentPlayer = 0;

            return winner;
        }
    }

    public boolean wrongAnswer() {
        System.out.println("Question was incorrectly answered");
        System.out.println(players.get(currentPlayer).getName() + " was sent to the penalty box");
        inPenaltyBox[currentPlayer] = true;

        currentPlayer++;
        if (currentPlayer == players.size()) currentPlayer = 0;
        return true;
    }


    private boolean didPlayerWin() {
        return !(purses[currentPlayer] == 6);
    }
}

class Player {
    private final String name;
    private int place;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPlace(){
        return place;
    }

    public void setPlace(int place) {
        this.place = place;
    }

}
