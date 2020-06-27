package dashboardcw;

/**
 *
 * @author Abdulrahma Ibrahim
 */

//This class will help me to store all the details from the database
//to an arraylist and then retrive them to a table in the managerDashboard.

public class managerUsersDetails {
    private int id;
    private String firstName;
    private String surname;
    private String username;
    private String password;
    private String mobileNo;
    private String gender;
    private String date;
    private String logoutDate;
    
    //This constractor will allow me to get all the data i need to store in the table manager.
    public managerUsersDetails( String Firstname, String Surname, String Username, String Password, String MobileNo, String Gender,String Date, String logoutDate){
        this.firstName = Firstname;
        this.surname = Surname;
        this.username = Username;
        this.password = Password;
        this.mobileNo = MobileNo;
        this.gender = Gender;
        this.date = Date;
        this.logoutDate = logoutDate; 
    }
    
    //Getters
    public int getId(){
        return id;
    }
    
    public String getFirstName(){
        return firstName;
    }
    
    public String getSurname(){
        return surname;
    }
    
    public String getUsername(){
        return username;
    }
    
    public String getPassword(){
        return password;
    }
    
    public String getMobileNo(){
        return mobileNo;
    }
    
    public String getGender(){
        return gender;
    }
    public String getDate(){
        return date;
    }

    public String getLogoutDate() {
        return logoutDate;
    }
}
