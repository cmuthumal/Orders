/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.CustomerController;
import controller.ReportController;
import controller.ShopController;
import extra.Extra;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Customer;
import model.Report;
import model.Shop;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author CM <2222cm@gmail.com>
 */
public class Reports extends javax.swing.JFrame {

    private CustomerController customerController;
    private ArrayList<Customer> custList = null;
    private ArrayList<Report> reportsList = null;
    private String[] custArray;
    private DefaultTableModel reportTableModel;
    private SimpleDateFormat dateFormat;
    private Date from, to;
    private double totalCost = 0, totalSellingPrice = 0, netProfit = 0;

    private int customerID = 0;
    private String fromDate = "", toDate = "", searchKey = "";
    private boolean fromDateSet, toDateSet;

    /**
     * Creates new form Report
     */
    public Reports() {
        initComponents();
        setLocationRelativeTo(null);
        dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        reportTableModel = (DefaultTableModel) table.getModel();
        customerController = new CustomerController();
        setAllCustomersToCombo();

        toDateChooser.setDate(new Date());
        Calendar c = fromDateChooser.getCalendar().getInstance();
        c.add(Calendar.WEEK_OF_MONTH, -2);
        fromDateChooser.setDate(c.getTime());

        new Extra().setCalendar(fromDateChooser.getJCalendar());
        new Extra().setCalendar(toDateChooser.getJCalendar());
        setAllRecordsToTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        searchPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        fromDateChooser = new com.toedter.calendar.JDateChooser();
        toDateChooser = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        customerCombo = new javax.swing.JComboBox<>();
        searchKeyTextField = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        tablePanel = new javax.swing.JPanel();
        tableScrollPane = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        totalBillTextField = new javax.swing.JTextField();
        totalCostTextField = new javax.swing.JTextField();
        netProfitTextField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        numOfRecordsLabel = new javax.swing.JLabel();
        printButton = new javax.swing.JButton();
        profitedCheckBox = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Reports");
        setResizable(false);

        searchPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(200, 200, 200), 1, true));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("From");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("To");

        fromDateChooser.setDateFormatString("yyyy-MM-dd");
        fromDateChooser.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        toDateChooser.setDateFormatString("yyyy-MM-dd");
        toDateChooser.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Customer");

        customerCombo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        customerCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customerComboActionPerformed(evt);
            }
        });

        searchKeyTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchKeyTextFieldActionPerformed(evt);
            }
        });

        searchButton.setText("Search");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Model");

        javax.swing.GroupLayout searchPanelLayout = new javax.swing.GroupLayout(searchPanel);
        searchPanel.setLayout(searchPanelLayout);
        searchPanelLayout.setHorizontalGroup(
            searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(searchPanelLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fromDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(toDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(searchPanelLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(searchKeyTextField)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 302, Short.MAX_VALUE)
                .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(searchPanelLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(customerCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        searchPanelLayout.setVerticalGroup(
            searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(searchPanelLayout.createSequentialGroup()
                        .addGap(0, 1, Short.MAX_VALUE)
                        .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(customerCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(searchPanelLayout.createSequentialGroup()
                        .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(toDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(fromDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(searchKeyTextField))))
                .addGap(16, 16, 16))
        );

        tablePanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(200, 200, 200), 1, true));

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Added Date", "Customer", "Model", "Error", "Issued Date", "Warranty", "Cost", "Price", "Technician"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Double.class, java.lang.Double.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.getTableHeader().setReorderingAllowed(false);
        tableScrollPane.setViewportView(table);

        javax.swing.GroupLayout tablePanelLayout = new javax.swing.GroupLayout(tablePanel);
        tablePanel.setLayout(tablePanelLayout);
        tablePanelLayout.setHorizontalGroup(
            tablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tableScrollPane)
        );
        tablePanelLayout.setVerticalGroup(
            tablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tableScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(200, 200, 200), 1, true));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Total Bill");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Total Cost");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Net Profit");

        totalBillTextField.setEditable(false);
        totalBillTextField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        totalBillTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalBillTextFieldActionPerformed(evt);
            }
        });

        totalCostTextField.setEditable(false);
        totalCostTextField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        totalCostTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalCostTextFieldActionPerformed(evt);
            }
        });

        netProfitTextField.setEditable(false);
        netProfitTextField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(netProfitTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                    .addComponent(totalBillTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                    .addComponent(totalCostTextField))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(totalBillTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(totalCostTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(netProfitTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Number of Records:");

        numOfRecordsLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        numOfRecordsLabel.setText("0");

        printButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        printButton.setText("Print");
        printButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printButtonActionPerformed(evt);
            }
        });

        profitedCheckBox.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        profitedCheckBox.setText("Show profited items only");
        profitedCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profitedCheckBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tablePanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(searchPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(numOfRecordsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(profitedCheckBox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(printButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(searchPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tablePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(numOfRecordsLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(printButton, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(profitedCheckBox))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void profitedCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profitedCheckBoxActionPerformed
        searchButtonActionPerformed(evt);
    }//GEN-LAST:event_profitedCheckBoxActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        setAllRecordsToTable();
    }//GEN-LAST:event_searchButtonActionPerformed

    private void searchKeyTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchKeyTextFieldActionPerformed
        searchButtonActionPerformed(evt);
    }//GEN-LAST:event_searchKeyTextFieldActionPerformed

    private void totalBillTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalBillTextFieldActionPerformed
        totalCostTextField.requestFocus();
    }//GEN-LAST:event_totalBillTextFieldActionPerformed

    private void totalCostTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalCostTextFieldActionPerformed
        //
    }//GEN-LAST:event_totalCostTextFieldActionPerformed

    private void printButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printButtonActionPerformed
        Shop shop = null;
        String customerName = "";

        try {
            shop = new ShopController().getShopDetails();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Reports.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Reports.class.getName()).log(Level.SEVERE, null, ex);
        }

        if ((customerID != 0) && (customerID != -1)) {
            try {
                customerName = new CustomerController().getCustomerName(customerID);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Reports.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(Reports.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        try {
            JRTableModelDataSource jrtmds = new JRTableModelDataSource(reportTableModel);

            Map dataSource = new HashMap();
            dataSource.put("details", jrtmds);
            String d = dateFormat.format(new Date());

            if (!customerName.equals("")) {
                Map param = new HashMap();
                param.put("name", shop.getShopName());
                param.put("address", shop.getShopAddress());
                param.put("contact", shop.getContact());
                param.put("fromDate", fromDate);
                param.put("toDate", toDate);
                param.put("reportDate", d);
                param.put("customer", customerName);
                param.put("totalBill", totalSellingPrice);

                JasperReport jr = JasperCompileManager.compileReport("./src/report/CustomerReport.jrxml");
                JasperPrint jp = JasperFillManager.fillReport(jr, param, jrtmds);
                JasperViewer.viewReport(jp, false);
            } else {
                Map param = new HashMap();
                param.put("name", shop.getShopName());
                param.put("address", shop.getShopAddress());
                param.put("contact", shop.getContact());
                param.put("fromDate", fromDate);
                param.put("toDate", toDate);
                param.put("reportDate", d);
                param.put("totalBill", totalSellingPrice);

                JasperReport jr = JasperCompileManager.compileReport("./src/report/Report.jrxml");
                JasperPrint jp = JasperFillManager.fillReport(jr, param, jrtmds);
                JasperViewer.viewReport(jp, false);
            }
        } catch (JRException ex) {
            JOptionPane.showMessageDialog(this, "Report generation failed.");
            Logger.getLogger(Reports.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_printButtonActionPerformed

    private void customerComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customerComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_customerComboActionPerformed

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
            java.util.logging.Logger.getLogger(Reports.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Reports.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Reports.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Reports.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Reports().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> customerCombo;
    private com.toedter.calendar.JDateChooser fromDateChooser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField netProfitTextField;
    private javax.swing.JLabel numOfRecordsLabel;
    private javax.swing.JButton printButton;
    private javax.swing.JCheckBox profitedCheckBox;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField searchKeyTextField;
    private javax.swing.JPanel searchPanel;
    private javax.swing.JTable table;
    private javax.swing.JPanel tablePanel;
    private javax.swing.JScrollPane tableScrollPane;
    private com.toedter.calendar.JDateChooser toDateChooser;
    private javax.swing.JTextField totalBillTextField;
    private javax.swing.JTextField totalCostTextField;
    // End of variables declaration//GEN-END:variables

    private void clearFields() {
        totalBillTextField.setText("");
        totalCostTextField.setText("");
        netProfitTextField.setText("");
    }

    private void setAllCustomersToCombo() {
        try {
            custList = customerController.getAllCustomers();
        } catch (SQLException ex) {
            Logger.getLogger(AddItem.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AddItem.class.getName()).log(Level.SEVERE, null, ex);
        }
        setCustomerCombo();
    }

    private void setCustomerCombo() {
        if (!custList.isEmpty()) {
            custArray = new String[custList.size() + 1];
            custArray[0] = "-Select customer to search-";
            for (int i = 0; i < custList.size(); i++) {
                Customer c = custList.get(i);
                custArray[i + 1] = c.getName();
            }
        } else {
            custArray = new String[1];
            custArray[0] = "-No matching results-";
        }
        customerCombo.setModel(new DefaultComboBoxModel(custArray));
    }

    private void setAllRecordsToTable() {
        clearFields();

        from = fromDateChooser.getDate();
        try {
            fromDate = dateFormat.format(from);
            fromDateSet = new Extra().validateDate(fromDate);
        } catch (NullPointerException e) {
            fromDateSet = false;
        }

        to = toDateChooser.getDate();
        try {
            toDate = dateFormat.format(to);
            toDateSet = new Extra().validateDate(toDate);
        } catch (NullPointerException e) {
            toDateSet = false;
        }

        if (!fromDateSet) {
            JOptionPane.showMessageDialog(rootPane, "Enter from date.", "Error", 1);
        } else if (!toDateSet) {
            JOptionPane.showMessageDialog(rootPane, "Enter to date.", "Error", 1);
        }

        int selectedIndex = customerCombo.getSelectedIndex();
        if (selectedIndex == 0) {
            customerID = -1;
        } else {
            customerID = custList.get(selectedIndex - 1).getID();
        }
        searchKey = searchKeyTextField.getText();

        try {
            reportsList = new ReportController().searchReport(fromDate, toDate, customerID, searchKey);
        } catch (SQLException ex) {
            Logger.getLogger(Reports.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Reports.class.getName()).log(Level.SEVERE, null, ex);
        }

        setTable();
    }

    private void setTable() {
        boolean profitedOnly = profitedCheckBox.isSelected();
        reportTableModel.setRowCount(0);
        totalCost = 0;
        totalSellingPrice = 0;
        netProfit = 0;

        if (!reportsList.isEmpty()) {
            for (int i = 0; i < reportsList.size(); i++) {
                Report r = reportsList.get(i);
                if (profitedOnly) {
                    if (r.getSellingPrice() != 0) {
                        totalCost += r.getCost();
                        totalSellingPrice += r.getSellingPrice();
                        Object[] row = {r.getAddedDate(), getCustomerByID(r.getCustomerID()), r.getModel(), r.getError(),
                            r.getIssuedDate(), r.getWarranty(), r.getCost(), r.getSellingPrice(), r.getTechnician()};
                        reportTableModel.addRow(row);
                    }
                } else {
                    totalCost += r.getCost();
                    totalSellingPrice += r.getSellingPrice();
                    Object[] row = {r.getAddedDate(), getCustomerByID(r.getCustomerID()), r.getModel(), r.getError(),
                        r.getIssuedDate(), r.getWarranty(), r.getCost(), r.getSellingPrice(), r.getTechnician()};
                    reportTableModel.addRow(row);
                }
            }
        }

        netProfit = totalSellingPrice - totalCost;
        numOfRecordsLabel.setText(reportTableModel.getRowCount() + "");
        totalCostTextField.setText(totalCost + "");
        totalBillTextField.setText(totalSellingPrice + "");
        netProfitTextField.setText(netProfit + "");
    }

    private String getCustomerByID(int id) {
        String name = "";
        try {
            name = new CustomerController().getCustomerName(id);
        } catch (SQLException ex) {
            Logger.getLogger(JobDoneScreen.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JobDoneScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return name;
    }
}
