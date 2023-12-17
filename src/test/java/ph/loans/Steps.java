package ph.loans;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class Steps {

    WebDriver driver = new ChromeDriver();
    private final WebElement sliderValue = driver.findElement(By.xpath("//span[@role='needAmount']"));
    private final String defaultTextOfSliderValue = sliderValue.getText();
    private final String actualTextOfSliderValue = sliderValue.getText();
    private final WebElement sliderAmountMinus = driver.findElement(By.xpath("//span[@role='sliderAmountMinus']"));
    private final WebElement sliderAmountPlus = driver.findElement(By.xpath("//span[@role='sliderAmountPlus']"));
    private final WebElement getFirstLoanButton = driver.findElement(By.xpath("//input[@role='takeMoneyMain']"));

    private final List<WebElement> warningMessage = driver
            .findElements(By.xpath("//span[text()='This field is required.']"));
    private final int countOfAttentionMessage = warningMessage.size();

    @When("Make sure the loan amount slider is displayed")
    public void makeSureTheLoanAmountSliderIsDisplayed() {
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
        sliderValue.isDisplayed();
    }

    @And("The default amount should be {int} PHP")
    public void theDefaultAmountShouldBePHP(int arg0) {
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
        Assert.assertEquals(defaultTextOfSliderValue, arg0);
    }

    @And("Move the slider all the way to the left and press the minus button")
    public void moveTheSliderAllTheWayToTheLeftAndPressTheMinusButton() {
        sliderAmountMinus.click();
        sliderAmountMinus.click();
        sliderAmountMinus.click();
        sliderAmountMinus.click();
    }

    @Then("Make sure that the amount is displayed and is equal to {int} PHP")
    public void makeSureThatTheAmountIsDisplayedAndIsEqualToPHP(int arg0) {
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
        sliderValue.isDisplayed();
        Assert.assertEquals(actualTextOfSliderValue, arg0);
    }

    @When("Click on the {string} button")
    public void clickOnTheGetFirstLoanButton() {
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
        getFirstLoanButton.click();
    }

    @Then("Make sure that in the fields First Name, Middle Initial, Last Name and Mobile phone the warning {string} is appeared.")
    public void makeSureThatTheWarningThisFieldIsRequiredIsAppeared() {
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
        Assert.assertEquals(countOfAttentionMessage, 4);
        for (WebElement element : warningMessage) {
            Assert.assertTrue(element.isDisplayed());
        }
    }

    @And("Increase the loan amount to {int} PHP")
    public void increaseTheLoanAmount() {
        sliderAmountPlus.click();
        sliderAmountPlus.click();
        sliderAmountPlus.click();
        sliderAmountPlus.click();
    }

    @Then("Make sure the {string} button is disabled")
    public void makeSureTheButtonIsDisabled() {
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
        Boolean checkGetFirstLoanButtonIsEnabled = getFirstLoanButton.isEnabled();
        Assert.assertEquals(checkGetFirstLoanButtonIsEnabled, false);
    }
}
