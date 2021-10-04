package com.inventory;
import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

//import com.main.HomePage;

import net.proteanit.sql.DbUtils;

import javax.swing.border.EtchedBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
public class ViewListedItemPage extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewListedItemPage frame = new ViewListedItemPage();
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
			Graphics2D gd = (Graphics2D)bi.createGraphics();
			gd.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING,RenderingHints.VALUE_RENDER_QUALITY));
			gd.drawImage(im.getImage(),0, 0, w, h, null);
			gd.dispose();
			return new ImageIcon(bi);
			}
			
			
			//load data to table
			public void loadTable() {
				
					dbConnect connect = new dbConnect();
					Connection con = connect.getConnection();
				try {
					
					PreparedStatement pst = con.prepareStatement("select * from item");
					ResultSet rs = pst.executeQuery();
					table_1.setModel(DbUtils.resultSetToTableModel(rs));
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
			
			

	/**
	 * Create the frame.
	 */
	public ViewListedItemPage() {
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
		
		JLabel view_stockDetails = new JLabel("Stock Details");
		view_stockDetails.setFont(new Font("Malgun Gothic", Font.BOLD, 16));
		view_stockDetails.setBounds(162, 177, 103, 43);
		contentPane.add(view_stockDetails);
		
		JButton btn_Edit = new JButton("Edit Item Details");
		btn_Edit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				UpdateItemPage updateItem = new UpdateItemPage();
				updateItem.setVisible(true);
				updateItem.setResizable(false);
				updateItem.setLocationRelativeTo(null);
				
			}
		});
		btn_Edit.setBackground(new Color(153, 255, 102));
		btn_Edit.setBounds(265, 540, 152, 63);
		contentPane.add(btn_Edit);
		
		JButton btn_BackNavPage = new JButton("Back");
		btn_BackNavPage.setForeground(Color.BLACK);
		btn_BackNavPage.setBackground( new Color(124, 252, 252));
		btn_BackNavPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				NavigationPage backNavPage = new NavigationPage();
				backNavPage.setVisible(true);
				backNavPage.setResizable(false);
				backNavPage.setLocationRelativeTo(null);
			}
		});
		btn_BackNavPage.setBounds(527, 540, 152, 63);
		contentPane.add(btn_BackNavPage);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(44, 248, 896, 273);
		contentPane.add(scrollPane);
		
		table_1 = new JTable();
		scrollPane.setViewportView(table_1);
		loadTable();
		
		JLabel lbl_cart = new JLabel("l");
		lbl_cart.setBounds(53, 170, 82, 63);
		contentPane.add(lbl_cart);
		lbl_cart.setIcon(resize(new ImageIcon(this.getClass().getResource("/inRetail.png")),lbl_cart.getWidth(), lbl_cart.getHeight()));
		
		
				//set hover for editItem button
				btn_Edit.addMouseListener(new java.awt.event.MouseAdapter() {
						public void mouseEntered(java.awt.event.MouseEvent evt) {
								btn_Edit.setBackground(new Color(85, 255, 0));
							}

							public void mouseExited(java.awt.event.MouseEvent evt) {
									btn_Edit.setBackground(new Color(153, 255, 102));
								}
					});
		
					//set hover for back button
					btn_BackNavPage.addMouseListener(new java.awt.event.MouseAdapter() {
							public void mouseEntered(java.awt.event.MouseEvent evt) {
									btn_BackNavPage.setBackground(new Color(0, 255, 255));
								}

								public void mouseExited(java.awt.event.MouseEvent evt) {
										btn_BackNavPage.setBackground(new Color(124, 252, 252));
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
