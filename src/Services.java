import java.util.HashMap;

public class Services {
    public static void clearConsole() {
        try {
            String operatingSystem = System.getProperty("os.name");

            if (operatingSystem.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                ProcessBuilder pb = new ProcessBuilder("clear");
                Process startProcess = pb.inheritIO().start();
                startProcess.waitFor();
            }
        } catch (Exception e) {
            System.out.println(e);

        }
    }

    public static String newHiddenWord(String secretWord) {
        String hiddenWord = secretWord;
        for (int i = 0; i < secretWord.length(); i++) {
            hiddenWord = hiddenWord.substring(0, i) + '_' + hiddenWord.substring(i + 1);
        }
        return hiddenWord;
    }

    public static String checkForGuess(String secretWord, String hiddenWord, String guess) {
        for (int i = 0; i < secretWord.length(); i++) {
            if (secretWord.charAt(i) == guess.charAt(0)) {
                hiddenWord = hiddenWord.substring(0, i) + secretWord.charAt(i) + hiddenWord.substring(i + 1);

            }
        }
        return hiddenWord;
    }

    public static boolean checkForMissed(String secretWord, String guess, boolean missed) {
        missed = true;
        for (int i = 0; i < secretWord.length(); i++) {
            if (secretWord.charAt(i) == guess.charAt(0)) {
                missed = false;

            }
        }
        return missed;
    }

}
