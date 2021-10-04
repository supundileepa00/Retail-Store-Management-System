package test_4;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import com.toedter.calendar.JDateChooser;

public class total_amount_topaid extends JFrame {

	private JPanel contentPane;
	private static JTable table_topay;
	private JTable table_tot;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					total_amount_topaid frame = new total_amount_topaid();
					frame.setVisible(true);
					Loadtopay();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	//new
			public static void Loadtopay() {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/expenses","root","");
				
						  //   String lkr = "LKR";
							PreparedStatement pst;
						     //display data table
						     pst = con.prepareStatement("SELECT * FROM `expensesf` WHERE paid = 'paid' ");
						     ResultSet  rs = pst.executeQuery();
						     
						     table_topay.setModel(DbUtils.resultSetToTableModel(rs));
						     
						    // pst.executeUpdate();
				//JOptionPane.showMessageDialog(null, "inserted complete!!");
				}catch(Exception e1) {System.out.print(e1);}
				
				
			}
			//end
	

	/**
	 * Create the frame.
	 */
	public total_amount_topaid() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(100, 100, 450, 300);
		setBounds(100, 100, 1007, 685);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel contentPane_1 = new JPanel();
		contentPane_1.setLayout(null);
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane_1.setBounds(0, 0, 991, 646);
		contentPane.add(contentPane_1);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(0, 51, 102));
		panel.setBounds(0, 0, 1058, 151);
		contentPane_1.add(panel);
		
		JLabel lblNewLabel_6 = new JLabel("Retail Store Management System");
		lblNewLabel_6.setForeground(Color.WHITE);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 32));
		lblNewLabel_6.setBounds(298, 31, 599, 67);
		panel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setIcon(new ImageIcon(total_amount_topaid.class.getResource("/images/logo2.png")));
		lblNewLabel_7.setBounds(55, 11, 197, 129);
		panel.add(lblNewLabel_7);
		
		JButton btn_back = new JButton("");
		btn_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//start
				
				 expenses_chart field= new expenses_chart();
	                field.setVisible(true);
	                field.Loadpaid();
	                field.Loadtopay();
					field.Loadrental();
					field.Loadtransport();
					field.Loadsal();
					field.Loaditme();
	                setVisible(false);
				
				//end
				
			}
		});
		btn_back.setIcon(new ImageIcon(total_amount_topaid.class.getResource("/images/back logo.png")));
		btn_back.setBounds(0, 0, 35, 35);
		panel.add(btn_back);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(204, 204, 204));
		panel_1.setBounds(0, 150, 991, 71);
		contentPane_1.add(panel_1);
		
		JLabel lblNewLabel_1 = new JLabel("Total Amount To be Paid");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(130, 30, 266, 19);
		panel_1.add(lblNewLabel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(204, 204, 204));
		panel_2.setBounds(0, 216, 25, 430);
		contentPane_1.add(panel_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(61, 297, 888, 206);
		contentPane_1.add(scrollPane);
		
		table_topay = new JTable();
		scrollPane.setViewportView(table_topay);
		
		JButton btnNewButton_1 = new JButton("Calculate Total Cost");
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(new Color(153, 153, 102));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				//SELECT 
			   /* SUM(quantityOrdered) SalesQuantity
			    FROM
			        orderdetails;*/
				
//start
			/*	SELECT 
				SUM(quantityOrdered * priceEach)  orderTotal
			FROM
				orderdetails
			WHERE
				orderNumber = 10100;*/
				
				
				//start calculation
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/expenses","root","");
				
						  //   String lkr = "LKR";
							PreparedStatement pst;
						     //display data table
						     pst = con.prepareStatement("SELECT SUM(cost) FROM `expensesf` WHERE paid = 'not' ");
						     ResultSet  rs = pst.executeQuery();
						     
						     table_tot.setModel(DbUtils.resultSetToTableModel(rs));
						     
						    // pst.executeUpdate();
				JOptionPane.showMessageDialog(null, "inserted complete!!");
				}catch(Exception e1) {System.out.print(e1);}
				
				
				
				
				//end
				
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton_1.setBounds(61, 533, 281, 42);
		contentPane_1.add(btnNewButton_1);
		
		JButton btnNewButton_1_2 = new JButton("Export Report");
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//export report
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/expenses","root","");
					String sql = "select * from expensesf where paid = 'not' ";
					
					JasperDesign jdesign = JRXmlLoader.load("D:\\itp\\git rea\\ITP2021_S2_B01_G06\\Retail Store Management System\\src\\test_4\\expenses report.jrxml");
					JRDesignQuery updateQuary = new JRDesignQuery();
					updateQuary.setText(sql);
					
					jdesign.setQuery(updateQuary);
					
					JasperReport Jreport = JasperCompileManager.compileReport(jdesign);
					JasperPrint Jasperprint = JasperFillManager.fillReport(Jreport, null,con);
					
					JasperViewer.viewReport(Jasperprint,false);
					
					
						
				}catch(Exception e1) {System.out.print(e1);}
				
			}
			
			
			
		});
		btnNewButton_1_2.setBackground(new Color(153, 153, 102));
		btnNewButton_1_2.setForeground(new Color(255, 255, 255));
		btnNewButton_1_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton_1_2.setBounds(340, 593, 281, 42);
		contentPane_1.add(btnNewButton_1_2);
		
		table_tot = new JTable();
		table_tot.setShowGrid(false);
		table_tot.setFont(new Font("Tahoma", Font.BOLD, 14));
		table_tot.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		));
		table_tot.setBounds(567, 534, 255, 41);
		contentPane_1.add(table_tot);
		
		JLabel lblNewLabel = new JLabel("Total Cost");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(417, 547, 140, 14);
		contentPane_1.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("From");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2.setBounds(62, 249, 59, 31);
		contentPane_1.add(lblNewLabel_2);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(131, 249, 204, 31);
		contentPane_1.add(dateChooser);
		
		JLabel lblNewLabel_3 = new JLabel("To");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_3.setBounds(361, 260, 46, 14);
		contentPane_1.add(lblNewLabel_3);
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(417, 249, 204, 31);
		contentPane_1.add(dateChooser_1);
		
		JButton btnNewButton = new JButton("Filter by Date");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(153, 153, 102));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			     String get = sdf.format(dateChooser.getDate());

			     String get1 = sdf.format(dateChooser_1.getDate());
			     String sql = "SELECT * FROM expensesf WHERE date(Date) >=   ?  && date(Date)  <= ? && paid = 'not'";
			     
			     try{
			    	 Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/expenses","root","");

			         PreparedStatement st = conn.prepareStatement(sql);

			        st.setString(1, get);
			        st.setString(2, get1);

			         ResultSet rs = st.executeQuery();
			         table_topay.setModel(DbUtils.resultSetToTableModel(rs));
			       
			         JOptionPane.showMessageDialog(null, "inserted complete!!");
			     		}catch(Exception e1) {System.out.print(e1);}
	
	
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(694, 249, 159, 31);
		contentPane_1.add(btnNewButton);
	}
}
