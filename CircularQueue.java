public class CircularQueue {
    private int[] queue;
    private int head;
    private int tail;
    private int size;
    private int count;

    public CircularQueue(int size) {
        this.size = size;
        this.queue = new int[size];
        this.head = 0;
        this.tail = 0;
        this.count = 0;
    }

    public boolean enqueue(int value) {
        if (count == size) {
            System.out.println("Queue is full" + value);
            return false;
        }
        queue[tail] = value;
        tail = (tail + 1) % size;
        count++;
        return true;
    }

    public Integer dequeue() {
        if (count == 0) {
            System.out.println("Queue is empty");
            return null;
        }
        int result = queue[head];
        head = (head + 1) % size;
        count--;
        return result;
    }

    public Integer peek() {
        if (count == 0) {
            System.out.println("Queue is empty");
            return null;
        }
        System.out.println("Front element: " + queue[head]);
        return queue[head];
    }

    public static void main(String[] args) {
        CircularQueue q = new CircularQueue(10);

        q.enqueue(2); // (a)
        q.enqueue(24); // (b)
        q.enqueue(18); // (c)
        q.dequeue(); // (d)
        q.enqueue(18); // (e)
        q.peek(); // (f)
        q.enqueue(7); // (g)
        q.enqueue(88); // (h)
        q.enqueue(82); // (i)
        q.enqueue(5); // (j)
        q.enqueue(1); // (k)
        q.enqueue(1); // (l)
        q.enqueue(1); // (m)
    }
}
