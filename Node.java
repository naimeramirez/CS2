class Node {
//    String data;
//    Node next;
//
//    Node(String data) {
//        this.data = data;
//        this.next = null;
//    }
//}
//
//class QueueEmptyException extends Exception {
//    public QueueEmptyException(String message) {
//        super(message);
//    }


    char value;
    Node left, right;

    public Node(char item) {
        value = item;
        left = right = null;
    }

}