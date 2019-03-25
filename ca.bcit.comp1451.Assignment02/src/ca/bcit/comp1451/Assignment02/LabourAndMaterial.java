package ca.bcit.comp1451.Assignment02;

public class LabourAndMaterial extends Labour {
	private double materialPurchasePrice;
	private double materialVolumeInCubicFoot;
	private double materialDistanceOfTransportationInKilometres;
	
	public LabourAndMaterial(String projectName, int workingHours, double rate,
			double distanceOfTransportationInKilometres, String hourlyRateCriteria, String typeOfLabour,
			double materialPurchasePrice, double materialVolumeInCubicFoot,
			double materialDistanceOfTransportationInKilometres) {
		super(projectName, workingHours, rate, distanceOfTransportationInKilometres, hourlyRateCriteria, typeOfLabour);
		setMaterialPurchasePrice(materialPurchasePrice);
		setMaterialVolumeInCubicFoot(materialVolumeInCubicFoot);
		setMaterialDistanceOfTransportationInKilometres(materialDistanceOfTransportationInKilometres);
	}

	public double getMaterialPurchasePrice() {
		return materialPurchasePrice;
	}
	
	public void setMaterialPurchasePrice(double materialPurchasePrice) {
		if(materialPurchasePrice > 0) {
			this.materialPurchasePrice = materialPurchasePrice;
		}else {
			System.out.println("Material Purchase price must be greater than 0");
		}
		
	}
	
	public double getMaterialVolumeInCubicFoot() {
		return materialVolumeInCubicFoot;
	}
	
	public void setMaterialVolumeInCubicFoot(double materialVolumeInCubicFoot) {
		if(materialVolumeInCubicFoot > 0) {
			this.materialVolumeInCubicFoot = materialVolumeInCubicFoot;
		}else {
			System.out.println("Material Volume In Cubic Foot must be greater than 0");
		}
	}
	
	public double getMaterialDistanceOfTransportationInKilometres() {
		return materialDistanceOfTransportationInKilometres;
	}
	
	public void setMaterialDistanceOfTransportationInKilometres(double materialDistanceOfTransportationInKilometres) {
		if(materialDistanceOfTransportationInKilometres > 0) {
			this.materialDistanceOfTransportationInKilometres = materialDistanceOfTransportationInKilometres;
		}else {
			System.out.println("materia lDistance Of Transportation In Kilometres must be greater than 0");
		}
	}
	
	@Override
	public void calculateTransportationCost(double distanceOfTransportationinKilometres) {
		//transportationCost = transportationCostMultiplier * distanceOfTransportationInKilometres;
		if(getMaterialVolumeInCubicFoot() >= 10) {
			transportationCost = getDistanceOfTransportationInKilometres() * 2;
		}else {
			transportationCost = getDistanceOfTransportationInKilometres() * 1.5;
		}
	}
	

	@Override
	public double calculateTotalCost(int workingHours, double rate) { 
		//materialTransportationFees, material cost, 5% salestax of the added fees added to superclass implementation of the method
		double cost = 0;
		cost = super.transportationCost + transportationCost + materialPurchasePrice;
		cost = cost + (cost * 0.5);
		return cost;
	}
	

	@Override
	public String toString() {
		//add the following to the superclass' toString() method.  
		//Hourly rate criteria, type of labour, cost of labour transportation and totalCost.
		  //if(this.getClass() == LabourAndMaterial.class) {
			return super.toString() + "\n" +
									"Material Purchase Price: " + getMaterialPurchasePrice() + "\n"  +	
									"Transportation Cost: " + getTransportationCost();
		//}else {
		//	return super.toString() + getMaterialPurchasePrice()  +	getTransportationCost();
		}
		
		
		//to display the result of calculatecost() method once at the end of each invoice use the class validation...
		// if(this.getClass() == LabourAndMaterial.class) to decide whether to include the calculateTotalCost() method call in the toString return value
	}
	
	
	
