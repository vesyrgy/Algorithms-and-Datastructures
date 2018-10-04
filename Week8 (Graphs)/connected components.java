import java.util.Collection;
import java.util.Iterator;

class Solution {

  public static int numberOfConnectedComponents(Graph g) {
    
    Collection<Vertex> unexplored = g.getAllVertices();
    int j = 0;

    while(unexplored.size() > 0) {
      Iterator<Vertex> it = unexplored.iterator();
      Vertex v = it.next();
      Iterator<Vertex> git = new GraphIterator(g,v);
      while(git.hasNext()) {
        Vertex w = git.next();
        unexplored.remove(w);
      }
      j++;
    }
    return j;
  }
}

/**
 * DO NOT MODIFY 
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

}
//
