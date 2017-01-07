/*
* StackImplUnitTest.java Unit Test 
*/

public class StackImplUnitTest{

	public static void main(String[] args){
	
	  List list = new ArrayList();
	  StackImpl stck = new StackImpl(list);
	  
	  System.out.println(stck.isEmpty()==false? "testing for empty stack works" : "failed test when calling isEmpty");	
	  System.out.println(stck.size()==0? "testing 0 based stack works fine" : "failed test on get the size of stack");	
	  System.out.println(stck.top().getError()==ErrorMessage.EMPTY_STRUCTURE? "Testing empty structure works fine" : "failed test on empty structure");
	  System.out.println(stck.pop().getReturnValue()==null? "Testing return null on pop(0) works fine" : "failed test on returning null");
		
	  System.out.println("\n");
	  System.out.println("Current item count in the stack is : \t " + stck.size() + "\n");
	  
	  stck.push("Ime Akpan");
	  stck.push("Carol Penny-Farthing");
	  stck.push("Liam The Great");
	  stck.push("class of 2016");
	  stck.push("Jame Archer");
	  stck.push("Michael Bernard-jones");
	  stck.push("Family");
	  stck.push("Family Family");
	  
	  System.out.println("The top item in the stack is: \t " + stck.top().getReturnValue().toString());

	  System.out.println("Printing stack after items being added to the stack: ");
	  printListItems(stck);
	  

	  
	  System.out.println("\n");
	  System.out.println("Current item count in the stack is : \t " + stck.size() + "\n");
	  
	  System.out.println("Poping the first 2 objects from the stack");
	  for (int i=0; i < 2; i++) {
			stck.pop();
		}
	 
	 System.out.println("Printing stack after poping 2 objects from the stack");
     System.out.println("\n");	 
	 printListItems(stck);
	 
	  System.out.println("\n");
	  System.out.println("Current item count in the stack is : \t " + stck.size() + "\n");

	}
	public static void printListItems(StackImpl  list) { 
		if (list.isEmpty()) {
			System.out.println("The list is empty");
		} else {
			for (int i=0; i < list.size(); i++) {
				System.out.println("Item in stack at index " + i + " is : \t" + list.internalList.get(i).getReturnValue().toString());
			}
		}
	}
}