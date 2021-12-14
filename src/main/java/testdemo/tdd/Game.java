package testdemo.tdd;

public class Game {
    public static final int ALL_PINS = 10;
    private final int[] rolls = new int[21];
    private int currentRoll = 0;

    public void roll(int pinsKnockedDown) {
        if (isRollInLastFrame())
            rolls[currentRoll++] = pinsKnockedDown;
        else if (isFirstRollInFrame() && pinsKnockedDown == ALL_PINS) {
            rolls[currentRoll++] = pinsKnockedDown;
            currentRoll++;
        } else
            rolls[currentRoll++] = pinsKnockedDown;
    }

    private boolean isRollInLastFrame() {
        return currentRoll >= 18;
    }

    private boolean isFirstRollInFrame() {
        return currentRoll % 2 == 0;
    }

    public int score() {
        int score = 0;

        for (int frame = 0; frame < 10; frame++) {
            if (isStrike(frame))
                score += ALL_PINS + strikeBonus(frame);
            else if (isSpare(frame))
                score += ALL_PINS + spareBonus(frame);
            else
                score += frameScore(frame);
        }
        return score;
    }

    private int frameScore(int frame) {
        return rolls[frameToIndex(frame)] + rolls[frameToIndex(frame) + 1];
    }

    private int spareBonus(int frame) {
        return rolls[frameToIndex(frame) + 2];
    }

    private int strikeBonus(int frame) {
        if (frame < 8 && isStrike(frame + 1))
            return rolls[frameToIndex(frame) + 2] + rolls[frameToIndex(frame) + 4];
        else if (frame <= 8)
            return rolls[frameToIndex(frame) + 2] + rolls[frameToIndex(frame) + 3];
        return rolls[frameToIndex(frame) + 1] + rolls[frameToIndex(frame) + 2];

    }

    private int frameToIndex(int frame) {
        return frame * 2;
    }

    private boolean isStrike(int frame) {
        return rolls[frameToIndex(frame)] == ALL_PINS;
    }

    private boolean isSpare(int frame) {
        return rolls[frameToIndex(frame)] + rolls[frameToIndex(frame) + 1] == ALL_PINS;
    }
}
