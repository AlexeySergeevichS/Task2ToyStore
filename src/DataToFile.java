import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

final public class DataToFile {
    /**
     * Создает файл, если его нет и записывает даннык, или дописывает данные в существующий файл
     *
     * @param data массив для записи в файл
     * @throws IOException Ошибка ввода вывода
     */

    public static void fileCreate(String[] data) throws IOException, NullPointerException {
//        boolean append = Files.exists(Path.of(data[0]));
        boolean append = false;
        try (FileWriter fileWriter = new FileWriter("Результат.txt", append);) {
            StringBuilder dataToWrite = new StringBuilder();
            for (String element : data) dataToWrite.append(element).append("\n");
//            if (append) fileWriter.write("\n");
            fileWriter.write(dataToWrite.toString().trim());
        }

    }







}