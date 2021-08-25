package opt24;

import dataProviders.TextDataProvider;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
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

public class BasketVerification extends DAO {
    private WebDriver driver;
    public SoftAssert softAssert = new SoftAssert();
    Assertion assertion = new Assertion();

    @Override
    @BeforeTest
    public void startDriver() {
        System.setProperty("webdriver.chrome.driver", "src/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.opt24.org/");
        driver.manage().window().maximize();
    }

    @Test (description = "Проверка, что товар добавляется в корзину")
    @Description("Item is added to basket. Title of added element corresponds to located in basket")
    @Story("addToBasket")
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
        softAssert.assertAll();
    }


    @Test(description = "Проверка, что корзина очищается")
    @Description("Basket is cleaned Up. Apropriate message appears")
    @Story("basketCleanUp")
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
    @Override
    @AfterTest
    public void shutDownDriver() {
        driver.close();
    }
}
