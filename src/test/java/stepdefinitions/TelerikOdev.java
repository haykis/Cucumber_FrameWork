package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.TelerikPage;
import utilities.ConfigReader;
import utilities.Driver;

public class TelerikOdev {
    TelerikPage telerikPage=new TelerikPage();

    @Given("ana sayfaya gider telerik")
    public void anaSayfayaGiderTelerik() {
        Driver.getDriver().get(ConfigReader.getProperty("telerik2"));
        Driver.waitBasic(10);
    }

    @When("cookiesleri kabul eder telerik")
    public void cookiesleriKabulEderTelerik() {
        try{
            Driver.waitIf(telerikPage.getTelerikcookies2,20);
        }
        catch (Exception e){
            System.out.println("cookieslerde sikinti var");
        }
    }

    @And("pricing butonuna tiklar")
    public void pricingButonunaTiklar() {
        Driver.waitIf(telerikPage.pricing,20);
    }

    @And("paket secipi yap sepete ekle")
    public void paketSecipiYapSepeteEkle() {
        Driver.waitIf(telerikPage.pakketkiezen,20);
    }

    @And("navigate ile geri gelir")
    public void navigateIleGeriGelir() {
        Driver.waitBasic(10);
        Driver.getDriver().navigate().back();
        Driver.waitBasic(10);
    }

    @Then("assert eder sepeti")
    public void assertEderSepeti() {
        String sepet =telerikPage.sepetsayisi.getText();
        int getTekst=Integer.parseInt(sepet);

        Assert.assertTrue(getTekst==1);

    }
}
