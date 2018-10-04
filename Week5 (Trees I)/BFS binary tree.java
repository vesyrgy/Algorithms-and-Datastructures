package weblab;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Iterates over a binarytree is a breadth-first manner. For instance a tree
 * with 8 as it's root and 4 and 10 as it's children should be iterated as: 8 ->
 * 4 -> 10.
 */
class BinaryTreeIterator<V> implements Iterator<V> {
  private BTree<V> bt;
  private Position<V> p;
  private Queue<Position<V>> q;
  
  
	/**
	 * Constructor (should call reset).
	 *
	 * @param tree
	 *            takes the tree
	 */
	public BinaryTreeIterator(BTree<V> tree) {
	  q = new LinkedList<Position<V>>();
	  bt = tree;
		this.reset();
	}

	/**
	 * Resets the iterators to start again.
	 */
	private void reset() {
	  p = bt.getRoot();
	  while(!q.isEmpty()) 
	    q.poll();
	  q.add(p);
	}

	@Override
	public boolean hasNext() {
	  //Queue<Position<V>> q2 = new LinkedList<Position<V>>();
	  if(!q.isEmpty()) {
	    p = q.peek();
	    try {
	      if(bt.hasLeft(p) || bt.hasRight(p) || (q.peek() != null))
	      return true;
	    } catch (InvalidPositionException e) {
	      return false;
	    }
	    
	  }
	  return false;
	}

	@Override
	public V next() {
	  V v = null;
	  if(!q.isEmpty()) {
	    p = q.poll();
	    v = p.getValue();
	    try {
	      if(bt.hasLeft(p)) {
	        Position<V> l = bt.getLeft(p);
	        q.add(l);
	      }
	      if(bt.hasRight(p)) {
	        Position<V> r = bt.getRight(p);
	        q.add(r);
	      }
	    } catch (InvalidPositionException e) {
	      return null;
	    }	
	  }

		return v;
	}
	
	@Override
	public void remove() {
    // can be left empty
	}


}

/** DO NOT MODIFY */
interface Position<V> {

	/**
	 * @return the key of this position.
	 */
	public int getKey();

	/**
	 * @return the value of the position.
	 */
	public V getValue();
}

interface BTree<V> {

	/**
	 * @return the root of the tree
	 */
	public Position<V> getRoot();

	/**
	 * Get the left child of a position.
	 *
	 * @param v
	 *            the position to get the child of.
	 * @return the child of the position iff hasLeft(v) is true.
	 * @throws InvalidPositionException
	 *             else
	 */
	public Position<V> getLeft(Position<V> v) throws InvalidPositionException;

	/**
	 * Get the right child of a position.
	 *
	 * @param v
	 *            the position to get the child of.
	 * @return the child of the position iff hasRight(v) is true.
	 * @throws InvalidPositionException
	 *             else
	 */
	public Position<V> getRight(Position<V> v) throws InvalidPositionException;

	/**
	 * Check if a position has a left child.
	 *
	 * @param v
	 *            position to check.
	 * @return true iff v has a left child.
	 * @throws InvalidPositionException
	 *             if v is not valid (e.g. null)
	 */
	public boolean hasLeft(Position<V> v) throws InvalidPositionException;

	/**
	 * Check if a position has a right child.
	 *
	 * @param v
	 *            position to check.
	 * @return true iff v has a right child.
	 * @throws InvalidPositionException
	 *             if v is not valid (e.g. null)
	 */
	public boolean hasRight(Position<V> v) throws InvalidPositionException;

	/**
	 * Adds a new entry to the tree.
	 *
	 * @param key
	 *            to use.
	 * @param value
	 *            to add.
	 */
	public void add(int key, V value);
}
//
