import java.util.Scanner;

public class Main {

    boolean randPunkt(int x, int y) {
        if(x < 1 || y < 1) return false;
        if(y > 3) return false;
        if(x==1 && y==3) return false;
        if(x==6 && y==3) return false;

        return true;
    }

    /** Aufagbe 3 **/
    public static void main1(String[] args) {
        Scanner input = new Scanner(System.in);

        int age = input.nextInt();
        int visitors = 0;

        int tenns = 0;
        int twens = 0;
        int middle_age = 0;
        int seniors = 0;

        while(age > 0) {

            if(age >= 10 && age <= 19) {
                tenns++;
            } else if(age >= 20 && age <= 29) {
                twens++;
            } else if(age >= 30 && age <= 64) {
                middle_age++;
            } else {
                seniors++;
            }

            System.out.println("Your Age: " + age);

            visitors++;
            age = input.nextInt();
        }

        System.out.println("Teens: " + ((float)tenns / (float)visitors) * 100.0);
        System.out.println("Twens: " + ((float)twens / (float)visitors) * 100.0);
        System.out.println("Middle age: " + ((float)middle_age / (float)visitors) * 100.0);
        System.out.println("Seniors: " + ((float)seniors / (float)visitors) * 100.0);
        System.out.println("Visitors: " + visitors);

    }

    /** Aufgabe 5 **/
    public static void main(String[] args) {
        Kamel lil_bro = new Kamel("Camillo");

        boolean ladung = false;
        while(true) {
            ladung = !ladung;
            lil_bro.beladen(ladung ? "Datteln" : "Feigen");
            lil_bro.karwane();
        }
    }

    /** Aufgabe 4 **/
    void lul() {
        /**
         *                  Anzahl Zeilen
                               v */
        int arr2[][] = new int[4][];
        arr2[0] = new int[]{3,2,5};
        arr2[1] = new int[]{1,4,4,8,13};
        arr2[2] = new int[]{1};
        arr2[3] = new int[]{0,1,-9,4,8,2};

        int sum = 0;
        for(int i = 0; i < arr2.length; i++) {
            sum += arr2[i].length;
        }


        int arr1[] = new int[sum];
        int index = 0;
        for(int i = 0; i < arr2.length; i++) {
            for(int j = 0; j < arr2[i].length; j++) {
                arr1[index] = arr2[i][j];
                index++;
            }
        }


    }
}