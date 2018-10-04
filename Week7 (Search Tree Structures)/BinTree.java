import java.util.ArrayList;
import java.util.Iterator;

class BinTree
{
  // -root : TNode
  // -size : int
  private TNode root;
  private int size;
  
  // post: has created an empty BinTree (that doesn’t contain any TNodes)
  // +BinTree()
  public BinTree() {
    size = 0;
  }
  
  // post: returns true iff BinTree is empty
  // +isEmpty() : boolean
  public boolean isEmpty() {
    return size == 0;
  }
  
  // post: returns the number of TNodes in the BinTree
  // +size() : int
  public int size() {
    return size;
  }
  
  // pre: isEmpty()
  // post: if pre root refers to a TNode containing object o, and only empty references; 
  //       otherwise NonEmptyTreeException has been thrown
  // +addRoot(o : Object)
  public void addRoot(Object o) throws NonEmptyTreeException {
    if(isEmpty()) {
      root = new TNode(o,null,null,null);
      size++;
    } else 
      throw new NonEmptyTreeException("Root cannot be added because the tree is not empty.");
  }
  
  
  // pre: !isEmpty()
  // post: if pre, returns a copy of the root reference, 
  //       otherwise an EmptyTreeException has been thrown
  // +root() : Position
  public Position root() throws EmptyTreeException {
    if(!isEmpty()) {
      return root;
    } else
      throw new EmptyTreeException("This tree has no root, because it is empty.");
    
  }
  
  
  // post: returns true iff p is equal to root
  // +isRoot(p : Position) : boolean
  public boolean isRoot(Position p) {
    TNode t = (TNode)p;
    return t == root;
  }

  public String toString()
  {
    if (isEmpty())
      throw new EmptyTreeException("toString()");
    else
      return toString(root, 0);
  }
  
  public String toString(Position p, int indents)
  {
    String tab = "   ";
    String tabs = "";
    for(int i = 0; i < indents; i++)
      tabs = tabs + tab;
  
    TNode t = (TNode) p;
    String res = "";
    res = tabs + "<BinTree(" + t;
    if (t.left() != null)
      res = res + "\n" + toString(t.left(), indents + 1);
    else
      res = res + "\n" + tabs + tab + "()";
    if (t.right() != null)
      res = res + "\n" + toString(t.right(), indents + 1);
    else
      res = res + "\n" + tabs + tab + "()";
    res = res + "\n" + tabs + ")>";
    return res;
  }
  
  // post: returns true iff p has a left child
  // +hasLeft(p :  Position) : boolean
  public boolean hasLeft(Position p) {
    TNode t = (TNode)p;
    if(t != null)
      return t.left() != null;
    return false;
  }
  
  //similar specification for hasRight()
  public boolean hasRight(Position p) {
    TNode t = (TNode)p;
    if(t != null)
      return t.right() != null;
    return false;
  } 
  
  // pre: p doesn’t have a left child
  // post: if pre, left refers to a TNode with object o and parent p, 
  //       and the other references set to null, 
  //       otherwise has thrown an InvalidPositionException
  // +insertLeft(p : Position, o : Object)
  public void insertLeft(Position p, Object o) throws InvalidPositionException {
    if(!hasLeft(p)) {
      TNode t = (TNode)p;
      TNode child = new TNode(o,t,null,null);
      t.setLeft(child);
      size++;
    } else
      throw new InvalidPositionException("Cannot insert left child because the node already has one.");
  }
  
  
  // similar specification for insertRight()
  public void insertRight(Position p, Object o) throws InvalidPositionException {
    if(!hasRight(p)) {
      TNode t = (TNode)p;
      TNode child = new TNode(o,t,null,null);
      t.setRight(child);
      size++;
    } else
      throw new InvalidPositionException("Cannot insert right child because the node already has one.");
    
  }
  
  // pre: p has a left child
  // post: if pre, returns a reference to the left child, 
  //       otherwise has thrown a BoundaryViolationException
  // +leftChild(p : Position) : Position
  public Position leftChild(Position p) throws BoundaryViolationException{
    if(hasLeft(p)) {
      TNode t = (TNode)p;
      return t.left();
    } else
      throw new BoundaryViolationException("The position has no left child.");
  }
  
  
  // similar specification for rightChild()
  public Position rightChild(Position p) {
    if(hasRight(p)) {
      TNode t = (TNode)p;
      return t.right();
    } else
      throw new BoundaryViolationException("The position has no right child.");
  }
  
  
  // post: returns true iff p is a left child
  // +isLeft(p : Position) : boolean
  public boolean isLeft(Position p) {
    TNode t = (TNode)p;
    if(t != null) {
      TNode parent = t.parent();
      if(parent != null)
        return parent.left() == t;
    }
    return false;
  }
  
