package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

import java.util.List;

public class CarvanaHelpMeSearch {

    public CarvanaHelpMeSearch() {PageFactory.initElements(Driver.getDriver(), this);}

    @FindBy(css = ".leftSide>h1")
    public WebElement firstHeading;

    @FindBy(css = ".leftSide>:nth-child(3)")
    public WebElement secondHeading;

    @FindBy(css = "a[data-qa=router-link]")
    public WebElement tryCarFinderLink;



}
