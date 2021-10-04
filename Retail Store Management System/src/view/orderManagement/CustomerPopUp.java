/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.orderManagement;

import bean.Customer;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import service.CustomerService;


public class CustomerPopUp extends javax.swing.JFrame {

    /**
     * Creates new form CustomerPopUp
     * 
     */
    private CustomerResponse customerResponse;
    private static CustomerResponse staticCustomerResponse;

    /**
     * Creates new form CustomerPopUp
     */
    public interface CustomerResponse{
        void getRespose(Customer responseCustomer);
    }
    public CustomerPopUp(CustomerResponse customerResponse) {
        staticCustomerResponse = customerResponse;
        this.customerResponse = customerResponse;
        initComponents();
        setDefaultsValues();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        clearButton = new javax.swing.JButton();
        selectCustomerButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        customerTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cusIDLabel = new javax.swing.JLabel();
        cusNameLabel = new javax.swing.JLabel();
        cusNICLabel = new javax.swing.JLabel();
        cancelButton = new javax.swing.JButton();
        searchTextField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        clearButton.setBackground(new java.awt.Color(102, 102, 102));
        clearButton.setForeground(new java.awt.Color(255, 255, 255));
        clearButton.setText("CLEAR");
        clearButton.setBorder(null);
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearFields(evt);
            }
        });

        selectCustomerButton.setBackground(new java.awt.Color(255, 204, 0));
        selectCustomerButton.setForeground(new java.awt.Color(51, 51, 51));
        selectCustomerButton.setText("SELECT CUSTOMER");
        selectCustomerButton.setBorder(null);
        selectCustomerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectCustomer(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Select Customer");

        customerTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Customer ID", "Customer Name", "NIC", "Phone Number"
            }
        ));
        customerTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                setSelectedCustomerToTextFields(evt);
            }
        });
        jScrollPane1.setViewportView(customerTable);

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Customer Name :");

        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Customer ID :");

        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Customer NIC :");

        cusIDLabel.setForeground(new java.awt.Color(102, 102, 102));

        cusNameLabel.setForeground(new java.awt.Color(102, 102, 102));

        cusNICLabel.setForeground(new java.awt.Color(102, 102, 102));

        cancelButton.setBackground(new java.awt.Color(255, 51, 0));
        cancelButton.setForeground(new java.awt.Color(255, 255, 255));
        cancelButton.setText("CANCEL");
        cancelButton.setBorder(null);
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        searchTextField.setText("Search");
        searchTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                SearchTable(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(selectCustomerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(clearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cusIDLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cusNICLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cusNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(searchTextField))
                .addContainerGap(7, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cusIDLabel)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cusNameLabel))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cusNICLabel))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(selectCustomerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(clearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void selectCustomer(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectCustomer
        // TODO add your handling code here:
        if(cusIDLabel.getText().isEmpty()){
            JOptionPane.showMessageDialog(rootPane,"Please Select a Customer");
        }else{
            selectCustomerAction(this.customerResponse);
            super.dispose();
        }
        
    }//GEN-LAST:event_selectCustomer

    private void clearFields(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearFields
        // TODO add your handling code here:
        clearFields();
    }//GEN-LAST:event_clearFields

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void setSelectedCustomerToTextFields(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_setSelectedCustomerToTextFields
        // TODO add your handling code here:
        DefaultTableModel tableModel = (DefaultTableModel)customerTable.getModel();
        int modelRow = customerTable.getSelectedRow();
        int selectedRow = customerTable.convertRowIndexToModel(modelRow);
        cusIDLabel.setText(tableModel.getValueAt(selectedRow, 0).toString());
        cusNameLabel.setText(tableModel.getValueAt(selectedRow, 1).toString());
        cusNICLabel.setText(tableModel.getValueAt(selectedRow, 2).toString());
    }//GEN-LAST:event_setSelectedCustomerToTextFields

    private void SearchTable(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SearchTable
        // TODO add your handling code here:
        searchFieldData(searchTextField.getText().toLowerCase());
    }//GEN-LAST:event_SearchTable

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CustomerPopUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CustomerPopUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CustomerPopUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CustomerPopUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CustomerPopUp(staticCustomerResponse).setVisible(true);
            }
        });
    }
    private void selectCustomerAction(CustomerResponse customerResponse ){
        Customer customer = new Customer();
        customer.setcID(cusIDLabel.getText());
        customer.setcName(cusNameLabel.getText());
        
        customerResponse.getRespose(customer);
        dispose();
    }
    private void loadTableData() {
        DefaultTableModel tableModel = (DefaultTableModel) customerTable.getModel();
        tableModel.setNumRows(0);
        CustomerService customerService = new CustomerService();
        for (Customer customer : customerService.loadCustomerList()) {
            String itemList[] = {String.valueOf(customer.getcID()), customer.getcName(), String.valueOf(customer.getcNIC()), customer.getcPhone()};
            tableModel.addRow(itemList);
        }
    }
    private void searchFieldData(String filter) {
        if (filter.length() !=0) {
            DefaultTableModel tableModel = (DefaultTableModel) customerTable.getModel();
            TableRowSorter<DefaultTableModel> tableRow = new TableRowSorter<DefaultTableModel>(tableModel);
            customerTable.setRowSorter(tableRow);
            tableRow.setRowFilter(RowFilter.regexFilter(String.valueOf(filter)));
        } else {
            DefaultTableModel tableModel = (DefaultTableModel) customerTable.getModel();
            TableRowSorter<DefaultTableModel> tableRow = new TableRowSorter<DefaultTableModel>(tableModel);
            customerTable.setRowSorter(tableRow);
            tableRow.setRowFilter(RowFilter.regexFilter("(?i)"+filter));
        }

    }
    private void clearFields(){
        cusIDLabel.setText("");
        cusNameLabel.setText("");
        cusNICLabel.setText("");
    }
     private void setDefaultsValues() {
        loadTableData();
        clearFields();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton clearButton;
    private javax.swing.JLabel cusIDLabel;
    private javax.swing.JLabel cusNICLabel;
    private javax.swing.JLabel cusNameLabel;
    private javax.swing.JTable customerTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField searchTextField;
    private javax.swing.JButton selectCustomerButton;
    // End of variables declaration//GEN-END:variables
}
