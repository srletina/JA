package tests.testjfreechart;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Locale;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.DefaultOHLCDataset;
import org.jfree.data.xy.OHLCDataItem;
import org.jfree.data.xy.OHLCDataset;

/**
 * @author imssbora
 */
public class OHLC extends JFrame {
  private static final long serialVersionUID = 6294689542092367723L;

  public OHLC(String title) {
    super(title);

    // Create dataset
    OHLCDataset dataset = createDataset();

    // Create chart
    JFreeChart chart = ChartFactory.createHighLowChart(
        "OHLC Stock chart | BORAJI.COM", 
        "Date", "Price", dataset, true);
    
    XYPlot plot = (XYPlot) chart.getPlot();
    NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
    rangeAxis.setAutoRangeIncludesZero(false);

    // Create Panel
    ChartPanel panel = new ChartPanel(chart);
    setContentPane(panel);
  }

  private OHLCDataset createDataset() {
	  SimpleDateFormat format = new SimpleDateFormat("d MMM, yyyy", Locale.US);
	  System.out.println("Locale.US " + Locale.US);
	  System.out.println("Locale.ROOT " + Locale.ROOT);
	  System.out.println("Locale.getDefault() " + Locale.getDefault());
	  System.out.println("Locale.getISOCountries() " + Arrays.toString(Locale.getISOCountries()));
  	  
    OHLCDataItem dataItem[] = null;

    try {
    	//OHLCDataItem test = new OHLCDataItem(date, open, high, low, close, volume)
      OHLCDataItem data1 = new OHLCDataItem(format.parse("8 Feb, 2017"), 
          288.00, 288.50, 282.70, 285.80, 15148100);
      OHLCDataItem data2 = new OHLCDataItem(format.parse("7 Feb, 2017"), 
          288.00, 292.70, 285.30, 288.10, 11663000);
      OHLCDataItem data3 = new OHLCDataItem(format.parse("6 Feb, 2017 "), 
          283.55, 292.25, 283.55, 290.30, 20474400);
      OHLCDataItem data4 = new OHLCDataItem(format.parse("3 Feb, 2017"), 
          284.95, 284.95, 278.80, 281.55, 18235300);
      OHLCDataItem data5 = new OHLCDataItem(format.parse("2 Feb, 2017"), 
          282.00, 287.50, 280.55, 285.80, 26282600);
      OHLCDataItem data6 = new OHLCDataItem(format.parse("1 Feb, 2017"), 
          265.85, 283.50, 262.80, 281.00, 40588400);
      OHLCDataItem data7 = new OHLCDataItem(format.parse("31 Jan, 2017"), 
          268.80, 274.00, 266.45, 268.95, 18668300);
      OHLCDataItem data8 = new OHLCDataItem(format.parse("30 Jan, 2017"), 
          273.00, 275.60, 269.70, 270.80, 15488600);
      OHLCDataItem data9 = new OHLCDataItem(format.parse("27 Jan, 2017"), 
          263.05, 274.00, 260.70, 272.00, 81303300);
      OHLCDataItem data10 = new OHLCDataItem(format.parse("26 Jan, 2017"), 
          259.95, 259.95, 259.95, 259.95, 0);

      dataItem = new OHLCDataItem[] { 
          data1, data2, data3, data4, data5, 
          data6, data7, data8, data9, data10
        };

    } catch (ParseException e) {
      e.printStackTrace();
    }

    OHLCDataset dataset = new DefaultOHLCDataset("ICICI BANK INR2 (NSE)", dataItem);
    return dataset;
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> {
    	OHLC example = new OHLC(
          "High Low Chart Example | BORAJI.COM");
      example.setSize(800, 400);
      example.setLocationRelativeTo(null);
      example.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
      example.setVisible(true);
    });
  }
}