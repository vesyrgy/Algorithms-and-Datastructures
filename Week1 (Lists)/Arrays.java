Arrays

*********************
* 	CLONING Arraya 	*
*********************


class R31 {
  
  static float[][] clone(float[][] a) {
    
    float[][] b;
    
    // clone a to b
    if(a != null) {
      if(a.length>0){
        b = new float[a.length][a[0].length];
        
        for(int i=0; i<a.length; i++) {
            for(int j=0; j<a[i].length; j++) {
              b[i][j] = a[i][j];
            }
        }
        return b;
      }
      b = new float[0][0];
      return b;
    }
    return null;
  }
}//


*************************
* 	TESTING HIGHSCORES 	*
*************************


import org.junit.*;
import static org.junit.Assert.*;

public class UTest {
	
	@Test 
	public void addJill() {
    
    Scores s = new Scores();
    s.add(new GameEntry("Mike", 1105));
    s.add(new GameEntry("Rob",   750));
    s.add(new GameEntry("Paul",  720));
    s.add(new GameEntry("Anna",  660));
    s.add(new GameEntry("Rose",  590));
    s.add(new GameEntry("Jack",  510));
    
    assertEquals(
      "[(Mike, 1105), (Rob, 750), (Paul, 720), (Anna, 660), (Rose, 590), (Jack, 510)]", 
      s.toString()
    );
    
    s.add(new GameEntry("Jill", 740));
    assertEquals(
      "[(Mike, 1105), (Rob, 750), (Jill, 740), (Paul, 720), (Anna, 660), (Rose, 590), (Jack, 510)]", 
      s.toString()
    );
    
	}
	
	@Test 
	public void removePaul() {
    
    Scores s = new Scores();
    s.add(new GameEntry("Mike", 1105));
    s.add(new GameEntry("Rob",   750));
    s.add(new GameEntry("Jill",  740));
    s.add(new GameEntry("Paul",  720));
    s.add(new GameEntry("Anna",  660));
    s.add(new GameEntry("Rose",  590));
    s.add(new GameEntry("Jack",  510));
    
    assertEquals(
      "[(Mike, 1105), (Rob, 750), (Jill, 740), (Paul, 720), (Anna, 660), (Rose, 590), (Jack, 510)]", 
      s.toString()
    );
    
    assertEquals("(Paul, 720)", s.remove(3).toString());
    
    assertEquals(
      "[(Mike, 1105), (Rob, 750), (Jill, 740), (Anna, 660), (Rose, 590), (Jack, 510)]", 
      s.toString()
    );
	}
	
	@Test 
	public void addInInverseOrder() {
    
    Scores s = new Scores();
    
    // TODO: fill test method here
    s.add(new GameEntry("Jack",  510));
    s.add(new GameEntry("Rose",  590));
    s.add(new GameEntry("Anna",  660));
    s.add(new GameEntry("Paul",  720));  
    s.add(new GameEntry("Jill",  740));   
    s.add(new GameEntry("Rob",   750));
    s.add(new GameEntry("Mike", 1105));

    assertEquals(
      "[(Mike, 1105), (Rob, 750), (Jill, 740), (Paul, 720), (Anna, 660), (Rose, 590), (Jack, 510)]", 
      s.toString()
    );

 	}
	
	@Test 
	public void addUnordered() {
    
    Scores s = new Scores();
    // TODO: fill test method here
    
    s.add(new GameEntry("Anna",  660));    
    s.add(new GameEntry("Jack",  510));
    s.add(new GameEntry("Mike", 1105));
    s.add(new GameEntry("Rose",  590));    
    s.add(new GameEntry("Rob",   750)); 
    s.add(new GameEntry("Paul",  720));  
    s.add(new GameEntry("Jill",  740));   

    assertEquals(
      "[(Mike, 1105), (Rob, 750), (Jill, 740), (Paul, 720), (Anna, 660), (Rose, 590), (Jack, 510)]", 
      s.toString()
    );
	}
	
	
	@Test 
	public void FillCompletely() {
	 
    Scores s = new Scores();

    // TODO: fill test method here
    s.add(new GameEntry("Mike", 1105));
    s.add(new GameEntry("Rob",   750));
    s.add(new GameEntry("Paul",  720));
    s.add(new GameEntry("Jill",  740));
    s.add(new GameEntry("Anna",  660));
    s.add(new GameEntry("Rose",  590));
    s.add(new GameEntry("Jack",  510));
    s.add(new GameEntry("George",  490));
    s.add(new GameEntry("Emily",  450));
    s.add(new GameEntry("Luigi",  420));
    
    assertEquals(
      "[(Mike, 1105), (Rob, 750), (Jill, 740), (Paul, 720), (Anna, 660), (Rose, 590), (Jack, 510), (George, 490), (Emily, 450), (Luigi, 420)]", 
      s.toString()
    );
    
	}
	
