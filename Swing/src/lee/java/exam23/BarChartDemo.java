package lee.java.exam23;
import java.awt.*;
import javax.swing.JPanel;
import org.jfree.chart.*;
import org.jfree.chart.axis.*;
import org.jfree.chart.plot.*;
import org.jfree.chart.renderer.*;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.*;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class BarChartDemo extends ApplicationFrame {
	private static final long serialVersionUID = 1L;

	public BarChartDemo(String title) {
		super(title);
		CategoryDataset dataset = createDataset();
		JFreeChart chart = createChart(dataset);
		ChartPanel chartPanel = new ChartPanel(chart);
		chartPanel.setPreferredSize(new Dimension(500,270));
		setContentPane(chartPanel);
	}
	
	// settings for dataset
	public static CategoryDataset createDataset() {
		// row keys
		String series1 = "First";
		String series2 = "Second";
		String series3 = "Third";
		// column keys
		String category1 = "Category1";
		String category2 = "Category2";
		String category3 = "Category3";
		String category4 = "Category4";
		String category5 = "Category5";
		
		// create dataset
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		dataset.addValue(1.0, series1, category1);
		dataset.addValue(4.0, series1, category2);
		dataset.addValue(3.0, series1, category3);
		dataset.addValue(5.0, series1, category4);
		dataset.addValue(5.0, series1, category5);
		
		dataset.addValue(5.0, series2, category1);
		dataset.addValue(7.0, series2, category2);
		dataset.addValue(6.0, series2, category3);
		dataset.addValue(8.0, series2, category4);
		dataset.addValue(4.0, series2, category5);
		
		dataset.addValue(4.0, series3, category1);
		dataset.addValue(3.0, series3, category2);
		dataset.addValue(2.0, series3, category3);
		dataset.addValue(3.0, series3, category4);
		dataset.addValue(6.0, series3, category5);
		return dataset;
	}
	
	// settings for chart
	public static JFreeChart createChart(CategoryDataset dataset) {
		// create chart
		JFreeChart chart = ChartFactory.createBarChart(
				"Bar Chart Demo", // Title
				"Category", // domain axis			 	 
				"Value", // range axis
				dataset, // dataset
				PlotOrientation.VERTICAL, // orientation
				true, // including legend
				true, // tooltips?
				false); // URLs?
		
		// setting backgrounds color for the chart
		chart.setBackgroundPaint(Color.white);
		
		// customizing the category plot
		CategoryPlot plot = chart.getCategoryPlot();
		plot.setBackgroundPaint(Color.lightGray);
		plot.setDomainGridlinePaint(Color.white);
		plot.setDomainGridlinesVisible(true);
		plot.setRangeGridlinePaint(Color.white);
		
		// settings for range axis to be displayed as integer only
		final NumberAxis rangeAxis = (NumberAxis)plot.getRangeAxis();
		rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
		
		// make disabled bar outlines
		BarRenderer renderer = (BarRenderer)plot.getRenderer();
		renderer.setDrawBarOutline(false);
		
		// setting for painting series
		GradientPaint gpRed = new GradientPaint(
				0.0f, 0.0f, Color.red,
				0.0f, 0.0f, new Color(64, 0, 0));
		GradientPaint gpGreen = new GradientPaint(
				0.0f, 0.0f, Color.green,
				0.0f, 0.0f, new Color(0, 64, 0));
		GradientPaint gpBlue = new GradientPaint(
				0.0f, 0.0f, Color.blue,
				0.0f, 0.0f, new Color(0, 0, 64));
		renderer.setSeriesPaint(0, gpRed);
		renderer.setSeriesPaint(1, gpGreen);
		renderer.setSeriesPaint(2, gpBlue);
		
		// setting for domain Axis
		CategoryAxis domainAxis = plot.getDomainAxis();
		domainAxis.setCategoryLabelPositions(
				CategoryLabelPositions.createUpRotationLabelPositions(Math.PI/6.0));
				
		
		return chart;
	}
	
	public static JPanel createDemoPanel() {
		JFreeChart chart = createChart(createDataset());
		return new ChartPanel(chart);
	}
	
	public static String getDemoDescription() {
		return "This is a bar chart demo for testing.";
	}
	
	public static void main(String[] args) {
		BarChartDemo demo = new BarChartDemo("Bar Chart Demo Test");
		demo.pack();
		RefineryUtilities.centerFrameOnScreen(demo); // 창 중앙에 위치시키기
		demo.setVisible(true);
	}
}
