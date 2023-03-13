package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import utilities.DbConnect;
import utilities.DbConnect2;

import java.sql.DriverManager;
import java.sql.SQLException;

public class DbHomeWork2 {
    @Given("DB ile baglanti kuruluri")
    public void dbIleBaglantiKuruluri() throws SQLException {
        DbConnect2.connection = DriverManager.getConnection(DbConnect2.dbUrl, DbConnect2.dbUserName, DbConnect2.dbPassword);
        DbConnect2.statement=DbConnect2.connection.createStatement(DbConnect.resultSet.TYPE_SCROLL_SENSITIVE, DbConnect.resultSet.CONCUR_UPDATABLE);
    }

    @When("Tablo ya gidiliri")
    public void tabloYaGidiliri() throws SQLException {
        DbConnect2.resultSet=DbConnect2.statement.executeQuery("select * from pruduct");
    }

    @Then("Tablodaki urun sayisi assert edeliri")
    public void tablodakiUrunSayisiAssertEdeliri() throws SQLException {
        int row=0;
        while (DbConnect2.resultSet.next()){
            row++;
        }
        System.out.println("Satir sayisi = " + row);
        Assert.assertTrue(row==4);
    }

    @And("Tabloda fiyati en yuksek urun assert ediliri")
    public void tablodaFiyatiEnYuksekUrunAssertEdiliri() throws SQLException {
        DbConnect2.resultSet=DbConnect2.statement.executeQuery("select max(fiyat) from pruduct");
        DbConnect2.resultSet.next();
        Assert.assertTrue(DbConnect2.resultSet.getInt(1)==25);
    }

    @And("Urun isimlerinden birinin adi degistirirliri")
    public void urunIsimlerindenBirininAdiDegistirirliri() throws SQLException {
        DbConnect2.statement.executeUpdate("update pruduct set name='Kivi' where id=101");
        DbConnect2.resultSet=DbConnect2.statement.executeQuery("select * from pruduct");
        DbConnect2.resultSet.absolute(4);
        Assert.assertEquals(DbConnect2.resultSet.getString("name"),"Kivi");
    }

    @And("Urun fiyat ortalamasi yazdirirliri")
    public void urunFiyatOrtalamasiYazdirirliri() throws SQLException {
        DbConnect2.resultSet=DbConnect2.statement.executeQuery("select avg(fiyat) from pruduct");
        DbConnect2.resultSet.next();
        System.out.println("Ortalama Fiyat = " + DbConnect2.resultSet.getInt(1));
    }

    @And("Tablodaki sutunlarin isimleri farkli yazdiriliri")
    public void tablodakiSutunlarinIsimleriFarkliYazdiriliri() throws SQLException {
        DbConnect2.resultSet=DbConnect2.statement.executeQuery
                ("select id as kimliknosu, name as ismi, turu as cinsi, fiyat as maaliyeti from pruduct");

        DbConnect2.resultSet.next();
        System.out.println("Birinci satir id bilgisi = " + DbConnect2.resultSet.getString("kimliknosu"));
    }

    @And("Urun isimlerinin hepsi buyuk harf olacak sekilde yazdiriliri")
    public void urunIsimlerininHepsiBuyukHarfOlacakSekildeYazdiriliri() throws SQLException {
        DbConnect2.resultSet=DbConnect2.statement.executeQuery("select upper(name) from pruduct");
        while (DbConnect2.resultSet.next()){
            System.out.println("name bilgileri = " + DbConnect2.resultSet.getString(1));
        }
    }

    @And("Hepsi kucuk harf olacak sekilde yazdiriliri")
    public void hepsiKucukHarfOlacakSekildeYazdiriliri() throws SQLException {
        DbConnect2.resultSet=DbConnect2.statement.executeQuery("select lower(name) from pruduct");
        while (DbConnect2.resultSet.next()){
            System.out.println("Name kucuk harf = " + DbConnect2.resultSet.getString(1));
        }
    }

    @And("Birinci harfi buyuk olacak sekilde yazdiriliri")
    public void birinciHarfiBuyukOlacakSekildeYazdiriliri() throws SQLException {
        DbConnect2.resultSet=DbConnect2.statement.executeQuery("select initcap(name) from pruduct");

        while (DbConnect2.resultSet.next()){
            System.out.println("Bas harfi buyuk = " + DbConnect2.resultSet.getString(1));
        }
    }

    @And("Belli bir fiyatin altindaki urunleri isme gore azalan olarak yazdiriliri")
    public void belliBirFiyatinAltindakiUrunleriIsmeGoreAzalanOlarakYazdiriliri() throws SQLException {
        DbConnect2.resultSet=DbConnect2.statement.executeQuery("select * from pruduct where fiyat<25 order by 2 ASC");
        while (DbConnect2.resultSet.next()){
            System.out.println("name A dan Z ye = " + DbConnect2.resultSet.getString(2));
        }

    }
}
