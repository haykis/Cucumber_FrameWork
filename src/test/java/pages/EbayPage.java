package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class EbayPage {

    public EbayPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy (xpath = "//button[@id='gdpr-banner-accept']")
    public WebElement cookies;

    @FindBy (xpath = "//input[@id='gh-ac']")
    public WebElement searchBox;

    @FindBy (xpath = "//input[@id='gh-btn']")
    public WebElement aramaButonu;

    @FindBy (xpath = "(//a[@class='srp-carousel-list__item-link--truncated-small-item'])[1]")
    public WebElement winOn;

    @FindBy (xpath = "(//span[@role='heading'])[2]")
    public WebElement productlink;

}
