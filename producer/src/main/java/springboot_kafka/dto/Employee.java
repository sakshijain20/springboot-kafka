package springboot_kafka.dto;

import lombok.Data;

@Data
public class Employee {

	public int id;
	public String firstName;
	public String lastName;
	public String contactNum;
	public String email;
	
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", contactNum="
				+ contactNum + ", email=" + email + "]";
	}
	
	

}
