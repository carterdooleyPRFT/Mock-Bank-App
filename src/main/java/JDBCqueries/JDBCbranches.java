package JDBCqueries;

import java.io.FileReader;
import java.sql.*;
import java.util.Properties;

public class JDBCbranches {

    public void createBranchesTable() {
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

                Statement statement = dbConn.createStatement();
                statement.execute("CREATE TABLE IF NOT EXISTS branches" +
                        "(name TEXT, users TEXT, zipcode INTEGER)");

                statement.close();
                dbConn.close();


            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }


    }

    public void insertBranches(String branchName, int zipcode) {
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

                PreparedStatement statement = dbConn.prepareStatement("INSERT INTO branches (name, zipcode) VALUES(?, ?)");
                statement.setString(1, branchName);
                statement.setInt(2,zipcode);
                statement.executeUpdate();


                System.out.println("Branch " + branchName + " with zipcode " + zipcode + " successfully added");
                statement.close();
                dbConn.close();


            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }


    }

    public boolean getBranch (String name, int zipcode) {
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

                PreparedStatement statement = dbConn.prepareStatement("SELECT *  FROM branches WHERE zipcode =  '" + zipcode + "'");
                statement.execute();
                ResultSet result = statement.getResultSet();
                while(result.next()) {
                    String checkName = result.getString("name");
                    System.out.print("List of branch names:" + checkName);


                    if (checkName.equals(name)) {
                        System.out.println("Branch Already Exist");
                        statement.close();
                        dbConn.close();
                        return false;
                    }
                }



            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }


        return true;
    }






}
