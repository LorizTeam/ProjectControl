package smartict.util;

public class SmartStringUtils {
	public String buildStringFormatParameterRegsimTHSRI(String curDate){
		//input 2016-11-03 yyyy-MM-dd
		//return 20161103 yyyyMMdd
		curDate = curDate.replace("-", "");
		
		return curDate;
	}
	
	public String cvtStringFormatRegsimTHSRItoFormatDate(String regsimFormat){
		//input 20161103 yyyyMMdd
		//return 2016-11-03 yyyy-MM-dd
		String dateFormat = regsimFormat.substring(0, 4)+"-"+regsimFormat.substring(4, 6)+"-"+regsimFormat.substring(6, 8);
		
		return dateFormat;
	}
	
	public String buildStringFormatNumberPrependZero(String prepaidNumberAddedPrefix){
		//input 66891744898
		//return 0891744898
		String prepaidNumber = "0"+prepaidNumberAddedPrefix.substring(2);
		
		return prepaidNumber;
	}
	
	public String buildStringFormatNumberPrepend66(String prepaidNumberAddedPrefix){
		//input 0891744898
		//return 66891744898
		String prepaidNumber = "66"+prepaidNumberAddedPrefix.substring(1);
		
		return prepaidNumber;
	}
	
}
