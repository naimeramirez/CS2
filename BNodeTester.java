import java.util.NoSuchElementException;

public class BNodeTester {
    public static void main(String[] args) {
        //Definition/Declaration of BNode objects
        BNode n1 = new BNode(21); //root
        BNode n2 = new BNode(11);
        BNode n3 = new BNode(68);
        BNode n4 = new BNode(7);
        BNode n5 = new BNode(13);
        BNode n6 = new BNode(42);
        BNode n7 = new BNode(88);
        BNode n8 = new BNode(55);
        BNode n9 = new BNode(70);

        //Establish connectivity
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;
        n6.right = n8;
        n7.left = n9;
        printPreOrder(n1);
        printInOrder(n1);
        printPostOrder(n1);
        findMin(n1);
        findMax(n1);
        System.out.println(n1);
//        System.out.println(n3);

    }

    public static void printPreOrder(BNode R) {
        if (R != null) {
            System.out.println(R.value);
            printPreOrder(R.left);
            printPreOrder(R.right);
        }
    }

    public static void printInOrder(BNode R) {
        if (R != null) {
            printInOrder(R.left);
            System.out.println(R.value);
            printInOrder(R.right);
        }
    }

    public static void printPostOrder(BNode R) {
        if (R != null) {
            printPostOrder(R.left);
            printPostOrder(R.right);
            System.out.println(R.value);
        }
    }

    public static void findMin(BNode R) {
        if (R != null) {
            BNode current = R;
            while (current.left != null) {
                current = current.left;
            }
            System.out.println("Min: " + current.value);
        }
    }

    public static void findMax(BNode R) {
        if (R != null) {
            BNode current = R;
            while (current.right != null) {
                current = current.right;
            }
            System.out.println("Min: " + current.value);
        }
    }


}
