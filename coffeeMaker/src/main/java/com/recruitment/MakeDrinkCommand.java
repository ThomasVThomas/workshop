package com.recruitment;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.EnumUtils;

public class MakeDrinkCommand implements Command {
	
	Map<String,Float> saleMap = new HashMap<>();

  @Override
  public void execute(Input input, Output out) {
	  
    String drinkType = input.getParameter("drinkType");

    if (EnumUtils.isValidEnumIgnoreCase(DRINKS.class, drinkType)) {
      DRINKS drinkType1 = EnumUtils.getEnumIgnoreCase(DRINKS.class, drinkType);
      float  money = input.getParameter("money");
      
      validateCost(out, money,drinkType1);
     
      validateSugarQuantityMessage(input, out, drinkType1);

    } else {
      out.run("The drink type should be tea, coffee or chocolate.");
    }

  }

private void validateSugarQuantityMessage(Input input, Output out, DRINKS drinkType) {
	String message;
	 int sugarsNo = input.getParameter("sugar");
      if (sugarsNo >= 0 && sugarsNo <= 2) {
        message = "You have ordered a " + drinkType.getDrinkName();

        message = validateExtraHot(input, message);
        message += " with " + sugarsNo + " sugar";
        if (sugarsNo > 0) {
          message += "s (stick included)";
        }
        updateSales(drinkType);
        
        out.run(message);
      } else {
        out.run("The number of sugars should be between 0 and 2.");
      }
}

private String validateExtraHot(Input input, String message) {
	Boolean isExtraHot = input.getParameter("extraHot");
	if (isExtraHot) {
	  message += " extra hot";
	}
	return message;
}

private void updateSales(DRINKS drinkType) {
	Float amountTill = saleMap.get(drinkType.name());
	if(amountTill ==null){
		amountTill = 0f;
	}
	saleMap.put(drinkType.name(),amountTill+drinkType.getDrinkCost());
}

private void validateCost(Output out, Float money,DRINKS drinkType) {
	float price = drinkType.getDrinkCost();
	  if (money < price) {
	    out.run("The "+drinkType.getDrinkName() +" costs " + price + ".");
	    return;
	  }
}
  
  @Override
  public void getSaleStatus(Output out){
	  out.run("sale status");
	  saleMap.forEach((drink,sale)->{out.run(drink+" "+sale);});
	  System.out.println();
	  
  }
}
