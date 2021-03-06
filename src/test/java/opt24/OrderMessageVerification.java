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
import pages.BasketPage;
import pages.HeaderPage;
import pages.SearchResultPage;


public class OrderMessageVerification extends DAO{
    private WebDriver driver;
    Assertion assertion = new Assertion();

    @Override
    @BeforeTest
    public void startDriver() {
        System.setProperty("webdriver.chrome.driver", "src/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.opt24.org/");
        driver.manage().window().maximize();
    }

    @Test (description = "Минимальная сумма заказа 150 грн")
    @Description("Apropriate messahe appears when final price is less than 150 uah")
    @Story("minOrderPrice")
    public void minOrderPrice(){
        HeaderPage headerPage = PageFactory.initElements(driver, HeaderPage.class);
        TextDataProvider textDataProvider = PageFactory.initElements(driver, TextDataProvider.class);
        SearchResultPage searchResultPage=PageFactory.initElements(driver, SearchResultPage.class);
        BasketPage basketPage=PageFactory.initElements(driver, BasketPage.class);
        headerPage.searchSubmit(driver, textDataProvider.element120);
        headerPage.searchButton.click();
        searchResultPage.buyNowButton.click();
        assertion.assertEquals(basketPage.minPriceMessage.getText(), textDataProvider.minPriceMessage, "Min price order message is wrong:");
    }

    @Test(description = "Сумма заказа больше 150, но не 3 элемента")
    @Description("Apropriate messahe appears when final price is bigger than 150 uah but added items less than 3")
    @Story("treeItemsOrderMessage")
    public void treeItemsOrderMessage(){
        HeaderPage headerPage = PageFactory.initElements(driver, HeaderPage.class);
        TextDataProvider textDataProvider = PageFactory.initElements(driver, TextDataProvider.class);
        SearchResultPage searchResultPage=PageFactory.initElements(driver, SearchResultPage.class);
        BasketPage basketPage=PageFactory.initElements(driver, BasketPage.class);
        headerPage.searchSubmit(driver, textDataProvider.element354);
        headerPage.searchButton.click();
        searchResultPage.buyNowButton.click();
        assertion.assertEquals(basketPage.treeItemsOrderMessage.getText(), textDataProvider.treeItemsOrderMessage, "Tree items in basket message is wrong:");
    }

    @Test(description = "Сумма заказа больше 300, но меньше 3000 грн")
    @Description("Apropriate messahe appears when final price is bigger 300 uah but less 3000 uah")
    @Story("orderBetween300And3000")
    public void orderBetween300And3000(){
        HeaderPage headerPage = PageFactory.initElements(driver, HeaderPage.class);
        TextDataProvider textDataProvider = PageFactory.initElements(driver, TextDataProvider.class);
        SearchResultPage searchResultPage=PageFactory.initElements(driver, SearchResultPage.class);
        BasketPage basketPage=PageFactory.initElements(driver, BasketPage.class);
        headerPage.searchSubmit(driver, textDataProvider.element354);
        headerPage.searchButton.click();
        searchResultPage.addToBasketLittleImg.click();
        headerPage.searchSubmit(driver, textDataProvider.element120);
        headerPage.searchButton.click();
        searchResultPage.addToBasketLittleImg.click();
        headerPage.searchSubmit(driver, textDataProvider.element160);
        headerPage.searchButton.click();
        searchResultPage.buyNowButton.click();
        assertion.assertEquals(basketPage.orderMessageBetween300And3000.getText(), textDataProvider.orderMessageBetween300And3000, "Order between 300 and 3000 is wrong:");
    }

    @Override
    @AfterTest
    public void shutDownDriver() {
        driver.close();
    }
}
