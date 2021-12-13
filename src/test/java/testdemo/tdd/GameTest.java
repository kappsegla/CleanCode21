package testdemo.tdd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameTest {


    @Test
    void rolling20TimesWithNoPinsKnockedDownShouldReturnScoreZero() {
        Game game = new Game();

        for (int i = 0; i < 20; i++) {
            game.roll(0);
        }

        assertEquals(0, game.score());
    }

    @Test
    void rolling20TimesWithOnePinKnockedDownShouldReturnScore20() {
        Game game = new Game();

        for (int i = 0; i < 20; i++) {
            game.roll(1);
        }

        assertEquals(20, game.score());
    }
}
