class Node {
    String data;
    Node next;

    public Node(String data) {
        this.data = data;
    }

    public String toString() {
        String result = "";
        Node current = this;
        while (current != null) {
            result += current.data;
            if (current.next != null) {
                result += " -> ";
            }
            current = current.next;
        }
        return result;
    }
}