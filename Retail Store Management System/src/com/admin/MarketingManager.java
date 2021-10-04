package com.admin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.discount.DBConnect;
import com.main.HomePage;

import net.proteanit.sql.DbUtils;

import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class MarketingManager extends JFrame {

	private JPanel contentPane;
	private JTextField txt_username;
	private JTextField txt_password;
	private static JTable Logintable;
	private JTextField txt_rmUsername;

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
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MarketingManager frame = new MarketingManager();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					frame.setResizable(false);
					LoadLoginTable();

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	

	public static void LoadLoginTable() {
		DBConnect db = new DBConnect();
		Connection con = db.Connect();
		PreparedStatement ps;
		ResultSet rs;

		try {
			ps = con.prepareStatement("select * from MarketingManager");
			rs = ps.executeQuery();
			Logintable.setModel(DbUtils.resultSetToTableModel(rs));

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * Create the frame.
	 */
	public MarketingManager() {
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
		label_Main_logo.setBounds(-12, -31, 194, 182);
		panel_Header.add(label_Main_logo);
		label_Main_logo.setIcon(resize(new ImageIcon(this.getClass().getResource("/img_Logo.png")),
				label_Main_logo.getWidth(), label_Main_logo.getHeight()));

		JButton btn_home = new JButton("Admin Home");
		btn_home.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				AdminHome adminHome = new AdminHome();
				adminHome.setResizable(false);
				adminHome.setLocationRelativeTo(null);
				adminHome.setVisible(true);
			}
		});
		btn_home.setForeground(new Color(255, 250, 205));
		btn_home.setBorderPainted(false);
		btn_home.setBackground(new Color(157, 144, 227));
		btn_home.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btn_home.setBounds(863, 111, 129, 40);
		panel_Header.add(btn_home);

		JButton btn_admin = new JButton("Add Marketing Managers");
		btn_admin.setForeground(new Color(255, 250, 205));
		btn_admin.setBorderPainted(false);
		btn_admin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btn_admin.setBounds(643, 111, 216, 40);
		btn_admin.setBackground(new Color(161, 158, 177));
		panel_Header.add(btn_admin);

		JPanel panel = new JPanel();
		panel.setBounds(0, 153, 439, 511);
		contentPane.add(panel);
		panel.setBackground(new Color(229, 229, 229));
		panel.setLayout(null);
		
		JLabel back = new JLabel("");
		back.setBounds(0, 0, 49, 41);
		panel.add(back);
		back.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				AdminHome ah = new AdminHome();
				ah.setResizable(false);
				ah.setLocationRelativeTo(null);
				ah.setVisible(true);
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
		back.setIcon(resize(new ImageIcon(this.getClass().getResource("/Discount_back.png")),back.getWidth(), back.getHeight()));

		JLabel label_UserLogin = new JLabel("Add User Login");
		label_UserLogin.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 21));
		label_UserLogin.setBounds(10, 24, 204, 54);
		panel.add(label_UserLogin);

		txt_username = new JTextField();
		txt_username.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		txt_username.setColumns(10);
		txt_username.setBounds(147, 111, 241, 38);
		panel.add(txt_username);

		JLabel Username = new JLabel("Username");
		Username.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		Username.setBounds(10, 113, 146, 34);
		panel.add(Username);

		JLabel Password = new JLabel("Password");
		Password.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		Password.setBounds(10, 173, 146, 34);
		panel.add(Password);

		txt_password = new JTextField();
		txt_password.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		txt_password.setColumns(10);
		txt_password.setBounds(147, 171, 241, 38);
		panel.add(txt_password);

		JButton btn_addUserLogin = new JButton("Add User");
		btn_addUserLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txt_username.getText().equals("") || txt_password.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Please Fill All Fields!!");
				} else {
					String username = txt_username.getText();
					String password = txt_password.getText();

					DBConnect db = new DBConnect();
					Connection con = db.Connect();
					PreparedStatement ps;

					try {
						ps = con.prepareStatement("insert into MarketingManager (Username,Password) values(?,?)");
						ps.setString(1, username);
						ps.setString(2, password);

						try {
							ps.executeUpdate();
						} catch (SQLIntegrityConstraintViolationException e1) {

							JOptionPane.showMessageDialog(null, "User Already Exists!!");
							txt_username.setText("");
							txt_password.setText("");
							txt_username.requestFocus();

							return;
						}

						JOptionPane.showMessageDialog(null, "User Added!!");
						txt_username.setText("");
						txt_password.setText("");
						txt_username.requestFocus();
						LoadLoginTable();

					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}

			}
		});
		btn_addUserLogin.setForeground(Color.WHITE);
		btn_addUserLogin.setFont(new Font("Roboto", Font.PLAIN, 25));
		btn_addUserLogin.setBorderPainted(false);
		btn_addUserLogin.setBackground(new Color(19, 141, 117));
		btn_addUserLogin.setBounds(209, 248, 181, 50);
		panel.add(btn_addUserLogin);

		// Submit button hover effect
		btn_addUserLogin.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				btn_addUserLogin.setBackground(new Color(106, 191, 174));
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				btn_addUserLogin.setBackground(new Color(19, 141, 117));
			}
		});

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(470, 237, 452, 231);
		contentPane.add(scrollPane);

		Logintable = new JTable();
		Logintable.setEnabled(false);
		scrollPane.setViewportView(Logintable);
		Logintable.setRowHeight(30);

		JLabel label_UserLogin_1 = new JLabel("All User Logins");
		label_UserLogin_1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 21));
		label_UserLogin_1.setBounds(460, 173, 204, 54);
		contentPane.add(label_UserLogin_1);

		JLabel lbl_username = new JLabel("Username");
		lbl_username.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lbl_username.setBounds(535, 500, 135, 42);
		contentPane.add(lbl_username);

		txt_rmUsername = new JTextField();
		txt_rmUsername.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		txt_rmUsername.setColumns(10);
		txt_rmUsername.setBounds(680, 505, 273, 37);
		contentPane.add(txt_rmUsername);

		JButton btn_removeUser = new JButton("Remove User ");
		btn_removeUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txt_rmUsername.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Input Username!!");
				} else {

					DBConnect db = new DBConnect();
					Connection con = db.Connect();
					PreparedStatement ps;

					try {
						String username = txt_rmUsername.getText();
						ps = con.prepareStatement("delete from MarketingManager where Username =? ");
						ps.setString(1, username);

						if(ps.executeUpdate() > 0) {
							
					

						JOptionPane.showMessageDialog(null, "User Deleted!!");
						LoadLoginTable();
						txt_rmUsername.setText("");
						txt_rmUsername.requestFocus();
						con.close();
						}
						else{
							JOptionPane.showMessageDialog(null, "User Not Found!!");
							txt_rmUsername.setText("");
							txt_rmUsername.requestFocus();
						}

					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}
			}
		});
		btn_removeUser.setForeground(Color.WHITE);
		btn_removeUser.setFont(new Font("Roboto Medium", Font.PLAIN, 23));
		btn_removeUser.setBorderPainted(false);
		btn_removeUser.setBackground(new Color(220, 56, 37));
		btn_removeUser.setBounds(737, 563, 216, 54);
		contentPane.add(btn_removeUser);

		// btn_removeDiscount button hover effect
		btn_removeUser.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				btn_removeUser.setBackground(new Color(217, 106, 93));
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				btn_removeUser.setBackground(new Color(220, 56, 37));
			}
		});

	}
}
