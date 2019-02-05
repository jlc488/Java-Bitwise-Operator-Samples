package ca.bcit.comp1451.Assignment01;

import java.util.HashMap;


public class Date {
	private int day = 1;
	private int month = 1;
	private int year = 1900;
	private int currentYear = 2019;
		
	private HashMap<Integer, String> monthNames;

	 //constructor
	 public Date(int day, int month, int year) {
		 //constructor needs to create the hash map
		 this.monthNames = new HashMap<Integer, String>();
		 //constructor needs to call the private method that populates the hashmap
		 this.populateMonthNames(); 
		 
		 this.setDay(day);
		 this.setMonth(month);
		 this.setYear(year);
	 }
	 
	 private int mutateDay(int day) {
		 return (day >= 1 || day <=31)? day : 1; //ternary operator, this is same as mutateMonth
	 }
	 
	 private void setDay(int day){
		 this.day = this.mutateDay(day);
	 }
	 
	 public int getDay(){
		 return this.day;
	 }
	 
	 private int mutateMonth(int month) {
		 int ret = 1;
		 
		 if( month >= 1 || month <= 31 ) {
			 ret = month;
		 }
		 
		 return ret;
	 }
	 
	 private void setMonth(int month){
		 this.month = this.mutateMonth(month);
	 }
	 
	 public int getMonth() {
		 return this.month;
	 }
	 
	 private int mutateYear(int year) {
		 int ret = 1900;
		 
		 if(1900 >= year || year <= this.currentYear) {
			 ret = year;
		 }
		 
		 return ret;
	 }
	 
	 private void setYear(int year){
		 this.year = this.mutateYear(year);
	 }
	 
	 public int getYear() {
		 return year;
	 }
	 
	 /**
	  * private method to populate the hasmap with month names and numbers
	  * you need to call this method from the constructor
	  */
	 private void populateMonthNames() {
		 monthNames.put(1, "January");
		 monthNames.put(2, "February");
		 monthNames.put(3, "March");
		 monthNames.put(4, "April");
		 monthNames.put(5, "May");
		 monthNames.put(6, "June");
		 monthNames.put(7, "July");
		 monthNames.put(8, "August");
		 monthNames.put(9, "September");
		 monthNames.put(10, "October");
		 monthNames.put(11, "November");
		 monthNames.put(12, "December");
	 }
	 
	 /**
	  * a method to return a string of the date in the format dd/month name/yyy.
	  *	if day value consists of one digit, it will be proceeded by 0
	  *	ie day3 of month3 of year 2013 will be 03/March/2013 
	  *	or 11/March/2013
	  *
	  * @return String formated date  
	  */
	public String formatDate() {
		 StringBuffer ret = new StringBuffer();
		 
		 if(this.day < 10) {
			 ret.append("0" +  this.day);
		 }else {
			 ret.append(this.day);
		 }
		 
		 ret.append("/");
		 ret.append(this.monthNames.get(this.month));
		 ret.append("/");
		 ret.append(this.year);
		 
		 return ret.toString();
		 
	 }
	 
	 
}
