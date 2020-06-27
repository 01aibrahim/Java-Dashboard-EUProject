package dashboardcw;

import java.awt.Color;
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
//  This class creates a Pie Chart, it stores the Data and design.
public class ViewPieChart extends JFrame {

    // In here, it creates the datset, the chart and it adds the chart it the panel 
    public ViewPieChart() {
        PieDataset dataset = createDataset();
        JFreeChart chart = createChart(dataset);
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 300));
        setContentPane(chartPanel);
    }

    // We store the data 
    private PieDataset createDataset() {
        DefaultPieDataset result = new DefaultPieDataset();
        result.setValue("Partner", 20);
        result.setValue("Participant", 1092);
        result.setValue("Co-ordinator", 396);
        return result;
    }

    // The Chart is created in here, and we customise it to suit our design.
    private JFreeChart createChart(PieDataset dataset) {

        // Inside the brackets ( Chart Tittle, Data & Legends) 
        JFreeChart chart = ChartFactory.createPieChart3D("Different Types of Roles", dataset, true, true, false);

        PiePlot3D plot = (PiePlot3D) chart.getPlot();
        plot.setStartAngle(0);
        plot.setDirection(Rotation.CLOCKWISE);
        plot.setForegroundAlpha(0.5f);
        plot.setBackgroundPaint(Color.white);
        plot.setOutlinePaint(Color.white);

        return chart;
    }

}
