/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dashboardcw;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author Abdulrahman Ibrahim
 */
// This class hold the visual data 
public class DataDashboard extends javax.swing.JFrame {

    // Fetches the data from these classes, this will be used to display that data.
    PartnerJFrame ViewPartnerData = new PartnerJFrame();
    ParticipantJFrame ViewParticipant = new ParticipantJFrame();
    CoordinatorJFrame ViewCoordinator = new CoordinatorJFrame();
    ViewPieChart ViewPieChart = new ViewPieChart();
    ViewCountryCount ViewBarChart = new ViewCountryCount();
    CountrySearch CountrySearch = new CountrySearch();
    SearchActivityTypeFrame sf = new SearchActivityTypeFrame();
    String option;
    Login_Page_Project s1;
   

    /**
     * Creates new form DataDashboard
     *
     * @throws java.sql.SQLException
     */
    public DataDashboard() throws SQLException {
        initComponents();
        FrameSize();
        CountryCount();
        TotalProjectCount();
        EccontributionsTotal();
        CountryCountBen();
        this.setLocationRelativeTo(null);

         Login_Page_Project d2 = new Login_Page_Project();
         UserLog s1 = new UserLog();
        
       
        

    }
        public DataDashboard(String getUsername) throws SQLException{
            initComponents();
            FrameSize();
            CountryCount();
            TotalProjectCount();
            EccontributionsTotal();
            CountryCountBen();
            this.setLocationRelativeTo(null);
            usernameLabel.setText(getUsername);
        }

    // Deals with the size of the frames to ensure that everything is displayed well 
    private void FrameSize() {

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        ViewPartnerData.setSize(screenSize.width, screenSize.height);
        ViewParticipant.setSize(screenSize.width, screenSize.height);
        ViewCoordinator.setSize(screenSize.width, screenSize.height);
        ViewPieChart.setSize(screenSize.width / 2, screenSize.height / 2);
        ViewBarChart.setSize(screenSize.width / 2, screenSize.height / 2);
        sf.setSize(screenSize.width / 2, screenSize.height / 2);
        
    }

    // This is a query search to see return the number of projects are the highest. 
    public int CountryCount() throws SQLException {
        
        String query = "SELECT COUNT(*) AS rowcount FROM 5CS03GroupThree where Country = 'DE' ";

        Statement e;
        ResultSet x;

        e = My_Database.getConnection().prepareStatement(query);
        x = e.executeQuery(query);

        x.next();
        int count = x.getInt("rowcount");
        x.close();

        String StringIntNumber = Integer.toString(count);
        CountryCount.setText(StringIntNumber + "- DE (Germany)");

        return count;

    }
    
    public int CountryCountBen() throws SQLException {
       
         String query = "SELECT COUNT(DISTINCT country) AS 'Number of Countries involved' FROM 5CS03GroupThree";
    
            { 
             PreparedStatement e;
             ResultSet x;

             e = My_Database.getConnection().prepareStatement(query);
             x = e.executeQuery(query);

             x.next();
             int CountryCount = x.getInt("Number of Countries involved");
             x.close();

             String ResultSet=Integer.toString(CountryCount);
             totalCountriesInvolved.setText(ResultSet);
             //System.out.println (CountryCount);
                 return CountryCount;
            }
    }

    // This is a query search to see how many projects there are and it will return the amount of projects. 
    public int TotalProjectCount() throws SQLException {
        String query = "SELECT COUNT(*) AS rowcount FROM 5CS03GroupThree";

        Statement e;
        ResultSet x;

        e = My_Database.getConnection().prepareStatement(query);
        x = e.executeQuery(query);

        x.next();
        int count = x.getInt("rowcount");
        x.close();

        String StringIntNumber = Integer.toString(count);
        TotalNumber.setText(StringIntNumber);

        return count;

    }
    

