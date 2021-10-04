package com.admin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.main.HomePage;

public class AdminHome extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminHome frame = new AdminHome();
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
	public AdminHome() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100,1007, 685);
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
		label_Title.setBounds(170, 10, 551, 78);
		panel_Header.add(label_Title);

		JLabel label_Main_logo = new JLabel("");
		label_Main_logo.setBounds(-15, -26, 199, 177);
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
		btn_home.setBounds(863, 111, 129, 40);
		panel_Header.add(btn_home);

		JButton btn_admin = new JButton("Admin Home");
		btn_admin.setForeground(new Color(255, 250, 205));
		btn_admin.setBorderPainted(false);
		btn_admin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btn_admin.setBounds(730, 111, 129, 40);
		btn_admin.setBackground(new Color(161, 158, 177));
		panel_Header.add(btn_admin);
		
		JLabel lblNewLabel = new JLabel("Admin Home");
		lblNewLabel.setForeground(new Color(240, 243, 244 ));
		lblNewLabel.setFont(new Font("Lucida Fax", Font.PLAIN, 32));
		lblNewLabel.setBounds(340, 81, 284, 60);
		panel_Header.add(lblNewLabel);
		
		
		
		JButton btn_userManager = new JButton("HR Manager Logins");
		btn_userManager.setBackground(new Color(240,240,240 ));
		btn_userManager.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				hrManager hr = new hrManager();
				hr.setLocationRelativeTo(null);
				hr.setResizable(false);
				hr.LoadLoginTable();
				hr.setVisible(true);
			}
		});
		btn_userManager.setFont(new Font("Segoe UI", Font.PLAIN, 23));
		btn_userManager.setBounds(30, 161, 399, 106);
		btn_userManager.setIcon(resize(new ImageIcon(this.getClass().getResource("/hrIcon.jpg")),100,100));
		contentPane.add(btn_userManager);
		btn_userManager.setBackground(Color.LIGHT_GRAY);
		
		btn_userManager.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	btn_userManager.setBackground(new Color(243, 243, 243  ));
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	btn_userManager.setBackground(Color.LIGHT_GRAY);
		    }
		});
		
		
		
		JButton btn_CustomerManager = new JButton("Customer Manager Logins");
		btn_CustomerManager.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				OrderManager cw = new OrderManager();
				cw.setLocationRelativeTo(null);
				cw.setResizable(false);
				cw.LoadLoginTable();
				cw.setVisible(true);
			}
		});
		btn_CustomerManager.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		btn_CustomerManager.setBounds(532, 161, 399, 106);
		btn_CustomerManager.setIcon(resize(new ImageIcon(this.getClass().getResource("/CustomerIcon.png")),120, 120));
		contentPane.add(btn_CustomerManager);
		btn_CustomerManager.setBackground(Color.LIGHT_GRAY);
		
		btn_CustomerManager.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	btn_CustomerManager.setBackground(new Color(243, 243, 243  ));
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	btn_CustomerManager.setBackground(Color.LIGHT_GRAY);
		    }
		});
		
		JButton btn_OrderManager = new JButton("Order Manager Logins");
		btn_OrderManager.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				OrderManager or = new OrderManager();
				or.setLocationRelativeTo(null);
				or.setResizable(false);
				or.LoadLoginTable();
				or.setVisible(true);
			}
		});
		btn_OrderManager.setFont(new Font("Segoe UI", Font.PLAIN, 23));
		btn_OrderManager.setBounds(30, 285, 399, 106);
		btn_OrderManager.setIcon(resize(new ImageIcon(this.getClass().getResource("/OrderIcon.jpg")),100,100));
		contentPane.add(btn_OrderManager);
		btn_OrderManager.setBackground(Color.LIGHT_GRAY);
		
		
		btn_OrderManager.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	btn_OrderManager.setBackground(new Color(243, 243, 243  ));
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	btn_OrderManager.setBackground(Color.LIGHT_GRAY);
		    }
		});
		
		JButton btn_SupplyManager = new JButton("Supply Manager Logins");
		btn_SupplyManager.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				SupplyManager sp = new SupplyManager();
				sp.setLocationRelativeTo(null);
				sp.setResizable(false);
				sp.LoadLoginTable();
				sp.setVisible(true);
			}
		});
		btn_SupplyManager.setFont(new Font("Segoe UI", Font.PLAIN, 23));
		btn_SupplyManager.setIcon(resize(new ImageIcon(this.getClass().getResource("/supplyMgrHomeIcon2.png")),100,100));
		btn_SupplyManager.setBounds(532, 285, 399, 106);
		contentPane.add(btn_SupplyManager);
		btn_SupplyManager.setBackground(Color.LIGHT_GRAY);
		
		btn_SupplyManager.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	btn_SupplyManager.setBackground(new Color(243, 243, 243  ));
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	btn_SupplyManager.setBackground(Color.LIGHT_GRAY);
		    }
		});
		
		JButton btn_expenseMgr = new JButton("Expense Managers Logins");
		btn_expenseMgr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ExpenseManager em = new ExpenseManager();
				em.setLocationRelativeTo(null);
				em.setResizable(false);
				em.LoadLoginTable();
				em.setVisible(true);
			}
		});
		btn_expenseMgr.setFont(new Font("Segoe UI", Font.PLAIN, 23));
		btn_expenseMgr.setIcon(resize(new ImageIcon(this.getClass().getResource("/expenseMgrIcon.png")),100,100));
		btn_expenseMgr.setBounds(30, 406, 399, 106);
		contentPane.add(btn_expenseMgr);
		btn_expenseMgr.setBackground(Color.LIGHT_GRAY);
		
		btn_expenseMgr.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	btn_expenseMgr.setBackground(new Color(243, 243, 243  ));
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	btn_expenseMgr.setBackground(Color.LIGHT_GRAY);
		    }
		});
		
		
		JButton btn_inventoryIcon = new JButton("Inventory Manager Logins");
		btn_inventoryIcon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				InventoryManager im = new InventoryManager();
				im.setLocationRelativeTo(null);
				im.setResizable(false);
				im.LoadLoginTable();
				im.setVisible(true);
			}
		});
		btn_inventoryIcon.setFont(new Font("Segoe UI", Font.PLAIN, 22));
		btn_inventoryIcon.setIcon(resize(new ImageIcon(this.getClass().getResource("/inventoryMgrIcon.png")),100,100));
		btn_inventoryIcon.setBounds(532, 406, 399, 106);
		contentPane.add(btn_inventoryIcon);
		btn_inventoryIcon.setBackground(Color.LIGHT_GRAY);
		
		btn_inventoryIcon.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	btn_inventoryIcon.setBackground(new Color(243, 243, 243  ));
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	btn_inventoryIcon.setBackground(Color.LIGHT_GRAY);
		    }
		});
		
		JButton btn_salesManager = new JButton("Sales Manager Logins");
		btn_salesManager.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				salesManager sm = new salesManager();
				sm.setLocationRelativeTo(null);
				sm.setResizable(false);
				sm.LoadLoginTable();
				sm.setVisible(true);
			}
		});
		
		btn_salesManager.setIcon(resize(new ImageIcon(this.getClass().getResource("/SalesMgrIcon.png")),100,100));
		btn_salesManager.setFont(new Font("Segoe UI", Font.PLAIN, 23));
		btn_salesManager.setBounds(30, 532, 399, 106);
		contentPane.add(btn_salesManager);
		btn_salesManager.setBackground(Color.LIGHT_GRAY);
		
		btn_salesManager.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	btn_salesManager.setBackground(new Color(243, 243, 243  ));
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	btn_salesManager.setBackground(Color.LIGHT_GRAY);
		    }
		});
		
		
		
		JButton btn_MarketingMgr = new JButton("Marketing Manager Logins");
		btn_MarketingMgr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				MarketingManager mm = new MarketingManager();
				mm.setLocationRelativeTo(null);
				mm.setResizable(false);
				mm.LoadLoginTable();
				mm.setVisible(true);
			}
		});
		btn_MarketingMgr.setFont(new Font("Segoe UI", Font.PLAIN, 21));
		btn_MarketingMgr.setIcon(resize(new ImageIcon(this.getClass().getResource("/MarketingMgrIcon.jpg")),100,100));
		btn_MarketingMgr.setBounds(532, 532, 399, 106);
		contentPane.add(btn_MarketingMgr);
		btn_MarketingMgr.setBackground(Color.LIGHT_GRAY);
		
		btn_MarketingMgr.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	btn_MarketingMgr.setBackground(new Color(243, 243, 243  ));
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	btn_MarketingMgr.setBackground(Color.LIGHT_GRAY);
		    }
		});
		
	}
}
