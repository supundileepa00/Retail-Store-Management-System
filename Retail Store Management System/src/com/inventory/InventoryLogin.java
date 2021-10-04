package com.inventory;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

//import com.main.HomePage;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InventoryLogin extends JFrame {

	private JPanel contentPane;
	private JTextField input_username;
	private JPasswordField input_password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InventoryLogin frame = new InventoryLogin();
					frame.setVisible(true);
					frame.setResizable(false);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	// Method for resizing images inside a jlabel
		public static ImageIcon resize(ImageIcon im, int w, int h) {
		BufferedImage bi = new BufferedImage(w, h, BufferedImage.TRANSLUCENT);
		Graphics2D gd = (Graphics2D)bi.createGraphics();
		gd.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING,RenderingHints.VALUE_RENDER_QUALITY));
		gd.drawImage(im.getImage(),0, 0, w, h, null);
		gd.dispose();
		return new ImageIcon(bi);
		}

	/**
	 * Create the frame.
	 */
	public InventoryLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1007, 685);
		contentPane = new JPanel();
		contentPane.setAutoscrolls(true);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JPanel panel_Header = new JPanel();
		panel_Header.setBackground(new Color(25, 25, 153));
		panel_Header.setBounds(0, 0, 1058, 151);
		contentPane.add(panel_Header);
		panel_Header.setLayout(null);
		JLabel label_Title = new JLabel("Retail Store Management System");
		label_Title.setForeground(new Color(255, 255, 240));
		label_Title.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 34));
		label_Title.setBounds(184, 37, 528, 69);
		panel_Header.add(label_Title);
		JLabel label_Main_logo = new JLabel("");
		label_Main_logo.setBounds(10, 10, 153, 116);
		panel_Header.add(label_Main_logo);
		label_Main_logo.setIcon(resize(new ImageIcon(this.getClass().getResource("/img_Logo.png")),label_Main_logo.getWidth(), label_Main_logo.getHeight()));
		
		JButton btn_home = new JButton("Home");
		/*btn_home.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				HomePage home = new HomePage();
				home.setVisible(true);
				home.setResizable(false);
				home.setLocationRelativeTo(null);
			}
			
			
		});*/
		btn_home.setForeground(new Color(255, 250, 205));
		btn_home.setBorderPainted(false);
		btn_home.setBackground(new Color(157, 144, 227 ));
		btn_home.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btn_home.setBounds(863, 100, 129, 51);
		panel_Header.add(btn_home);
		
		JButton btn_adminLogin = new JButton("Admin Login");
		btn_adminLogin.setForeground(new Color(255, 250, 205));
		btn_adminLogin.setBorderPainted(false);
		btn_adminLogin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btn_adminLogin.setBounds(734, 100, 129, 51);
		btn_adminLogin.setBackground(new Color(157, 144, 227 ));
		panel_Header.add(btn_adminLogin);
		
		// inventory manager displayed jpanel
		JPanel InventoryM_Display = new JPanel();
		InventoryM_Display.setBounds(0, 152, 289, 494);
		InventoryM_Display.setBackground(new Color(229,229,229));
		contentPane.add(InventoryM_Display);
		InventoryM_Display.setLayout(null);
		
		JLabel view_login = new JLabel("Inventory Manager ");
		view_login.setVerticalAlignment(SwingConstants.TOP);
		view_login.setFont(new Font("Tahoma", Font.BOLD, 16));
		view_login.setBackground(Color.WHITE);
		view_login.setBounds(66, 296, 160, 27);
		InventoryM_Display.add(view_login);
		
		JLabel lbl_manager = new JLabel("New label");
		lbl_manager.setBounds(24, 71, 242, 228);
		InventoryM_Display.add(lbl_manager);
		lbl_manager.setIcon(resize(new ImageIcon(this.getClass().getResource("/inventory-manager.png")),lbl_manager.getWidth(), lbl_manager.getHeight()));
		
		JLabel view_userName = new JLabel("Username");
		view_userName.setBounds(414, 229, 150, 42);
		contentPane.add(view_userName);
		
		JLabel view_password = new JLabel("Password");
		view_password.setToolTipText("");
		view_password.setBounds(414, 394, 90, 35);
		contentPane.add(view_password);
		
		input_username = new JTextField();
		input_username.setBounds(414, 296, 298, 42);
		contentPane.add(input_username);
		input_username.setColumns(10);
		
		input_password = new JPasswordField();
		input_password.setBounds(414, 438, 298, 42);
		contentPane.add(input_password);
		
		JButton btn_login = new JButton("Login");
		btn_login.setForeground(Color.WHITE);
		btn_login.setBackground(new Color(74, 74, 255));
		btn_login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					
					String user,password;
					
					user = input_username.getText();
					password = input_password.getText().toString();
					
					if(user.equals("")  ||  password.equals("")) {
						JOptionPane.showMessageDialog(null, "Please Fill All The Fields!");
					}else {
						try {
							
							dbConnect connect  = new dbConnect();
							Connection con = connect.getConnection();
							PreparedStatement ps = con.prepareStatement("select * from inventorymanager where UserName='"+input_username.getText()+"' and Password='"+input_password.getText().toString()+"'");
							ResultSet rs = ps.executeQuery();
							
							
							
							if(rs.next() ) {
								
								dispose();
								NavigationPage navPage = new NavigationPage();
								navPage.setVisible(true);
								navPage.setResizable(false);
								navPage.setLocationRelativeTo(null);
								
							}else {
								JOptionPane.showMessageDialog(null, "Incorrect User Name and Password !");
								input_username.setText("");
								input_password.setText("");
							}
								
				}catch(Exception e3) {
					e3.printStackTrace();
				}
				
			}
				
			}
		});
		btn_login.setBounds(500, 558, 125, 47);
		contentPane.add(btn_login);
		
		//set hover for login button
		btn_login.addMouseListener(new java.awt.event.MouseAdapter() {
		public void mouseEntered(java.awt.event.MouseEvent evt) {
			btn_login.setBackground(new Color(9, 9, 186));
		}

		 public void mouseExited(java.awt.event.MouseEvent evt) {
			 btn_login.setBackground(new Color(74, 74, 255));
		}
		});
		
		//set hover for admin login button
		
		btn_adminLogin.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				btn_adminLogin.setBackground(new Color(162, 0, 255));
				}

				public void mouseExited(java.awt.event.MouseEvent evt) {
					btn_adminLogin.setBackground(new Color(157, 144, 227));
					}
		});
		
		//set hover for home button
		
		btn_home.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				btn_home.setBackground(new Color(162, 0, 255));
				}

				public void mouseExited(java.awt.event.MouseEvent evt) {
					btn_home.setBackground(new Color(157, 144, 227));
					}
		});
	}
}
