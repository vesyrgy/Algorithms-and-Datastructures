import java.util.*;

class InorderIterator implements Iterator<Object>
{
  // - bt   : BinTree
  // - pos  : Position
  // - todo : ArrayStack<Position>
  private BinTree bt;
  private Position pos;
  private ArrayStack<Position> todo;
  
  // post: has created an InorderIterator that will inorder visit the Positions of b
  // +InorderIterator(b : BinTree)
  public InorderIterator(BinTree b) {
    bt = b;
    pos = b.root();
    todo = new ArrayStack<Position>;
    reset();
  }
  
  // post: returns true iff is not all Positions have been visited
  // +hasNext() : boolean
  public boolean hasNext() {
    
  }
  
  // post: returns next element in the iteration
  // +next() : Object
  public Object next() {
    
  }
  
  // +remove()
  // the remove() method is not implemented
  public void remove() {
    
  }
  
  // post: has reset the iterator
  // +reset()
  public void reset() {
    
  }
}//
