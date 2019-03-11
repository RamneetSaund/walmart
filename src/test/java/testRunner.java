import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import stepDefinitions.TestBase;

@RunWith(Cucumber.class)
@CucumberOptions(
        features="src/test/resources/Features",
        glue={"stepDefinitions"},
        plugin = {"io.qameta.allure.cucumber4jvm.AllureCucumber4Jvm", "pretty", "json:target/cucumber-report/report.json"}
)


public class testRunner {

    @BeforeClass
    public static void initialize() {
        TestBase.init();
    }

    @AfterClass
    public static void shutdown() {
        TestBase.tearDown();
    }

}
