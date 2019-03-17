package ca.bcit.comp1451.Assignment02;

public class LabourAndMaterialAndEquipment extends LabourAndMaterial {
	private double equipmentValueInCAD;
	private int numberOfRentedHours;

	public LabourAndMaterialAndEquipment(String projectName, int workingHours, double rate,
			double distanceOfTransportationInKilometres, String hourlyRateCriteria, String typeOfLabour,
			double materialPurchasePrice, double materialVolumeInCubicFoot,
			double materialDistanceOfTransportationInKilometres, double equipmentValueInCAD, int numberOfRentedHours) {
		super(projectName, workingHours, rate, distanceOfTransportationInKilometres, hourlyRateCriteria, typeOfLabour,
				materialPurchasePrice, materialVolumeInCubicFoot, materialDistanceOfTransportationInKilometres);
		
		setEquipmentValueInCAD(equipmentValueInCAD);
		setNumberOfRentedHours(numberOfRentedHours);
	}
	
	public double getEquipmentValueInCAD() {
		return equipmentValueInCAD;
	}
	
	public void setEquipmentValueInCAD(double equipmentValueInCAD) {
		if(equipmentValueInCAD > 0) {
			this.equipmentValueInCAD = equipmentValueInCAD;
		} else {
			System.out.println("equipmentValueInCAD needs to be greater than 0");
		}
	}
	
	public int getNumberOfRentedHours() {
		return numberOfRentedHours;
	}
	
	public void setNumberOfRentedHours(int numberOfRentedHours) {
		if(numberOfRentedHours > 0) {
			this.numberOfRentedHours = numberOfRentedHours;
		} else {
			System.out.println("numberOfRentedHours needs to be greater than 0");
		}
	}
	
	public double calculateTotalRentalFees() {
		double ratePerHour = 0.5 * getEquipmentValueInCAD();
		double totalRentalFee = ratePerHour * getNumberOfRentedHours();
		return totalRentalFee;
	}
	
	public double calculateTrainingFees() {
		double fee = 0;
		if(typeOfLabour.equals("experienced")) {
			fee = 0;
		}else if(typeOfLabour == "inexperienced") {
			fee = getEquipmentValueInCAD() * .02;
		}
		return fee;
	}
	
	@Override
	public double calculateTotalCost(int workingHours, double rate) { 
		//materialTransportationFees, material cost, 5% salestax of the added fees added to superclass implementation of the method
		double cost = 0;
		cost = super.calculateTotalCost(workingHours, rate) + (calculateTrainingFees() + (calculateTotalRentalFees()) * .5) ;
		cost = cost + (cost * 0.5);
		return cost;
	}
	
	@Override
	public String toString() {
		//add the following to the superclass' toString() method.  
		//equipment number of rented hours, equipment rental fees, training fees if applicable
		if(calculateTrainingFees() < 0) {
			return super.toString() + "Number rented hours: " + getNumberOfRentedHours()  +	", equipment Rental Fees: " + calculateTotalRentalFees();
		}else {
			return super.toString() + "Number rented hours: " + getNumberOfRentedHours()  +	", equipment Rental Fees: " + calculateTotalRentalFees() + 
					", Training Fees: " + calculateTrainingFees();
		}
	}
	
}
