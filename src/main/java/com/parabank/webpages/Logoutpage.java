package com.parabank.webpages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class Logoutpage extends Basepage{
    private final WebDriver driver;
    public Logoutpage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//a[contains(text(),'Log Out')]")
    public WebElement logoutLink;

    @FindBy(css = "img.logo")
    public WebElement homePageLogo;

    public void clickLogoutLink(){
        logoutLink.click();

    }

}