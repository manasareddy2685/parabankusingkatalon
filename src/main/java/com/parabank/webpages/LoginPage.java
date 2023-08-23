package com.parabank.webpages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends Basepage
{

  //  private WebElement waitForElementClickable;

    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(name="username")
    public WebElement usernameInput;

    @FindBy(name="password")
    public WebElement passwordInput;

    @FindBy(xpath="//input[@value='Log In']")
    public WebElement loginButton;

    @FindBy(xpath = "//div[@id='rightPanel']/div/div/h1")  //   //div[@id='rightPanel']/div/div/h
    public WebElement loginWelcomeHeader;

    @FindBy(xpath ="//div[@id='rightPanel']/h1")
    public WebElement loginErrorHeader;

    public void enterUsername(String userName){
        usernameInput.click();
        usernameInput.sendKeys(userName);
    }


    public void enterPassword(String loginPassword){
        passwordInput.click();
        passwordInput.sendKeys(loginPassword);
    }
    public void clickLoginButton(){

        loginButton.click();
    }
}


