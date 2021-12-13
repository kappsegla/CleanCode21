package testdemo.tdd;

public class Game {
    public static final int ALL_PINS = 10;
    private int[] rolls = new int[21];
    private int currentRoll = 0;

    public void roll(int pinsKnockedDown) {
        if (isFirstRollInFrame() && pinsKnockedDown == ALL_PINS) {
            rolls[currentRoll++] = pinsKnockedDown;
            currentRoll++;
        } else
            rolls[currentRoll++] = pinsKnockedDown;
    }

    private boolean isFirstRollInFrame() {
        return currentRoll % 2 == 0;
    }

    public int score() {
        return totalScore;
    }
}
