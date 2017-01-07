/*
* ArrayList.java is an implementation of interface List( see List.java)
* This is implemented using array.
* 
* @author BBK-PiJ-2016-73 Ime Akpan
*/

public class ArrayList implements List{
   
    //variable to hold number items in the list
    private int counter;

    // declares an array of any type
    private Object[] listItems;
   
    //declares a variable to hold the error message
    private ErrorMessage message;
   
   //initialise the current size of the array list
    private int sizeOfArray = 10;
   
    //declares a variable to hold the return object type(success or error)
    private ReturnObject returnObjectType;
   
     /**
	 *
     * ArrayList contructor.  
     * 
     */
   public ArrayList(){
    
		//initialise count of items in the list
		counter = 0 ;
   
		//initialise a new List based on arrarys and set the default size
		listItems = new Object[sizeOfArray];  
   }
   
 /**
  * Returns true if the list is empty, false otherwise. 
  * @return true or false. 
  */
  @Override
 public boolean isEmpty(){
	//check the value of counter and return true or false  
	return counter == 0;
 }

 /**
  * Returns the number of items currently in the list. 
  * calls getCounter() method
  * @return the number of items in the list
  */
  @Override
 public int size(){
	return getCounter();
 }
 
 /*
 * Helper function 
 * Return number of items in list
 */
 private int getCounter(){
	return counter;
 }
 
 /*
 * Helper function to check for if the itemIndex is negative or greater or equal than the size of
 * the list ( test a negative or out of bounds value )
 * returns true or false
 */ 
 private boolean isIndexOutOfBounds(int itemIndex){
	//get the count of items in the array list
	int count = this.getCounter();
	
	//check if the itemIndex value parameter passed is a negative or greater 
	//than the count of item in the arrar list 
	if(itemIndex < 0 || itemIndex > count || itemIndex >= sizeOfArray ){
		return true;
	}else{
		return false; 
	}  
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
	//check for index is a negative or out of bounds value
	if(isIndexOutOfBounds(index)) {  
	   //return the result of the operation as failure operation 
		return new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);			
	} else {
	   //return the result of the operation as success operation 
		return new ReturnObjectImpl(listItems[index]);
	} 
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

	 //check for empty structure in the array list
	if (this.isEmpty() == true) { 
		//return the result of the operation as failure operation 
		return new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);
	}
	//check for the a negative or out of bounds value
	if(isIndexOutOfBounds(index)){		
		//return the result of the operation as failure operation  
		return new ReturnObjectImpl(message.INDEX_OUT_OF_BOUNDS);		
	}
    //loop and update the list with the deleted item 
	//and reduce the count of items by 1	
	 for(int i = index; i < listItems.length - 1; i++){
			listItems[i] = listItems[i+1];
		}
	  counter--;
	  //set the result of the operation as success operation 
	  return new ReturnObjectImpl(null);
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
	
		//check for the a negative or out of bounds value
	 if(isIndexOutOfBounds(index)){
		//set the result of the operation as failure operation  
		return new ReturnObjectImpl(message.INDEX_OUT_OF_BOUNDS);
	} 
		//ignored and set the appropriate error message
	if (item == null){
		return new ReturnObjectImpl(ErrorMessage.INVALID_ARGUMENT);
	}else{
		//add the item at the specified index
		listItems[index]=item;
		
		//increment the count item in the arrary list
		counter++;
	
		//set the result of the operation as success operation 
		return new ReturnObjectImpl(listItems[index]); 

	}
 }

 /**
  * Adds an element at the end of the list.
  * add(int index, Object item) does all the validation of adding item to the list
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

	if(item != null){
		//get the item count of the list
		int count = this.getCounter();
		if(count < sizeOfArray){
			//add the item at the specified index
			this.listItems[count]=item;	
		
			//increment the count item in the arrary list
			counter++;
		
			return new ReturnObjectImpl(item);
		}else{
			//set the result of the operation as failure operation  
			return new ReturnObjectImpl(message.INDEX_OUT_OF_BOUNDS);
		}

	}else{
		//return the result to the calling function
		return new ReturnObjectImpl(message.INVALID_ARGUMENT);
	}  
 }
 

 
}