	@Test 
	public void add11Entries() {
	 
    Scores s = new Scores();

    // TODO: fill test method here
    s.add(new GameEntry("Mike", 1105));
    s.add(new GameEntry("Rob",   750));
    s.add(new GameEntry("Paul",  720));
    s.add(new GameEntry("Jill",  740));
    s.add(new GameEntry("Anna",  660));
    s.add(new GameEntry("Rose",  590));
    s.add(new GameEntry("Jack",  510));
    s.add(new GameEntry("George",  490));
    s.add(new GameEntry("Emily",  450));
    s.add(new GameEntry("Luigi",  420));
    
    assertEquals(
      "[(Mike, 1105), (Rob, 750), (Jill, 740), (Paul, 720), (Anna, 660), (Rose, 590), (Jack, 510), (George, 490), (Emily, 450), (Luigi, 420)]", 
      s.toString()
    );
    
    s.add(new GameEntry("Wilma",  1200));
    
    assertEquals(
      "[(Wilma, 1200), (Mike, 1105), (Rob, 750), (Jill, 740), (Paul, 720), (Anna, 660), (Rose, 590), (Jack, 510), (George, 490), (Emily, 450)]", 
      s.toString()
    );
    
	}
	
	@Test 
	public void addSameScore() {
	 
    Scores s = new Scores();

    // TODO: fill test method here
    s.add(new GameEntry("Mike", 1105));
    s.add(new GameEntry("Rob",   750));
    s.add(new GameEntry("Paul",  720));
    s.add(new GameEntry("Anna",  660));
    s.add(new GameEntry("Rose",  590));
    s.add(new GameEntry("Jack",  510));
    s.add(new GameEntry("Jack",  510));
    
    assertEquals(
      "[(Mike, 1105), (Rob, 750), (Paul, 720), (Anna, 660), (Rose, 590), (Jack, 510), (Jack, 510)]", 
      s.toString()
    );
    
	}
	
	@Test 
	public void addWithoutEffect() {

    Scores s = new Scores();

    // TODO: fill test method here
   s.add(new GameEntry("Mike", 1105));
    s.add(new GameEntry("Rob",   750));
    s.add(new GameEntry("Paul",  720));
    s.add(new GameEntry("Jill",  740));
    s.add(new GameEntry("Anna",  660));
    s.add(new GameEntry("Rose",  590));
    s.add(new GameEntry("Jack",  510));
    s.add(new GameEntry("George",  490));
    s.add(new GameEntry("Emily",  450));
    s.add(new GameEntry("Luigi",  420));
    
    assertEquals(
      "[(Mike, 1105), (Rob, 750), (Jill, 740), (Paul, 720), (Anna, 660), (Rose, 590), (Jack, 510), (George, 490), (Emily, 450), (Luigi, 420)]", 
      s.toString()
    );
    
    s.add(new GameEntry("Wilma",  300));
    
    assertEquals(
      "[(Mike, 1105), (Rob, 750), (Jill, 740), (Paul, 720), (Anna, 660), (Rose, 590), (Jack, 510), (George, 490), (Emily, 450), (Luigi, 420)]", 
      s.toString()
    );
    
	}
	
	@Test 
	public void removeFirst() {
	 
    Scores s = new Scores();

    // TODO: fill test method here
    s.add(new GameEntry("Mike", 1105));
    s.add(new GameEntry("Rob",   750));
    s.add(new GameEntry("Paul",  720));
    s.add(new GameEntry("Anna",  660));
    s.add(new GameEntry("Rose",  590));
    s.add(new GameEntry("Jack",  510));
    
    assertEquals(
      "[(Mike, 1105), (Rob, 750), (Paul, 720), (Anna, 660), (Rose, 590), (Jack, 510)]", 
      s.toString()
    );
    
    s.remove(0);
    
    assertEquals(
      "[(Rob, 750), (Paul, 720), (Anna, 660), (Rose, 590), (Jack, 510)]", 
      s.toString()
    );
    
	}
	
	@Test 
	public void removeLast() {
	 
    Scores s = new Scores();

    // TODO: fill test method here
    s.add(new GameEntry("Mike", 1105));
    s.add(new GameEntry("Rob",   750));
    s.add(new GameEntry("Paul",  720));
    s.add(new GameEntry("Anna",  660));
    s.add(new GameEntry("Rose",  590));
    s.add(new GameEntry("Jack",  510));
    
    assertEquals(
      "[(Mike, 1105), (Rob, 750), (Paul, 720), (Anna, 660), (Rose, 590), (Jack, 510)]", 
      s.toString()
    );
    
    s.remove(5);
    
    assertEquals(
      "[(Mike, 1105), (Rob, 750), (Paul, 720), (Anna, 660), (Rose, 590)]", 
      s.toString()
    );
    
	}
	
