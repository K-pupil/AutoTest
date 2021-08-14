package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

public class HeaderPage {

    @FindBy(xpath = "/html/body/header/div[1]/div/div/menu/li[1]/a")
    public WebElement discontSystemButton;

    @FindBy(xpath = "/html/body/div[2]/div/div/div/div/div[2]/div/main/div/div[2]")
    public WebElement discontSystemText;

    @FindBy(xpath = "/html/body/header/div[1]/div/div/menu/li[2]/a")
    public WebElement paymentButton;

    @FindBy(xpath = "/html/body/header/div[1]/div/div/menu/li[6]/a")
    public WebElement contactsButton;

    @FindBy(xpath = "/html/body/header/div[1]/div/div/div[2]/div[2]/a[1]")
    public WebElement ukrButton;

    @FindBy(xpath = "//*[@id=\"pp-n-1\"]/div/div/div")
    public WebElement ukrLangMessagePopUp;

    @FindBy(xpath = "//*[@id=\"story\"]")
    public WebElement searchField;

    @FindBy(xpath = "//*[@id=\"q_search\"]/div/button")
    public WebElement searchButton;

    @FindBy(xpath = "/html/body/header/div[2]/div/div/div[2]/div[2]/a[1]")
    public WebElement basketButton;


    public void searchSubmit(WebDriver driver, String  searchInput) {
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        searchField.sendKeys(searchInput);
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

    public void discontSystem(WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        discontSystemButton.click();
    }

    public void paymentClick(WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        paymentButton.click();
    }

    public void contactsClick(WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        contactsButton.click();
    }

    public void ukrButtonClick(WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        ukrButton.click();
    }
}