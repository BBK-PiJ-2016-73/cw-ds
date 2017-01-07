	/*
	* LinkedListUnitTest.java Unit testing
	*/
public class LinkedListUnitTest{


	public static void main(String[] args) {
 
		// Default constructor 
		List list = new LinkedList();
		
		System.out.println(list.isEmpty()==true? "testing for empty list works" : "failed test");	
		System.out.println(list.size()==0? "testing 0 based list works fine" : "failed test");
		
		System.out.println(list.remove(0).getError()==ErrorMessage.EMPTY_STRUCTURE? "Testing empty structure works fine" : "failed test");
		System.out.println("\n");
        String str = "My java";
		// add items to to LinkedList
		list.add("Nice to have a break to code");
		list.add(2);
		list.add("ime akpan");
		list.add("4");
		list.add("java oh java");
		list.add(4,str);
		
		System.out.println("Printing the current list items");
		printListItems(list);
		System.out.println("\n");
		System.out.println("Size of the list is: \t" + list.size());
		ReturnObject robj = list.get(7);		
		System.out.println("Testing for out of bounds when getting item index 7:"  );
		System.out.println(robj.hasError()==true ? robj.getError() : robj.getReturnValue());
			 
	    System.out.println("Return item at index 3: \t" + list.get(3).getReturnValue());
		
		
		System.out.println("removing item 2 is: \t" + list.remove(2).getReturnValue());
		System.out.println("Print list after removing item 2");
		System.out.println("\n");
		printListItems(list);
		System.out.println("\n");
       
 		System.out.println("Return item 3 is : \t" + list.get(3).getReturnValue());
		System.out.println("\n");
		
		List list1 = new LinkedList();
		
		System.out.println("adding item at index 4, Say your name say your name");
		String sName = "Say your name say your name";
		list.add(4,sName);
 
	    System.out.println("Return item at index 4: \t" + list.get(4).getReturnValue());
		
		System.out.println("\n");
		System.out.println("Size of list is now: \t" + list.size());
		System.out.println("adding item at index 5, Say your name say your name");
		list.add(5, sName);
 
	    System.out.println("Return item at index 5: \t" + list.get(5).getReturnValue());
		System.out.println("Printing the current list items");
		System.out.println("\n");
		printListItems(list);
		
	}
	public static void printListItems(List list){
	if (list.isEmpty()) {
			System.out.println("The list is empty");
	}else{
	     for (int i = 0; i < list.size(); i++) {
		System.out.println("Item " + i + " is " + list.get(i).getReturnValue().toString());
	     }
	  }
    }
}