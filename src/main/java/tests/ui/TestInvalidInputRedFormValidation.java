package tests.ui;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.resources.methods.pageObjectMethods.pageMethods;

public class TestInvalidInputRedFormValidation extends pageMethods {

    String inputValToCalculateFactorial = "7.7";
    String expectedTextFormOutput = "Please enter an integer";

    @BeforeAll
    public static void initializeBrowser(){
        initializeChromeBrowser(false);
    }

    @Test
    void testInvalidInputRedFormValidation(){
        navigateToFactorialHomePageAndConfirmLanding();
        inputValueIntoFactorialCalculator(inputValToCalculateFactorial);
        clickCalculateButton();
        assertIntFactorialCalculatorResult(expectedTextFormOutput);
        confirmRedFormCss();

    }

    @AfterAll
    static void terminateBrowserWindows(){
        terminateBrowser();
    }

}
