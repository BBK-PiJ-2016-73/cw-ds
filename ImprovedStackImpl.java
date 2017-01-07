/**
 * ImprovedStackImpl.java implements Interface ImprovedStack
 *
 *  @author BBK-PiJ-2016-73 Ime Akpan
 */

public class ImprovedStackImpl implements ImprovedStack {

	//The data structure where the elements on the stack are stored. 
    protected List internalList;
	
	
	/**
     * ImprovedStackImpl contructor.  
     * 
	 * @param list the list to be used 
     */ 

	public ImprovedStackImpl(List list) {
		  this.internalList = list;			
	    }
	
	/**
	 * Returns a copy of this stack with the items reversed, the top
	 * elements on the original stack is at the bottom of the new
	 * stack and viceversa.
	 * 
	 * @return a copy of this stack with the items reversed. 
	 */
	public ImprovedStack reverse(){
		 //hold the result of the opperation
		ImprovedStack reverseStack = null;
		
		if (this.isEmpty()) {
			//set an appropriate error message
			ReturnObject result = new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);
			return reverseStack;
		} else {
			//creat a new list of type arraylist
			List listReverse = new ArrayList();
			//make a copy of the list 
			reverseStack = new ImprovedStackImpl(listReverse);
			//reverse the items by looping from the top to the bottom   			
			for (int i = this.size()-1; i >= 0; i--) { 
			    //get the value 
				Object obj = internalList.get(i).getReturnValue();
				listReverse.add(obj);	
			}
			//return the reverse list
		return reverseStack;
		}
		
	}

	/**
	 * Removes the given object from the stack if it is
	 * there. Multiple instances of the object are all removed.
	 *
	 * Classes implementing this method must use method .equals() to
	 * check whether the item is in the stack or not.
	 * 
	 * @param object the object to remove
	 */
	public void remove(Object object){
		if (this.isEmpty()) {
			//set an appropriate error message
			ReturnObject result = new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);
		} else {
			for (int i = 0; i < this.size()-1; i++) {
				//check whether the item is in the stack or not
				if (internalList.get(i).getReturnValue().equals(object)) {
					//if so remove it from the stack
					internalList.remove(i);
				}
			}
		}
		
	}
	
	 /**
	 * Returns true if the stack is empty, false otherwise. 
	 * 
	 * @return true if the stack is empty, false otherwise. 
	 */
	public boolean isEmpty(){
		
		return this.internalList == null;		
	}

	/**
	 * Returns the number of items currently in the stack.
	 * 
	 * @return the number of items currently in the stack
	 */
	public int size(){
		if (this.isEmpty()) {
			return 0;
		} else {	
			return this.internalList.size();
		}
	}

	/**
	 * Adds an element at the top of the stack. 
	 * 
	 * @param item the new item to be added
	 */
	public void push(Object item){
		 //hold the result of the opperation
		ReturnObject result = null;
		boolean ok = item == null ? true : false;
		if(ok){
		//set an appropriate error message
		 result = new ReturnObjectImpl(ErrorMessage.INVALID_ARGUMENT);
		}
		if (this.internalList != null) {
			this.internalList.add(item);
		}
	}

	/**
	 * Returns the element at the top of the stack. The stack is
	 * left unchanged.
	 * 
	 * @return If stack is not empty, the item on the top is returned. If the
	 *         stack is empty, an appropriate error.
	 */
	public ReturnObject top(){
		
		if (this.isEmpty() == true ) {
			//return an appropriate error if the list is empty			
			return new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);
		} else {
			//return the top item on the stack.
			return this.internalList.get((this.internalList.size()-1)); 
		}
		
	}

	/**
	 * Returns the element at the top of the stack. The element is
	 * removed from the stack.
	 * 
	 * @return If stack is not empty, the item on the top is returned. If the
	 *         stack is empty, an appropriate error.
	 */
	public ReturnObject pop(){
		
		if (this.isEmpty()) {		
			return new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);
		}else{
			return internalList.remove((internalList.size()-1)); 
		}
	}
}