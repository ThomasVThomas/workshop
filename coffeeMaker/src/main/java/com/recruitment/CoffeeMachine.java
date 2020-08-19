package com.recruitment;

import picocli.CommandLine;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.util.concurrent.Callable;

public class CoffeeMachine implements Callable<Void> {

  @Parameters(arity = "1", index = "0", description = "The type of the drink."
      + " (Tea, Coffee or Chocolate)")
  private String drinkType;

  @Parameters(arity = "1", index = "1", description = "The amount of money "
      + "given by the user")
  private Float money;

  @Parameters(arity = "0...1", index = "2", description = "The number of "
      + "sugars the user wants. (0, 1, 2)", defaultValue = "0")
  private Integer sugar;

  @Option(names = {"-e", "--extra-hot"}, required = false,
      description = "If the user wants to make the drink extra hot",
      defaultValue = "false")
  private Boolean extraHot;

  public static void main(String[] args) {
    CommandLine.call(new CoffeeMachine(), args);
  }

  @Override
  public Void call() {

    new MakeDrinkCommand().execute(
        new InputArguments(drinkType, money, sugar, extraHot),
        new CliOutput()
    );

    return null;
  }
}
