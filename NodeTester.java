public class NodeTester {
    public static void main(String[] args) {
        Node n1 = new Node("A");
        Node n2 = new Node("B");
        Node n3 = new Node("C");
        Node n4 = new Node("D");
        Node n5 = new Node("E");

        Node dummy = n2;

        dummy.next = n1;
        dummy.next.next = n3;
        dummy.next.next.next = n5;
        dummy.next.next.next.next = n4;


        System.out.println("print():");
        print(dummy);

        System.out.println("\nprintRecursive():");
        printRecursive(dummy);

        System.out.println("\ntoString():");
        System.out.println(dummy.toString());

    }

    private static void print(Node n) {
        while (n != null) {
            System.out.print(n);
            n = n.next;
            if (n != null) {
                System.out.print(" -> ");
            }
        }
    }

    private static void printRecursive(Node n) {
        if (n != null) {
            System.out.print(n);
            if (n.next != null) {
                System.out.print(" -> ");
                printRecursive(n.next);
            }
        }
    }
}