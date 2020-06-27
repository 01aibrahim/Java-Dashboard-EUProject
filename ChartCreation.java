package dashboardcw;

import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.util.Rotation;

/**
 *
 * @author Abdulrahman Ibrahim
 */

public class ChartCreation extends JFrame {
    //Creating a chart
    public ChartCreation(String panelTitle, String chartTitle, int hes, int rec, int prc, int pub, int oth){
        PieDataset dataset = createDataset(hes,rec,prc,pub,oth);
        JFreeChart chart = chartCreation(dataset, chartTitle);
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(500,300));
        setContentPane(chartPanel);
    }
    //creating the data values that the piechart will hold
    private PieDataset createDataset(int hes, int rec, int prc, int pub, int oth){
        DefaultPieDataset result = new DefaultPieDataset();
        result.setValue("HES", hes);
        result.setValue("REC", rec);
        result.setValue("PRC", prc);
        result.setValue("PUB", pub);
        result.setValue("OTH", oth);
        return result;
        
    }
    //creating the pie chart
    private JFreeChart chartCreation(PieDataset dataset, String title){
        JFreeChart chart = ChartFactory.createPieChart3D(title, dataset, true, true, false);
        PiePlot3D plot = (PiePlot3D) chart.getPlot();
        plot.setStartAngle(0);
        plot.setDirection(Rotation.CLOCKWISE);
        plot.setForegroundAlpha(0.8f);
        return chart;
        
    }    
}
