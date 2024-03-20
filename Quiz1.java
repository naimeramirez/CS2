public class Quiz1 {
        public static double getMax(double[] array) {
            if (array == null || array.length == 0) {
                throw new IllegalArgumentException("empty array");
            }

            double max = array[0];

            for (int i = 1; i < array.length; i++) {
                if (array[i] > max) {
                    max = array[i];
                }
            }

            return max;
        }

        public static void main(String[] args) {
            double[] numbers = {10.5, 20.8, 15.3, 30.2, 25.7};
            double max = getMax(numbers);
            System.out.println("The maximum value in the array is: " + max);
        }

}
