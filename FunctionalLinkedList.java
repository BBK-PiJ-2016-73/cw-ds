/**
 * FunctionalLinkedList.java is an implementation of interface FunctionalList
 *
 *  @author BBK-PiJ-2016-73 Ime Akpan
 */

public class FunctionalLinkedList extends LinkedList implements FunctionalList {
	
	
     /**
     * FunctionalLinkedList contructor.  
     * makes a call the base class 
     */
	public FunctionalLinkedList(){
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
    public ReturnObject head() {
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
    public FunctionalList rest() {
		//initialise a new list
		FunctionalList fnList = new FunctionalLinkedList();
		//check for empty list
    	if (this.isEmpty() == true) { 
    		return fnList;
    	}
		//loop and return all element in the list except the first item (head)
		//in the same order as they where in the original list
		for (int index = 1; index < this.size(); index++) {
			//get the item value and add it to the new list
			Object obj = this.get(index).getReturnValue();
			fnList.add(obj);
		}
		//return the new list
		return fnList;   	
    }
	
	/*
	* Unit testing
	*/
	public static void main(String[] args) {
 
		// Default constructor 
		
	  FunctionalList fnctlist = new FunctionalLinkedList();
		
		System.out.println(fnctlist.isEmpty()==true? "testing for empty list works" : "failed test");	
		System.out.println(fnctlist.size()==0? "testing 0 based list works fine" : "failed test");	
		System.out.println(fnctlist.remove(0).getError()==ErrorMessage.EMPTY_STRUCTURE? "Testing empty structure works fine" : "failed test");
		System.out.println("\n");
        String str = "My java";
		// add items to to LinkedList
		fnctlist.add("Nice to have a break to code");
		fnctlist.add(2);
		fnctlist.add("ime akpan");
		fnctlist.add("4");
		fnctlist.add("java oh java");
		fnctlist.add(4,str);
		
		System.out.println("Printing the current list items");
		printListItems(fnctlist);
		System.out.println("\n");
		System.out.println("Size of the original list is: \t" + fnctlist.size());
		FunctionalList fnlistResult = new FunctionalLinkedList();
	    FunctionalList fnctlistCopy = new FunctionalLinkedList();	
		fnctlistCopy = fnctlist;
		
		
		
		for (int count = 0; count <= fnctlist.size(); count++) { 

			int testnumber = 9;		
			System.out.println("Printing the head in the copylist is : \t " + fnctlistCopy.head().getReturnValue());
			System.out.println("Printing the appropriate error message when getting the head in the list : \t " + fnctlistCopy.head().getError());

			System.out.println("Printing the copylist without the head");
			fnlistResult = fnctlistCopy.rest();
			printListItems(fnlistResult);
			System.out.println("\n");
			System.out.println("Printing the size of the copylist now... : \t " + fnlistResult.size());
			System.out.println("The Size of the original list is : \t " + fnctlist.size()+ "\n");
			fnctlistCopy = fnlistResult;	
		}
	
		System.out.println("Printing the current list items");
		printListItems(fnctlist);

	}
		
	
	public static void printListItems(FunctionalList list){
		if (list.isEmpty()) {
				System.out.println("The list is empty");
		}else{
	     for (int i = 0; i < list.size(); i++) {
		System.out.println("Item " + i + " is " + list.get(i).getReturnValue().toString());
	     }
	  }
    }
} 