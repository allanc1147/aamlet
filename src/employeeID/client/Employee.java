package employeeID.client;

import java.util.HashMap;
import java.util.Map;

public class Employee {
	
	HashMap<String, Object> employeeInformation = new HashMap<String, Object>();
	
	public Employee(String[] employeeFields, Object[] employeeDetails){
		/** Create an employee object
		 *  
		 *  <employeeFields> and <employeeDetails> must have the same length.
		 *  let i be a natural number, <employeeFields[i]> must pertain to <employeeDetails[1]>
		 *  
		 *  @type employeeFields: Array
		 *  	List of employee fields. Example: "First Name", "Position"
		 *  @type employeeDetails: Array
		 *  	List of employee details that pertains to a specific employee.
		 *  	Example: "Allan", "Night Patrol"
		 *  @rtype: null
		 * **/
		for (int i = 0; i < employeeFields.length; i++){
			this.employeeInformation.put(employeeFields[i], employeeDetails[i]); 
		}
	}
}
