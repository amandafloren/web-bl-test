package page.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.utils.Function;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.text.SimpleDateFormat;

import static org.junit.Assert.assertTrue;


public class MicrositeStep {
    RemoteWebDriver driver;

    @Given("^User access the website")
    public void accessTheMicrosite() throws Throwable {
        try {
            //call chrome driver, should be latest stable version
            System.setProperty("webdriver.chrome.driver", "/Users/amandafloren/Downloads/chromedriver");
            driver = new ChromeDriver();
            driver.get("https://www.bukalapak.com/");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @When("^I click Login button at homepage")
    public void click_login_button(){
        WebElement loginBtn = driver.findElement(By.cssSelector("a.sigil-header__nav.te-header-login > p.pr-4.sigil-header__nav-action.bl-text.bl-text--body-small.bl-text--semi-bold"));
        loginBtn.click();
    }

    @And("^I input email (.*)")
    public void subtract(String email){
        WebElement phoneField = driver.findElement(By.xpath("//input[@id='user_identity_textfield']"));
        phoneField.sendKeys(email);
    }

    @And("^I click Next button")
    public void click_next_btn(){
        WebElement nextBtn = driver.findElement(By.xpath("//button[@id='submit_button']/span"));
        nextBtn.click();
    }

    @And("^I input password (.*)")
    public void input_pass(String cryptedPass){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='input-password']"))));
        WebElement inputPass = driver.findElement(By.xpath("//input[@id='input-password']"));
        inputPass.sendKeys(Function.decryptPass(cryptedPass));
    }

    @And("^I encrypt pass (.*)")
    public void encrypt_pass(String cryptPass){
        System.out.println(Function.encrypt(cryptPass));
        //inputPass.sendKeys(cryptedPass);
    }

    @And("^I click Login button")
    public void click_login(){
        WebElement loginBtn = driver.findElement(By.xpath("//button[@id='btn-login']/span"));
        loginBtn.click();
    }

    @And("^I (.*) successfully logged in to Bukalapak")
    public void verify_login(String nama){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("div.bl-avatar.sigil-avatar"))).click();
        String userCheck = driver.findElement(By.cssSelector("p.bl-text.bl-text--subheading-2 > a.bl-link.is-hide-underline")).getText();
        assertTrue(userCheck.contains(nama));
    }


}
