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
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;

public class expenses_report extends JFrame {

	private JPanel contentPane;
	private static JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					expenses_report frame = new expenses_report();
					frame.setVisible(true);
					Loadtable();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	
	//new
	public static void Loadtable() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/expenses","root","");
		
				  //   String lkr = "LKR";
					PreparedStatement pst;
				     //display data table
				     pst = con.prepareStatement("SELECT * FROM `expensesf`  ");
				     ResultSet  rs = pst.executeQuery();
				     
				     table.setModel(DbUtils.resultSetToTableModel(rs));
				     
				    // pst.executeUpdate();
		//JOptionPane.showMessageDialog(null, "inserted complete!!");
		}catch(Exception e1) {System.out.print(e1);}
		
		
	}
	//end
	
	

	/**
	 * Create the frame.
	 */
	public expenses_report() {
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
		lblNewLabel_6.setBounds(298, 31, 636, 67);
		panel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setIcon(new ImageIcon(expenses_report.class.getResource("/images/logo2.png")));
		lblNewLabel_7.setBounds(60, 0, 190, 140);
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
		btn_back.setIcon(new ImageIcon(expenses_report.class.getResource("/images/back logo.png")));
		btn_back.setBounds(0, 0, 35, 35);
		panel.add(btn_back);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(204, 204, 204));
		panel_1.setBounds(0, 149, 991, 71);
		contentPane.add(panel_1);
		
		JLabel lblNewLabel_1 = new JLabel("Expenses Report");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(130, 30, 266, 30);
		panel_1.add(lblNewLabel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(204, 204, 204));
		panel_2.setBounds(0, 216, 25, 430);
		contentPane.add(panel_2);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(45, 294, 915, 266);
		contentPane.add(scrollPane_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane_1.setViewportView(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnNewButton_1_2 = new JButton("Export Report");
		btnNewButton_1_2.setBackground(new Color(153, 153, 102));
		btnNewButton_1_2.setForeground(new Color(255, 255, 255));
		btnNewButton_1_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton_1_2.setBounds(406, 582, 281, 42);
		contentPane.add(btnNewButton_1_2);
		
		JLabel lblNewLabel_2 = new JLabel("From");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2.setBounds(59, 241, 59, 31);
		contentPane.add(lblNewLabel_2);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(128, 241, 204, 31);
		contentPane.add(dateChooser);
		
		JLabel lblNewLabel_3 = new JLabel("To");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_3.setBounds(358, 252, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(414, 241, 204, 31);
		contentPane.add(dateChooser_1);
		
		JButton btnNewButton = new JButton("Filter by Date");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(153, 153, 102));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			     String get = sdf.format(dateChooser.getDate());

			     String get1 = sdf.format(dateChooser_1.getDate());
			     String sql = "SELECT * FROM expensesf WHERE date(Date) >=   ?  && date(Date)  <= ? ";
			     
			     try{
			    	 Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/expenses","root","");

			         PreparedStatement st = conn.prepareStatement(sql);

			        st.setString(1, get);
			        st.setString(2, get1);

			         ResultSet rs = st.executeQuery();
			         table.setModel(DbUtils.resultSetToTableModel(rs));
			       
			         JOptionPane.showMessageDialog(null, "inserted complete!!");
			     		}catch(Exception e1) {System.out.print(e1);}
	
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(691, 241, 159, 31);
		contentPane.add(btnNewButton);
	}
}
