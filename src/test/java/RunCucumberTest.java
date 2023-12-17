import io.cucumber.testng.CucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
@CucumberOptions(features = "src/test/resources/scenarios/loans.feature", glue = {"ph.loans"})
public class RunCucumberTest extends AbstractTestNGCucumberTests {
}