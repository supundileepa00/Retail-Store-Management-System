package test_4;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import com.toedter.calendar.JDayChooser;
import com.toedter.components.JLocaleChooser;

import net.proteanit.sql.DbUtils;

import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;

public class add_expenses extends JFrame {
	String paid;
	private JPanel contentPane;
	private JTextField txtcost;
	private JTextField txtcom;
	private static JTable table;
	private JTable table_1;
	private JTextField txts;
	private JRadioButton topay;
	private JRadioButton pay;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					add_expenses frame = new add_expenses();
					frame.setVisible(true);
					Loadtable();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	//new
	
	
	//load table data ;;starting
		public static void Loadtable() {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/expenses","root","");
			
					  //   String lkr = "LKR";
						PreparedStatement pst;
					     //display data table
					     pst = con.prepareStatement("SELECT * FROM `expensesf`");
					     ResultSet  rs = pst.executeQuery();
					     
					     table.setModel(DbUtils.resultSetToTableModel(rs));
					     
					    // pst.executeUpdate();
			//JOptionPane.showMessageDialog(null, "inserted complete!!");
			}catch(Exception e1) {System.out.print(e1);}
			
			
		}
		//end
	
	
	
	
	/**
	 * Create the frame.
	 */
	
	
	public add_expenses() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(100, 100, 712, 468);
		setBounds(100, 100, 1007, 685);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	//	public JavaCrud() {
			//initialize();
		//Connect();
			//table_load();
	//	}
		
		
		
		JPanel panel = new JPanel();
	//	panel.setBackground(new Color(255, 102, 51));
		panel.setBackground(new Color(25, 25, 112));
		panel.setBounds(0, 0, 1058, 151);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_6 = new JLabel("Retail Store Management System");
		lblNewLabel_6.setForeground(new Color(255, 255, 255));
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 32));
		lblNewLabel_6.setBounds(298, 31, 549, 67);
		panel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setIcon(new ImageIcon(add_expenses.class.getResource("/images/logo2.png")));
		lblNewLabel_7.setBounds(60, 11, 213, 129);
		panel.add(lblNewLabel_7);
		
		JButton btnNewButton_4_1 = new JButton("Home");
		btnNewButton_4_1.setForeground(new Color(255, 255, 255));
		btnNewButton_4_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_4_1.setBackground(new Color(0, 51, 102));
		btnNewButton_4_1.setBounds(901, 128, 89, 23);
		panel.add(btnNewButton_4_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Insert Details", TitledBorder.LEADING, TitledBorder.TOP, null, Color.WHITE));
		panel_1.setBackground(new Color(204, 204, 204));
		panel_1.setBounds(0, 150, 239, 569);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Date");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(22, 18, 89, 25);
		panel_1.add(lblNewLabel);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(22, 40, 190, 29);
		panel_1.add(dateChooser);
		
		JLabel lblNewLabel_1 = new JLabel("Type");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(22, 103, 89, 25);
		panel_1.add(lblNewLabel_1);
		
		JComboBox cmbtyp = new JComboBox();
		cmbtyp.addItem("Rental");
		cmbtyp.addItem("Transport");
		cmbtyp.addItem("salary");
		cmbtyp.addItem("items");
		//cmbtyp.addItem("");
		cmbtyp.setBounds(22, 131, 190, 29);
		panel_1.add(cmbtyp);
		
		JLabel lblNewLabel_2 = new JLabel("Cost");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2.setBounds(22, 187, 57, 20);
		panel_1.add(lblNewLabel_2);
		
		txtcost = new JTextField();
		txtcost.setBounds(22, 208, 190, 25);
		panel_1.add(txtcost);
		txtcost.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Comment");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_3.setBounds(22, 252, 129, 25);
		panel_1.add(lblNewLabel_3);
		
		txtcom = new JTextField();
		txtcom.setBounds(21, 277, 191, 58);
		panel_1.add(txtcom);
		txtcom.setColumns(10);
		
		topay = new JRadioButton("Have to pay");
		topay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(topay.isSelected())
				{
			pay.setSelected(false);
		}
			}
		});
		topay.setBackground(new Color(204, 204, 204));
		topay.setFont(new Font("Tahoma", Font.BOLD, 18));
		topay.setBounds(22, 361, 170, 23);
		panel_1.add(topay);
		
		pay = new JRadioButton("Paid");
		pay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(pay.isSelected())
				{
			topay.setSelected(false);
		}
			}
			
			
		});
		pay.setBackground(new Color(204, 204, 204));
		pay.setFont(new Font("Tahoma", Font.BOLD, 18));
		pay.setBounds(22, 391, 109, 23);
		panel_1.add(pay);
		
		JLabel lblcom = new JLabel("");
		lblcom.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblcom.setBounds(22, 333, 155, 14);
		panel_1.add(lblcom);
		
		JLabel lblcost = new JLabel("");
		lblcost.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblcost.setBounds(22, 233, 155, 14);
		panel_1.add(lblcost);
		
		//cost validation
		txtcost.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {

				char c = e.getKeyChar();
				if (Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE) {
					txtcost.setEditable(true);
					lblcost.setText("");

				} else {
					txtcost.setEditable(false);
					lblcost.setText("*Please input a Number");
				}
			}
		});
		//end
		
		JButton btnNewButton = new JButton("ADD");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				//strat
				// login form validetion
				if(txtcost.getText().trim().isEmpty() && txtcom.getText().trim().isEmpty()) {
					lblcom.setText("field is empty");
					lblcost.setText("field is empty");		
				}
				else if(txtcost.getText().trim().isEmpty()) {
					lblcost.setText("field is empty");
					lblcom.setText(" ");
				}
				else if(txtcom.getText().trim().isEmpty()) {
					lblcom.setText("field is empty");
					lblcost.setText(" ");
				}
				else
				//end
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/expenses","root","");
					Statement stmt = con.createStatement();
					//String sql = "select * from logindata where username='"+name.getText()+"' and password='"+pass.getText()+"'";
					//String sql = "insert into expensesf(cost,comment)values(0,?,?)";
					
					String sql = "insert into expensesf(date,type,cost,comment,paid)values(?,?,?,?,?)";
					
							PreparedStatement pst = con.prepareStatement(sql);
							
							String type;
							type = cmbtyp.getSelectedItem().toString();
							SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD");
							String date = sdf.format(dateChooser.getDate());
							pst.setString(1, date);
							pst.setString(2, type);
							pst.setString(3, txtcost.getText());
							pst.setString(4,txtcom.getText() );
						     if(pay.isSelected()) {
						    	 paid= "paid";
						     }
						     if(topay.isSelected()) {
						    	 paid = "not";
						     }
						     pst.setString(5, paid);
				//	ResultSet rs=stmt.executeQuery(sql);
							
				//	if(rs.next())
					//	JOptionPane.showMessageDialog(null, "Sucessfull");
				//	else
						//JOptionPane.showMessageDialog(null, "Login faill");
					//con.close();
						    // table_load();
						     
						     pst.executeUpdate();
						     
						     
						     //display data table
						     pst = con.prepareStatement("select * from expensesf");
						     ResultSet  rs = pst.executeQuery();
						     table.setModel(DbUtils.resultSetToTableModel(rs));
						     
						    // pst.executeUpdate();
				JOptionPane.showMessageDialog(null, "inserted complete!!");
				}catch(Exception e1) {System.out.print(e1);}
				
				
				
				
				
				
			}
		});
		btnNewButton.setBackground(new Color(153, 153, 102));
		btnNewButton.setIcon(null);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.setBounds(10, 435, 110, 29);
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("CLEAR");
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(new Color(153, 153, 102));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				cmbtyp.setSelectedIndex(0);
				txtcost.setText(" ");
				txtcom.setText(" ");
				pay.setSelected(false);
				topay.setSelected(false);
			
				
				
				
				
				
			}
		});
		btnNewButton_1.setIcon(null);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton_1.setBounds(123, 435, 110, 28);
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_6 = new JButton("Demo");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//dateChooser.setDate("2021-01-22");
				cmbtyp.setSelectedIndex(2);
				txtcost.setText("1200.00");
				txtcom.setText("colombo - anuradhapura");
			/*	 paid.equals("paid") 
			    	 pay.setSelected(true);
			    	 topay.setSelected(false); */
			//	paid.equals(pay.setSelected(true));
				pay.setSelected(true);
			
				
				
			}
		});
		btnNewButton_6.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_6.setBounds(150, 0, 89, 23);
		panel_1.add(btnNewButton_6);
		
		
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(204, 204, 204));
		panel_2.setBounds(239, 149, 752, 53);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("Recently Added");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_4.setBounds(242, 11, 339, 31);
		panel_2.add(lblNewLabel_4);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(239, 200, 752, 446);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 732, 238);
		panel_3.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_5 = new JLabel("Search Payment");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_5.setBounds(20, 260, 355, 32);
		panel_3.add(lblNewLabel_5);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 331, 732, 69);
		panel_3.add(scrollPane_1);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		
		txts = new JTextField();
		txts.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				//new
				
				
				
				
				
				//new end
				//new1
	/*			try {
					 	Class.forName("com.mysql.jdbc.Driver");
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/expenses","root","");
						Statement stmt = con.createStatement();
			            
			            
			               // pst = con.prepareStatement("select name,edition,price from book where id = ?");
			               // pst.setString(1, id);
			               // ResultSet rs = pst.executeQuery();
							PreparedStatement pst;    
						    String id = txts.getText();
			                pst = con.prepareStatement("select date,type,cost,comment,paid from expensesf where id = ?");
				            pst.setString(1, id);
				            ResultSet rs = pst.executeQuery();
			                
			                

			            if(rs.next()==true)
			            {
			              
			            	//pst.setString(1, date);
							//pst.setString(2, type);
							pst.setString(3, txtcost.getText());
							pst.setString(4,txtcom.getText() );
						     if(pay.isSelected()) {
						    	 paid= "paid";
						     }
						     if(topay.isSelected()) {
						    	 paid = "not";
						     }
						     pst.setString(5, paid); 
			            	
			            	
			            	
			            	//date,type,cost,comment,paid
			               // String date = rs.getString(1);
			                //String type = rs.getString(2);
			            //    String txtcost = rs.getString(3);
			             //   String txtcom = rs.getString(4);
			                //String paid = rs.getString(5);
			               
			              //  date.setText(date);
			             //   type.setText(type);
			                txtcost.setText(cost);
			                txtcom.setText(comment);
			                
			                
			                
			          }   
			           else
			            {
			            	//txtbname.setText("");
			            	//txtedition.setText("");
			                //txtprice.setText("");
			                 
			          }
			            


			        } 
				
				 catch (SQLException ex) {
			           
			       }
				
				
				*/
				
				
				//new end
				
				// new test 2
				
				 try {
		//			 	Class.forName("com.mysql.jdbc.Driver");
					 	//Class.forName("com.mysql.jdbc.Driver");
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/expenses","root","");
				//		Statement stmt = con.createStatement();
						String sql = ("select date,type,cost,comment,paid from expensesf where id = ?");
						PreparedStatement pst = con.prepareStatement(sql);
						pst.setString(1, txts.getText());
						ResultSet rs = pst.executeQuery();
						
						if(rs.next()) {
							//date
							dateChooser.setDate(rs.getDate("date"));
							
							//type
							//String cmbtyp = rs.getString("type");
						//	type.setText(cmbtyp);
		//					String type = rs.getString(2);
							//cmbtyp.setText(type);
							String type = rs.getString(2);
							cmbtyp.setSelectedItem(type);
							
						
							
							
							//cost
//							String txtcost = rs.getString("cost");
							//cost.setText(txtcost);
							String cost =rs.getString(3);
							txtcost.setText(cost);
				
							//comment
							//String txtcom = rs.getString("comment");
						//	comment.setText(txtcom);
							String comment = rs.getString(4);
							txtcom.setText(comment);
							
							
							//pay
				/*			String paid1 = rs.getString("paid");
							 if(pay.isSelected()) {
					    	 paid= "paid";
					     }
					     if(topay.isSelected()) {
					    	 paid = "not";
					     }
			*/
						String paid= rs.getString(5);
						// if(pay.isSelected()) {
				/*		if(paid == "paid") {
					    	 //paid= "paid";
					    	pay.setSelected(true);
					    	//topay.setSelected(false);
					    	 
					     }
					    // if(topay.isSelected()) {
						if(paid == "not") {
					    	// paid = "not";
					    	 topay.setSelected(true);
					    	 //pay.setSelected(false);
					     }
					     
				*/	     
					     if(paid.equals("paid")) {
					    	 pay.setSelected(true);
					    	 topay.setSelected(false);
					     }
					     else {
					    	 topay.setSelected(true);
					    	 pay.setSelected(false);
					     }
						
					     	
					     
					     
					     
						}
						
						else {
							
						}
						
						
			           
			        } 
				
				 catch (SQLException ex) {
			           
			        } 
				
				
				//new test 2 end
				
				
			}
		});
		txts.setBounds(10, 293, 112, 27);
		panel_3.add(txts);
		txts.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("SEARCH");
		btnNewButton_2.setBackground(new Color(153, 153, 102));
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// new
				
				
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/expenses","root","");
					Statement stmt = con.createStatement();
					
					
							PreparedStatement pst;// = con.prepareStatement(sql);
						
					
					String id = txts.getText();
					 
	                pst = con.prepareStatement("select date,type,cost,comment,paid from expensesf where id = ?");
	               pst.setString(1, id);
	                ResultSet rs = pst.executeQuery();

	            if(rs.next()==true)
	            {
	              
	               // String name = rs.getString(1);
	                //String edition = rs.getString(2);
	                //String price = rs.getString(3);
	                
	                //txtbname.setText(name);
	                //txtedition.setText(edition);
	                //txtprice.setText(price);
	                
	                ResultSet  rs1 = pst.executeQuery();
				    table_1.setModel(DbUtils.resultSetToTableModel(rs1));
	                
	                
	            }   
	            else
	            {
	            	//txtbname.setText("");
	            	//txtedition.setText("");
	                //txtprice.setText("");
	                 
	            }
					
					
					
				JOptionPane.showMessageDialog(null, "Search item add complete!!");
				}catch(Exception e1) {System.out.print(e1);}
							
				
			}
		});
		btnNewButton_2.setIcon(null);
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_2.setBounds(140, 295, 112, 23);
		panel_3.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Genarate Report / Analys");
		btnNewButton_3.setBackground(new Color(153, 153, 102));
		btnNewButton_3.setForeground(new Color(255, 255, 255));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//frame
				 expenses_chart field= new expenses_chart();
				 
	                field.setVisible(true);
	                field.Loadpaid();
	                field.Loadtopay();
					field.Loadrental();
					field.Loadtransport();
					field.Loadsal();
					field.Loaditme();
	                setVisible(false);
	                //show total
	            
	                //end show
	                
				
				/*login field= new add_expenses();
                field.setVisible(true);
                setVisible(false);*/
				
			}
		});
		btnNewButton_3.setIcon(null);
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton_3.setBounds(79, 403, 547, 32);
		panel_3.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Update");
		btnNewButton_4.setBackground(new Color(153, 153, 102));
		btnNewButton_4.setForeground(new Color(255, 255, 255));
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//for upadate data
				
				String bid;
				bid = txts.getText();
				
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/expenses","root","");
					Statement stmt = con.createStatement();
					//String sql = "select * from logindata where username='"+name.getText()+"' and password='"+pass.getText()+"'";
					//String sql = "insert into expensesf(cost,comment)values(0,?,?)";
				
					String sql = "update expensesf set date=?,type=?,cost=?,comment=?,paid=? where id=?";
					
							PreparedStatement pst = con.prepareStatement(sql);
							
							String type;
							type = cmbtyp.getSelectedItem().toString();
							SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-D");
							String date = sdf.format(dateChooser.getDate());
							pst.setString(1, date);
							pst.setString(2, type);
							pst.setString(3, txtcost.getText());
							pst.setString(4,txtcom.getText() );
						     if(pay.isSelected()) {
						    	 paid= "paid";
						     }
						     if(topay.isSelected()) {
						    	 paid = "not";
						     }
						     pst.setString(5, paid);
						     
						     pst.setString(6, bid);
						     
				//	ResultSet rs=stmt.executeQuery(sql);
							
				//	if(rs.next())
					//	JOptionPane.showMessageDialog(null, "Sucessfull");
				//	else
						//JOptionPane.showMessageDialog(null, "Login faill");
					//con.close();
						    // table_load();
						     
						     pst.executeUpdate();
						     
						     
						     //display data table
						     pst = con.prepareStatement("select * from expensesf");
					     ResultSet  rs = pst.executeQuery();
					     table.setModel(DbUtils.resultSetToTableModel(rs));					     
						    // pst.executeUpdate();
				JOptionPane.showMessageDialog(null, "Update complete!!");
			}catch(Exception e1) {System.out.print(e1);}
							
				//end update code
				
				
				
				
				
				
				
			}
		});
		btnNewButton_4.setBounds(525, 297, 89, 23);
		panel_3.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Delete");
		btnNewButton_5.setBackground(new Color(204, 51, 0));
		btnNewButton_5.setForeground(new Color(255, 255, 255));
		btnNewButton_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//delete
				
				String bid;
				bid = txts.getText();
				
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/expenses","root","");
					Statement stmt = con.createStatement();
					//String sql = "select * from logindata where username='"+name.getText()+"' and password='"+pass.getText()+"'";
					//String sql = "insert into expensesf(cost,comment)values(0,?,?)";
				
					String sql = "delete from expensesf where id=?";
					
							PreparedStatement pst = con.prepareStatement(sql);
							
						
						     
						     pst.setString(1, bid);
						     
				//	ResultSet rs=stmt.executeQuery(sql);
							
				//	if(rs.next())
					//	JOptionPane.showMessageDialog(null, "Sucessfull");
				//	else
						//JOptionPane.showMessageDialog(null, "Login faill");
					//con.close();
						    // table_load();
						     
						     pst.executeUpdate();
						     
						     
						     //display data table
						     pst = con.prepareStatement("select * from expensesf");
					     ResultSet  rs = pst.executeQuery();
					     table.setModel(DbUtils.resultSetToTableModel(rs));					     
						    // pst.executeUpdate();
				JOptionPane.showMessageDialog(null, "Delete  complete!!");
			}catch(Exception e1) {System.out.print(e1);}
							
				//end update code
				
				
				
				
				
				
				
				//end delete
				
			}
		});
		btnNewButton_5.setBounds(635, 297, 89, 23);
		panel_3.add(btnNewButton_5);
	}
}
