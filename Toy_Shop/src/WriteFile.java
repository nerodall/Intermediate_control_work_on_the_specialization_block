import java.io.FileWriter;
import java.io.IOException;
/**
 * Класс для записи в файл результатов розыгрыша
 */
public class WriteFile {
    /**
     * Метод для записи имени игрушки в файл "Result.txt"
     * Используется при извлечении игрушки из очереди
     * @param toy
     */
    public void saveResultToFile(Toy toy) {
        try (FileWriter fw = new FileWriter("Result.txt", true)) {
            fw.write(toy.getName());
            fw.append("\n");
            fw.flush();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
/**
 * Метод для очистки файла "Result.txt" с результатами розыгрыша
 * @throws IOException
 */
    public void clearFile() throws IOException {
        new FileWriter("Result.txt", false).close();
    }
}
