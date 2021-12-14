package testdemo.tdd;

public class Game {
    public static final int ALL_PINS = 10;
    private final int[] rolls = new int[21];
    private int currentRoll = 0;

    public void roll(int pinsKnockedDown) {
        if( isLastFrame())
            rolls[currentRoll++] = pinsKnockedDown;
        else if (isFirstRollInFrame() && pinsKnockedDown == ALL_PINS) {
            rolls[currentRoll++] = pinsKnockedDown;
            currentRoll++;
        } else
            rolls[currentRoll++] = pinsKnockedDown;
    }

    private boolean isLastFrame() {
        return currentRoll >=18;
    }

    private boolean isFirstRollInFrame() {
        return currentRoll % 2 == 0;
    }

    public int score() {
        int score = 0;

        for (int frame = 0; frame < 10; frame++) {
            score += frameScore(frame);
            score += calculateBonus(frame);
        }
        return score;
    }

    private int frameScore(int frame){
        return rolls[frame*2] + rolls[frame*2 + 1];
    }

    private int calculateBonus(int frame) {
        if (isStrike(frame*2)) {
            return rolls[frame*2 + 2] + rolls[frame * 2 + 3];
        }
        else if (isSpare(frame*2))
            return rolls[frame + 2];
        return 0;
    }

    private boolean isStrike(int frame) {
        return frame % 2 == 0 && rolls[frame] == ALL_PINS;
    }

    private boolean isSpare(int frame) {
        return frame % 2 == 0 && rolls[frame] + rolls[frame + 1] == ALL_PINS;
    }
}
