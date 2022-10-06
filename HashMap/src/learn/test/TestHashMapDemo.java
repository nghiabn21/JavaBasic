package learn.test;

import learn.hashmapdemo.HashMapAccessKeyExample;
import learn.hashmapdemo.HashMapCreationExample;
import learn.hashmapdemo.HashMapIteratorExample;
import learn.hashmapdemo.HashMapObtainKeySetExample;
import learn.hashmapdemo.HashMapRemoveKeyExample;

/**
 * @author hoabt2
 *
 */
public class TestHashMapDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		HashMapCreationExample hashMapCreation = new HashMapCreationExample(); 
		
		HashMapAccessKeyExample hashMapAccess = new HashMapAccessKeyExample(); 
		
		HashMapObtainKeySetExample hashMapKeySet = new HashMapObtainKeySetExample(); 
		
		HashMapIteratorExample hashMapIterator = new HashMapIteratorExample(); 
		 
		HashMapRemoveKeyExample hashMapRemove = new HashMapRemoveKeyExample(); 
		
		hashMapCreation.createHashMap();
		hashMapCreation.createEmployeeMap();
		hashMapAccess.accessKeys();
		hashMapKeySet.obtainEntryKeySetValues();
		hashMapIterator.iterateHashMap();
		hashMapRemove.removeKeys();
	}
}
