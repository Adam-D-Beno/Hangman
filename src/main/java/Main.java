
import java.util.*;

public class Main {

    private final static char YES = 'н';
    private final static char EXIT = 'в';

    public static void main(String[] args) {
        LoadDictionary loadDictionary = new LoadDictionaryImpl();
        Draftsman draftsman = new DraftsmanImpl();
        RandomWord randomWord = new RandomWordImpl(loadDictionary);
        GameEngine engine = new GameEngine(draftsman, randomWord);
        Scanner in = new Scanner(System.in);

        System.out.println("[N]ew game or [E]xit");

        while (true) {
            System.out.println("Начать новую игру(Н) или выйти(В) из приложения ?");
            char select = in.next().toLowerCase().charAt(0);

            if (select == YES) {
                engine.startGame();
            } else if (select == EXIT) {
//                in.close();
                System.exit(0);
            } else {
                System.out.println("Сделайте выбор ещё раз");
            }
        }
    }
}
