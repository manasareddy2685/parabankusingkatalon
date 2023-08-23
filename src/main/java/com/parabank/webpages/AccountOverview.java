package com.parabank.webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;

import static utilities.GenericMethods.*;

public class AccountOverview extends Basepage {
    public AccountOverview(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
             @FindBy(xpath = "//a[contains(text(),'Accounts Overview')]")
                public WebElement  overviewLink;
               @FindBy(css="h1.title")
                  public WebElement AccountsuccessOverview;

       public void OverviewInfo(HashMap < String, String > projectDetails) throws InterruptedException {

          elementClick(overviewLink);

         System.out.println("Accounts Overview");
    }

}

