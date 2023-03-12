package utilities;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class DbConnect {
    public static String dbUrl="jdbc:postgresql://localhost:5432/school";
    public static String dbUserName="postgres";
    public static String dbPassword="Ekim2020";

    public static Connection connection;
    public static Statement statement;
    public static ResultSet resultSet;
}
