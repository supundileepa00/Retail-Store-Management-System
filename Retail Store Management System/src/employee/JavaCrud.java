package employee;

import java.awt.EventQueue;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
import java.sql.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

public class JavaCrud {

	private JFrame frame;
	private JTextField txtbname;
	private JTextField txtphone;
	private JTextField txtemail;
	private JTextField txtbid;

	/**
	 * Launch the application.
	 */
	public static void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JavaCrud window = new JavaCrud();
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
	public JavaCrud() {
		initialize();
		Connect();
		table_load();

	}

	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	private JTable table;
	private JTable tableData;
	private JTextField txtposition;
	private JTextField txtaddress;

	public void Connect() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/javacrud", "root", "");
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

	}

	public void table_load() {
		try {
			pst = con.prepareStatement("select * from employee");
			rs = pst.executeQuery();
			tableData.setModel(new DbUtils().resultSetToTableModel(rs));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void FillTable(String Query) {
		try {

			Statement stat = con.createStatement();
			ResultSet rs = stat.executeQuery(Query);
			Vector columnNames = new Vector();
			Vector data = new Vector();

			// To remove previously added rows
			while (tableData.getRowCount() > 0) {
				((DefaultTableModel) tableData.getModel()).removeRow(0);
			}
			ResultSetMetaData metaData = rs.getMetaData();
			int columns = metaData.getColumnCount();
			for (int i = 1; i <= columns; i++) {
				columnNames.addElement(metaData.getColumnName(i));
			}
			while (rs.next()) {
				Vector row = new Vector(columns);
				for (int i = 1; i <= columns; i++) {
					row.addElement(rs.getObject(i));
				}
				data.addElement(row);
			}
			DefaultTableModel test = (DefaultTableModel) tableData.getModel();
			tableData = new JTable(data, columnNames);
			tableData.setModel(test);
			TableColumn column;
			for (int i = 0; i < tableData.getColumnCount(); i++) {
				column = tableData.getColumnModel().getColumn(i);
				column.setMaxWidth(250);
			}

			rs.close();
			stat.close();
			// con.close();
		} catch (SQLException e) {
		}
	}

	class DbUtils {
		public TableModel resultSetToTableModel(ResultSet rs) {
			try {
				ResultSetMetaData metaData = rs.getMetaData();
				int numberOfColumns = metaData.getColumnCount();
				Vector<String> columnNames = new Vector<String>();

				// Get the column names
				for (int column = 0; column < numberOfColumns; column++) {
					columnNames.addElement(metaData.getColumnLabel(column + 1));
				}

				// Get all rows.
				Vector<Vector<Object>> rows = new Vector<Vector<Object>>();

				while (rs.next()) {
					Vector<Object> newRow = new Vector<Object>();

					for (int i = 1; i <= numberOfColumns; i++) {
						newRow.addElement(rs.getObject(i));
					}

					rows.addElement(newRow);
				}

				return new DefaultTableModel(rows, columnNames);
			} catch (Exception e) {
				e.printStackTrace();

				return null;
			}
		}

		public List<List<Object>> resultSetToNestedList(ResultSet rs, boolean includeColumnNames) {
			try {
				// To contain all rows.
				List<List<Object>> rows = new ArrayList<List<Object>>();
				ResultSetMetaData metaData = rs.getMetaData();
				int numberOfColumns = metaData.getColumnCount();

				// Include column headers as first row if required
				if (includeColumnNames) {
					List<Object> columnNames = new ArrayList<Object>();

					// Get the column names
					for (int column = 0; column < numberOfColumns; column++) {
						columnNames.add(metaData.getColumnLabel(column + 1));
					}
					rows.add(columnNames);
				}

				// Get the data
				while (rs.next()) {
					List<Object> newRow = new ArrayList<Object>();

					for (int i = 1; i <= numberOfColumns; i++) {
						newRow.add(rs.getObject(i));
					}

					rows.add(newRow);
				}
				return rows;
			} catch (Exception e) {
				e.printStackTrace();

				return null;
			}
		}

		public List<List<Object>> resultSetToNestedList(ResultSet rs) {
			try {
				// To contain all rows.
				List<List<Object>> rows = new ArrayList<List<Object>>();
				ResultSetMetaData metaData = rs.getMetaData();
				int numberOfColumns = metaData.getColumnCount();

				// Get the data
				while (rs.next()) {
					List<Object> newRow = new ArrayList<Object>();

					for (int i = 1; i <= numberOfColumns; i++) {
						newRow.add(rs.getObject(i));
					}

					rows.add(newRow);
				}
				return rows;
			} catch (Exception e) {
				e.printStackTrace();

				return null;
			}
		}

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1024, 719);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(248, 248, 255));
		panel.setBorder(new TitledBorder(null, "Registration", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(26, 204, 419, 311);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(45, 66, 90, 17);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Phone");
		lblNewLabel_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(45, 103, 90, 17);
		panel.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("Email");
		lblNewLabel_1_2.setForeground(Color.BLACK);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_2.setBounds(45, 142, 90, 17);
		panel.add(lblNewLabel_1_2);

		txtbname = new JTextField();
		txtbname.setBounds(158, 66, 156, 19);
		panel.add(txtbname);
		txtbname.setColumns(10);

		txtphone = new JTextField();
		txtphone.setColumns(10);
		txtphone.setBounds(158, 104, 156, 19);
		panel.add(txtphone);

		txtemail = new JTextField();
		txtemail.setColumns(10);
		txtemail.setBounds(158, 142, 156, 19);
		panel.add(txtemail);

		JLabel lblNewLabel_1_2_1 = new JLabel("Position");
		lblNewLabel_1_2_1.setForeground(Color.BLACK);
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_2_1.setBounds(45, 178, 90, 17);
		panel.add(lblNewLabel_1_2_1);

		txtposition = new JTextField();
		txtposition.setColumns(10);
		txtposition.setBounds(158, 178, 156, 19);
		panel.add(txtposition);

		JLabel lblNewLabel_1_2_2 = new JLabel("address");
		lblNewLabel_1_2_2.setForeground(Color.BLACK);
		lblNewLabel_1_2_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_2_2.setBounds(45, 215, 90, 17);
		panel.add(lblNewLabel_1_2_2);

		txtaddress = new JTextField();
		txtaddress.setColumns(10);
		txtaddress.setBounds(158, 215, 156, 19);
		panel.add(txtaddress);

		JButton btnClear = new JButton("Clear");
		btnClear.setBounds(310, 266, 85, 34);
		panel.add(btnClear);
		btnClear.setBackground(new Color(153, 153, 102));
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnClear.setForeground(new Color(255, 255, 255));
		
		JLabel lblmsg = new JLabel("");
		lblmsg.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblmsg.setForeground(Color.RED);
		lblmsg.setBounds(158, 160, 156, 14);
		panel.add(lblmsg);
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				txtbname.setText("");
				txtphone.setText("");
				txtemail.setText("");
				txtposition.setText("");
				txtaddress.setText("");
				txtbname.requestFocus();
			}
		});

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(485, 204, 494, 311);
		frame.getContentPane().add(scrollPane);

		tableData = new JTable();
		scrollPane.setViewportView(tableData);
		tableData.setBackground(Color.WHITE);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(25, 25, 112));
		panel_2.setBounds(0, 0, 1008, 118);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setForeground(new Color(148, 0, 211));
		lblNewLabel_2.setIcon(new ImageIcon(JavaCrud.class.getResource("/images/logo2.png")));
		lblNewLabel_2.setBounds(0, 0, 168, 118);
		panel_2.add(lblNewLabel_2);

		JLabel lblNewLabel = new JLabel("Retail Store Management System");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(178, 49, 436, 43);
		panel_2.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 26));

		JLabel lblEmployeeManagement = new JLabel("Employee Management");
		lblEmployeeManagement.setForeground(new Color(240, 248, 255));
		lblEmployeeManagement.setBackground(new Color(240, 248, 255));
		lblEmployeeManagement.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblEmployeeManagement.setBounds(692, 64, 316, 43);
		panel_2.add(lblEmployeeManagement);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(204, 204, 204));
		panel_3.setBounds(0, 118, 464, 562);
		frame.getContentPane().add(panel_3);
		panel_3.setLayout(null);

		JButton btnNewButton = new JButton("Save");
		btnNewButton.setBounds(41, 431, 85, 34);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(153, 153, 102));
		panel_3.add(btnNewButton);

		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(JavaCrud.class.getResource("/images/employee.png")));
		lblNewLabel_3.setBounds(29, 11, 74, 74);
		panel_3.add(lblNewLabel_3);

		JButton btnUp = new JButton("Update");
		btnUp.setBounds(200, 431, 85, 32);
		panel_3.add(btnUp);
		btnUp.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnUp.setBackground(new Color(153, 153, 102));
		btnUp.setForeground(new Color(255, 255, 255));

		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(334, 431, 85, 32);
		panel_3.add(btnDelete);
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnDelete.setBackground(new Color(153, 153, 102));
		btnDelete.setForeground(new Color(255, 255, 255));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String bid;
				bid = txtbid.getText();

				try {
					pst = con.prepareStatement("delete from employee where id =?");

					pst.setString(1, bid);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Record Delete!!");
					table_load();

					txtbname.setText("");
					txtphone.setText("");
					txtemail.setText("");
					txtposition.setText("");
					txtaddress.setText("");
					txtbname.requestFocus();
				}

				catch (SQLException e1) {

					e1.printStackTrace();
				}

			}
		});
		btnUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String bname, phone, email, position, address, bid;
				bname = txtbname.getText();
				phone = txtphone.getText();
				email = txtemail.getText();
				position = txtposition.getText();
				address = txtaddress.getText();
				bid = txtbid.getText();
				
				boolean status = validation.email_validation(txtemail.getText());
				if (status) {
					lblmsg.setText("");
			
					try {
						pst = con.prepareStatement(
								"update employee set name= ?,phone=?,email=?,position=?,address=? where id =?");
						pst.setString(1, bname);
						pst.setString(2, phone);
						pst.setString(3, email);
						pst.setString(4, position);
						pst.setString(5, address);
						pst.setString(6, bid);
						pst.executeUpdate();
						JOptionPane.showMessageDialog(null, "Record Update!!");
						table_load();

						txtbname.setText("");
						txtphone.setText("");
						txtemail.setText("");
						txtposition.setText("");
						txtaddress.setText("");
						txtbname.requestFocus();
					}

					catch (SQLException e1) {

						e1.printStackTrace();
					}

					
				}else {
					lblmsg.setText("Email is not Valid");
				}

			}

		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String bname, phone, email, position, address;
				bname = txtbname.getText();
				phone = txtphone.getText();
				email = txtemail.getText();
				position = txtposition.getText();
				address = txtaddress.getText();
				
				boolean status = validation.email_validation(txtemail.getText());
				if (status) {
					
					lblmsg.setText("");
					
					try {
						pst = con.prepareStatement(
								"insert into employee(name,phone,email,position,address)values(?,?,?,?,?)");
						pst.setString(1, bname);
						pst.setString(2, phone);
						pst.setString(3, email);
						pst.setString(4, position);
						pst.setString(5, address);
						pst.executeUpdate();
						JOptionPane.showMessageDialog(null, "Record Added!");
						table_load();

						txtbname.setText("");
						txtphone.setText("");
						txtemail.setText("");
						txtposition.setText("");
						txtaddress.setText("");
						txtbname.requestFocus();
					}

					catch (SQLException e1) {

						e1.printStackTrace();
					}
					
				}else {
					lblmsg.setText("Email is not Valid");
				}
				

				

			}
		});

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(204, 204, 204));
		panel_4.setBounds(465, 118, 553, 562);
		frame.getContentPane().add(panel_4);
		panel_4.setLayout(null);

		JLabel lblNewLabel_3_1_2_1 = new JLabel("");
		lblNewLabel_3_1_2_1.setBounds(56, 384, 39, 29);
		panel_4.add(lblNewLabel_3_1_2_1);

		JLabel lblNewLabel_3_1 = new JLabel("");
		lblNewLabel_3_1.setBounds(21, 0, 76, 84);
		lblNewLabel_3_1.setIcon(new ImageIcon(JavaCrud.class.getResource("/images/datagrid.png")));
		panel_4.add(lblNewLabel_3_1);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(107, 10, 408, 60);
		panel_4.add(panel_1);
		panel_1.setBackground(new Color(204, 204, 153));
		panel_1.setBorder(new TitledBorder(null, "Search", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setLayout(null);

		JLabel lblNewLabel_1_1_1 = new JLabel("Employee ID");
		lblNewLabel_1_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1_1.setBounds(64, 21, 90, 17);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_1.add(lblNewLabel_1_1_1);

		txtbid = new JTextField();
		txtbid.setBounds(203, 21, 195, 21);
		txtbid.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {

				try {

					String id = txtbid.getText();

					pst = con.prepareStatement("select name,phone,email,position,address from employee where id = ?");
					pst.setString(1, id);
					ResultSet rs = pst.executeQuery();

					if (rs.next() == true) {

						String name = rs.getString(1);
						String phone = rs.getString(2);
						String email = rs.getString(3);
						String position = rs.getString(4);
						String address = rs.getString(5);

						txtbname.setText(name);
						txtphone.setText(phone);
						txtemail.setText(email);
						txtposition.setText(position);
						txtaddress.setText(address);

					} else {
						txtbname.setText("");
						txtphone.setText("");
						txtemail.setText("");
						txtposition.setText("");
						txtaddress.setText("");
					}

				}

				catch (SQLException ex) {

				}

			}
		});
		txtbid.setColumns(10);
		panel_1.add(txtbid);

		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(JavaCrud.class.getResource("/images/iconsearch.png")));
		lblNewLabel_4.setBounds(164, 21, 29, 21);
		panel_1.add(lblNewLabel_4);

		JButton btnExit = new JButton("Exit");
		btnExit.setBounds(430, 427, 85, 34);
		panel_4.add(btnExit);
		btnExit.setBackground(new Color(204, 0, 51));
		btnExit.setForeground(new Color(255, 255, 255));
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JButton btnjrep = new JButton("Generate Report");
		btnjrep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JasperPrint jprtint;
			
					try {
						Class.forName("com.mysql.jdbc.Driver");
						con = DriverManager.getConnection("jdbc:mysql://localhost/javacrud", "root", "");
						String sql="select*from employee";
						
						JasperDesign jdesign=JRXmlLoader.load("E:\\ITP\\Employee_Management\\src\\Blank_A4.jrxml");
						
						JRDesignQuery updateQuery=new JRDesignQuery();
						updateQuery.setText(sql);
						
						jdesign.setQuery(updateQuery);
						
						JasperReport Jreport=JasperCompileManager.compileReport(jdesign);
						JasperPrint JasperPrint=JasperFillManager.fillReport(Jreport, null,con);
						
						JasperViewer.viewReport(JasperPrint,false);
					}catch(Exception e2) {
						JOptionPane.showMessageDialog(null, e2);
					}
				}
			});
		
		

		btnjrep.setBounds(190, 433, 163, 28);
		panel_4.add(btnjrep);
		

		}
	
			

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub

	}
}
