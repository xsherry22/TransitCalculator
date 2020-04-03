package programming.CodeAcademy;

public class TransitCalculator {
	//consumer information
	int transitDays;
	int numberOfRides;
	int age;
	boolean hasDisability;
	boolean hasDiscount;
	
	//fare options
	double singleRide = 2.75;
	double sevenDaysUnlimited = 33.00;
	double thirtyDaysUnlimited = 127.00;
	
	
	static double numberOfPasses;
	static double totalCost;
	static double pricePerRide;
	
	
	public static void main(String[] args) {
		int expectedDays = 22;
		int expectedRides = 50;
		int age = 25;
		boolean hasDisability = false;
		
		TransitCalculator ticket = new TransitCalculator(expectedDays, expectedRides, age, hasDisability);
		ticket.getBestFare();
	}
	
	
	public TransitCalculator() {
	}
	
	
	public TransitCalculator(int days, int rides, int age, boolean disability) {
		this.transitDays = days;
		this.numberOfRides = rides;
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
			//days = Double.valueOf(transitDays);
			numberOfPasses = transitDays * numberOfRides;
			totalCost = singleRide * numberOfPasses;
			pricePerRide = totalCost / numberOfRides;
		
		return pricePerRide;
	}
	
	
	public double unlimited7Price() {
		if (hasDiscount) {
			sevenDaysUnlimited = 16.50;
		} 
			
			numberOfPasses = Math.ceil(transitDays/7.0);
			totalCost = sevenDaysUnlimited * numberOfPasses;
			pricePerRide = totalCost / numberOfRides;
		
		return pricePerRide;
	}
	
	
	public double unlimited30Price() {
		if (hasDiscount) {
			thirtyDaysUnlimited = 63.50;
		}
			//days = Double.valueOf(transitDays);
			numberOfPasses = Math.ceil(transitDays/30.0);
			totalCost = thirtyDaysUnlimited * numberOfPasses;
			pricePerRide = totalCost / numberOfRides;
		
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
		minPrice = Math.round(minPrice * 100.0) / 100.0;
		
		StringBuilder bestOption = new StringBuilder();
		bestOption.append("Your best option is to buy the " + fare + " pass at $" + minPrice + " per ride.");

	
		System.out.println(bestOption);
		
	}
	



}
