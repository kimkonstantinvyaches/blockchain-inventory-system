
package Ui;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import Controller.InventoryController;
import Controller.OrdersController;
import Controller.StocksController;
import Controller.UserController;
import Models.Inventory;
import Models.OrderDetail;
import Models.Orders;
import Models.Stocks;
import Models.User;
import Models.Orders.OrdersStatus;
import Models.User.UserRoles;

import java.util.List;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author slavi
 */
public class Mainmenu extends javax.swing.JFrame {

    /**
     * Creates new form MainMenu
     */
	InventoryController inventoryController;
	StocksController stocksController;
	OrdersController ordersController;
	UserController userController;
	String selectedInventoryRow;
	String selectedOrdersRow;

    public Mainmenu() {
    	inventoryController = new InventoryController();
    	stocksController = new StocksController();
    	ordersController = new OrdersController();
    	userController = new UserController();
    	System.out.println(inventoryController.getInventory().toString());
        initComponents();
        sortComponents();
        setLocationRelativeTo(null);
        fillInventoryTable();
        fillUsersName();
//        fillOrdersTable();
        tbl_Inventory.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tbl_Stock.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        System.out.println("Welcome " + User.currentUser.getUserRole()  + " "  +  User.currentUser.getUserName());
    }

    private void fillUsersName() {
    	lbl_Welcome.setText("Welcome, " + User.currentUser.getUserName());
    }

    private void sortComponents() {
    	//Default configuration
    	Pnl_Inventory.setVisible(true);
    	Pnl_Order.setVisible(false);
    	btn_AddOrder.setVisible(false);
    	btn_CancelOrder.setVisible(false);

    	UserRoles currentRole = UserRoles.valueOf(User.currentUser.getUserRole());
    	switch (currentRole) {
		case MANAGER: {			
			break;
		}
		case STAFF: {
			Pnl_Inventory.setVisible(true);
			btn_AddInventory.setVisible(false);
			btn_AddStock.setVisible(true);
			btn_EditStock.setVisible(true);
			btn_AddOrder.setVisible(false);
			btn_CancelOrder.setVisible(false);
			btn_CreateUser.setVisible(false);
			btn_DeleteUser.setVisible(false);
			break;
		}
		case SUPPLIER: {
			Pnl_Inventory.setVisible(false);
			btn_ViewInventory.setVisible(false);
			btn_AddInventory.setVisible(false);
			btn_AddStock.setVisible(false);
			btn_EditStock.setVisible(false);
	    	Pnl_Order.setVisible(true);
	    	btn_AddOrder.setVisible(false);
			btn_CancelOrder.setVisible(false);
			btn_CreateUser.setVisible(false);
			btn_DeleteUser.setVisible(false);
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + currentRole.toString());
		}
    }
    
    private void sortInventoryComponents() {
    	Pnl_Inventory.setVisible(true);
    	btn_AddStock.setVisible(true);
		btn_EditStock.setVisible(true);
		Pnl_Order.setVisible(false);
		btn_AddOrder.setVisible(false);
		btn_CancelOrder.setVisible(false);
    	UserRoles currentRole = UserRoles.valueOf(User.currentUser.getUserRole());
    	switch (currentRole) {
		case MANAGER: {
			btn_AddInventory.setVisible(true);
			btn_CreateUser.setVisible(true);
			btn_DeleteUser.setVisible(true);
			break;
		}
		case STAFF: {
			btn_AddInventory.setVisible(false);
			btn_CreateUser.setVisible(false);
			btn_DeleteUser.setVisible(false);
			
			break;
		}
		case SUPPLIER: {
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + currentRole.toString());
		}
    }
    
