package FIFOQueueUsingArray;

public class FIFOQueueUsingArray<T> {
    private T[] queue;
    private int front; // Front of the queue
    private int rear; // Rear of the queue
    private int size; // Current size of the queue
    private int capacity; // Maximum capacity of the queue

    public FIFOQueueUsingArray(int capacity) {
        this.capacity = capacity;
        queue = (T[]) new Object[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    public void enqueue(T element) {
        if (size == capacity) {
            throw new IllegalStateException("Queue is full. Cannot enqueue element.");
        }
        rear = (rear + 1) % capacity;
        queue[rear] = element;
        size++;
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty. Cannot dequeue element.");
        }
        T removedElement = queue[front];
        queue[front] = null;
        front = (front + 1) % capacity;
        size--;
        return removedElement;
    }

    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty. Cannot peek element.");
        }
        return queue[front];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        FIFOQueueUsingArray<Integer> myQueue = new FIFOQueueUsingArray<>(5);
        myQueue.enqueue(10);
        myQueue.enqueue(20);
        myQueue.enqueue(30);

        System.out.println("Front element: " + myQueue.peek());
        System.out.println("Dequeued element: " + myQueue.dequeue());
        System.out.println("Is the queue empty? " + myQueue.isEmpty());
        System.out.println("Size of the queue: " + myQueue.size());
    }
}
