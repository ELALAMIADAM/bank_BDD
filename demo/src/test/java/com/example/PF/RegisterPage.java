package com.example.PF;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
    WebDriver driver;
    @FindBy(id="customer.firstName")
    private WebElement FirstName; 

    @FindBy(id="customer.lastName")
    private WebElement LastName; 

    @FindBy(id="customer.address.street")
    private WebElement Address; 

    @FindBy(id="customer.address.city")
    private WebElement city; 

    @FindBy(id="customer.address.state")
    private WebElement state; 

    @FindBy(id="customer.address.zipCode")
    private WebElement zipcode; 

    @FindBy(id="customer.phoneNumber")
    private WebElement phone; 

    @FindBy(id="customer.ssn")
    private WebElement ssn; 

    @FindBy(id="customer.username")
    private WebElement Username; 

    @FindBy(id="customer.password")
    private WebElement password; 

    @FindBy(id="repeatedPassword")
    private WebElement repeatedPassword; 

    @FindBy(css="[value=\"Register\"]")
    private WebElement register_submit;

    public RegisterPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);

    }
    public void FirstName(String s){
        FirstName.sendKeys(s);
    }
    public void LastName(String s){
        LastName.sendKeys(s);
    }
    public void Address(String s){
        this.Address.sendKeys(s);
    }
    public void State(String s){
        state.sendKeys(s);
    }
    public void City(String s){
        city.sendKeys(s);
    }
    public void SSN(String s){
        ssn.sendKeys(s);
    }
    public void Zipcode(String s){
        zipcode.sendKeys(s);
    }
    public void phoneNumber(String s){
        phone.sendKeys(s);
    }
    public void Username(String s){
        Username.sendKeys(s);
    }
    public void Password(String s){
        password.sendKeys(s);
    }
    public void repeatedPassword(String s){
        repeatedPassword.sendKeys(s);
    }

    public void RegisterSubmit(){
        register_submit.click();
    }

}
