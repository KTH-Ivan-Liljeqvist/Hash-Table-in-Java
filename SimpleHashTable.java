
import java.util.ArrayList;
import java.util.LinkedList;


/**
 * This class is a representation of a hash table.
 * A hash table is a data structure that consists of many linked lists.
 * 
 * @version 23-02-2015
 * @author Ivan Liljeqvist
 */

public class SimpleHashTable implements StringDictionary {

	/*table that will hold the linked lists.*/
	private ArrayList<LinkedList<String>> table;
	/*size of the table. the number of linked lists it will contain.*/
	private int n;
	
	/**
	 * The constructor. 
	 * Sets the size and fills the hash-table with empty linked lists.
	 * If the size is less or equals to 0 it will automatically be set to 1
	 */
	public SimpleHashTable(int size){
		
		table = new ArrayList<>();
				 
		//avoid values less than one.
		if(size<=0){
			size=1;
		}
		
		this.n=size;
		
		//populate the table with empty lists
		for(int i=0;i<n;i++){
			table.add(new LinkedList<String>());
		}
		
	}
	
	/**
	 * Adds a string to the hash table. 
	 * @returns true if the hash table didn't contain the string and was now added to the table.
	 * Returns false if the string passed to the method is null or if the hash table already contains the string and 
	 * therefore the string was not added to the table.
	 */
	public boolean add(String s) {
		
		if(s==null){
			return false;
		}
		//add + return true if no duplicate
		if(!this.contains(s)){
			//get the hash
			int hash = this.hash(s);
			table.get(hash).add(s);
			return true;
		}
		
		//return false if duplicates found
		return false;
	}

	/**
	 * Removes the element from the hash table.
	 * @return true if the hash table did contain the element and false if it didn't. 
	 * Returns false if the string passed to the method is null.
	 */
	public boolean remove(String s) {
		if(s==null){
			return false;
		}
		
		//if the list contained the element,
		//remove, return true
		if(this.contains(s)){
			//get the hash
			int hash = this.hash(s);
			table.get(hash).remove(s);
			return true;
		}
		
		//if the element not found, return false
		return false;
	}

	/**
	 * Checks if the hash table contains the string.
	 * @returns true if the hash table contains the string and false if it doesn't.
	 * Returns false if the string passed to the method is null.
	 */
	public boolean contains(String s) {
		
		if(s==null){
			return false;
		}
		
		//get the hash
		int hash = this.hash(s);
		
		//if contains - return true
		if(table.get(hash).contains(s)){
			return true;
		}
		
		//if doesnt contain - return false
		return false;
	}
	
	/**
	 * 
	 * Gets the hash of the string and compress it to the table size.
	 * Avoids negative values by using the absolute function.
	 * @return the compressed hash of the string.
	 */
	private int hash(String s){
		
		return Math.abs(s.hashCode()%table.size());
	}
	

}
