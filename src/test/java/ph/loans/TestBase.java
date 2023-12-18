package ph.loans;

import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class TestBase {
    public static WebDriver driver;

    static {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Given("Open the website {string}")
    public void openTheWebsite(String url) {

        driver.get(url);
    }




}
