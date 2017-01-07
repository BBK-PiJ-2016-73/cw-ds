/*
* LinkedList.java is an implementation of interface List pointer-based 
*
* A helper class (see Node interface and NodeImpl class)acting as a pointer in the linked list implemention 
* 
* @author BBK-PiJ-2016-73 Ime Akpan
*/

public class LinkedList implements List{
	
	//pointer to the first node in the chain
	private Node firstItem;
	
	 //variable to hold number items in the list
	private int counter;

    //variable to hold the error message
    private ErrorMessage message;  
   

	/**
	* LinkedList constructor 
	* firstItem is the first node in the list
	* Each list is just an object pointing to another list behind it
	*/
	public LinkedList(){
		//initialise 
		this.counter = 0;
		this.firstItem = null;	   
   }
	
	/*
	* Helper function 
	* Return number of items in list
	*/
	private int getCounter(){
		return counter;
	}
	
	/*
	* Helper function to check for 
	* a negative or out of bounds value
	* returns true or false
	*/	
	private boolean isIndexOutOfBounds(int itemIndex){
		int count = this.getCounter();
		if(itemIndex < 0 || itemIndex >= count){
			return true;
		}else{
			return false;	
		} 	
	}
	
	/**
	 * Returns true if the list is empty, false otherwise. 
	 * @return true or false. 
	 */
	 @Override
	public boolean isEmpty(){
		//	
		return this.firstItem == null;
	}

	/**
	 * Returns the number of items currently in the list. 
	 * calls getCounter() method
	 * @return the count of items in the list
	 */
	 @Override
	public int size(){
		return getCounter();
	}
	
	/**
	 * Returns the element at the given position. 
	 * 
	 * If the index is negative or greater or equal than the size of
	 * the list, then an appropriate error must be returned.
	 * 
	 * @param index the position in the list of the item to be retrieved
	 * @return the element or an appropriate error message, 
	 *         encapsulated in a ReturnObject
	 */
	  @Override
	public ReturnObject get(int index){
		
		  //check for empty structure in the array list
		if (this.isEmpty() == true) { 
			//return the result of the operation as failure operation 
			return new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);
		}
		  //check for a negative or out of bounds value
		if(isIndexOutOfBounds(index)){
			return  new ReturnObjectImpl(message.INDEX_OUT_OF_BOUNDS);
		}
		 //initialise		 
		 Node currentItem = null;
		 ReturnObject result = null;
		 
		//check if the first item in the chain is null
		if (this.firstItem != null) {
			//we have an item in the chain so set the last item to be the current
			currentItem = firstItem.getNext();
			
			//loop and get the next item in the chain
			for (int i = 0; i < index; i++) {
				//if the next item in the chain is the last one, break from the loop
				if (currentItem.getNext() == null)
					return null;
				//set current item node to the next node in the loop
				currentItem = currentItem.getNext();
			}
			
			//get the value of the object at the specified position 
			Object itemVal = currentItem.getData();
			
			//set the appropriate element 
			result = new ReturnObjectImpl(itemVal);
		}		  

	  return result;
	}
	
	/**
	 * Returns the elements at the given position and removes it
	 * from the list. The indeces of elements after the removed
	 * element must be updated accordignly.
	 * 
	 * If the index is negative or greater or equal than the size of
	 * the list, then an appropriate error must be returned.
	 * 
	 * @param index the position in the list of the item to be retrieved
	 * @return the element or an appropriate error message, 
	 *         encapsulated in a ReturnObject
	 */
	  @Override
	public ReturnObject remove(int index){
		ReturnObject result = null;
		
		  //check for empty structure in the array list
		if (this.isEmpty() == true) { 
			//return the result of the operation as failure operation 
			return new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);
		}
		//check for  a negative or out of bounds value
		if(isIndexOutOfBounds(index)){
			//set an appropriate error message
			return new ReturnObjectImpl(message.INDEX_OUT_OF_BOUNDS);
		}
			 //
			 Node currentItem = firstItem;
			if (firstItem != null) {
				for (int i = 0; i < index; i++) {
					if (currentItem.getNext() == null)
						return null;
	 
					currentItem = currentItem.getNext();
				}
				currentItem.setNext(currentItem.getNext().getNext());
				//get the value of the object at the specified position 
				Object itemVal = currentItem.getData();
				
				// decrement the counter value of elements
				counter--;
				//set the appropriate result of the operation
				result = new ReturnObjectImpl(itemVal);
			}
		
		return result;
	}
	
	/**
	 * Adds an element to the list, inserting it at the given
	 * position. The indeces of elements at and after that position
	 * must be updated accordignly.
	 * 
	 * If the index is negative or greater or equal than the size of
	 * the list, then an appropriate error must be returned.
	 * 
	 * If a null object is provided to insert in the list, the
	 * request must be ignored and an appropriate error must be
	 * returned.
	 * 
	 * @param index the position at which the item should be inserted in
	 *              the list
	 * @param item the value to insert into the list
	 * @return an ReturnObject, empty if the operation is successful
	 *         or containing an appropriate error message otherwise
	 */
	  @Override
	public ReturnObject add(int index, Object item){
		 //hold the result of the opperation
		ReturnObject result = null;
		
	 	//check for  a negative or out of bounds value
		 if(isIndexOutOfBounds(index)){
			//set an appropriate error message
			return new ReturnObjectImpl(message.INDEX_OUT_OF_BOUNDS);
		} 
		
		if(item == null){
			//set an appropriate error message
			return new ReturnObjectImpl(message.INVALID_ARGUMENT);
		} 
		
		Node currentItemTemp = new NodeImpl(item);
		Node currentItem = this.firstItem;

		// iterate over currentItem
		if (currentItem != null) {
			// crawl to the index or the last element in the chain
			for (int i = 0; i < index && currentItem.getNext() != null; i++) {
				currentItem = currentItem.getNext();
			}
		}
	
			// set the new node to the next node reference
			currentItemTemp.setNext(currentItem.getNext());
	 
			// set the current node pointer to the new node
			currentItem.setNext(currentItemTemp);
			
			// increment the counter in the chain
			counter++;	
			
			//get the value of the object at the specified position 
			Object itemVal = currentItem.getData();
			
			//set the appropriate result of the operation
			return new ReturnObjectImpl(itemVal);
	}
	
	/**
	 * Adds an element at the end of the list.
	 * 
	 * If a null object is provided to insert in the list, the
	 * request must be ignored and an appropriate error must be
	 * returned.
	 * 
	 * @param item the value to insert into the list
	 * @return an ReturnObject, empty if the operation is successful
	 *         or containing an appropriate error message otherwise
	 */
	 @Override
	public ReturnObject add(Object item){
		 //hold the result of the opperation
		ReturnObject result = null;
		
		if(item == null){
			//set an appropriate error message
			return  new ReturnObjectImpl(message.INVALID_ARGUMENT);
		}  
		
		// Initialize and set the node if this is the first node in the chain
		if (firstItem == null) {
			firstItem = new NodeImpl(item);
		}
 
		Node currentItemTemp = new NodeImpl(item);
		Node currentItem = firstItem;
 
		//check if node is null 
		if (currentItem != null) {
 
			// loop from the begining of the node and add item to the last node
			while (currentItem.getNext() != null) {
				currentItem = currentItem.getNext();
			}
			//set the last node pointer to this node
			currentItem.setNext(currentItemTemp);
		}
			//get the value of the object at the specified position 
			Object itemVal = currentItem.getData();
			
			// increment the counter in the chain
			counter++;		
			
			//set the appropriate result of the operation
			return new ReturnObjectImpl(itemVal);
	}
	
}

