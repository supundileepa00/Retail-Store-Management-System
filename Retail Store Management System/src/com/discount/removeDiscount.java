package com.discount;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;

import java.sql.*;
import com.main.*;

import net.proteanit.sql.DbUtils;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class removeDiscount extends JFrame {

	private JPanel contentPane;
	private JTextField text_discountID;
	private static JTable discountTable;
	private JTextField txt_discountID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					removeDiscount frame = new removeDiscount();
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

	//Load data from discount table
			public static void LoadDiscountTable() {
				DBConnect db = new DBConnect();
				Connection con = db.Connect();
				PreparedStatement ps;
				ResultSet rs;
				
				try {
					ps = con.prepareStatement("select * from discount");
					rs = ps.executeQuery();
					discountTable.setModel(DbUtils.resultSetToTableModel(rs));
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
	public removeDiscount() {
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
		label_Main_logo.setBounds(0, -17, 183, 168);
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
		btn_home.setBounds(884, 114, 108, 37);
		panel_Header.add(btn_home);

		JButton btn_MMRemoveDiscount = new JButton("Remove Discount");
		btn_MMRemoveDiscount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				 
				 removeDiscount rmDis = new removeDiscount();
				 
				 rmDis.setResizable(false);
				 rmDis.setLocationRelativeTo(null);
				 rmDis.LoadDiscountTable();
				 rmDis.setVisible(true);
			}
		});
		btn_MMRemoveDiscount.setForeground(new Color(255, 250, 205));
		btn_MMRemoveDiscount.setBorderPainted(false);
		btn_MMRemoveDiscount.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btn_MMRemoveDiscount.setBounds(490, 114, 165, 37);
		btn_MMRemoveDiscount.setBackground(new Color(161, 158, 177));
		panel_Header.add(btn_MMRemoveDiscount);

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
		btn_MarketingManager.setBounds(659, 114, 221, 37);
		panel_Header.add(btn_MarketingManager);

		//////////////////////////////////////////

		JPanel panel = new JPanel();
		panel.setBounds(0, 150, 453, 513);
		contentPane.add(panel);
		panel.setBackground(new Color(229, 229, 229));
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Remove Discount");
		lblNewLabel.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 23));
		lblNewLabel.setBounds(10, 35, 216, 42);
		panel.add(lblNewLabel);

		JLabel img_removeDiscount = new JLabel("");
		img_removeDiscount.setBounds(100, 72, 227, 197);
		panel.add(img_removeDiscount);
		img_removeDiscount.setIcon(resize(new ImageIcon(this.getClass().getResource("/removeDiscount.png")),
				img_removeDiscount.getWidth(), img_removeDiscount.getHeight()));

		JLabel lbl_discountID = new JLabel("Discount ID");
		lbl_discountID.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lbl_discountID.setBounds(10, 279, 135, 42);
		panel.add(lbl_discountID);

		JLabel lbl_rmvDError = new JLabel("");
		lbl_rmvDError.setForeground(new Color(242, 72, 72));
		lbl_rmvDError.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lbl_rmvDError.setBounds(158, 258, 273, 26);
		panel.add(lbl_rmvDError);

		text_discountID = new JTextField();
		text_discountID.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				char c = e.getKeyChar();
				if (Character.isDigit(c)||c== KeyEvent.VK_BACK_SPACE) {
					text_discountID.setEditable(true);
					lbl_rmvDError.setText("");
					

				} else {
					text_discountID.setEditable(false);
					lbl_rmvDError.setText("*Please input a Number");
				}
			}
		});
		text_discountID.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		text_discountID.setBounds(155, 284, 273, 37);
		panel.add(text_discountID);
		text_discountID.setColumns(10);

		JButton btn_removeDiscount = new JButton("Remove Discount");
		btn_removeDiscount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (text_discountID.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Field is Empty!!");
				} else {

					String discountID = text_discountID.getText();
					
					DBConnect db = new DBConnect();
					PreparedStatement ps1;
					Connection con1 = db.Connect();

					try {
						ps1 = con1.prepareStatement("select * from discount where DiscountID = ?");
						ps1.setInt(1, Integer.parseInt(discountID));

						ResultSet rs1 = ps1.executeQuery();
						
						
						String previousPrice = null;
						int itemCode = 0;

						while (rs1.next()) {
							previousPrice = rs1.getString(8);
							itemCode = rs1.getInt(2);
						}

						con1.close();

						PreparedStatement ps2;
						Connection con2 = db.Connect();

						ps2 = con2.prepareStatement("delete from discount where DiscountID = ?");
						ps2.setInt(1, Integer.parseInt(discountID));
						ps2.executeUpdate();

						con2.close();

						PreparedStatement ps3;
						Connection con3 = db.Connect();

						ps3 = con3.prepareStatement("update item set SellingPrice = ? where ItemCode = ?");

						ps3.setString(1, previousPrice);
						ps3.setInt(2, itemCode);
						if(ps3.executeUpdate() > 0) {

							JOptionPane.showMessageDialog(null, "Discount Deleted!!");
							text_discountID.setText("");
							LoadDiscountTable();
						}
						else {
							JOptionPane.showMessageDialog(null, "Discount not found!!");
							text_discountID.setText("");
							LoadDiscountTable();
						}
						

					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}

			}
		});
		btn_removeDiscount.setForeground(Color.WHITE);
		btn_removeDiscount.setBorderPainted(false);
		btn_removeDiscount.setFont(new Font("Roboto Medium", Font.PLAIN, 23));
		btn_removeDiscount.setBounds(215, 356, 216, 62);
		panel.add(btn_removeDiscount);
		btn_removeDiscount.setBackground(new Color(220, 56, 37));
		
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
		back.setBounds(0, 0, 45, 37);
		panel.add(back);
		back.setIcon(resize(new ImageIcon(this.getClass().getResource("/Discount_back.png")),back.getWidth(), back.getHeight()));

		// btn_removeDiscount button hover effect
		btn_removeDiscount.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				btn_removeDiscount.setBackground(new Color(217, 106, 93));
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				btn_removeDiscount.setBackground(new Color(220, 56, 37));
			}
		});

		JLabel lblViewDiscount = new JLabel("View Discounts");
		lblViewDiscount.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 23));
		lblViewDiscount.setBounds(463, 165, 216, 42);
		contentPane.add(lblViewDiscount);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(463, 226, 520, 177);
		contentPane.add(scrollPane);

		discountTable = new JTable();
		scrollPane.setViewportView(discountTable);
		discountTable.setOpaque(false);
		discountTable.setRowHeight(20);


		JLabel lblSearchDiscount = new JLabel("Search Discount");
		lblSearchDiscount.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 21));
		lblSearchDiscount.setBounds(469, 411, 204, 54);
		contentPane.add(lblSearchDiscount);

		JLabel label_discountID = new JLabel("Discount ID");
		label_discountID.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		label_discountID.setBounds(469, 462, 113, 42);
		contentPane.add(label_discountID);

		JLabel lbl_rmvDError_2 = new JLabel("");
		lbl_rmvDError_2.setForeground(new Color(242, 72, 72));
		lbl_rmvDError_2.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lbl_rmvDError_2.setBounds(592, 449, 190, 16);
		contentPane.add(lbl_rmvDError_2);

		txt_discountID = new JTextField();
		txt_discountID.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				char c = e.getKeyChar();
				if (Character.isDigit(c)||c== KeyEvent.VK_BACK_SPACE) {
					txt_discountID.setEditable(true);
					lbl_rmvDError_2.setText("");
					

				} else {
					txt_discountID.setEditable(false);
					lbl_rmvDError_2.setText("*Please input a Number");
				}
			}
		});
		txt_discountID.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txt_discountID.setColumns(10);
		txt_discountID.setBounds(592, 472, 190, 34);
		contentPane.add(txt_discountID);

		JLabel lblItemCode_2 = new JLabel("Item Code :");
		lblItemCode_2.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 17));
		lblItemCode_2.setBounds(463, 528, 99, 35);
		contentPane.add(lblItemCode_2);

		JLabel lbl_viewItemCode = new JLabel("");
		lbl_viewItemCode.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		lbl_viewItemCode.setBounds(558, 528, 99, 35);
		contentPane.add(lbl_viewItemCode);

		JLabel lblDiscountName = new JLabel("Discount Name :");
		lblDiscountName.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 17));
		lblDiscountName.setBounds(667, 528, 132, 35);
		contentPane.add(lblDiscountName);

		JLabel lbl_ViewDiscountName_1 = new JLabel("");
		lbl_ViewDiscountName_1.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lbl_ViewDiscountName_1.setBounds(801, 528, 192, 35);
		contentPane.add(lbl_ViewDiscountName_1);

		JLabel lblDiscount = new JLabel("Discount % :");
		lblDiscount.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 17));
		lblDiscount.setBounds(463, 575, 99, 35);
		contentPane.add(lblDiscount);

		JLabel lbl_discountPer = new JLabel("");
		lbl_discountPer.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		lbl_discountPer.setBounds(568, 576, 99, 34);
		contentPane.add(lbl_discountPer);

		JLabel lblNewPrice = new JLabel(" New Price :");
		lblNewPrice.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 17));
		lblNewPrice.setBounds(667, 575, 99, 35);
		contentPane.add(lblNewPrice);

		JLabel lbl_newPrice = new JLabel("");
		lbl_newPrice.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		lbl_newPrice.setBounds(763, 576, 144, 34);
		contentPane.add(lbl_newPrice);

		JButton btn_searchDiscount = new JButton("Search");
		btn_searchDiscount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (txt_discountID.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Field is Empty!!");
				} else {
					DBConnect db = new DBConnect();
					Connection con1 = db.Connect();
					PreparedStatement ps1;

					try {
						ps1 = con1.prepareStatement(
								"select ItemCode,DiscountName,Discount,DiscountPercentage,CurrentPrice from discount where DiscountID = ? ");
						ps1.setInt(1, Integer.parseInt(txt_discountID.getText()));
						ResultSet rs1 = ps1.executeQuery();

						if (rs1.next() == true) {
							int itemCode = rs1.getInt(1);
							String discountName = rs1.getString(2);
							String discount = rs1.getString(3);
							String discountPercentage = rs1.getString(4);
							String curPrice = rs1.getString(5);

							lbl_viewItemCode.setText(String.valueOf(itemCode));
							lbl_ViewDiscountName_1.setText(discountName);
							lbl_discountPer.setText(discountPercentage + "%");
							lbl_newPrice.setText(curPrice + " LKR");

						} else {

							lbl_viewItemCode.setText("");
							lbl_ViewDiscountName_1.setText("");
							lbl_discountPer.setText("");
							lbl_newPrice.setText("");

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
		btn_searchDiscount.setFont(new Font("Roboto", Font.PLAIN, 18));
		btn_searchDiscount.setBorderPainted(false);
		btn_searchDiscount.setBackground(new Color(19, 141, 117));
		btn_searchDiscount.setBounds(813, 471, 132, 34);
		contentPane.add(btn_searchDiscount);

		// btn_removeDiscount button hover effect
		btn_searchDiscount.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				btn_searchDiscount.setBackground(new Color(106, 191, 174));
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				btn_searchDiscount.setBackground(new Color(19, 141, 117));
			}
		});

	}
}
