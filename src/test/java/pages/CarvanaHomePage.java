package pages;

import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.Hooks;
import utils.ActionsUtil;
import utils.Driver;
import utils.Waiter;

import java.util.List;

public class CarvanaHomePage{

    public CarvanaHomePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (css = "div[class*=HeaderMenustyles] >[data-qa*=menu]")
    public List<WebElement> mainMenuItemLinks; // 4

    @FindBy (css = "div[role=menu]>a[data-cv-test*=headerFinance]")
    public List<WebElement> financingMenuLinks; // 3


    public void clickMenuLink(String linkText){
        for(WebElement link : mainMenuItemLinks){
            if(link.getText().equals(linkText)){
                link.click();
                break;
            }
        }
    }

    public void hoverMenuLink(String linkText){
        for(WebElement link : mainMenuItemLinks){
            if(link.getText().equals(linkText)){
                new Actions(Hooks.driver).moveToElement(link).perform();
                break;
            }
        }
    }


    public void clickFinanceLink(String linkText){
        for(WebElement link : financingMenuLinks){
            if(link.getText().equals(linkText)){
                link.click();
                break;
            }
        }
    }


}