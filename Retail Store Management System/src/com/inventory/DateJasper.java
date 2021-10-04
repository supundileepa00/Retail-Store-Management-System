package com.inventory;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.toedter.calendar.JDateChooser;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.swing.JRViewer;
import net.sf.jasperreports.view.JasperViewer;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class DateJasper extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DateJasper frame = new DateJasper();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DateJasper() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1007, 685);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setAutoscrolls(true);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel DateFrom = new JLabel("Get Inventory Report From");
		DateFrom.setFont(new Font("Tahoma", Font.BOLD, 14));
		DateFrom.setBounds(93, 72, 206, 40);
		contentPane.add(DateFrom);
		
		JLabel DateTo = new JLabel("To");
		DateTo.setFont(new Font("Tahoma", Font.BOLD, 14));
		DateTo.setBounds(499, 75, 34, 37);
		contentPane.add(DateTo);
		
		JDateChooser txt_fDate = new JDateChooser();
		txt_fDate.setBounds(322, 79, 155, 25);
		contentPane.add(txt_fDate);
		
		JDateChooser txt_toDate = new JDateChooser();
		txt_toDate.setBounds(543, 79, 132, 25);
		contentPane.add(txt_toDate);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 123, 971, 432);
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JButton btn_Find = new JButton("Find");
		btn_Find.setForeground(new Color(255, 255, 255));
		btn_Find.setBackground(new Color (100, 95, 110));
		btn_Find.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				if (txt_fDate(getDate)==null || txt_toDate.equals(null)) {
//					
					
					try {
						
						SimpleDateFormat date_format1 = new SimpleDateFormat("yyyy-MM-dd");
						String fdate = date_format1.format(txt_fDate.getDate());
						
						SimpleDateFormat date_format2 = new SimpleDateFormat("yyyy-MM-dd");
						String todate = date_format2.format(txt_toDate.getDate());
						
						
							
							HashMap a = new HashMap();
							a.put("fromd",fdate);
							a.put("tod",todate);
							
							panel.removeAll();
							panel.repaint();
							panel.revalidate();
							
							
							
							
							dbConnect connect = new dbConnect();
							Connection con = connect.getConnection();
//							String sql = "select * from item";
			
							JasperDesign jdesign = JRXmlLoader.load("C:\\Users\\SANDEEPA\\git\\ITP2021_S2_B01_G06\\Retail Store Management System\\src\\com\\inventory\\InventoryReport.jrxml");
							
//							JRDesignQuery updateQuery = new JRDesignQuery();
//							updateQuery.setText(sql);
							
//							jdesign.setQuery(updateQuery);
							
							JasperReport jreport = JasperCompileManager.compileReport(jdesign);
							JasperPrint jasperPrint = JasperFillManager.fillReport(jreport, a, con);
							
							JRViewer v = new JRViewer(jasperPrint);
							panel.setLayout(new BorderLayout());
							panel.add(v);
							
//							JasperViewer.viewReport(jasperPrint, false);
							
						
						
						
						
					}catch(Exception ex) {
						ex.printStackTrace();
					}
					
			}
			
		});
		btn_Find.setBounds(698, 69, 112, 43);
		contentPane.add(btn_Find);
		
		JButton btn_back = new JButton("Back");
		btn_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				NavigationPage backNavPage = new NavigationPage();
				backNavPage.setVisible(true);
				backNavPage.setResizable(false);
				backNavPage.setLocationRelativeTo(null);
			}
		});
		btn_back.setForeground(Color.BLACK);
		btn_back.setBackground( new Color(124, 252, 252));
		btn_back.setBounds(822, 583, 112, 52);
		contentPane.add(btn_back);
		

		//set hover for Find button
		btn_Find.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseEntered(java.awt.event.MouseEvent evt) {
						btn_Find.setBackground(new Color(0, 0, 0));
					}

					public void mouseExited(java.awt.event.MouseEvent evt) {
							btn_Find.setBackground(new Color(100, 95, 110));
						}
			});
		
		//set hover for back button
		btn_back.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseEntered(java.awt.event.MouseEvent evt) {
						btn_back.setBackground(new Color(0, 255, 255));
					}

					public void mouseExited(java.awt.event.MouseEvent evt) {
							btn_back.setBackground(new Color(124, 252, 252));
						}
			});
	}
}
