public class MyQueue {
    Node front, rear;

    public MyQueue() {
        front = rear = null;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public void enqueue(String data) {
        Node newNode = new Node(data);
        if (rear == null) {
            front = rear = newNode;
            return;
        }
        rear.next = newNode;
        rear = newNode;
    }

    public String dequeue() throws QueueEmptyException {
        if (isEmpty()) {
            throw new QueueEmptyException("Queue is empty");
        }
        String data = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        return data;
    }

    public String peek() throws QueueEmptyException {
        if (isEmpty()) {
            throw new QueueEmptyException("Queue is empty");
        }
        return front.data;
    }

}
