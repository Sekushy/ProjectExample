package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    @FindBy(xpath = "/html/body/section[2]/div/div/div/input")
    private WebElement inputEmailField;

    @FindBy(xpath = "/html/body/section[2]/div/div/div/button")
    private WebElement elementSubmitButton;

    @FindBy(xpath = "/html/body/section[3]/div/div/div[1]/div/div/h3")
    private WebElement virtualHeader;

    @FindBy(xpath = "/html/body/section[3]/div/div/div[1]/div/div/a")
    private WebElement virtualReadMoreButton;

    @FindBy(xpath = "/html/body/section[3]/div/div/div[2]/div/div/a")
    private WebElement hybridReadMoreButton;


    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void inputValueInEmailField(String string) {
        inputEmailField.sendKeys(string);
    }

    public void clickOnSubmitButton() {
        elementSubmitButton.click();
    }

    public WebElement getVirtualHeader() {
        return virtualHeader;
    }

    public void clickOnReadMoreVirtual() {
        virtualReadMoreButton.click();
    }

    public void clickReadMoreHybrid() {
        hybridReadMoreButton.click();
    }
}