	@Test(expected=IndexOutOfBoundsException.class)
	public void removeInvalid() {
    Scores s = new Scores();

    // TODO: fill test method here
    
    s.add(new GameEntry("Mike", 1105));
    s.add(new GameEntry("Rob",   750));
    s.add(new GameEntry("Paul",  720));
    s.add(new GameEntry("Anna",  660));
    s.add(new GameEntry("Rose",  590));
    s.add(new GameEntry("Jack",  510));
    
    assertEquals(
      "[(Mike, 1105), (Rob, 750), (Paul, 720), (Anna, 660), (Rose, 590), (Jack, 510)]", 
      s.toString()
    );
    
    s.remove(-1);
	}
	
	@Test 
	public void FillEmptyRefill() {

    Scores s = new Scores();

    // TODO: fill test method here
    s.add(new GameEntry("Mike", 1105));
    s.add(new GameEntry("Rob",   750));
    s.add(new GameEntry("Paul",  720));
    s.add(new GameEntry("Jill",  740));
    s.add(new GameEntry("Anna",  660));
    s.add(new GameEntry("Rose",  590));
    s.add(new GameEntry("Jack",  510));
    s.add(new GameEntry("George",  490));
    s.add(new GameEntry("Emily",  450));
    s.add(new GameEntry("Luigi",  420));
    
    assertEquals(
      "[(Mike, 1105), (Rob, 750), (Jill, 740), (Paul, 720), (Anna, 660), (Rose, 590), (Jack, 510), (George, 490), (Emily, 450), (Luigi, 420)]", 
      s.toString()
    );
    
    for(int i = 0; i<10;i++)
      s.remove(0);
    
    assertEquals(
      "[]", 
      s.toString()
    );
    
    s.add(new GameEntry("Mike", 1105));
    s.add(new GameEntry("Rob",   750));
    s.add(new GameEntry("Paul",  720));
    s.add(new GameEntry("Jill",  740));
    s.add(new GameEntry("Anna",  660));
    s.add(new GameEntry("Rose",  590));
    s.add(new GameEntry("Jack",  510));
    s.add(new GameEntry("George",  490));
    s.add(new GameEntry("Emily",  450));
    s.add(new GameEntry("Luigi",  420));
    
    assertEquals(
      "[(Mike, 1105), (Rob, 750), (Jill, 740), (Paul, 720), (Anna, 660), (Rose, 590), (Jack, 510), (George, 490), (Emily, 450), (Luigi, 420)]", 
      s.toString()
    );
    
    
	}
}


*****************************
* 	ADAPTING HIGH SCORES 	*
*****************************


/** Class for storing high scores in an array in non-decreasing order */
import java.util.*;

class Scores {
  
  public static final int maxEntries = 10; // number of high scores we keep 
  protected ArrayList<GameEntry> entries;
  
  /** Default constructor */
  public Scores() {
    entries = new ArrayList<GameEntry>(maxEntries);
  }
  
  /** Returns a string representation of the high scores list */
  public String toString() {
 
    String s = "[";
    
    for (int i = 0; i < entries.size(); i++) {
      if (i > 0) s += ", "; // separate entries by comma
      s += entries.get(i);
    }
    
    return s + "]";
  }
  
  /** Attempt to add a new score to the collection (if it is high enough) */
  public void add(GameEntry e) {

    int newScore = e.getScore();
    
    // is the new entry really a high score?
    if (entries.size() == maxEntries) { // the array is full
 
      if (newScore <= entries.get(entries.size()-1).getScore())
        return; // the new entry is not a high score in this case

    } // the array is not full
    
    // locate the place that the new entry belongs
    int i = entries.size();
    
    while ((i >= 1) && (newScore > entries.get(i-1).getScore()))
      i--;
    
    entries.add(i,e); // add the new score to entries
    if(entries.size() > maxEntries)
      entries.remove(entries.size()-1);  //remove the last entry if the list has gotten too big;
  }
  
  /** Remove and return the high score at index i */
  public GameEntry remove(int i) throws IndexOutOfBoundsException {
    if ((i < 0) || (i >= entries.size()))
      throw new IndexOutOfBoundsException("Invalid index: " + i);

    GameEntry entry = entries.remove(i);
    return entry;
  }
}


//
