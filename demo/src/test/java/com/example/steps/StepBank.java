package com.example.steps;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.example.PF.AccountOverviewPage;
import com.example.PF.HomePage;
import com.example.PF.RegisterPage;
import com.example.PF.WelcomeUserPage;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;


public class StepBank {
    WebDriver driver;
    HomePage hp;
    RegisterPage rg;
    WelcomeUserPage wu;
    AccountOverviewPage ap;
    URL gridUrl;
    @Before 
    public void setUp(){
        try {
            gridUrl = new URL("http://selenium-hub:4444/wd/hub");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        ChromeOptions co = new ChromeOptions();
        driver = new RemoteWebDriver(gridUrl, co);
        hp = new HomePage(driver);
        rg = new RegisterPage(driver);
        wu = new WelcomeUserPage(driver);
        ap = new AccountOverviewPage(driver);
    }

    @After 
    public void tearDown(){
        driver.quit();
    }

    @Given("go to {string}")
    public void go_to(String s) {
        driver.get(s);
    }

    @When("Click the register button")
    public void Click_the_register_button() {
        hp.RegisterLink();
    }
    double randomnumber = Math.floor(Math.random()*1000);
    @When("Signing up with FirstName {string}, LastName {string}, Address {string}, city {string}, state {string}, zipcode {string}, phone {string}, SSN {string}, Username {string}, password {string}")
    public void Signing_up_with_FirstName_LastName_Address_city_state_zipcode_phone_SSN_Username_password(String s, String s2, String s3, String s4, String s5, String s6, String s7, String s8, String s9, String s10) {
        rg.FirstName(s);
        rg.LastName(s2);
        rg.Address(s3);
        rg.City(s4);
        rg.State(s5);
        rg.Zipcode(s6);
        rg.phoneNumber(s7);
        rg.SSN(s8);
        rg.Username(s9+randomnumber);
        rg.Password(s10+randomnumber);
        rg.repeatedPassword(s10+randomnumber);
    }

    @When("submit register")
    public void submit_register() {
        rg.RegisterSubmit();
    }
    
    @When("verify the welcome message")
    public void verify_the_welcome_message() {
        assertTrue(wu.getWelcomeMessage().contains("Welcome"));
    }
    @When("Click LogOut")
    public void Click_LogOut() {
        wu.LogOutLink();
    }
    
    
    @When("verify title login {string}")
    public void verify_title(String s) {
        assertEquals(s, hp.getMessageLogin());
    }

    @When("Enter Username {string} and password {string}")
    public void Enter_Username_and_password(String s, String s2) {
        hp.Login(s+randomnumber, s2+randomnumber);
    }
    
    
    
    
    @Then("Verify title {string}")
    public void Verify_title(String s) {
        assertEquals(s, ap.getTitle());
    }




}
