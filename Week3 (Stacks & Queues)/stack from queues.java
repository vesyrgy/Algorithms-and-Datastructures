import java.util.NoSuchElementException;

interface Queue<T> {

	/**
	 * @return true iff it contains no elements.
	 */
	public boolean isEmpty();

	/**
	 * @return the number of elements in the queue.
	 */
	public int size();

	/**
	 * Add an element to the end of the queue
	 *
	 * @param e
	 *            element to enqueue.
	 */
	public void enqueue(T e);

	/**
	 * Removes the first element from the queue.
	 *
	 * @return the first element.
	 * @throws NoSuchElementException
	 *             iff the queue is empty
	 */
	public T dequeue() throws NoSuchElementException;

	/**
	 * @return the first element (does not dequeue it).
	 * @throws NoSuchElementException
	 *             iff the queue is empty
	 */
	public T front() throws NoSuchElementException;

}

class Stack<T> {
	private Queue<T> q1 = new LibraryQueue<>();
	private Queue<T> q2 = new LibraryQueue<>();

	/**
	 * @return true iff there are no elements left.
	 */
	public boolean isEmpty() {
		return q1.isEmpty();
	}

	/**
	 * @return the number of elements in the stack.
	 */
	public int size() {
		return q1.size();
	}

	/**
	 * Adds an element to the stack.
	 *
	 * @param i
	 *            element to enqueue.
	 */
	public void push(T i) {
    while(q1.size() > 0) {
      q2.enqueue(q1.dequeue());
    }
    q1.enqueue(i);
    while(q2.size() > 0) {
      q1.enqueue(q2.dequeue());
    }
	}

	/**
	 * Removes the top element from the stack.
	 *
	 * @return the top element from the stack.
	 * @throws NoSuchElementException
	 *             iff the stack is empty.
	 */
	public T pop() throws NoSuchElementException {
		return q1.dequeue();
	}

	/**
	 * Only returns (i.e. does not remove) the top element from the stack.
	 *
	 * @return the top element from the stack.
	 * @throws NoSuchElementException
	 *             iff the stack is empty.
	 */
	public T top() throws NoSuchElementException {
		return q1.front();
	}
}//
