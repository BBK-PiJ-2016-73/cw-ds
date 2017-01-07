/*
* SampleableListImplUnitTest.java Unit Test 
*/

public class SampleableListImplUnitTest{

  // unit test 
 public static void main(String[] args) {
	 
	  SampleableList smplList = new SampleableListImpl();
	  
	  System.out.println(smplList.isEmpty()==true? "testing for empty list works" : "failed test when calling isEmpty");	
	  System.out.println(smplList.size()==0? "testing 0 based list works fine" : "failed test on get the size of list");	
	  System.out.println(smplList.get(0).getError()==ErrorMessage.EMPTY_STRUCTURE? "Testing empty structure works fine" : "failed test on empty structure");
	  System.out.println(smplList.get(0).getReturnValue()==null? "Testing return null on get(0) works fine" : "failed test on returning null");
	
	  System.out.println("\n");
	  System.out.println("Current item in the list is : \t " + smplList.size() + "\n");
	  
	  smplList.add("Ime Akpan");
	  smplList.add("Carol Penny-Farthing");
	  smplList.add("Liam The Great");
	  smplList.add("class of 2016");
	  smplList.add("Jame Archer");
	  smplList.add("Michael Bernard-jones");
	  smplList.add(5,"Family");
	  smplList.add(6,"Family Family");

	  System.out.println("Printing list after items being added : ");
	  printListItems(smplList);
	  
	  
	  System.out.println("\n");
	  System.out.println("Removing item index 3 from the list : \t" + smplList.get(3).getReturnValue().toString());
	  smplList.remove(3); 
	 
	  
	  System.out.println("Printing list after item index 3 remove");
	  System.out.println("\n");
	  printListItems(smplList);
	  System.out.println("\n");
	  System.out.println("Display item index 2 in the list : \t" + smplList.get(2).getReturnValue().toString());

	  
	  System.out.println("Number of item in the list " + smplList.size() + "\n");
	  System.out.println("adding 'I love java' to the list at index 6");
	  smplList.add(6, "I love java");
	  System.out.println("\n");
	  
	  System.out.println("Print new list after addition");
	  printListItems(smplList);
	  
	  System.out.println("\n");
	  System.out.println("Printing a sample list after calling sample list sample method");
	  printListItems(smplList.sample());
    } 
	
	public static void printListItems(SampleableList  list) { 
		if (list.isEmpty()) {
			System.out.println("The list is empty");
		} else {
			for (int i=0; i < list.size(); i++) {
				System.out.println("Item in list at index " + i + " is : \t" + list.get(i).getReturnValue().toString());
			}
		}
	}


}