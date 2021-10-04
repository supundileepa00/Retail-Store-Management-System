package com.discount;

public class Calculations {
	
	public float calcDiscountPercentage(double discount, float sellingPrice) {
		float discountPercentage = (float) ((discount / sellingPrice) * 100);
		return discountPercentage;
	}
	

}
