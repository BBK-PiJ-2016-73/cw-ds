/**
 * ReturnObjectImpl.java is an implementation of ReturnObject interface ( see ReturnObject.java)
 * 
 * A wrapper containing either an object (the result of an operation
 * on a data structure) or an error value
 *
 *  @author  BBK-PiJ-2016-73 Ime Akpan
 */
public class ReturnObjectImpl implements ReturnObject {
	
	//variable for returning the error message to the calling function
    private ErrorMessage errorMessage;
	
	//variable to return true or false if an error is found
	private boolean errorFound;
	
	//result of operation value
	private Object resultOfOperationValue;
	
	/**
 	* ReturnObjectImpl constructor for successful implementation
 	* The constructor used for successful operations receives an Object type as it's only parameter
 	* @param object
 	*/
	public ReturnObjectImpl(Object object){
		
		//initialise all errors to be false
		this.errorFound = false;		
		//initialise the success value 
		this.resultOfOperationValue = object;
		//default value for erorMessage
	    this.errorMessage = ErrorMessage.NO_ERROR;
	}
	
	/**
 	* ReturnObjectImpl constructor for failed messages 
 	* the constructor used for failed operations receives an ErrorMessage type as its only parameter
 	* @param message
 	*/
	public ReturnObjectImpl(ErrorMessage message){
		
		if (message == ErrorMessage.NO_ERROR) {
			this.errorFound = false;
		} else {
			//initialise all errors to be true
			errorFound = true;
			
			/* initialise return value to null
			* because there has been an error.
			*/
			resultOfOperationValue = null;
		}
		//set the appropriate error message
		this.errorMessage = message;
	}
		
	/**
	 * hasError method returns true or false
     * if and error has occured
	 * @return true of false
	 */
	 @Override
	public boolean hasError(){
	  //return true of false to the calling function
	  return errorFound;		
	}

	/**
	 * This method returns the error message to the calling function. 
	 * default is NO_ERROR 
	 * @return the error message
	 */
	 @Override
	public ErrorMessage getError(){		
		//return the error message
		if(hasError()){
			return errorMessage;
		}else{
		 //default is NO_ERROR
		  return errorMessage.NO_ERROR;
		}	
	}
	
	
	/**
	 * Returns the object wrapped in this ReturnObject, i.e. the
	 * result of the operation if it was successful, or null if
	 * there has been an error.
	 * 
	 * Note that the output of this method must be null if {@see
	 * hasError} returns true, but the opposite is not true: if
	 * {@see hasError} returns false, this method may or may not
	 * return null.
	 * 
	 * @return the return value from the method or null if there has been an error
	 */
	 @Override
	public Object getReturnValue(){
		//just to double check that we returning the right result of the operation
		if (errorFound == false) { 
			return resultOfOperationValue;
		} else {
			return null; 
		}
		//I could have just return resultOfOperationValue because of the initialisation in the constructor 
		//return resultOfOperationValue;
	}
}