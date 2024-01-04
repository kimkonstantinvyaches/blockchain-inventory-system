package Blockchain;

import java.util.ArrayList;
import java.util.List;
import Models.Orders;

public class OrdersOperation extends BlockchainOperation{

    public OrdersOperation(BlockType blockType) {
        super(blockType);
    }

    public List<Orders> getOrders() {
        List<Orders> filteredOrders = new ArrayList<Orders>();
        removeDuplicateData();
        for (Block blockOrders : filteredBlockchain) {
            filteredOrders.add(new Orders(
                ( (Orders) blockOrders.getBlockchainData() ).getOrderId(),
                ( (Orders) blockOrders.getBlockchainData() ).getManagerId(),
                ( (Orders) blockOrders.getBlockchainData() ).getSupplierId(),
                ( (Orders) blockOrders.getBlockchainData() ).getOrdersList(),
                ( (Orders) blockOrders.getBlockchainData() ).getOrdersStatus()
                )
            );
        }
        return filteredOrders;
    }

    public Orders getSingleOrder(String orderId) {
        List<Orders> ordersList = getOrders();
        return (Orders) ordersList.stream().filter(order -> order.getOrderId().equals(orderId)).findAny().orElse(null);
    }
}
