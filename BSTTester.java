public class BSTTester {
    public static void main(String[] args) {
        BST t = new BST();
        System.out.println("is Empty? " + t.isEmpty());
        t.add(21);
        t.add(11);
        t.add(68);
        t.add(7);
        t.add(13);
        t.add(42);
        t.add(88);
        t.add(55);
        t.add(70);
        System.out.println("is Empty? " + t.isEmpty());
        t.print();
        System.out.println("is 88 there? " + t.find(88));
        System.out.println("is 18 there? " + t.find(18));
        System.out.println("Total: " + t.size());
        t.remove(13);
        t.print();
        System.out.println("Total leaves: " + t.totalLeaves());
        System.out.println("Total parents: " + t.totalParents());
        System.out.println("Height: " + t.getHeight());
        t.printMin();
        t.printMax();
    }

}
