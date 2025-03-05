import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

// Hangman Game with Java keywords
// Thanks to SSaurel's Channel
public class HangmanGame {

    // Java Keywords
    public static final String[] WORDS = {
            "ABSTRACT", "ASSERT", "BOOLEAN", "BREAK", "BYTE",
            "CASE", "CATCH", "CHAR", "CLASS", "CONST",
            "CONTINUE", "DEFAULT", "DOUBLE", "DO", "ELSE",
            "ENUM", "EXTENDS", "FALSE", "FINAL", "FINALLY",
            "FLOAT", "FOR", "GOTO", "IF", "IMPLEMENTS",
            "IMPORT", "INSTANCEOF", "INT", "INTERFACE",
            "LONG", "NATIVE", "NEW", "NULL", "PACKAGE",
            "PRIVATE", "PROTECTED", "PUBLIC", "RETURN",
            "SHORT", "STATIC", "STRICTFP", "SUPER", "SWITCH",
            "SYNCHRONIZED", "THIS", "THROW", "THROWS",
            "TRANSIENT", "TRUE", "TRY", "VOID", "VOLATILE", "WHILE"
    };

    public static final Random RANDOM = new Random();
    public static final int MAX_WRONG_ATTEMPTS = 8;

    private String targetWord;

    private final ArrayList<String> lettersEntered = new ArrayList<>();
    private char[] revealedWord;
    private int wrongTries;

    // Method returning randomly next word to find
    private String nextTargetWord() {
        return WORDS[RANDOM.nextInt(WORDS.length)];
    }

    // Method for starting a new game
    public void newGame() {
        wrongTries = 0;
        lettersEntered.clear();
        targetWord = nextTargetWord();
        initializeWordFound();
    }

    private void initializeWordFound() {
        revealedWord = new char[targetWord.length()];

        for (int i = 0; i < revealedWord.length; i++)
            revealedWord[i] = '_';
    }

    private void enterAttempt(String c) {
        if (lettersEntered.contains(c))
            return;

        if (targetWord.contains(c))
            revealCharacters(c);
        else
            wrongTries++;

        lettersEntered.add(c);
    }

    private void revealCharacters(String c) {
        int index = targetWord.indexOf(c);
        boolean letterExists = index >= 0;
        while (letterExists) {
            revealedWord[index] = c.charAt(0);
            index = targetWord.indexOf(c, index + 1);
            letterExists = index >= 0;
        }
    }

    // Play method for our Hangman Game
    public void play() {
        Scanner input = new Scanner(System.in);

        while (!isGameOver()) {
            promptAttempt(input);
            displayRevealedWord();
        }

        reportStatus();
        reportResult();
    }

    private void promptAttempt(Scanner input) {
        reportStatus();
        String aLetter = getLetter(input);
        enterAttempt(aLetter);
    }

    private void reportStatus() {
        System.out.println("\nTries remaining : " + (MAX_WRONG_ATTEMPTS - wrongTries));
        HangmanGraphic.hangmanImage(wrongTries);
    }

    private static String getLetter(Scanner input) {
        System.out.print("Enter a letter : ");
        String str = input.next();
        if (str.length() > 1)
            str = str.substring(0, 1);
        return str;
    }

    private void displayRevealedWord() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < revealedWord.length; i++) {
            builder.append(revealedWord[i]);
            builder.append(" ");
        }

        String result = builder.toString();
        System.out.println("\n" + result);
    }

    private void reportResult() {
        if (isWon()) {
            System.out.println("\nYou win!");
        }

        if (isLost()) {
            System.out.println("\nYou lose!");
            System.out.println("=> Word to find was : " + targetWord);
        }
    }

    private boolean isGameOver() {
        return isLost() || isWon();
    }

    private boolean isLost() {
        return wrongTries >= MAX_WRONG_ATTEMPTS;
    }

    private boolean isWon() {
        return targetWord.contentEquals(new String(revealedWord));
    }


    public static void main(String[] args) {
        System.out.println("Hangman Game - with Java Keywords");
        HangmanGame hangmanGame = new HangmanGame();
        hangmanGame.newGame();
        hangmanGame.play();
    }
}