package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.Driver;

public class Hooks {
    static int stepCount;

    public Hooks() {
    }

    @Before
    public void setup() {
        // TestNG'deki @BeforeMethod gibi çalışır.
        // Her senaryodan önce çalışır.
        //System.out.println("setUp calisti.");
        //Driver.getDriver();
    }

    @After
    public void teardown(Scenario scenario) {
        System.out.println("tearDown calisti.");
        // ekran görüntüsü almak için bu sabit kodu kullanabiliriz.
        // eğer senaryonun sonucu FAILED ise(başarısızsa) ekran görüntüsünü rapora ekleyebilirsin.
        byte[] picture;
        if (scenario.isFailed()) {
            picture = (byte[])((TakesScreenshot)Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(picture, "image/png", "failed" + scenario.getName());
        } else {
            picture = (byte[])((TakesScreenshot)Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(picture, "image/png", "passed" + scenario.getName());
        }

        //Driver.closeDriver();
    }

    @AfterStep //method sayisi
    public void makeSlowRunning() throws InterruptedException {
        Driver.waitBasic(2);
        ++stepCount;
        System.out.println(stepCount + ". STEP");
    }
}
// Aldığımız SCREENSHOT'lar çok fazla yer kaplar.
// Onun için bu resimler GitHub'a Push edilmemelidir.
// Bunu şu şekilde yaparız;
// test-output klasörüne sağ tıklayıp en aşağıdaki 'Git' seçeneğine gelinir ve 'Add to .gitignore' seçilir.
// Karşınıza çıkan diğer sorulara da olumlu cevap verebilirsiniz.
// Böylece GitHub hesabına push etseniz bile resimler yollanmaz. Bunu istediğiniz diğer klasörlere de yapabilirsiniz.
