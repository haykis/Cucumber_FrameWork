package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.SaucePage;
import utilities.ConfigReader;
import utilities.Driver;

public class LoginSteps {
    SaucePage saucePage=new SaucePage();
    @Given("Kullanici login sayfasina gider")
    public void kullaniciLoginSayfasinaGider() {
        Driver.getDriver().get(ConfigReader.getProperty("demo"));
    }

    @When("Kullanici adi sifreyi girer")
    public void kullaniciAdiSifreyiGirer() {
        saucePage.username.sendKeys(ConfigReader.getProperty("username"));
        saucePage.password1.sendKeys(ConfigReader.getProperty("password"));
    }

    @And("Login butonuna tiklar")
    public void loginButonunaTiklar() {
        saucePage.login.click();
    }

    @Then("Aanasayfaya yonlendirilir")
    public void aanasayfayaYonlendirilir() {
        Assert.assertEquals("PRODUCTS",saucePage.product.getText());
    }

    @When("Kullanici gecersiz bir username ve sifre girer")
    public void kullaniciGecersizBirUsernameVeSifreGirer() {
        saucePage.username.sendKeys("username");
        saucePage.password1.sendKeys("password");
        saucePage.login.click();
    }

    @Then("Kullanici hata mesaji alir")
    public void kullaniciHataMesajiAlir() {

        Assert.assertTrue(saucePage.eror.isDisplayed());
    }

}
