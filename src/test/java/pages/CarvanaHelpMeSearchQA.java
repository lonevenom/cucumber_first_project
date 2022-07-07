package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

import java.util.List;

public class CarvanaHelpMeSearchQA {

    public CarvanaHelpMeSearchQA(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = "div[data-qa=headline]")
    public WebElement firstHeadLine;

    @FindBy(css = "div[data-qa=heading-container]>:nth-child(2)")
    public WebElement subHeading;


}