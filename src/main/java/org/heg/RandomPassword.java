package org.heg;

import org.heg.exception.BadPasswordException;
import org.heg.exception.InitializationException;

import java.util.Arrays;
import java.util.List;

public class RandomPassword implements IRandomPassword{

    private static final List<Integer> NUMBERS = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);

    private static final List<String> LETTERS = Arrays.asList("a", "b", "c", "d", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z");

    private final int minLength;

    private final int maxLength;

    private boolean useLetter = true;

    private boolean useNumber = true;

    private boolean useCapitalize = true;

    public RandomPassword(int minLength, int maxLength) throws InitializationException {
        if (minLength < MIN_LENGTH) {
            throw new InitializationException("min length must be > %s".formatted(MIN_LENGTH));
        }
        if (maxLength > MAX_LENGTH) {
            throw new InitializationException("max length must < %s".formatted(MAX_LENGTH));
        }
        this.minLength = minLength;
        this.maxLength = maxLength;
    }


    @Override
    public String generatePassword(int length) throws BadPasswordException {
        if (length < minLength || length > maxLength) {
            throw new BadPasswordException("Generator cannot create password for this length %s".formatted(length));
        }
        if (!useNumber && !useCapitalize && !useLetter) {
            throw new BadPasswordException("Generator cannot create password without numbers and lettres");
        }
        StringBuilder sb = new StringBuilder();
        do {
            if (useNumber) {
                int randomNb = getRandomNumber(0, NUMBERS.size() - 1);
                sb.append(NUMBERS.get(randomNb));
            }

            if (useLetter) {
                int randomNbLetter = getRandomNumber(0, LETTERS.size() - 1);
            sb.append(LETTERS.get(randomNbLetter));
            }

            if (useCapitalize) {
                int randomNbLetterCap = getRandomNumber(0, LETTERS.size() - 1);
                sb.append(LETTERS.get(randomNbLetterCap).toUpperCase());
            }
        } while (sb.length() < length);
        return sb.substring(0, length);
    }

    private int getRandomNumber(int min, int max) {
        return (int) (Math.random() * (max - min)) + min;
    }

    @Override
    public void useNumbers(boolean useNbs) {
        this.useNumber = useNbs;
    }

    @Override
    public void useLetters(boolean useLetters) {
        this.useLetter = useLetters;
    }

    @Override
    public void useCapitalize(boolean useCapitalize) {
        this.useCapitalize = useCapitalize;
    }
}
