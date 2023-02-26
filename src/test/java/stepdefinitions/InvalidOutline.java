package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.devtools.v85.network.model.DataReceived;
import pages.SaucePage;
import utilities.ConfigReader;
import utilities.Driver;

public class InvalidOutline {
    SaucePage saucePage=new SaucePage();
    @And("hatali {string} ve {string} girer")
    public void hataliVeGirer(String arg0, String arg1) {
        saucePage.username.sendKeys(arg0);
        saucePage.password1.sendKeys(arg1);
        Driver.waitBasic(2);
    }

    @Then("login olmak icin butona tiklar")
    public void loginOlmakIcinButonaTiklar() {
        saucePage.login.click();
        Driver.waitBasic(2);
    }


}
