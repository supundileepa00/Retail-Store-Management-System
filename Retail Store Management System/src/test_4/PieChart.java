package test_4;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.util.Rotation;

public class PieChart extends JFrame {

	private static final long serialVersionUID = 1L;

    public PieChart(String applicationTitle, String chartTitle) {
        super(applicationTitle);
        // This will create the dataset
        PieDataset dataset = createDataset();
        // based on the dataset we create the chart
        JFreeChart chart = createChart(dataset, chartTitle);
        // we put the chart into a panel
        ChartPanel chartPanel = new ChartPanel(chart);
        // default size
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
        // add it to our application
        setContentPane(chartPanel);

    }

    /**
     * Creates a sample dataset
     */
    private  PieDataset createDataset() {
    	DefaultPieDataset result = new DefaultPieDataset();
    	//for rental
    	 try {
	            
			    Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/expenses","root","");
				Statement stmt = con.createStatement();
				ResultSet rs;
				//DefaultPieDataset result = new DefaultPieDataset();	
	            rs = stmt.executeQuery("SELECT SUM(cost) Reantal FROM `expensesf` WHERE type = 'Rental'");
	            while ( rs.next() ) {
	                String myDate = rs.getString(1);
	              //  System.out.println(myDate);
	                int number = Integer.parseInt(myDate);
	              //  System.out.println(number);
	                result.setValue("Rental",number );
	                
	            }
	            
	            //con.close();
        } catch (Exception e) {
	            System.err.println("Got an exception! ");
	            System.err.println(e.getMessage());
	        }
    	 
    	 //for transport
    	 try {
	            
			    Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/expenses","root","");
				Statement stmt = con.createStatement();
				ResultSet rs;
				//DefaultPieDataset result = new DefaultPieDataset();	
	            rs = stmt.executeQuery("SELECT SUM(cost) Reantal FROM `expensesf` WHERE type = 'Transport' ");
	            while ( rs.next() ) {
	                String myDate = rs.getString(1);
	              //  System.out.println(myDate);
	                int number = Integer.parseInt(myDate);
	              //  System.out.println(number);
	                result.setValue("Transport",number );
	                
	            }
	            
	            //con.close();
     } catch (Exception e) {
	            System.err.println("Got an exception! ");
	            System.err.println(e.getMessage());
	        }
    	 //for salary
    	 try {
	            
			    Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/expenses","root","");
				Statement stmt = con.createStatement();
				ResultSet rs;
				//DefaultPieDataset result = new DefaultPieDataset();	
	            rs = stmt.executeQuery("SELECT SUM(cost) Reantal FROM `expensesf` WHERE type = 'salary' ");
	            while ( rs.next() ) {
	                String myDate = rs.getString(1);
	              //  System.out.println(myDate);
	                int number = Integer.parseInt(myDate);
	              //  System.out.println(number);
	                result.setValue("Salary",number );
	                
	            }
	            
	            //con.close();
     } catch (Exception e) {
	            System.err.println("Got an exception! ");
	            System.err.println(e.getMessage());
	        }
    	 
    	 //for items
    	 try {
	            
			    Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/expenses","root","");
				Statement stmt = con.createStatement();
				ResultSet rs;
				//DefaultPieDataset result = new DefaultPieDataset();	
	            rs = stmt.executeQuery("SELECT SUM(cost) Reantal FROM `expensesf` WHERE type = 'items' ");
	            while ( rs.next() ) {
	                String myDate = rs.getString(1);
	              //  System.out.println(myDate);
	                int number = Integer.parseInt(myDate);
	              //  System.out.println(number);
	                result.setValue("Items",number );
	                
	            }
	            
	            //con.close();
  } catch (Exception e) {
	            System.err.println("Got an exception! ");
	            System.err.println(e.getMessage());
	        }
 	 
    	 
    	
     //   DefaultPieDataset result = new DefaultPieDataset();
       //result.setValue("Transport", );
//        result.setValue("Rental", 20);
//        result.setValue("Items", 51);
 //       result.setValue("Salary", 20);
        
       return result;

    }

    /**
     * Creates a chart
     */
    private JFreeChart createChart(PieDataset dataset, String title) {

        JFreeChart chart = ChartFactory.createPieChart3D(
            title,                  // chart title
            dataset,                // data
            true,                   // include legend
            true,
            false
        );

        PiePlot3D plot = (PiePlot3D) chart.getPlot();
        plot.setStartAngle(290);
        plot.setDirection(Rotation.CLOCKWISE);
        plot.setForegroundAlpha(0.5f);
        return chart;

	}

}
