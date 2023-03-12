package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import utilities.DbConnect;

import java.sql.DriverManager;
import java.sql.SQLException;

public class DbHomeWork {
    @Given("DB ile baglanti kurulur")
    public void dbIleBaglantiKurulur() throws SQLException {
        DbConnect.connection = DriverManager.getConnection(DbConnect.dbUrl, DbConnect.dbUserName, DbConnect.dbPassword);
        DbConnect.statement = DbConnect.connection.createStatement(DbConnect.resultSet.TYPE_SCROLL_SENSITIVE, DbConnect.resultSet.CONCUR_UPDATABLE);
    }

    @When("Tablo ya gidilir")
    public void tabloYaGidilir() throws SQLException {
        DbConnect.resultSet=DbConnect.statement.executeQuery("select * from school1");
    }

    @Then("Tablodaki urun sayisi assert edelir")
    public void tablodakiUrunSayisiAssertEdelir() throws SQLException {
        int row=0;
        while (DbConnect.resultSet.next()){
            row++;
        }
        Assert.assertTrue(row==4);
    }

    @And("Tabloda fiyati en yuksek urun assert edilir")
    public void tablodaFiyatiEnYuksekUrunAssertEdilir() throws SQLException {
        DbConnect.resultSet=DbConnect.statement.executeQuery("select max(fiyat) from school1");
        DbConnect.resultSet.next();
        Assert.assertTrue(DbConnect.resultSet.getInt(1)==25);

    }

    @And("Urun isimlerinden birinin adi degistirirlir")
    public void urunIsimlerindenBirininAdiDegistirirlir() throws SQLException {
        DbConnect.resultSet=DbConnect.statement.executeQuery("select * from school1");
        DbConnect.resultSet=DbConnect.statement.executeQuery("update school1 set name='Kiv' where id=125");
        //update "public".school1 set name='Kivi' where id=125;
        System.out.println("DbConnect.resultSet.getString(2) = " + DbConnect.resultSet.getString(2));

    }

    @And("Urun fiyat ortalamasi yazdirirlir")
    public void urunFiyatOrtalamasiYazdirirlir() {
    }

    @And("Tablodaki sutunlarin isimleri farkli yazdirilir")
    public void tablodakiSutunlarinIsimleriFarkliYazdirilir() {
    }

    @And("Urun isimlerinin hepsi buyuk harf olacak sekilde yazdirilir")
    public void urunIsimlerininHepsiBuyukHarfOlacakSekildeYazdirilir() {
    }

    @And("Hepsi kucuk harf olacak sekilde yazdirilir")
    public void hepsiKucukHarfOlacakSekildeYazdirilir() {
    }

    @And("Birinci harfi buyuk olacak sekilde yazdirilir")
    public void birinciHarfiBuyukOlacakSekildeYazdirilir() {
    }

    @And("Belli bir fiyatin altindaki urunleri isme gore azalan olarak yazdirilir")
    public void belliBirFiyatinAltindakiUrunleriIsmeGoreAzalanOlarakYazdirilir() {
    }
}
