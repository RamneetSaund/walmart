package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import stepDefinitions.TestBase;

import java.time.Duration;

public class Utils {

    private static final Logger LOG = LoggerFactory.getLogger(Utils.class);

    public static WebElement waitForElementToBeVisible(By locator, int timeout){
        WebDriverWait webDriverWait = new WebDriverWait(TestBase.getDriver(), timeout, 100L);
        try {
            WebElement elem = webDriverWait.pollingEvery(Duration.ofSeconds(2L)).withTimeout(Duration.ofSeconds(timeout))
                    .ignoring(NoSuchElementException.class).ignoring(StaleElementReferenceException.class)
                    .until(ExpectedConditions.visibilityOfElementLocated(locator));
            return elem;
        } catch (Exception var4) {
            LOG.info("Can\'t find element in " + timeout + " seconds: ");
            var4.printStackTrace();
            return null;
        }
    }

    public static boolean waitForElementToBeVisible(WebElement element, int timeout){
        return waitAndGetElementAfterVisible(element, timeout) != null;
    }

    public static WebElement waitAndGetElementAfterVisible(WebElement element, int timeout){
        WebDriverWait webDriverWait = new WebDriverWait(TestBase.getDriver(), timeout, 100L);
        try {
            WebElement elem = webDriverWait.pollingEvery(Duration.ofSeconds(2L)).withTimeout(Duration.ofSeconds(timeout))
                    .ignoring(NoSuchElementException.class).ignoring(StaleElementReferenceException.class)
                    .until(ExpectedConditions.visibilityOf(element));
            return elem;
        } catch (Exception var4) {
            LOG.info("Can\'t find element in " + timeout + " seconds: ");
            var4.printStackTrace();
            return null;
        }
    }

    public static WebElement waitAndGetElementAfterVisible(WebElement element){
        int timeout = new PropertiesReader().getElementTimeout();
        return waitAndGetElementAfterVisible(element, timeout);
    }

    public static boolean isDisplayed(WebElement element){
        try{
            boolean visible = element.isDisplayed();
            return visible;
        } catch (Exception e){
            LOG.info("Can\'t find element");
            e.printStackTrace();
            return false;
        }
    }

    public static boolean isEnabled(WebElement element){
        try{
            boolean enabled = element.isEnabled();
            return enabled;
        } catch (Exception e){
            LOG.info("Can\'t find element");
            e.printStackTrace();
            return false;
        }
    }

}
