package com.discount;

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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JTextPane;

import com.main.*;

import net.proteanit.sql.DbUtils;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class addDiscount extends JFrame {

	private static final Connection Connection = null;
	private JPanel contentPane;
	private JTextField txt_ItemCode;
	private JTextField txt_DiscountName;
	private JTextField txt_discountPrice;
	private static JTable ItemTable;
	private JTextField txt_ItemCodeSearch;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addDiscount frame = new addDiscount();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					frame.setResizable(false);

					tableLoad();
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

	// Load data for the table
	public static void tableLoad() {
		DBConnect db = new DBConnect();
		Connection con = db.Connect();
		PreparedStatement ps;
		ResultSet rs;

		try {
			ps = con.prepareStatement("select * from item");
			rs = ps.executeQuery();
			ItemTable.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * Create the frame.
	 */
	public addDiscount() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1007, 685);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel_Header = new JPanel();
		panel_Header.setBackground(new Color(25,25,112));
		panel_Header.setBounds(0, 0, 1003, 151);
		contentPane.add(panel_Header);
		panel_Header.setLayout(null);

		JLabel label_Title = new JLabel("Retail Store Management System");
		label_Title.setForeground(new Color(255, 255, 240));
		label_Title.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 34));
		label_Title.setBounds(187, 24, 528, 69);
		panel_Header.add(label_Title);

		JLabel label_Main_logo = new JLabel("");
		label_Main_logo.setBounds(-15, -28, 192, 179);
		panel_Header.add(label_Main_logo);
		label_Main_logo.setIcon(resize(new ImageIcon(this.getClass().getResource("/img_Logo.png")),label_Main_logo.getWidth(), label_Main_logo.getHeight()));

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

		JButton btn_AddDiscount = new JButton("Add Discount");
		btn_AddDiscount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				
				addDiscount addDis = new addDiscount();
				addDis.setLocationRelativeTo(null);
				addDis.setResizable(false);
				addDis.tableLoad();
				addDis.setVisible(true);
			}
		});
		btn_AddDiscount.setForeground(new Color(255, 250, 205));
		btn_AddDiscount.setBorderPainted(false);
		btn_AddDiscount.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btn_AddDiscount.setBounds(461, 114, 175, 37);
		btn_AddDiscount.setBackground(new Color(161, 158, 177));
		panel_Header.add(btn_AddDiscount);

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
		btn_MarketingManager.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn_MarketingManager.setBorderPainted(false);
		btn_MarketingManager.setBackground(new Color(157, 144, 227));
		btn_MarketingManager.setBounds(639, 114, 221, 37);
		panel_Header.add(btn_MarketingManager);

		JPanel panel = new JPanel();
		panel.setBounds(0, 149, 491, 513);
		contentPane.add(panel);
		panel.setBackground(new Color(229, 229, 229));
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Add Discount ");
		lblNewLabel.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 21));
		lblNewLabel.setBounds(20, 61, 156, 41);
		panel.add(lblNewLabel);

		JLabel lbl_ItemCode = new JLabel("Item Code");
		lbl_ItemCode.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		lbl_ItemCode.setBounds(33, 124, 100, 34);
		panel.add(lbl_ItemCode);

		JLabel lbl_DiscountName = new JLabel("Discount Name");
		lbl_DiscountName.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		lbl_DiscountName.setBounds(33, 183, 143, 34);
		panel.add(lbl_DiscountName);

		JLabel lbl_disPrice = new JLabel("Discount Price");
		lbl_disPrice.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		lbl_disPrice.setBounds(33, 242, 143, 34);
		panel.add(lbl_disPrice);

		JLabel lbl_ItemCodeValidate = new JLabel("");
		lbl_ItemCodeValidate.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lbl_ItemCodeValidate.setForeground(Color.RED);
		lbl_ItemCodeValidate.setBounds(184, 98, 230, 18);
		panel.add(lbl_ItemCodeValidate);

		txt_ItemCode = new JTextField();
		txt_ItemCode.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {

				char c = e.getKeyChar();
				if (Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE) {
					txt_ItemCode.setEditable(true);
					lbl_ItemCodeValidate.setText("");

				} else {
					txt_ItemCode.setEditable(false);
					lbl_ItemCodeValidate.setText("*Please input a Number");
				}
			}
		});
		txt_ItemCode.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		txt_ItemCode.setBounds(170, 126, 282, 38);
		panel.add(txt_ItemCode);
		txt_ItemCode.setColumns(10);

		txt_DiscountName = new JTextField();
		txt_DiscountName.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		txt_DiscountName.setColumns(10);
		txt_DiscountName.setBounds(170, 181, 282, 38);
		panel.add(txt_DiscountName);

		JLabel lbl_DiscountPriceValidate = new JLabel("");
		lbl_DiscountPriceValidate.setForeground(Color.RED);
		lbl_DiscountPriceValidate.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lbl_DiscountPriceValidate.setBounds(184, 222, 230, 18);
		panel.add(lbl_DiscountPriceValidate);

		txt_discountPrice = new JTextField();
		txt_discountPrice.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				char c = e.getKeyChar();
				if (Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE) {
					txt_discountPrice.setEditable(true);
					lbl_DiscountPriceValidate.setText("");

				} else {
					txt_discountPrice.setEditable(false);
					lbl_DiscountPriceValidate.setText("*Please input in valid format");
				}

			}
		});
		txt_discountPrice.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		txt_discountPrice.setColumns(10);
		txt_discountPrice.setBounds(170, 238, 282, 38);
		panel.add(txt_discountPrice);

		JButton btn_submit = new JButton("Submit");

		btn_submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// Check text fields are empty
				if (txt_ItemCode.getText().equals("") || txt_DiscountName.getText().equals("")
						|| txt_discountPrice.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Please Fill all fields!!");

				} else {

					// Get Current Date
					Calendar cal = Calendar.getInstance();
					SimpleDateFormat dateOnly = new SimpleDateFormat("dd/MM/yyyy");

					String itemCode = txt_ItemCode.getText();
					String discountName = txt_DiscountName.getText();
					double discount = Float.parseFloat(txt_discountPrice.getText());
					String date = dateOnly.format(cal.getTime());

					// Get selling price

					try {

						DBConnect db = new DBConnect();
						PreparedStatement ps1;
						Connection con1 = db.Connect();

						ps1 = con1.prepareStatement("select * from item where ItemCode = ?");

						ps1.setInt(1, Integer.parseInt(itemCode));
						ResultSet rs1;

						rs1 = ps1.executeQuery();

						String sellingPrice = null;

						while (rs1.next()) {
							sellingPrice = rs1.getString(7);

						}
						float SelP = 0;

						try {
							SelP = Float.parseFloat(sellingPrice);

						} catch (NullPointerException ex) {
							JOptionPane.showMessageDialog(null, "Discount not Added!!");
							txt_ItemCode.setText("");
							txt_DiscountName.setText("");
							txt_discountPrice.setText("");

							txt_ItemCode.requestFocus();

							return;
						}
						Calculations calc = new Calculations();

						float discountPercentage = calc.calcDiscountPercentage(discount, SelP);

						String discountPercentageStr = String.format("%.1f", discountPercentage);

						String previousPrice = sellingPrice;
						double currentPrice = (double) SelP - discount;

						
						Connection con2 =db.Connect();
						PreparedStatement ps2;

						ps2 = con2.prepareStatement("update item set SellingPrice = ? where ItemCode = ?");

						ps2.setString(1, String.valueOf(currentPrice));
						ps2.setInt(2, Integer.parseInt(itemCode));

						ps2.executeUpdate();

						Connection con3 = db.Connect();
						PreparedStatement ps3;

						ps3 = con3.prepareStatement(
								"insert into discount (ItemCode,Date,DiscountName,Discount,DiscountPercentage,CurrentPrice,PreviousPrice) values (?,?,?,?,?,?,?)");
						ps3.setInt(1, Integer.parseInt(itemCode));
						ps3.setString(2, date);
						ps3.setString(3, discountName);
						ps3.setDouble(4, discount);
						ps3.setFloat(5, Float.parseFloat(discountPercentageStr));
						ps3.setString(6, String.valueOf(currentPrice));
						ps3.setString(7, previousPrice);

						try {

							ps3.executeUpdate();

						} catch (SQLIntegrityConstraintViolationException e1) {
							JOptionPane.showMessageDialog(null, "Can Not add multiple discounts for single item!!");
							txt_ItemCode.setText("");
							txt_DiscountName.setText("");
							txt_discountPrice.setText("");

							txt_ItemCode.requestFocus();

							return;

						}

						JOptionPane.showMessageDialog(null, "Discount Added!!");
						tableLoad();

					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}
			}
		});

		btn_submit.setForeground(Color.WHITE);
		btn_submit.setBorderPainted(false);
		btn_submit.setFont(new Font("Roboto", Font.PLAIN, 25));
		btn_submit.setBounds(271, 326, 181, 50);
		panel.add(btn_submit);
		btn_submit.setBackground(new Color(19, 141, 117));
		
		// Submit button hover effect
		btn_submit.addMouseListener(new java.awt.event.MouseAdapter() {
					public void mouseEntered(java.awt.event.MouseEvent evt) {
						btn_submit.setBackground(new Color(106, 191, 174));
					}

					public void mouseExited(java.awt.event.MouseEvent evt) {
						btn_submit.setBackground(new Color(19, 141, 117));
					}
				});

		JButton btn_Clear = new JButton("Clear");
		btn_Clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txt_ItemCode.setText("");
				txt_DiscountName.setText("");
				txt_discountPrice.setText("");

				txt_ItemCode.setEditable(true);
				txt_discountPrice.setEditable(true);

				lbl_ItemCodeValidate.setText("");
				lbl_DiscountPriceValidate.setText("");

				txt_ItemCode.requestFocus();

			}
		});
		btn_Clear.setForeground(Color.WHITE);
		btn_Clear.setFont(new Font("Roboto", Font.PLAIN, 25));
		btn_Clear.setBorderPainted(false);
		btn_Clear.setBackground(new Color(19, 141, 117));
		btn_Clear.setBounds(64, 326, 181, 50);
		panel.add(btn_Clear);
		
		JLabel back = new JLabel("");
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
		back.setBounds(10, 10, 49, 41);
		panel.add(back);
		back.setIcon(resize(new ImageIcon(this.getClass().getResource("/Discount_back.png")),back.getWidth(), back.getHeight()));
		
		JButton btnNewButton = new JButton("Demo");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txt_ItemCode.setText("1");
				txt_DiscountName.setText("Normal Discount");
				txt_discountPrice.setText("20");
				
				
				
			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.BLUE);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton.setBounds(326, 33, 126, 41);
		panel.add(btnNewButton);
		
		
		
		


		// Submit button hover effect
		btn_Clear.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				btn_Clear.setBackground(new Color(106, 191, 174));
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				btn_Clear.setBackground(new Color(19, 141, 117));
			}
		});

		JLabel lblViewItem = new JLabel("Item List");
		lblViewItem.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 21));
		lblViewItem.setBounds(495, 174, 156, 41);
		contentPane.add(lblViewItem);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(495, 225, 498, 184);
		contentPane.add(scrollPane);

		ItemTable = new JTable();
		ItemTable.setRowHeight(20);
		scrollPane.setViewportView(ItemTable);
		ItemTable.getTableHeader().setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		ItemTable.setOpaque(false);
		ItemTable.setRowHeight(20);

		JLabel lblSearchItem = new JLabel("Search Item");
		lblSearchItem.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 21));
		lblSearchItem.setBounds(501, 419, 156, 41);
		contentPane.add(lblSearchItem);

		JLabel lbl_ItemCode_1 = new JLabel("Item Code");
		lbl_ItemCode_1.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		lbl_ItemCode_1.setBounds(511, 472, 100, 34);
		contentPane.add(lbl_ItemCode_1);

		txt_ItemCodeSearch = new JTextField();
		txt_ItemCodeSearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				char c = e.getKeyChar();
				if (Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE) {
					txt_ItemCodeSearch.setEditable(true);

				} else {
					txt_ItemCodeSearch.setEditable(false);
				}
			}
		});
		txt_ItemCodeSearch.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		txt_ItemCodeSearch.setColumns(10);
		txt_ItemCodeSearch.setBounds(608, 470, 212, 38);
		contentPane.add(txt_ItemCodeSearch);

		JLabel lbl_ItemName = new JLabel("Item Name :");
		lbl_ItemName.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 17));
		lbl_ItemName.setBounds(501, 529, 99, 35);
		contentPane.add(lbl_ItemName);

		JLabel txt_ItemName = new JLabel("");
		txt_ItemName.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		txt_ItemName.setBounds(608, 529, 99, 35);
		contentPane.add(txt_ItemName);

		JLabel lbl_Price = new JLabel("Selling Price :");
		lbl_Price.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 17));
		lbl_Price.setBounds(717, 529, 137, 35);
		contentPane.add(lbl_Price);

		JLabel txt_Price = new JLabel("");
		txt_Price.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		txt_Price.setBounds(826, 529, 99, 35);
		contentPane.add(txt_Price);

		JButton btn_searchItem = new JButton("Search");
		btn_searchItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (txt_ItemCodeSearch.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Please input an item Code!!");
					txt_ItemCodeSearch.setEditable(true);
				}

				else {
					DBConnect db = new DBConnect();

					txt_ItemCodeSearch.setEditable(true);
					Connection con = db.Connect();
					PreparedStatement ps;

					try {
						ps = con.prepareStatement("select ItemName, SellingPrice from item where ItemCode = ?");
						ps.setInt(1, Integer.parseInt(txt_ItemCodeSearch.getText()));
						ResultSet rs = ps.executeQuery();

						if (rs.next() == true) {

							String itemName = rs.getString(1);
							String sellingPrice = rs.getString(2);

							txt_ItemName.setText(itemName);
							txt_Price.setText(sellingPrice + " LKR");

						} else {

							txt_ItemName.setText("");
							txt_Price.setText("");

							txt_ItemCodeSearch.requestFocus();
							JOptionPane.showMessageDialog(null, "Record Not Found!!");

						}

					} catch (NumberFormatException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}

			}
		});
		btn_searchItem.setForeground(Color.WHITE);
		btn_searchItem.setBorderPainted(false);
		btn_searchItem.setFont(new Font("Roboto", Font.PLAIN, 19));
		btn_searchItem.setBounds(845, 470, 118, 38);
		contentPane.add(btn_searchItem);
		btn_searchItem.setBackground(new Color(19, 141, 117));
		
		
		// Submit button hover effect
		btn_searchItem.addMouseListener(new java.awt.event.MouseAdapter() {
							public void mouseEntered(java.awt.event.MouseEvent evt) {
								btn_searchItem.setBackground(new Color(106, 191, 174));
							}

							public void mouseExited(java.awt.event.MouseEvent evt) {
								btn_searchItem.setBackground(new Color(19, 141, 117));
							}
						});


	}
}
