package employee;
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

public class hrlogin {

	private JFrame frame;
	private JPasswordField password;
	private JTextField txtusername;

	/**
	 * Launch the application.
	 */
	public static void NewScressnlog() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					hrlogin window = new hrlogin();
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
	public hrlogin() {
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
		
		JLabel lblNewLabel = new JLabel("USERNAME");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(214, 175, 120, 25);
		panel.add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPassword.setBounds(214, 254, 120, 25);
		panel.add(lblPassword);
		
		password = new JPasswordField();
		password.setBounds(344, 241, 185, 20);
		panel.add(password);
		
		txtusername = new JTextField();
		txtusername.setBounds(344, 177, 185, 20);
		panel.add(txtusername);
		txtusername.setColumns(10);
		
		JButton loginbtn = new JButton("LOGIN");
		loginbtn.setBackground(new Color(153, 153, 102));
		loginbtn.setFont(new Font("Tahoma", Font.BOLD, 11));
		loginbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost/javacrud", "root", "");
					Statement stmt = con.createStatement();
					String sql = "Select * from hr_login where username = '"+txtusername.getText()+"'and password = '"+password.getText().toString()+"'";
					ResultSet rs = stmt.executeQuery(sql);
					if(rs.next()) {
						JOptionPane.showMessageDialog(null,"You are logged in");
						
						Dashboard_Emp nw = new Dashboard_Emp();
						frame.dispose();
						nw.NewScreenDash();
						
					}
					else
						JOptionPane.showMessageDialog(null,"Incorrect Username and Password");
						con.close();
					
				}catch(Exception e1) { System.out.print(e1);}
			}
			
			
			
		});
		loginbtn.setBounds(214, 330, 315, 34);
		panel.add(loginbtn);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(25, 25, 112));
		panel_1.setBounds(0, 0, 1008, 102);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(hrlogin.class.getResource("/images/logo2.png")));
		lblNewLabel_1.setBounds(0, 0, 154, 102);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Employee Management");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel_2.setBounds(599, 48, 292, 29);
		panel_1.add(lblNewLabel_2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(245, 255, 250));
		panel_2.setBounds(0, 101, 377, 580);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(99, 184, 207, 192);
		panel_2.add(lblNewLabel_3);
		lblNewLabel_3.setIcon(new ImageIcon(hrlogin.class.getResource("/images/hr_login.png")));
	}
}
