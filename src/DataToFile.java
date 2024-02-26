import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.PriorityQueue;

final public class DataToFile {
    /**
     * Создает файл, если его нет и записывает даннык,
     *
     * @param data массив для записи в файл
     * @throws IOException Ошибка ввода вывода
     * @throws NullPointerException Ошибка пустой очереди
     */

    public static void fileCreate(PriorityQueue<Toy> data) throws IOException, NullPointerException {
        //append = Files.exists(Path.of(data[0]));
        boolean append = false;
        System.out.println("Запись результатов в файл...");
        try (FileWriter fileWriter = new FileWriter("result.txt", append);) {
            StringBuilder dataToWrite = new StringBuilder();
            while(!data.isEmpty()){
                dataToWrite.append(data.poll()).append("\n");
            }
//            for (String element : data) dataToWrite.append(element).append("\n");
//            if (append) fileWriter.write("\n");
            fileWriter.write(dataToWrite.toString().trim());
            System.out.println("Запись результатов в файл окончена!");
        }

    }







}