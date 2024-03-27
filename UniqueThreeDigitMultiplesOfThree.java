public class UniqueThreeDigitMultiplesOfThree {
    public static void main(String[] args) {
        int count = 0;
        for (int number = 100; number < 1000; number++) {
            if (number % 3 == 0 && areDigitsUnique(number)) {
                count++;
            }
        }
        System.out.println("Total numbers: " + count);
    }

    private static boolean areDigitsUnique(int number) {
        boolean[] digitSeen = new boolean[10]; // Tracks digits 0-9
        while (number > 0) {
            int digit = number % 10;
            if (digitSeen[digit]) {
                // Digit repeats
                return false;
            }
            digitSeen[digit] = true;
            number /= 10;
        }
        return true;
    }
}
