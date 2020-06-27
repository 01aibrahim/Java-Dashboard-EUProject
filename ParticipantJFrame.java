package dashboardcw;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Abdulrahman Ibrahim 
 */
public class ParticipantJFrame extends javax.swing.JFrame {

    /**
     * Creates new form ParticipantJFrame
     */
    public ParticipantJFrame() throws SQLException {
        initComponents();
        ShowTable();
        Count();
    }

    // In here, A query and execution happens, where by it gets all all data and stores it in an ArrayList, which will be used later on
    // To populate in the table.
    public ArrayList<GroupData> DataList() throws SQLException {

        ArrayList<GroupData> DataList = new ArrayList<GroupData>();

        String query = "SELECT * FROM 5CS03GroupThree WHERE role= 'participant' ";

        Statement e;
        ResultSet x;

        e = My_Database.getConnection().prepareStatement(query);
        x = e.executeQuery(query);

        GroupData costumerDetails;
        while (x.next()) {
            costumerDetails = new GroupData(x.getInt("projectRcn"), x.getInt("projectID"), x.getString("projectAcronym"), x.getString("role"), x.getInt("CompanyID"), x.getString("ComapnyName"), x.getString("CompanyShortName"), x.getString("ActivityType"),
                    x.getString("endOfParticipation"), x.getInt("ecContribution"), x.getString("Country"), x.getString("Street"), x.getString("City"), x.getString("PostCode"), x.getString("OrganisationURL"), x.getString("VatNumber"), x.getString("ProjectLink"));
            DataList.add(costumerDetails);

        }
        return DataList;
    }

    // This is a query search to see return the number of projects where the role is participant . 
    public int Count() throws SQLException {
        String query = "SELECT COUNT(*) AS rowcount FROM 5CS03GroupThree where role= 'participant' ";

        Statement e;
        ResultSet x;

        e = My_Database.getConnection().prepareStatement(query);
        x = e.executeQuery(query);

        x.next();
        int count = x.getInt("rowcount");
        x.close();

        String StringIntNumber = Integer.toString(count);
        TotalNumber.setText("A total of: " + StringIntNumber);

        return count;

    }
  
    // In here, we set the data into the rows. 
    public void ShowTable() throws SQLException {
        ArrayList<GroupData> list = DataList();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        Object[] row = new Object[17];
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getProjectRcn();
            row[1] = list.get(i).getProjectID();
            row[2] = list.get(i).getProjectAcronym();
            row[3] = list.get(i).getRole();
            row[4] = list.get(i).getCompanyID();
            row[5] = list.get(i).getCompanyName();
            row[6] = list.get(i).getCompanyShortName();
            row[7] = list.get(i).getActivityType();
            row[8] = list.get(i).getEndOfParticipation();
            row[9] = list.get(i).getecContribution();
            row[10] = list.get(i).getCountry();
            row[11] = list.get(i).getStreet();
            row[12] = list.get(i).getCity();
            row[13] = list.get(i).getPostcode();
            row[14] = list.get(i).getOrganisationURL();
            row[15] = list.get(i).getVatNumber();
            row[16] = list.get(i).getProjectLink();
            model.addRow(row);

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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        Title = new javax.swing.JLabel();
        TotalNumber = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ProjectRcn", "ProjectID", "Project Acronym", "Role", "Company ID", "Company Name", "Company Short Name", "Activity Type ", "End Of Participation", "EC Contribution", "Country", "Street", "City", "Post Code", "Organisation URL", "VAT Number", "Project Link"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        Title.setFont(new java.awt.Font("Noto Sans Kannada", 1, 18)); // NOI18N
        Title.setText("Only Participant roles are showing ");

        TotalNumber.setFont(new java.awt.Font("Noto Sans Kannada", 1, 18)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(433, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(TotalNumber, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(505, 505, 505))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Title)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TotalNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 661, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(ParticipantJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ParticipantJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ParticipantJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ParticipantJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new ParticipantJFrame().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(ParticipantJFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Title;
    private javax.swing.JLabel TotalNumber;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

}
