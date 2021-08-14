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
import pages.ContactsPage;
import pages.HeaderPage;
import pages.PaymentPage;

public class HeaderVerification {
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

    @Test(description = "Текст на странице Система скидок соответствует требованиям--discontSystemValidText")
    public void discontTextVerification() {
        HeaderPage headerPage = PageFactory.initElements(driver, HeaderPage.class);
        TextDataProvider textDataProvider = PageFactory.initElements(driver, TextDataProvider.class);
        headerPage.discontSystem(driver);
        softAssert.assertEquals(headerPage.discontSystemText.getText(), textDataProvider.discontSystemValidText);
    }

    @Test(description = "Заголовки на странице Оплата соответствуют требовниям--Payment titles")
    public void paymentTextTitleVerification() {
        HeaderPage headerPage = PageFactory.initElements(driver, HeaderPage.class);
        PaymentPage paymentPage = PageFactory.initElements(driver, PaymentPage.class);
        TextDataProvider textDataProvider = PageFactory.initElements(driver, TextDataProvider.class);
        headerPage.paymentClick(driver);
        softAssert.assertEquals(paymentPage.cashTitle.getText(), textDataProvider.cashTitle, "Cash title isn't valid:");
        softAssert.assertEquals(paymentPage.cardTitle.getText(), textDataProvider.cardTitle, "Card title isn't valid:");
        softAssert.assertEquals(paymentPage.cryptoTitle.getText(), textDataProvider.cryptoTitle, "Crypto title isn't valid:");
        softAssert.assertEquals(paymentPage.elMoneyTitle.getText(), textDataProvider.elMoneyTitle, "ElMoney title isn't valid:");
        softAssert.assertAll();
    }

    @Test(description = "Номера телефонов на странице Контакты соответствуют требовниям--Contact numbers")
    public void contactNumbersVerification() {
        HeaderPage headerPage = PageFactory.initElements(driver, HeaderPage.class);
        TextDataProvider textDataProvider = PageFactory.initElements(driver, TextDataProvider.class);
        ContactsPage contactsPage = PageFactory.initElements(driver, ContactsPage.class);
        headerPage.contactsClick(driver);
        softAssert.assertEquals(contactsPage.kyivstarNumber.getText(), textDataProvider.kyivstarNumber, "Kyivstar number isn't valid:");
        softAssert.assertEquals(contactsPage.vodafoneNumber.getText(), textDataProvider.vodafoneNumber, "Vodafone number isn't valid:");
        softAssert.assertEquals(contactsPage.viberNumber.getText(), textDataProvider.viberNumber, "Viber number isn't valid:");
        softAssert.assertEquals(contactsPage.telegramNumber.getText(), textDataProvider.telegramNumber, "Telegram number isn't valid:");
        softAssert.assertAll();
    }

    @Test(description = "Проверка текста поп-ап сообщения: Украинская версия в разработке")
    public void ukrLangButton() {
        HeaderPage headerPage = PageFactory.initElements(driver, HeaderPage.class);
        TextDataProvider textDataProvider = PageFactory.initElements(driver, TextDataProvider.class);
        headerPage.ukrButtonClick(driver);
        assertion.assertEquals(headerPage.ukrLangMessagePopUp.getText(), textDataProvider.ukrLangMessagePopUp, "Ukr Lang message text isn't valid:");
    }

    @AfterTest
    public void shutDownDriver() {
        driver.close();
    }
}
