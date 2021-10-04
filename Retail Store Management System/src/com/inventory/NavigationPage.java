package com.inventory;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

//import com.sun.jdi.connect.spi.Connection;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

//import com.main.HomePage;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NavigationPage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NavigationPage frame = new NavigationPage();
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
	public NavigationPage() {
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
		
		JButton btn_viewListedItem = new JButton("View Listed Item");
		btn_viewListedItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				ViewListedItemPage viewList = new ViewListedItemPage();
				viewList.setVisible(true);
				viewList.setResizable(false); //not change app resolution
				viewList.setLocationRelativeTo(null); //open app in desktop defined location

			}
		});
		
		
		btn_viewListedItem.setForeground(new Color(255, 255, 255));
		btn_viewListedItem.setBackground(new Color (100, 95, 110));
		btn_viewListedItem.setBounds(123, 467, 148, 49);
		contentPane.add(btn_viewListedItem);
		
		JButton btn_addNewItem = new JButton("Add New Item");
		btn_addNewItem.setForeground(new Color(255, 255, 255));
		btn_addNewItem.setBackground(new Color (100, 95, 110));
		btn_addNewItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//function to open item adding page
				
				dispose();
				AddNewItemPage addItem = new AddNewItemPage();
				addItem.setVisible(true);
				addItem.setResizable(false);
				addItem.setLocationRelativeTo(null);
			}
		});
		
		
		btn_addNewItem.setBounds(410, 467, 148, 49);
		contentPane.add(btn_addNewItem);
		
		JButton btn_generaateReport = new JButton("Generate Report");
		btn_generaateReport.setForeground(new Color(255, 255, 255));
		btn_generaateReport.setBackground(new Color (100, 95, 110));
		btn_generaateReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				DateJasper report = new DateJasper();
				report.setVisible(true);
				report.setResizable(false);
				report.setLocationRelativeTo(null);
			}
		});
		btn_generaateReport.setBounds(689, 467, 148, 49);
		contentPane.add(btn_generaateReport);
		
		JLabel lbl_viewItem = new JLabel("");
		lbl_viewItem.setBounds(106, 263, 194, 174);
		contentPane.add(lbl_viewItem);
		lbl_viewItem.setIcon(resize(new ImageIcon(this.getClass().getResource("/inChecklist-icon.png")),lbl_viewItem.getWidth(), lbl_viewItem.getHeight()));
		
		JLabel lbl_addItem = new JLabel("");
		lbl_addItem.setBounds(379, 263, 194, 174);
		contentPane.add(lbl_addItem);
		lbl_addItem.setIcon(resize(new ImageIcon(this.getClass().getResource("/inCart-add-icon.png")),lbl_addItem.getWidth(), lbl_addItem.getHeight()));

		
		JLabel lbl_genReport = new JLabel("");
		lbl_genReport.setBounds(675, 263, 194, 174);
		contentPane.add(lbl_genReport);
		lbl_genReport.setIcon(resize(new ImageIcon(this.getClass().getResource("/inReport-generate.png")),lbl_genReport.getWidth(), lbl_genReport.getHeight()));
		
		
		
				//set hover for addItem button
				btn_addNewItem.addMouseListener(new java.awt.event.MouseAdapter() {
						public void mouseEntered(java.awt.event.MouseEvent evt) {
								btn_addNewItem.setBackground(new Color(0, 0, 0));
							}

							public void mouseExited(java.awt.event.MouseEvent evt) {
									btn_addNewItem.setBackground(new Color(100, 95, 110));
								}
					});
				//set hover for viewwList button
				btn_viewListedItem.addMouseListener(new java.awt.event.MouseAdapter() {
						public void mouseEntered(java.awt.event.MouseEvent evt) {
							btn_viewListedItem.setBackground(new Color(0, 0, 0));
							}

							public void mouseExited(java.awt.event.MouseEvent evt) {
									btn_viewListedItem.setBackground(new Color(100, 95, 110));
								}
					});
		
				//set hover for reportGenerator button
				btn_generaateReport.addMouseListener(new java.awt.event.MouseAdapter() {
						public void mouseEntered(java.awt.event.MouseEvent evt) {
								btn_generaateReport.setBackground(new Color(0, 0, 0));
							}

							public void mouseExited(java.awt.event.MouseEvent evt) {
									btn_generaateReport.setBackground(new Color(100, 95, 110));
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
