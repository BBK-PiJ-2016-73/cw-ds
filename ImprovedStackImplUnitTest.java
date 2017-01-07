/*
* ImprovedStackImplUnitTest.java Unit Test 
*/

public class ImprovedStackImplUnitTest{

	public static void main(String[] args){
	
	  List list = new ArrayList();
	  ImprovedStackImpl impStack = new ImprovedStackImpl(list);
	  
	  System.out.println(impStack.isEmpty()==true? "testing for empty stack works" : "failed test when calling isEmpty");	
	  System.out.println(impStack.size()==0? "testing 0 based stack works fine" : "failed test on get the size of stack");	
	  System.out.println(impStack.top().getError()==ErrorMessage.EMPTY_STRUCTURE? "Testing empty structure works fine" : "failed test on empty structure");
	  System.out.println(impStack.pop().getReturnValue()==null? "Testing return null on pop(0) works fine" : "failed test on returning null");
		
	  System.out.println("\n");
	  System.out.println("Current item count in the stack is : \t " + impStack.size() + "\n");
	  
	  impStack.push("Ime Akpan");
	  impStack.push("Carol Penny-Farthing");
	  impStack.push("Liam The Great");
	  impStack.push("class of 2016");
	  impStack.push("Jame Archer");
	  impStack.push("Michael Bernard-jones");
	  impStack.push("Family");
	  impStack.push("Family Family");
	  
	  System.out.println("The top item in the stack is: \t " + impStack.top().getReturnValue().toString());

	  System.out.println("Printing stack after items being added to the stack: ");
	  printListItems(impStack);
	  
	  System.out.println("\n");
	  System.out.println("Removing item 'Family' from the stack");
	  impStack.remove("Family"); 
	 
	  
	  System.out.println("Printing stack after object 'Family' is removed");
	  System.out.println("\n");
	  printListItems(impStack);
	  
	  System.out.println("\n");
	  System.out.println("Current item count in the stack is : \t " + impStack.size() + "\n");
	  
	  System.out.println("Poping the first 4 objects from the stack");
	  for (int i=0; i < 4; i++) {
			impStack.pop();
		}
	 
	 System.out.println("Printing stack after poping 4 objects from the stack");
     System.out.println("\n");	 
	 printListItems(impStack);
	 
	  System.out.println("\n");
	  System.out.println("Current item count in the stack is : \t " + impStack.size() + "\n");
	 
	  ImprovedStack reverseStack = impStack.reverse();
	  System.out.println("The top reverse stack after poping 4 objects from the stack is now : \t" + reverseStack.top().getReturnValue().toString());
 
	}
	public static void printListItems(ImprovedStackImpl  list) { 
		if (list.isEmpty()) {
			System.out.println("The list is empty");
		} else {
			for (int i=0; i < list.size(); i++) {
				System.out.println("Item in stack at index " + i + " is : \t" + list.internalList.get(i).getReturnValue().toString());
			}
		}
	}
}