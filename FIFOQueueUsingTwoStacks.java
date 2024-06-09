package FIFOQueueUsingArray;

public class FIFOQueueUsingTwoStacks<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    private static class Node<T> {
        T data;
        Node<T> next;
        Node<T> prev;

        public Node(T data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public FIFOQueueUsingTwoStacks() {
        head = null;
        tail = null;
        size = 0;
    }

    public void enqueue(T element) {
        Node<T> newNode = new Node<>(element);
        if (isEmpty()) {
            head = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
        }
        tail = newNode;
        size++;
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty. Cannot dequeue element.");
        }
        T data = head.data;
        head = head.next;
        if (head == null) {
            tail = null;
        } else {
            head.prev = null;
        }
        size--;
        return data;
    }

    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty. Cannot peek element.");
        }
        return head.data;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        FIFOQueueUsingTwoStacks<Integer> myQueue = new FIFOQueueUsingTwoStacks<>();
        myQueue.enqueue(25);
        myQueue.enqueue(20);
        myQueue.enqueue(50);

        System.out.println("Front element: " + myQueue.peek());
        System.out.println("Dequeued element: " + myQueue.dequeue());
        System.out.println("Is the queue empty? " + myQueue.isEmpty());
        System.out.println("Size of the queue: " + myQueue.size());
    }
}
