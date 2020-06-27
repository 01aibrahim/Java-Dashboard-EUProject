package dashboardcw;
/**
 *
 * @author Abdulrahman Ibrahim 
 */


import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.TextAnchor;

public class EntityParticipation extends javax.swing.JFrame {
    public EntityParticipation() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.setValue(494, "highereducation", "HES");
        dataset.setValue(147, "private", "PRC");
        dataset.setValue(528, "research", "REC");
        dataset.setValue(79, "public", "PUB");
        dataset.setValue(260, "other", "OTH");
        
        JFreeChart chart = ChartFactory.createBarChart(
                "Participation by Legal Entity Type", "HES - Higher Educ., | PRC - Private | REC - Research | PUB - Public | OTH - Other", "Value", dataset,
                PlotOrientation.VERTICAL, false, false, false);

        CategoryItemRenderer renderer = ((CategoryPlot)chart.getPlot()).getRenderer();

        renderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
        renderer.setBaseItemLabelsVisible(true);
        ItemLabelPosition position = new ItemLabelPosition(ItemLabelAnchor.OUTSIDE12, 
                TextAnchor.TOP_CENTER);
        renderer.setBasePositiveItemLabelPosition(position);

        JFrame frame = new JFrame("Participation by Legal Entity Type");
        frame.add(new ChartPanel(chart));
        frame.setLocationByPlatform(true);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new EntityParticipation();
            }
        });
    }
}