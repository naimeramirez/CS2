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
        preOrder(n1);
    }

    public static void preOrder(BNode R){
        if(R != null) {
            System.out.println(R.value);
            preOrder(R.left);
            preOrder(R.right);
        }
    }
}
