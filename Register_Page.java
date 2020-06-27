
package dashboardcw;

import java.awt.Color;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.border.Border;

/**
 *
 * @author Abdulrahman Ibrahim
 */
public class Register_Page extends javax.swing.JFrame {
    //Declaring all the variables i need to store data or check for data.
    //i have declare the variables for the pattern. 
    private Pattern passwordPattern;
    private Matcher passwordMatcher;
    private Pattern usernamePattern;
    private Matcher usernameMatcher;
    private Pattern phonePattern;
    private Matcher phoneMatcher;
    private  final String passwordPatternWay = "((?=.*[a-z])(?=.*\\d)(?=.*[A-Z])(?=.*[@#$%!]).{8,24})";
    private  final String usernamePatternWay = "((?=.*[a-z])(?=.*\\d)(?=.*[A-Z])(?=.*[@#$%!]).{8,24})";
   private  final String mobilePatternWay = "((?=.*[0-9]).{10,24})";

    /**
     * Creates new form Register_Page
     */
    public Register_Page() {
        initComponents();
        ButtonGroup radios = new ButtonGroup();
        radios.add(Male_Radio);
        radios.add(Female_Radio);
        radios.add(Other_Radio);
    }

    // Method for empty fields all fields are mandatory for the registration.
    
    public boolean FieldsVerification(){
        //Declaring new variables and attaching the inputs of the user in them.
        String firstname = First_Name.getText();
        String surname = Last_Name.getText();
        String username = rUsername_Login.getText();
        String mobile = Mobile_Register.getText();
        String password = String.valueOf(rPassword_Login.getPassword());
        String cpassword = String.valueOf(CPassword_Login.getPassword());
        String femaleRadio = Female_Radio.getText().toString();
        String maleRadio = Male_Radio.getText().toString();
        String otherRadio = Other_Radio.getText().toString();
        
        //Checking if the user insert all his/her details correctly.
        if(firstname.trim().equals("") || surname.trim().equals("") || username.trim().equals("") || 
                mobile.trim().equals("") || password.trim().equals("") || cpassword.trim().equals("") ||
                firstname.trim().equals("firstname") || surname.trim().equals("surname") || username.trim().equals("username") || 
                mobile.trim().equals("number") || password.trim().equals("password") || cpassword.trim().equals("password") ||
                femaleRadio.matches("") || maleRadio.matches("") || otherRadio.matches("")){
            //if the user has not typed all the required fields this error message will show.
            JOptionPane.showMessageDialog(null, "You have to fill in all the informations requaried!!");
            return false;
        }
        //checking if the two password match, if not the following error message will pop up.
        else if (!password.equals(cpassword)){
            JOptionPane.showMessageDialog(null, "Passwords are not the same!","Passwords should be the same, try again!", 1);
            return false;
        }
            
        else {
            return true;
        }
        
       
       
    }
  
    
    // Creating a method to check if the username already exist in our database system.
    //This method will be the last running and it will check the database if the
    //username already exist in the database.
    public boolean UsernameVerification(String UsernameCheck){
        
        PreparedStatement StatementCheckUsername;
        ResultSet resultCheckUsername;
        
        boolean verification_of_Username = false;
        
        //Query to check the database for the username.
        String checkingUsernames = "SELECT * FROM `Users` WHERE `Username` = ?";
        
            try { 
                StatementCheckUsername = My_Database.getConnection().prepareStatement(checkingUsernames);
                StatementCheckUsername.setString(1, UsernameCheck);
                resultCheckUsername = StatementCheckUsername.executeQuery();

                if(resultCheckUsername.next()){
                    verification_of_Username = true;
                    //Error message if the username already exist.
                    JOptionPane.showMessageDialog(null, "Username already Exist", "Try another Username", 2);
                }
            } catch (SQLException ex) {
                Logger.getLogger(Register_Page.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        //Returning the verification of the username.
        return verification_of_Username;
        
    }
    
    //This is a method which will check the pattern of the username 
    //to make a strong username we have set up the pattern to be 
    //between 8-24 characters with a special letter and a capital letter.
    public boolean usernameChecking(){
        //Getting the username input texr form the user.
         String username = rUsername_Login.getText();
       //Attaching the pattern created in the top of the page.
       // to the username pattern so the user has to follow,
       // this pattern to insert a valid username.
        usernamePattern = Pattern.compile(usernamePatternWay);
        // attaching the matcher with the pattern to the username to check if matches the pattern.
        usernameMatcher = usernamePattern.matcher(username);
            if(usernameMatcher.matches()){

            }else {
                //Error message if the pattern does not match the user input.
                JOptionPane.showMessageDialog(null, "Wrong Username should be between 8-24char,include a Special Char and Capital Letter");
            }
       return usernameMatcher.matches();
        
    }
    
    //Checking the password pattern, i have set up a pattern for the password
    // to make the user enter a strong password so it will not be easy to be hacked.
    public boolean passwordChecking(){
        //Getting the passwords inputs from the user.
         String password = String.valueOf(rPassword_Login.getPassword());
         //Attaching the pattern created in the top of the page,
         //to the password pattern so the user had to follow,
         //this pattern to insert a valid username.
        passwordPattern = Pattern.compile(passwordPatternWay);
        passwordMatcher = passwordPattern.matcher(password);
            if(passwordMatcher.matches()){

            }else {
                //Error message if the pattern does not match the user input.
                JOptionPane.showMessageDialog(null, "Wrong Password should be between 8-24char,include a Special Char and Capital Letter");
            }
        
        return passwordMatcher.matches();
        
    }
    
    //Checking method for mobile batter it should be minimum of 10 numbers 
    public boolean mobileChecking(){
        //Same coding used for the pattern of ther mobile phone.
        String mobile = Mobile_Register.getText();
        phonePattern = Pattern.compile(mobilePatternWay);
        phoneMatcher = phonePattern.matcher(mobile);
            if(phoneMatcher.matches()){

            }else {
                JOptionPane.showMessageDialog(null, "Mobile numbers should have 10 or more Numbers");
            }
        return phoneMatcher.matches();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        rUsername_Login = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        rPassword_Login = new javax.swing.JPasswordField();
        Register_Button = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        First_Name = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        Last_Name = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        Mobile_Register = new javax.swing.JTextField();
        Male_Radio = new javax.swing.JRadioButton();
        Female_Radio = new javax.swing.JRadioButton();
        Other_Radio = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();
        CPassword_Login = new javax.swing.JPasswordField();
        Login_Back_Label = new javax.swing.JLabel();
        Title_Login_Page = new javax.swing.JPanel();
        Login_Page = new javax.swing.JLabel();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel8.setText("jLabel8");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(255, 204, 0));

        jLabel1.setText("Username");

        rUsername_Login.setForeground(new java.awt.Color(204, 204, 204));
        rUsername_Login.setText("username");
        rUsername_Login.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                rUsername_LoginFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                rUsername_LoginFocusLost(evt);
            }
        });

        jLabel2.setText("Password");

        rPassword_Login.setForeground(new java.awt.Color(204, 204, 204));
        rPassword_Login.setText("password");
        rPassword_Login.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                rPassword_LoginFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                rPassword_LoginFocusLost(evt);
            }
        });
        rPassword_Login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rPassword_LoginActionPerformed(evt);
            }
        });

        Register_Button.setText("Register");
        Register_Button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Register_ButtonMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Register_ButtonMouseEntered(evt);
            }
        });
        Register_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Register_ButtonActionPerformed(evt);
            }
        });

        jLabel3.setText("First Name:");

        First_Name.setForeground(new java.awt.Color(204, 204, 204));
        First_Name.setText("firstname");
        First_Name.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                First_NameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                First_NameFocusLost(evt);
            }
        });
        First_Name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                First_NameActionPerformed(evt);
            }
        });

        jLabel4.setText("Last Name");

        Last_Name.setForeground(new java.awt.Color(204, 204, 204));
        Last_Name.setText("surname");
        Last_Name.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                Last_NameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                Last_NameFocusLost(evt);
            }
        });

        jLabel5.setText("Mobile No:");

        jLabel6.setText("Gender");

        Mobile_Register.setForeground(new java.awt.Color(204, 204, 204));
        Mobile_Register.setText("number");
        Mobile_Register.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                Mobile_RegisterFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                Mobile_RegisterFocusLost(evt);
            }
        });
        Mobile_Register.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Mobile_RegisterActionPerformed(evt);
            }
        });
        Mobile_Register.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                Mobile_RegisterKeyTyped(evt);
            }
        });

        Male_Radio.setText("Male");
        Male_Radio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Male_RadioActionPerformed(evt);
            }
        });

        Female_Radio.setText("Female");

        Other_Radio.setText("Other");

        jLabel7.setText("Password");

        CPassword_Login.setForeground(new java.awt.Color(204, 204, 204));
        CPassword_Login.setText("password");
        CPassword_Login.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                CPassword_LoginFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                CPassword_LoginFocusLost(evt);
            }
        });

        Login_Back_Label.setText("Already Member Go To Login Page");
        Login_Back_Label.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Login_Back_LabelMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Login_Back_LabelMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Login_Back_LabelMouseEntered(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(First_Name)
                                    .addComponent(rPassword_Login, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel7))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(Last_Name, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(rUsername_Login, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(CPassword_Login, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(Mobile_Register, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addComponent(Male_Radio)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Female_Radio)
                                .addGap(18, 18, 18)
                                .addComponent(Other_Radio))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(324, 324, 324)
                        .addComponent(Login_Back_Label))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Register_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 842, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(First_Name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(Last_Name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(rUsername_Login))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(rPassword_Login, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(CPassword_Login, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(Mobile_Register, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(Male_Radio)
                    .addComponent(Female_Radio)
                    .addComponent(Other_Radio))
                .addGap(18, 18, 18)
                .addComponent(Register_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Login_Back_Label)
                .addGap(23, 23, 23))
        );

        Title_Login_Page.setBackground(new java.awt.Color(255, 204, 0));

        Login_Page.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        Login_Page.setText("Register With Us");

        javax.swing.GroupLayout Title_Login_PageLayout = new javax.swing.GroupLayout(Title_Login_Page);
        Title_Login_Page.setLayout(Title_Login_PageLayout);
        Title_Login_PageLayout.setHorizontalGroup(
            Title_Login_PageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Title_Login_PageLayout.createSequentialGroup()
                .addGap(325, 325, 325)
                .addComponent(Login_Page)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        Title_Login_PageLayout.setVerticalGroup(
            Title_Login_PageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Title_Login_PageLayout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addComponent(Login_Page)
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Title_Login_Page, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 856, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Title_Login_Page, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Login_Back_LabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Login_Back_LabelMouseEntered
        // TODO add your handling code here:
        //Setting a border when the user enters the label to go back to the log in page\
        //This will allow the user to understand that a change has been made.
        Border Register_Page = BorderFactory.createMatteBorder(0, 0, 1, 0, Color.black);
        Login_Back_Label.setBorder(Register_Page);
    }//GEN-LAST:event_Login_Back_LabelMouseEntered

    private void Login_Back_LabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Login_Back_LabelMouseExited
        // TODO add your handling code here:
        Login_Back_Label.setBorder(null);
    }//GEN-LAST:event_Login_Back_LabelMouseExited

    private void Login_Back_LabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Login_Back_LabelMouseClicked
        // TODO add your handling code here:
        //Redirecting the user to the log in page.
        Login_Page_Project newLoginPage = new Login_Page_Project();
        newLoginPage.setVisible(true);
        newLoginPage.pack();
        newLoginPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.dispose();
    }//GEN-LAST:event_Login_Back_LabelMouseClicked

    private void CPassword_LoginFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_CPassword_LoginFocusLost
        // TODO add your handling code here:
        String CPasswordLogin = String.valueOf(CPassword_Login.getPassword());
        if(CPasswordLogin.equals("") || CPasswordLogin.trim().toLowerCase().equals("password")){
            CPassword_Login.setText("password");
            CPassword_Login.setForeground(Color.LIGHT_GRAY);
        }
    }//GEN-LAST:event_CPassword_LoginFocusLost

    private void CPassword_LoginFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_CPassword_LoginFocusGained
        // TODO add your handling code here:
        //On focus the password text will change to empty
        //so when the user enters to type a password it will delete the password
        // if he change field without entering anything to password it will show again password.
        String CPasswordLogin = String.valueOf(CPassword_Login.getPassword());
        if(CPasswordLogin.trim().toLowerCase().equals("password")){
            CPassword_Login.setText("");
            CPassword_Login.setForeground(Color.black);

        }
    }//GEN-LAST:event_CPassword_LoginFocusGained

    private void Male_RadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Male_RadioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Male_RadioActionPerformed

    private void Mobile_RegisterKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Mobile_RegisterKeyTyped
        // TODO add your handling code here:
        //Allowing only number for mobile phone
        //the following if statement will not allow the user to enter 
        //characters in the mobile text field.
        if(!Character.isDigit(evt.getKeyChar())){
            evt.consume();
        }
    }//GEN-LAST:event_Mobile_RegisterKeyTyped

    private void Mobile_RegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Mobile_RegisterActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Mobile_RegisterActionPerformed

    private void Mobile_RegisterFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_Mobile_RegisterFocusLost
        // TODO add your handling code here:
        //On focus lost if we move the mouse to next text field the will show in light gray Mobile Number
        // it will notify the user that in this section they have to insert their mobile number.
        if(Mobile_Register.getText().equals("") || Last_Name.getText().trim().toLowerCase().equals("number")){
            Mobile_Register.setText("number");
            Mobile_Register.setForeground(Color.LIGHT_GRAY);
        }
    }//GEN-LAST:event_Mobile_RegisterFocusLost

    private void Mobile_RegisterFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_Mobile_RegisterFocusGained
        // TODO add your handling code here:
        //On focus gained the Mobile Number text will go to empty so the user can 
        //start typing the mobile number.
        if(Mobile_Register.getText().trim().toLowerCase().equals("number")){
            Mobile_Register.setText("");
            Mobile_Register.setForeground(Color.black);

        }
    }//GEN-LAST:event_Mobile_RegisterFocusGained

    private void Last_NameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_Last_NameFocusLost
        // TODO add your handling code here:

        if(Last_Name.getText().equals("") || Last_Name.getText().trim().toLowerCase().equals("surname")){
            Last_Name.setText("surname");
            Last_Name.setForeground(Color.LIGHT_GRAY);
        }
    }//GEN-LAST:event_Last_NameFocusLost

    private void Last_NameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_Last_NameFocusGained
        // TODO add your handling code here:

        if(Last_Name.getText().trim().toLowerCase().equals("surname")){
            Last_Name.setText("");
            Last_Name.setForeground(Color.black);

        }
    }//GEN-LAST:event_Last_NameFocusGained

    private void First_NameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_First_NameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_First_NameActionPerformed

    private void First_NameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_First_NameFocusLost
        // TODO add your handling code here:
        if(First_Name.getText().equals("") || First_Name.getText().trim().toLowerCase().equals("firstname")){
            First_Name.setText("firstname");
            First_Name.setForeground(Color.LIGHT_GRAY);
        }
    }//GEN-LAST:event_First_NameFocusLost

    private void First_NameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_First_NameFocusGained
        // TODO add your handling code here:
        if(First_Name.getText().trim().toLowerCase().equals("firstname")){
            First_Name.setText("");
            First_Name.setForeground(Color.black);

        }
    }//GEN-LAST:event_First_NameFocusGained

    private void Register_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Register_ButtonActionPerformed
        // TODO add your handling code here:
        PreparedStatement e;
        ResultSet x;

        //Getting username and passwords
        String firstName = First_Name.getText();
        String surName = Last_Name.getText();
        String userName = rUsername_Login.getText();
        String password = String.valueOf(rPassword_Login.getPassword());
        String cpassword = String.valueOf(CPassword_Login.getPassword());
        String mobile = Mobile_Register.getText();
        String gender = "Male";

        //Getting radio buttons.
        if (Female_Radio.isSelected()){
            gender = "Female";
        } else if (Male_Radio.isSelected()){
            gender = "Male";
        }else if (Other_Radio.isSelected()){
            gender = "Other";
        }

        //Checking if fieldsverification not correct.
        if(!FieldsVerification()){
        }
        //Checking if usernamechecking not correct.
        else if(!usernameChecking()){
        }
        //Checking if paasswordchecking not correct.
        else if(!passwordChecking()){

        }else
        //Checking if mobilechecking not correct.
        if(!mobileChecking()){
        }else
        //Checking usernameverification not correct.
        if(UsernameVerification(userName)){
            
        }else{

            PreparedStatement statementInsertData;
            ResultSet y;
            //Inser Query which will help me to insert all the details the user added,
            //If they much our validation.
            String queries = "INSERT INTO `Users`(`First_Name`, `Last_Name`, `Username`, `Password`, `Mobile_Number`, `Gender`) VALUES (?,?,?,?,?,?)";

            try {
                
                encryptionDecr encrypt = new encryptionDecr("a1djwlqa1djwlq32");
                Date s = new Date();
                String regDate = s.toString();
                password = encrypt.encryptData(password);
                firstName = encrypt.encryptData(firstName);
                surName = encrypt.encryptData(surName);
                //Adding them to the database
                statementInsertData = My_Database.getConnection().prepareStatement(queries);
                statementInsertData.setString(1, firstName);
                statementInsertData.setString(2, surName);
                statementInsertData.setString(3, userName);
                statementInsertData.setString(4, password);
                statementInsertData.setString(5, mobile);
                statementInsertData.setString(6, gender);

                    if (statementInsertData.executeUpdate()!=0){
                        //Pop up message if the query execution is correct.
                        JOptionPane.showMessageDialog(null,"Your Account Has Been created", "Successfull Reg",2);
                    } else {
                        //Error message if something goes wrong.
                        JOptionPane.showMessageDialog(null,"Error", "Check Info",2);
                    }

            } catch (SQLException ex) {
                Logger.getLogger(Register_Page.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(Register_Page.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_Register_ButtonActionPerformed

    private void Register_ButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Register_ButtonMouseEntered
        // TODO add your handling code here:
        Register_Button.setBackground(Color.blue);
    }//GEN-LAST:event_Register_ButtonMouseEntered

    private void Register_ButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Register_ButtonMouseExited
        // TODO add your handling code here:
        Register_Button.setBackground(Color.GRAY);
    }//GEN-LAST:event_Register_ButtonMouseExited

    private void rPassword_LoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rPassword_LoginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rPassword_LoginActionPerformed

    private void rPassword_LoginFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_rPassword_LoginFocusLost
        // TODO add your handling code here:
        String PasswordLogin = String.valueOf(rPassword_Login.getPassword());
        if(PasswordLogin.equals("") || PasswordLogin.trim().toLowerCase().equals("password")){
            rPassword_Login.setText("password");
            rPassword_Login.setForeground(Color.LIGHT_GRAY);
        }
    }//GEN-LAST:event_rPassword_LoginFocusLost

    private void rPassword_LoginFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_rPassword_LoginFocusGained
        // TODO add your handling code here:

        String PasswordLogin = String.valueOf(rPassword_Login.getPassword());
        if(PasswordLogin.trim().toLowerCase().equals("password")){
            rPassword_Login.setText("");
            rPassword_Login.setForeground(Color.black);

        }
    }//GEN-LAST:event_rPassword_LoginFocusGained

    private void rUsername_LoginFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_rUsername_LoginFocusLost
        // TODO add your handling code here:

        if(rUsername_Login.getText().equals("") || rUsername_Login.getText().trim().toLowerCase().equals("username")){
            rUsername_Login.setText("username");
            rUsername_Login.setForeground(Color.LIGHT_GRAY);
        }
    }//GEN-LAST:event_rUsername_LoginFocusLost

    private void rUsername_LoginFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_rUsername_LoginFocusGained
        // TODO add your handling code here:
        // setting clear if user clicks and the text is == username
        if(rUsername_Login.getText().trim().toLowerCase().equals("username")){
            rUsername_Login.setText("");
            rUsername_Login.setForeground(Color.black);

        }
    }//GEN-LAST:event_rUsername_LoginFocusGained
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Register_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Register_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Register_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Register_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Register_Page().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField CPassword_Login;
    private javax.swing.JRadioButton Female_Radio;
    private javax.swing.JTextField First_Name;
    private javax.swing.JTextField Last_Name;
    private javax.swing.JLabel Login_Back_Label;
    private javax.swing.JLabel Login_Page;
    private javax.swing.JRadioButton Male_Radio;
    private javax.swing.JTextField Mobile_Register;
    private javax.swing.JRadioButton Other_Radio;
    private javax.swing.JButton Register_Button;
    private javax.swing.JPanel Title_Login_Page;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPasswordField rPassword_Login;
    private javax.swing.JTextField rUsername_Login;
    // End of variables declaration//GEN-END:variables
}

//References

//Pattern Refference:
//Mkyong, M. 2009. How to validate password with regular expression. [Online]. [10 March 2020]. 
//Available from: https://mkyong.com/regular-expressions/how-to-validate-password-with-regular-expression/
