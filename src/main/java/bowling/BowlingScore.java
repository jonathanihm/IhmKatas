package bowling;

/**
 * Created by jonat on 4/30/2016.
 */
public class BowlingScore {
    private final static int DEFAULT_FRAMES = 10;
    private final static char STRIKE = 'X';
    private final static char SPARE = '/';
    private final static char MISS = '-';

    private static int frames = DEFAULT_FRAMES;

    public static int calculateScore(String line) {
        return calculateScore(line, DEFAULT_FRAMES);
    }

    protected static int calculateScore(String line, int endFrame) {
        return processGroup(1, endFrame, 0, line);
    }

    private static int processGroup(int depth, int endFrame, int score, String line) {
        if (depth == endFrame) {
            if (line.length() == 2) {
                return score + getPinValue(line.charAt(0)) + getPinValue(line.charAt(1));
            } else {
                if (line.length() != 3) {
                    throw new RuntimeException("Throw count in last frame is not correct");
                }
                if (line.charAt(2) == SPARE) {
                    return score + 20;
                } else if (line.charAt(1) == SPARE) {
                    return score + 10 + getPinValue(line.charAt(2));
                } else {
                    return score + getPinValue(line.charAt(0)) + getPinValue(line.charAt(1)) + getPinValue(line.charAt(2));
                }
            }
        } else {
            if (line.length() < 3) {
                throw new RuntimeException("Incorrect frame numbers for score line, please verify");
            }
            if (line.charAt(0) == STRIKE) {
                if (line.charAt(2) == SPARE) {
                    score += 20;
                } else if (line.charAt(2) == STRIKE) {
                    score += 30;
                } else {
                    score += +10 + getPinValue(line.charAt(1)) + getPinValue(line.charAt(2));
                }
                return processGroup(depth + 1, endFrame, score, line.substring(1, line.length()));
            } else {
                if (line.charAt(1) == SPARE) {
                    score += 10 + getPinValue(line.charAt(2));
                } else {
                    score += getPinValue(line.charAt(0)) + getPinValue(line.charAt(1));
                }
                return processGroup(depth + 1, endFrame, score, line.substring(2, line.length()));
            }
        }
    }

    private static int getPinValue(char pin) {
        if (pin == STRIKE) {
            return 10;
        } else if (pin == MISS) {
            return 0;
        } else {
            return Integer.parseInt(String.valueOf(pin));
        }
    }
}