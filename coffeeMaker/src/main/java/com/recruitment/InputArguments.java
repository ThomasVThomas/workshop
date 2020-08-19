package com.recruitment;

public class InputArguments implements Input {

  private final String    drinkType;
  private final Float     money;
  private final Integer     sugar;
  private final Boolean   extraHot;

  InputArguments(
      String drinkType,
      Float money,
      Integer sugar,
      Boolean extraHot
  ) {
    this.drinkType = drinkType;
    this.money = money;
    this.sugar = sugar;
    this.extraHot = extraHot;
  }

  @Override
  public <T> T getParameter(String parameterName) {
    switch (parameterName) {
      case "drinkType":
        return (T) this.drinkType;
      case "money":
        return (T) this.money;
      case "sugar":
        return (T) this.sugar;
      case "extraHot":
        return (T) this.extraHot;
      default:
        return null;
    }
  }
}
