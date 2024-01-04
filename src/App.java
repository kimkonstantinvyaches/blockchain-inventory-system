import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import Controller.InventoryController;
import Controller.OrdersController;
import Controller.StocksController;
import Controller.UserController;
import Helper.IdGenerator;
import Models.Inventory;
import Models.OrderDetail;
import Models.Orders;
import Models.Orders.OrdersStatus;
import Models.Stocks;
import Models.Stocks.StockStatus;
import Models.User.UserRoles;

public class App {


    
    
    public static void main(String[] args) throws Exception {

        try(Stream<Path>paths=Files.walk(Paths.get("./"))){
            paths.filter(Files::isRegularFile)
            .forEach(System.out::println);
        }

        UserController userController = new UserController();
        // userController.getUserData("peach");
        // User user = new User("eli", "eli", "peach@gmail.com", "manager");
        userController.createNewUser("sricomputer", "sricomputer", "allit@gmail.com", UserRoles.SUPPLIER.toString());
        // userController.createNewUser("peach2", "peach", "eliwoo@gmail.com", UserRoles.STAFF.toString());
        // userController.deleteUser("peach");
        // userController.authUser(user);
        // userController.createNewUser(user);
        OrderDetail mouseOrder = new OrderDetail("111", "12", 100);
        OrderDetail mouseOrder2 = new OrderDetail("111", "12", 60);
        OrderDetail keyboardOrder = new OrderDetail("112", "13", 90);
        OrderDetail headsetOrder = new OrderDetail("113", "15", 80);

        List<OrderDetail> groupOrder = Arrays.asList(mouseOrder, keyboardOrder);
        // List<OrderDetail> groupOrder = new ArrayList<OrderDetail>();
        // groupOrder.add(mouseOrder);
        // groupOrder.add(keyboardOrder);
        List<OrderDetail> groupOrder1 = Arrays.asList(mouseOrder, headsetOrder, mouseOrder2);
        List<OrderDetail> groupOrder2 = Arrays.asList(keyboardOrder, mouseOrder2, headsetOrder);

        Orders order1 = new Orders("OD685a0555", "12", groupOrder, OrdersStatus.PENDING.toString());
        Orders order2 = new Orders("ODfa4ee6c9", "86", "14", groupOrder1, OrdersStatus.PENDING.toString());
        Orders order3 = new Orders("88", "14", groupOrder2, OrdersStatus.PENDING.toString());

        Inventory inventory1 = new Inventory("Mouse G102", "Shelf B2");
        Inventory inventory2 = new Inventory("Tecware Spectre", "Shelf C4");
        Inventory inventory3 = new Inventory("Razer Kraken", "Shelf K3");

        Stocks stockMouse1 = new Stocks("22", "44", StockStatus.AVAILABLE.toString());
        Stocks stockMouse2 = new Stocks(IdGenerator.generateUUID(), "12", StockStatus.AVAILABLE.toString());
        Stocks stockKeyboard1 = new Stocks(IdGenerator.generateUUID(), "13", StockStatus.DEFECTIVE.toString());

        // OrdersOperation bc1 = new OrdersOperation(BlockType.ORDER);
        // bc1.createBlock(order1);
        // bc1.createBlock(order2);
        // System.out.println("BC1: " + bc1.toString());
        // System.out.println("\nReading Orders Lists:\n" + bc1.getOrders().toString());

        // InventoryOperation bc2 = new InventoryOperation(BlockType.INVENTORY);
        // bc2.createBlock(inventory1);
        // bc2.createBlock(inventory3);
        // System.out.println("\nReading Inventory Lists:\n" + bc2.getInventory().toString());

        // StocksOperation bc3 = new StocksOperation(BlockType.STOCK);
        // bc3.createBlock(stockMouse2);
        // bc3.createBlock(stockMouse1);
        // System.out.println("\nReading Stocks Lists:\n" + bc3.getStocks().get(0).getStockId());
        try {
            InventoryController inventoryController = new InventoryController();
            // inventoryController.createInventory(inventory2.getInventoryName(), inventory2.getInventoryLocation());
            // inventoryController.createInventory(inventory1.getInventoryName(), "Shelf H8");
            // inventoryController.createInventory(inventory3.getInventoryName(), inventory3.getInventoryLocation());

            // System.out.println("Inventory List: " + inventoryController.getInventory());
            // inventoryController.printUUID();

            OrdersController ordersController = new OrdersController();
            // ordersController.createOrders(order1.getManagerId(), order1.getSupplierId(), order1.getOrdersList());
            // ordersController.createOrders(order2.getManagerId(), order2.getSupplierId(), order2.getOrdersList());
            // ordersController.deleteOrder(505 , order1.getManagerId(), order1.getSupplierId(), order1.getOrdersList());
            // System.out.println("First Order List: " + ordersController.getOrders().get(0).getOrdersList().toString());
            // ordersController.confirmOrders("ODea18b662", order2.getManagerId(), order2.getSupplierId(), order2.getOrdersList(), OrdersStatus.REJECTED);
            // ordersController.deleteOrder("ODea18b662" , order2.getManagerId(), order2.getSupplierId(), order2.getOrdersList());
            // System.out.println("Orders List: " + ordersController.getOrders());
            
            StocksController stocksController = new StocksController();
            // stocksController.createStocks(stockMouse1.getStockId(), stockMouse1.getInventoryId(), StockStatus.MISSING);
            // stocksController.updateStocks("22", stockMouse1.getInventoryId(), StockStatus.AVAILABLE);
            // stocksController.createUpdateStocks("1e98a29a", stockMouse1.getInventoryId(), StockStatus.DEFECTIVE);
            // stocksController.createUpdateStocks(stockMouse2.getStockId(), stockMouse2.getInventoryId(), StockStatus.NOT_AVAILABLE);
            // System.out.println("Stocks List: " + stocksController.getStocks());

        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
}
