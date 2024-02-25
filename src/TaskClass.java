import java.util.PriorityQueue;
import java.util.Random;
import java.util.Scanner;

public class TaskClass {
    private static PriorityQueue<Toy> toyPriorityQueue = new PriorityQueue<>(new ToyComparator<>());

    public static void run() {
        int countToys = 0;
        while (true) {
            try {
                countToys = Integer.parseInt(inputStr("Введи количество наименований игрушек\n-> "));
                break;
            } catch (NumberFormatException e) {
                System.out.println("Нужно ввести число!");
            }
        }

        for (int i = 1; i < (countToys + 1); i++) {
            while (true) {
                System.out.printf("+++Введи параметры игрушки %d +++\n", i);
                String toyWeight = inputStr("Вес: ");
                String toyName = inputStr("Название: ");
                try {
                    toyPriorityQueue.add(Toy.create(String.valueOf(i), toyName, toyWeight));
                    break;
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        for (int i = 0; i <10 ; i++) {
            get(toyPriorityQueue);
        }
    }

    private static String inputStr(String message)  {
        Scanner sc = new Scanner(System.in);
        System.out.print(message);
        return sc.nextLine();
    }
    public  static void get(PriorityQueue<Toy> pQ){
        System.out.println(pQ.peek().getToyName());
//        System.out.println(randomInt(pQ.size()));
//        int id = randomInt(pQ.size());
//        for (int i = 0; i < pQ.size(); i++) {
//            id -= chance[i];
//            if(index < 0) {
//                System.out.println("Случайное число: " + number[i]);
//                break;
//            }
//        }
    }
    private static int randomInt(int max){
        Random rnd = new Random();
        return rnd.nextInt(1,max+1);
    }

}
