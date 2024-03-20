public class Quiz4 {
    public static void main(String[] args) {
        int[] a = {2, 24, 224, 2, 718, 6, 4};
        int max = findMax(a, 0);
        System.out.println("Max: " + max);
    }

    public static int findMax(int[] a, int current) {
        if (current == a.length - 1) {
            return a[current];
        } else {
            int nextMax = findMax(a, current + 1);
            if (a[current] > nextMax) {
                return a[current];
            } else {
                return nextMax;
            }
        }
    }
}
