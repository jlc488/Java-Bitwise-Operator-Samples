package ca.bcit.comp1451.Assignment02;

import java.util.ArrayList;
import java.util.Collections;

public class InsuranceCompany {
	//will calculate the insurance fees on a project bases
		String companyName;
		ArrayList<ProjectInvoice> list;
		
		public InsuranceCompany(String companyName) {
			super();
			setCompanyName(companyName);
			list = new ArrayList<ProjectInvoice>();
			
		}
		
		public String getCompanyName() {
			return companyName;
		}
		
		public void setCompanyName(String companyName) {
			if(companyName != null && !companyName.equals("")) {
				this.companyName = companyName;
			}else {
				this.companyName = "unknown";
			}
		}
		
		//Method to add a project invoice object to the collection
		public void addProjectInvoice(ProjectInvoice projectInvoice) {		
			//can't be project invoice, make it labour, or labourMaterial or some other object(s) but how?
			// do if instanceOf labour then.. or if instanceOf labourAndMaterial then... or etc
			list.add(projectInvoice);
			
			//String projectName, int workingHours, double rate
			
		}
		public void displayProjectInvoice(String invoiceNumber) throws InvalidInvoiceNumberException {
			if(invoiceNumber != null && invoiceNumber.length() >= 7) {
				//search collection and print invoice
				for(ProjectInvoice p : list) {
					if(p.getInvoiceNumber().equals(invoiceNumber)) {
						System.out.println(p);
						System.out.println("");
					}
				}
			}else {
				throw new InvalidInvoiceNumberException("invoice number can't be null or less than 7 chars");
			}
		}
		
		public double calculateTotalInsuranceFees(){
			double insuranceRatePercent = 0.0;
			if(getClass().getName().equals("LabourAndMaterialsAndEquipment")) {
				insuranceRatePercent = 0.1;
			}else if(getClass().getName().equals("LabourAndMaterials")) {
				insuranceRatePercent = 0.07;
			}else if(getClass().getName().equals("Labour")) {
				insuranceRatePercent = 0.05;
			}
			return insuranceRatePercent;
		}
		
		public void displayProjectInvoiceNumbers(String invoiceNumber) {
			Collections.sort(list);
			
			if(invoiceNumber != null && invoiceNumber.length() >= 7) {
				//search collection and print invoice
				for(ProjectInvoice p : list) {
					if(p.getInvoiceNumber().equals(invoiceNumber)) {
						System.out.println(p);
					}
				}
			}else {
				throw new IllegalArgumentException("invoice number can't be null or less than 7 chars");
			}
			
		}

}
