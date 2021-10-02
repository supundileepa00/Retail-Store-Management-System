package customer_management;

import java.awt.EventQueue;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Font;

public class Logincustomer {

	private JFrame frame;
	private JPasswordField password;
	private JTextField txtusername;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Logincustomer window = new Logincustomer();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Logincustomer() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1024, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 204, 204));
		panel.setBounds(378, 101, 630, 580);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("UserName");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(128, 164, 120, 25);
		panel.add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPassword.setBounds(128, 219, 120, 25);
		panel.add(lblPassword);
		
		password = new JPasswordField();
		password.setBounds(344, 217, 185, 34);
		panel.add(password);
		
		txtusername = new JTextField();
		txtusername.setBounds(344, 162, 185, 34);
		panel.add(txtusername);
		txtusername.setColumns(10);
		
		JButton loginbtn = new JButton("Login");
		loginbtn.setBackground(new Color(153, 153, 102));
		loginbtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		loginbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost/javacurd", "root", "");
					Statement stmt = con.createStatement();
					String sql = "Select * from cus_login where username = '"+txtusername.getText()+"'and password = '"+password.getText().toString()+"'";
					ResultSet rs = stmt.executeQuery(sql);
					if(rs.next()) {
						JOptionPane.showMessageDialog(null,"You are logged in");
						class1 nw = new class1();
						frame.dispose();
						nw.newScreen2();
					}
					else
						JOptionPane.showMessageDialog(null,"Incorrect Username and Password");
						con.close();
					
				}catch(Exception e1) { System.out.print(e1);}
			}
			
			
			
		});
		loginbtn.setBounds(272, 324, 276, 34);
		panel.add(loginbtn);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(25, 25, 112));
		panel_1.setBounds(0, 0, 1008, 102);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Logincustomer.class.getResource("/customer_management/images/logo2.png")));
		lblNewLabel_1.setBounds(0, 0, 154, 102);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Customer Management");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2.setBounds(755, 59, 293, 43);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("Retail Store Management System");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setBounds(184, 23, 345, 68);
		panel_1.add(lblNewLabel_4);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(245, 255, 250));
		panel_2.setBounds(0, 101, 377, 580);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(Logincustomer.class.getResource("/customer_management/images/cusmanager.jpg")));
		lblNewLabel_3.setBounds(70, 90, 219, 250);
		panel_2.add(lblNewLabel_3);
		
		
	}

	protected void NewScreen2() {
		// TODO Auto-generated method stub
	}
}
