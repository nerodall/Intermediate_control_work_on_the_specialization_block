import java.io.FileWriter;
import java.io.IOException;

public class WriteFile {
    public void saveResultToFile(Toy toy) {
        try (FileWriter fw = new FileWriter("Result.txt", true)) {
            fw.write(toy.getName());
            fw.append("\n");
            fw.flush();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void clearFile() throws IOException {
        new FileWriter("Result.txt", false).close();
    }
}
