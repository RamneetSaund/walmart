package stepDefinitions;

import cucumber.api.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.PropertiesReader;

import java.io.File;
import java.util.UUID;

public class TestBase {

    private static WebDriver driver;

    public TestBase() {

    }

    public static WebDriver getDriver(){
        return driver;
    }

    public static WebDriver init() {
        PropertiesReader propertiesReader = new PropertiesReader();
        String userDir = System.getProperty("user.dir");
        String driverPath = userDir + "\\src\\test\\resources\\drivers\\";
        switch(propertiesReader.getBrowser().toLowerCase()){
            case "chrome":
            default:
                System.setProperty("webdriver.chrome.driver", driverPath + "chromedriver.exe");
                driver = new ChromeDriver();
        }
        driver.manage().window().maximize();
        driver.navigate().to(propertiesReader.getBaseUrl());
        return driver;
    }

    public String getCurrentUrl(){
        return getDriver().getCurrentUrl();
    }

    public static void tearDown() {
        getDriver().quit();
    }

    public static void takeScreenshot(Scenario scenario) {
        if (scenario.isFailed()) {
            try {
                String screenshotName = UUID.randomUUID().toString();
                TakesScreenshot ts = (TakesScreenshot) getDriver();
                byte[] screenshotBytes = ts.getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenshotBytes, "image/png");
                File sourcePath = ts.getScreenshotAs(OutputType.FILE);
                String userDir = System.getProperty("user.dir");
                String screenshotPath = userDir + "\\target\\cucumber-report\\screenshots\\";
                File destinationPath = new File( screenshotPath + screenshotName + ".png");
                FileUtils.copyFile(sourcePath, destinationPath);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void goToHomePage(){
        getDriver().navigate().to(new PropertiesReader().getBaseUrl());
    }

}
