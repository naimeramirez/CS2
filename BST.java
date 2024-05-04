public class BST {
    BNode root;

    public BST() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public boolean add(int x) {
        root = add(x, root);
        return true;
    }

    private BNode add(int x, BNode r) {
        if (r == null) {
            BNode n = new BNode(x);
            return n;
        } else if (x < r.value) {
            r.left = add(x, r.left);
        } else if (x > r.value) {
            r.right = add(x, r.right);
        }
        return r;
    }

    public void print() {
        inOrder(root);
    }

    private void inOrder(BNode R){
        if(R != null) {
            inOrder(R.left);
            System.out.println(R.value);
            inOrder(R.right);
        }
    }

    public boolean find(int x) {
        return find(x, root);
    }

    private boolean find(int x, BNode r) {
        if(r == null) {
            return false;
        } else if (x == r.value) {
            return true;
        } else if (x < r.value) {
            return find(x, r.left);
        } else {
            return find(x, r.right);
        }
    }

    public int size() {
        return size(root);
    }

    private int size(BNode r) {
        //return r == null ? 0 : 1 + size(r.left) + size(r.right);
        if (r == null) {
            return 0;
        } else {
            return 1 + size(r.left) + size(r.right);
        }
    }

}
