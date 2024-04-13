public class Quiz9 {
    private String[] stackArray;
    private int top;
    private int capacity;

    public void ArrayStack(int capacity) {
        this.capacity = capacity;
        this.stackArray = new String[capacity];
        this.top = -1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == capacity - 1;
    }

    public void push(String element) {
        if (isFull()) {
            System.out.println("Stack is full");
            return;
        }
        stackArray[++top] = element;
    }

    public String pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return null;
        }
        return stackArray[top--];
    }

    public String peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return null;
        }
        return stackArray[top];
    }
}
