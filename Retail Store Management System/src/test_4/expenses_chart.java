package test_4;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;

public class expenses_chart extends JFrame {

	private JPanel contentPane;
	private static JTable table_tpay;
	private static JTable table_1;
	private static JTable table_rental;
	private static JTable table_trans;
	private static JTable table_sal;
	private static JTable table_item;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				try {
					
					expenses_chart frame = new expenses_chart();
					frame.setVisible(true);
					Loadpaid();
					Loadtopay();
					Loadrental();
					Loadtransport();
					Loadsal();
					Loaditme();
					
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	//new
	public static void Loadpaid() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/expenses","root","");
		
				  //   String lkr = "LKR";
					PreparedStatement pst;
				     //display data table
				     pst = con.prepareStatement("SELECT SUM(cost) FROM `expensesf` WHERE paid = 'paid' ");
				     ResultSet  rs = pst.executeQuery();
				     
				     table_1.setModel(DbUtils.resultSetToTableModel(rs));
				     
				    // pst.executeUpdate();
		//JOptionPane.showMessageDialog(null, "inserted complete!!");
		}catch(Exception e1) {System.out.print(e1);}
		
		
	}
	//end
	
	//new
		public static void Loadtopay() {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/expenses","root","");
			
					  //   String lkr = "LKR";
						PreparedStatement pst;
					     //display data table
					     pst = con.prepareStatement("SELECT SUM(cost) FROM `expensesf` WHERE paid = 'not' ");
					     ResultSet  rs = pst.executeQuery();
					     
					     table_tpay.setModel(DbUtils.resultSetToTableModel(rs));
					     
					     
					    // pst.executeUpdate();
			//JOptionPane.showMessageDialog(null, "inserted complete!!");
			}catch(Exception e1) {System.out.print(e1);}
			
			
		}
		//end
		
		

		//new
			public static void Loadrental() {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/expenses","root","");
				
						  //   String lkr = "LKR";
							PreparedStatement pst;
						     //display data table
						     pst = con.prepareStatement("SELECT SUM(cost) Reantal FROM `expensesf` WHERE type = 'Rental' ");
						     ResultSet  rs = pst.executeQuery();
						     
						     
						     table_rental.setModel(DbUtils.resultSetToTableModel(rs));
						     
						     
						     
						    // pst.executeUpdate();
				//JOptionPane.showMessageDialog(null, "inserted complete!!");
				}catch(Exception e1) {System.out.print(e1);}
				
				
			}
			//end
			
			//new
			public static void Loadtransport() {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/expenses","root","");
				
						  //   String lkr = "LKR";
							PreparedStatement pst;
						     //display data table
						     pst = con.prepareStatement("SELECT SUM(cost) Reantal FROM `expensesf` WHERE type = 'Transport' ");
						     ResultSet  rs = pst.executeQuery();
						     
						     
						     table_trans.setModel(DbUtils.resultSetToTableModel(rs));
						     
						     
						     
						    // pst.executeUpdate();
				//JOptionPane.showMessageDialog(null, "inserted complete!!");
				}catch(Exception e1) {System.out.print(e1);}
				
				
			}
			//end
			
			//new
			public static void Loadsal() {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/expenses","root","");
				
						  //   String lkr = "LKR";
							PreparedStatement pst;
						     //display data table
						     pst = con.prepareStatement("SELECT SUM(cost) Reantal FROM `expensesf` WHERE type = 'salary' ");
						     ResultSet  rs = pst.executeQuery();
						     
						     
						     table_sal.setModel(DbUtils.resultSetToTableModel(rs));
						     
						     
						     
						    // pst.executeUpdate();
				//JOptionPane.showMessageDialog(null, "inserted complete!!");
				}catch(Exception e1) {System.out.print(e1);}
				
				
			}
			//end
			
			//new
			public static void Loaditme() {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/expenses","root","");
				
						  //   String lkr = "LKR";
							PreparedStatement pst;
						     //display data table
						     pst = con.prepareStatement("SELECT SUM(cost) Reantal FROM `expensesf` WHERE type = 'items' ");
						     ResultSet  rs = pst.executeQuery();
						     
						     
						     table_item.setModel(DbUtils.resultSetToTableModel(rs));
						     
						     
						     
						    // pst.executeUpdate();
				//JOptionPane.showMessageDialog(null, "inserted complete!!");
				}catch(Exception e1) {System.out.print(e1);}
				
				
			}
			//end
		
	
	
	
	/**
	 * Create the frame.
	 */
	public expenses_chart() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(100, 100, 450, 300);
		setBounds(100, 100, 1007, 685);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(0, 51, 102));
		panel.setBounds(0, 0, 1058, 151);
		contentPane.add(panel);
		
		JLabel lblNewLabel_6 = new JLabel("Retail Store Management System");
		lblNewLabel_6.setForeground(Color.WHITE);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 32));
		lblNewLabel_6.setBounds(246, 36, 558, 67);
		panel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setIcon(new ImageIcon(expenses_chart.class.getResource("/images/logo2.png")));
		lblNewLabel_7.setBounds(63, 11, 204, 131);
		panel.add(lblNewLabel_7);
		
		JButton btn_back = new JButton("");
		btn_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//start
				
				 add_expenses field= new add_expenses();
	                field.setVisible(true);
	                field.Loadtable();
	                setVisible(false);
				
				//end
				
			}
		});
		btn_back.setIcon(new ImageIcon(expenses_chart.class.getResource("/images/back logo.png")));
		btn_back.setBounds(0, 0, 35, 35);
		panel.add(btn_back);
		
		JButton btnNewButton_4 = new JButton("Home");
		btnNewButton_4.setForeground(new Color(255, 255, 255));
		btnNewButton_4.setBackground(new Color(0, 51, 102));
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_4.setBounds(895, 128, 89, 23);
		panel.add(btnNewButton_4);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(204, 204, 204));
		panel_1.setBounds(0, 150, 509, 496);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		table_rental = new JTable();
		table_rental.setBackground(new Color(204, 204, 204));
		table_rental.setForeground(Color.RED);
		table_rental.setShowGrid(false);
		table_rental.setFont(new Font("Tahoma", Font.BOLD, 18));
		table_rental.setBounds(55, 390, 121, 28);
		panel_1.add(table_rental);
		
		JLabel lblNewLabel_2 = new JLabel("Total Rental Cost");
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2.setBounds(34, 362, 203, 28);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Total Transport Cost");
		lblNewLabel_2_1.setForeground(new Color(0, 0, 255));
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2_1.setBounds(279, 362, 203, 28);
		panel_1.add(lblNewLabel_2_1);
		
		table_trans = new JTable();
		table_trans.setShowGrid(false);
		table_trans.setForeground(new Color(0, 0, 255));
		table_trans.setFont(new Font("Tahoma", Font.BOLD, 18));
		table_trans.setBackground(new Color(204, 204, 204));
		table_trans.setBounds(329, 390, 121, 28);
		panel_1.add(table_trans);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Total Salary Cost");
		lblNewLabel_2_1_1.setForeground(Color.GREEN);
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2_1_1.setBounds(34, 429, 203, 28);
		panel_1.add(lblNewLabel_2_1_1);
		
		table_sal = new JTable();
		table_sal.setShowGrid(false);
		table_sal.setForeground(Color.GREEN);
		table_sal.setFont(new Font("Tahoma", Font.BOLD, 18));
		table_sal.setBackground(new Color(204, 204, 204));
		table_sal.setBounds(55, 457, 121, 28);
		panel_1.add(table_sal);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("Total Item Cost");
		lblNewLabel_2_1_1_1.setForeground(Color.YELLOW);
		lblNewLabel_2_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2_1_1_1.setBounds(279, 429, 203, 28);
		panel_1.add(lblNewLabel_2_1_1_1);
		
		table_item = new JTable();
		table_item.setShowGrid(false);
		table_item.setForeground(Color.YELLOW);
		table_item.setFont(new Font("Tahoma", Font.BOLD, 18));
		table_item.setBackground(new Color(204, 204, 204));
		table_item.setBounds(329, 457, 121, 28);
		panel_1.add(table_item);
		
		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.setBounds(55, 54, 375, 253);
		panel_1.add(btnNewButton_3);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				 PieChart demo = new PieChart("Comparison", "Total Cost Analysis");
		            demo.pack();
		            demo.setVisible(true);
				
				
			}
		});
		btnNewButton_3.setBackground(new Color(204, 204, 204));
		btnNewButton_3.setIcon(new ImageIcon(expenses_chart.class.getResource("/images/Hnet.com-image (2).png")));
		
		JLabel lblNewLabel_3 = new JLabel("Click to analys");
		lblNewLabel_3.setBounds(65, 96, 90, 14);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("LKR");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_4.setBounds(10, 393, 35, 25);
		panel_1.add(lblNewLabel_4);
		
		JLabel lblNewLabel_4_1 = new JLabel("LKR");
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_4_1.setBounds(284, 388, 35, 25);
		panel_1.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_4_2 = new JLabel("LKR");
		lblNewLabel_4_2.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_4_2.setBounds(10, 455, 35, 25);
		panel_1.add(lblNewLabel_4_2);
		
		JLabel lblNewLabel_4_1_1 = new JLabel("LKR");
		lblNewLabel_4_1_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_4_1_1.setBounds(279, 460, 35, 25);
		panel_1.add(lblNewLabel_4_1_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(507, 150, 484, 496);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Total amount to be paid");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(22, 62, 232, 38);
		panel_2.add(lblNewLabel);
		
		table_tpay = new JTable();
		table_tpay.setShowGrid(false);
		table_tpay.setFont(new Font("Tahoma", Font.PLAIN, 18));
		table_tpay.setBounds(44, 120, 210, 25);
		panel_2.add(table_tpay);
		
		JButton btnNewButton = new JButton("Show Details");
		btnNewButton.setBackground(new Color(153, 153, 102));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//start
			
				 total_amount_topaid field= new total_amount_topaid();
	             
				 field.setVisible(true);
	                setVisible(false);
	                field.Loadtopay();
				
				//end
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.setBounds(264, 123, 210, 39);
		panel_2.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Total paid amount");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(22, 217, 224, 47);
		panel_2.add(lblNewLabel_1);
		
		table_1 = new JTable();
		table_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		table_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table_1.setShowVerticalLines(false);
		table_1.setShowHorizontalLines(false);
		table_1.setShowGrid(false);
		table_1.setBounds(44, 271, 210, 25);
		panel_2.add(table_1);
		
		JButton btnNewButton_1 = new JButton("Show Details");
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(new Color(153, 153, 102));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//start
				
				 total_paid_amount field= new total_paid_amount();
	                field.setVisible(true);
	                setVisible(false);
	                field.Loadpaid();
	                
				
				//end
				
				
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton_1.setBounds(264, 271, 210, 39);
		panel_2.add(btnNewButton_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(204, 204, 204));
		panel_3.setBounds(0, 435, 484, 61);
		panel_2.add(panel_3);
		panel_3.setLayout(null);
		
		JButton btnNewButton_2 = new JButton("Genarate Report");
		btnNewButton_2.setBackground(new Color(153, 153, 102));
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 expenses_report field= new expenses_report();
					// 	field.Loadpaid();
		                field.setVisible(true);
		                setVisible(false);
		                field.Loadtable();
					
				
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton_2.setBounds(65, 11, 264, 39);
		panel_3.add(btnNewButton_2);
		
		JLabel lblNewLabel_4_1_2 = new JLabel("LKR");
		lblNewLabel_4_1_2.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_4_1_2.setBounds(10, 118, 35, 25);
		panel_2.add(lblNewLabel_4_1_2);
		
		JLabel lblNewLabel_4_1_2_1 = new JLabel("LKR");
		lblNewLabel_4_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_4_1_2_1.setBounds(10, 274, 35, 25);
		panel_2.add(lblNewLabel_4_1_2_1);
				
	}
}
