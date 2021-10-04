package employee;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class validation {

	
	public static boolean email_validation(String email) {
		boolean statusval = false;
		
		String email_Pattern=  "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+(?:\\."  
                + "[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+)*@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$";
		
		Pattern pattern = Pattern.compile(email_Pattern);
		Matcher matcher = pattern.matcher(email);
		
		if (matcher.matches()) {
			statusval = true;
		}else {
			statusval = false;
		}
		return statusval;
		
		
	}
}
