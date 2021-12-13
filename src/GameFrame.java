import java.util.Scanner;

public class GameFrame {
    GameFrame(){
        new Services();
        Scanner scanner = new Scanner(System.in);

        Services.clearConsole();
        System.out.println("Digite a palavra secreta");
        String secretWord = scanner.nextLine();
        Services.clearConsole();
        new GameLogic(secretWord);

    }
}
