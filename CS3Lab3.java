public class CS3Lab3 {
    public static void main(String[] args) {
        CS3Lab3 bte = new CS3Lab3();
        try {
            Node root = bte.makeTree("(A(C(k)(2))(n(24)))");
            System.out.println("Height: " + bte.getHeight());
            System.out.println("Size: " + bte.size());
            System.out.println("Total Parents: " + bte.totalParents());
            System.out.println("Total Leaves: " + bte.totalLeaves());
            System.out.println("Is Balanced: " + bte.isBalanced());
            System.out.println("Is Full: " + bte.isFull());
            System.out.println("Inorder Traversal: " + bte.getInorder());
        } catch (InvalidSyntaxExpression e) {
            System.out.println(e.getMessage());
        }
    }

    private Node root;

    public Node makeTree(String expression) throws InvalidSyntaxExpression {
        if (!isValidExpression(expression)) {
            throw new InvalidSyntaxExpression("Invalid Expression Syntax");
        }
        return constructTree(expression);
    }

    private boolean isValidExpression(String expression) {
        int balance = 0;
        for (char ch : expression.toCharArray()) {
            if (ch == '(') balance++;
            if (ch == ')') balance--;
            if (balance < 0 || ch == ' ') return false;
        }
        return balance == 0 && expression.length() > 0;
    }

    private Node constructTree(String expression) {
        if (expression.isEmpty()) return null;

        if (expression.length() < 2 || expression.charAt(0) != '(' || expression.charAt(expression.length() - 1) != ')') {
            return new Node(expression.charAt(0));
        }

        expression = expression.substring(1, expression.length() - 1);

        if (expression.length() == 1) {
            return new Node(expression.charAt(0));
        }

        char rootValue = expression.charAt(0);
        Node root = new Node(rootValue);

        int index = findSubtreeIndex(expression);

        if (index != -1) {
            root.left = constructTree(expression.substring(1, index));
            root.right = constructTree(expression.substring(index));
        } else {
            root.left = constructTree(expression.substring(1));
        }

        return root;
    }

    private int findSubtreeIndex(String expression) {
        int balance = 0;
        for (int i = 1; i < expression.length(); i++) {
            if (expression.charAt(i) == '(') balance++;
            if (expression.charAt(i) == ')') balance--;
            if (balance == 0 && i + 1 < expression.length()) return i + 1;
        }
        return -1;
    }

    public int getHeight() {
        return getHeight(root);
    }

    private int getHeight(Node node) {
        if (node == null) return 0;
        return 1 + Math.max(getHeight(node.left), getHeight(node.right));
    }

    public int size() {
        return size(root);
    }

    private int size(Node node) {
        if (node == null) return 0;
        return 1 + size(node.left) + size(node.right);
    }

    public int totalParents() {
        return totalParents(root);
    }

    private int totalParents(Node node) {
        if (node == null || (node.left == null && node.right == null)) return 0;
        return 1 + totalParents(node.left) + totalParents(node.right);
    }

    public int totalLeaves() {
        return totalLeaves(root);
    }

    private int totalLeaves(Node node) {
        if (node == null) return 0;
        if (node.left == null && node.right == null) return 1;
        return totalLeaves(node.left) + totalLeaves(node.right);
    }

    public boolean isBalanced() {
        return isBalanced(root);
    }

    private boolean isBalanced(Node node) {
        if (node == null) return true;
        int leftHeight = getHeight(node.left);
        int rightHeight = getHeight(node.right);
        return Math.abs(leftHeight - rightHeight) <= 1 && isBalanced(node.left) && isBalanced(node.right);
    }

    public boolean isFull() {
        return isFull(root);
    }

    private boolean isFull(Node node) {
        if (node == null) return true;
        if (node.left == null && node.right == null) return true;
        if (node.left != null && node.right != null) return isFull(node.left) && isFull(node.right);
        return false;
    }

    public String getInorder() {
        StringBuilder result = new StringBuilder();
        getInorder(root, result);
        return result.toString();
    }

    private void getInorder(Node node, StringBuilder result) {
        if (node == null) return;
        getInorder(node.left, result);
        result.append(node.value).append(" ");
        getInorder(node.right, result);
    }
}