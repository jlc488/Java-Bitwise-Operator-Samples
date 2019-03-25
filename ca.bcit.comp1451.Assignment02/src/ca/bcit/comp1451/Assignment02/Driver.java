package ca.bcit.comp1451.Assignment02;

import java.util.Collections;
import java.util.Scanner;

public class Driver {
	public static void main(String[] args) {
		// create an insurance company object
		InsuranceCompany insuranceCo = new InsuranceCompany("The Insurance Co.");
		// add 2 objects of labour class, 2 objects of labourAndMaterial and 2 objects
		// of LabourAndMaterialAndEquipment
		// to arraylist in Insurancecompany object
		Labour l1 = new Labour("Labour1", 1, 1.0, 1.0, "regular", "experienced");
		Labour l2 = new Labour("Labour2", 2, 2.0, 2.0, "overtime", "inexperienced");

		LabourAndMaterial lm1 = new LabourAndMaterial("LabourMaterials1", 3, 3.0, 3.0, "holiday", "experienced", 3.0,
				3.0, 3.0);
		LabourAndMaterial lm2 = new LabourAndMaterial("LabourMaterials2", 4, 4.0, 4.0, "regular", "inexperienced", 4.0,
				4.0, 4.0);

		LabourAndMaterialAndEquipment lme1 = new LabourAndMaterialAndEquipment("LabourMaterialsEquip1", 5, 5.0, 5.0,
				"overtime", "experienced", 5.0, 5.0, 5.0, 5.0, 5);
		LabourAndMaterialAndEquipment lme2 = new LabourAndMaterialAndEquipment("LabourMaterialsEquip1", 6, 6.0, 6.0,
				"holiday", "inexperienced", 6.0, 6.0, 6.0, 6.0, 6);

		insuranceCo.addProjectInvoice(l1);
		insuranceCo.addProjectInvoice(l2);
		insuranceCo.addProjectInvoice(lm1);
		insuranceCo.addProjectInvoice(lm2);
		insuranceCo.addProjectInvoice(lme1);
		insuranceCo.addProjectInvoice(lme2);

		// display all the invoice numbers sorted by total cost
		Collections.sort(insuranceCo.list);
		// display the total insurance fees of all the projects
		System.out.println("The Invoices sorted by the total cost");
		// System.out.println(insuranceCo.list);
		for (int i = 0; i < insuranceCo.list.size(); i++) {
			System.out.println(insuranceCo.list.get(i));
			System.out.println("");
			System.out.println("------------------");
		}

		// create a loop to do the following
		// ask user to enter an invoice num using scanner in
		Scanner sc = new Scanner(System.in);
		String yN = "y";
		String invoiceNumber;
		int choice;
		double amount;
		// call method displayInvoice() to display the project invoice of the given
		// invoice num
		// if invoice num invalid an exception is thrown from method getInvoice(). this
		// exception will be handled properly and will not break the while loop
		// handle this exception properly
		// if invoice num was valid the invoice of that project will be displayed
		System.out.print("Enter an Invoice Number : ");
		try {
			invoiceNumber = sc.nextLine();
			insuranceCo.displayProjectInvoice(invoiceNumber);
		} catch (InvalidInvoiceNumberException exc) {
			System.out.println(exc.getMessage());
			System.out.println("no invoice num");
		}
		while (yN != "n") {

			try {
				invoiceNumber = sc.nextLine();
				insuranceCo.displayProjectInvoice(invoiceNumber);
				// } catch(InvalidInvoiceNumberException exc) { //if invoice # was invalid an
				// exception will be thrown from method getInvoice()
			} catch (InvalidInvoiceNumberException exc) {
				System.out.println(exc.getMessage());
				System.out.println("no invoice num");
			}

			// -- disregard the catch block and just throw an error
			System.out.println("Would you like to do another transaction?: y /n ?");
			yN = sc.nextLine();
			if (yN.equals("n")) {
				System.out.println("GoodBye.");
				break;
			} else {
				System.out.print("Enter an Invoice Number : ");
				try {
					invoiceNumber = sc.nextLine();
					insuranceCo.displayProjectInvoice(invoiceNumber);
				} catch(InvalidInvoiceNumberException exc ) {
					System.out.println(exc.getMessage());
					System.out.println("no invoice num");
				}
			}
		} // end of while yN loop

	}// end of private static main
}
