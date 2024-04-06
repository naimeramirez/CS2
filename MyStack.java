import java.util.EmptyStackException;

public class MyStack {
    private String[] stack;
    private int top;

    public MyStack() {
        stack = new String[10];
        top = 0;
    }

    public void push(String item) {
        ensureCapacity(top + 1);
        stack[top++] = item;
    }

    public String pop() {
        if (top == 0) {
            throw new EmptyStackException();
        }
        return stack[--top];
    }

    public String peek() {
        if (top == 0) {
            throw new EmptyStackException();
        }
        return stack[top - 1];
    }

    private void ensureCapacity(int minCapacity) {
        if (minCapacity > stack.length) {
            int newSize = stack.length * 2;
            String[] newStack = new String[newSize];
            System.arraycopy(stack, 0, newStack, 0, stack.length);
            stack = newStack;
        }
    }
}
