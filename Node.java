/***********************************************
 * A Helper interface class to act as a pointer 
 *
 * @author Ime Akpan
 ************************************************/
public interface Node{
	/**
	* A Helper method to return an object in the chain 
	* @return Object an object to be returned,
	*/	
	public Object getData();
	
	/**
	* A Helper method to set an object value in the chain 
	* @param dataValue the object item value to be set in the chain 
	*   
	*/	
	public void setData(Object dataValue);
	
	/**
	* A Helper method to get an object value in the chain 
	* @return the node of an object to be returned,    
	*/
	public Node getNext();
	
    /**
	* A Helper method to set the next node in the chain 
	* @param nextItemValue the node of an object to be set,    
	*/
	public void setNext(Node nextItemValue);


}