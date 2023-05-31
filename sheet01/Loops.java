import java.util.InputMismatchException;
import java.util.Scanner;

public class Loops {

    //Blackbox
    private final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int n = readIntFromConsole();

        // a)
        for(int i = 1; i <= n; i++) {
            System.out.format("%d ", i);
        }
        System.out.println("");


        // b)
        //i)
        int i = 1;
        while(i <= n) {
            System.out.format("%d ", i++);
        }
        System.out.println("");

        //ii)
        i = 0;
        while(i<n) {
            System.out.format("%d ", (++i) * i);
        }
        System.out.println("");

        //iii)
        i = n;
        while(i >= (-n)) {
            System.out.format("%d ", i--);
        }
        System.out.println("");

        // c)
        i = 1;
        while(i <= n) {
            if((i++) % 2 == 0) {
                System.out.print("+ ");
            } else  {
                System.out.print("* ");
            }
        }
        System.out.println("");

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