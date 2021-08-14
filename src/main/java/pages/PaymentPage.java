package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaymentPage {
    @FindBy(xpath = "/html/body/div[2]/div/div/div/div/div[2]/div/main/div/div[2]/div[1]/h2")
    public WebElement cashTitle;

    @FindBy(xpath = "/html/body/div[2]/div/div/div/div/div[2]/div/main/div/div[2]/div[2]/h2")
    public WebElement cardTitle;

    @FindBy(xpath = "/html/body/div[2]/div/div/div/div/div[2]/div/main/div/div[2]/div[3]/h2")
    public WebElement cryptoTitle;

    @FindBy(xpath = "/html/body/div[2]/div/div/div/div/div[2]/div/main/div/div[2]/div[4]/h2")
    public WebElement elMoneyTitle;
}
