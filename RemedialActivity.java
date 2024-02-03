import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

public class RemedialActivity {
    public static int[] readValuesFromFile(String fileName) throws FileNotFoundException {
        Scanner fileScanner = new Scanner(new File(fileName));
        int numValues = fileScanner.nextInt();
        int[] values = new int[numValues];

        for (int i = 0; i < numValues; i++) {
            values[i] = fileScanner.nextInt();
        }

        fileScanner.close();
        return values;
    }

    public static void print(int[] array) {
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public static int findSum(int[] array) {
        int sum = 0;
        for (int value : array) {
            sum += value;
        }
        return sum;
    }

    public static double findAVG(int[] array) {
        int sum = findSum(array);
        return (double) sum / array.length;
    }

    public static void writeResultsToFile(String fileName, int[] array) throws FileNotFoundException {
        PrintWriter writer = new PrintWriter(new File(fileName));

        for (int i = 0; i < array.length; i++) {
            writer.print(array[i]);
            if (i < array.length - 1) {
                writer.print(" + ");
            }
        }
        writer.println();

        writer.println("sum: " + findSum(array));
        writer.println("average: " + findAVG(array));

        writer.close();
    }

    public static void main(String[] args) {
        try {
            Random rand = new Random();
            int[] intArray = new int[10];
            for (int i = 0; i < intArray.length; i++) {
                intArray[i] = rand.nextInt(11);
            }

            int[] fileArray = readValuesFromFile("numbers.txt");

            writeResultsToFile("results.txt", fileArray);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
