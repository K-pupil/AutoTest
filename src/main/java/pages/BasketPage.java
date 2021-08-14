package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BasketPage {

    @FindBy(xpath = "//*[@id=\"cart-item-808-808\"]/td[2]/div[2]/a")
    public WebElement titleOfelementBasket;

    @FindBy(xpath = "//*[@id=\"cart-item-808-808\"]/td[3]/div[2]")
    public WebElement deleteitemButton;

    @FindBy(xpath = "//*[@id=\"cart-item-808-808\"]/td[3]/div[3]")
    public WebElement getBackButton;

    @FindBy(xpath = "//*[@id=\"cart-item-808-808\"]/td[4]/div[1]")
    public WebElement resultPrice;

    @FindBy(xpath = "//*[@id=\"cart-item-808-808\"]/td[4]/div[2]")
    public WebElement retailPrice;

    @FindBy(xpath = "//*[@id=\"cart-item-808-808\"]/td[4]/div[3]")
    public WebElement discontPrice;

    @FindBy(xpath = "//*[@id=\"cart-order\"]/div[2]/div[1]/div[6]/a")
    public WebElement cleanUpBasketButton;

    @FindBy(xpath = "/html/body/div[2]/div/div/div/div/div[2]/div/main/div/div[2]")
    public WebElement cleanedBasketMessage;

    @FindBy(xpath = "//*[@id=\"cart-order\"]/div[2]/div[1]/div[2]")
    public WebElement minPriceMessage;

    @FindBy(xpath = "//*[@id=\"cart-item-748-748\"]/td[3]/div[1]/input")
    public WebElement amountOfItemsField;

    @FindBy(xpath = "//*[@id=\"cart-order\"]/div[2]/div[1]/div[4]")
    public WebElement treeItemsOrderMessage;

    @FindBy(xpath = "//*[@id=\"cart-order\"]/div[2]/div[1]/div[5]")
    public WebElement orderMessageBetween300And3000;





}
