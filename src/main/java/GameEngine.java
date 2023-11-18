import java.util.*;

/**
 * В этом классе описана логика работы игры. Данный класс через конструктор принимает объекты.
 * @author Адам Д.
 */
public class GameEngine {

    /** Поле содержит объект класса Draftsman, который печатает изображение ошибки*/
    private final Draftsman draftsman;
    /** Поле содержит объект класса RandomWord, который выдает случайное слово */
    private final RandomWord randomWord;
    /** Поле хранить максимальное количество ошибок */
    private final int maxError = 2;
    private char[] secretWordView;
    private int numberCorrectAnswer;
    private int numberWrongAnswer;
    private Set<Integer> indexFoundChar;
    private Set<Character> enteredCharacters;
    private Map<Character, Integer> numberUniqueCharacters;

    /**
     * Конструктор
     * @param draftsman объект класса который печатает изображение ошибки
     * @param randomWord объект класса который возвращает случайное слово
     */
    public GameEngine(Draftsman draftsman, RandomWord randomWord) {
        this.draftsman = draftsman;
        this.randomWord = randomWord;
    }

    public void startGame() {
      boolean gameNOtOver = true;
       String secretWord = getRandomWord();

       initParam(secretWord);
       while (gameNOtOver) {
           System.out.print("Введите букву: ");
           Scanner scanner = new Scanner(System.in);
           char input = scanner.next().toLowerCase().charAt(0);

           if (Character.isDigit(input)) {
               System.out.println("Не корректный ввод");
               continue;
           }
           System.out.println("\n \n \n \n \n \n \n \n \n \n");

           for (int i = 0; i < secretWord.length(); i++) {

               if (indexFoundChar.contains(i)) {
                   continue;
               }
               if (enteredCharacters.contains(input) && numberUniqueCharacters.get(input) == 1) {
                   System.out.println("Вы уже вводили эту букву.");
                   break;
               }
               if (input == secretWord.charAt(i)) {
                   logicCorrectAnswer(input, i);
                   break;
               } else if (i == secretWord.length() - 1){
                   logicWrongAnswer();
               }
           }
            if (numberCorrectAnswer == secretWord.length()) {
                System.out.println("\n \n \tПоздравляем ! Вы выйграли ! \n \n");
                gameNOtOver = false;
            }else if (numberWrongAnswer == maxError){ //
                System.out.println("\n \tВы проиграли, допустив много ошибок !  \n \n");
                gameNOtOver = false;
            }
       }
    }

    /**
     * Метод, который выдает случайное слово.
     * @return возвращает строку содержавший случайное слово.
     */
    private String getRandomWord() {
        return randomWord.getRandomWord();
    }

    /**
     * Методы принимает номер ошибки и печатает изображение.
     * @param numberWrongAnswer количество ошибок.
     */
    private void printImage(int numberWrongAnswer) {
        draftsman.showImage(numberWrongAnswer);
    }


    private void logicCorrectAnswer(char input, int index) {
        indexFoundChar.add(index);
        enteredCharacters.add(input);
        numberCorrectAnswer++;
        System.out.println("Вы нашли букву в слове.");
        secretWordView[index] = input;
        System.out.println(secretWordView);
    }

    private void logicWrongAnswer() {
        numberWrongAnswer++;
        System.out.println("Такой буквы нет! У вас осталось попыток " + (numberWrongAnswer - maxError));
        System.out.println();
        printImage(numberWrongAnswer);
    }

    private void initParam(String secretWord) {
        initUniqueCharactersMap(secretWord);
        enteredCharacters = new HashSet<>();
        indexFoundChar = new HashSet<>();
        numberCorrectAnswer = 0;
        numberWrongAnswer = 0;
        secretWordView = "*".repeat(secretWord.length()).toCharArray();
        System.out.println(Arrays.toString(secretWordView) +
                " Количество символов в слове " + secretWord.length());
    }

    private void initUniqueCharactersMap(String secretWord) {
        numberUniqueCharacters = new HashMap<>();
        for (int i = 0; i < secretWord.length(); i++) {
            Character ch = secretWord.toLowerCase().charAt(i);
            if (numberUniqueCharacters.containsKey(ch)) {
                int count = numberUniqueCharacters.get(ch);
                numberUniqueCharacters.put(ch, ++count);
            }else {
                numberUniqueCharacters.put(ch, 1);
            }
        }
    }
}


