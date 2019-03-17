package ca.bcit.comp1451.Assignment02;

import java.util.Collections;
import java.util.Scanner;

public class Driver {
	private static void main(String[] args) {
		//create an insurance company object
		InsuranceCompany insuranceCo = new InsuranceCompany("The Insurance Co.");
		//add 2 objects of labour class, 2 objects of labourAndMaterial and 2 objects of LabourAndMaterialAndEquipment 
		//to arraylist in Insurancecompany object
		ProjectInvoice l1 = new Labour("Labour1", 1, 1.0, 1.0, "regular", "experienced");
		ProjectInvoice l2 = new Labour("Labour2", 2, 2.0, 2.0, "overtime", "inexperienced");
		
		ProjectInvoice lm1 = new LabourAndMaterial("LabourMaterials1", 3, 3.0, 3.0, "holiday", "experienced", 3.0, 3.0, 3.0);
		ProjectInvoice lm2 = new LabourAndMaterial("LabourMaterials2", 4, 4.0, 4.0, "regular", "inexperienced", 4.0, 4.0, 4.0);
		
		ProjectInvoice lme1 = new LabourAndMaterialAndEquipment("LabourMaterialsEquip1", 5, 5.0, 5.0, "overtime", "experienced", 5.0, 5.0, 5.0, 5.0, 5);
		ProjectInvoice lme2 = new LabourAndMaterialAndEquipment("LabourMaterialsEquip1", 6, 6.0, 6.0, "holiday", "inexperienced", 6.0, 6.0, 6.0, 6.0, 6);
		
		insuranceCo.addProjectInvoice(l1);
		insuranceCo.addProjectInvoice(l2);
		insuranceCo.addProjectInvoice(lm1);
		insuranceCo.addProjectInvoice(lm2);
		insuranceCo.addProjectInvoice(lme1);
		insuranceCo.addProjectInvoice(lme2);
		
		//display all the invoice numbers sorted by total cost
		Collections.sort(insuranceCo.list);
		//display the total insurance fees of all the projects
		
		//create a loop to do the following
			
			// ask user to enter an invoice num using scanner in
		System.out.print("Enter the Invoice Number : ");
		Scanner sc = new Scanner(System.in);
			//call method displayInvoice() to display the project invoice of the given invoice num
		String invoiceNumber = sc.nextLine();
			//if invoice num invalid an exception is thrown from method getInvoice(). this exception will be handled properly and will not break the while loop
		if(invoiceNumber == null) {
//			ProjectInvoice.getInvoice(invoiceNumber); //handle this exception properly
		}else {
			//Account accnt = getAccount(accountNumber); 
			//if invoice num was valid the invoice of that project will be displayed
		
		//the while loop will ask the user if he/she wants to enter another invoice num and will stop if the users reponse was no.
		}
	}
}


