package lee.java.exam24;
import java.awt.*;
import javax.swing.*;
import org.jfree.chart.*;
import org.jfree.chart.axis.*;
import org.jfree.chart.plot.*;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.*;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class WeatherBarGraph extends ApplicationFrame {
	private static final long serialVersionUID = 1L;

	public WeatherBarGraph(String title) {
		super(title);
		setLayout(new BorderLayout());
		JPanel jp = new JPanel(new BorderLayout());
		jp.add("West", new JLabel("* 2016�� ����� ������ ���� *", JLabel.LEFT)); // �� ���� �� jp Panel�� ���
		
		// �����ͼ� ��ü ����
		CategoryDataset dataset = createDataset();
		// �����ͼ��� ���� ��Ʈ ��ü ����
		JFreeChart chart = createChart(dataset);
		// ��Ʈ ��ü�� ���� ��Ʈ Panel ����
		ChartPanel chartPanel = new ChartPanel(chart);
		chartPanel.setPreferredSize(new Dimension(700,600)); // ��Ʈ Panel ũ�� ����(�˸°� ������)
		JPanel jps = new JPanel(new BorderLayout()); // ���� ���� �󺧰� ��Ʈ �г��� �Բ� ���� JPanel
		jps.add("North", jp); // JPanel�� ���� �� ���
		jps.add("Center", chartPanel); // ��Ʈ �г� ���
		setContentPane(jps); // ȭ�鿡 ��� ������ ���� ��ü �г� ����(����)
	}
	
	// �����ͼ� ����
	public static CategoryDataset createDataset() {
		// �� : ������ & �����ϼ�
		String rainFallVolume = "Rain Fall Volume(ml)";
		String rainyDays = "Rainy Days(day)";
		// �� : ��(month)
		String category1 = "Jan";
		String category2 = "Feb";
		String category3 = "Mar";
		String category4 = "Apr";
		String category5 = "May";
		String category6 = "Jun";
		String category7 = "Jul";
		String category8 = "Aug";
		String category9 = "Sep";
		String category10 = "Oct";
		String category11 = "Nov";
		String category12 = "Dec";
		
		// �����ͼ�
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		// ������ ������ �Է�
		dataset.addValue(1.0, rainFallVolume, category1);
		dataset.addValue(47.6, rainFallVolume, category2);
		dataset.addValue(40.5, rainFallVolume, category3);
		dataset.addValue(76.8, rainFallVolume, category4);
		dataset.addValue(160.5, rainFallVolume, category5);
		dataset.addValue(54.4, rainFallVolume, category6);
		dataset.addValue(358.2, rainFallVolume, category7);
		dataset.addValue(67.1, rainFallVolume, category8);
		dataset.addValue(33.0, rainFallVolume, category9);
		dataset.addValue(74.8, rainFallVolume, category10);
		dataset.addValue(16.7, rainFallVolume, category11);
		dataset.addValue(61.1, rainFallVolume, category12);

		// �����ϼ� ������ �Է�
		dataset.addValue(4.0, rainyDays, category1);
		dataset.addValue(8.0, rainyDays, category2);
		dataset.addValue(5.0, rainyDays, category3);
		dataset.addValue(10.0, rainyDays, category4);
		dataset.addValue(9.0, rainyDays, category5);
		dataset.addValue(8.0, rainyDays, category6);
		dataset.addValue(17.0, rainyDays, category7);
		dataset.addValue(11.0, rainyDays, category8);
		dataset.addValue(7.0, rainyDays, category9);
		dataset.addValue(9.0, rainyDays, category10);
		dataset.addValue(11.0, rainyDays, category11);
		dataset.addValue(10.0, rainyDays, category12);
	
		return dataset;
	}
	
	// ��Ʈ ����
	public static JFreeChart createChart(CategoryDataset dataset) {
		// create chart
		JFreeChart chart = ChartFactory.createBarChart(
				"The RainFall Distribution on Seoul in 2016", // ��Ʈ ����
				"Month", // ������		 	 
				"Rainfall(ml)", // range(�� �� ����)
				dataset, // �����ͼ�
				PlotOrientation.VERTICAL, // ��Ʈ �������� 
				true, // legend ����
				true, // tooltips
				false); // URLs X
		
		// ��Ʈ ���� : ���
		chart.setBackgroundPaint(Color.white);
		
		// ī�װ� ���� ����
		CategoryPlot plot = chart.getCategoryPlot();
		plot.setBackgroundPaint(Color.white); // ��Ʈ ���� ���� : ���
		plot.setDomainGridlinePaint(Color.yellow); // ������ ���� �Ǽ� : �����
		plot.setDomainGridlinesVisible(true); // ������ ���� gridline ���̱�
		plot.setRangeGridlinePaint(Color.yellow); // range �� ���� �Ǽ� : �����
		
		// ��Ʈ ������ ���� double�� ���� ������ �Է� ������ ���������� ��Ÿ�������� ����
		// ���� ������ 20���� ����
		final NumberAxis rangeAxis = (NumberAxis)plot.getRangeAxis();
		rangeAxis.setTickUnit(new NumberTickUnit(20.0));

		rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
		// ��Ʈ �ƿ����� �Ⱥ��̵��� ����
		BarRenderer renderer = (BarRenderer)plot.getRenderer();
		renderer.setDrawBarOutline(false);
		
		// �� ��(series), �� ��Ʈ �� ���� ���� ����
		// ������ ���� �� : �����
		GradientPaint gpYellow = new GradientPaint(
				0.0f, 0.0f, Color.yellow,
				0.0f, 0.0f, new Color(64, 64, 0));
		// �����ϼ� ���� �� : �ʷϻ�
		GradientPaint gpGreen = new GradientPaint(
				0.0f, 0.0f, Color.green,
				0.0f, 0.0f, new Color(0, 64, 0));
		renderer.setSeriesPaint(0, gpYellow);
		renderer.setSeriesPaint(1, gpGreen);
		
		// ������ ���� ����
		CategoryAxis domainAxis = plot.getDomainAxis();
		domainAxis.setCategoryLabelPositions(
				// ������ ������ �� �� ��¦ ����̱�
				CategoryLabelPositions.createUpRotationLabelPositions(Math.PI/6.0));
				
		return chart;
	}
	
	// ���ο� ��Ʈ
	public static JPanel createDemoPanel() {
		JFreeChart chart = createChart(createDataset());
		return new ChartPanel(chart);
	}
	
	// ��Ʈ ����(Description)
	public static String getDemoDescription() {
		return "This is a bar chart demo";
	}
	
	public static void main(String[] args) {
		// â Title
		WeatherBarGraph demo = new WeatherBarGraph("���� ��� ������ �ð�ȭ ���α׷�");
		demo.pack();
		RefineryUtilities.centerFrameOnScreen(demo); // â �߾ӿ� ��ġ��Ű��
		demo.setVisible(true);
	}
}






