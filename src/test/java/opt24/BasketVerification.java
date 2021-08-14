package opt24;

import dataProviders.TextDataProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;
import pages.BasketPage;
import pages.HeaderPage;
import pages.SearchResultPage;

import java.util.concurrent.TimeUnit;

public class BasketVerification {
    private WebDriver driver;
    public SoftAssert softAssert = new SoftAssert();
    Assertion assertion = new Assertion();

    @BeforeTest
    public void startDriver() {
        System.setProperty("webdriver.chrome.driver", "src/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.opt24.org/");
        driver.manage().window().maximize();
    }

    @Test (description = "Проверка, что товар добавляется в корзину")
    public void addToBasket(){
        HeaderPage headerPage = PageFactory.initElements(driver, HeaderPage.class);
        TextDataProvider textDataProvider = PageFactory.initElements(driver, TextDataProvider.class);
        SearchResultPage searchResultPage=PageFactory.initElements(driver, SearchResultPage.class);
        BasketPage basketPage=PageFactory.initElements(driver, BasketPage.class);
        headerPage.searchSubmit(driver, textDataProvider.element120);
        headerPage.searchButton.click();
        searchResultPage.addToBasketLittleImg.click();
        softAssert.assertEquals(searchResultPage.successfullyAddedMessage.getText(), textDataProvider.elementIsAddedToBasketMessage, "Pop-up message of adding element to basket is wrong:");
        headerPage.basketButton.click();
        softAssert.assertEquals(basketPage.titleOfelementBasket.getText(), textDataProvider.element120, "Title of added element doesn't correspond to located in basket:");
    }

    @Test (description = "Проверка, что товар удаляется из корзины")
    public void deleteFromBasket() {
        HeaderPage headerPage = PageFactory.initElements(driver, HeaderPage.class);
        TextDataProvider textDataProvider = PageFactory.initElements(driver, TextDataProvider.class);
        SearchResultPage searchResultPage=PageFactory.initElements(driver, SearchResultPage.class);
        BasketPage basketPage=PageFactory.initElements(driver, BasketPage.class);
        headerPage.searchSubmit(driver, textDataProvider.element120);
        headerPage.searchButton.click();
        searchResultPage.buyNowButton.click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        basketPage.deleteitemButton.click();
        softAssert.assertEquals(basketPage.getBackButton.getText(), textDataProvider.getBackButtonText, "Button has wrong name after deliting item from basket:");
        softAssert.assertEquals(basketPage.resultPrice.getText(), "-", "Result price is displayed after item was deleted:");
        softAssert.assertEquals(basketPage.retailPrice.getText(), "-", "Retail price is displayed after item was deleted:");
        softAssert.assertEquals(basketPage.discontPrice.getText(), "-", "Discont price is displayed after item was deleted:");
    }

    @Test(description = "Проверка, что корзина очищается")
    public void basketCleanUp(){
        HeaderPage headerPage = PageFactory.initElements(driver, HeaderPage.class);
        TextDataProvider textDataProvider = PageFactory.initElements(driver, TextDataProvider.class);
        SearchResultPage searchResultPage=PageFactory.initElements(driver, SearchResultPage.class);
        BasketPage basketPage=PageFactory.initElements(driver, BasketPage.class);
        headerPage.searchSubmit(driver, textDataProvider.element120);
        headerPage.searchButton.click();
        searchResultPage.buyNowButton.click();
        basketPage.cleanUpBasketButton.click();
        assertion.assertEquals(basketPage.cleanedBasketMessage.getText(), textDataProvider.cleanedBasketMessage, "Item wasn't deleted:");
    }

    @AfterTest
    public void shutDownDriver() {
        driver.close();
    }
}
