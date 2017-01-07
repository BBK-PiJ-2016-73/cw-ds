/**
 * SampleableListImpl.java is an implementation of interface SampleableList
 *
 * SampleableListImpl.java extends LinkedList to take advantage of methods 
 * (inheritance) already define in implementing interface List
 *
 *  @author BBK-PiJ-2016-73 Ime Akpan
 */
public class SampleableListImpl extends LinkedList implements SampleableList{

    /**
     * SampleableListImpl contructor.  
     * makes a call the base class 
     */
	public SampleableListImpl(){
		super();
	}
	/**
	 * Returns a list containing the first, third, fifth...
	 * items of this list, or an empty list if the list is empty. 
	 * 
	 * @return a list containing the first, third, fifth... items of this list
	 */
	@Override
	public SampleableList sample() {
		
		SampleableList simpleList = new SampleableListImpl();
		//rturn an empty list if the list is empty. 
		if (this.isEmpty()) {	
			return simpleList;
		} else {
			//start the loop from the first item and increment by 2
			//and get the item value
			for (int index = 1; index < this.size(); index += 2) {
				Object obj = this.get(index).getReturnValue();
				simpleList.add(obj);
			}
			// return the list containing the first, third, fifth... items
			return simpleList;
		}
	}
}