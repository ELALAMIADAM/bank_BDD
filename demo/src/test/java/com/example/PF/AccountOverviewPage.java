package com.example.PF;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountOverviewPage {
    WebDriver driver;

    @FindBy (css="[id=\"showOverview\"] h1")
    private WebElement title_account;

    public AccountOverviewPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
        
    }

    public String getTitle(){
        return title_account.getText();
    }
}
