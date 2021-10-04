package employee;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;

public class Dashboard_Emp {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void NewScreenDash() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dashboard_Emp window = new Dashboard_Emp();
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
	public Dashboard_Emp() {
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
		panel.setBackground(new Color(25,25,112));
		panel.setBounds(10, 0, 998, 121);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(0, 0, 168, 118);
		lblNewLabel.setIcon(new ImageIcon(Dashboard_Emp.class.getResource("/images/logo2.png")));
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Retail Store Management System");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblNewLabel_1.setBounds(156, 38, 450, 30);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Employee Management");
		lblNewLabel_1_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel_1_2.setBounds(650, 65, 296, 30);
		panel.add(lblNewLabel_1_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(220, 220, 220));
		panel_1.setBounds(10, 121, 1008, 549);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton = new JButton("Registration");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setBounds(427, 370, 163, 35);
		btnNewButton.setBackground(new Color(153, 153, 102));
		panel_1.add(btnNewButton);
		
		JButton btnSalarySlip = new JButton("Salary Slip");
		btnSalarySlip.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSalarySlip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSalarySlip.setBounds(137, 370, 163, 35);
		btnSalarySlip.setBackground(new Color(153, 153, 102));
		panel_1.add(btnSalarySlip);
		
		JButton btnAttendance = new JButton("Attendance");
		btnAttendance.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAttendance.setBounds(726, 370, 163, 35);
		btnAttendance.setBackground(new Color(153, 153, 102));
		panel_1.add(btnAttendance);
		
		JLabel lblNewLabel_2_1 = new JLabel("");
		lblNewLabel_2_1.setIcon(new ImageIcon(Dashboard_Emp.class.getResource("/images/empreg .png")));
		lblNewLabel_2_1.setBounds(413, 182, 184, 163);
		panel_1.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon(Dashboard_Emp.class.getResource("/images/payroll.png")));
		lblNewLabel_2.setBounds(129, 182, 193, 169);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(Dashboard_Emp.class.getResource("/images/attendance (1).png")));
		lblNewLabel_3.setBounds(697, 182, 222, 163);
		panel_1.add(lblNewLabel_3);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JavaCrud nw = new JavaCrud();
				frame.dispose();
				nw.NewScreen();
			}
		});
	}

}
