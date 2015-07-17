package JavaBootCampWeek2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

/**
 * Created by Abram on 6/29/2015.
 */
public class AlphabetizeNames {

    public static void main(String[] args) throws IOException {

        FileReader fr = new FileReader(new File("C:\\Users\\Abram\\IdeaProjects\\HelloIntelliJ\\src\\JavaBootCampWeek2\\names"));
        BufferedReader bf = new BufferedReader(fr);
        String input = bf.readLine();
        fr.close();
        bf.close();
        input = input.replace("\"", " ").replace(" ", "");
        String[] names = input.split(",");
        Arrays.sort(names);

        int length = names.length;
        System.out.println("length = " + length);
        for (int i = 0; i < length; i++) {
            System.out.print("(" + (i + 1) + ")" + names[i] + " ");
        }

        System.out.println();

        int[] scores = new int[length];
        int sum, nameScore;
        for(int i = 0; i < length; i++) {
            sum = 0;
            for(int j = 0; j < names[i].length(); j++) {
                sum = sum + (Integer.valueOf(names[i].charAt(j)) - 64);
            }
            nameScore = sum * (i + 1);
            scores[i] = nameScore;
        }

        for (int i = 0; i < length; i++) {
            System.out.print("(" + (i + 1) + ") = " + scores[i] + " ");
        }

        System.out.println();
        int grandTotal = 0;
        for(int i = 0; i < length; i++) {
            grandTotal = grandTotal + scores[i];
        }
        System.out.println("grandTotal = " + grandTotal);
    }
}
