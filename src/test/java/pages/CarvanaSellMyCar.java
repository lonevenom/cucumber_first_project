package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class CarvanaSellMyCar {

    public CarvanaSellMyCar() {PageFactory.initElements(Driver.getDriver(), this);}

    @FindBy(css = "div[class$=jwFVns]>:nth-child(2)")
    public WebElement firstHeading;

    @FindBy(css = "div[class$=jwFVns]>:last-child")
    public WebElement subHeading;

    @FindBy(css = "button[data-cv-test=VINToggle]")
    public WebElement vinButton;



    @FindBy(css = "input[type=text]")
    public WebElement vinSearchBox;

    @FindBy(css = "button[data-cv-test^=heroG]")
    public WebElement getMyOfferButton;













}