    private void sortOrdersComponents() {
    	Pnl_Inventory.setVisible(false);
    	btn_AddInventory.setVisible(false);
    	btn_AddStock.setVisible(false);
    	btn_EditStock.setVisible(false);
    	Pnl_Order.setVisible(true);
    	btn_CreateUser.setVisible(false);
    	btn_DeleteUser.setVisible(false);
        
    	UserRoles currentRole = UserRoles.valueOf(User.currentUser.getUserRole());
    	switch (currentRole) {
		case MANAGER: {
			btn_AddOrder.setVisible(true);
			btn_CancelOrder.setVisible(true);
			break;
		}
		case STAFF: {
			btn_AddOrder.setVisible(false);
			btn_CancelOrder.setVisible(false);
			break;
		}
		case SUPPLIER: {
			btn_AddOrder.setVisible(false);
			btn_CancelOrder.setVisible(false);
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + currentRole.toString());
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

        jScrollPane3 = new javax.swing.JScrollPane();
        jRadioButtonMenuItem1 = new javax.swing.JRadioButtonMenuItem();
        btn_ViewInventory = new javax.swing.JButton();
        btn_ViewOrders = new javax.swing.JButton();
        btn_Logout = new javax.swing.JButton();
        btn_CancelOrder = new javax.swing.JButton();
        btn_AddInventory = new javax.swing.JButton();
        btn_DeleteUser = new javax.swing.JButton();
        btn_EditStock = new javax.swing.JButton();
        btn_CreateUser = new javax.swing.JButton();
        btn_AddOrder = new javax.swing.JButton();
        btn_AddStock = new javax.swing.JButton();
        Layer = new javax.swing.JLayeredPane();
        Pnl_Order = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tbl_Order = new javax.swing.JTable();
        tbl_Order.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mousePressed(MouseEvent e) {
        		selectedOrdersRow = tbl_Order.getValueAt(tbl_Order.getSelectedRow(), 0).toString();
        		fillOrderDetailTable(selectedOrdersRow);
        	}
        });
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_Orderdetail = new javax.swing.JTable();
        Pnl_Inventory = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbl_Inventory = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        tbl_Stock = new javax.swing.JTable();
        lbl_Welcome = new javax.swing.JLabel();

//        jTable1.setModel(new javax.swing.table.DefaultTableModel(
//            new Object [][] {
//                {null, null, null, null},
//                {null, null, null, null},
//                {null, null, null, null},
//                {null, null, null, null}
//            },
//            new String [] {
//                "Title 1", "Title 2", "Title 3", "Title 4"
//            }
//        ));
//        jScrollPane3.setViewportView(jTable1);

