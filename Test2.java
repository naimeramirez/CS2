
public class Test2 {
    public static boolean isAscending(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] > a[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public static void bubbleSort(int[] a) {
        int n = a.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
    }

    public static boolean binarySearch(int[] a, int target) {
        int left = 0;
        int right = a.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (a[mid] == target) {
                return true;
            } else if (a[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }

    public static boolean useBinary(int[] a, int t) {
        if (isAscending(a)) {
            bubbleSort(a);
        } else {
            return binarySearch(a, t);
        }
        return binarySearch(a, t);
    }

    public static void main(String[] args) {
        int[] array1 = {5, 2, 7, 9, 3};
        int target1 = 7;
        System.out.println("Target found in array1: " + useBinary(array1, target1));

        int[] array2 = {2, 3, 5, 7, 9};
        int target2 = 4;
        System.out.println("Target found in array2: " + useBinary(array2, target2));
    }
}
