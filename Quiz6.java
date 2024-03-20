public class Quiz6 {
    public static boolean validateAndFind(int[] a, int t) {
        if (!isAscending(a)) {
            throw new IllegalStateException("Array is not in ascending order");
        }
        return sequentialSearch(a, t, 0);
    }

    private static boolean sequentialSearch(int[] a, int t, int index) {
        if (index >= a.length) {
            return false;
        }
        if (a[index] == t) {
            return true;
        }
        return sequentialSearch(a, t, index + 1);
    }

    private static boolean isAscending(int[] a) {
        for (int i = 1; i < a.length; i++) {
            if (a[i] < a[i - 1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        int target = 3;
        try {
            boolean found = validateAndFind(array, target);
            System.out.println("Target found: " + found);
        } catch (IllegalStateException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}
