package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class CarvanaAutoLoanCalc {

    public CarvanaAutoLoanCalc(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = ".form-control:nth-child(2)")
    public WebElement carCostField;

    @FindBy(css = "[data-form-type*=loan]>:first-child>span")
    public WebElement carCostHeadingText;

    @FindBy(css = "[data-form-type*=loan]>:nth-child(2)>span")
    public WebElement creditScoreHeadingText;

    @FindBy(css = ".form-control[name*=credit]>:first-child")
    public WebElement creditScoreMenuButton;

    @FindBy(css = ".form-control[name*=credit]>:first-child")
    public WebElement excellentCreditButton;

    @FindBy(css = "[data-form-type*=loan]>:nth-child(3)>span")
    public WebElement loanTermHeadingText;

    @FindBy(css = "[data-form-type*=loan]>:nth-child(4)>span")
    public WebElement downPaymentHeadingText;

    @FindBy(css = ".form-control[name*=loan]")
    public WebElement loanTermMenu;

    @FindBy(css = ".form-control[name*=loan]>:nth-child(2)")
    public WebElement sixtyloanTermButton;

    @FindBy(css = ".form-control[name*=down]")
    public WebElement downPaymentField;

    @FindBy(css = "div[class$=value]")
    public WebElement monthlyPaymentAmount;

}
