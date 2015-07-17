package JavaBootCampWeek2;

/**
 * Created by Abram on 6/25/2015.
 */
public class StringManipulation {
    public static void main(String[] args) {
        String input = args[0];
        int length = input.length();
        char[] text = input.toCharArray();
        String alteredInput;

        for (int i = 0; i < length; i++) {
             if (!Character.isWhitespace(input.charAt(i))) {
                text[i] = (char) (((int) input.charAt(i)) + 1);
             } else {
                 text[i] = ' ';
             }
        }

        alteredInput = String.valueOf(text);

        System.out.println("Original input: " + input);
        System.out.println("alteredInput = " + alteredInput);
    }
}
