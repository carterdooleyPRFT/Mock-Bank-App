import GUI.HomePage;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Application {

    private static Connection connection;

    public static void main(String[] args) throws SQLException {
        new HomePage();

        try {
            Properties prop = new Properties();

            String dbPropertiesFile = "src/main/JDBC/DBconfig.properties";

            FileReader fileReader = new FileReader(dbPropertiesFile);

            prop.load(fileReader);


            String dbDriverClass = prop.getProperty("db.driver.class");

            String dbConnUrl = prop.getProperty("db.conn.url");

            String dbUserName = prop.getProperty("db.username");

            String dbPassword = prop.getProperty("db.password");

            if (!"".equals(dbDriverClass) && !"".equals(dbConnUrl)) {
                /* Register jdbc driver class. */
                Class.forName(dbDriverClass);

                // Get database connection object.
                Connection dbConn = DriverManager.getConnection(dbConnUrl, dbUserName, dbPassword);

                // Get dtabase meta data.
                DatabaseMetaData dbMetaData = dbConn.getMetaData();

                // Get database name.
                String dbName = dbMetaData.getDatabaseProductName();

                // Get database version.
                String dbVersion = dbMetaData.getDatabaseProductVersion();

                System.out.println("Database Name : " + dbName);

                System.out.println("Database Version : " + dbVersion);


            } 


        } catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
