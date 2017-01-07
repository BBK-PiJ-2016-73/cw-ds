/*
* ReturnObjectImplUnitTest Unit Test 
*/

public class ReturnObjectImplUnitTest{

	public static void main(String[] args) {
	
	
	   ReturnObject rtnObj = new ReturnObjectImpl(null);
		
		System.out.println(rtnObj.hasError()==true? "testing for hasError on null object" : "failed test on hasError");	
		System.out.println("testing get return value on a null object  : \t " + rtnObj.getReturnValue() );	
		System.out.println(rtnObj.getError()== null ? "Testing get error on null object works fine" : "failed test on getError");
		System.out.println("\n");
        String str = "My java";
		// 
		ReturnObject rtnObj1 = new ReturnObjectImpl(str);
		System.out.println("testing get return value on a 'My java' object  : \t " + rtnObj1.getReturnValue() );	
		System.out.println(rtnObj1.hasError()==false ? "testing for hasError on object 'My java' object " : "failed test on hasError");	
		System.out.println(rtnObj1.getError() == ErrorMessage.NO_ERROR ? "Testing get error on object 'My java' object  works fine" : "failed test on getError");
		
		Object obj = "Nice to have a break to code";
		ReturnObject rtnObj2 = new ReturnObjectImpl(obj);
		System.out.println("testing get return value on a 'Nice to have a break to code'  : \t" + rtnObj2.getReturnValue() );	
		System.out.println(rtnObj2.hasError()==false ? "testing for hasError on object 'Nice to have a break to code' " : "failed test on hasError");	
		System.out.println(rtnObj2.getError() == ErrorMessage.NO_ERROR ? "Testing get error on object 'Nice to have a break to code'  works fine" : "failed test NO_ERROR");
				
		ReturnObject rtnObj3 = new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);
		System.out.println(rtnObj3.getError() == ErrorMessage.EMPTY_STRUCTURE ? "Testing EMPTY_STRUCTURE message works fine" : "failed test on EMPTY_STRUCTURE");
		
		ReturnObject rtnObj4 = new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
		System.out.println(rtnObj4.getError() == ErrorMessage.INDEX_OUT_OF_BOUNDS ? "Testing INDEX_OUT_OF_BOUNDS message works fine" : "failed test on INDEX_OUT_OF_BOUNDS");
		
		ReturnObject rtnObj5 = new ReturnObjectImpl(ErrorMessage.INVALID_ARGUMENT);
		System.out.println(rtnObj5.getError() == ErrorMessage.INVALID_ARGUMENT ? "Testing INVALID_ARGUMENT message works fine" : "failed test on INVALID_ARGUMENT"); 
		
		
		

	}
}