package JavaBootCampWeek2;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Abram on 6/26/2015.
 */
public class Consecutive {
    public static void main(String[] args) {

        ArrayList<Integer> prime = new ArrayList<>();
        boolean isPrime = true;
        int answer = 0;

        for(int i = 2; prime.size() < 100; i++) {
            for(int j = 2; j < i; j++) {
                if (i % j == 0) {
                    isPrime = false;
                }
            }
            if (isPrime) {
                prime.add(i);
            }
            isPrime = true;
        }
        System.out.println(prime);
        System.out.println("Size of array = " + prime.size());

        /*calculates how many numbers are missing between two any two indexes of the array
         * starts from the beginning, steps through each consecutive pair of indexes, and keeps
          * a running total*/
        for (int i = 0; i < 99; i++) {
            answer = answer + ((prime.get(i + 1) - prime.get(i)) - 1);
        }
        System.out.println("There are " + answer + " missing numbers.");

    }
}
