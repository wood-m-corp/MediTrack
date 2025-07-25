import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class InputUtility {
    private static final Scanner keyboard = new Scanner(System.in);

    public static String prompt(String message) {
        System.out.print(message);
        return keyboard.nextLine();
    }

    public static LocalDate promptDate(String message) {
        while(true) {
            System.out.println(message + "yyyy-MM-dd");
            String input = keyboard.nextLine();
            try {
                return LocalDate.parse(input);
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date. Please use format yyyy-MM-dd.");
            }
        }
    }

    public static int promptInt(String message) {
        System.out.print(message);
        while(!keyboard.hasNextInt()) {
            System.out.println("Invalid input. Please enter am integer number: ");
            keyboard.next();
        }
        return keyboard.nextInt();
    }
}
