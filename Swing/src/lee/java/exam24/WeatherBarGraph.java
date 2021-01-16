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
		jp.add("West", new JLabel("* 2016년 서울시 강수량 분포 *", JLabel.LEFT)); // 맨 윗쪽 라벨 jp Panel에 담기
		
		// 데이터셋 객체 생성
		CategoryDataset dataset = createDataset();
		// 데이터셋을 담은 차트 객체 생성
		JFreeChart chart = createChart(dataset);
		// 차트 객체를 담은 차트 Panel 생성
		ChartPanel chartPanel = new ChartPanel(chart);
		chartPanel.setPreferredSize(new Dimension(700,600)); // 차트 Panel 크기 설정(알맞게 적당히)
		JPanel jps = new JPanel(new BorderLayout()); // 북쪽 제목 라벨과 차트 패널을 함께 담을 JPanel
		jps.add("North", jp); // JPanel에 북쪽 라벨 담기
		jps.add("Center", chartPanel); // 차트 패널 담기
		setContentPane(jps); // 화면에 모든 정보를 담은 전체 패널 띄우기(설정)
	}
	
	// 데이터셋 설정
	public static CategoryDataset createDataset() {
		// 행 : 강수량 & 강수일수
		String rainFallVolume = "Rain Fall Volume(ml)";
		String rainyDays = "Rainy Days(day)";
		// 열 : 월(month)
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
		
		// 데이터셋
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		// 강수량 데이터 입력
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

		// 강수일수 데이터 입력
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
	
	// 차트 설정
	public static JFreeChart createChart(CategoryDataset dataset) {
		// create chart
		JFreeChart chart = ChartFactory.createBarChart(
				"The RainFall Distribution on Seoul in 2016", // 차트 제목
				"Month", // 도메인		 	 
				"Rainfall(ml)", // range(행 값 범위)
				dataset, // 데이터셋
				PlotOrientation.VERTICAL, // 차트 수직으로 
				true, // legend 포함
				true, // tooltips
				false); // URLs X
		
		// 차트 배경색 : 흰색
		chart.setBackgroundPaint(Color.white);
		
		// 카테고리 영역 설정
		CategoryPlot plot = chart.getCategoryPlot();
		plot.setBackgroundPaint(Color.white); // 차트 영역 배경색 : 흰색
		plot.setDomainGridlinePaint(Color.yellow); // 도메인 격자 실선 : 노란색
		plot.setDomainGridlinesVisible(true); // 도메인 영역 gridline 보이기
		plot.setRangeGridlinePaint(Color.yellow); // range 값 격자 실선 : 노란색
		
		// 차트 데이터 값이 double로 들어가기 때문에 입력 값들을 정수형으로 나타나지도록 설정
		// 값의 간격은 20으로 설정
		final NumberAxis rangeAxis = (NumberAxis)plot.getRangeAxis();
		rangeAxis.setTickUnit(new NumberTickUnit(20.0));

		rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
		// 차트 아웃라인 안보이도록 설정
		BarRenderer renderer = (BarRenderer)plot.getRenderer();
		renderer.setDrawBarOutline(false);
		
		// 행 값(series), 즉 차트 상 막대 색상 설정
		// 강수량 막대 색 : 노란색
		GradientPaint gpYellow = new GradientPaint(
				0.0f, 0.0f, Color.yellow,
				0.0f, 0.0f, new Color(64, 64, 0));
		// 강수일수 막대 색 : 초록색
		GradientPaint gpGreen = new GradientPaint(
				0.0f, 0.0f, Color.green,
				0.0f, 0.0f, new Color(0, 64, 0));
		renderer.setSeriesPaint(0, gpYellow);
		renderer.setSeriesPaint(1, gpGreen);
		
		// 도메인 영역 설정
		CategoryAxis domainAxis = plot.getDomainAxis();
		domainAxis.setCategoryLabelPositions(
				// 도메인 영역의 월 라벨 살짝 기울이기
				CategoryLabelPositions.createUpRotationLabelPositions(Math.PI/6.0));
				
		return chart;
	}
	
	// 새로운 차트
	public static JPanel createDemoPanel() {
		JFreeChart chart = createChart(createDataset());
		return new ChartPanel(chart);
	}
	
	// 차트 설명(Description)
	public static String getDemoDescription() {
		return "This is a bar chart demo";
	}
	
	public static void main(String[] args) {
		// 창 Title
		WeatherBarGraph demo = new WeatherBarGraph("날씨 통계 데이터 시각화 프로그램");
		demo.pack();
		RefineryUtilities.centerFrameOnScreen(demo); // 창 중앙에 위치시키기
		demo.setVisible(true);
	}
}






