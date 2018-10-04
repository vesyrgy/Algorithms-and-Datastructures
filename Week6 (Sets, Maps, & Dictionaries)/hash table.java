import java.util.LinkedList;

class Entry {

	public String key;
	public Integer value;

	public Entry(String s, Integer v)
	{
		key = s;
		value = v;
	}

	public boolean equals(String s) {
		return key.equals(s);
	}

	@Override
	public boolean equals(Object s) {
		if (s instanceof Entry) {
			Entry that = (Entry) s;
			return key.equals(that.key);
		}
		return key.equals(s);
	}

	public int getValue() {
		return value;
	}
}

abstract class Hashtable {

  // Entry objects are used to represent "Key-Value" pairs.
  // An entry can be created by using new Entry(String key, Integer Value)
  // The .equals() method of Entry will compare the keys only.
	private LinkedList<Entry>[] myTable;

	/**
	 * Constructs a new hashTable.
	 *
	 * @param size
	 *            to be used as size of the table.
	 */
	@SuppressWarnings("unchecked")
	public Hashtable(int size) {
	  myTable = (LinkedList<Entry>[]) new LinkedList<?>[size];
	  for(int i = 0; i<myTable.length; i++) {
	    myTable[i] = new LinkedList<Entry>();  //initialize the buckets
	  }
	}

	// Required by the LibraryTable to print statistics
	protected LinkedList<Entry>[] getTable() {
		return myTable;
	}

	/**
	 * Add a key value pair to the hashTable.
	 *
	 * @param key
	 *            to identify the value.
	 * @param value
	 *            that is identified by the key.
	 */
	public void put(String key, Integer value) {
	  LinkedList<Entry> bucket;
	  Entry e = new Entry(key,value);
	  bucket = myTable[hash(key)];
	  bucket.addFirst(e);

	}

	/**
	 * @param key
	 *            to look for in the table.
	 * @return true iff the key is in the table.
	 */
	public boolean containsKey(String key) {
	  LinkedList<Entry> bucket = myTable[hash(key)];
    return bucket.size() != 0;
	}

	/**
	 * Get a value from the hashtable.
	 *
	 * @param key
	 *            that identifies the value.
	 * @return the value associated with the key or 0 if the key is not in the
	 *         table.
	 */
	public int get(String key) {
		if(this.containsKey(key)) {
		  LinkedList<Entry> bucket = myTable[hash(key)];
		  Entry e = bucket.removeLast();
		  return e.getValue();
		}
		return 0;
	}

	/**
	 * @return the size of the table.
	 */
	public int getSize() {
		return myTable.length;
	}

	/**
	 * Hashes a string/key.
	 *
	 * @param item
	 *            to hash.
	 * @return the hashcode of the string.
	 */
	public abstract int hash(String item);
	
		
	public void printStatistics() {
		int elementCount = 0;
		int maxLen = 0;
		int sum = 0;
		int sqSum = 0;
		double avg;
		for (int k = 0; k < getTable().length; k++) {
			int len = getTable()[k].size();
			maxLen = (len > maxLen) ? len : maxLen;
			elementCount += len;
			// 1 + 2 + 3 + ... + len = len(len+1)/2
			sum += (len * (len + 1)) / 2;
			// 1^2 + 2^2 + 3^2 + ... + len^2 = len(len+1)(2 len+1)/6
			sqSum += (len * (len + 1) * (2 * len + 1)) / 6;
		}
		avg = ((float) sum) / elementCount;

		System.out.println("Number of elements  = " + elementCount);
		System.out.println("Maximum list length = " + maxLen);
		System.out.println("Optimal list length = "
				+ (elementCount + getTable().length - 1) / getTable().length);
		System.out.println("Average # compares  = " + avg);
		System.out.println("Standard deviation  = "
				+ Math.sqrt(((double) sqSum) / elementCount - avg * avg));
	}
}

class ETHHash extends Hashtable {

	public ETHHash(int size) {
		super(size);
	}

	@Override
	public int hash(String item) {
	  
	  if(item != null) {
	    int hash = 1;
  	  char[] chars = item.toCharArray();
  	  for(int i=0; i<chars.length; i++) {
  	    int c_i = Math.abs(String.valueOf(chars[i]).hashCode());
  	    hash = c_i*((hash%257)+1);
  	  }
  	  hash = hash%this.getSize();
  	  return hash;
	  }
		return 0;
	}

}

class GNUCPPHash extends Hashtable {

	public GNUCPPHash(int size) {
		super(size);
	}

	@Override
	public int hash(String item) {
    
    if(item != null) {
      int b = 0;
      char[] chars = item.toCharArray();
  	  for(int i=0; i<chars.length; i++) {
  	    int c_i = Math.abs(String.valueOf(chars[i]).hashCode());
  	    b = 4*b + c_i;
  	  }
  	  String bits = Integer.toBinaryString(b);
  	  if(bits.length() > 31)
  	    bits = bits.substring(bits.length()-31);
  	  int bs = Integer.parseInt(bits.trim(),2);
  	  int hash = (int)bs%this.getSize();
  	  return hash;
    }
		return 0;
	}

}

class GNUCC1Hash extends Hashtable {

	public GNUCC1Hash(int size) {
		super(size);
	}

	@Override
	public int hash(String item) {
		
		if(item != null) {
		  
  		char[] chars = item.toCharArray();
  	  int hash = chars.length;
  	  for(int i=0; i<chars.length; i++) {
  	    //int c_i = Math.abs(chars[i].hashCode();
  	    int c_i = Math.abs(String.valueOf(chars[i]).hashCode());
  	    hash = 613*hash + c_i;
  	  }
  	  String bits = Integer.toBinaryString(hash);
  	  if(bits.length() > 30)
  	    bits = bits.substring(bits.length()-30);
  	  hash = Integer.parseInt(bits.trim(),2);
  	  hash = hash%this.getSize();
  	  return hash;
		}
	  return 0;
	}

}

class HashCodeHash extends Hashtable {

	public HashCodeHash(int size) {
		super(size);
	}

	@Override
	public int hash(String item) {
	  if (item != null) {
  		int hash = Math.abs(item.hashCode());
  		hash = hash%this.getSize();
  		return hash;
	  }
	  return 0;
	}

}//
