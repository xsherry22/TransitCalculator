package programming.CodeAcademy;

import java.util.Arrays;

public class TransitCalculator {
	
	int transitDays;
	int totalRides;
	static double singleRide = 2.75;
	static double sevenDaysUnlimited = 33.00;
	static double thirtyDaysUnlimited = 127.00;
	
	public TransitCalculator(int days, int rides) {
		this.transitDays = days;
		this.totalRides = rides;
	}
	
	public double payPerRide() {
		double days = Double.valueOf(transitDays);
		double numberOfPasses = days * totalRides;
		double totalCost = singleRide * numberOfPasses;
		double pricePerRide = totalCost / totalRides;
		
		return pricePerRide;
	}
	
	public double unlimited7Price() {
		double days = Double.valueOf(transitDays);
		double numberOfPasses = Math.ceil(days/7);
		double totalCost = sevenDaysUnlimited * numberOfPasses;
		double pricePerRide = totalCost / totalRides;
		
		return pricePerRide;
	}
	
	public double unlimited30Price() {
		double days = Double.valueOf(transitDays);
		double numberOfPasses = Math.ceil(days/30);
		double totalCost = thirtyDaysUnlimited * numberOfPasses;
		double pricePerRide = totalCost / totalRides;
		
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
				
		StringBuilder bestOption = new StringBuilder();
		bestOption.append("Your best option is the " + fare + " pass at $" + minPrice + " per ride.");

	
		System.out.println(bestOption);
		
	}
	

	public static void main(String[] args) {
		
		TransitCalculator ticket = new TransitCalculator(19, 20);
		ticket.getBestFare();
	}
	
	


}
