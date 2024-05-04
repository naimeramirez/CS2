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

    private void inOrder(BNode R) {
        if (R != null) {
            inOrder(R.left);
            System.out.println(R.value);
            inOrder(R.right);
        }
    }

    public boolean find(int x) {
        return find(x, root);
    }

    private boolean find(int x, BNode r) {
        if (r == null) {
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

    public void remove(int x) {
        root = remove(root, x);
    }

    private BNode remove(BNode r, int x) {
        if (r == null) {
            return null;
        }

        if (x < r.value) {
            r.left = remove(r.left, x);
        } else if (x > r.value) {
            r.right = remove(r.right, x);
        } else {
            if (r.left != null && r.right != null) {
                r.value = findMin(r.right).value;
                r.right = remove(r.right, r.value);
            } else if (r.left != null) {
                r = r.left;
            } else if (r.right != null) {
                r = r.right;
            } else {
                r = null;
            }
        }
        return r;
    }

    public void printMin() {
        BNode r = findMin(root);
        if (r != null) {
            System.out.println("Min: " + r.value);
        }
    }

    private BNode findMin(BNode r) {
        if (r != null) {
            while (r.left != null) {
                r = r.left;
            }
        }
        return r;
    }

    public void printMax() {
        BNode r = findMax(root);
        if (r != null) {
            System.out.println("Max: " + r.value);
        }
    }

    private BNode findMax(BNode r) {
        if (r != null) {
            while (r.right != null) {
                r = r.right;
            }
        }
        return r;
    }

    public int totalLeaves() {
        return totalLeaves(root);
    }

    private int totalLeaves(BNode r) {
        if (r == null) {
            return 0;
        } else if (r.left == null && r.right == null) {
            return 1;
        } else {
            return totalLeaves(r.left) + totalLeaves(r.right);
        }
    }

    public int totalParents() {
        return totalParents(root);
    }

    private int totalParents(BNode r) {
        if (r == null || (r.left == null && r.right == null)) {
            return 0;
        } else {
            return 1 + totalParents(r.left) + totalParents(r.right);
        }
    }

    public int getHeight() {
        return getHeight(root);
    }

    private int getHeight(BNode r) {
        if (r == null) {
            return -1;
        } else {
            return 1 + Math.max(getHeight(r.left), getHeight(r.right));
        }
    }

}
