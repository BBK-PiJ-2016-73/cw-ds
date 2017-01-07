/**
 * An implementation of Node interface 
 * This class implementation is a helper class acting as a pointer
 *
 * @author Ime Akpan
 */
public class NodeImpl implements Node {
	
	//holds the data value of any type in the chain
	public Object dataValue;
	
	//holds the reference to the next node
    public Node nextItem;
	
	/*
	* NodeImpl constructor
	*/	
	public NodeImpl(Object itemValue) {
		//initialise  
		nextItem = null;
		dataValue = itemValue;
	}
	
	/*
	* NodeImpl constructor to point to a specific node
	*/
	public NodeImpl(Object itemValue, Node nextValue) {
		nextItem = nextValue;
		dataValue = itemValue;
	}
	
	/**
	* A Helper method to return an object in the chain 
	* @return Object an object to be returned,
	*/	
	public Object getData(){
		return dataValue;
	}
	
	/**
	* A Helper method to set an object value in the chain 
	* @param dataValue the object item value to be set in the chain    
	*/	
	public void setData(Object dataValue){
		dataValue = dataValue;
	}
	
	/**
	* A Helper method to get an object value in the chain 
	* @return the node of an object to be returned,    
	*/
	public Node getNext(){
		return nextItem;
	}
	
    /**
	* A Helper method to set the next node in the chain 
	* @param nextItemValue the node of an object to be set,    
	*/
	public void setNext(Node nextItemValue){
		nextItem = nextItemValue;
	}
      
}