  // similar specification for isRight()
  public boolean isRight(Position p) {
    TNode t = (TNode)p;
    if (t != null) {
      TNode parent = t.parent();
      if(parent != null)
        return parent.right() == t;
    }
    return false;
  }
  
  // post: returns true iff p has a parent
  // +hasParent(p : Position) : boolean
  public boolean hasParent(Position p) {
    TNode t = (TNode)p;
    if(t != null) {
      TNode parent = t.parent();
      return parent != null;
    }
    return false;
  }
  
  // pre: hasParent(p)
  // post: if pre, returns a reference to the parent of p, 
  //       otherwise has thrown a BoundaryViolationException
  // +parent(p : Position) : Position
  public Position parent(Position p) throws BoundaryViolationException {
    if(hasParent(p)) {
      TNode t = (TNode)p;
      return t.parent();
    } else
      throw new BoundaryViolationException("The position has no parent.");
  }
  
  // post: returns true iff p has 1 or 2 two children
  // +isInternal(p : Position) : boolean
  public boolean isInternal(Position p) {
    if(p != null)
      return hasLeft(p) || hasRight(p);
    return false;
  }
  
  // post: returns true iff p doesn’t have children
  // +isExternal(p : Position) : boolean
  public boolean isExternal(Position p) {
    return !isInternal(p);
  }
  
  // post: has stored e at Position p; 
  //       returns the element that was previously stored at that Position 
  // +replaceElement(p : Position, e : Object) : Object
  public Object replaceElement(Position p, Object e) {
    TNode t = (TNode)p;
    Object el = t.element();
    t.setElem(e);
    if(e == null)
      size--;
    return el;
  }
  
  // post: has swapped the element that was stored at Position p 
  //       with the element that was stored at Position q
  // +swapElements(p : Position, q : Position)
  public void swapElements(Position p, Position q) {
    TNode tp = (TNode)p;
    TNode tq = (TNode)q;
    if((tp!=null) && (tq!=null)) {
      Object temp = tp.element();
      tp.setElem(tq.element());
      tq.setElem(temp);
    }
  }
  
  // post: returns the number of branches between p and the root
  // +depth(p : Position) : int
  public int depth(Position p) {
    TNode t = (TNode)p;
    int depth = 0;
    if(t != null) {
      while(!isRoot(t)) {
        t = t.parent();
        depth++;
      } 
    }
    return depth;
  }
  
  // post: returns the number of nodes in the subtree that has p as root
  // +size(p : Position) : int
  public int size(Position p) {
    TNode t = (TNode)p;
    if(t == null || t.element() == null)
      return 0;
    int s = 1;
    if(hasLeft(p))
      s += size(leftChild(p));
    if(hasRight(p))
      s += size(rightChild(p));
    return s;
  }
  
  // post: returns an Iterator for the Positions of the binary tree, 
  //       the tree is visited in the inorder sequence
  // +positions() : Iterator
  public Iterator<Object> positions() {
    ArrayList<Object> positions = new ArrayList<Object>();
    Position p = (Position)root;
    if(p != null)
      inorderPositions(p,positions);
    return positions.iterator();
  }
  
  // post: returns an Iterator for the elements of the binary tree, 
  //       the tree is visited in the inorder sequence
  // +elements() : Iterator
  public Iterator<Object> elements() {
    ArrayList<Object> elements = new ArrayList<Object>();
    Iterator<Object> positions  = positions();
    while (positions.hasNext()) {
      Object p = positions.next();
      TNode t = (TNode)p;
      elements.add(t.element());
    }
    
    return elements.iterator();
  }
  
  // post: aList contains the Positions of the binary tree in the inorder  sequence
  // -inorderPositions(p : Position, aList : ArrayList<Object>)
  protected void inorderPositions(Position p, ArrayList<Object> aList) {
    if(hasLeft(p))
      inorderPositions(leftChild(p),aList);
    aList.add(p);
    if(hasRight(p))
      inorderPositions(rightChild(p),aList);
  }
  
}//
