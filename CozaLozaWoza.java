package JavaBootCampWeek2;

/**
 * Created by Abram on 6/25/2015.
 */
public class CozaLozaWoza {
    public static void main(String[] args) {

        int x = 1;
        for (int i = 0; i < 10; i++) {  //<--- 10 lines
            for (int j = 0; j < 11; j++) {   //<---11 numbers per line
                if (x % 7 == 0 && x % 5 == 0 && x % 3 == 0) {
                    System.out.print("CozaLozaWoza ");
                } else if (x % 7 == 0 && x % 5 == 0) {
                    System.out.print("LozaWoza ");
                } else if (x % 7 == 0 && x % 3 == 0) {
                    System.out.print("CozaWoza ");
                } else if (x % 5 == 0 && x % 3 == 0) {
                    System.out.print("CozaLoza ");
                } else if (x % 7 == 0) {
                    System.out.print("Woza ");
                } else if (x % 5 == 0) {
                    System.out.print("Loza ");
                } else if (x % 3 == 0) {
                    System.out.print("Coza ");
                } else System.out.print(x + " ");
                x++;
            }
            System.out.println();
        }
    }
}

