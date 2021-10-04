package supply;
import java.awt.EventQueue;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

public class JavaCrud {

	private JFrame frame;
	private JTextField txtpid;
	private JTextField txtpname;
	private JTextField txtshid;
	private JTextField txt;

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
	private JTextField txtquntity;
	private JTextField txtsname;

	public void Connect() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/retail_store_management_system_db", "root", "");
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

	}

	public void table_load() {
		try {
			pst = con.prepareStatement("select * from supply");
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

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Supply Manager", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 131, 419, 282);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Product ID");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(20, 159, 90, 17);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Product name");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(20, 200, 142, 17);
		panel.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("Shipping Id");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_2.setBounds(20, 115, 90, 17);
		panel.add(lblNewLabel_1_2);
		
		JLabel lbperror = new JLabel("");
		lbperror.setForeground(Color.RED);
		lbperror.setFont(new Font("Tahoma", Font.ITALIC, 10));
		lbperror.setBounds(105, 163, 138, 13);
		panel.add(lbperror);
		
		JLabel lbserror = new JLabel("");
		lbserror.setForeground(Color.RED);
		lbserror.setFont(new Font("Tahoma", Font.ITALIC, 10));
		lbserror.setBounds(128, 119, 115, 13);
		panel.add(lbserror);
		
		txtpid = new JTextField();
		txtpid.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {

			 char c = e.getKeyChar();
			if (Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE) {
			txtpid.setEditable(true);
			 } else {
			txtpid.setEditable(false);
			lbperror.setText("*Please input a Number");
			}
			}
			});
		txtpid.setBounds(253, 160, 156, 19);
		panel.add(txtpid);
		txtpid.setColumns(10);

		txtpname = new JTextField();
		txtpname.setColumns(10);
		txtpname.setBounds(253, 201, 156, 19);
		panel.add(txtpname);

		txtshid = new JTextField();
		txtshid.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {

			 char c = e.getKeyChar();
			if (Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE) {
			txtshid.setEditable(true);
			 } else {
			txtshid.setEditable(false);
			lbserror.setText("*Please input a Number");
			}
			}
			});
		txtshid.setColumns(10);
		txtshid.setBounds(253, 116, 156, 19);
		panel.add(txtshid);
		
		txtquntity = new JTextField();
		txtquntity.setColumns(10);
		txtquntity.setBounds(253, 239, 156, 19);
		panel.add(txtquntity);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Product quntity");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_2_1.setBounds(20, 238, 142, 17);
		panel.add(lblNewLabel_1_2_1);
		
		txtsname = new JTextField();
		txtsname.setColumns(10);
		txtsname.setBounds(253, 71, 156, 19);
		panel.add(txtsname);
		
		JLabel lblNewLabel_1_2_2 = new JLabel("Supplier_name");
		lblNewLabel_1_2_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_2_2.setBounds(20, 70, 142, 17);
		panel.add(lblNewLabel_1_2_2);
	
		JButton btnNewButton = new JButton("Save");
		btnNewButton.setBackground(new Color(153, 153, 102));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String sname, shid, pid,pname,quntity  ;
				sname = txtsname.getText();
				shid = txtshid.getText();
				pid = txtpid.getText();
				pname = txtpname.getText();
				quntity = txtquntity.getText();
				

				try {
					pst = con.prepareStatement("insert into supply(sname,shid,pid,pname,quntity)values(?,?,?,?,?)");
					pst.setString(1, sname);
					pst.setString(2, shid);
					pst.setString(3, pid);
					pst.setString(4, pname);
					pst.setString(5, quntity);
					
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Record Added");
					table_load();

					txtsname.setText("");
					txtshid.setText("");
					txtpid.setText("");
					txtpname.setText("");
					txtquntity.setText("");
					txtsname.requestFocus();
				}

				catch (SQLException e1) {

					e1.printStackTrace();
				}

			}
		});
		btnNewButton.setBounds(463, 423, 96, 36);
		frame.getContentPane().add(btnNewButton);

		JButton btnExit = new JButton("Exit");
		btnExit.setBackground(Color.RED);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				System.exit(0);
			}
		});
		btnExit.setBounds(753, 479, 123, 36);
		frame.getContentPane().add(btnExit);

		JButton btnClear = new JButton("Clear");
		btnClear.setBackground(new Color(153, 153, 102));
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				txtsname.setText("");
				txtshid.setText("");
				txtpid.setText("");
				txtpname.setText("");
				txtquntity.setText("");
				txtsname.requestFocus();
			}
		});
		btnClear.setBounds(330, 511, 85, 36);
		frame.getContentPane().add(btnClear);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Search", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 433, 419, 82);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JLabel lbsuerror = new JLabel("");
		lbsuerror.setForeground(Color.RED);
		lbsuerror.setFont(new Font("Tahoma", Font.ITALIC, 10));
		lbsuerror.setBounds(131, 30, 112, 13);
		panel_1.add(lbsuerror);
		
		
		txt = new JTextField();
		txt.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {

			 char c = e.getKeyChar();
			if (Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE) {
				txt.setEditable(true);
			lbsuerror.setText("");

			 } else {
				 txt.setEditable(false);
			lbsuerror.setText("*Please input a Number");
			}
			}
			
			public void keyReleased(KeyEvent e) {
				
				 try {
			          
			            String id = txt.getText();

			                pst = con.prepareStatement("select sname,shid,pid,pname,quntity from supply where id = ?");
			                pst.setString(1, id);
			                ResultSet rs = pst.executeQuery();

			            if(rs.next()==true)
			            {
			              
			                String sname = rs.getString(1);
			                String shid = rs.getString(2);
			                String pid = rs.getString(3);
			                String pname = rs.getString(4);
			                String quntity = rs.getString(5);
			                
			                //sname, shid, pid,pname,quntity
			                
			                txtsname.setText(sname);
			                txtshid.setText(shid);
			                txtpid.setText(pid);
			                txtpname.setText(pname);
			                txtquntity.setText(quntity);
							
			                
			            }   
			            else
			            {
			            	txtpid.setText("");
			            	txtpname.setText("");
			                txtshid.setText("");
			                txtquntity.setText("");
							txtsname.setText("");
			                 
			            }
			        } 
				
				 catch (SQLException ex) {
			           
			        }
				
				
		
			}
		});
		txt.setColumns(10);
		txt.setBounds(253, 30, 156, 19);
		panel_1.add(txt);
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("Supplier_Id");
		lblNewLabel_1_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_2_1_1.setBounds(32, 29, 109, 17);
		panel_1.add(lblNewLabel_1_2_1_1);
		
		JButton btnUp = new JButton("Update");
		btnUp.setBackground(new Color(153, 153, 102));
		btnUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
					String sname, shid, pid,pname,quntity,bid;
					
					
					sname = txtsname.getText();
					shid = txtshid.getText();
					pid = txtpid.getText();
					pname = txtpname.getText();
					quntity = txtquntity.getText();
					bid  = txt.getText();
					
					 try {
							pst = con.prepareStatement("update supply set sname= ?,shid=?,pid=? ,pname=?, quntity=? where id =?");
							pst.setString(1, sname);
				            pst.setString(2, shid);
				            pst.setString(3, pid);
				            pst.setString(4, pname);
				            pst.setString(5, quntity);
				            pst.setString(6, bid);
				            pst.executeUpdate();
				            JOptionPane.showMessageDialog(null, "Record Update!!!");
				            table_load();
				           
				            txtsname.setText("");
				            txtshid.setText("");
				            txtpid.setText("");
				            txtpname.setText("");
				            txtquntity.setText("");
				            txtsname.requestFocus();
						}
	 
			            catch (SQLException e1) {
							
							e1.printStackTrace();
						}
		
				}
				
		
		});
		btnUp.setBounds(601, 423, 85, 36);
		frame.getContentPane().add(btnUp);

		JButton btnDelete = new JButton("Delete");
		btnDelete.setBackground(new Color(153, 153, 102));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
                String bid;
		bid  = txt.getText();
		
		 try {
				pst = con.prepareStatement("delete from supply where id =?");
		
	            pst.setString(1, bid);
	            pst.executeUpdate();
	            JOptionPane.showMessageDialog(null, "Record Delete!!");
	            table_load();
	           
	            txtsname.setText("");
	            txtshid.setText("");
	            txtpid.setText("");
	            txtpname.setText("");
	            txtquntity.setText("");
	            txtpid.requestFocus();
			}

          catch (SQLException e1) {
				
				e1.printStackTrace();
			}
				
			}
		});
		btnDelete.setBounds(732, 423, 85, 36);
		frame.getContentPane().add(btnDelete);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(439, 207, 437, 190);
		frame.getContentPane().add(scrollPane);
		
		tableData = new JTable();
		scrollPane.setViewportView(tableData);
		tableData.setBackground(Color.WHITE);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 0, 102));
		panel_2.setBounds(10, 80, 866, -69);
		frame.getContentPane().add(panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(25,25,112));
		panel_3.setBounds(0, 0, 886, 99);
		frame.getContentPane().add(panel_3);
				panel_3.setLayout(null);
		
				JLabel lblNewLabel = new JLabel("Reatail Store managment System");
				lblNewLabel.setForeground(Color.WHITE);
				lblNewLabel.setBounds(157, 50, 404, 29);
				panel_3.add(lblNewLabel);
				lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
				
				JLabel lblNewLabel_2 = new JLabel("");
				lblNewLabel_2.setBounds(0, 10, 144, 89);
				panel_3.add(lblNewLabel_2);
				lblNewLabel_2.setIcon(new ImageIcon(JavaCrud.class.getResource("/images/logo2.png")));
				
				JLabel lblNewLabel_3 = new JLabel("");
				lblNewLabel_3.setBounds(590, 109, 96, 88);
				frame.getContentPane().add(lblNewLabel_3);
				lblNewLabel_3.setIcon(resize(new ImageIcon(this.getClass().getResource("/list.png")),lblNewLabel_3.getWidth(), lblNewLabel_3.getHeight()));
				
				JButton btngrep = new JButton("Generate Report");
				btngrep.setFont(new Font("Tahoma", Font.PLAIN, 14));
				btngrep.addActionListener(new ActionListener() {
					private JasperPrint jprtint;
					public void actionPerformed(ActionEvent e) {
						try {
							Class.forName("com.mysql.jdbc.Driver");
							con = DriverManager.getConnection("jdbc:mysql://localhost/retail_store_management_system_db", "root", "");
							String sql="select*from supply";
							
							JasperDesign jdesign=JRXmlLoader.load("C:\\Users\\DELL\\eclipse-workspace\\supply_management\\src\\supply\\Report.jrxml");
							
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
				btngrep.setBounds(488, 469, 198, 54);
				frame.getContentPane().add(btngrep);

				
				
				
	}
}