    // The query is for showing the total Figue of how much EC Contribtion there is. 
    public int EccontributionsTotal() throws SQLException {
        String query = "Select Sum(ecContribution) from  5CS03GroupThree"; 
                 
        Statement e;
        ResultSet x;

        e = My_Database.getConnection().prepareStatement(query);
        x = e.executeQuery(query);

        x.next();
        int count = x.getInt("Sum(ecContribution)");
        x.close();

        String StringIntNumber = Integer.toString(count);
        EcFigure.setText(StringIntNumber + " Billion");

        return count;
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        CountryPanel = new javax.swing.JPanel();
        TittleProject = new javax.swing.JLabel();
        CountryCount = new javax.swing.JLabel();
        ViewTopFive = new javax.swing.JButton();
        projectSearch = new javax.swing.JButton();
        RolePanel = new javax.swing.JPanel();
        ChartButton = new javax.swing.JButton();
        ParticipantButton = new javax.swing.JButton();
        PartnerButton = new javax.swing.JButton();
        COordinatorButton = new javax.swing.JButton();
        RoleTittle = new javax.swing.JLabel();
        ProjectPanel = new javax.swing.JPanel();
        TotalText = new javax.swing.JLabel();
        TotalNumber = new javax.swing.JLabel();
        AbdulPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        EcFigure = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        pieChartButton = new javax.swing.JButton();
        searchFunctionButton = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        entityParticipationBtn = new javax.swing.JButton();
        topContributionBtn = new javax.swing.JButton();
        totalCountriesInvolved = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        logoutBtn = new javax.swing.JButton();
        usernameLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(java.awt.Color.lightGray);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                formMouseEntered(evt);
            }
        });

        CountryPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                CountryPanelMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CountryPanelMouseEntered(evt);
            }
        });

        TittleProject.setFont(new java.awt.Font("Helvetica", 1, 18)); // NOI18N
        TittleProject.setText("Country with highest amount of projects");

        CountryCount.setFont(new java.awt.Font("Helvetica", 1, 18)); // NOI18N

        ViewTopFive.setText("View Top 5 Country ");
        ViewTopFive.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ViewTopFiveActionPerformed(evt);
            }
        });

        projectSearch.setText("Search Project Country");
        projectSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                projectSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout CountryPanelLayout = new javax.swing.GroupLayout(CountryPanel);
        CountryPanel.setLayout(CountryPanelLayout);
        CountryPanelLayout.setHorizontalGroup(
            CountryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CountryPanelLayout.createSequentialGroup()
                .addGroup(CountryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CountryPanelLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(TittleProject))
                    .addGroup(CountryPanelLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(ViewTopFive)
                        .addGap(47, 47, 47)
                        .addComponent(projectSearch))
                    .addGroup(CountryPanelLayout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(CountryCount, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        CountryPanelLayout.setVerticalGroup(
            CountryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CountryPanelLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(TittleProject)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(CountryCount, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(CountryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ViewTopFive)
                    .addComponent(projectSearch))
                .addGap(37, 37, 37))
        );

        RolePanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                RolePanelMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                RolePanelMouseEntered(evt);
            }
        });

        ChartButton.setText("Full Chart");
        ChartButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChartButtonActionPerformed(evt);
            }
        });

        ParticipantButton.setText("Participant");
        ParticipantButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ParticipantButtonActionPerformed(evt);
            }
        });

        PartnerButton.setText("Partner");
        PartnerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PartnerButtonActionPerformed(evt);
            }
        });

        COordinatorButton.setText("Co-Ordinator");
        COordinatorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                COordinatorButtonActionPerformed(evt);
            }
        });

        RoleTittle.setFont(new java.awt.Font("Helvetica", 1, 18)); // NOI18N
        RoleTittle.setText("Roles within Project");

        javax.swing.GroupLayout RolePanelLayout = new javax.swing.GroupLayout(RolePanel);
        RolePanel.setLayout(RolePanelLayout);
        RolePanelLayout.setHorizontalGroup(
            RolePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RolePanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(COordinatorButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ParticipantButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(PartnerButton)
                .addGap(49, 49, 49))
            .addGroup(RolePanelLayout.createSequentialGroup()
                .addGroup(RolePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(RolePanelLayout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(RoleTittle))
                    .addGroup(RolePanelLayout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addComponent(ChartButton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        RolePanelLayout.setVerticalGroup(
            RolePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RolePanelLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(RoleTittle)
                .addGap(18, 18, 18)
                .addComponent(ChartButton)
                .addGap(53, 53, 53)
                .addGroup(RolePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PartnerButton)
                    .addComponent(ParticipantButton)
                    .addComponent(COordinatorButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        ProjectPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ProjectPanelMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ProjectPanelMouseEntered(evt);
            }
        });

        TotalText.setFont(new java.awt.Font("Helvetica", 1, 18)); // NOI18N
        TotalText.setText("Total Projects to date");

        TotalNumber.setFont(new java.awt.Font("Helvetica", 1, 18)); // NOI18N

        javax.swing.GroupLayout ProjectPanelLayout = new javax.swing.GroupLayout(ProjectPanel);
        ProjectPanel.setLayout(ProjectPanelLayout);
        ProjectPanelLayout.setHorizontalGroup(
            ProjectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ProjectPanelLayout.createSequentialGroup()
                .addContainerGap(97, Short.MAX_VALUE)
                .addGroup(ProjectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ProjectPanelLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(TotalNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(TotalText, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(88, 88, 88))
        );
        ProjectPanelLayout.setVerticalGroup(
            ProjectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ProjectPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TotalText, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TotalNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        AbdulPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                AbdulPanelMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                AbdulPanelMouseEntered(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Helvetica", 1, 18)); // NOI18N
        jLabel1.setText("Total EC contributions");

        EcFigure.setFont(new java.awt.Font("Helvetica", 1, 18)); // NOI18N

        javax.swing.GroupLayout AbdulPanelLayout = new javax.swing.GroupLayout(AbdulPanel);
        AbdulPanel.setLayout(AbdulPanelLayout);
        AbdulPanelLayout.setHorizontalGroup(
            AbdulPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AbdulPanelLayout.createSequentialGroup()
                .addGroup(AbdulPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AbdulPanelLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel1))
                    .addGroup(AbdulPanelLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(EcFigure, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        AbdulPanelLayout.setVerticalGroup(
            AbdulPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AbdulPanelLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(EcFigure, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel2MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel2MouseEntered(evt);
            }
        });

        pieChartButton.setText("Pie Chart");
        pieChartButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pieChartButtonActionPerformed(evt);
            }
        });

        searchFunctionButton.setText("Search projects");
        searchFunctionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchFunctionButtonActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Helvetica", 1, 18)); // NOI18N
        jLabel6.setText("Projects with specific activity types");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(pieChartButton)
                .addGap(43, 43, 43)
                .addComponent(searchFunctionButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pieChartButton)
                    .addComponent(searchFunctionButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel3MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel3MouseEntered(evt);
            }
        });

        entityParticipationBtn.setText("Participation");
        entityParticipationBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                entityParticipationBtnActionPerformed(evt);
            }
        });

        topContributionBtn.setText("Contribution");
        topContributionBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                topContributionBtnActionPerformed(evt);
            }
        });

        totalCountriesInvolved.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Helvetica", 1, 18)); // NOI18N
        jLabel4.setText("Number of Participation Countries");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(124, 124, 124)
                        .addComponent(totalCountriesInvolved, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(entityParticipationBtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(topContributionBtn)
                                .addGap(11, 11, 11))
                            .addComponent(jLabel4))))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(totalCountriesInvolved, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(entityParticipationBtn)
                    .addComponent(topContributionBtn))
                .addGap(42, 42, 42))
        );

        logoutBtn.setText("Log Out");
        logoutBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                logoutBtnMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                logoutBtnMouseEntered(evt);
            }
        });
        logoutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutBtnActionPerformed(evt);
            }
        });

        usernameLabel.setText("Username");

        jLabel2.setText("User Logged In:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CountryPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AbdulPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(RolePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ProjectPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(343, 343, 343)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(usernameLabel)
                            .addComponent(jLabel2))))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(602, 602, 602)
                .addComponent(logoutBtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(ProjectPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(CountryPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(36, 36, 36)
                                        .addComponent(RolePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addComponent(AbdulPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(72, 72, 72)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(logoutBtn)
                    .addComponent(usernameLabel)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // When this button is clicked, the Participant data will appear.
    private void ParticipantButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ParticipantButtonActionPerformed

        ViewParticipant.setVisible(true);
        ViewParticipant.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }//GEN-LAST:event_ParticipantButtonActionPerformed

    // When this button is clicked, the Co-Ordinator data will appear.
    private void COordinatorButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_COordinatorButtonActionPerformed

        ViewCoordinator.setVisible(true);
        ViewCoordinator.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }//GEN-LAST:event_COordinatorButtonActionPerformed

    // When this button is clicked, the Partner data will appear.
    private void PartnerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PartnerButtonActionPerformed

        ViewPartnerData.setVisible(true);
        ViewPartnerData.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }//GEN-LAST:event_PartnerButtonActionPerformed

    // When this button is clicked, the Pie Chart will appear.
    private void ChartButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChartButtonActionPerformed

        ViewPieChart.setVisible(true);
        ViewPieChart.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }//GEN-LAST:event_ChartButtonActionPerformed

    // When this button is clicked, the Bar Chart will appear.
    private void ViewTopFiveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ViewTopFiveActionPerformed

        ViewBarChart.setVisible(true);
        ViewBarChart.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }//GEN-LAST:event_ViewTopFiveActionPerformed

