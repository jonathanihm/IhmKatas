package bowling;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by jonat on 4/30/2016.
 */
public class BowlingScoreTest {

    @Test
    public void calculateLastFrameScore() throws Exception {
        assertEquals(0, BowlingScore.calculateScore("--", 1));
        assertEquals(8, BowlingScore.calculateScore("8-", 1));
        assertEquals(30, BowlingScore.calculateScore("XXX", 1));
    }

    @Test
    public void calculateTwoFrameSpareScore() throws Exception {
        assertEquals(10, BowlingScore.calculateScore("5/--", 2));
        assertEquals(18, BowlingScore.calculateScore("-/4-", 2));
        assertEquals(28, BowlingScore.calculateScore("-/9-", 2));

    }

    @Test
    public void calculatePerfectScore() throws Exception {
        assertEquals(300, BowlingScore.calculateScore("XXXXXXXXXXXX"));
    }

    @Test
    public void calculateAlmostPerfectScore() throws Exception {
        assertEquals(299, BowlingScore.calculateScore("XXXXXXXXXXX9"));
    }

    @Test
    public void calculateAlmostPerfectWithFunkyLastFrameScore() throws Exception {
        assertEquals(275, BowlingScore.calculateScore("XXXXXXXXX5/X"));
    }

    @Test
    public void calculateBadScore() throws Exception {
        assertEquals(90, BowlingScore.calculateScore("9-9-9-9-9-9-9-9-9-9-"));
    }

    @Test
    public void calculateSparesScore() throws Exception {
        assertEquals(150, BowlingScore.calculateScore("5/5/5/5/5/5/5/5/5/5/5"));
    }

    @Test
    public void calculateMiscScore() throws Exception {
        assertEquals(107, BowlingScore.calculateScore("9-9-9-9-9-9-9-X3/54"));
        assertEquals(50, BowlingScore.calculateScore("X--X--X--X--X--"));
        assertEquals(206, BowlingScore.calculateScore("X5/XX8-XX8/XX4/"));
    }

    @Test(expected=RuntimeException.class)
    public void incorrectNumberThrowsInLastFrame() throws Exception {
        BowlingScore.calculateScore("XXXXXXXXXX9-/");
    }

    @Test(expected=RuntimeException.class)
    public void incorrectNumberThrowsForFrameCount() throws Exception {
        BowlingScore.calculateScore("12345-/");
    }

}