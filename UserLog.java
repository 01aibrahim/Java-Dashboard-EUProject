package dashboardcw;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Abdulrahman Ibrahim
 */
public class UserLog {
    
    String LogoutDate = "";
    
    public UserLog(){
        this.LogoutDate = LogoutDate;
    }
    public UserLog(String LogoutDate){
        this.LogoutDate = LogoutDate;
    }
    public void LoggingTester() {
        
        PreparedStatement i;
        ResultSet y;
            //Query which will allow to insert the log in time of the users.
             String checkLogIn = "INSERT INTO `Users`(`LogInDate`)SELECT `LogInDate`WHERE `First_Name` =`Username`";
       try {
                    i = My_Database.getConnection().prepareStatement(checkLogIn);
                    i.setString(1,"26/09/97");
                    
                    
                    if (i.executeUpdate()!=0){
                        //Message if is successful 
                        JOptionPane.showMessageDialog(null,"Your Account Has Been created", "Successfull Reg",2);
                    } else {
                        JOptionPane.showMessageDialog(null,"Error", "Check Info",2);
                    }
                    
                } catch (SQLException ex) {
                    Logger.getLogger(Register_Page.class.getName()).log(Level.SEVERE, null, ex);
                }
       
    }

    public String getLogoutDate() {
        return LogoutDate;
    }

    public void setLogoutDate(String LogoutDate) {
        this.LogoutDate = LogoutDate;
    }

}   

    
    

