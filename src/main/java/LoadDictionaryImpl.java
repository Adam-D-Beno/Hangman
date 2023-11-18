import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Этот класс загружает словарь из внешнего источника.
 * @author Адам Д.
 */
public class LoadDictionaryImpl implements LoadDictionary{
    /** Путь файлу словаря */
    static final String PATH_DICTIONARY = "src/main/resources/singular.txt";

    /**
     * Метод загружает словарь из внешнего источника.
     * @return возвращает лист из словаря.
     * @throws RuntimeException выбрасывает если нет доступа к словарю.
     */
    @Override
    public List<String> loadFile() {

        try {
            return new ArrayList<>(Files.readAllLines(Paths.get(PATH_DICTIONARY)));
        } catch (IOException e) {
            throw new RuntimeException(e + "Dictionary not found");
        }
    }
}
