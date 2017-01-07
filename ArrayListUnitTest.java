/*
* ArrayListUnitTest.java Unit Test 
*/

public class ArrayListUnitTest{

  // unit test 
 public static void main(String[] args) {
	 
      List list = new ArrayList();
	  
	  System.out.println(list.isEmpty()==true? "testing for empty list works" : "failed test");	
	  System.out.println(list.size()==0? "testing 0 based list works fine" : "failed test");	
	  System.out.println(list.remove(0).getError()==ErrorMessage.EMPTY_STRUCTURE? "Testing empty structure works fine" : "failed test");
	  System.out.println("\n");
	  System.out.println("Current item in the list is : \t " + list.size() + "\n");
	  
	  list.add("Ime Akpan");
	  list.add("Carol Penny-Farthing");
	  list.add("Liam The Great");
	  list.add("class of 2016");
	  list.add("Jame Archer");
	  list.add("Michael Bernard-jones");
	  list.add(6,"Family");
	  list.add(7,"Family Family");

	  System.out.println("Printing list after items being added : ");
	  printListItems(list);
	  
	  
	  System.out.println("\n");
	  System.out.println("Removing item index 3 from the list : \t" + list.get(3).getReturnValue().toString());
	  list.remove(3); 
	 
	  
	  System.out.println("Printing list after item index 3 remove");
	  System.out.println("\n");
	  printListItems(list);
	  System.out.println("\n");
	  System.out.println("Display item index 2 in the list : \t" + list.get(2).getReturnValue().toString());

	  
	  System.out.println("Number of item in the list " + list.size() + "\n");
	  System.out.println("adding 'I love java' to the list at index 7");
	  list.add(7, "I love java");
	   System.out.println("\n");
	  System.out.println("Print new list after addition");
	  printListItems(list);
    } 
	
	public static void printListItems(List list) { 
		if (list.isEmpty()) {
			System.out.println("The list is empty");
		} else {
			for (int i=0; i < list.size(); i++) {
				System.out.println("Item in list at index " + i + " is : \t" + list.get(i).getReturnValue().toString());
			}
		}
	}


}