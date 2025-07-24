import java.util.Scanner;
public class InputUtility {
    private static final Scanner keyboard = new Scanner(System.in);

    public static String prompt(String message) {
        System.out.print(message);
        return keyboard.nextLine();
    }
}
