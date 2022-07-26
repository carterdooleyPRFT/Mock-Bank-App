package JDBCqueries;

import User.User;

import javax.xml.transform.Result;
import java.io.FileReader;
import java.sql.*;
import java.util.Objects;
import java.util.Properties;

public class JDBCuser {




    public void createUserTable() {
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
                statement.execute("CREATE TABLE IF NOT EXISTS users" +
                        "(user_name TEXT NOT NULL, password TEXT, account_total DOUBLE PRECISION,branch_id INTEGER, FOREIGN KEY(branch_id) REFERENCES branches(branch_id))");

                statement.close();
                dbConn.close();


            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }


    }

    public void newUser(User newUser) {
        String userName = newUser.getUserName();
        String password = newUser.getPassWord();
        int branchID = newUser.getBranchID();
        double initTransaction = newUser.getInitialTransaction();
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

                PreparedStatement statement = dbConn.prepareStatement("INSERT INTO users (user_name, password, account_total, branch_id) VALUES(?, ?, ?, ?)");
                statement.setString(1,userName);
                statement.setString(2, password);
                statement.setDouble(3,initTransaction);
                statement.setInt(4, branchID);
                statement.executeUpdate();

                statement.close();
                dbConn.close();


            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }


    }

    public boolean loginUser(String username, String password) {
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

                PreparedStatement statement = dbConn.prepareStatement("SELECT password FROM users WHERE user_name =  '" + username.trim() + "'");
                statement.execute();
                ResultSet result = statement.getResultSet();
                result.next();
                String checkPassword = result.getString("password");

                statement.close();
                dbConn.close();

                if (Objects.equals(checkPassword, password)){
                    System.out.print("User " + username + " Logged in");
                        return true;
                    } else {
                        System.out.print("User not Found: Invalid password: " + checkPassword + " " + password);
                    }
                }



        } catch (Exception ex) {
            ex.printStackTrace();
        }


        return false;
    }





    public double getAccountBalance(String username) {


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

                PreparedStatement statement = dbConn.prepareStatement("SELECT account_total FROM users WHERE user_name =  '" + username.trim() + "'");
                statement.execute();
                ResultSet result = statement.getResultSet();
                result.next();
                double account_total = Double.parseDouble(result.getString("account_total"));
                statement.close();
                dbConn.close();
                return account_total;




            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }


        return 0;
    }




    public boolean getUser (String name) {
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

                PreparedStatement statement = dbConn.prepareStatement("SELECT *  FROM users");
                statement.execute();
                ResultSet result = statement.getResultSet();
                while(result.next()) {
                    String checkName = result.getString("user_name");
                    System.out.println("User: " + checkName);


                    if (checkName.equals(name)) {
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


    public void getUser () {
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

                PreparedStatement statement = dbConn.prepareStatement("SELECT *  FROM users");
                statement.execute();
                ResultSet result = statement.getResultSet();
                while(result.next()) {
                    String checkName = result.getString("user_name");
                    String checkBranchId = result.getString("branch_id");

                    System.out.println("Username: " + checkName + " Branch Id: " + checkBranchId);

                }



            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }


    public void dropUsersTable () {
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

                    PreparedStatement statement = dbConn.prepareStatement("DROP TABLE users");
                    statement.execute();




                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }


        }






}
