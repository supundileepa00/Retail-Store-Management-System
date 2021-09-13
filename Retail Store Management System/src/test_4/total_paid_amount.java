package test_4;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

public class total_paid_amount extends JFrame {

	private JPanel contentPane;
	private static JTable table_paid;
	private JTable table_tot;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					total_paid_amount frame = new total_paid_amount();
					frame.setVisible(true);
					Loadpaid();
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
					     pst = con.prepareStatement("SELECT * FROM `expensesf` WHERE paid = 'paid' ");
					     ResultSet  rs = pst.executeQuery();
					     
					     table_paid.setModel(DbUtils.resultSetToTableModel(rs));
					     
					    // pst.executeUpdate();
			//JOptionPane.showMessageDialog(null, "inserted complete!!");
			}catch(Exception e1) {System.out.print(e1);}
			
			
		}
		//end
	
	
	
	

	/**
	 * Create the frame.
	 */
	public total_paid_amount() {
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
		lblNewLabel_6.setBounds(298, 31, 508, 67);
		panel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setBackground(new Color(0, 51, 102));
		lblNewLabel_7.setIcon(new ImageIcon(total_paid_amount.class.getResource("/images/logo2.png")));
		lblNewLabel_7.setBounds(55, 11, 186, 129);
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
		btn_back.setIcon(new ImageIcon(total_paid_amount.class.getResource("/images/back logo.png")));
		btn_back.setBounds(0, 0, 35, 35);
		panel.add(btn_back);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(204, 204, 204));
		panel_1.setBounds(0, 149, 991, 71);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Total Paid Amount");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(130, 30, 266, 19);
		panel_1.add(lblNewLabel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(204, 204, 204));
		panel_2.setBounds(0, 216, 25, 430);
		contentPane.add(panel_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(61, 301, 888, 206);
		contentPane.add(scrollPane);
		
		table_paid = new JTable();
		scrollPane.setViewportView(table_paid);
		
		
		JButton btnNewButton_1 = new JButton("Calculate Total Cost");
		btnNewButton_1.setBackground(new Color(153, 153, 102));
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//start calculation
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/expenses","root","");
				
						     
							PreparedStatement pst;
						     //display data table
						     pst = con.prepareStatement("SELECT SUM(cost) FROM `expensesf` WHERE paid = 'paid' ");
						     ResultSet  rs = pst.executeQuery();
						     table_tot.setModel(DbUtils.resultSetToTableModel(rs));
						    // lbl_tot.setText(DbUtils.resultSetToTableModel(rs));
						    // String as = table_tot.setModel(DbUtils.resultSetToTableModel(rs));
						    // lbl_tot.setText(table_tot);
						  //   txttot.setCaret(DbUtils.resultSetToTableModel(rs));
						     
						     
						    // pst.executeUpdate();
				JOptionPane.showMessageDialog(null, "inserted complete!!");
				}catch(Exception e1) {System.out.print(e1);}
				
				
				
				
				//end
				
				
				
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton_1.setBounds(61, 533, 281, 42);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_1_2 = new JButton("Export Report");
		btnNewButton_1_2.setForeground(new Color(255, 255, 255));
		btnNewButton_1_2.setBackground(new Color(153, 153, 102));
		btnNewButton_1_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton_1_2.setBounds(340, 593, 281, 42);
		contentPane.add(btnNewButton_1_2);
		
		table_tot = new JTable();
		table_tot.setFont(new Font("Tahoma", Font.BOLD, 14));
		table_tot.setShowGrid(false);
		table_tot.setBounds(592, 542, 255, 31);
		contentPane.add(table_tot);
		
		JLabel lblNewLabel = new JLabel("Total Cost");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(417, 547, 140, 14);
		contentPane.add(lblNewLabel);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(140, 244, 204, 31);
		contentPane.add(dateChooser);
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(426, 244, 204, 31);
		contentPane.add(dateChooser_1);
		
		JLabel lblNewLabel_2 = new JLabel("From");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2.setBounds(71, 244, 59, 31);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("To");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_3.setBounds(370, 255, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("Filter by Date");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(153, 153, 102));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				     String get = sdf.format(dateChooser.getDate());

				     String get1 = sdf.format(dateChooser_1.getDate());
				     String sql = "SELECT * FROM expensesf WHERE date(Date) >=   ?  && date(Date)  <= ? && paid = 'paid'";
				     
				     try{
				    	 Class.forName("com.mysql.jdbc.Driver");
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/expenses","root","");

				         PreparedStatement st = conn.prepareStatement(sql);

				        st.setString(1, get);
				        st.setString(2, get1);

				         ResultSet rs = st.executeQuery();
				         table_paid.setModel(DbUtils.resultSetToTableModel(rs));
				       
		JOptionPane.showMessageDialog(null, "inserted complete!!");
	}catch(Exception e1) {System.out.print(e1);}
		
		
		
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(703, 244, 159, 31);
		contentPane.add(btnNewButton);
		
		
	}
}
