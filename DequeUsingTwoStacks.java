package DequeUsingTwoQueues;


	import java.util.Stack;

	public class DequeUsingTwoStacks<T> {
	    private Stack<T> stack1;
	    private Stack<T> stack2;

	    public DequeUsingTwoStacks() {
	        stack1 = new Stack<>();
	        stack2 = new Stack<>();
	    }

	    // Add element to the front of the deque
	    public void addFront(T element) {
	        stack1.push(element);
	    }

	    // Add element to the rear of the dequeue
	    public void addRear(T element) {
	        stack2.push(element);
	    }

	    // Remove element from the front of the dequeue
	    public T removeFront() {
	        if (stack1.isEmpty()) {
	            if (stack2.isEmpty()) {
	                throw new IllegalStateException("Deque is empty. Cannot remove element.");
	            }
	            while (!stack2.isEmpty()) {
	                stack1.push(stack2.pop());
	            }
	        }
	        return stack1.pop();
	    }

	    // Remove element from the rear of the dequeue
	    public T removeRear() {
	        if (stack2.isEmpty()) {
	            if (stack1.isEmpty()) {
	                throw new IllegalStateException("Deque is empty. Cannot remove element.");
	            }
	            while (!stack1.isEmpty()) {
	                stack2.push(stack1.pop());
	            }
	        }
	        return stack2.pop();
	    }

	    // Peek the front element of the dequeue
	    public T peekFront() {
	        if (stack1.isEmpty()) {
	            if (stack2.isEmpty()) {
	                throw new IllegalStateException("Deque is empty. Cannot peek element.");
	            }
	            while (!stack2.isEmpty()) {
	                stack1.push(stack2.pop());
	            }
	        }
	        return stack1.peek();
	    }

	    // Peek the rear element of the dequeue
	    public T peekRear() {
	        if (stack2.isEmpty()) {
	            if (stack1.isEmpty()) {
	                throw new IllegalStateException("Deque is empty. Cannot peek element.");
	            }
	            while (!stack1.isEmpty()) {
	                stack2.push(stack1.pop());
	            }
	        }
	        return stack2.peek();
	    }

	    // Check if the dequeue is empty
	    public boolean isEmpty() {
	        return stack1.isEmpty() && stack2.isEmpty();
	    }

	    // Get the size of the dequeue
	    public int size() {
	        return stack1.size() + stack2.size();
	    }

	    public static void main(String[] args) {
	        DequeUsingTwoStacks<Integer> myDeque = new DequeUsingTwoStacks<>();

	        myDeque.addFront(500);
	        myDeque.addRear(10);
	        myDeque.addFront(125);

	        System.out.println("Front element: " + myDeque.peekFront());
	        System.out.println("Rear element: " + myDeque.peekRear());

	        System.out.println("Removed front element: " + myDeque.removeFront());
	        System.out.println("Removed rear element: " + myDeque.removeRear());

	        System.out.println("Is the deque empty? " + myDeque.isEmpty());
	        System.out.println("Size of the deque: " + myDeque.size());
	    }
	}

	


