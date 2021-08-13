import java.util.*;

public class StringTable {
    public static void main(String[] args) {
        String[] input;
        input = new String[]{"1", "231", "13", "112", "123123132123131",
                             "1222", "11", "1213", "12", "2131231",
                             "133", "1", "112313", "12", "112"};
        int arrLength = input.length;
        printInTable(input,arrLength);
    }

    public static void printInTable(String[] receivedArray, int arrayLength) {
        int posColumn;
        int[] maxColumnValue = new int[5];
        Arrays.fill(maxColumnValue, 0);
        for (int i = 0; i < arrayLength; i++) {
            int strLength = receivedArray[i].length();
            posColumn = (i + 1) % 5;
            if (posColumn == 0) {
                posColumn = 5;
            }
            if (maxColumnValue[posColumn - 1] < strLength) {
                maxColumnValue[posColumn - 1] = strLength;
            }
        }

        System.out.println(Arrays.toString(maxColumnValue));
        for (int i = 0; i < arrayLength; i++) {
            posColumn = (i + 1) % 5;
            if (posColumn == 0) {
                posColumn = 5;
            }
            System.out.printf("%-" + (maxColumnValue[posColumn - 1] + 4) + "s", receivedArray[i]);
            if ((i + 1) % 5 == 0) System.out.println();
        }
    }
}