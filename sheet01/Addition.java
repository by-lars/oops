import java.util.InputMismatchException;
import java.util.Scanner;

public class Addition {

    //Blackbox
    private final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        /**
         * c)
         * Mit einer Deklarierung erzeugt man eine neue Variabel
         * Mit einer Initialisierung weist man den Wert zu
         */

        int input1 = readIntFromConsole();
        int input2 = readIntFromConsole();
        int sum = input1 + input2;

        System.out.println("Sum: " + sum);
        System.out.println("Your input1: " + input1);
        System.out.println("Your input2: " + input2);

    }

    /**
     * Blackbox-Methode zum Einlesen aus der Konsole. Bei einer fehlerhaften Eingabe wird zu einer
     * erneuten Eingabe aufgefordet,
     *
     * @return Bei korrekter Eingabe, die Eingabe als int
     */
    public static int readIntFromConsole() {

        System.out.print("Please insert an integer: ");
        try {
            return scanner.nextInt();
        } catch (InputMismatchException ime) {
            System.out.println("[Error] Input is not a whole number!");
            scanner.next();
        }

        return readIntFromConsole();
    }
}
