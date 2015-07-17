package JavaBootCampWeek2;

/**
 * Created by Abram on 6/25/2015.
 */
public class EvenFibonacciNumbers {
    public static void main(String[] args) {
        int a = 1, b = 2, c = 0, sum = 2;
        while (c < 4000000) {
            c = a + b;
            a = b;
            b = c;
            if ( c % 2 == 0) {
                sum = sum + c;
            }
        }
        System.out.println("sum = " + sum);
    }
}
