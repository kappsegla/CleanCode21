package testdemo.tdd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameTest {

    private final Game game;

    public GameTest() {
        game = new Game();
    }

    @Test
    void rolling20TimesWithNoPinsKnockedDownShouldReturnScoreZero() {
        multipleRolls(20, 0);

        assertEquals(0, game.score());
    }

    @Test
    void rolling20TimesWithOnePinKnockedDownShouldReturnScore20() {
        multipleRolls(20, 1);

        assertEquals(20, game.score());
    }

    @Test
    void spareTest() {
        game.roll(5);
        game.roll(5);
        game.roll(2);
        multipleRolls(17, 0);

        assertEquals(14, game.score());
    }

    @Test
    void strikeTest() {
        game.roll(10);
        game.roll(5);
        game.roll(2);
        multipleRolls(16, 0);

        assertEquals(24, game.score());
    }

    @Test
    void spareInLastRoundTest() {
        multipleRolls(18, 0);
        game.roll(5);
        game.roll(5);
        game.roll(2);

        assertEquals(12, game.score());
    }

    @Test
    void perfectGame() {
        multipleRolls(12, 10);

        assertEquals(300, game.score());
    }

    private void multipleRolls(int n, int pins) {
        for (int i = 0; i < n; i++) {
            game.roll(pins);
        }
    }
}
