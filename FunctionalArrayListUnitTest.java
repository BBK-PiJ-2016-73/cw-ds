/*
* FunctionalArrayList Unit Test 
*/
public class FunctionalArrayListUnitTest {

	public static void main(String[] args) {
 

	  FunctionalList fnctlist = new FunctionalArrayList();
		
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
		fnctlist.add(5,str);
		
		System.out.println("Printing the current list items");
		printListItems(fnctlist);
		System.out.println("\n");
		System.out.println("Size of the original list is: \t" + fnctlist.size());
		FunctionalList fnlistResult = new FunctionalArrayList();
	    FunctionalList fnctlistCopy = new FunctionalArrayList();	
		fnctlistCopy = fnctlist;
		
		
		
		for (int count = 0; count <= fnctlist.size(); count++) { 

			int testnumber = 6;		
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