// When this button is clicked, the Projects from DE data will appear.
    private void projectSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_projectSearchActionPerformed

        CountrySearch.setVisible(true);
        CountrySearch.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }//GEN-LAST:event_projectSearchActionPerformed

    private void pieChartButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pieChartButtonActionPerformed

        int hesType = 0;
                        int recType = 0;
                        int prcType = 0;
                        int pubType = 0;
                        int othType = 0;
        try {
            String actiType = "";

            Connection connect = My_Database.getConnection();
            PreparedStatement ps = connect.prepareStatement("select * from 5CS03GroupThree");
            ResultSet rs = ps.executeQuery();

            
            while (rs.next()) {
                actiType = rs.getString("activityType");
                if (actiType.contains("HES")) {
                    hesType++;
                    continue;
                } else if (actiType.contains("REC")) {
                    recType++;

                    
                    continue;
                } else if (actiType.contains("PRC")) {
                    prcType++;
                    
                    continue;
                } else if (actiType.contains("PUB")) {
                    pubType++;
                    
                    continue;
                } else if (actiType.contains("OTH")) {
                    othType++;
                    
                    continue;
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }

        ChartCreation PieChart = new ChartCreation("Acitivity Type Pie Chart", "Projects of Different Activity Types",hesType,recType,prcType,pubType,othType);
        PieChart.pack();
     
        PieChart.setVisible(true);
    }//GEN-LAST:event_pieChartButtonActionPerformed

    private void searchFunctionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchFunctionButtonActionPerformed
        sf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        sf.setVisible(true);
         sf.pack();
        sf.setLocationRelativeTo(null);
    }//GEN-LAST:event_searchFunctionButtonActionPerformed

    private void entityParticipationBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_entityParticipationBtnActionPerformed
            SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new EntityParticipation();
            }
        });
    }//GEN-LAST:event_entityParticipationBtnActionPerformed

    private void topContributionBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_topContributionBtnActionPerformed
        topcontributioncountries frame = new topcontributioncountries("Top 10 Contributing Countries");  
      frame.setSize(750,500);    
      //RefineryUtilities.centerFrameOnScreen(frame);    
      frame.setVisible(true);
    }//GEN-LAST:event_topContributionBtnActionPerformed

    private void logoutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutBtnActionPerformed                    
        PreparedStatement ps = null;
        SimpleDateFormat formatter= new SimpleDateFormat("HH:mm:ss_yy-MM-dd");
        Date date = new Date(System.currentTimeMillis());
        String p = formatter.format(date);
        try 
        {
            
            String checkLogIn = "UPDATE  Users set LogoutDate = ? where Username= ? ";
            ps = My_Database.getConnection().prepareStatement(checkLogIn);
            ps.setString(1, p); 
            ps.setString(2, usernameLabel.getText()); 
            int i = ps.executeUpdate();
            if (i > 0) 
            { 
                    Login_Page_Project d1 = new Login_Page_Project();
                    d1.setVisible(true);
                    d1.pack();
                    d1.setLocationRelativeTo(null);
                    this.dispose();
                System.out.println("Product Updated"); 
            } 
            else 
            {
                System.out.println("Error Occured");
            }
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(Login_Page_Project.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch (Exception ex) 
        {
            Logger.getLogger(Login_Page_Project.class.getName()).log(Level.SEVERE, null, ex);
        }
                    
                    
    }//GEN-LAST:event_logoutBtnActionPerformed

    private void logoutBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutBtnMouseEntered
        // TODO add your handling code here:
        logoutBtn.setBackground(Color.red);
    }//GEN-LAST:event_logoutBtnMouseEntered

    private void logoutBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutBtnMouseExited
        // TODO add your handling code here
        logoutBtn.setBackground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_logoutBtnMouseExited

    private void formMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_formMouseEntered

    private void AbdulPanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AbdulPanelMouseEntered
        // TODO add your handling code here:
        AbdulPanel.setBackground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_AbdulPanelMouseEntered

    private void AbdulPanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AbdulPanelMouseExited
        // TODO add your handling code here:
        AbdulPanel.setBackground(null);
    }//GEN-LAST:event_AbdulPanelMouseExited

    private void CountryPanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CountryPanelMouseEntered
        // TODO add your handling code here:
        CountryPanel.setBackground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_CountryPanelMouseEntered

    private void CountryPanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CountryPanelMouseExited
        // TODO add your handling code here:
        CountryPanel.setBackground(null);
    }//GEN-LAST:event_CountryPanelMouseExited

    private void ProjectPanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProjectPanelMouseEntered
        // TODO add your handling code here:
        ProjectPanel.setBackground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_ProjectPanelMouseEntered

    private void ProjectPanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProjectPanelMouseExited
        // TODO add your handling code here:
        ProjectPanel.setBackground(null);
    }//GEN-LAST:event_ProjectPanelMouseExited

    private void RolePanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RolePanelMouseEntered
        // TODO add your handling code here:
        RolePanel.setBackground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_RolePanelMouseEntered

    private void RolePanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RolePanelMouseExited
        // TODO add your handling code here:
        RolePanel.setBackground(null);
    }//GEN-LAST:event_RolePanelMouseExited

    private void jPanel2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseEntered
        // TODO add your handling code here:
        jPanel2.setBackground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_jPanel2MouseEntered

    private void jPanel2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseExited
        // TODO add your handling code here:
        jPanel2.setBackground(null);
    }//GEN-LAST:event_jPanel2MouseExited

    private void jPanel3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseEntered
        // TODO add your handling code here:
        jPanel3.setBackground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_jPanel3MouseEntered

    private void jPanel3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseExited
        // TODO add your handling code here:
        jPanel3.setBackground(null);
    }//GEN-LAST:event_jPanel3MouseExited

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
            java.util.logging.Logger.getLogger(DataDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DataDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DataDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DataDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new DataDashboard().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(DataDashboard.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AbdulPanel;
    private javax.swing.JButton COordinatorButton;
    private javax.swing.JButton ChartButton;
    private javax.swing.JLabel CountryCount;
    private javax.swing.JPanel CountryPanel;
    private javax.swing.JLabel EcFigure;
    private javax.swing.JButton ParticipantButton;
    private javax.swing.JButton PartnerButton;
    private javax.swing.JPanel ProjectPanel;
    private javax.swing.JPanel RolePanel;
    private javax.swing.JLabel RoleTittle;
    private javax.swing.JLabel TittleProject;
    private javax.swing.JLabel TotalNumber;
    private javax.swing.JLabel TotalText;
    private javax.swing.JButton ViewTopFive;
    private javax.swing.JButton entityParticipationBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JButton logoutBtn;
    private javax.swing.JButton pieChartButton;
    private javax.swing.JButton projectSearch;
    private javax.swing.JButton searchFunctionButton;
    private javax.swing.JButton topContributionBtn;
    private javax.swing.JLabel totalCountriesInvolved;
    private javax.swing.JLabel usernameLabel;
    // End of variables declaration//GEN-END:variables
}
