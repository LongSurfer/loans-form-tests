import io.cucumber.testng.CucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.AfterClass;

import static ph.loans.TestBase.driver;

@CucumberOptions(features = "src/test/resources/scenarios/loans.feature", glue = {"ph.loans"})
public class RunCucumberTest extends AbstractTestNGCucumberTests {



    @AfterClass
    public void closeBrowser() {

        driver.quit();
    }
}