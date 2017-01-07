/*
* FunctionalArrayList.java is an implementation of interface List( see List.java)
* This is implemented using array.
* 
* @author BBK-PiJ-2016-73 Ime Akpan
*/
public class FunctionalArrayList extends ArrayList implements FunctionalList{

     /**
     * FunctionalArrayList contructor.  
     * makes a call the base class 
     */
	public FunctionalArrayList(){
		//call the base class constructor
		super();
	}
	/**
     * Returns the element at the beginning of the list. 
     * 
     * If the list is empty, an appropriate error is returned. 
     *
     * @return a copy of the element at the beginning of the list or 
     *         an error if the list is empty.
     */
	 @Override
    public ReturnObject head(){
		
		if (this.isEmpty() == true) {
			//the list is empty, just return the appropriate error message
        	return new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);
        } else {
			//return a copy of the element at the beginning of the list
        	return new ReturnObjectImpl(this.get(0).getReturnValue()); 
        }
	}

    /**
     * Returns a list with the elements in this list except the
     * head. The elements must be in the same order. The original list
     * must not change or be affected by changes in the new list. 
     * 
     * If the list is empty, another empty list is returned. 
     */
	 @Override
    public FunctionalList rest(){
		//initialise a new list
		FunctionalList arryList = new FunctionalArrayList();
		//check for empty list
		if (this.isEmpty() == true) { 
	    	return arryList;
	    } else {	
			//loop and return all element in the list except the first item (head)
			//in the same order as they where in the original list
	    	for (int index = 1; index <= (this.size()-1); index++) {
				//get the item value and add it to the new list
	    		Object obj = this.get(index).getReturnValue();
	    		arryList.add(obj);
	    	}
		}
		return  arryList;
	}
	
	
}