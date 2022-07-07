package steps;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import pages.*;
import utils.ActionsUtil;
import utils.Driver;
import utils.Waiter;

public class CarvanaSteps {

    WebDriver driver;
    CarvanaHomePage carvanaHomePage;
    CarvanaHelpMeSearch carvanaHelpMeSearch;
    CarvanaHelpAndSupport carvanaHelpAndSupport;
    CarvanaHelpMeSearchQA carvanaHelpMeSearchQA;
    CarvanaSellMyCar carvanaSellMyCar;
    CarvanaAutoLoanCalc carvanaAutoLoanCalc;
    GetYourOfferPage getYourOfferPage;

    @Before
    public void setup(){
        driver = Driver.getDriver();
        carvanaHelpAndSupport = new CarvanaHelpAndSupport();
        carvanaHelpMeSearch = new CarvanaHelpMeSearch();
        carvanaHomePage = new CarvanaHomePage();
        carvanaHelpMeSearchQA = new CarvanaHelpMeSearchQA();
        carvanaSellMyCar = new CarvanaSellMyCar();
        carvanaAutoLoanCalc = new CarvanaAutoLoanCalc();
        getYourOfferPage = new GetYourOfferPage();
    }
    @When("user clicks on {string} menu item")
    public void userClicksOnMenuItem(String itemText) {
        if (itemText.equalsIgnoreCase("AUTO LOAN CALCULATOR")) {
            Waiter.pause(1);
            carvanaHomePage.clickFinanceLink(itemText);
        }
        Waiter.pause(1);
        carvanaHomePage.clickMenuLink(itemText);
    }

    @And("user should see {string} text")
    public void userShouldSeeText(String text) {
        switch (text) {
            case "WHAT CAR SHOULD I GET?":
                Assert.assertTrue(carvanaHelpMeSearch.firstHeading.isDisplayed());
                Assert.assertEquals(text, carvanaHelpMeSearch.firstHeading.getText());
                break;
            case "Car Finder can help! Answer a few quick questions to find the right car for you.":
                Assert.assertTrue(carvanaHelpMeSearch.secondHeading.isDisplayed());
                Assert.assertEquals(text, carvanaHelpMeSearch.secondHeading.getText());
                break;
            case "WHAT IS MOST IMPORTANT TO YOU IN YOUR NEXT CAR?":
                Assert.assertTrue(carvanaHelpMeSearchQA.firstHeadLine.isDisplayed());
                Assert.assertEquals(text, carvanaHelpMeSearchQA.firstHeadLine.getText());
                break;
            case "Select up to 4 in order of importance":
                Assert.assertTrue(carvanaHelpMeSearchQA.subHeading.isDisplayed());
                Assert.assertEquals(text, carvanaHelpMeSearchQA.subHeading.getText());
                break;
            case "GET A REAL OFFER IN 2 MINUTES":
                Assert.assertTrue(carvanaSellMyCar.firstHeading.isDisplayed());
                Assert.assertEquals(text, carvanaSellMyCar.firstHeading.getText());
                break;
            case "We pick up your car. You get paid on the spot.":
                Assert.assertTrue(carvanaSellMyCar.subHeading.isDisplayed());
                Assert.assertEquals(text, carvanaSellMyCar.subHeading.getText());
                break;
            case "We couldn’t find that VIN. Please check your entry and try again.":
                Waiter.pause(10);
                Assert.assertTrue(getYourOfferPage.vinNotFoundText.isDisplayed());
                Assert.assertEquals(text, getYourOfferPage.vinNotFoundText.getText());
                break;
            default:
                throw new NotFoundException("The paragraph text is not defined properly in the feature file!!!");
        }
    }

    @And("user should see {string} link")
    public void userShouldSeeLink(String text) {
        Assert.assertTrue(carvanaHelpMeSearch.tryCarFinderLink.isEnabled());
        Assert.assertEquals(text, carvanaHelpMeSearch.tryCarFinderLink.getText());
    }

    @When("user clicks on {string} link")
    public void userClicksOnLink(String arg0) {
        carvanaHelpMeSearch.tryCarFinderLink.click();
    }

    @When("user clicks on {string} button")
    public void userClicksOnButton(String text) {
        switch(text){
            case"VIN":
                carvanaSellMyCar.vinButton.click();
                break;
            case"GET MY OFFER":
                carvanaSellMyCar.getMyOfferButton.click();
                break;
            default:
                throw new NotFoundException("The button text is not defined properly in the feature file!!!");
        }
    }
    @And("user enters vin number as {string}")
    public void userEntersVinNumberAs(String key) {
        carvanaSellMyCar.vinSearchBox.sendKeys(key + Keys.ENTER);
    }

    @When("user hovers over on {string} menu item")
    public void user_hovers_over_on_menu_item(String linkText) {
        carvanaHomePage.hoverMenuLink(linkText);
    }


    @When("user enters {string} as {string}")
    public void userEntersAs(String text1, String text2) {
        switch (text1) {
            case "Cost of Car I want":
                Assert.assertTrue(carvanaAutoLoanCalc.carCostHeadingText.isDisplayed());
                Assert.assertEquals(text1, carvanaAutoLoanCalc.carCostHeadingText.getText());
                carvanaAutoLoanCalc.carCostField.click();
                carvanaAutoLoanCalc.carCostField.sendKeys(text2);
                break;
            case "What is Your Down Payment?":
                Assert.assertTrue(carvanaAutoLoanCalc.downPaymentHeadingText.isDisplayed());
                Assert.assertEquals(text1, carvanaAutoLoanCalc.downPaymentHeadingText.getText());
                carvanaAutoLoanCalc.downPaymentField.click();
                carvanaAutoLoanCalc.downPaymentField.sendKeys(text2);
                break;
            default:
                throw new NotFoundException("The text is not defined properly in the feature file!!!");
        }

    }

    @And("user selects {string} as {string}")
    public void userSelectsAs(String text1, String text2) {
        switch (text1) {
            case "What's Your Credit Score?":
                Assert.assertTrue(carvanaAutoLoanCalc.creditScoreHeadingText.isDisplayed());
                Assert.assertEquals(text1, carvanaAutoLoanCalc.creditScoreHeadingText.getText());
                carvanaAutoLoanCalc.creditScoreMenuButton.click();
                Assert.assertEquals(text2, carvanaAutoLoanCalc.excellentCreditButton.getText());
                carvanaAutoLoanCalc.excellentCreditButton.click();
                break;
            case "Choose Your Loan Terms":
                Assert.assertTrue(carvanaAutoLoanCalc.loanTermHeadingText.isDisplayed());
                Assert.assertEquals(text1, carvanaAutoLoanCalc.loanTermHeadingText.getText());
                carvanaAutoLoanCalc.loanTermMenu.click();
                Assert.assertEquals(text2, carvanaAutoLoanCalc.sixtyloanTermButton.getText());
                carvanaAutoLoanCalc.sixtyloanTermButton.click();
                break;
        }
    }

    @Then("user should see the monthly payment as {string}")
    public void userShouldSeeTheMonthlyPaymentAs(String text) {
        Assert.assertTrue(carvanaAutoLoanCalc.monthlyPaymentAmount.isDisplayed());
        Assert.assertEquals(text, carvanaAutoLoanCalc.monthlyPaymentAmount.getText());
    }
}
