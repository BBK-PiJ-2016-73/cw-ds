/**
 * StackImpl.java extends AbstractStack which implements Interface Stack
 *
 *  @author BBK-PiJ-2016-73 Ime Akpan
 */
 
 
 public class StackImpl extends AbstractStack{
	 
	/**
     * StackImpl contructor.  
     * makes a call the base class 
     */ 
	 public StackImpl(List list) { 
		super(list);	
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
			return internalList.get((internalList.size()-1)); 
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