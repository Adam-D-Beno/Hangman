import java.util.List;
import java.util.Locale;
import java.util.Random;

/**
 * Этот класс принимает через конструктор объект класса и возвращает случайное слово.
 * @author Адам Д.
 */
public class RandomWordImpl implements RandomWord{
    /** Поле содержит объект класса LoadDictionary*/
    private final LoadDictionary loadDictionary;

    /**
     * Конструктор
     * @param loadDictionary объект класса LoadDictionary.
     */
    public RandomWordImpl(LoadDictionary loadDictionary) {
        this.loadDictionary = loadDictionary;
    }

    /**
     * Этот метод загружает словарь и сохраняет его в List<String>.
     * @return возвращает строку содержавший случайное слово.
     */
    @Override
   public String getRandomWord() {
        List<String> words = loadDictionary.loadFile();
        return words.get(new Random().nextInt(words.size())).toLowerCase(Locale.ROOT);
    }
}
