package com.inventory;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.sql.*;
import java.text.SimpleDateFormat;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

//import com.main.HomePage;
//import com.sun.jdi.connect.spi.Connection;
import com.toedter.calendar.JDateChooser;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class UpdateItemPage extends JFrame {

	private JPanel contentPane;
	private JTextField update_ItemName;
	private JTextField update_BuyingPrice;
	private JTextField update_Quantity;
	private JTextField update_SellingPrice;
	private JTextField input_ItemCode;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateItemPage frame = new UpdateItemPage();
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
	
	
	/**
	 * Create the frame.
	 */
	public UpdateItemPage() {
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
			
			JPanel ItemUpdateForm = new JPanel();
			ItemUpdateForm.setBackground(new Color(248,248,255));
			ItemUpdateForm.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Update Item Detail", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			ItemUpdateForm.setBounds(366, 188, 585, 356);
			contentPane.add(ItemUpdateForm);
			ItemUpdateForm.setLayout(null);
			
			JLabel view_BuyingPrice = new JLabel("Buying Price");
			view_BuyingPrice.setFont(new Font("Tahoma", Font.BOLD, 14));
			view_BuyingPrice.setBounds(26, 122, 97, 24);
			ItemUpdateForm.add(view_BuyingPrice);
			
			/*JLabel view_StockedDate = new JLabel("Stocked Date");
			view_StockedDate.setFont(new Font("Tahoma", Font.BOLD, 14));
			view_StockedDate.setBounds(26, 100, 97, 24);
			ItemUpdateForm.add(view_StockedDate); */
			
			JLabel view_ItemName = new JLabel("Item Name");
			view_ItemName.setFont(new Font("Tahoma", Font.BOLD, 14));
			view_ItemName.setBounds(26, 40, 97, 24);
			ItemUpdateForm.add(view_ItemName);
			
			JLabel view_Quantity = new JLabel("Quantity");
			view_Quantity.setFont(new Font("Tahoma", Font.BOLD, 14));
			view_Quantity.setBounds(26, 208, 97, 24);
			ItemUpdateForm.add(view_Quantity);
			
			JLabel view_SellingPrice = new JLabel("Selling Price");
			view_SellingPrice.setFont(new Font("Tahoma", Font.BOLD, 14));
			view_SellingPrice.setBounds(26, 287, 97, 24);
			ItemUpdateForm.add(view_SellingPrice);
			
			update_ItemName = new JTextField();
			update_ItemName.setBounds(162, 37, 261, 35);
			ItemUpdateForm.add(update_ItemName);
			update_ItemName.setColumns(10);
			
			update_BuyingPrice = new JTextField();
			//method to set input type as int
			update_BuyingPrice.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					
					char c = e.getKeyChar();
					if (Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE) {
						update_BuyingPrice.setEditable(true);

					} else {
						update_BuyingPrice.setEditable(false);
					}
				}
			});
			update_BuyingPrice.setColumns(10);
			update_BuyingPrice.setBounds(162, 119, 261, 35);
			ItemUpdateForm.add(update_BuyingPrice);
			
			update_Quantity = new JTextField();
			//method to set input type as int
			update_Quantity.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					
					char c = e.getKeyChar();
					if (Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE) {
						update_Quantity.setEditable(true);

					} else {
						update_Quantity.setEditable(false);
					}
					
				}
			});
			update_Quantity.setColumns(10);
			update_Quantity.setBounds(162, 205, 261, 35);
			ItemUpdateForm.add(update_Quantity);
			
			update_SellingPrice = new JTextField();
			//method to set input type as int
			update_SellingPrice.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					
					char c = e.getKeyChar();
					if (Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE) {
						update_SellingPrice.setEditable(true);

					} else {
						update_SellingPrice.setEditable(false);
					}
				}
			});
			update_SellingPrice.setColumns(10);
			update_SellingPrice.setBounds(162, 284, 261, 35);
			ItemUpdateForm.add(update_SellingPrice);
			
			/*JDateChooser update_StockedDate = new JDateChooser();
			update_StockedDate.setBounds(162, 100, 261, 35);
			ItemUpdateForm.add(update_StockedDate);*/
			
			JButton btn_Update = new JButton("Update");
			btn_Update.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					
					// declare item variables
					String name;
					String quantity;
					String bPrice;
					String sPrice;
					SimpleDateFormat dateOnly = new SimpleDateFormat("dd/MM/yyyy");
					String bId;
					
					// Date selectedDate = (Date) datePicker.getModel().getValue();

					name = update_ItemName.getText();
					quantity = update_Quantity.getText();
					bPrice = update_BuyingPrice.getText();
					//String date = dateOnly.format(input_StockedDate.getDate());
					sPrice = update_SellingPrice.getText();
					bId = input_ItemCode.getText();
					
					//method for calculate paid amount
					Double paidAmount = Double.parseDouble(bPrice)*Double.parseDouble(quantity);
					
					if(name.equals("") || quantity.equals("") || bPrice.equals("")
						|| sPrice.equals("")){
						
						JOptionPane.showMessageDialog(null, "Please Fill all fields!!");
						
					}else {
						
						// update data in item table
						try {
							
							dbConnect connect = new dbConnect();
							Connection con = connect.getConnection();
							PreparedStatement stmt = con.prepareStatement(
									"update item set ItemName=?,BuyingPrice=?,Quantity=?,PaidAmount=?,SellingPrice=? where ItemCode='"+input_ItemCode.getText()+"'");

							stmt.setString(1, name);
							//stmt.setString(2, date);
							stmt.setString(2, bPrice);
							stmt.setString(3, quantity);
							stmt.setString(4, String.valueOf(paidAmount));
							stmt.setString(5, sPrice);
							stmt.executeUpdate();
							JOptionPane.showMessageDialog(null, "Item Added Succesfully");

							// set fields to null after inserted data
							update_ItemName.setText("");
							//input_StockedDate.setToolTipText("");
							update_Quantity.setText("");
							update_BuyingPrice.setText("");
							update_SellingPrice.setText("");

							// set cursor to begin field
							update_ItemName.requestFocus();
							
							
						}catch(Exception e1){
							e1.printStackTrace();
						}
						
					}
					
				}
			});
			
			btn_Update.setFont(new Font("Tahoma", Font.BOLD, 11));
			btn_Update.setBackground(new Color(153, 255, 102));
			btn_Update.setBounds(437, 571, 128, 45);
			contentPane.add(btn_Update);
			
			JPanel panel_SearchItem = new JPanel();
			panel_SearchItem.setBackground(new Color(248,248,255));
			panel_SearchItem.setBorder(new TitledBorder(null, "Search", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_SearchItem.setBounds(20, 288, 325, 99);
			contentPane.add(panel_SearchItem);
			panel_SearchItem.setLayout(null);
			
			JLabel view_ItemCode = new JLabel("Item Code");
			view_ItemCode.setFont(new Font("Tahoma", Font.BOLD, 12));
			view_ItemCode.setBounds(10, 46, 69, 15);
			panel_SearchItem.add(view_ItemCode);
			
			input_ItemCode = new JTextField();
			input_ItemCode.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					
					try {
						
						String id = input_ItemCode.getText(); 
						dbConnect connect = new dbConnect();
						Connection con = connect.getConnection();
						PreparedStatement ps = con.prepareStatement("select ItemName,StockedDate,BuyingPrice,Quantity,SellingPrice from item where ItemCode = '"+input_ItemCode.getText()+"'");
						ResultSet rs = ps.executeQuery();
						
						if(rs.next()==true) {
							String name = rs.getString(1);
							String date = rs.getString(2);
							String bPrice = rs.getString(3);
							String quantity = rs.getString(4);
							String sPrice = rs.getString(5);
							
							update_ItemName.setText(name); 
							//update_StockedDate.setToolTipText(date);  
							update_BuyingPrice.setText(bPrice);  
							update_Quantity.setText(quantity); 
							update_SellingPrice.setText(sPrice);
							
						}else {
							
							update_ItemName.setText(""); 
							//update_StockedDate.setToolTipText("");  
							update_BuyingPrice.setText("");  
							update_Quantity.setText(""); 
							update_SellingPrice.setText("");
						}
						
					}catch(SQLException e2) {
						e2.printStackTrace();
					}
					
					
					
				}
				@Override
				public void keyTyped(KeyEvent e) {
					
					char c = e.getKeyChar();
					if (Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE) {
						input_ItemCode.setEditable(true);

					} else {
						input_ItemCode.setEditable(false);
					}
				}
			});
			input_ItemCode.setBounds(89, 39, 152, 30);
			panel_SearchItem.add(input_ItemCode);
			input_ItemCode.setColumns(10);
			
			JButton btn_Delete = new JButton("Delete");
			btn_Delete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					String bId;
					bId = input_ItemCode.getText();
					
					if(bId.equals("")) {
						
						JOptionPane.showMessageDialog(null, "Please Select Item Code to Delete!");
					}else {
					
					try {
						
						dbConnect del = new dbConnect();
						Connection con = del.getConnection();
						PreparedStatement ps = con.prepareStatement("delete from item where ItemCode='"+input_ItemCode.getText()+"'");
						
						ps.executeUpdate();
						JOptionPane.showMessageDialog(null, "Item delete Successfully!");
						
						update_ItemName.setText(""); 
						//update_StockedDate.setToolTipText("");  
						update_BuyingPrice.setText("");  
						update_Quantity.setText(""); 
						update_SellingPrice.setText("");
						
					}catch(SQLException e4) {
						e4.printStackTrace();
					
						}
					}
				}
			});
			btn_Delete.setFont(new Font("Tahoma", Font.BOLD, 11));
			btn_Delete.setBackground(new Color(252, 76, 76));
			btn_Delete.setBounds(622, 571, 128, 45);
			contentPane.add(btn_Delete);
			
			JButton btn_Back = new JButton("Back");
			btn_Back.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					dispose();
					ViewListedItemPage backListViewPage = new ViewListedItemPage();
					backListViewPage.setVisible(true);
					backListViewPage.setResizable(false);
					backListViewPage.setLocationRelativeTo(null);
				}
			});
			btn_Back.setFont(new Font("Tahoma", Font.BOLD, 11));
			btn_Back.setBackground(new Color(124, 252, 252));
			btn_Back.setBounds(796, 571, 128, 45);
			contentPane.add(btn_Back);
			
			
					//set hover for update button
					btn_Update.addMouseListener(new java.awt.event.MouseAdapter() {
							public void mouseEntered(java.awt.event.MouseEvent evt) {
									btn_Update.setBackground(new Color(85, 255, 0));
								}

								public void mouseExited(java.awt.event.MouseEvent evt) {
										btn_Update.setBackground(new Color(153, 255, 102));
									}
						});
			
			
						//set hover for delete button
						btn_Delete.addMouseListener(new java.awt.event.MouseAdapter() {
								public void mouseEntered(java.awt.event.MouseEvent evt) {
										btn_Delete.setBackground(new Color(255, 0, 0));
									}

									public void mouseExited(java.awt.event.MouseEvent evt) {
											btn_Delete.setBackground(new Color(252, 76, 76));
										}
						});
						
						//set hover for back button
						btn_Back.addMouseListener(new java.awt.event.MouseAdapter() {
								public void mouseEntered(java.awt.event.MouseEvent evt) {
									btn_Back.setBackground(new Color(0, 255, 255));
									}

									public void mouseExited(java.awt.event.MouseEvent evt) {
										btn_Back.setBackground(new Color(124, 252, 252));
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
