package org.example;

import PageObjects.Hybrid;
import PageObjects.MainPage;
import dev.failsafe.internal.util.Assert;
import io.cucumber.java.After;
import io.cucumber.java.en.*;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.helpers.Util;

public class StepDefinitions {
    private WebDriver driver;
    ChromeOptions options = new ChromeOptions();
    MainPage mainPage;
    Hybrid hybrid;


    public StepDefinitions() {
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        mainPage = new MainPage(driver);
        hybrid = new Hybrid(driver);
    }

    @Given("I am on the main page")
    public void i_am_on_the_main_page() {
        driver.get("file:///Users/andraghici/Documents/Programming/Testing-Env/index.html");
    }

    @When("the email value of {string} is inputted")
    public void input_email_to_field(String string) {
        mainPage.inputValueInEmailField(string);
    }

    @When("the submit button is clicked")
    public void click_submit_button() {
        mainPage.clickOnSubmitButton();
    }

    @Then("the newsletter confirmation pop-up appears")
    public void theNewsletterConfirmationPopUpAppears() {
        driver.switchTo().alert().accept();
    }

    @When("I click the read more button for the virtual section")
    public void iClickTheReadMoreButtonForTheVirtualSection() {
        Utils.scrollToElement(driver, mainPage.getVirtualHeader());
        mainPage.clickOnReadMoreVirtual();
    }

    @Then("the {string} page opens")
    public void thePageOpens(String string) {
        Assertions.assertEquals(string, driver.getTitle());
    }

    @After
    public void cleanUp() {
        driver.quit();
    }

    @When("I click the read more button for the hybrid section")
    public void iClickTheReadMoreButtonForTheHybridSection() {
        Utils.scrollToElement(driver, mainPage.getVirtualHeader());
        mainPage.clickReadMoreHybrid();
    }

    @Then("the hybrid page opens")
    public void theHybridPageOpens() {
        Assertions.assertEquals("Hybrid", hybrid.getHybridHeaderText());
    }

}
