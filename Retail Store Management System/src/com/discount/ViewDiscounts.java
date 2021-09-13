package com.discount;

import java.sql.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import com.main.HomePage;

import net.proteanit.sql.DbUtils;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ViewDiscounts extends JFrame {

	private JPanel contentPane;
	private static JTable discount_table;
	private JTextField txtDiscountID;
	private JTextField txt_ItemCode;
	private JTextField txt_discountName;
	private JTextField txtDiscountAmount;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewDiscounts frame = new ViewDiscounts();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					frame.setResizable(false);

					LoadDiscountTable();

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	

	// Load data from discount table
	public static void LoadDiscountTable() {
		DBConnect db = new DBConnect();
		Connection con = db.Connect();
		PreparedStatement ps;
		ResultSet rs;

		try {
			ps = con.prepareStatement("select * from discount");
			rs = ps.executeQuery();
			discount_table.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

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
	public ViewDiscounts() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1007, 685);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel_Header = new JPanel();
		panel_Header.setBackground(new Color(25,25,112));
		panel_Header.setBounds(0, 0, 993, 151);
		contentPane.add(panel_Header);
		panel_Header.setLayout(null);

		JLabel label_Title = new JLabel("Retail Store Management System");
		label_Title.setForeground(new Color(255, 255, 240));
		label_Title.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 34));
		label_Title.setBounds(187, 24, 528, 69);
		panel_Header.add(label_Title);

		JLabel label_Main_logo = new JLabel("");
		label_Main_logo.setBounds(0, -19, 179, 160);
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
				HomePage.setVisible(true);
			}
		});
		btn_home.setForeground(new Color(255, 250, 205));
		btn_home.setBorderPainted(false);
		btn_home.setBackground(new Color(157, 144, 227));
		btn_home.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btn_home.setBounds(863, 114, 129, 37);
		panel_Header.add(btn_home);

		JButton btn_MarketingManager = new JButton("Marketing Manager Home ");
		btn_MarketingManager.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				marketingManagerHome mmHome = new marketingManagerHome();
				mmHome.setResizable(false);
				mmHome.setLocationRelativeTo(null);
				mmHome.setVisible(true);
			}
		});
		btn_MarketingManager.setForeground(new Color(255, 250, 205));
		btn_MarketingManager.setBorderPainted(false);
		btn_MarketingManager.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btn_MarketingManager.setBounds(632, 114, 227, 37);
		btn_MarketingManager.setBackground(new Color(157, 144, 227));
		panel_Header.add(btn_MarketingManager);

		JButton btn_MarketingManagerViewDIs = new JButton("View Discounts ");
		btn_MarketingManagerViewDIs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				
				ViewDiscounts viewDis = new ViewDiscounts();
				viewDis.setLocationRelativeTo(null);
				viewDis.setResizable(false);
				viewDis.LoadDiscountTable();
				viewDis.setVisible(true);
			}
		});
		btn_MarketingManagerViewDIs.setForeground(new Color(255, 250, 205));
		btn_MarketingManagerViewDIs.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btn_MarketingManagerViewDIs.setBorderPainted(false);
		btn_MarketingManagerViewDIs.setBackground(new Color(161, 157, 177));
		btn_MarketingManagerViewDIs.setBounds(429, 114, 199, 37);
		panel_Header.add(btn_MarketingManagerViewDIs);

		JLabel label_allDiscounts = new JLabel("All Discounts");
		label_allDiscounts.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 21));
		label_allDiscounts.setBounds(10, 187, 204, 42);
		contentPane.add(label_allDiscounts);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 230, 946, 223);
		contentPane.add(scrollPane);

		
		
		
		discount_table = new JTable();
		discount_table.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		discount_table.setRowHeight(20);
		scrollPane.setViewportView(discount_table);

		JLabel lblSearchDiscount = new JLabel("Search Discount");
		lblSearchDiscount.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 21));
		lblSearchDiscount.setBounds(10, 445, 204, 54);
		contentPane.add(lblSearchDiscount);

		JLabel label_discountID = new JLabel("Discount ID");
		label_discountID.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		label_discountID.setBounds(10, 496, 113, 42);
		contentPane.add(label_discountID);

		txtDiscountID = new JTextField();
		txtDiscountID.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				char c = e.getKeyChar();
				if (Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE) {
					txtDiscountID.setEditable(true);

				} else {

					txtDiscountID.setEditable(false);
				}
			}
		});
		txtDiscountID.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtDiscountID.setBounds(133, 506, 190, 34);
		contentPane.add(txtDiscountID);
		txtDiscountID.setColumns(10);

		JPanel panel = new JPanel();
		panel.setBounds(20, 548, 946, 99);
		contentPane.add(panel);
		panel.setBackground(new Color(215, 215, 215));
		panel.setLayout(null);

		JLabel lblItemCode = new JLabel("Item Code");
		lblItemCode.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 17));
		lblItemCode.setBounds(10, 10, 99, 35);
		panel.add(lblItemCode);

		txt_ItemCode = new JTextField();
		txt_ItemCode.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				char c = e.getKeyChar();
				if (Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE) {
					txt_ItemCode.setEditable(true);

				} else {

					txt_ItemCode.setEditable(false);
				}
			}

		});
		txt_ItemCode.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		txt_ItemCode.setColumns(10);
		txt_ItemCode.setBounds(105, 16, 113, 29);
		panel.add(txt_ItemCode);

		JLabel lblDiscountName = new JLabel("Discount Name");
		lblDiscountName.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 17));
		lblDiscountName.setBounds(245, 10, 125, 35);
		panel.add(lblDiscountName);

		txt_discountName = new JTextField();
		txt_discountName.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		txt_discountName.setColumns(10);
		txt_discountName.setBounds(380, 16, 218, 29);
		panel.add(txt_discountName);

		txtDiscountAmount = new JTextField();
		txtDiscountAmount.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				char c = e.getKeyChar();
				if (Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE) {
					txtDiscountAmount.setEditable(true);

				} else {
					txtDiscountAmount.setEditable(false);
				}
			}

		});
		txtDiscountAmount.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		txtDiscountAmount.setColumns(10);
		txtDiscountAmount.setBounds(773, 16, 163, 29);
		panel.add(txtDiscountAmount);

		JLabel lblDiscountAmount = new JLabel("Discount Amount");
		lblDiscountAmount.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 17));
		lblDiscountAmount.setBounds(622, 10, 141, 35);
		panel.add(lblDiscountAmount);

		JLabel lblDiscountPercentage = new JLabel("Discount % :");
		lblDiscountPercentage.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 17));
		lblDiscountPercentage.setBounds(10, 55, 99, 35);
		panel.add(lblDiscountPercentage);

		JLabel lbl_discountPer = new JLabel("");
		lbl_discountPer.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		lbl_discountPer.setBounds(115, 55, 141, 34);
		panel.add(lbl_discountPer);

		JLabel lblNewPrice = new JLabel("New Price :");
		lblNewPrice.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 17));
		lblNewPrice.setBounds(294, 55, 99, 35);
		panel.add(lblNewPrice);

		JLabel lbl_newPrice = new JLabel("");
		lbl_newPrice.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		lbl_newPrice.setBounds(409, 55, 163, 34);
		panel.add(lbl_newPrice);

		JButton btn_addDiscount = new JButton("Add Discount");
		btn_addDiscount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();

				addDiscount addDis = new addDiscount();
				addDis.setLocationRelativeTo(null);
				addDis.setResizable(false);
				addDis.tableLoad();
				addDis.setVisible(true);
			}
		});
		btn_addDiscount.setForeground(Color.WHITE);
		btn_addDiscount.setBorderPainted(false);
		btn_addDiscount.setFont(new Font("Roboto", Font.PLAIN, 18));
		btn_addDiscount.setBounds(785, 175, 181, 42);
		contentPane.add(btn_addDiscount);
		btn_addDiscount.setBackground(new Color(82, 113, 185));

		// Login button hover effect
		btn_addDiscount.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				btn_addDiscount.setBackground(new Color(129, 150, 198));
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				btn_addDiscount.setBackground(new Color(82, 113, 185));
			}
		});
		JButton btn_searchDiscount = new JButton("Search");
		btn_searchDiscount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (txtDiscountID.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Please input valid discount ID!!");
				} else {
					
					DBConnect db = new DBConnect();
					Connection con1 = db.Connect();
					PreparedStatement ps1;

					try {
						ps1 = con1.prepareStatement(
								"select ItemCode,DiscountName,Discount,DiscountPercentage,CurrentPrice from discount where DiscountID = ? ");
						ps1.setInt(1, Integer.parseInt(txtDiscountID.getText()));
						ResultSet rs1 = ps1.executeQuery();

						if (rs1.next() == true) {
							int itemCode = rs1.getInt(1);
							String discountName = rs1.getString(2);
							String discount = rs1.getString(3);
							String discountPercentage = rs1.getString(4);
							String curPrice = rs1.getString(5);

							txt_ItemCode.setText(String.valueOf(itemCode));
							txt_ItemCode.setEditable(false);
							txt_discountName.setText(discountName);
							txtDiscountAmount.setText(discount);
							lbl_discountPer.setText(discountPercentage + "%");
							lbl_newPrice.setText(curPrice + " LKR");

						} else {
							txt_ItemCode.setText("");
							txt_discountName.setText("");
							txtDiscountAmount.setText("");
							lbl_discountPer.setText("");
							lbl_newPrice.setText("");
							txtDiscountID.setText("");

							JOptionPane.showMessageDialog(null, "Record Not Found!!");

						}

					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}

			}
		});
		btn_searchDiscount.setForeground(Color.WHITE);
		btn_searchDiscount.setBorderPainted(false);
		btn_searchDiscount.setFont(new Font("Roboto", Font.PLAIN, 18));
		btn_searchDiscount.setBounds(354, 505, 132, 34);
		contentPane.add(btn_searchDiscount);
		btn_searchDiscount.setBackground(new Color(19, 141, 117));

		// Search button hover effect
		btn_searchDiscount.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				btn_searchDiscount.setBackground(new Color(106, 191, 174));
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				btn_searchDiscount.setBackground(new Color(19, 141, 117));
			}
		});

		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txt_ItemCode.getText().equals("") || txtDiscountID.getText().equals("")
						|| txt_discountName.getText().equals("") || txtDiscountAmount.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Some fields are Empty");
				}

				else {

					int itemCode = Integer.parseInt(txt_ItemCode.getText());
					int discountID = Integer.parseInt(txtDiscountID.getText());
					String discountName = txt_discountName.getText();
					double discount = Double.parseDouble(txtDiscountAmount.getText());

					Calendar cal = Calendar.getInstance();
					SimpleDateFormat dateOnly = new SimpleDateFormat("MM/dd/yyyy");

					String date = dateOnly.format(cal.getTime());

					DBConnect db = new DBConnect();
					PreparedStatement ps1;
					Connection con1 = db.Connect();

					try {
						ps1 = con1.prepareStatement("select * from discount where DiscountID = ?");
						ps1.setInt(1, discountID);

						ResultSet rs1 = ps1.executeQuery();

						String sellingPrice = null;

						while (rs1.next()) {
							sellingPrice = rs1.getString(8);

						}

						float SelP = Float.parseFloat(sellingPrice);
						
						Calculations calc = new Calculations();
						
						float discountPercentage = calc.calcDiscountPercentage(discount, SelP);

						String discountPercentageStr = String.format("%.1f", discountPercentage);
						String previousPrice = sellingPrice;
						double currentPrice = (double) SelP - discount;

						Connection con2 = db.Connect();
						PreparedStatement ps2;

						ps2 = con2.prepareStatement("update item set SellingPrice = ? where ItemCode = ?");
						ps2.setString(1, String.valueOf(currentPrice));
						ps2.setInt(2, itemCode);

						ps2.executeUpdate();

						Connection con3 = db.Connect();
						PreparedStatement ps3;

						ps3 = con3.prepareStatement(
								"update discount set Date =?,DiscountName=?,Discount=?,DiscountPercentage=?,CurrentPrice=?,PreviousPrice=? where DiscountID =? ");

						ps3.setString(1, date);
						ps3.setString(2, discountName);
						ps3.setDouble(3, discount);
						ps3.setFloat(4, Float.parseFloat(discountPercentageStr));
						ps3.setString(5, String.valueOf(currentPrice));
						ps3.setString(6, previousPrice);
						ps3.setInt(7, discountID);

						if (ps3.executeUpdate() != 0) {

							JOptionPane.showMessageDialog(null, "Discount Updated!!");
							
							txt_discountName.setText("");
							txtDiscountAmount.setText("");
							lbl_discountPer.setText("");
							lbl_newPrice.setText("");
							
							LoadDiscountTable();
						}

					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}

			}
		});

		// Login button hover effect
		btnUpdate.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				btnUpdate.setBackground(new Color(237, 156, 75));
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				btnUpdate.setBackground(new Color(247, 143, 40));
			}
		});
		btnUpdate.setForeground(Color.WHITE);
		btnUpdate.setFont(new Font("Roboto", Font.PLAIN, 18));
		btnUpdate.setBorderPainted(false);
		btnUpdate.setBackground(new Color(247, 143, 40));
		btnUpdate.setBounds(773, 56, 163, 34);
		panel.add(btnUpdate);

		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txt_ItemCode.setText("");
				txt_discountName.setText("");
				txtDiscountAmount.setText("");
				lbl_discountPer.setText("");
				lbl_newPrice.setText("");

				txtDiscountAmount.setEditable(true);
				txtDiscountID.setEditable(true);
				txt_ItemCode.setEditable(true);
			}
		});
		btnClear.setForeground(Color.WHITE);
		btnClear.setFont(new Font("Roboto", Font.PLAIN, 18));
		btnClear.setBorderPainted(false);
		btnClear.setBackground(new Color(166, 172, 175));
		btnClear.setBounds(604, 55, 163, 34);
		panel.add(btnClear);
		
		JLabel back = new JLabel("");
		back.setBounds(10, 155, 50, 42);
		contentPane.add(back);
		back.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				marketingManagerHome mh = new marketingManagerHome();
				mh.setResizable(false);
				mh.setLocationRelativeTo(null);
				mh.setVisible(true);
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
		
		
		btnClear.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				btnClear.setBackground(new Color(188, 194, 197));
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				btnClear.setBackground(new Color(166, 172, 175));
			}
		});

	}
}
