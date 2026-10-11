
public class MyQueue<T> {

    private MyStack<T> stack1;
    private MyStack<T> stack2;

    // Constructor
    public MyQueue() {
        stack1 = new MyStack<>();
        stack2 = new MyStack<>();
    }

    // Add an element to the queue
    public void enqueue(T data) {
        stack1.push(data);
    }

    // Transfer elements when stack2 is empty
    private void transfer() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
    }

    // Remove and return the oldest element
    public T dequeue() {
        transfer();

        if (stack2.isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }

        return stack2.pop();
    }

    // Return the oldest element without removing it
    public T peek() {
        transfer();

        if (stack2.isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }

        return stack2.peek();
    }

    // Check whether the queue is empty
    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}
