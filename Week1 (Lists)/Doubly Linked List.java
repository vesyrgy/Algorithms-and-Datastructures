interface PositionList {
  
  // post: returns number of elements of the list
  public int size(); 
  
  // post: returns true iff the list is empty
  public boolean isEmpty();
  
  // post: returns first node of the list
  public Position first();
  
  // post: returns last node of the list
  public Position last();
  
  // pre: 1. Position p is valid, 2. p is not the last element
  // post: if pre returns the successor node, otherwise it will throw 
  //       1. an InvalidPositionException or 2. a BoundaryViolationException
  public Position next(Position p);
  
  // pre: 1. Position p is valid, 2. p is not the first element
  // post: if pre returns the predecessor node, otherwise it will throw 
  //       1. an InvalidPositionException or 2. a BoundaryViolationException
  public Position prev(Position p);
  
  // post: has added o to the front of the list
  public void addFirst(Object o);
  
  // post: has added o to the rear of the list
  public void addLast(Object o);
  
  // pre: Position p is valid
  // post: if pre has added o to the list after position p, 
  //       otherwise has thrown a InvalidPositionException
  public void addAfter(Position p, Object o);
  
  // pre: Position p is valid 
  // post: if pre has added o to the list before position p, 
  //       otherwise has thrown a InvalidPositionException
  public void addBefore(Position p, Object o);
  
  // pre: Position p is valid
  // post: if pre removed the node at Position p, and returned the element of that node, 
  //       otherwise has thrown a InvalidPositionException
  public Object remove(Position p);
  
  // pre: Position p is valid
  // post: has put o at Position p, returns the old element
  public Object set(Position p, Object o);
}

class DLList implements PositionList
{
  // -header  : DNode
  // -trailer : DNode
  // -size    : int
  private DNode header;
  private DNode trailer;
  private int size;
  
  // post: has constructed an empty DLList, header refers to trailer and 
  //       trailer refers to header
  // +DDList()
  public DLList() {
    header = new DNode(null,null,null);
    trailer = new DNode(null,header,null);
    header.setNext(trailer);
    size = 0;
  }
  
  // pre: p is a valid Position
  // post: if pre returns the DNode p is referring to, 
  //       throws an InvalidPositionException otherwise
  // -checkPosition(p : Position) : DNode throws InvalidPositionException
  private DNode checkPosition(Position p) throws InvalidPositionException {
    DNode n = (DNode)p;
    if (p == null)
      throw new InvalidPositionException("Position is null.");
    if (p == header)
      throw new InvalidPositionException("Position is header.");
    if (p == trailer)
      throw new InvalidPositionException("Position is trailer.");
    if (n.next() == null || n.prev() == null)
      throw new InvalidPositionException("Position has been removed.");
    else {
      return (DNode)p;
    }
  }
  
  // pre:  the list is not empty
  // post: if pre returns first node of the list, throws otherwise an EmptyListException
  // +first() : Position
  public Position first() {
    if(!isEmpty())
      return (Position)header.next();
    throw new EmptyListException("The list is empty.");
  }
  
  // pre:  the list is not empty
  // post: if pre returns last node of the list. throws otherwise an EmptyListException
  // +last() : Position
  public Position last() {
    if(!isEmpty())
      return (Position)trailer.prev();
    throw new EmptyListException("The list is empty.");
  }
  
  // post: returns a String representation of the DDList
  // +toString() : String
  public String toString() {
    String res = "<DLList[";
    DNode n = header;
    for(int i = 0; i < size-1; i++) {
      res += n.next() + ",";
      n = n.next();
    }
    if(size != 0)
      res += n.next();
    res += "]>";
    return res;
  }
  
  ///////////////////////////////////////////////////////////////////////
  //  Implementation of the remaining methods of the Position interface  //
  ///////////////////////////////////////////////////////////////////////
  
  // post: returns number of elements of the list
  public int size(){
    return size;
  } 
  
  // post: returns true iff the list is empty
  public boolean isEmpty() {
    return size == 0;
  }

  // pre: 1. Position p is valid, 2. p is not the last element
  // post: if pre returns the successor node, otherwise it will throw 
  //       1. an InvalidPositionException or 2. a BoundaryViolationException
  public Position next(Position p) throws BoundaryViolationException {
    DNode n = checkPosition(p);
    if(n.next().equals(trailer))
      throw new BoundaryViolationException("Current position is the last position and has no successor.");
    return (Position)n.next();
  };
  
  // pre: 1. Position p is valid, 2. p is not the first element
  // post: if pre returns the predecessor node, otherwise it will throw 
  //       1. an InvalidPositionException or 2. a BoundaryViolationException
  public Position prev(Position p) throws BoundaryViolationException {
    DNode n = checkPosition(p);
    if(n.prev().equals(header))
      throw new BoundaryViolationException("Current position is the first position and has no predecessor.");
    return (Position)n.prev();
  }
  
  // post: has added o to the front of the list
  public void addFirst(Object o) {
    DNode next = (DNode)header.next();
    DNode first = new DNode(o,header,next);
    next.setPrev(first);
    header.setNext(first);
    size++;
  }
  
  // post: has added o to the rear of the list
  public void addLast(Object o) {
    DNode penultimate = (DNode)trailer.prev();
    DNode last = new DNode(o,penultimate,trailer);
    penultimate.setNext(last);
    trailer.setPrev(last);
    size++;
  }
  
  // pre: Position p is valid
  // post: if pre has added o to the list after position p, 
  //       otherwise has thrown a InvalidPositionException
  public void addAfter(Position p, Object o) {
    DNode n = checkPosition(p);
    DNode m = n.next();
    DNode newnode = new DNode(o,n,m);
    n.setNext(newnode);
    m.setPrev(newnode);
    size++;
  }
  
  // pre: Position p is valid 
  // post: if pre has added o to the list before position p, 
  //       otherwise has thrown a InvalidPositionException
  public void addBefore(Position p, Object o) {
    DNode m = checkPosition(p);
    DNode n = m.prev();
    DNode newnode = new DNode(o,n,m);
    n.setNext(newnode);
    m.setPrev(newnode);
    size++;
  }
  
  // pre: Position p is valid
  // post: if pre removed the node at Position p, and returned the element of that node, 
  //       otherwise has thrown a InvalidPositionException
  public Object remove(Position p) {
    DNode n = checkPosition(p);
    DNode prev = n.prev();
    DNode next = n.next();
    prev.setNext(next);
    next.setPrev(prev);
    n.setNext(null);
    n.setPrev(null);
    Object o = (Object)n.element();
    size--;
    return o;
  }
  
  // pre: Position p is valid
  // post: has put o at Position p, returns the old element
  public Object set(Position p, Object o) {
    DNode n = checkPosition(p);
    Object res = (Object)n.element();
    n.setElement(o);
    return res;
  }
  
}
//
