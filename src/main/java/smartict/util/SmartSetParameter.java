package smartict.util;

public class SmartSetParameter {
	
	public String StringIsNullOrEmpty(String value){
		String returnValue = null;
		if(value == null){
			returnValue = value;
		}else if(!value.equals("")){
			returnValue = "'"+value+"'";
		}
		return returnValue;
	}
	
	public String checkIntegerNotZero(int receiveInt){
		String returnValue = null;
		
		if(receiveInt > 0) returnValue =  String.valueOf(receiveInt);
		
		return returnValue;
	}
}
