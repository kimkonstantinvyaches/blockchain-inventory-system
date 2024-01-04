/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ui;

import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import Controller.InventoryController;
import Controller.OrdersController;
import Controller.UserController;
import Models.Inventory;
import Models.OrderDetail;
import Models.Orders;
import Models.User;
import Models.Orders.OrdersStatus;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author slavi
 */
public class Suppliermainmenu extends javax.swing.JFrame {
	OrdersController ordersController;
	InventoryController inventoryController;
	UserController userController;
	String selectedOrderRow;
    /**
     * Creates new form MainMenu
     */
    public Suppliermainmenu() {
    	ordersController = new OrdersController();
		inventoryController = new InventoryController();
    	userController = new UserController();
        initComponents();
        fillOrdersTable();
        setLocationRelativeTo(null);
    }

    private void fillOrdersTable() {
    	List<Orders> ordersList = ordersController.getOrders();
    	DefaultTableModel model = (DefaultTableModel)tbl_Order.getModel();
    	String managerName, supplierName;
    	model.setRowCount(0);
    	for (Orders orders : ordersList) {
    		managerName = getUser(orders.getManagerId()).getUserName() ;
    		supplierName = getUser(orders.getSupplierId()).getUserName();
			model.addRow(new Object[] {orders.getOrderId(), managerName, supplierName, orders.getOrdersStatus() });
		}
    }

    private void fillOrderDetailTable(String orderId) {
    	List<OrderDetail> ordersList = ordersController.getOrders().stream()
    			.filter(order -> order.getOrderId().equals(orderId))
    			.map(Orders::getOrdersList)
    			.findFirst().orElse(null);
    	DefaultTableModel model = (DefaultTableModel)tbl_Orderdetail.getModel();
    	String inventoryName;
    	model.setRowCount(0);
    	for (OrderDetail orderDetail : ordersList) {
    		inventoryName = getInventory(orderDetail.getInventoryId()).getInventoryName();
			model.addRow(new Object[] {inventoryName, orderDetail.getOrderDetailQty()});
		}
    }

    private User getUser(String userId) {
    	User user = userController.getUserDataWithID(userId);
    	if (user == null) {
    		return new User();
    	} else {
    		return user;
    	}
    }

    private Inventory getInventory(String inventoryId) {
    	Inventory inventory = inventoryController.getSingleInventory(inventoryId);
    	if (inventory == null ) {
    		return new Inventory("", "");
    	} else {
    		return inventory;
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_Order = new javax.swing.JTable();
        tbl_Order.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mousePressed(MouseEvent e) {
        		selectedOrderRow = tbl_Order.getValueAt(tbl_Order.getSelectedRow(), 0).toString();
        		fillOrderDetailTable(selectedOrderRow);
        	}
        });
        btn_ConfirmOrder = new javax.swing.JButton();
        btn_RejectOrder = new javax.swing.JButton();
        Btn_Logout = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_Orderdetail = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tbl_Order.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
            		"Order ID", "Manager Name", "Supplier Name", "Order Status"
            }
        ));
        jScrollPane1.setViewportView(tbl_Order);

        btn_ConfirmOrder.setText("Confirm Order");
        btn_ConfirmOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_ConfirmorderActionPerformed(evt);
            }
        });

        btn_RejectOrder.setText("Reject Order");
        btn_RejectOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_RejectorderActionPerformed(evt);
            }
        });

        Btn_Logout.setText("Logout");
        Btn_Logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_LogoutActionPerformed(evt);
            }
        });

        tbl_Orderdetail.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product", "Quantity"
            }
        ));
        jScrollPane2.setViewportView(tbl_Orderdetail);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_ConfirmOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_RejectOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Btn_Logout))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_ConfirmOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(btn_RejectOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(90, 90, 90)
                        .addComponent(Btn_Logout))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Btn_ConfirmorderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_ConfirmorderActionPerformed
   int response = JOptionPane.showConfirmDialog(this , "Are you sure you want to approve this order?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        
        if(response==JOptionPane.YES_OPTION){
        	Orders rejectOrder = getOrderData();
            ordersController.confirmOrders(rejectOrder.getOrderId(), rejectOrder.getManagerId(), rejectOrder.getSupplierId(), rejectOrder.getOrdersList(), OrdersStatus.ACCEPTED);
            fillOrdersTable();
        } else if (response == JOptionPane.NO_OPTION){
            //if no
        } else if (response == JOptionPane.CANCEL_OPTION){
            //if cancel
        }
        
        
    }//GEN-LAST:event_Btn_ConfirmorderActionPerformed

    private void Btn_LogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_LogoutActionPerformed
    dispose();
     Login Login = new Login();
       Login.setVisible(true);
    }//GEN-LAST:event_Btn_LogoutActionPerformed

    private void Btn_RejectorderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_RejectorderActionPerformed
        int response = JOptionPane.showConfirmDialog(this , "Are you sure you want to reject this order?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        
        if(response==JOptionPane.YES_OPTION){
        	Orders rejectOrder = getOrderData();
            ordersController.confirmOrders(rejectOrder.getOrderId(), rejectOrder.getManagerId(), rejectOrder.getSupplierId(), rejectOrder.getOrdersList(), OrdersStatus.REJECTED);
            fillOrdersTable();
        } else if (response == JOptionPane.NO_OPTION){
            //if no
        } else if (response == JOptionPane.CANCEL_OPTION){
            //if cancel
        }
    }//GEN-LAST:event_Btn_RejectorderActionPerformed

    private Orders getOrderData() {
    	return ordersController.getSingleOrder(selectedOrderRow);
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
            java.util.logging.Logger.getLogger(Mainmenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Mainmenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Mainmenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Mainmenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Suppliermainmenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_ConfirmOrder;
    private javax.swing.JButton Btn_Logout;
    private javax.swing.JButton btn_RejectOrder;
    private javax.swing.JTable tbl_Orderdetail;
    private javax.swing.JTable tbl_Order;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
