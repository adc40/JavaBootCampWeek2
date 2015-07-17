package JavaBootCampWeek2;

import java.io.*;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Abram on 6/26/2015.
 */
public class LargeSums {

    public static void main(String[] args) throws IOException {

        /* gets the list of really long numbers from the file and stores them in an array */
        FileReader fr = new FileReader(new File ("C:\\Users\\Abram\\IdeaProjects\\HelloIntelliJ\\src\\JavaBootCampWeek2\\longnums"));
        BufferedReader bf = new BufferedReader(fr);
        String[] numbers = new String[100];

        for(int i = 0; i < 100; i++) {
            numbers[i] = bf.readLine();
        }
        fr.close();
        bf.close();

        /* sorts the array */
        Arrays.sort(numbers);

//      String temp;
//      int length = numbers[0].length();
//        for (int a = 0; a < 99; a++) {
//            for (int i = 0; i < 99; i++) {
//                for (int j = 0; j < length - 1; j++) {
//                    if ((Integer.valueOf(numbers[i].substring(j, j + 1)) <
//                        Integer.valueOf(numbers[i + 1].substring(j, j + 1)))) {
//                        break;
//                    } else if (Integer.valueOf(numbers[i].substring(j, j + 1)) >
//                        Integer.valueOf(numbers[i + 1].substring(j, j + 1))) {
//                        temp = numbers[i];
//                        numbers[i] = numbers[i + 1];
//                        numbers[i + 1] = temp;
//                        break;
//                    } else if (Integer.valueOf(numbers[i].substring(j, j + 1)) ==
//                        Integer.valueOf(numbers[i + 1].substring(j, j + 1))) {
//                    }
//                }
//            }
//        }

        /* prints the sorted array */
        for (int i = 0; i < 100; i++) {
            System.out.println(numbers[i]);
        }

        /* calculates total of all really big numbers by adding each column individually, starting with
            the ones column, moving to tens, then hundreds and so on,
            and storing each subtotal in an array list */
        ArrayList<Integer> bigSum = new ArrayList<>();
        int length = numbers[0].length();
        int sum = 0;

        for (int j = 0; j < length; j++) {  //<---iterates the same number of times as the length of each number
            for (int i = 0; i < numbers.length; i++) { //<---steps through each number
                if (j == 0) { //<---starts at end of number, the ones position, so no second index needed in substring
                    sum = sum + Integer.valueOf(numbers[i].substring(length - 1));
                } else {
                    sum = sum + Integer.valueOf(numbers[i].substring((length - 1) - j, (length - 1) - (j - 1)));
                }
            }
            bigSum.add(sum % 10); //<---stores last digit into array list
            sum = sum / 10; //<---carry the "1"
        }

        //System.out.println(bigSum.size());
        //System.out.println("sum = " + sum);
        System.out.println("bigSum = " + bigSum);
        String answer = Integer.toString(sum);

        for (int i = bigSum.size() - 1; i > bigSum.size() - 9; i-- ) {
            answer = answer + bigSum.get(i).toString();
        }

        System.out.println("answer = " + answer);
    }
}


