import java.util.Scanner;

public class GameLogic {

    byte chancesRemaining = 6;
    boolean win;
    boolean missed;

    GameLogic(String secretWord) {
        Scanner scanner = new Scanner(System.in);
        new Services();
        String hiddenWord = Services.newHiddenWord(secretWord);
        System.out.println(hiddenWord);
        int wordLength = hiddenWord.length();
        while (true) {
            Services.clearConsole();
            missed = false;
            //header
            System.out.println("Chances Reamining  " + chancesRemaining);
            System.out.println("Word Length  " + wordLength + "\n");
            System.out.println(hiddenWord);
            //logic for input
            String guess = scanner.nextLine();
            if (guess.length() > 1) {
                if (guess.length() == wordLength) {
                    if (secretWord.equalsIgnoreCase(guess.trim())) {
                        win = true;
                        break;
                    } else {
                        System.out.println(secretWord + "   " + hiddenWord);
                        win = false;
                        break;
                    }
                }
            } else if (guess.length() == 1 && guess != " ") {
                missed = Services.checkForMissed(secretWord, guess, missed);
                hiddenWord = Services.checkForGuess(secretWord, hiddenWord, guess);
            }
            if (missed) {
                chancesRemaining--;
            }
            //lose
            if (chancesRemaining <= 0) {
                win = false;
                break;
            }
            //win
            if (secretWord.equalsIgnoreCase(hiddenWord)) {
                win = true;
                break;
            }
        }
        Services.clearConsole();
        if (win) {
            System.out.println("You Won the word was:  " + secretWord);
            System.out.println("Remaining Chances:  "+chancesRemaining);
        } else {
            System.out.println("You Lost the word was:  " + secretWord);
        }
    }


}
