package com.recruitment;

public class CliOutput implements Output {

  @Override
  public void run(String message) {
    System.out.println(message);
  }
}
