package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.sql.*;

public class DbSorgusu {
    String dbUrl="jdbc:postgresql://localhost:5432/school";
    String dbUserName="postgres";
    String dbPassword="Ekim2020";

    Connection connection;
    Statement statement;
    ResultSet resultSet;

    @Given("DB ile baglanti kurar")
    public void dbIleBaglantiKurar() throws SQLException {
        connection = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
        statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
    }

    @When("Verileri getiririr")
    public void verileriGetiririr() throws SQLException {
        resultSet=statement.executeQuery("select*from school1");
    }

    @Then("testlerini yapar")
    public void testleriniYapar() throws SQLException {
        int rowcount=0;
        while (resultSet.next()){
            rowcount++;
        }
        System.out.println("rowcount = " + rowcount);
        resultSet.first();
        System.out.println("resultSet.getString(1) = " + resultSet.getString(2));//ilk satirda 2. stunu st getir
        System.out.println("resultSet.getString(\"id\") = " + resultSet.getString("id"));// ilk satirda id stununu st getir
        resultSet.last();
        System.out.println("resultSet.getInt(1) = " + resultSet.getInt(1));//son satirda 1. stunu int getir
        resultSet.absolute(2);
        System.out.println("resultSet.getStr(2) = " + resultSet.getString(2));//2. satirda 2.  stundaki stringi getir

        System.out.println("resultSet.findColumn(\"id\") = " + resultSet.findColumn("id")); //id kacinci stun, 1
    }
}
