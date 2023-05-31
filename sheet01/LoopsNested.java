import java.util.InputMismatchException;
import java.util.Scanner;

public class LoopsNested {

    //Blackbox
    private final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int n = readIntFromConsole();

        // a)
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
               System.out.print("* ");
            }
            System.out.print("\n");
        }
        System.out.print("\n");


        // b)
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j<=i; j++) {
                System.out.print("* ");
            }
            System.out.print("\n");
        }
        System.out.print("\n");


        // c)
        for(int i = 1; i<=n; i++) {
            System.out.print("* ");
        }
        System.out.print("\n");

        for(int i = 2; i < n; i++) {
            System.out.print("* ");
            for(int j = 2; j < n; j++) {
                System.out.print("  ");
            }
            System.out.print("* ");
            System.out.print("\n");
        }

        for(int i = 1; i<=n; i++) {
            System.out.print("* ");
        }
        System.out.print("\n\n");

        // d)
        for(int i = 1; i <= n; i++) {
            System.out.print("* ");
        }
        System.out.print("\n");

        for(int i = 2; i < n; i++) {
            System.out.print("* ");

            for(int j = 1; j <= (n/2); j++) {
                System.out.print("  ");
            }

            for(int j = 1; j <= (n/2); j++) {
                System.out.print("* ");
            }
            System.out.print("\n");
        }

        for(int i = 1; i <= n; i++) {
            System.out.print("* ");
        }
        System.out.print("\n");
    }

    /**
     * #BLACKBOX
     * Blackbox-Methode zum Einlesen aus der Konsole. Bei einer fehlerhaften Eingabe wird zu einer
     * erneuten Eingabe aufgefordet,
     *
     * @return Bei korrekter Eingabe, die Eingabe als int
     */
    public static int readIntFromConsole() {

        System.out.print("Please input a natural number: ");
        try {
            int n = scanner.nextInt();

            if (n < 1) {
                System.out.println("[Error] Input is not a natural number!");
                return readIntFromConsole();
            } else {
                return n;
            }
        } catch (InputMismatchException ime) {
            System.out.println("[Error] Input is not a number!");
            scanner.next();
        }

        return readIntFromConsole();
    }
}