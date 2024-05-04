public class BNode {

    int value;
    BNode left;
    BNode right;

    public BNode(int value){
        this(value, null, null);
    }

    public BNode(int value, BNode left, BNode right){
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public String toString() {
        String result = "";
        if (left != null) {
            result += left.toString() + " ";
        }
        result += value;
        if (right != null) {
            result += " " + right.toString();
        }
        return result;
    }

}
