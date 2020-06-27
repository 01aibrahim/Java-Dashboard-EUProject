package dashboardcw;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Abdulrahman Ibrahim
 */
public class My_Database {
    
    //Declaring the variables we need to connect with our database.
    public static String serverName = "localhost";
    public static String username = "root";
    public static String databaseName = "users";
    public static Integer portNumConnection = 3307;
    public static String password = "";
    public static Date date;
    
   // UserLog loginTime = new UserLog();
    
   

    public static Connection getConnection() {
        
        Connection Database = null;
        MysqlDataSource data = new MysqlDataSource();

        data.setServerName(serverName);
        data.setUser(username);
        data.setPassword(password);
        data.setDatabaseName(databaseName);
        data.setPortNumber(portNumConnection);
        
        try {
            //Database = (Connection) data.getConnection();
            Database = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3307/users", username, password);
        } catch (SQLException ex) {
            Logger.getLogger("Try Connection..." + My_Database.class.getName()).log(Level.SEVERE, null, ex);
        }
            

        return Database;
    }

}

//References 
//The following references help me to understand how to use the xampp and connect the application with the 
//database.
//Pande, A. 2019. How to connect xampp mysql database with JDBC Netbeans Project. [Online]. [3 March 2020]. 
//Available from: https://digitalpadm.com/mysql-connector-java-connect-xampp-mysql-database-with-jdbc-netbeans/
