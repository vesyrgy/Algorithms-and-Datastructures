class TNode implements Position
{
  // -elem   : Object
  // -parent : TNode
  // -left   : TNode
  // -right  : TNode
  private Object elem;
  private TNode parent;
  private TNode left;
  private TNode right;


  // post: has created a TNode object with elem = el, parent = pt, left = lt and right = rt
  // +TNode(el : Object, pt : TNode, lt : TNode, rt : TNode)
  public TNode(Object el, TNode pt, TNode lt, TNode rt) {
    elem = el;
    parent = pt;
    left = lt;
    right = rt;
  }
  
  // post: elem = e
  // +setElem(e : Object)
  public void setElem(Object e) {
    elem = e;
  }
  
  // post: parent = pt
  // +setParent(pt : TNode)
  public void setParent(TNode pt) {
    parent = pt;
  }
  
  
  // post: if left referred another TNode, 
  //       the parent reference of that TNode has been set to null; 
  //       left = lt; if lt is non-null, the parent reference of lt has been set to this TNode
  // +setLeft(lt : TNode)
  public void setLeft(TNode lt) {
    if(left != null)
      left.setParent(null);
    if(lt != null)
      lt.setParent(this);
    left = lt;
  }
  
  // //the specification of setRight() is similar to the specification of //setLeft()
  public void setRight(TNode rt) {
    if(right != null)
      right.setParent(null);
    if(rt != null)
      rt.setParent(this);
    right = rt;
  }
  
  // post: returns elem
  // +element() : Object
  public Object element() {
    return elem;
  }
  
  // post: returns parent
  // +parent() : TNode
  public TNode parent() {
    return parent;
  }
  
  // the specification of left() and right() are similar to the specification of parent()
  public TNode right() {
    return right;
  }
  
  public TNode left() {
    return left;
  }
  
  
  // post: returns a String-representation of this TNode
  // +toString() : String
  public String toString() {
    String res = "<TNode(";
    if(elem != null)
      res += elem;
    res +=")>";
    return res;
  }
  
}

//
