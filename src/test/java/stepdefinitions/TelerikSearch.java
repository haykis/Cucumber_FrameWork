package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import pages.TelerikPage;
import utilities.ConfigReader;
import utilities.Driver;

public class TelerikSearch {

    TelerikPage telerikPage = new TelerikPage();

    @Given("Kullanici telerik sitesine gider")
    public void kullaniciTelerikSitesineGider() {
        Driver.getDriver().get(ConfigReader.getProperty("telerik"));
    }
    @When("Telerik teki cookies leri kabul eder")
    public void telerikTekiCookiesLeriKabulEder() {
        try{
            Driver.waitIf(telerikPage.telerikcookies,20);
        }catch (Exception e){
            System.out.println("cookies ile karsilasilmadi");
        }
    }
    @And("Arama kutusu sayfasina gider")
    public void aramaKutusuSayfasinaGider() {
        Driver.waitIf(telerikPage.aramaicinklik, 20);
        Driver.waitBasic(10);
    }
    @Then("Arama kutusuna {string} yazar ve arama butonuna tiklar ve test eder")
    public void aramaKutusunaYazarVeAramaButonunaTiklarVeTestEder(String arg0) {
        telerikPage.aramaKutusu.sendKeys(arg0+ Keys.ENTER);
        Driver.waitBasic(10);
        String[] s = arg0.split(" ");
        String ilkKisim = s[0].toLowerCase();
        String ikinciKisim = s[1].toLowerCase();

        Assert.assertTrue(telerikPage.urunadresi.getText().toLowerCase().contains(ilkKisim));
        Assert.assertTrue(telerikPage.urunadresi.getText().toLowerCase().contains(ikinciKisim));
    }
}

