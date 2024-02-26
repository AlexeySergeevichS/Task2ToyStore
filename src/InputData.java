import java.util.Scanner;

public class InputData {
    public static String inputStr(String message) {
        Scanner sc = new Scanner(System.in);
        System.out.print(message);
        return sc.nextLine();
    }
}
