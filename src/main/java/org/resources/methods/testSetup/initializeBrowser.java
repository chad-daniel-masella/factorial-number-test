package org.resources.methods.testSetup;

import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.BrowserType;
import org.resources.methods.pageObjectMethods.pageMethods;

public class initializeBrowser extends pageMethods {

    /**
     * The idea here is to move all setup methods (instantiating the browser and configurations)
     * This is not done at the moment, but can be completed in the next iteration
     */
    public static void initializeChromeBrowser(boolean isHeadless) {
        Playwright pw = Playwright.create();
        browser = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(isHeadless).setSlowMo(50));
        browserContext = browser.newContext(new Browser.NewContextOptions().setViewportSize(1800, 880));
        page = browserContext.newPage();
    }

}
