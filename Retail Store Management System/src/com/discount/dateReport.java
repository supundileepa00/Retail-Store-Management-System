package com.discount;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;

import com.toedter.calendar.JDateChooser;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.swing.JRViewer;
import java.sql.*;

public class dateReport extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					dateReport frame = new dateReport();
					frame.setVisible(true);
					frame.setResizable(false);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public dateReport() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 1200, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("From");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(218, 20, 71, 29);
		contentPane.add(lblNewLabel);

		JLabel lblTo = new JLabel("To");
		lblTo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTo.setBounds(523, 20, 71, 29);
		contentPane.add(lblTo);

		JDateChooser txtfDate = new JDateChooser();
		txtfDate.setBounds(278, 20, 176, 29);
		contentPane.add(txtfDate);

		JDateChooser txtTodate = new JDateChooser();
		txtTodate.setBounds(571, 20, 176, 29);
		contentPane.add(txtTodate);

		JPanel panel = new JPanel();
		panel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(10, 99, 1166, 664);
		contentPane.add(panel);

		JButton btnGenerateReport = new JButton("Generate Report");
		btnGenerateReport.setForeground(Color.BLACK);
		btnGenerateReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				

					Connection con = new DBConnect().Connect();

					SimpleDateFormat dateOnly = new SimpleDateFormat("yyyy-MM-dd");
					String fromDate = dateOnly.format(txtfDate.getDate());

					SimpleDateFormat dateOnly2 = new SimpleDateFormat("yyyy-MM-dd");
					String toDate = dateOnly2.format(txtTodate.getDate());
					
					

					HashMap a = new HashMap();
					a.put("fromDate", fromDate);
					a.put("toDate", toDate);

					panel.removeAll();
					panel.repaint();
					panel.revalidate();

					System.out.println(a.get(fromDate));
					System.out.println(a.get(toDate));

					try {

						
						JasperDesign jdesign = JRXmlLoader.load(
								"C:\\Users\\Supun Dileepa\\eclipse-workspace2\\Retail Store\\src\\com\\discount\\discountReport.jrxml");
						JasperReport Jreport = JasperCompileManager.compileReport(jdesign);
						
						JasperPrint jprint = JasperFillManager.fillReport(Jreport, a, con);

						JRViewer v = new JRViewer(jprint);
						panel.setLayout(new BorderLayout());
						panel.add(v);
						

					} catch (JRException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				

			}
		});

		// addDiscount button hover effect
		btnGenerateReport.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				btnGenerateReport.setBackground(new Color(243, 243, 243));
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				btnGenerateReport.setBackground(Color.LIGHT_GRAY);
			}
		});
		btnGenerateReport.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnGenerateReport.setBounds(848, 20, 199, 44);
		btnGenerateReport.setBackground(Color.LIGHT_GRAY);
		contentPane.add(btnGenerateReport);

		JLabel lblNewLabel_1 = new JLabel("Select Date ");
		lblNewLabel_1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 19));
		lblNewLabel_1.setBounds(71, 13, 164, 39);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel(
				"*This report will containt all the discounts that within the given time limit.");
		lblNewLabel_2.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(40, 66, 637, 25);
		contentPane.add(lblNewLabel_2);
	}
}
