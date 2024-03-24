package cucumberOptions;


import commons.GlobalConstants;
import factoryBrowser.*;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.UnreachableBrowserException;

import java.util.concurrent.TimeUnit;

public class Hooks {
    private static WebDriver driver;
    private static final Logger log = Logger.getLogger(Hooks.class.getName());
    private static long longTimeout = GlobalConstants.getGlobalConstants().getLongTimeout();

    @Before
    public synchronized static WebDriver openAndQuitBrowser() {
        String browserName = System.getProperty("BROWSER");
        System.out.println("Browser name run by command line = " + browserName);

        if (driver == null) {
            try {

                if (browserName == null) {
                    // Get browser name from Environment Variable in OS
                    browserName = System.getenv("BROWSER");
                    if (browserName == null) {
                        // Set default browser
                        browserName = "CHROME";
                    }
                }

                BrowserList browser = BrowserList.valueOf(browserName);
                switch (browser){
                    case CHROME:
                        driver = new ChromeDriverManager().getBrowserDriver();
                        break;
                    case H_CHROME:
                        driver = new HeadlessChromeDriverManager().getBrowserDriver();
                        break;
                    case FIREFOX:
                        driver = new FireFoxDriverManager().getBrowserDriver();
                        break;
                    case H_FIREFOX:
                        driver = new HeadlessFireFoxDriverManager().getBrowserDriver();
                        break;
                    case EDGE:
                        driver = new EdgeDriverManager().getBrowserDriver();
                        break;
                    default:
                        throw new BrowserNotSupportedException(browserName);
                }
            } catch (WebDriverException e) {
                driver = new ChromeDriver();
            } finally {
                Runtime.getRuntime().addShutdownHook(new Thread(new BrowserCleanup()));
            }
            driver.get(GlobalConstants.getGlobalConstants().getPortalPageUrl());
            driver.manage().timeouts().implicitlyWait(longTimeout, TimeUnit.SECONDS);
        }
        return driver;
    }

    public static void close() {
        try {
            if (driver != null) {
                openAndQuitBrowser().quit();
                log.info("------------- Closed the browser -------------");
            }
        } catch (UnreachableBrowserException e) {
            System.out.println("Can not close the browser");
        }
    }

    private static class BrowserCleanup implements Runnable {
        @Override
        public void run() {
            close();
        }
    }
}
