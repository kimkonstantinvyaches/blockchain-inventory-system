package Helper;

import java.util.List;

public class Validation {
	 public static boolean emptyTextfield(List<String> textFields) {
	    	//Return false if either fields are empty, Return true if all fields are valid
	    	return !textFields.contains("");
	 }
}
