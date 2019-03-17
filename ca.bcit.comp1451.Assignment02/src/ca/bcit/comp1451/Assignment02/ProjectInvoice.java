package ca.bcit.comp1451.Assignment02;

import java.util.Objects;
import java.util.Collections;

public abstract class ProjectInvoice implements Comparable<ProjectInvoice>{	
	String projectName;
	int workingHours;
	double rate;
	String invoiceNumber;
	private String invoicePrefix = "INVC";
	private static int uniqueNumber = 100;
	
	public ProjectInvoice (String projectName, int workingHours, double rate){
		createInvoiceNumber();
		setProjectName(projectName);
		setWorkingHours(workingHours);
		setRate(rate);
	}

	private String createInvoiceNumber() {
		invoiceNumber = invoicePrefix + uniqueNumber;
		uniqueNumber++;
		return invoiceNumber;
	}
	
	public String getInvoiceNumber() {
		return invoiceNumber;
	}
	
	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public int getWorkingHours() {
		return workingHours;
	}

	public void setWorkingHours(int workingHours) {
		this.workingHours = workingHours;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public abstract double calculateTotalCost(int workingHours, double rate); 
	
	
	
	@Override
	public int hashCode() {
		return Objects.hash(invoicePrefix);
	}

	//Override method compareTo() in a way to compare  the total cost of two ProjectInvoice objects
	@Override
	public int compareTo(ProjectInvoice o){
		return (int) (this.calculateTotalCost(workingHours, rate) - o.calculateTotalCost(workingHours, rate));	
	}
	

	@Override
	public String toString() {
		//return a string of the the invoice number, project name, number of working hours and the hourly rate
		return "Invoice number:  " + getInvoiceNumber() + ", the project name: " + getProjectName() + ", the number of working hours: "  +
				getWorkingHours() + " and hourly rate: " + getRate();
	}


	
}