        jRadioButtonMenuItem1.setSelected(true);
        jRadioButtonMenuItem1.setText("jRadioButtonMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_ViewInventory.setText("View Inventory");
        btn_ViewInventory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ViewInventoryActionPerformed(evt);
            }
        });
        getContentPane().add(btn_ViewInventory, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 224, 39));

        btn_ViewOrders.setText("View Orders");
        btn_ViewOrders.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ViewOrdersActionPerformed(evt);
            }
        });
        getContentPane().add(btn_ViewOrders, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 224, 39));

        btn_Logout.setText("Logout");
        btn_Logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_LogoutActionPerformed(evt);
            }
        });
        getContentPane().add(btn_Logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, 90, 40));

        btn_CancelOrder.setText("Cancel Order");
        btn_CancelOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CancelOrderActionPerformed(evt);
            }
        });
        getContentPane().add(btn_CancelOrder, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 160, 114, 39));

        btn_AddInventory.setText("Add Inventory");
        btn_AddInventory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AddInventoryActionPerformed(evt);
            }
        });
        getContentPane().add(btn_AddInventory, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 110, 39));

        btn_DeleteUser.setText("Delete User");
        btn_DeleteUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_DeleteUserActionPerformed(evt);
            }
        });
        getContentPane().add(btn_DeleteUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 310, 110, 39));

        btn_EditStock.setText("Edit");
        btn_EditStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_EditStockActionPerformed(evt);
            }
        });
        getContentPane().add(btn_EditStock, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 210, 114, 39));

        btn_CreateUser.setText("Create User");
        btn_CreateUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CreateUserActionPerformed(evt);
            }
        });
        getContentPane().add(btn_CreateUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, 110, 39));

        btn_AddOrder.setText("Add Order");
        btn_AddOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AddOrderActionPerformed(evt);
            }
        });
        getContentPane().add(btn_AddOrder, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 114, 39));

        btn_AddStock.setText("Add Stock");
        btn_AddStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AddStockActionPerformed(evt);
            }
        });
        getContentPane().add(btn_AddStock, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 260, 110, 39));

        tbl_Order.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Order ID", "Manager Name", "Supplier Name", "Order Status"
            }
        ));
        tbl_Order.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                Tbl_OrderMousePressed(evt);
            }
        });
        jScrollPane6.setViewportView(tbl_Order);
        if (tbl_Order.getColumnModel().getColumnCount() > 0) {
            tbl_Order.getColumnModel().getColumn(1).setResizable(false);
        }

        tbl_Orderdetail.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product", "Quantity"
            }
        ));
        jScrollPane1.setViewportView(tbl_Orderdetail);

        javax.swing.GroupLayout Pnl_OrderLayout = new javax.swing.GroupLayout(Pnl_Order);
        Pnl_Order.setLayout(Pnl_OrderLayout);
        Pnl_OrderLayout.setHorizontalGroup(
            Pnl_OrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Pnl_OrderLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Pnl_OrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        Pnl_OrderLayout.setVerticalGroup(
            Pnl_OrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Pnl_OrderLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                .addContainerGap())
        );

        tbl_Inventory.setModel(new DefaultTableModel(
        	new Object[][] {
        	},
        	new String[] {
        		"Inventory ID", "Product Name", "Location", "Quantity"
        	}
        ));
        tbl_Inventory.setDefaultEditor(Object.class, null);
        tbl_Inventory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
            	selectedInventoryRow = tbl_Inventory.getValueAt(tbl_Inventory.getSelectedRow(), 0).toString();  
            	fillStocksTable(selectedInventoryRow);
            }
        });
        jScrollPane4.setViewportView(tbl_Inventory);

        tbl_Stock.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] {
                "Stock ID", "Inventory ID", "Stock Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tbl_Stock.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Tbl_StockMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                Tbl_StockMousePressed(evt);
            }
        });
        jScrollPane5.setViewportView(tbl_Stock);

        javax.swing.GroupLayout Pnl_InventoryLayout = new javax.swing.GroupLayout(Pnl_Inventory);
        Pnl_Inventory.setLayout(Pnl_InventoryLayout);
        Pnl_InventoryLayout.setHorizontalGroup(
            Pnl_InventoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Pnl_InventoryLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Pnl_InventoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE))
                .addContainerGap())
        );
        Pnl_InventoryLayout.setVerticalGroup(
            Pnl_InventoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Pnl_InventoryLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );

        Layer.setLayer(Pnl_Order, javax.swing.JLayeredPane.DEFAULT_LAYER);
        Layer.setLayer(Pnl_Inventory, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout LayerLayout = new javax.swing.GroupLayout(Layer);
        Layer.setLayout(LayerLayout);
        LayerLayout.setHorizontalGroup(
            LayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Pnl_Order, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(LayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(Pnl_Inventory, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        LayerLayout.setVerticalGroup(
            LayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LayerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Pnl_Order, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(LayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(LayerLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(Pnl_Inventory, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        getContentPane().add(Layer, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 0, 500, 430));

        lbl_Welcome.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_Welcome.setText("Welcome, ");
        getContentPane().add(lbl_Welcome, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 220, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_ViewInventoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ViewInventoryActionPerformed
        // TODO add your handling code here:
        sortInventoryComponents();
    	fillInventoryTable();
    }//GEN-LAST:event_btn_ViewInventoryActionPerformed

    private void btn_LogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_LogoutActionPerformed
     Login Login = new Login();
        setVisible(false);
       Login.setVisible(true);
    }//GEN-LAST:event_btn_LogoutActionPerformed

    private void btn_AddInventoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AddInventoryActionPerformed
        Addinventory Addinventory = new Addinventory();
      
       Addinventory.setVisible(true);
       setVisible(false);
    }//GEN-LAST:event_btn_AddInventoryActionPerformed

    private void fillInventoryTable()
    {
    	List<Inventory> inventoryList = inventoryController.getInventory();
    	DefaultTableModel model = (DefaultTableModel)tbl_Inventory.getModel();
    	model.setRowCount(0);
    	for (Inventory inventory : inventoryList) {
			model.addRow( new Object[] { inventory.getInventoryId(), 
				inventory.getInventoryName(), 
				inventory.getInventoryLocation(), 
				stocksController.countInventoryStock(inventory.getInventoryId())
			} );
		}
    }

    private void fillStocksTable(String inventoryId) {
    	List<Stocks> stocksList = stocksController.getGroupStocks(inventoryId);
    	DefaultTableModel model = (DefaultTableModel)tbl_Stock.getModel();
    	model.setRowCount(0);
    	for (Stocks stocks : stocksList) {
			model.addRow( new Object[] {stocks.getStockId(), stocks.getInventoryId(), stocks.getStockStatus()} );
		}
    	
    }
    
    private void btn_CancelOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CancelOrderActionPerformed
        if (selectedOrdersRow != "" && selectedOrdersRow != null) {
        	Orders searchOrder = ordersController.getSingleOrder(selectedOrdersRow);
        	String currentOrderStatus = searchOrder.getOrdersStatus();
        	System.out.println("Current Status: " + currentOrderStatus);
        	if (currentOrderStatus.equals(OrdersStatus.REJECTED.toString())|| currentOrderStatus.equals(OrdersStatus.ACCEPTED.toString())) {
        		JOptionPane.showMessageDialog(null , "Supplied has " + currentOrderStatus.toLowerCase() + " the order, canceling is not allowed", "Notice", 1);
        	} else {
        		ordersController.deleteOrder(searchOrder.getOrderId(), searchOrder.getManagerId(), searchOrder.getSupplierId(), searchOrder.getOrdersList());
        		fillOrdersTable();
        	}
        }
    }//GEN-LAST:event_btn_CancelOrderActionPerformed

    private void btn_DeleteUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_DeleteUserActionPerformed
         Deleteuser Deleteuser = new Deleteuser();
       Deleteuser.setVisible(true);
       setVisible(false);
    }//GEN-LAST:event_btn_DeleteUserActionPerformed

    private void btn_ViewOrdersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ViewOrdersActionPerformed
        fillOrdersTable();
    	sortOrdersComponents();
    }//GEN-LAST:event_btn_ViewOrdersActionPerformed

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

    private void btn_EditStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_EditStockActionPerformed
 EditStock EditStock = new EditStock();
       EditStock.setVisible(true);
       setVisible(false);
    }//GEN-LAST:event_btn_EditStockActionPerformed

    private void btn_CreateUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CreateUserActionPerformed
        Adduser Adduser = new Adduser();
       Adduser.setVisible(true);
       setVisible(false);
    }//GEN-LAST:event_btn_CreateUserActionPerformed

    private void btn_AddOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AddOrderActionPerformed
        Addorder Addorder = new Addorder();
       Addorder.setVisible(true);
       setVisible(false);
    }//GEN-LAST:event_btn_AddOrderActionPerformed

    private void btn_AddStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AddStockActionPerformed
       Addstock Addstock = new Addstock();
       Addstock.setVisible(true);
       setVisible(false);
    }//GEN-LAST:event_btn_AddStockActionPerformed

    private void Tbl_StockMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tbl_StockMouseClicked
          
    }//GEN-LAST:event_Tbl_StockMouseClicked

    private void Tbl_StockMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tbl_StockMousePressed
         if(tbl_Stock.getSelectionModel().isSelectionEmpty()){
        System.out.println("stock is empty");
    } else{
            tbl_Inventory.getSelectionModel().clearSelection();
        }
    }//GEN-LAST:event_Tbl_StockMousePressed

