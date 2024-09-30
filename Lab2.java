import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Lab2 {

    public static void main(String[] args) {
        int numSets = 50;
        int[] sizes = {100, 200, 300, 400, 500, 600, 700, 800, 900, 1000};

        try (FileWriter writer = new FileWriter("results.txt")) {
            writer.write("Size Avg Count Coef Count Avg Time Coef Time\n");

            for (int size : sizes) {
                System.out.println("Generating data sets for size: " + size);
                int[][] dataSets = generateDataSets(size, numSets);

                int[] iterativeCounts = new int[numSets];
                long[] iterativeTimes = new long[numSets];
                int[] recursiveCounts = new int[numSets];
                long[] recursiveTimes = new long[numSets];

                for (int i = 0; i < numSets; i++) {
                    int[] dataSet = dataSets[i].clone();

                    BubbleSortMetrics iterativeMetrics = bubbleSortIterativeWithMetrics(dataSet.clone());
                    iterativeCounts[i] = iterativeMetrics.criticalCount;
                    iterativeTimes[i] = iterativeMetrics.timeTaken;

                    BubbleSortMetrics recursiveMetrics = bubbleSortRecursiveWithMetrics(dataSet.clone(), dataSet.length, 0);
                    recursiveCounts[i] = recursiveMetrics.criticalCount;
                    recursiveTimes[i] = recursiveMetrics.timeTaken;
                }

                double avgCount = calculateMean(iterativeCounts);
                double coefCount = calculateCoefficientOfVariance(iterativeCounts);
                double avgTime = calculateMean(iterativeTimes);
                double coefTime = calculateCoefficientOfVariance(iterativeTimes);

                writer.write(size + " " + avgCount + " " + coefCount + "% " + avgTime + " " + coefTime + "%\n");
                System.out.println("Completed size: " + size);
                System.out.println("Avg Count: " + avgCount + ", Coef Count: " + coefCount + "%, Avg Time: " + avgTime + " ns, Coef Time: " + coefTime + "%");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static class NotSortedException extends Exception {
        public NotSortedException(String message) {
            super(message);
        }
    }

    public static class BubbleSortMetrics {
        public long timeTaken;
        public int criticalCount;

        public BubbleSortMetrics(long timeTaken, int criticalCount) {
            this.timeTaken = timeTaken;
            this.criticalCount = criticalCount;
        }
    }

    public static BubbleSortMetrics bubbleSortIterativeWithMetrics(int[] arr) {
        int n = arr.length;
        int criticalCount = 0;
        long startTime = System.nanoTime();

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                criticalCount++;
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        long endTime = System.nanoTime();
        return new BubbleSortMetrics(endTime - startTime, criticalCount);
    }

    public static BubbleSortMetrics bubbleSortRecursiveWithMetrics(int[] arr, int n, int criticalCount) {
        if (n == 1) {
            return new BubbleSortMetrics(0, criticalCount);
        }

        long startTime = System.nanoTime();

        for (int i = 0; i < n - 1; i++) {
            criticalCount++;
            if (arr[i] > arr[i + 1]) {
                int temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }
        }

        long endTime = System.nanoTime();
        BubbleSortMetrics metrics = bubbleSortRecursiveWithMetrics(arr, n - 1, criticalCount);
        metrics.timeTaken += (endTime - startTime);
        return metrics;
    }

    public static int[][] generateDataSets(int size, int numSets) {
        Random rand = new Random();
        int[][] dataSets = new int[numSets][size];

        for (int i = 0; i < numSets; i++) {
            for (int j = 0; j < size; j++) {
                dataSets[i][j] = rand.nextInt(size * 10);
            }
        }

        return dataSets;
    }

    public static void verifySorted(int[] arr) throws NotSortedException {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                throw new NotSortedException("Array is not sorted correctly.");
            }
        }
    }

    public static double calculateMean(int[] values) {
        double sum = 0;
        for (int value : values) {
            sum += value;
        }
        return sum / values.length;
    }

    public static double calculateStandardDeviation(int[] values, double mean) {
        double sum = 0;
        for (int value : values) {
            sum += Math.pow(value - mean, 2);
        }
        return Math.sqrt(sum / values.length);
    }

    public static double calculateCoefficientOfVariance(int[] values) {
        double mean = calculateMean(values);
        double standardDeviation = calculateStandardDeviation(values, mean);
        return (standardDeviation / mean) * 100;
    }

    public static double calculateMean(long[] values) {
        double sum = 0;
        for (long value : values) {
            sum += value;
        }
        return sum / values.length;
    }

    public static double calculateStandardDeviation(long[] values, double mean) {
        double sum = 0;
        for (long value : values) {
            sum += Math.pow(value - mean, 2);
        }
        return Math.sqrt(sum / values.length);
    }

    public static double calculateCoefficientOfVariance(long[] values) {
        double mean = calculateMean(values);
        double standardDeviation = calculateStandardDeviation(values, mean);
        return (standardDeviation / mean) * 100;
    }


}
