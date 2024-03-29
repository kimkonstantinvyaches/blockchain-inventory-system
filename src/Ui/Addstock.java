/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ui;

import Models.User;

import java.util.Arrays;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

import Controller.InventoryController;
import Controller.StocksController;
import Helper.Validation;
import Models.Inventory;
import Models.Stocks;
import Models.Stocks.StockStatus;

/**
 *
 * @author slavi
 */
public class Addstock extends javax.swing.JFrame {
	InventoryController inventoryController;
	StocksController stocksController;
	List<Inventory> inventoryList;
    /**
     * Creates new form AddUser
     */
    public Addstock() {
    	inventoryController = new InventoryController();
    	stocksController = new StocksController();
        initComponents();
        getInventoryList();
        setLocationRelativeTo(null);
    }
    
    private void getInventoryList() {
    	inventoryList = inventoryController.getInventory();
    	for (Inventory inventory : inventoryList) {
			cmb_Inventory.addItem(inventory.getInventoryName());
		}
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_Inventory = new javax.swing.JLabel();
        lbl_StockId = new javax.swing.JLabel();
        btn_Add = new javax.swing.JButton();
        btn_Cancel = new javax.swing.JButton();
        txt_StockId = new javax.swing.JTextField();
        cmb_Inventory = new javax.swing.JComboBox<>();
        lbl_StockStatus = new javax.swing.JLabel();
        cmb_StockStatus = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lbl_Inventory.setText("Product Name");

        lbl_StockId.setText("Stock ID");

        btn_Add.setText("Add");
        btn_Add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_AddActionPerformed(evt);
            }
        });

        btn_Cancel.setText("Cancel");
        btn_Cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_CancelActionPerformed(evt);
            }
        });

        cmb_Inventory.setModel(new javax.swing.DefaultComboBoxModel<>());

        lbl_StockStatus.setText("Status");

        cmb_StockStatus.setModel(new DefaultComboBoxModel(StockStatus.values()));
        cmb_StockStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cmb_StatusActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn_Cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addComponent(btn_Add, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lbl_StockId)
                            .addComponent(lbl_Inventory))
                        .addContainerGap(42, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmb_Inventory, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_StockId, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                            .addComponent(lbl_StockStatus)
                            .addComponent(cmb_StockStatus, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(lbl_Inventory)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmb_Inventory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_StockId)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_StockId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_StockStatus)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmb_StockStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_Cancel)
                    .addComponent(btn_Add))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Cmb_StatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cmb_StatusActionPerformed
        cmb_StockStatus.addItem("Available");
        cmb_StockStatus.addItem("Sold");
        cmb_StockStatus.addItem("Defective");
    }//GEN-LAST:event_Cmb_StatusActionPerformed

    private void Btn_CancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_CancelActionPerformed
    	Mainmenu Mainmenu = new Mainmenu();
        Mainmenu.setVisible(true);
        dispose();
    }//GEN-LAST:event_Btn_CancelActionPerformed

    private void Btn_AddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_AddActionPerformed
    	Stocks newStock = getStockData();

    	if ( Validation.emptyTextfield( Arrays.asList(newStock.getStockId()) ) ) {
    		if ( stocksController.chkDuplicateStock(newStock.getStockId()) ) {
    			stocksController.createStocks(newStock.getStockId(), newStock.getInventoryId(), newStock.getStockStatus());

    			Mainmenu Mainmenu = new Mainmenu();
    			Mainmenu.setVisible(true);
    			dispose();
    		} else {
    			JOptionPane.showMessageDialog(null, "Each Stock ID must be unique", "Duplicated Stock ID found", 1);
    		}	
    	} else {
    		JOptionPane.showMessageDialog(null, "All text fields cannot be empty", "Empty Fields Detected", 1);
    	}

    		
    	
    }//GEN-LAST:event_Btn_AddActionPerformed

	private Stocks getStockData() {
		String selectedInventory = cmb_Inventory.getSelectedItem().toString();
		String inventoryId = inventoryList.stream().filter( inventory -> inventory.getInventoryName().equals(selectedInventory) ).findFirst().orElse(null).getInventoryId();
		String stockId = txt_StockId.getText();
		String stockStatus = cmb_StockStatus.getSelectedItem().toString();
		return new Stocks(stockId, inventoryId, stockStatus);
	}
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
            java.util.logging.Logger.getLogger(Adduser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Adduser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Adduser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Adduser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Addstock().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Add;
    private javax.swing.JButton btn_Cancel;
    private javax.swing.JComboBox<String> cmb_Inventory;
    private javax.swing.JComboBox<String> cmb_StockStatus;
    private javax.swing.JLabel lbl_Inventory;
    private javax.swing.JLabel lbl_StockStatus;
    private javax.swing.JLabel lbl_StockId;
    private javax.swing.JTextField txt_StockId;
    // End of variables declaration//GEN-END:variables
}
