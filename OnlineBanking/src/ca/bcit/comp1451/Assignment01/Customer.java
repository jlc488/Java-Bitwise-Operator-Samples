package ca.bcit.comp1451.Assignment01;

public class Customer {
	private String name;
	private String address;
	private String dob;
	
	public Customer(String name, String address, String dob) {
		this.setName(name);
		this.setAddress(address);
		this.setDob(dob);
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = this.validateName(name);
	}
	
	private String validateName(String name) {
		if( name == null || "".equals(name)) {
			throw new IllegalArgumentException("Name can not be null or empty!");
		}
		
		return name;
	}
	
	public String getAddress(){
		return address;
	}
	
	public void setAddress(String address){
		this.address = this.validateAddress(address);
	}
	
	/**
	 * The reason using "".equals(addess) instead of address.equals("")
	 * address.equals("") <-- this approach have a change of null point exception
	 * So, make a habit of using it as "".eqauls(something)
	 * which means if you are using "".equals(address) then you don't have to check null before checking this condition
	 * But you have to add it because that's what your assignment is asking XD 
	 * 
	 * @param address
	 * @return
	 */
	private String validateAddress(String address) {
		if(address == null || "".equals(address)){
			throw new IllegalArgumentException("address cannot be null or empty!");
		}
		return address;
	}
	
	public String getDob(){
		return dob;
	}
	
	public void setDob(String dob){
		this.dob = this.validateDoB(dob);
	}
	
	private String validateDoB(String dob) {
		if( dob == null || "".equals(dob)) {
			throw new IllegalArgumentException("dob cannot be null or empty!");
		}
		
		return dob;
	}
	
	public String formatName(String word) {
		String lowerCase= word.toLowerCase();
		String properName = Character.toUpperCase(lowerCase.charAt(0)) + lowerCase.substring(1);
		return  properName;
		
	}
	
	// a method to display all the information of the customer in an organized format with the name
	// properly formatted
	public void displayInformation() {
		System.out.println("Name: " + this.formatName(this.getName()));
		System.out.println("Address: " + this.getAddress());
		System.out.println("DOB: " + this.getDob());
	}
	
}
