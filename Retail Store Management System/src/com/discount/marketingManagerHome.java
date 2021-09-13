package com.discount;
import javax.swing.*;
import javax.swing.border.Border;



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.main.*;

public class marketingManagerHome extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					marketingManagerHome frame = new marketingManagerHome();
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
	public marketingManagerHome() {
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
		label_Main_logo.setBounds(-9, -24, 186, 165);
		panel_Header.add(label_Main_logo);
		label_Main_logo.setIcon(resize(new ImageIcon(this.getClass().getResource("/img_Logo.png")),label_Main_logo.getWidth(), label_Main_logo.getHeight()));
		
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
		btn_home.setBackground(new Color(157, 144, 227  ));
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
		btn_MarketingManager.setBounds(629, 114, 231, 37);
		btn_MarketingManager.setBackground(new Color(161, 158, 177 ));
		panel_Header.add(btn_MarketingManager);
		
		////////////////////////////////////////////////////////
		
		JPanel panel_addDiscount = new JPanel();
		panel_addDiscount.setBounds(24, 185, 269, 240);
		panel_addDiscount.setBackground(new Color(229, 229, 229));
		contentPane.add(panel_addDiscount);
		panel_addDiscount.setLayout(null);
		
		JLabel addDiscountImg = new JLabel("");
		addDiscountImg.setBounds(48, 22, 143, 121);
		panel_addDiscount.add(addDiscountImg);
		addDiscountImg.setIcon(resize(new ImageIcon(this.getClass().getResource("/img_addDiscount.png")),addDiscountImg.getWidth(), addDiscountImg.getHeight()));
		panel_addDiscount.setBorder(new RoundedBorder(10));
		
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
		btn_addDiscount.setBorderPainted(false);
		btn_addDiscount.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 18));
		btn_addDiscount.setBounds(20, 165, 227, 65);
		panel_addDiscount.add(btn_addDiscount);
		btn_addDiscount.setBackground(Color.LIGHT_GRAY);
		
		//addDiscount button hover effect
		btn_addDiscount.addMouseListener(new java.awt.event.MouseAdapter() {
								    public void mouseEntered(java.awt.event.MouseEvent evt) {
								    	btn_addDiscount.setBackground(new Color(243, 243, 243  ));
								    }

								    public void mouseExited(java.awt.event.MouseEvent evt) {
								    	btn_addDiscount.setBackground(Color.LIGHT_GRAY);
								    }
								});
		
		
		
		JPanel panel_addDiscount_1 = new JPanel();
		panel_addDiscount_1.setLayout(null);
		panel_addDiscount_1.setBorder(new RoundedBorder(10));
		panel_addDiscount_1.setBackground(new Color(229, 229, 229));
		panel_addDiscount_1.setBounds(354, 185, 269, 240);
		contentPane.add(panel_addDiscount_1);
		
		JButton btn_viewDiscounts = new JButton("View Discounts");
		btn_viewDiscounts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				
				ViewDiscounts viewDis = new ViewDiscounts();
				viewDis.setLocationRelativeTo(null);
				viewDis.setResizable(false);
				viewDis.LoadDiscountTable();
				viewDis.setVisible(true);
			}
		});
		btn_viewDiscounts.setBorderPainted(false);
		btn_viewDiscounts.setBackground(Color.LIGHT_GRAY);
		btn_viewDiscounts.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 18));
		btn_viewDiscounts.setBounds(21, 165, 227, 65);
		panel_addDiscount_1.add(btn_viewDiscounts);
		
		//ViewDiscount button hover effect
		btn_viewDiscounts.addMouseListener(new java.awt.event.MouseAdapter() {
						    public void mouseEntered(java.awt.event.MouseEvent evt) {
						    	btn_viewDiscounts.setBackground(new Color(243, 243, 243  ));
						    }

						    public void mouseExited(java.awt.event.MouseEvent evt) {
						    	btn_viewDiscounts.setBackground(Color.LIGHT_GRAY);
						    }
						});
		
		JLabel img_viewDiscounts = new JLabel("");
		img_viewDiscounts.setBounds(54, 10, 152, 134);
		panel_addDiscount_1.add(img_viewDiscounts);
		img_viewDiscounts.setIcon(resize(new ImageIcon(this.getClass().getResource("/img_viewDiscounts.png")),addDiscountImg.getWidth(), addDiscountImg.getHeight()));

		
		JPanel panel_addDiscount_2 = new JPanel();
		panel_addDiscount_2.setLayout(null);
		panel_addDiscount_2.setBorder(new RoundedBorder(10));
		panel_addDiscount_2.setBackground(new Color(229, 229, 229));
		panel_addDiscount_2.setBounds(689, 185, 269, 240);
		contentPane.add(panel_addDiscount_2);
		
		JButton btn_removeDIscount = new JButton("Remove Discount");
		btn_removeDIscount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 dispose();
				 
				 removeDiscount rmDis = new removeDiscount();
				 
				 rmDis.setResizable(false);
				 rmDis.setLocationRelativeTo(null);
				 rmDis.LoadDiscountTable();
				 rmDis.setVisible(true);
				 
				
				
			}
		});
		btn_removeDIscount.setBorderPainted(false);
		btn_removeDIscount.setBackground(Color.LIGHT_GRAY);
		btn_removeDIscount.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 18));
		btn_removeDIscount.setBounds(21, 165, 227, 65);
		panel_addDiscount_2.add(btn_removeDIscount);
		
		
		//removeDIscount button hover effect
		btn_removeDIscount.addMouseListener(new java.awt.event.MouseAdapter() {
								    public void mouseEntered(java.awt.event.MouseEvent evt) {
								    	btn_removeDIscount.setBackground(new Color(243, 243, 243  ));
								    }

								    public void mouseExited(java.awt.event.MouseEvent evt) {
								    	btn_removeDIscount.setBackground(Color.LIGHT_GRAY);
								    }
								});
		
		JLabel img_removeDiscounts = new JLabel("");
		img_removeDiscounts.setBounds(53, 10, 140, 128);
		panel_addDiscount_2.add(img_removeDiscounts);
		img_removeDiscounts.setIcon(resize(new ImageIcon(this.getClass().getResource("/img_removeDiscounts.png")),addDiscountImg.getWidth(), addDiscountImg.getHeight()));
		
		JButton btn_DiscountReport = new JButton("Generate Report");
		btn_DiscountReport.setForeground(Color.WHITE);
		btn_DiscountReport.setBorderPainted(false);
		btn_DiscountReport.setFont(new Font("Yu Gothic UI", Font.BOLD, 19));
		btn_DiscountReport.setBounds(706, 563, 254, 61);
		contentPane.add(btn_DiscountReport);
		btn_DiscountReport.setBackground(new Color(27, 14, 93));
		
		//Report button hover effect
		btn_DiscountReport.addMouseListener(new java.awt.event.MouseAdapter() {
				    public void mouseEntered(java.awt.event.MouseEvent evt) {
				    	btn_DiscountReport.setBackground(new Color(113, 105, 157 ));
				    }

				    public void mouseExited(java.awt.event.MouseEvent evt) {
				    	btn_DiscountReport.setBackground(new Color(27, 14, 93));
				    }
				});

		
		
	
		 
		
	}
}
