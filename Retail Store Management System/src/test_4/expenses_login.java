package test_4;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

//import com.mysql.jdbc.PreparedStatement;

//import com.mysql.jdbc.PreparedStatement;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class expenses_login extends JFrame {

	private JPanel contentPane;
	private JTextField txtuser;
	private JPasswordField pass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					expenses_login frame = new expenses_login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public expenses_login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 674, 460);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 51, 102));
		panel.setBounds(0, 0, 658, 104);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(expenses_login.class.getResource("/images/logo2.png")));
		lblNewLabel_4.setBounds(35, 11, 155, 82);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Retail Store Management System");
		lblNewLabel_5.setForeground(new Color(255, 255, 255));
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblNewLabel_5.setBounds(200, 32, 464, 42);
		panel.add(lblNewLabel_5);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(204, 204, 204));
		panel_1.setBounds(0, 103, 263, 322);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(expenses_login.class.getResource("/images/pm_iconFN1.png")));
		lblNewLabel.setBounds(20, 39, 226, 207);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Expense manager");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblNewLabel_1.setBounds(20, 214, 243, 64);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Username");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2.setBounds(291, 152, 100, 40);
		contentPane.add(lblNewLabel_2);
		
		txtuser = new JTextField();
		txtuser.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtuser.setColumns(10);
		txtuser.setBounds(291, 190, 295, 39);
		contentPane.add(txtuser);
		
		JLabel lblNewLabel_3 = new JLabel("Password");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_3.setBounds(291, 256, 134, 40);
		contentPane.add(lblNewLabel_3);
		
		//lable replaced
		JLabel lbluser = new JLabel("");
		lbluser.setBounds(301, 228, 285, 21);
		contentPane.add(lbluser);
		
		JLabel lblpass = new JLabel("");
		lblpass.setBounds(301, 347, 285, 21);
		contentPane.add(lblpass);
		
		//end
		
		
	
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(153, 153, 102));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// login form validetion
				if(txtuser.getText().trim().isEmpty() && pass.getText().trim().isEmpty()) {
					lbluser.setText("Username is empty");
					lblpass.setText("Password is empty");		
				}
				else if(txtuser.getText().trim().isEmpty()) {
					lbluser.setText("Username is empty");
					lblpass.setText(" ");
				}
				else if(pass.getText().trim().isEmpty()) {
					lblpass.setText("Password is empty");
					lbluser.setText(" ");
				}
				else
					
				try{
		            //Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		            //String url="jdbc:sqlserver://localhost:1433;databaseName=testdb;user=sa;password=orchid";
		            //Connection con = DriverManager.getConnection(url);
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/expenses","root","");
					Statement stmt = con.createStatement();
		            String sql = "Select * from expenseslogin where username=? and password = ?";
		            //PreparedStatement pst = con.prepareStatement(sql);
		            PreparedStatement pst = con.prepareStatement(sql);
		            pst.setString(1, txtuser.getText());
		            pst.setString(2, pass.getText());
		            ResultSet rs = pst.executeQuery();
		            if(rs.next()){
		                JOptionPane.showMessageDialog(null, "Username and Password Matched");
		                add_expenses field= new add_expenses();
		                field.setVisible(true);
		                setVisible(false);
		                field.Loadtable();
		             
		            }
		            else{
		                JOptionPane.showMessageDialog(null, "Username and password not Correct");
		                txtuser.setText("");
		                pass.setText("");
		                lbluser.setText("");
		                lblpass.setText(" ");
		            }
		            con.close();
		        }
		        catch(Exception e4){
		            JOptionPane.showMessageDialog(null, e4);
		        }
				
				
			
				
				
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.setBounds(384, 368, 106, 31);
		contentPane.add(btnNewButton);
		
		pass = new JPasswordField();
		pass.setBounds(291, 307, 295, 40);
		contentPane.add(pass);
		
	
	}
}