//    private void Tbl_InventoryMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tbl_InventoryMousePressed
//       if(tbl_Inventory.getSelectionModel().isSelectionEmpty()){
//        System.out.println("inventory is selected");
//    } else{
//            tbl_Stock.getSelectionModel().clearSelection();
//        }
//    }//GEN-LAST:event_Tbl_InventoryMousePressed

    private void Tbl_OrderMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tbl_OrderMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_Tbl_OrderMousePressed

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
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Mainmenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane Layer;
    private javax.swing.JPanel Pnl_Inventory;
    private javax.swing.JPanel Pnl_Order;
    private static javax.swing.JTable tbl_Inventory;
    private javax.swing.JTable tbl_Order;
    private javax.swing.JTable tbl_Orderdetail;
    private javax.swing.JTable tbl_Stock;
    private javax.swing.JButton btn_AddInventory;
    private javax.swing.JButton btn_AddOrder;
    private javax.swing.JButton btn_AddStock;
    private javax.swing.JButton btn_CancelOrder;
    private javax.swing.JButton btn_CreateUser;
    private javax.swing.JButton btn_DeleteUser;
    private javax.swing.JButton btn_EditStock;
    private javax.swing.JButton btn_Logout;
    private javax.swing.JButton btn_ViewInventory;
    private javax.swing.JButton btn_ViewOrders;
    private javax.swing.JLabel lbl_Welcome;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
