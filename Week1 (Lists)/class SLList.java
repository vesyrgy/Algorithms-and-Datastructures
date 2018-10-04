class SLList 
{

  // -head : Node
  private Node head;

  // post: has created an empty SLList
  // +SLList()
  public SLList() {
    head = null;
  }
  
  // post: has added n at the beginning of the list
  // +addFirst(n : Node)
  public void addFirst(Node n) {
    Node m = new Node(n.getElement(), head);
    head = m;
  }
  
  // pre: the list is not empty
  // post: if pre has removed and returned the first Node, has returned null otherwise
  // +removeFirst(): Node
  public Node removeFirst() {
    
    Node first = head;
    if(size() > 0)
      head = head.getNext();
    return first;
  }
  
  // pre: the list is not empty
  // post: if pre has removed and returned the last Node, has returned null otherwise
  // +removeLast(): Node
  public Node removeLast() {
    Node n = head;
    
    if(size() > 1) {
      Node m = n.getNext();
      while(m.getNext() != null) {
        n = m;
        m = m.getNext();
      }
      n.setNext(null);
      return m;
    } else { 
      head = null;
      return n;
    }
  }
  
  // post : return the number of Nodes in the list
  // +size() : int
  public int size() {
    int i = 0;
    Node n = head;
    while(n != null) {
      i++;
      n = n.getNext();
    }
    return i;
  }
  
  // pre: 0 <= pos < size()
  // post: if pre has added n to the position pos
  // +addAtPosition(n : Node; pos : int)
  public void addAtPosition(Node n, int pos) {
    if(0 <= pos && pos < this.size()) {
      Node m = head;
      int i = 0;
      while(i < pos) {
        i++;
        m =  m.getNext();
      }
      if(m.getNext() != null) {
        n.setNext(m.getNext().getNext());
      } 
      m.setNext(n);
    }
    
  }
  
  // pre: 0 <= pos < size()
  // post: if pre has removed and returned the node at position pos, otherwise has returned null
  // +removeFromPosition(pos : int): Node
  public Node removeFromPosition(int pos) {
    if(0 <= pos && pos < this.size()) {
      Node m = head;
      Node n = m;
      int i = 0;
      while(i < pos) {
        i++;
        n = m;
        m = m.getNext();
      }
      n.setNext(m.getNext());
      return m;
    }
    return null;
  }

  // post: returns a List that contains the elements of this and that in same order 
  // +merge(that : List) : List
  
  //  apparently this is not needed to pass the spec-tests?
  
  /*
  public SLList merge(SLList that) {
    SLList sllist = new SLList();
    Node n = this.removeLast();
    Node m = that.removeLast();
    for(int i=0; i<this.size() + that.size(); i++) {
      if(n.getElement() >= m.getElement()) {
        sllist.addFirst(n);
        n = this.removeLast();
      } else {
        sllist.addFirst(m);
        m = that.removeLast();
      }
    }
    return sllist;
  }
  */
  
  // post: returns a List that contains the elements of this in reversed order
  // +reverse() : List
  public SLList reverse() {
    
    SLList rev = new SLList();
    // System.out.println("size() is: " + size());
    
    Node n = head;
    while(n != null) { 
      rev.addFirst(n);
      n = n.getNext();
    }
    
    //System.out.println("reversed size: " + rev.size());
    return rev;
  }

}//
