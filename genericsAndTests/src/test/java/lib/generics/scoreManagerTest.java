package lib.generics;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class scoreManagerTest {

    @Test
    void addScore() {
        ScoreManager<Integer> sm = new ScoreManager<>();

        sm.addScore(100);

        assertEquals(1, sm.size());
    }

    @Test
    void addScoreShouldThrowAnException_whenScoreIsNegative() {
        ScoreManager<Integer> sm = new ScoreManager<>();

        assertThrows(IllegalArgumentException.class, () -> sm.addScore(-10));
    }

    @Test
    void addScoreShouldThrowAnException_whenScoreIsGreaterThanOneHundred() {
        ScoreManager<Integer> sm = new ScoreManager<>();

        assertThrows(IllegalArgumentException.class, () -> sm.addScore(200));
    }

    @Test
    void addScoreShouldAcceptBoundaryValues() {
        ScoreManager<Integer> sm = new ScoreManager<>();

        sm.addScore(100);
        sm.addScore(0);

        assertEquals(2, sm.size());
    }

    @Test
    void getAverage() {
        ScoreManager<Integer> sm = new ScoreManager<>();
        sm.addScore(100);
        sm.addScore(80);

        assertEquals(90.0, sm.getAverage());
    }

    @Test
    void getAverageShouldThrowAnException_whenListIsEmpty() {
        ScoreManager<Integer> sm = new ScoreManager<>();
        assertThrows(IllegalArgumentException.class, () -> sm.getAverage());
    }
}