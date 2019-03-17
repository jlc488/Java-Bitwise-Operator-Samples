package ca.bcit.comp1451.Assignment02;

public class Labour extends ProjectInvoice {
	double distanceOfTransportationInKilometres;
	String hourlyRateCriteria;  // regular, overtime, holiday
	String typeOfLabour;  // experienced, inexperienced
	public double transportationCost;
	private static double transportationCostMultiplier = 1.2;
	private static double overtimeRateMultiplier = 1.5;
	private static double holidayRateMultiplier = 2.0;
	private static double salesTax = 0.5;

	public Labour(String projectName, int workingHours, double rate, double distanceOfTransportationInKilometres, String hourlyRateCriteria, String typeOfLabour) {
		super(projectName, workingHours, rate);
		setDistanceOfTransportationInKilometres(distanceOfTransportationInKilometres);
		setHourlyRateCriteria(hourlyRateCriteria);
		setTypeOfLabour(typeOfLabour);
	}
	
	public double getDistanceOfTransportationInKilometres() {
		return distanceOfTransportationInKilometres;
	}
	
	public void setDistanceOfTransportationInKilometres(double distanceOfTransportationInKilometres) {
		if(distanceOfTransportationInKilometres > 0) {
			this.distanceOfTransportationInKilometres = distanceOfTransportationInKilometres;
		}else {
			System.out.println("Distance of Transportation in kilometres cannot be negative");
		}
		
	}
	
	public String getHourlyRateCriteria() {
		return hourlyRateCriteria;
	}
	
	public void setHourlyRateCriteria(String hourlyRateCriteria) {
			switch(hourlyRateCriteria) {
			case "regular":
				this.hourlyRateCriteria = hourlyRateCriteria;
				break;
			case "overtime":
				this.hourlyRateCriteria = hourlyRateCriteria;
				break;
			case "holiday":
				this.hourlyRateCriteria = hourlyRateCriteria;
			break;
			default:
				this.hourlyRateCriteria = "regular";
			}
	}
	
	public String getTypeOfLabour() {
		return typeOfLabour;
	}
	
	public void setTypeOfLabour(String typeOfLabour) {
		if(typeOfLabour != null) {
			switch(typeOfLabour) {
			case "experienced":
				this.typeOfLabour = typeOfLabour;
				break;
			case "inexperiencd":
				this.typeOfLabour = typeOfLabour;
				break;
			default:
				this.typeOfLabour = "inexperienced";
			}
		}else {
			this.typeOfLabour = "inexperienced";
		}
	}
	
	public void calculateTransportationCost(double distanceOfTransportationinKilometres){
		transportationCost = transportationCostMultiplier * distanceOfTransportationInKilometres;
	}
	
	public double getTransportationCost() {
		return transportationCost;
	}

	@Override
		public double calculateTotalCost(int workingHours, double rate) {
		double cost = 0;
		if(getHourlyRateCriteria().equals("regular")) {
			cost = getRate() * getWorkingHours();
		} else if(getHourlyRateCriteria().equals("overtime")) {
			cost = overtimeRateMultiplier * getRate() * getWorkingHours();
		} else if(getHourlyRateCriteria().equals("holiday")) {
			cost = holidayRateMultiplier * getRate() * getWorkingHours();
		}
		cost = (cost * salesTax) + cost;
		return cost;
	}
	
	@Override
	public String toString() {
		//add the following to the superclass' toString() method.  
		//Hourly rate criteria, type of labour, cost of labour transportation and totalCost.
		return super.toString() + "hourly rate criteria:  " + getHourlyRateCriteria() + ", type of labour: " + getTypeOfLabour() + 
				", cost of Labour Transportation: "  +	getTransportationCost() + " and total cost: " + calculateTotalCost(workingHours, rate);
	}
	
}
