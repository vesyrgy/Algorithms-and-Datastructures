import java.util.Collection;
import java.util.List;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Map;
import java.util.TreeMap;
import java.util.LinkedList;

class Solution {

  /**
   * Find the shortest path between v and u in the graph g.
   *
   * @param g
   *            graph to search in.
   * @param v
   *            node to start from.
   * @param u
   *            node to reach.
   * @return the nodes that form the shortest path, including v and u. An
   *         empty list iff there is no path between v and u.
   */
  public static List<Vertex> shortestPath(Graph g, Vertex v, Vertex u) {
    Map<Vertex, Vertex> predecessors = new TreeMap<>();
    HashMap<Vertex,Integer> distance = new HashMap<Vertex,Integer>(g.getAllVertices().size());
    PriorityQueue<Entry> q = new PriorityQueue<Entry>();
    
    // Note: You can use the GraphIterator(Graph, Vertex) constructor to get
    // a BFS iterator as you built for the previous assignment.
    GraphIterator gi = new GraphIterator(g,v);
    
    //  Initializing the distances and adding all vertices using the distances as keys, 
    //  as per Dijkstra's algorithm  
    while(gi.hasNext()) {
      Vertex w = gi.next();
      if(w == v)
        distance.put(w,0);
      else
        distance.put(w,Integer.MAX_VALUE);
      Entry e = new Entry(distance.get(w),w);

      q.add(e);
    }
    
    
    while(!q.isEmpty()) {
      //  pull a new vertex into the cloud, as per Dijkstra's algorithm
      //Entry<Integer,Vertex> e = q.poll();
      Entry e = q.poll();
      
      Vertex x = e.getValue();
      int d_x = distance.get(x);
      for(Vertex w: g.getNeighbours(x)) {
        //  Perform relaxation procedure, as per Dijkstra's algorithm.
        //  Since the weight w(u,v) of each edge is the same, this is expressed as 1
        int d_w = distance.get(w);
        if((d_x + 1) < d_w) {
          d_w = d_x + 1;
          distance.put(w,d_w);
          q.remove(e);
          e = new Entry(d_w,w);
          q.add(e);
          
          if(((x == v) || predecessors.containsKey(x)) && (w != v))
            predecessors.put(w,x);
          
        }
      }
    }
    
    //  construct the path from the vertices with the shortest distances from v
    LinkedList<Vertex> path = new LinkedList<Vertex>();
    Vertex z = u;
    path.addFirst(z);
    while((z != v) && (z != null)) {
      Vertex y = predecessors.get(z);
      if(y == null) break;

      path.addFirst(y);
      z = y;
    }
    
    if((path.size() == 1) && (u != v)) path.pollFirst();
    
    //System.out.println("path is: " + path.toString());
    
    return path;
    
  }
  
  
}


class Entry implements Comparable<Entry> {
  private int distance;
  private Vertex vertex;
  
  public Entry(int d, Vertex v) {
    distance = d;
    vertex = v;
  }
  
  public int getKey() {
    return distance;
  }
  
  public Vertex getValue() {
    return vertex;
  }
  
  @Override
  public int compareTo(Entry e) {
    if(this.getKey() > e.getKey())
      return 1;
    else if (this.getKey() == e.getKey())
      return 0;
    else
      return -1;
  }
  
  public String toString() {
    return "<" + distance + "," + "<" + vertex.getId() + ">>";
    
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

}//
