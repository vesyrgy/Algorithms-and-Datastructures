/**
 * Interface that represents a node in the list.
 *
 * @param <T>
 *            Type of element to hold
 */
interface Position<T> {
	T getElement();
}

/**
 * Interface for a node based list.
 *
 * @param <T>
 *            Type of elements the list can hold
 */
interface PositionList<T> {

	/**
	 * @return the number of nodes/elements in the list.
	 */
	public int size();

	/**
	 * @return true iff the list is empty.
	 */
	public boolean isEmpty();

	/**
	 * @return the first node in the list or null if no such node exists.
	 */
	public Position<T> getFirst();

	/**
	 * @return the last node in the list or null if no such node exists.
	 */
	public Position<T> getLast();

	/**
	 * Finds the next element in the list given a position.
	 *
	 * @param p
	 *            position to find the next element of.
	 * @return the next element of p.
	 * @throws InvalidPositionException
	 *             iff p is invalid.
	 */
	public Position<T> getNext(Position<T> p) throws InvalidPositionException;

	/**
	 * Finds the previous element in the list given a position.
	 *
	 * @param p
	 *            position to find the previous element of.
	 * @return the previous element of p.
	 * @throws InvalidPositionException
	 *             iff p is invalid.
	 */
	public Position<T> getPrev(Position<T> p) throws InvalidPositionException;

	/**
	 * Adds an element to the front of the list.
	 *
	 * @param o
	 *            element to add.
	 */
	public void addFirst(T o);

	/**
	 * Adds an element to th end of the list.
	 *
	 * @param o
	 *            element to add.
	 */
	public void addLast(T o);

	/**
	 * Adds an element after a specified position.
	 *
	 * @param p
	 *            position to place element after.
	 * @param o
	 *            element to insert.
	 * @throws InvalidPositionException
	 *             iff p is invalid.
	 */
	public void addAfter(Position<T> p, T o) throws InvalidPositionException;

	/**
	 * Adds an element before a specified position.
	 *
	 * @param p
	 *            position that the element should be placed in front of.
	 * @param o
	 *            element to insert.
	 * @throws InvalidPositionException
	 *             iff p is invalid.
	 */
	public void addBefore(Position<T> p, T o) throws InvalidPositionException;

	/**
	 * Removes a position from the list.
	 *
	 * @param p
	 *            position to remove.
	 * @return the element of p.
	 * @throws InvalidPositionException
	 *             if p is invalid
	 */
	public T remove(Position<T> p) throws InvalidPositionException;

	/**
	 * Changes the value of the given position to the given element.
	 *
	 * @param p
	 *            position to change the value of.
	 * @param o
	 *            the new element for p.
	 * @return the old element of p.
	 * @throws InvalidPositionException
	 *             iff p is invalid.
	 */
	public T set(Position<T> p, T o) throws InvalidPositionException;
}

/**
 * Interface for the double ended queue.
 */
interface Deque<T> {

	/**
	 * @return the number of elements in the deque.
	 */
	public int size();

	/**
	 * @return true iff the deque contains no elements.
	 */
	public boolean isEmpty();

	/**
	 * @return the element at the front of the dequeue
	 * @throws EmptyDequeException
	 *             iff the queue is empty
	 */
	public T getFirst() throws EmptyDequeException;

	/**
	 * @return the element at the end of the dequeue
	 * @throws EmptyDequeException
	 *             iff the queue is empty
	 */
	public T getLast() throws EmptyDequeException;

	/**
	 * Adds an element to the front of the deque.
	 *
	 * @param element
	 *            to add.
	 */
	public void addFirst(T element);

	/**
	 * Adds an element to the back of the deque.
	 *
	 * @param element
	 *            to add.
	 */
	public void addLast(T element);

	/**
	 * Removes and return the element at the front of the dequeue.
	 *
	 * @return the element at the front of the dequeue
	 * @throws EmptyDequeException
	 *             iff the queue is empty
	 */
	public T removeFirst() throws EmptyDequeException;

	/**
	 * Removes and return the element at the end of the dequeue.
	 *
	 * @return the element at the end of the dequeue
	 * @throws EmptyDequeException
	 *             iff the queue is empty
	 */
	public T removeLast() throws EmptyDequeException;
}

class DoubleEndedQueue<T> implements Deque<T> {

	PositionList<T> list;

	public DoubleEndedQueue() {
		this.list = new CLList<>();
	}

	@Override
	public int size() {
		return list.size();
	}

	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

	@Override
	public T getFirst() throws EmptyDequeException {
	  Position<T> p = list.getFirst();
		if(p != null)
		  return p.getElement();
		else
		  throw new EmptyDequeException("Cannot get the first element because the deque is empty!");
	}

	@Override
	public T getLast() throws EmptyDequeException {
		Position<T> p = list.getLast();
		if(p != null)
		  return p.getElement();
		else 
		  throw new EmptyDequeException("Cannot get the last element because the deque is empty!");
	}

	@Override
	public void addFirst(T element) {
		list.addFirst(element);
	}

	@Override
	public void addLast(T element) {
    list.addLast(element);
	}

	@Override
	public T removeFirst() throws EmptyDequeException {
		Position<T> p = list.getFirst();
		if(p != null)
		  return list.remove(list.getFirst());
		else
		  throw new EmptyDequeException("list.getFirst() did not return a valid position");
	}

	@Override
	public T removeLast() throws EmptyDequeException {
    try {
		  return list.remove(list.getLast());
    } catch (InvalidPositionException e) { 
		  throw new EmptyDequeException("list.getLast() did not return a valid position");
    }
	}

}//
