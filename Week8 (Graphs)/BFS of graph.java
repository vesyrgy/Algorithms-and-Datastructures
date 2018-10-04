import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

import java.util.Set;
import java.util.TreeSet;

/**
 * Implements a BFS traversal of the Graph starting at a certain vertex v. 
 * It should return nodes at most once.
 */
class GraphIterator implements Iterator<Vertex> {

  private final Set<Vertex> colored;
  private LinkedList<Vertex> level;
  private LinkedList<Vertex> nextLevel;
  private Graph gr;
  private Vertex vx;
  private Collection<Vertex> unexplored;
  private boolean nonempty;
  
	public GraphIterator(Graph g, Vertex v) {
    colored = new TreeSet<Vertex>();
    if((g!=null) && (v!=null)) {
      gr = g;
      vx = v;
      
      level = new LinkedList<Vertex>();
      nextLevel = new LinkedList<Vertex>();
      unexplored = gr.getAllVertices();
      
  		this.reset();
    }
	}

	public void reset() {
    nonempty = !unexplored.isEmpty();
    colored.add(vx);
    unexplored.remove(vx);
    level.addLast(vx);
    for(Vertex v: gr.getNeighbours(vx)) {
      if(!colored.contains(v))
        nextLevel.addLast(v);
    }
    //System.out.println("after reset: ");
    //System.out.println("level: " + level.toString());
    //System.out.println("nextLevel: " + nextLevel.toString());
	}

	@Override
	public boolean hasNext() {
	  //System.out.println("during call to hasNext(): ");
    //System.out.println("level: " + level.toString());
    //System.out.println("nextLevel: " + nextLevel.toString());
	  //System.out.println("all vertices: " + allVertices);
	  if(vx != null && nonempty) {
  	  //System.out.println("breakpoint");
  	  if(!level.isEmpty())
  	    return true;
  	  else if (!nextLevel.isEmpty())
  	    return true;
  	  else 
  	    return !unexplored.isEmpty();
	  }
	  return false;
	}

	@Override
	public Vertex next() {
	  if(hasNext()) {
	    //System.out.println("hasNext() is true");
  	  if(level.isEmpty()) {
  	    level = nextLevel;
  	    nextLevel = new LinkedList<Vertex>();
  	    if(level.isEmpty()) {
  	      //System.out.println("unexplored: " + unexplored.toString());
  	      if(!unexplored.isEmpty()) {
  	        Vertex v = unexplored.iterator().next();
  	        level.addLast(v);
  	        colored.add(v);
  	        unexplored.remove(v);
  	      }
  	    } else {
    	    for(Vertex v : level) {
    	      if(!colored.contains(v)) {
    	        colored.add(v);
    	        unexplored.remove(v);
    	        for(Vertex x: gr.getNeighbours(v)) {
    	          if(!colored.contains(x) && !level.contains(x) && !nextLevel.contains(x))
    	            nextLevel.addLast(x);
    	        }
    	      }
    	    }
  	    }
  	    
  	  }
  	  Vertex w = level.iterator().next();
  	  level.remove(w);
  	  //System.out.println("Vertex w is: " + w);
  	  //System.out.println("level is: " + level.toString());
  	  //System.out.println("nextLevel: " + nextLevel.toString());
  	  return w;
	  }
    return null;
	}
	
	@Override
	public void remove() {
	  // Can be ignored.
	}
}

/**
 *  DO NOT MODIFY
 */
interface Vertex extends Comparable<Vertex> {

	/**
	 * @return the id of the vertex
	 */
	public int getId();

}

/**
 * Interface for a generic graph. You may assume that our implementation is an
 * undirected graph.
 */
interface Graph {

	/**
	 * @param id
	 *            to look for a vertex by.
	 * @return the vertex or null if not found.
	 */
	public Vertex getVertexById(int id);

	/**
	 * Returns the neighbours in a sorted collection by id
	 *
	 * @param v
	 *            node to get the neighbours of.
	 * @return sorted collection of neighbours.
	 */
	public Collection<Vertex> getNeighbours(Vertex v);

	/**
	 * @return an unsorted collection of all vertices in the graph.
	 */
	public Collection<Vertex> getAllVertices();

}//
