interface Queue {
  // post: returns the number of elements of the queue
  public int size();
  
  // post: returns true iff the number of elements is 0
  public boolean isEmpty();

  // pre:  the queue is not empty
  // post: if pre returns (a reference to) the element at the front of the queue, 
  //       throws otherwise an EmptyQueueException
  public Object front() throws EmptyQueueException;

  // post: has added o to the rear of the queue
  public void enqueue (Object o);
  
  // pre:  the queue is not empty
  // post: if pre removes and returns the element at the front of the queue, throws otherwise an EmptyQueueException
  public Object dequeue() throws EmptyQueueException;
}

class ArrayQueue implements Queue {
  // -elements : Object[]
  // -front    : int
  // -size     : int
  // -capacity : int
  private Object[] elements;
  private int front;
  private int size;
  private int capacity;
  
  // post: returns the number of elements of the queue
  public int size() {
    return size;
  }
  
  // post: returns true iff the number of elements is 0
  public boolean isEmpty() {
    return size == 0;
  }

  // pre: cap >= 0
  // post: if pre has constructed an empty ArrayQueue with capacity = cap,
  //       has thrown a NegativeArraySizeException otherwise
  // +ArrayQueue(cap : int) throws NegativeArraySizeException
  public ArrayQueue(int cap) throws NegativeArraySizeException {
    if(cap >= 0) {
      capacity = cap;
      elements = new Object[cap];
      size = 0;
      front = 0;
    } else 
      throw new NegativeArraySizeException("Capacity cannot be a negative number!");
  }
  
  // pre:  the queue is not empty
  // post: if pre returns (a reference to) the element at the front of the queue, 
  //       throws otherwise an EmptyQueueException
  public Object front() throws EmptyQueueException {
    if(!isEmpty()) {
      return elements[front];
    } else 
      throw new EmptyQueueException("There is no front, bcause the queue is empty!");
    
  }
  
  
  // post: returns true iff the size is equal to the capacity
  // +isFull() : boolean
  public boolean isFull() {
    return size == capacity;
  }
  
  // pre: the queue is not full
  // post: if pre has added o to the rear of the queue, 
  //       has otherwise thrown an FullQueueException 
  // +enqueue (o : Object) throws a FullQueueException
  public void enqueue(Object o) throws FullQueueException {
    if(!isFull()) {
      elements[(front + size) % capacity] = o;
      size++;
    } else 
      throw new FullQueueException("The queue is already full!");
  }
  
  // pre:  the queue is not empty
  // post: if pre removes and returns the element at the front of the queue, throws otherwise an EmptyQueueException
  public Object dequeue() throws EmptyQueueException {
    if(!isEmpty()) {
      Object o = elements[front];
      elements[front] = null;
      front = (front + 1) % capacity;
      size--;
      return o;
    } else
      throw new EmptyQueueException("Cannot dequeue because the queue is empty!");
  }
  
  // post: returns a String representation of the ArrayQueue
  // +toString() : String
  public String toString() {
    String res = "<ArrayQueue[";
    if(!isEmpty()) {
      for(int i = 0; i<size-1; i++) {
        res += elements[(front+i)%capacity] + ",";
      }
      res += elements[(front + size - 1)%capacity];
    }
    res += "]>";
    return res;
  }
  
}//
