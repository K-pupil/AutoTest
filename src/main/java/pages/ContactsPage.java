package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactsPage {
    @FindBy(xpath = "/html/body/div[2]/div/div/div/div/div[2]/div/main/div/div[2]/ul/li[1]/span[1]/a")
    public WebElement vodafoneNumber;

    @FindBy(xpath = "/html/body/div[2]/div/div/div/div/div[2]/div/main/div/div[2]/ul/li[1]/span[2]/a")
    public WebElement kyivstarNumber;

    @FindBy(xpath = "/html/body/div[2]/div/div/div/div/div[2]/div/main/div/div[2]/ul/li[2]/span/a")
    public WebElement viberNumber;

    @FindBy(xpath = "/html/body/div[2]/div/div/div/div/div[2]/div/main/div/div[2]/ul/li[3]/span/a")
    public WebElement telegramNumber;
}
