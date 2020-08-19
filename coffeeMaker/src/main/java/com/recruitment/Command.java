package com.recruitment;

public interface Command {

  void execute(Input input, Output out);
  
  void getSaleStatus(Output out);

}
