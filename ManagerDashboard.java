package dashboardcw;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Abdulrahman Ibrahim
 */


public class ManagerDashboard extends javax.swing.JFrame {
    DefaultTableModel myDTable;
    String showData;

    public ManagerDashboard() {
        
        initComponents();
        tableCostumerList();
      
    }
    
    
    //Creating a method which will call the class created to store the details
    //in the arryList, then it will be easier to retrive to the jTable from a database.
    public  ArrayList<managerUsersDetails> managerList() throws SQLException{
        
        ArrayList<managerUsersDetails> managerList = new ArrayList<managerUsersDetails>();
        
        //Query
        String query = "SELECT * FROM `users`";
      
        
       Statement statementGetAllUsers;
       ResultSet x;
       
       //Creating a connection with the database.
       statementGetAllUsers = My_Database.getConnection().prepareStatement(query);
       x = statementGetAllUsers.executeQuery(query);
       managerUsersDetails costumerDetails;
       while (x.next())
       {
            try 
            {
                //Retriving all the details from the database, and then store them to the
                //arraylist managerList.
                encryptionDecr  s = new encryptionDecr("a1djwlqa1djwlq32");
                costumerDetails = new managerUsersDetails((x.getString("First_Name")),(x.getString("Last_Name")),x.getString("username"),s.decryptData(x.getString("password")),x.getString("Mobile_Number"),x.getString("Gender"),x.getString("LogInDate"), x.getString("LogoutDate"));
                managerList.add(costumerDetails);
            } 
            catch (NoSuchPaddingException | NoSuchAlgorithmException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException | IOException ex) 
            {
                Logger.getLogger(ManagerDashboard.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
       return managerList;
        
    }
    public  ArrayList<managerUsersDetails> managerListSearch() throws SQLException{
        
        ArrayList<managerUsersDetails> managerListSearch = new ArrayList<managerUsersDetails>();
        
        //Query
        String query = "select * from `users` where First_Name like '%" + showData + "%' OR Last_Name like '%" + showData + "%' OR LogInDate like '%" + showData + "%' OR username like '%" + showData + "%'";
      
        
       Statement e;
       ResultSet x;
       
       //Creating a connection with the database.
       e = My_Database.getConnection().prepareStatement(query);
       x = e.executeQuery(query);
       managerUsersDetails costumerDetails;
       while (x.next())
       {
            try 
            {
                //Retriving all the details from the database, and then store them to the
                //arraylist managerList.
                encryptionDecr  s = new encryptionDecr("a1djwlqa1djwlq32");
                costumerDetails = new managerUsersDetails((x.getString("First_Name")),(x.getString("Last_Name")),x.getString("username"),s.decryptData(x.getString("password")),x.getString("Mobile_Number"),x.getString("Gender"),x.getString("LogInDate"),x.getString("LogoutDate"));
                managerListSearch.add(costumerDetails);
            } 
            catch (NoSuchPaddingException | NoSuchAlgorithmException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException | IOException ex) 
            {
                Logger.getLogger(ManagerDashboard.class.getName()).log(Level.SEVERE, null, ex);
            }
       }
        
     return managerListSearch;
        
    }

    //Storing the jtable with the details retrived from the database.
    public void tableCostumerList(){
        //Declare the arraylist of the manager like before.
        ArrayList<managerUsersDetails> list;
        try {
            list = managerList();

             DefaultTableModel detailsModel = (DefaultTableModel)myTableDetails.getModel();

            Object[] row = new Object[8];
            for (int i = 0; i <list.size(); i++)
            {
                row[0] = list.get(i).getFirstName();
                row[1] = list.get(i).getSurname();
                row[2] = list.get(i).getUsername();
                row[3] = list.get(i).getPassword();
                row[4] = list.get(i).getMobileNo();
                row[5] = list.get(i).getGender();
                row[6] = list.get(i).getDate();
                row[7] = list.get(i).getLogoutDate();
            
                detailsModel.addRow(row);
            }
        }
        catch (SQLException ex) 
        {
            Logger.getLogger(ManagerDashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    public void tableCostumerListSearch(){
        //Declare the arraylist of the manager like before.
        ArrayList<managerUsersDetails> list;
        try {
            list = managerListSearch();
             DefaultTableModel detailsModel = (DefaultTableModel)myTableDetails.getModel();
       
            Object[] row = new Object[8];
            for (int i = 0; i <list.size(); i++)
            {
                row[0] = list.get(i).getFirstName();
                row[1] = list.get(i).getSurname();
                row[2] = list.get(i).getUsername();
                row[3] = list.get(i).getPassword();
                row[4] = list.get(i).getMobileNo();
                row[5] = list.get(i).getGender();
                row[6] = list.get(i).getDate();
                row[7] = list.get(i).getLogoutDate();
            
                detailsModel.addRow(row);
                
            }
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(ManagerDashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtFilter = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        myTableDetails = new javax.swing.JTable();
        searchBtn = new javax.swing.JButton();

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 204, 0));

        jPanel1.setBackground(new java.awt.Color(255, 204, 0));

        jLabel1.setText("Search:");

        txtFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFilterActionPerformed(evt);
            }
        });
        txtFilter.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFilterKeyTyped(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFilterKeyReleased(evt);
            }
        });

        myTableDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "First Name", "Last Name", "Username", "Password", "Mobile No", "Gender", "Login Date/Time", "Logout Date"
            }
        ));
        jScrollPane1.setViewportView(myTableDetails);

        searchBtn.setText("Search");
        searchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(searchBtn)
                .addContainerGap(440, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 329, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFilterActionPerformed
        try 
        {
            // TODO add your handling code here:

            managerListSearch();
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(ManagerDashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
              
    }//GEN-LAST:event_txtFilterActionPerformed

    private void searchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBtnActionPerformed
      
       showData = txtFilter.getText();
       tableCostumerListSearch();
        if(myTableDetails.getRowCount()==0)
        {
             JOptionPane.showMessageDialog(null, "The text input does not exit in the Database Server", "Error", 2);
        }
       
    
    }//GEN-LAST:event_searchBtnActionPerformed

    private void txtFilterKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFilterKeyReleased
        // TODO add your handling code here:
       
    }//GEN-LAST:event_txtFilterKeyReleased

    private void txtFilterKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFilterKeyTyped
        // TODO add your handling code here:
        DefaultTableModel cTable = (DefaultTableModel) myTableDetails.getModel();
        int count = cTable.getRowCount();
        for (int i = count -1; i >=0; i--)
        {
            cTable.removeRow(i);
        }
    }//GEN-LAST:event_txtFilterKeyTyped

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
            java.util.logging.Logger.getLogger(ManagerDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManagerDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManagerDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManagerDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManagerDashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable myTableDetails;
    private javax.swing.JButton searchBtn;
    private javax.swing.JTextField txtFilter;
    // End of variables declaration//GEN-END:variables
}
