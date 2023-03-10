package BG.BGJDBC;

public class Student {
	
	private String Last_name;
	private String First_name;
	private double Phone;
	private String Email;
	private String Title;
	private String Designation;
	

	public Student(String last_name, String first_name, double phone, String email, String title, String designation) {
		super();
		Last_name = last_name;
		First_name = first_name;
		Phone = phone;
		Email = email;
		Title = title;
		Designation = designation;
	}
	public String getLast_name() {
		return Last_name;
	}
	public void setLast_name(String last_name) {
		Last_name = last_name;
	}
	public String getFirst_name() {
		return First_name;
	}
	public void setFirst_name(String first_name) {
		First_name = first_name;
	}
	public double getPhone() {
		return Phone;
	}
	public void setPhone(double phone) {
		Phone = phone;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getDesignation() {
		return Designation;
	}
	public void setDesignation(String designation) {
		Designation = designation;
	}
	@Override
	public String toString() {
		return "InterfaceImplementation [Last_name=" + Last_name + ", First_name=" + First_name + ", Phone=" + Phone
				+ ", Email=" + Email + ", Title=" + Title + ", Designation=" + Designation + "]";
	}
	
	
	


	
}
