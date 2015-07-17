package JavaBootCampWeek2;

/**
 * Created by Abram on 6/25/2015.
 */
public class SumAndAverage {
    public static void main(String[] args) {
        int n = 0, upperBound = 100, sum = 0, counter = 0, average;
        while (n < upperBound) {
//            if (n % 7 == 0) {
//                sum = sum + n;
//                counter++;
//            }
//            n++;
            sum = sum + (n * n);
            n++;
            counter++;
        }

        average = sum / counter;
        System.out.println("The sum of sevens = " + sum);
        System.out.println("The average is " + average);
        System.out.println(counter + " numbers counted");
    }
}
