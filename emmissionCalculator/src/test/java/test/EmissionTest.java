package test;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

import com.sap.emissionCalculator.EmissionCalculator2;

public class EmissionTest{
	
	
	@Test
	public void testEmissionQty(){
		
		 ByteArrayOutputStream bytes = new ByteArrayOutputStream();
		 String params = "--start Los Angeles --end New York --transportation-method=medium-diesel-car";
	      PrintStream console = System.out;
	      try {
	         System.setOut(new PrintStream(bytes));
	         EmissionCalculator2.main(sanitiseInput(params));
	      } finally {
	         System.setOut(console);
	      }
	      System.out.println(bytes.toString());
	      assertEquals("test value"+System.getProperty("line.separator"), bytes.toString());
	   }
		
	



private String[] sanitiseInput(String rawInput) {
    // process the input and return each part of it in order in an array, something like:
    return rawInput.trim().split("[ \t]+");
}
	
}