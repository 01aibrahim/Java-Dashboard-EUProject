package dashboardcw;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Abdulrahman Ibrahim
 */
public class ViewCountryCount extends JFrame {

    // In here we create the dataset, chart and add the chart to the panel. 
    public ViewCountryCount() {

        CategoryDataset dataset = createDataset();
        JFreeChart chart = createChart(dataset);
        ChartPanel chartPanel = new ChartPanel(chart);

        chartPanel.setPreferredSize(new Dimension(500, 270));
        setContentPane(chartPanel);

    }

    // This method puts the values into their bar chart 
    private CategoryDataset createDataset() {

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.setValue(148, "Total Number", "DE");            // Germany
        dataset.setValue(142, "Total Number", "ES");            // Spain
        dataset.setValue(131, "Total Number", "FR");            // France 
        dataset.setValue(118, "Total Number", "IT");            // Italy
        dataset.setValue(106, "Total Number", "UK");            // United Kingdom

        return dataset;
    }
    

    // This method creates the chart 
    private JFreeChart createChart(CategoryDataset dataset) {

        // Within the Brackets ( Chart Tittle, x-axis, y-axis)
        JFreeChart chart = ChartFactory.createBarChart("Top 5 Countries", "Country Name", "Total Project Number", dataset, PlotOrientation.VERTICAL, false, true, false);

        CategoryPlot p = chart.getCategoryPlot();
        p.setRangeGridlinePaint(Color.black);

        return chart;

    }

}
