package com.recruitment;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(DataProviderRunner.class)
public class MakeDrinkCommandTest {

  @Mock
  private Output output;

  @Before
  public void setUp() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  @UseDataProvider("drinkCombinations")
  public void testCoffeeMachineReturnsExpectedOutputForCoffeeCombinations(
      Input input, String expectedMessage
  ) {
    new MakeDrinkCommand().execute(input, output);

    verify(output, times(1)).run(expectedMessage);
  }

  @DataProvider
  public static Object[][] drinkCombinations() {
    return new Object[][] {
        { new InputArguments("coffee", (float)1, 1, false), "You have ordered a coffee with 1 sugars (stick included)"},
        { new InputArguments("coffee", (float)1, 1, true), "You have ordered a coffee extra hot with 1 sugars (stick included)"},
        { new InputArguments("coffee", (float)1, 0, false), "You have ordered a coffee with 0 sugar"},
        { new InputArguments("coffee", (float)0.1, 1, false), "The coffee costs 0.5."},

        { new InputArguments("tea", (float)1, 1, false), "You have ordered a tea with 1 sugars (stick included)"},
        { new InputArguments("tea", (float)1, 1, true), "You have ordered a tea extra hot with 1 sugars (stick included)"},
        { new InputArguments("tea", (float)1, 0, false), "You have ordered a tea with 0 sugar"},
        { new InputArguments("tea", (float)0.1, 1, false), "The tea costs 0.4."},

        { new InputArguments("chocolate", (float)1, 1, false), "You have ordered a chocolate with 1 sugars (stick included)"},
        { new InputArguments("chocolate", (float)1, 1, true), "You have ordered a chocolate extra hot with 1 sugars (stick included)"},
        { new InputArguments("chocolate", (float)1, 0, false), "You have ordered a chocolate with 0 sugar"},
        { new InputArguments("chocolate", (float)0.1, 1, false), "The chocolate costs 0.6."},

        { new InputArguments("foo", (float)0.1, 1, false), "The drink type should be tea, coffee or chocolate."},
    };
  }

}
