package com.inventory;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.sql.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import com.toedter.calendar.JDayChooser;
import com.toedter.calendar.JMonthChooser;
import com.toedter.components.JLocaleChooser;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import com.toedter.components.JSpinField;

import java.util.Calendar;
import java.util.Date;

import com.toedter.calendar.JYearChooser;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class AddNewItemPage extends JFrame {

	private JPanel contentPane;
	private JTextField input_ItemName;
	private JTextField input_BuyingPrice;
	private JTextField input_Quantity;
	private JTextField input_SellingPrice;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddNewItemPage frame = new AddNewItemPage();
					frame.setVisible(true);
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

	// sql query to insert item data
	private static final String insert_item_details = "insert into item(ItemCode.ItemName,StockedDate,BuyingPrice,Quantity,PaidAmount,SellingPrice)values(?,?,?,?,?,?)";
	
	/**
	 * Create the frame.
	 */
	public AddNewItemPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1007, 685);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204,204,204));
		contentPane.setAutoscrolls(true);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JPanel panel_Header = new JPanel();
		panel_Header.setBackground(new Color(25, 25, 153));
		panel_Header.setBounds(0, 0, 991, 151);
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
		label_Main_logo.setIcon(resize(new ImageIcon(this.getClass().getResource("/img_Logo.png")),
				label_Main_logo.getWidth(), label_Main_logo.getHeight()));

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
		btn_home.setBackground(new Color(157, 144, 227));
		btn_home.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btn_home.setBounds(863, 100, 129, 51);
		panel_Header.add(btn_home);

		JButton btn_adminLogin = new JButton("Admin Login");
		btn_adminLogin.setForeground(new Color(255, 250, 205));
		btn_adminLogin.setBorderPainted(false);
		btn_adminLogin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btn_adminLogin.setBounds(734, 100, 129, 51);
		btn_adminLogin.setBackground(new Color(157, 144, 227));
		panel_Header.add(btn_adminLogin);

		JPanel ItemAddingForm = new JPanel();
		ItemAddingForm.setBackground(new Color(248,248,255));
		ItemAddingForm
				.setBorder(new TitledBorder(null, "Add New Item", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		ItemAddingForm.setBounds(24, 176, 585, 356);
		contentPane.add(ItemAddingForm);
		ItemAddingForm.setLayout(null);

		JLabel view_BuyingPrice = new JLabel("Buying Price");
		view_BuyingPrice.setBounds(26, 163, 97, 24);
		view_BuyingPrice.setFont(new Font("Tahoma", Font.BOLD, 14));
		ItemAddingForm.add(view_BuyingPrice);

		JLabel view_StockedDate = new JLabel("Stocked Date");
		view_StockedDate.setBounds(26, 100, 97, 24);
		view_StockedDate.setFont(new Font("Tahoma", Font.BOLD, 14));
		ItemAddingForm.add(view_StockedDate);

		JLabel view_ItemName = new JLabel("Item Name");
		view_ItemName.setBounds(26, 40, 97, 24);
		view_ItemName.setFont(new Font("Tahoma", Font.BOLD, 14));
		ItemAddingForm.add(view_ItemName);

		JLabel view_Quantity = new JLabel("Quantity");
		view_Quantity.setBounds(26, 234, 97, 24);
		view_Quantity.setFont(new Font("Tahoma", Font.BOLD, 14));
		ItemAddingForm.add(view_Quantity);

		JLabel view_SellingPrice = new JLabel("Selling Price");
		view_SellingPrice.setBounds(26, 306, 97, 24);
		view_SellingPrice.setFont(new Font("Tahoma", Font.BOLD, 14));
		ItemAddingForm.add(view_SellingPrice);

		input_ItemName = new JTextField();
		input_ItemName.setBounds(168, 44, 261, 35);
		ItemAddingForm.add(input_ItemName);
		input_ItemName.setColumns(10);

		input_BuyingPrice = new JTextField();
		
		//method to set input type as int
		input_BuyingPrice.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {

				char c = e.getKeyChar();
				if (Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE) {
					input_BuyingPrice.setEditable(true);

				} else {
					input_BuyingPrice.setEditable(false);
				}
			}
		});
		input_BuyingPrice.setBounds(168, 167, 261, 35);
		input_BuyingPrice.setColumns(10);
		ItemAddingForm.add(input_BuyingPrice);

		
		input_Quantity = new JTextField();
		//method to set input type as int
		input_Quantity.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				
				char c = e.getKeyChar();
				if (Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE) {
					input_Quantity.setEditable(true);

				} else {
					input_Quantity.setEditable(false);
				}
				
			}
		});
		input_Quantity.setBounds(168, 238, 261, 35);
		input_Quantity.setColumns(10);
		ItemAddingForm.add(input_Quantity);

		input_SellingPrice = new JTextField();
		//method to set input type as int
		input_SellingPrice.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				
				char c = e.getKeyChar();
				if (Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE) {
					input_SellingPrice.setEditable(true);

				} else {
					input_SellingPrice.setEditable(false);
				}
			}
		});
		input_SellingPrice.setBounds(168, 303, 261, 35);
		input_SellingPrice.setColumns(10);
		ItemAddingForm.add(input_SellingPrice);

		JDateChooser input_StockedDate = new JDateChooser();
		input_StockedDate.setBounds(168, 104, 261, 35);
		ItemAddingForm.add(input_StockedDate);

		JButton btn_AddItem = new JButton("Add Item");
		btn_AddItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// declare item variables
				String name;
				String quantity;
				String bPrice;
				String sPrice;
				SimpleDateFormat dateOnly = new SimpleDateFormat("dd/MM/yyyy");
				
				// Date selectedDate = (Date) datePicker.getModel().getValue();

				name = input_ItemName.getText();
				quantity = input_Quantity.getText();
				bPrice = input_BuyingPrice.getText();
				String date = dateOnly.format(input_StockedDate.getDate());
				sPrice = input_SellingPrice.getText();
				
				
				//method for calculate paid amount
				Double paidAmount = Double.parseDouble(bPrice)*Double.parseDouble(quantity);
				
				// Check text fields are empty
				if (name.equals("") || date.equals("") || quantity.equals("") || bPrice.equals("")
						|| sPrice.equals("")) {
					JOptionPane.showMessageDialog(null, "Please Fill all fields!!");

				} else {
					// insert data into item table
					try {
						dbConnect connect = new dbConnect();
						Connection con = connect.getConnection();
						PreparedStatement stmt = con.prepareStatement(
								"insert into item(ItemName,StockedDate,BuyingPrice,Quantity,PaidAmount,SellingPrice)values(?,?,?,?,?,?)");

						stmt.setString(1, name);
						stmt.setString(2, date);
						stmt.setString(3, bPrice);
						stmt.setString(4, quantity);
						stmt.setString(5, String.valueOf(paidAmount));
						stmt.setString(6, sPrice);
						stmt.executeUpdate();
						JOptionPane.showMessageDialog(null, "Item Added Succesfully");

						// set fields to null after inserted data
						input_ItemName.setText("");
						input_StockedDate.setToolTipText("");
						input_Quantity.setText("");
						input_BuyingPrice.setText("");
						input_SellingPrice.setText("");

						// set cursor to begin field
						input_ItemName.requestFocus();

					} catch (Exception e1) {
						e1.printStackTrace();
					}

				}

			}
		});

		btn_AddItem.setBackground(new Color(153, 255, 102));
		btn_AddItem.setBounds(132, 569, 128, 45);
		contentPane.add(btn_AddItem);
		
		JButton btn_backNavPage = new JButton("Back");
		btn_backNavPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				NavigationPage backNavPage = new NavigationPage();
				backNavPage.setVisible(true);
				backNavPage.setResizable(false);
				backNavPage.setLocationRelativeTo(null);
			}
		});
		btn_backNavPage.setBackground(new Color(124, 252, 252));
		btn_backNavPage.setBounds(320, 569, 128, 45);
		contentPane.add(btn_backNavPage);
		
		JLabel lbl_buyMore = new JLabel("");
		lbl_buyMore.setBounds(687, 259, 204, 221);
		contentPane.add(lbl_buyMore);
		lbl_buyMore.setIcon(resize(new ImageIcon(this.getClass().getResource("/in-buymore.png")),lbl_buyMore.getWidth(), lbl_buyMore.getHeight()));
		
		JButton btn_demo = new JButton("Demo");
		btn_demo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				
				
				input_ItemName.setText("Rice");
				input_Quantity.setText("200");
				input_BuyingPrice.setText("120");
				input_SellingPrice.setText("200");
				
				
				
			
				
			}
		});
		btn_demo.setBackground(new Color(124, 252, 252));
		btn_demo.setBounds(481, 569, 128, 45);
		contentPane.add(btn_demo);
		
		
				//set hover for addItem button
				btn_AddItem.addMouseListener(new java.awt.event.MouseAdapter() {
						public void mouseEntered(java.awt.event.MouseEvent evt) {
								btn_AddItem.setBackground(new Color(85, 255, 0));
							}

							public void mouseExited(java.awt.event.MouseEvent evt) {
									btn_AddItem.setBackground(new Color(153, 255, 102));
								}
					});
				
				
				//set hover for back button
				btn_backNavPage.addMouseListener(new java.awt.event.MouseAdapter() {
						public void mouseEntered(java.awt.event.MouseEvent evt) {
							btn_backNavPage.setBackground(new Color(0, 255, 255));
							}

							public void mouseExited(java.awt.event.MouseEvent evt) {
								btn_backNavPage.setBackground(new Color(124, 252, 252));
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
