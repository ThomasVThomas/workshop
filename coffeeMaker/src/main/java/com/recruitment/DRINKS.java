package com.recruitment;

public enum DRINKS {
  COFFEE(0.5f),
  TEA(0.4f),
  CHOCOLATE(0.6f);
	
	
	DRINKS(float cost){
		this.cost = cost;
	}
	private float cost;
	
	float getDrinkCost(){
		return cost;
		
	}
	String getDrinkName(){
		return this.name().toLowerCase();
		
	}
	
	
}
