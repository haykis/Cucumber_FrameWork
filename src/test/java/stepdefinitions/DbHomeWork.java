package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import utilities.DbConnect;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

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
        DbConnect.statement.executeUpdate("update school1 set name='Kivi' where id=125");
        DbConnect.resultSet=DbConnect.statement.executeQuery("select * from school1");
        DbConnect.resultSet.absolute(4);
        System.out.println("DbConnect.resultSet.getString(2) = " + DbConnect.resultSet.getString(2));
    }

    @And("Urun fiyat ortalamasi yazdirirlir")
    public void urunFiyatOrtalamasiYazdirirlir() throws SQLException {
        DbConnect.resultSet=DbConnect.statement.executeQuery("select avg(fiyat) from school1");
        DbConnect.resultSet.next();
        System.out.println("Ortalama Fiyat= " + DbConnect.resultSet.getString(1));
    }

    @And("Tablodaki sutunlarin isimleri farkli yazdirilir")
    public void tablodakiSutunlarinIsimleriFarkliYazdirilir() throws SQLException {
        DbConnect.resultSet=DbConnect.statement.executeQuery
                ("select id as numarasi, name as ismi, cinsi as turu, fiyat as maaliyeti from school1");
        DbConnect.resultSet.absolute(1);
        System.out.println("Birinci satirdaki name = " + DbConnect.resultSet.getString("ismi"));
    }

    @And("Urun isimlerinin hepsi buyuk harf olacak sekilde yazdirilir")
    public void urunIsimlerininHepsiBuyukHarfOlacakSekildeYazdirilir() throws SQLException {
        DbConnect.resultSet=DbConnect.statement.executeQuery("select upper(name) from school1");
        while (DbConnect.resultSet.next()){
            System.out.println(DbConnect.resultSet.getString(1));
        }
    }

    @And("Hepsi kucuk harf olacak sekilde yazdirilir")
    public void hepsiKucukHarfOlacakSekildeYazdirilir() throws SQLException {
        DbConnect.resultSet=DbConnect.statement.executeQuery("select lower(name) from school1");
        while (DbConnect.resultSet.next()){
            System.out.println(DbConnect.resultSet.getString(1));
        }
    }

    @And("Birinci harfi buyuk olacak sekilde yazdirilir")
    public void birinciHarfiBuyukOlacakSekildeYazdirilir() throws SQLException {
        DbConnect.resultSet=DbConnect.statement.executeQuery("select initcap(name) from school1");
        while (DbConnect.resultSet.next()){
            System.out.println(DbConnect.resultSet.getString(1));
        }
    }

    @And("Belli bir fiyatin altindaki urunleri isme gore azalan olarak yazdirilir")
    public void belliBirFiyatinAltindakiUrunleriIsmeGoreAzalanOlarakYazdirilir() throws SQLException {
        DbConnect.resultSet=DbConnect.statement.executeQuery("select * from school1 where fiyat<25 order by 2 ASC");
        while (DbConnect.resultSet.next()){
            System.out.println(DbConnect.resultSet.getString(2));
        }
    }
}
