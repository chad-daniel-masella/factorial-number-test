package tests.ui;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.resources.methods.pageObjectMethods.pageMethods;
public class TestFactorialOfSeven extends pageMethods {

    String inputValToCalculateFactorial = "7";
    String expectedTextFormOutput = "5040";

    @BeforeAll
    public static void initializeBrowser(){
        initializeChromeBrowser(false);
    }

    @Test
    void testFactorialOfSeven(){
        navigateToFactorialHomePageAndConfirmLanding();
        inputValueIntoFactorialCalculator(inputValToCalculateFactorial);
        clickCalculateButton();
        assertIntFactorialCalculatorResult(expectedTextFormOutput);

    }

    @AfterAll
    static void terminateBrowserWindows(){
        terminateBrowser();
    }

}
