/**
 * Это класс, который печатает разные изображения в зависимости от количества ошибок.
 * @author Адам Д.
 */
public class DraftsmanImpl implements Draftsman{
    /**
     * Метод, который принимает номер ошибки и печатает изображение в зависимости от номера ошибки.
     * @param numberOfMistake номер ошибки.
     */
    @Override
    public void showImage(int numberOfMistake) {
        Image[] images = Image.values();
        System.out.print(images[numberOfMistake - 1].getImage() + "\n");
    }
}
