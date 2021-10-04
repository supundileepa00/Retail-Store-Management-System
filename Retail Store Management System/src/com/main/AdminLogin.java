package com.main;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.border.MatteBorder;

import com.admin.AdminHome;
import com.discount.marketingManagerHome;

import javax.swing.border.BevelBorder;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class AdminLogin extends JFrame {

	private JPanel contentPane;
	private JTextField txt_adminUsername;
	private JPasswordField txt_adminPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminLogin frame = new AdminLogin();
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
	public AdminLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1007, 685);
		contentPane = new JPanel();
		contentPane.setAutoscrolls(true);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel_Header = new JPanel();
		panel_Header.setBackground(new Color(110, 89, 222));
		panel_Header.setBounds(0, 0, 1058, 151);
		contentPane.add(panel_Header);
		panel_Header.setLayout(null);

		JLabel label_Title = new JLabel("Retail Store Management System");
		label_Title.setForeground(new Color(255, 255, 240));
		label_Title.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 36));
		label_Title.setBounds(173, 37, 551, 78);
		panel_Header.add(label_Title);

		JLabel label_Main_logo = new JLabel("");
		label_Main_logo.setBounds(-18, -13, 175, 164);
		panel_Header.add(label_Main_logo);
		label_Main_logo.setIcon(resize(new ImageIcon(this.getClass().getResource("/img_Logo.png")),
				label_Main_logo.getWidth(), label_Main_logo.getHeight()));

		JButton btn_home = new JButton("Home");
		btn_home.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				HomePage HomePage = new HomePage();
				HomePage.setLocationRelativeTo(null);
				HomePage.setResizable(false);
				HomePage.setVisible(true);;
			}
		});
		btn_home.setForeground(new Color(255, 250, 205));
		btn_home.setBorderPainted(false);
		btn_home.setBackground(new Color(157, 144, 227));
		btn_home.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btn_home.setBounds(863, 111, 129, 40);
		panel_Header.add(btn_home);

		JButton btn_adminLogin = new JButton("Admin Login");
		btn_adminLogin.setForeground(new Color(255, 250, 205));
		btn_adminLogin.setBorderPainted(false);
		btn_adminLogin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btn_adminLogin.setBounds(730, 111, 129, 40);
		btn_adminLogin.setBackground(new Color(161, 158, 177));
		panel_Header.add(btn_adminLogin);

		
		JPanel LoginSidePanel = new JPanel();
		LoginSidePanel.setBackground(new Color(229, 229, 229));
		LoginSidePanel.setBounds(0, 150, 342, 498);
		contentPane.add(LoginSidePanel);
		LoginSidePanel.setLayout(null);
		
		
		
		JLabel back = new JLabel("");
		back.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				HomePage hp = new HomePage();
				hp.setResizable(false);
				hp.setLocationRelativeTo(null);
				hp.setVisible(true);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				back.setIcon(resize(new ImageIcon(this.getClass().getResource("/Discount_back.png")),55, 55));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				back.setIcon(resize(new ImageIcon(this.getClass().getResource("/Discount_back.png")),back.getWidth(), back.getHeight()));
			}
		});
		back.setBounds(10, 10, 45, 37);
		LoginSidePanel.add(back);
		back.setIcon(resize(new ImageIcon(this.getClass().getResource("/Discount_back.png")),back.getWidth(), back.getHeight()));


		JLabel lblNewLabel_2 = new JLabel("Admin Login");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 29));
		lblNewLabel_2.setBounds(85, 305, 165, 73);
		LoginSidePanel.add(lblNewLabel_2);

		JLabel AdminIcon = new JLabel("");
		AdminIcon.setBounds(50, 81, 217, 205);
		AdminIcon.setIcon(resize(new ImageIcon(this.getClass().getResource("/adminLoginImage.jpg")),
				AdminIcon.getWidth(), AdminIcon.getHeight()));
		LoginSidePanel.add(AdminIcon);

		JLabel label_username = new JLabel("Username");
		label_username.setFont(new Font("Yu Gothic UI", Font.PLAIN, 24));
		label_username.setBounds(400, 234, 265, 46);
		contentPane.add(label_username);

		txt_adminUsername = new JTextField();
		txt_adminUsername.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txt_adminUsername.setBounds(400, 290, 447, 39);
		contentPane.add(txt_adminUsername);
		txt_adminUsername.setColumns(10);

		JLabel label_password = new JLabel("Password");
		label_password.setFont(new Font("Yu Gothic UI", Font.PLAIN, 24));
		label_password.setBounds(400, 355, 265, 69);
		contentPane.add(label_password);

		txt_adminPassword = new JPasswordField();
		txt_adminPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txt_adminPassword.setBounds(400, 416, 447, 39);
		contentPane.add(txt_adminPassword);

		JButton btm_adminLogin = new JButton("Login");
		btm_adminLogin.setBorderPainted(false);
		btm_adminLogin.setBackground(new Color(110, 229, 67));
		btm_adminLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (txt_adminUsername.getText().equals("") || txt_adminPassword.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Please fill all fields!!");
					txt_adminUsername.requestFocus();
				} else {

					String username = txt_adminUsername.getText();
					String password = txt_adminPassword.getText();

					if (username.equalsIgnoreCase("admin") && password.equalsIgnoreCase("admin")) {
						dispose();
						AdminHome adminhome = new AdminHome();
						adminhome.setResizable(false);
						adminhome.setLocationRelativeTo(null);
						adminhome.setVisible(true);
						
					} else {
						JOptionPane.showMessageDialog(null, "Invalid username or Password");
						txt_adminUsername.setText("");
						txt_adminPassword.setText("");
						
						txt_adminUsername.requestFocus();
					}

				}
			}
		});
		btm_adminLogin.setFont(new Font("Segoe UI", Font.PLAIN, 26));
		btm_adminLogin.setBounds(624, 508, 223, 52);
		contentPane.add(btm_adminLogin);

		// Login button hover effect
		btm_adminLogin.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				btm_adminLogin.setBackground(new Color(145, 240, 112));
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				btm_adminLogin.setBackground(new Color(110, 229, 67));
			}
		});

	}
}
