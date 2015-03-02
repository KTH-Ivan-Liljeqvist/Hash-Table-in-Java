import static org.junit.Assert.*;

import org.junit.Test;

/**
 * This class tests the functionality of SimpleHashTable class.
 * All the public methods are tested.
 * @version 23-02-2015
 * @author IvanLiljeqvist
 *
 */

public class SimpleHashTableTest {

	@Test
	/**
	 * This method tests the add method. 
	 * Testing so the method behaves properly when duplicates are inserted.
	 * Testing so that table corrects the size if it's less or equal to 0.
	 * Testing to insert null. 
	 */
	public void addTest() {
		SimpleHashTable hashTable=new SimpleHashTable(10);
		
		//try inserting - should return true
		assertTrue(hashTable.add("tja"));
		assertTrue(hashTable.add("hej"));
		
		assertTrue(hashTable.add(""));
		//should return false when duplicates
		assertFalse(hashTable.add(""));
		assertFalse(hashTable.add(""));
		
		//see if contains registers the added elements
		assertTrue(hashTable.contains("tja"));
		assertTrue(hashTable.contains(""));
		
		//check so that it corrects the size if 0
		SimpleHashTable emptyTable=new SimpleHashTable(0);
		assertTrue(emptyTable.add("tja"));
		
		//check so that it corrects the size if <0
		SimpleHashTable negativeSize=new SimpleHashTable(-1000);
		assertTrue(negativeSize.add("tja"));
		
		assertFalse(hashTable.add(null));
	}
	
	@Test 
	/**
	 * This method tests the remove method.
	 * Testing to remove null.
	 */
	public void removeTest(){
		SimpleHashTable hashTable=new SimpleHashTable(10);
		
		//add elements
		hashTable.add("tja");
		hashTable.add("hej");
		hashTable.add("");
		
		hashTable.add("survivor");
		
		//remove elements - should return true of found
		assertTrue(hashTable.remove("tja"));
		assertTrue(hashTable.remove("hej"));
		assertTrue(hashTable.remove(""));
		//should return false if not found
		assertFalse(hashTable.remove(""));
		assertFalse(hashTable.remove("cow"));
		//check contains
		assertFalse(hashTable.contains("tja"));
		assertFalse(hashTable.contains(""));
		assertFalse(hashTable.contains("cow"));
		
		//see so that it did remove this
		assertTrue(hashTable.contains("survivor"));
		
		assertFalse(hashTable.remove(null));
	}
	
	@Test
	/**
	 * This method tests the contains method.
	 * Testing if contains null.
	 */
	public void containsTest(){
		SimpleHashTable hashTable=new SimpleHashTable(10);
		//should contain anything
		assertFalse(hashTable.contains("tja"));
		
		//add values
		hashTable.add("tja");
		hashTable.add("hej");
		hashTable.add("");
		hashTable.add("purple");
		
		
		
		//should contain
		assertTrue(hashTable.contains("tja"));
		assertTrue(hashTable.contains(""));
		assertTrue(hashTable.contains("hej"));
		
		//remove values
		hashTable.remove("tja");
		hashTable.remove("hej");
		hashTable.remove("");
		hashTable.remove("");
		
		//now they're gone
		assertFalse(hashTable.contains("tja"));
		assertFalse(hashTable.contains(""));
		
		assertFalse(hashTable.contains(null));
	}
	
	

}
