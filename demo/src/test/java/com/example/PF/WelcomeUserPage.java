package com.example.PF;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WelcomeUserPage {
    WebDriver driver;
    @FindBy(className="title")
    private WebElement welcomeTitle;
    
    @FindBy(css="[href=\"logout.htm\"]")
    private WebElement logout_link;

    public WelcomeUserPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    public String getWelcomeMessage(){
        return welcomeTitle.getText();
    }
    
    public void LogOutLink(){
        logout_link.click();
    }
}
