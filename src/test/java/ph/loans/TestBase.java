package ph.loans;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {
    @Given("Open the website {string}")
    public void openTheWebsite(String url) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get(url);
    }

    @After
    public void closeBrowser() {
        WebDriver driver = new ChromeDriver();
        driver.quit();
    }

}
