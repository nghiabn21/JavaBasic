package learn.test;

import learn.demo.HashSetCreationExample;
import learn.demo.HashSetIterationExample;
import learn.demo.HashSetRemoveElementExample;
import learn.demo.HashSetRetrieveElementExample;

public class TestHashSetDemo {
	public static void main(String[] args) {
		HashSetCreationExample hashSetCreation = new HashSetCreationExample(); 
		
		HashSetRetrieveElementExample hashSetElements = new HashSetRetrieveElementExample(); 
		
		HashSetRemoveElementExample hashSetRemove = new HashSetRemoveElementExample(); 
		
		HashSetIterationExample hashSetIterator = new HashSetIterationExample(); 
		
		hashSetCreation.createHashSet();
		hashSetElements.retrieveElements();
		hashSetRemove.removeElements();
		hashSetIterator.hashSetIterator();
	}
}
