package com.discount;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.*;

import javax.swing.border.EmptyBorder;

import com.main.HomePage;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class marketingManager_Login extends JFrame {

	private JPanel contentPane;
	private JTextField txt_mm_username;
	private JPasswordField txt_mm_password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					marketingManager_Login frame = new marketingManager_Login();
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
		Graphics2D gd = (Graphics2D) bi.createGraphics();
		gd.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY));
		gd.drawImage(im.getImage(), 0, 0, w, h, null);
		gd.dispose();
		return new ImageIcon(bi);
	}

	/**
	 * Create the frame.
	 */
	public marketingManager_Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1007, 685);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel_Header = new JPanel();
		panel_Header.setBackground(new Color(25,25,112));
		panel_Header.setBounds(0, 0, 1058, 151);
		contentPane.add(panel_Header);
		panel_Header.setLayout(null);

		JLabel label_Title = new JLabel("Retail Store Management System");
		label_Title.setForeground(new Color(255, 255, 240));
		label_Title.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 36));
		label_Title.setBounds(173, 37, 551, 78);
		panel_Header.add(label_Title);

		JLabel label_Main_logo = new JLabel("");
		label_Main_logo.setBounds(0, -16, 184, 167);
		panel_Header.add(label_Main_logo);
		label_Main_logo.setIcon(resize(new ImageIcon(this.getClass().getResource("/img_Logo.png")),
				label_Main_logo.getWidth(), label_Main_logo.getHeight()));

		JButton btn_home = new JButton("Home");
		btn_home.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				HomePage hm = new HomePage();
				hm.setLocationRelativeTo(null);
				hm.setResizable(false);
				hm.setVisible(true);
			}
		});
		btn_home.setForeground(new Color(255, 250, 205));
		btn_home.setBorderPainted(false);
		btn_home.setBackground(new Color(157, 144, 227));
		btn_home.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btn_home.setBounds(863, 100, 129, 51);
		panel_Header.add(btn_home);

		JButton btn_MarketingManager = new JButton("Marketing Manager ");
		btn_MarketingManager.setForeground(new Color(255, 250, 205));
		btn_MarketingManager.setBorderPainted(false);
		btn_MarketingManager.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btn_MarketingManager.setBounds(665, 100, 195, 51);
		btn_MarketingManager.setBackground(new Color(161, 158, 177));
		panel_Header.add(btn_MarketingManager);

		JPanel LoginSidePanel = new JPanel();
		LoginSidePanel.setBackground(new Color(229, 229, 229));
		LoginSidePanel.setBounds(0, 150, 325, 498);
		contentPane.add(LoginSidePanel);
		LoginSidePanel.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("Marketing Manager Login");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel_2.setBounds(30, 275, 285, 117);
		LoginSidePanel.add(lblNewLabel_2);

		JLabel img_mm_login = new JLabel("");
		img_mm_login.setBounds(46, 82, 221, 213);
		LoginSidePanel.add(img_mm_login);
		img_mm_login.setIcon(resize(new ImageIcon(this.getClass().getResource("/MM_login.png")),
				img_mm_login.getWidth(), img_mm_login.getHeight()));

		JLabel label_username = new JLabel("Username");
		label_username.setFont(new Font("Yu Gothic UI", Font.PLAIN, 22));
		label_username.setBounds(400, 234, 100, 46);
		contentPane.add(label_username);

		JLabel username_error = new JLabel("");
		username_error.setForeground(new Color(242, 72, 72));
		username_error.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		username_error.setBounds(526, 258, 246, 22);
		contentPane.add(username_error);

		JLabel password_error = new JLabel("");
		password_error.setForeground(new Color(242, 72, 72));
		password_error.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		password_error.setBounds(526, 397, 246, 22);
		contentPane.add(password_error);

		JButton btn_mm_login = new JButton("Login");
		btn_mm_login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = txt_mm_username.getText();
				String password = txt_mm_password.getText();

				if (username.equals("") || password.equals("")) {
					JOptionPane.showMessageDialog(null, "Please fill the fields");
				} else {

					DBConnect db = new DBConnect();
					Connection con = db.Connect();
					try {
						PreparedStatement ps = con
								.prepareStatement("select * from marketingmanager where Username =? ");
						ps.setString(1, username);

						ResultSet rs = ps.executeQuery();

						String pwd = null;

						while (rs.next()) {
							pwd = rs.getString(2);
						}
						try {
							if (pwd.equals(password)) {
								dispose();
								marketingManagerHome mh = new marketingManagerHome();
								mh.setResizable(false);
								mh.setLocationRelativeTo(null);
								mh.setVisible(true);

							} else {
								JOptionPane.showMessageDialog(null, "Invalid Password");
								txt_mm_password.setText("");
								password_error.setText("*Re-enter Password");
							}
						} catch (NullPointerException ex) {
							JOptionPane.showMessageDialog(null, "Invalid Username And Password");

							txt_mm_username.setText("");
							txt_mm_password.setText("");
							txt_mm_username.requestFocus();
							username_error.setText("*Re-enter Username");
							password_error.setText("*Re-enter Password");
						}

					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}

			}
		});
		btn_mm_login.setBorderPainted(false);
		btn_mm_login.setBackground(new Color(110, 229, 67));
		btn_mm_login.setFont(new Font("Segoe UI", Font.PLAIN, 26));
		btn_mm_login.setBounds(587, 529, 223, 52);
		contentPane.add(btn_mm_login);

		// Login button hover effect
		btn_mm_login.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				btn_mm_login.setBackground(new Color(145, 240, 112));
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				btn_mm_login.setBackground(new Color(110, 229, 67));
			}
		});

		JLabel mm_label_password = new JLabel("Password");
		mm_label_password.setBounds(400, 368, 265, 31);
		mm_label_password.setFont(new Font("Yu Gothic UI", Font.PLAIN, 22));
		contentPane.add(mm_label_password);

		txt_mm_username = new JTextField();
		txt_mm_username.setBounds(410, 290, 400, 39);
		txt_mm_username.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(txt_mm_username);
		txt_mm_username.setColumns(10);

		txt_mm_password = new JPasswordField();
		txt_mm_password.setBounds(410, 428, 400, 39);
		txt_mm_password.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(txt_mm_password);

	}
}
