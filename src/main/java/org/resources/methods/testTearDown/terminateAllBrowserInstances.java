package org.resources.methods.testTearDown;

import org.resources.methods.pageObjectMethods.pageMethods;

public class terminateAllBrowserInstances extends pageMethods {
    public static void terminateBrowsers(){
        page.close();
    }
}