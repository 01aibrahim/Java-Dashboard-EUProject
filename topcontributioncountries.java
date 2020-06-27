package dashboardcw;


import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.RefineryUtilities;


/**
 *
 * @author Abdulrahman Ibrahim
 */
public class topcontributioncountries extends javax.swing.JFrame {

    /**
     * Creates new form topcontributioncountries
     */
    public topcontributioncountries () {
        initComponents();
    }

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */

   public topcontributioncountries(String title) {
      super(title); 
      setContentPane(createFramePanel( ));
   }
   
   private static PieDataset createDataset( ) {
      DefaultPieDataset dataset = new DefaultPieDataset( );
      dataset.setValue("Netherlands",(153642924.1));  
      dataset.setValue("Germany",(82135614.37));   
      dataset.setValue("France",(64417190.33));    
      dataset.setValue("United Kingdom",(51048830.75));
      dataset.setValue("Switzerland",(43916158.34));   
      dataset.setValue("Spain",(43089087.77));  
      dataset.setValue("Italy",(36217828.63));  
      dataset.setValue("Belgium",(26261394.62));  
      dataset.setValue("Sweden",(25769140.26));  
      dataset.setValue("Poland",(21501839.7));  
      return dataset;         
   }
   
   private static JFreeChart createChart( PieDataset dataset ) {
      JFreeChart chart = ChartFactory.createPieChart("Top 10 Contributing Countries",dataset,true,true,false);

      return chart;
   }
   
   public static JPanel createFramePanel( ) {
      JFreeChart chart = createChart(createDataset( ) );  
      return new ChartPanel( chart ); 
   }
   

   public static void main( String[ ] args ) {
      topcontributioncountries frame = new topcontributioncountries("Top 10 Contributing Countries");  
      frame.setSize(750,500);    
      //RefineryUtilities.centerFrameOnScreen(frame);    
      frame.setVisible(true);
      
   }
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
