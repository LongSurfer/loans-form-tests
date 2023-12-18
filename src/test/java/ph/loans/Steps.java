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

import static ph.loans.TestBase.driver;


public class Steps {


    WebElement sliderValue = driver.findElement(By.xpath("//span[@role='needAmount']"));
    WebElement sliderAmountMinus = driver.findElement(By.xpath("//span[@role='sliderAmountMinus']"));
    WebElement sliderAmountPlus = driver.findElement(By.xpath("//span[@role='sliderAmountPlus']"));
    WebElement getFirstLoanButton = driver.findElement(By.xpath("//input[@role='takeMoneyMain']"));



    @When("Make sure the loan amount slider is displayed")
    public void makeSureTheLoanAmountSliderIsDisplayed() {
//        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
        sliderValue.isDisplayed();
    }

    @And("The default amount should be {string} PHP")
    public void theDefaultAmountShouldBePHP(String arg0) {
//        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
        String defaultTextOfSliderValue = sliderValue.getText();
        Assert.assertEquals(defaultTextOfSliderValue, arg0);
    }

    @And("Move the slider all the way to the left and press the minus button")
    public void moveTheSliderAllTheWayToTheLeftAndPressTheMinusButton() {
        sliderAmountMinus.click();
        sliderAmountMinus.click();
        sliderAmountMinus.click();
        sliderAmountMinus.click();
    }

    @Then("Make sure that the amount is displayed and is equal to {string} PHP")
    public void makeSureThatTheAmountIsDisplayedAndIsEqualToPHP(String arg1) {
//        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(3000));
        sliderValue.isDisplayed();
        String actualTextOfSliderValue = sliderValue.getText();
        Assert.assertEquals(actualTextOfSliderValue, arg1);
    }

    @When("Click on the 'Get First Loan' button")
    public void clickOnTheGetFirstLoanButton() {
//        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
        getFirstLoanButton.click();
    }

    @Then("Make sure that in the fields First Name, Middle Initial, Last Name and Mobile phone the warning 'This field is required' is appeared.")
    public void makeSureThatTheWarningThisFieldIsRequiredIsAppeared() {
//        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
        List<WebElement> warningMessage = driver
                .findElements(By.xpath("//span[text()='This field is required.']"));

        int countOfAttentionMessage = warningMessage.size();

        Assert.assertEquals(countOfAttentionMessage, 4);
        for (WebElement element : warningMessage) {
            Assert.assertTrue(element.isDisplayed());
        }
    }

    @And("Increase the loan amount to {string} PHP")
    public void increaseTheLoanAmount(String arg2) {
        sliderAmountPlus.click();
        sliderAmountPlus.click();
        sliderAmountPlus.click();
        sliderAmountPlus.click();
        String actualTextOfSliderValue = sliderValue.getText();
        Assert.assertEquals(actualTextOfSliderValue, arg2);
    }

    @Then("Make sure the 'Get First Loan' button is disabled")
    public void makeSureTheButtonIsDisabled() {
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
        Boolean checkGetFirstLoanButtonIsEnabled = getFirstLoanButton.isEnabled();
        Assert.assertEquals(checkGetFirstLoanButtonIsEnabled, false);
    }

}
