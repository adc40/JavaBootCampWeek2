package JavaBootCampWeek2;

/**
 * Created by Abram on 6/23/2015.
 */
public class poker {

    public static int ranking = 0, counter = 0;
    public static int[] sorted = new int[5];
    public static int[] sorted1 = new int[5];

    /*checks whether if all suits are the same
     * @param suit is char array for now
      * @return boolean*/
    public static boolean flush(char[] suit) {
        if (suit[1] == suit[3] && suit[1] == suit[5] && suit[1] == suit[7] && suit[1] == suit[9]) {
            return true;
        } else {
            return false;
        }
    }

    /*looks for matching cards
     * @param cardNumbers is char array for now
      * @return int representing the count of found match,
      * careful though, this method counts each match twice*/
    public static int match(int[] cardNumbers) {
        int same = 0;
        int length = cardNumbers.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (i != j && cardNumbers[i] == cardNumbers[j]) {
                    ++same;
                }
            }
        }

        switch (same) {
            case 0:
                ranking = 1;
                break;
            case 2:
                ranking = 2;
                sorted = sortPairs(sorted);
                break;
            case 4:
                ranking = 3;
                sorted = sortPairs(sorted);
                break;
            case 6:
                ranking = 4;
                sorted = sort3(sorted);
                break;
            case 8:
                ranking = 7;
                sorted = sort3(sorted);
                break;
            case 12:
                ranking = 8;
                sorted = sortQuads(sorted);
                break;
        }
        return ranking;
    }

    /*sorts the cards descending sort
     * @param array is char array for now to account for both numbers and letters
      * @return int array*/
    public static int[] sort(char[] array) {
        int length = array.length;
        int[] newArray = new int[array.length/2];
        int temp;
        for (int i = 0, j = 0; i < length; i = i + 2, j++) {
//            if ((Integer.parseInt(String.valueOf(array[i]))) > 2 && (Integer.parseInt(String.valueOf(array[i]))) < 9) {
//                newArray[i] = (Integer.parseInt(String.valueOf(array[i])));
//            }
            switch (array[i]) {
                case '2':
                    newArray[j] = 2;
                    break;
                case '3':
                    newArray[j] = 3;
                    break;
                case '4':
                    newArray[j] = 4;
                    break;
                case '5':
                    newArray[j] = 5;
                    break;
                case '6':
                    newArray[j] = 6;
                    break;
                case '7':
                    newArray[j] = 7;
                    break;
                case '8':
                    newArray[j] = 8;
                    break;
                case '9':
                    newArray[j] = 9;
                    break;
                case 'T':
                    newArray[j] = 10;
                    break;
                case 'J':
                    newArray[j] = 11;
                    break;
                case 'Q':
                    newArray[j] = 12;
                    break;
                case 'K':
                    newArray[j] = 13;
                    break;
                case 'A':
                    newArray[j] = 14;
                    break;
            }
        }
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 4; j++) {
                if (newArray[j] < newArray[j + 1]) {
                    temp = newArray[j + 1];
                    newArray[j + 1] = newArray[j];
                    newArray[j] = temp;
                }
            }
        }
        return newArray;
    }

    /*resorts the array in descending order moving matching cards to the top
     * used for hands with one or two pairs
     * @param array is an array which was sorted into descending order
      * @returns the resorted array*/
    public static int[] sortPairs(int[] array) {
        int length = array.length;
        int temp;
        for (int i = 0; i < length - 1; i++) {
            if (array[i] == array[i + 1]) {
                array[i] = array[i] + 20;
                array[i + 1] = array[i + 1] + 20;
            }
        }
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 4; j++) {
                if (array[j] < array[j + 1]) {
                    temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }

    /*/*resorts the array in descending order moving matching cards to the top
     * used for hands with three of a kind or full house
     * @param array is an array which was sorted into descending order
      * @returns the resorted array*/
    public static int[] sort3(int[] array) {
        int length = array.length;
        int temp;
        for (int i = 1; i < length - 1; i++) {
            if (array[i] == array[i - 1] && array[i] == array[i + 1]) {
                array[i] = array[i] + 20;
                array[i - 1] = array[i - 1] + 20;
                array[i + 1] = array[i + 1] + 20;
            }
        }
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 4; j++) {
                if (array[j] < array[j + 1]) {
                    temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }

    /*resorts the array in descending order moving matching cards to the top
     * used for hands with four of a kind
     * @param array is an array which was sorted into descending order
      * @returns the resorted array*/
     public static int[] sortQuads(int[] array) {
         int length = array.length;
         int temp;
         if (array[0] != array[1]) {
             temp = array[0];
             array[0] = array[length - 1];
             array[length - 1] = temp;
         }
         return array;
     }

    /*checks if hand is a straight
     * @param cardNumber is int array for now
      * @return boolean*/
    public static boolean straight(int[] cardNumber) {
        int length = cardNumber.length;
        boolean straight = true;

        for (int i = 0; i < length - 1; i++) {
            if (cardNumber[i] - 1 == cardNumber[i + 1]) {
            } else {
                straight = false;
                break;
            }
        }

        return straight;
    }

    /*uses previous methods to give a five card hand a ranking
     * @param hand is char array
      * @return int ranking*/
    public static int rank(char[] hand) {
        sorted = sort(hand);
        if (flush(hand) && straight(sorted)) {
            if (sorted[0] == 14) {
                ranking = 10;
                System.out.println("Royal Flush!!! " + ranking);
            } else {
                ranking = 9;
                System.out.println("straight flush " + ranking);
            }
        } else if (flush(hand)) {
                ranking = 6;
                System.out.println("flush " + ranking);
            } else if (straight(sorted)) {
                ranking = 5;
                System.out.println("straight " + ranking);
            } else {
                ranking = match(sorted);
            }
        if (counter == 0) {
            sorted1 = sorted;
            counter++;
        }
        return ranking;
    }

    public static void main(String[] args) {

        String bothHands = "QC KC 3C QD 2S QH 3S 2D QH KD";
        char[] bothHandsChar = bothHands.toCharArray();
//        for (int i = 0; i < length; i++) {
//            System.out.println("bothHandsChar = " + bothHandsChar[i]);
//        }
        char[] hand1 = new char[10];
        char[] hand2 = new char[10];
        int length = bothHandsChar.length;
        int halfLength = length / 2;
        int index1 = 0, index2 = 0, counter = 0;

        for (int i = 0; i < length; i++) {
            if (i < halfLength && !Character.isWhitespace(bothHandsChar[i])) {
                hand1[index1++] = bothHandsChar[i];
            } else if (!Character.isWhitespace(bothHandsChar[i])) {
                hand2[index2++] = bothHandsChar[i];
            }
        }

//        for (int i = 0; i < hand1.length; i++) {
//            System.out.println("hand1 "+i+" = " + hand1[i] + " hand2 "+i+" = " + hand2[i]);
//        }

        if (rank(hand1) > rank(hand2)){
            System.out.println("Player 1 wins!");
            counter++;
        } else if (rank(hand1) < rank(hand2)) {
            System.out.println("Player 2 wins!");
            counter++;
        } else {
            for (int i = 0; i < 5; i++) {
                if (sorted1[i] != sorted[i]) {
                    if (sorted1[i] > sorted[i]) {
                        System.out.println("Player 1 wins!");
                        counter++;
                        break;
                    } else {
                        System.out.println("Player 2 wins!");
                        counter++;
                        break;
                    }
                }
            }
        }
        if (counter == 0) {
            System.out.println("Chop it up!");
        }

        for (int i = 0; i < hand1.length/2; i++) {
            System.out.println(sorted1[i] + " " + sorted[i]);
        }

    }
}