package customer_management;
import java.awt.EventQueue;
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

import com.mysql.jdbc.Connection;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

public class JavaCrud {

	private JFrame frame;
	private JTextField txtbname;
	private JTextField txtaddress;
	private JTextField txtnic;
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
	private JTextField txtphone;
	private JTextField txtstatus;

	public void Connect() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/javacurd", "root", "");
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

	}

	public void table_load() {
		try {
			pst = con.prepareStatement("select * from management");
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
		frame.setBounds(100, 100, 900, 610);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Reatail Store managment System");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(178, 21, 534, 56);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 26));
		frame.getContentPane().add(lblNewLabel);

		JButton btnNewButton = new JButton("Save");
		btnNewButton.setBackground(new Color(153,153,102));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBounds(489, 429, 85, 21);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String bname, address, nic,phone,status  ;
				bname = txtbname.getText();
				address = txtaddress.getText();
				nic = txtnic.getText();
				phone = txtphone.getText();
				status = txtstatus.getText();
				
				try {
					pst = con.prepareStatement("insert into management(name,address,nic,phone,status)values(?,?,?,?,?)");
					pst.setString(1, bname);
					pst.setString(2, address);
					pst.setString(3, nic);
					pst.setString(4, phone);
					pst.setString(5, status);
					
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Record Added");
					table_load();

					txtbname.setText("");
					txtaddress.setText("");
					txtnic.setText("");
					txtphone.setText("");
					txtstatus.setText("");
					txtbname.requestFocus();
				}

				catch (SQLException e1) {

					e1.printStackTrace();
				}
				
				
			}
		});
		frame.getContentPane().add(btnNewButton);

		JButton btnExit = new JButton("Exit");
		btnExit.setBackground(new Color(255, 0, 102));
		btnExit.setForeground(new Color(255, 255, 255));
		btnExit.setBounds(727, 508, 85, 21);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				System.exit(0);
			}
		});
		frame.getContentPane().add(btnExit);

		JButton btnClear = new JButton("Clear");
		btnClear.setForeground(new Color(255, 255, 255));
		btnClear.setBackground(new Color(153,153,102));
		btnClear.setBounds(329, 508, 85, 21);
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				txtbname.setText("");
				txtaddress.setText("");
				txtnic.setText("");
				txtphone.setText("");
				txtstatus.setText("");
				txtbname.requestFocus();
			}
		});
		frame.getContentPane().add(btnClear);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(204,204,153));
		panel_1.setBounds(43, 402, 378, 82);
		panel_1.setBorder(new TitledBorder(null, "Search", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_1_1_1 = new JLabel("Customer ID");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1_1.setBounds(10, 25, 121, 17);
		panel_1.add(lblNewLabel_1_1_1);

		txtbid = new JTextField();
		txtbid.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				
				 try {
			          
			            String id = txtbid.getText();

			                pst = con.prepareStatement("select name,address,nic,phone,status from management where id = ?");
			                pst.setString(1, id);
			                ResultSet rs = pst.executeQuery();

			            if(rs.next()==true)
			            {
			              
			                String name = rs.getString(1);
			                String address = rs.getString(2);
			                String nic = rs.getString(3);
			                String phone = rs.getString(4);
			                String status = rs.getString(5);
			                
			                
			               
			                txtbname.setText(name);
			                txtaddress.setText(address);
			                txtnic.setText(nic);
			                txtphone.setText(phone);
							txtstatus.setText(status);
			                
			            }   
			            else
			            {
			            	txtbname.setText("");
			            	txtaddress.setText("");
			                txtnic.setText("");
			                txtphone.setText("");
							txtstatus.setText("");
			                 
			            }
			            


			        } 
				
				 catch (SQLException ex) {
			           
			        }
				
				
		
			}
		});
		txtbid.setColumns(10);
		txtbid.setBounds(154, 26, 156, 19);
		panel_1.add(txtbid);

		JButton btnUp = new JButton("Update");
		btnUp.setBackground(new Color(153,153,102));
		btnUp.setForeground(new Color(255, 255, 255));
		btnUp.setBounds(604, 429, 85, 21);
		btnUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
					String bname,address,nic,phone,status,bid;
					
					
					bname = txtbname.getText();
					address = txtaddress.getText();
					nic = txtnic.getText();
					phone = txtphone.getText();
					status = txtstatus.getText();
					bid  = txtbid.getText();
					
					 try {
							pst = con.prepareStatement("update management set name= ?,address=?,nic=? ,phone=?, status=? where id =?");
							pst.setString(1, bname);
				            pst.setString(2, address);
				            pst.setString(3, nic);
				            pst.setString(4, phone);
				            pst.setString(5, status);
				            pst.setString(6, bid);
				            pst.executeUpdate();
				            JOptionPane.showMessageDialog(null, "Record Update!!!!!");
				            table_load();
				           
				            txtbname.setText("");
			            	txtaddress.setText("");
			                txtnic.setText("");
			                txtphone.setText("");
							txtstatus.setText("");
				            txtbname.requestFocus();
						}
	 
			            catch (SQLException e1) {
							
							e1.printStackTrace();
						}
		
				}
				
		
		});
		frame.getContentPane().add(btnUp);

		JButton btnDelete = new JButton("Delete");
		btnDelete.setBackground(new Color(153,153,102));
		btnDelete.setForeground(new Color(255, 255, 255));
		btnDelete.setBounds(699, 429, 85, 21);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
                String bid;
		bid  = txtbid.getText();
		
		 try {
				pst = con.prepareStatement("delete from management where id =?");
		
	            pst.setString(1, bid);
	            pst.executeUpdate();
	            JOptionPane.showMessageDialog(null, "Record Delete!!!!!");
	            table_load();
	           
	            txtbname.setText("");
            	txtaddress.setText("");
                txtnic.setText("");
                txtphone.setText("");
				txtstatus.setText("");
	            txtbname.requestFocus();
			}

          catch (SQLException e1) {
				
				e1.printStackTrace();
			}
				
			}
		});
		frame.getContentPane().add(btnDelete);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(25,25,112));
		panel_2.setBounds(0, 0, 1006, 87);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(JavaCrud.class.getResource("/customer_management/images/logo2.png")));
		lblNewLabel_2.setBounds(0, 0, 159, 87);
		panel_2.add(lblNewLabel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(204,204,204));
		panel_3.setBounds(0, 88, 884, 483);
		frame.getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(426, 5, 395, 402);
		panel_3.add(scrollPane);
		
		tableData = new JTable();
		scrollPane.setViewportView(tableData);
		tableData.setBackground(Color.WHITE);
		
				JPanel panel = new JPanel();
				panel.setBounds(50, 6, 378, 292);
				panel_3.add(panel);
				panel.setBorder(new TitledBorder(null, "Registration", TitledBorder.LEADING, TitledBorder.TOP, null, null));
						panel.setLayout(null);
				
						JLabel lblNewLabel_1 = new JLabel("Name");
						lblNewLabel_1.setBounds(20, 59, 90, 17);
						lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
						panel.add(lblNewLabel_1);
						
								JLabel lblNewLabel_1_1 = new JLabel("Address");
								lblNewLabel_1_1.setBounds(20, 97, 90, 17);
								lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
								panel.add(lblNewLabel_1_1);
								
										JLabel lblNewLabel_1_2 = new JLabel("NIC");
										lblNewLabel_1_2.setBounds(20, 144, 90, 17);
										lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
										panel.add(lblNewLabel_1_2);
										
												txtbname = new JTextField();
												txtbname.setBounds(158, 57, 156, 19);
												panel.add(txtbname);
												txtbname.setColumns(10);
												
														txtaddress = new JTextField();
														txtaddress.setBounds(158, 95, 156, 19);
														txtaddress.setColumns(10);
														panel.add(txtaddress);
														
																txtnic = new JTextField();
																txtnic.setBounds(158, 142, 156, 19);
																txtnic.setColumns(10);
																panel.add(txtnic);
																
																
																
																txtphone = new JTextField();
																txtphone.setBounds(158, 184, 156, 19);
																txtphone.setColumns(10);
																panel.add(txtphone);
																
																JLabel lblNewLabel_1_2_1 = new JLabel("Phone Number");
																lblNewLabel_1_2_1.setBounds(20, 186, 109, 17);
																lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
																panel.add(lblNewLabel_1_2_1);
																
																txtstatus = new JTextField();
																txtstatus.setBounds(158, 227, 156, 19);
																txtstatus.setColumns(10);
																panel.add(txtstatus);
																
																JLabel lblNewLabel_1_2_2 = new JLabel("Status");
																lblNewLabel_1_2_2.setBounds(20, 229, 90, 17);
																lblNewLabel_1_2_2.setFont(new Font("Tahoma", Font.BOLD, 14));
																panel.add(lblNewLabel_1_2_2);
	}
		
		
			
		
	public void show() {
		// TODO Auto-generated method stub
		
	}
}
