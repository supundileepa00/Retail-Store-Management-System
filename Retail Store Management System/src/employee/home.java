package employee;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;

public class home {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					home window = new home();
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
	public home() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 842, 708);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1008, 685);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnemployee = new JButton("HR Manager");
		btnemployee.setBackground(new Color(204,204,204));
		btnemployee.setIcon(new ImageIcon(home.class.getResource("/images/employee (2).png")));
		btnemployee.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnemployee.setBounds(76, 162, 312, 102);
		panel.add(btnemployee);
		
		JButton btnNewButton = new JButton("Customer Manager");
		btnNewButton.setBackground(new Color(204,204,204));
		btnNewButton.setIcon(new ImageIcon(home.class.getResource("/images/customer.png")));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setBounds(463, 162, 312, 102);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Marketing Manager");
		btnNewButton_1.setBackground(new Color(204,204,204));
		btnNewButton_1.setIcon(new ImageIcon(home.class.getResource("/images/promotion.png")));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_1.setBounds(463, 550, 312, 100);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_1_2 = new JButton("Inventory Manager");
		btnNewButton_1_2.setBackground(new Color(204,204,204));
		btnNewButton_1_2.setIcon(new ImageIcon(home.class.getResource("/images/inventory.png")));
		btnNewButton_1_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_1_2.setBounds(463, 423, 312, 102);
		panel.add(btnNewButton_1_2);
		
		JButton btnNewButton_1_2_1_1 = new JButton("Supply Manager");
		btnNewButton_1_2_1_1.setBackground(new Color(204,204,204));
		btnNewButton_1_2_1_1.setIcon(new ImageIcon(home.class.getResource("/images/supply.png")));
		btnNewButton_1_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_1_2_1_1.setBounds(463, 288, 312, 102);
		panel.add(btnNewButton_1_2_1_1);
		
		JButton btnNewButton_1_2_1_1_1 = new JButton("Sales Manager");
		btnNewButton_1_2_1_1_1.setBackground(new Color(204,204,204));
		btnNewButton_1_2_1_1_1.setIcon(new ImageIcon(home.class.getResource("/images/sales.png")));
		btnNewButton_1_2_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_1_2_1_1_1.setBounds(76, 548, 312, 102);
		panel.add(btnNewButton_1_2_1_1_1);
		
		JButton btnNewButton_1_2_1_1_1_1 = new JButton("Expenses Manager");
		btnNewButton_1_2_1_1_1_1.setBackground(new Color(204,204,204));
		btnNewButton_1_2_1_1_1_1.setIcon(new ImageIcon(home.class.getResource("/images/expenses.png")));
		btnNewButton_1_2_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_1_2_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1_2_1_1_1_1.setBounds(76, 423, 312, 102);
		panel.add(btnNewButton_1_2_1_1_1_1);
		
		JButton btnNewButton_1_2_1_1_2 = new JButton("Order Manager");
		btnNewButton_1_2_1_1_2.setBackground(new Color(204,204,204));
		btnNewButton_1_2_1_1_2.setIcon(new ImageIcon(home.class.getResource("/images/order.png")));
		btnNewButton_1_2_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_1_2_1_1_2.setBounds(76, 299, 312, 102);
		panel.add(btnNewButton_1_2_1_1_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(25,25,112));
		panel_1.setBounds(0, 0, 826, 118);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(home.class.getResource("/images/logo2.png")));
		lblNewLabel.setBounds(0, 11, 159, 107);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Retail Store Management System");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblNewLabel_1.setBounds(181, 56, 466, 28);
		panel_1.add(lblNewLabel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(248,248,255));
		panel_2.setBounds(0, 117, 826, 557);
		panel.add(panel_2);
		panel_2.setLayout(null);
		btnemployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				hrlogin nw = new hrlogin();
				frame.dispose();
				nw.NewScressnlog();
			}
		});
	}
}
