public class Recursion {
    public static void main(String[] args) {
        int n = 5;
        System.out.println("printReverseIter:");
        printReverseIter(n);

        System.out.println("\nprintReverseRec:");
        printReverseRec(n);

        int sumIter = getSumIter(n);
        System.out.println("\ngetSumIter: " + sumIter);

        int sumRec = getSumRec(n);
        System.out.println("getSumRec: " + sumRec);

        String str = "Recursion";
        System.out.println("printReverse:");
        printReverse(str);
    }

    public static void printReverseIter(int n) {
        for (int i = n; i >= 1; i--) {
            System.out.print(i + " ");
        }
    }

    public static void printReverseRec(int n) {
        if (n == 0) {
            return;
        } else {
            System.out.print(n + " ");
            printReverseRec(n - 1);
        }
    }

    public static int getSumIter(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }

    public static int getSumRec(int n) {
        if (n == 0) {
            return 0;
        } else {
            return n + getSumRec(n - 1);
        }
    }

    public static void printReverse(String s) {
        if (s.isEmpty()) {
            return;
        } else {
            System.out.print(s.charAt(s.length() - 1));
            printReverse(s.substring(0, s.length() - 1));
        }
    }
}
