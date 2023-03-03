package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class TelerikPage {

    public TelerikPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy (xpath = "//button[@id='onetrust-accept-btn-handler']")
    public WebElement telerikcookies;

    @FindBy (xpath = "//a[@id='js-tlrk-nav-search-link']")
    public WebElement aramaicinklik;

    @FindBy (xpath = "//input[@class='TK-Tag-Input']")
    public WebElement aramaKutusu;

    @FindBy (xpath = "//button[@class='TK-Tag-Input-Button']")
    public WebElement aramaEnter;

    @FindBy (xpath = "(//h4[@class='TK-Search-Results-List-Item-H'])[1]")
    public WebElement urunadresi;

    @FindBy (xpath = "//button[@id='onetrust-accept-btn-handler']")
    public  WebElement getTelerikcookies2;

    @FindBy (xpath = "(//a[@class='TK-Menu-Item-Link'])[5]")
    public WebElement pricing;

    @FindBy (xpath = "(//a[@class='Btn Btn--prim4 u-db'])[1]")
    public WebElement pakketkiezen;

    @FindBy (xpath = "//span[@class='TK-Counter TK-Counter--SC TK-Counter--Visible']")
    public WebElement sepetsayisi;

}
