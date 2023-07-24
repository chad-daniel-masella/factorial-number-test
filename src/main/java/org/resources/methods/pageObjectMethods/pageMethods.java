package org.resources.methods.pageObjectMethods;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.resources.methods.testSetup.initializeBrowser;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class pageMethods {

    public static Browser browser;
    public static BrowserContext browserContext;
    public static Page page;

    public static String returnFactorialCalculatorUrl(){

        String propertyValToReturn;

        InputStream input = initializeBrowser.class.getClassLoader().getResourceAsStream("environmentConfig.properties");
        Properties prop = new Properties();
        if (input == null) {
            System.out.println("Sorry, unable to find config.properties");
        }
        //load a properties file from class path, inside static method
        try {
            prop.load(input);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //get the property value and print it out
        propertyValToReturn = prop.getProperty("factorial.calculator.homepage");
        System.out.println("[INFO]: FACTORIAL CALCULATOR URL TESTING AGAINST IS: " + propertyValToReturn);


        return propertyValToReturn;
    }

    public static void initializeChromeBrowser(boolean isHeadless) {
        Playwright pw = Playwright.create();
        browser = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(isHeadless).setSlowMo(50));
        browserContext = browser.newContext(new Browser.NewContextOptions().setViewportSize(1800, 880));
        page = browserContext.newPage();
    }

    public static void terminateBrowser(){
        browser.close();
    }


    public static void navigateToFactorialHomePageAndConfirmLanding(){
        page.navigate(returnFactorialCalculatorUrl());

        //assert that you have landed on the "Factorial" page
        assertThat(page.locator("//h1[text()='The greatest factorial calculator!']")).isVisible();
    }

    public static void pauseTestForSeconds(int seconds){
        /**
         * To allow to pause the execution of a test at a point during execution
         * Can be used for debugging purposes as well
         */

        try {
            Thread.sleep(seconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void inputValueIntoFactorialCalculator(String valToInput){
        page.locator("//input[@id='number']").fill(valToInput);

        pauseTestForSeconds(1);
    }

    public static void clickCalculateButton(){
        page.click("//button[@id='getFactorial']");
    }

    public static void assertIntFactorialCalculatorResult(String expectedResult){

        // factorial assertion (expected Vs actual)
        String factorialActualReturnVal = page.locator("//p[@id='resultDiv']").textContent();
        System.out.println("The actual factorial return string is ==== " + factorialActualReturnVal);

        String expectedTextOut = "The factorial of 7 is: " + expectedResult;

        assertThat(page.locator("//p[@id='resultDiv']")).containsText(expectedResult);

    }

    public static void confirmRedFormCss(){
        assertThat(page.locator("//input[@style='border: 2px solid red;'][@id='number']")).isVisible();
        assertThat(page.locator("//p[@style='color: rgb(255, 0, 0);'][text()='Please enter an integer']")).isVisible();
    }

    public static void getConsoleLogs(){
        page.onConsoleMessage(msg -> System.out.println(msg.text()));
    }

}
