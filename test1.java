public class test1 {
    public static void main(String[] args) {
        char[] charArray = {'b', 'a', 'n', 'a', 'n', 'a', 's'};
        printReverse(charArray);
    }

    public static void printReverse(char[] array) {
        printReverseRecursive(array, array.length - 1);
    }

    private static void printReverseRecursive(char[] array, int index) {
        if (index >= 0) {
            System.out.print(array[index]);
            printReverseRecursive(array, index - 1);
        }
    }
}

