package programming.CodeAcademy;

public class TransitCalculator {
	//consumer information
	int numberOfDaysExpected;
	int numberOfRidesExpected;
	int age;
	boolean hasDisability;
	boolean hasDiscount;
	
	//fare options
	double singleRide = 2.75;
	double sevenDaysUnlimited = 33.00;
	double thirtyDaysUnlimited = 127.00;
	
	double days; 
	double numberOfPasses;
	double totalCost;
	double pricePerRide;
	
	
	public static void main(String[] args) {
		TransitCalculator ticket = new TransitCalculator(19, 20, 80, false);
		ticket.getBestFare();
	}
	
	
	public TransitCalculator() {
	}
	
	
	public TransitCalculator(int days, int rides, int age, boolean disability) {
		this.numberOfDaysExpected = days;
		this.numberOfRidesExpected = rides;
		this.age = age;
		this.hasDisability = disability;
		
		if (age >= 65 || disability) {
			this.hasDiscount = true;
		} else {
			this.hasDiscount = false;
		}
		
	}
	
	
	public double payPerRide() {
		if (hasDiscount) {
			singleRide = 1.35;
		} 
			days = Double.valueOf(numberOfDaysExpected);
			numberOfPasses = days * numberOfRidesExpected;
			totalCost = singleRide * numberOfPasses;
			pricePerRide = totalCost / numberOfRidesExpected;
		
		return pricePerRide;
	}
	
	
	public double unlimited7Price() {
		if (hasDiscount) {
			sevenDaysUnlimited = 16.50;
		} 
			days = Double.valueOf(numberOfDaysExpected);
			numberOfPasses = Math.ceil(days/7);
			totalCost = sevenDaysUnlimited * numberOfPasses;
			pricePerRide = totalCost / numberOfRidesExpected;
		
		return pricePerRide;
	}
	
	
	public double unlimited30Price() {
		if (hasDiscount) {
			thirtyDaysUnlimited = 63.50;
		}
			days = Double.valueOf(numberOfDaysExpected);
			numberOfPasses = Math.ceil(days/30);
			totalCost = thirtyDaysUnlimited * numberOfPasses;
			pricePerRide = totalCost / numberOfRidesExpected;
		
		return pricePerRide;
	}
	
	
	public double[] getRidePrices() {
		double [] ridePrices = {payPerRide(), unlimited7Price(), unlimited30Price()};
		 
		return ridePrices;
	}
	
	
	public void getBestFare() {
		String [] fareOptions = {"Pay-Per-Ride", "7-day unlimited", "30-day unlimited"};
		double [] ridePrices = getRidePrices();
		double minPrice = Integer.MAX_VALUE;
		String fare = "";

		for (int i = 0; i < ridePrices.length; i++) {
			if (ridePrices[i] < minPrice) {
				minPrice = ridePrices[i];
				fare = fareOptions[i];
			}
		} 
		
		minPrice = Math.round(minPrice * 100.0) /100.0;
		StringBuilder bestOption = new StringBuilder();
		bestOption.append("Your best option is the " + fare + " pass at $" + minPrice + " per ride.");

	
		System.out.println(bestOption);
		
	}
	



}
