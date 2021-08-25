package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultPage {
    @FindBy(xpath = "/html/body/div[2]/div/div/div/div/div[2]/div/main/div[4]/div[7]/a[4]")
    public WebElement addToBasketLittleImg;

    @FindBy(xpath = "//*[@id=\"pp-n-1\"]/div/div/div")
    public WebElement successfullyAddedMessage;

    @FindBy(xpath = "/html/body/div[2]/div/div/div/div/div[2]/div/main/div[4]/div[5]/a")
    public WebElement buyNowButton;

}
