package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.EbayPage;
import utilities.ConfigReader;
import utilities.Driver;

public class EbayWin10 {
    EbayPage ebayPage=new EbayPage();
    @Given("Kullanici ebay sayfasina gider")
    public void kullaniciEbaySayfasinaGider() {
        Driver.getDriver().get(ConfigReader.getProperty("ebay"));
        Driver.waitBasic(3);
    }
    @When("Cookies leri kabul eder")
    public void cookiesLeriKabulEder() {
        Driver.waitIf(ebayPage.cookies,20);
       // ebayPage.cookies.click();
        Driver.waitBasic(2);
    }

    @And("Arama kutusuna computer yazar ve aratir")
    public void aramaKutusunaComputerYazarVeAratir() {
        ebayPage.searchBox.sendKeys("computer");
        ebayPage.aramaButonu.click();
        Driver.waitBasic(4);
    }

    @And("Cikan sayfada WinOn butanina tiklar")
    public void cikanSayfadaWinOnButaninaTiklar() {
        ebayPage.winOn.click();
        Driver.waitBasic(2);
        System.out.println("******************************");
    }

    @Then("En usstteki urunun WinOn ozelliklerinde oldugunu test eder")
    public void enUssttekiUrununWinOnOzelliklerindeOldugunuTestEder() {
        System.out.println("ebayPage.productlink.getText() = " + ebayPage.productlink.getText());
        Assert.assertTrue(ebayPage.productlink.getText().contains("Windows 10"));
    }
}
