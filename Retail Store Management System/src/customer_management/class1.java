package customer_management;

import java.awt.EventQueue;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;



import javax.swing.JFrame;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JPanel;

import com.mysql.jdbc.Connection;

public class class1  {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void newScreen2() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					class1 window = new class1();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public class1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 734, 523);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 718, 110);
		panel.setBackground(new Color(25, 25, 112));
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Retail Store managment System");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(154, 44, 487, 37);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(0, 11, 144, 99);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setIcon(new ImageIcon(class1.class.getResource("/customer_management/images/logo2.png")));
		
		JLabel lblCustomerManager = new JLabel("Customer Management");
		lblCustomerManager.setForeground(Color.WHITE);
		lblCustomerManager.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblCustomerManager.setBounds(517, 73, 201, 37);
		panel.add(lblCustomerManager);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(56, 138, 601, 346);
		panel_1.setBackground(new Color(204 , 204, 204));
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(144, 11, 293, 172);
		panel_1.add(lblNewLabel_2);
		lblNewLabel_2.setIcon(new ImageIcon(class1.class.getResource("/customer_management/images/customdetails.png")));
		
		JButton btnNewButton_1 = new JButton("Generate  Report");
		btnNewButton_1.addActionListener(new ActionListener() {
		private JasperPrint jprint;
				
				public void actionPerformed(ActionEvent e) {
					try {
						Class.forName("com.mysql.jdbc.Driver");
						Connection con = (Connection) DriverManager.getConnection("JDBC:mySQL://localhost:3306/javacurd", "root", "");
						String sql = "select * from management";
						
						JasperDesign jdesign = JRXmlLoader.load("C:\\Users\\HP-PC\\OneDrive\\Documents\\OOP -cording\\customer_management\\src\\customer_management\\Report.jrxml");
						
						JRDesignQuery updateQuery = new JRDesignQuery();
						updateQuery.setText(sql);
						
						jdesign.setQuery(updateQuery);
						
						JasperReport Jreport = JasperCompileManager.compileReport(jdesign);
						JasperPrint JasperPrint = JasperFillManager.fillReport(Jreport, null, con);
						
						JasperViewer.viewReport(JasperPrint, false);
						
					}catch(Exception e2) {
						JOptionPane.showMessageDialog(null, e2);
					}
				}
			});
			
			
		
	
		
			
			
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBackground(new Color(153, 153, 102));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_1.setBounds(415, 288, 159, 33);
		panel_1.add(btnNewButton_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("");
		lblNewLabel_2_1.setBounds(590, 91, 0, 0);
		panel_1.add(lblNewLabel_2_1);
		
		JButton btnNewButton = new JButton("Customer Management");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JavaCrud nw = new JavaCrud();
				frame.dispose();
				nw.NewScreen();
				
			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(new Color(153, 153, 102));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(171, 212, 232, 47);
		panel_1.add(btnNewButton);
	}

	private Icon resize(ImageIcon imageIcon, int width, int height) {
		
		return null;
	}

	 
		
	}



	

	

	
	
	 

	

