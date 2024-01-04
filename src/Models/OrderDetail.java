package Models;

import java.io.Serializable;

public class OrderDetail implements Serializable {
    private String orderDetailId;
    private int orderDetailQty;
    private String inventoryId;

    public OrderDetail(String orderDetailId, String inventoryId, int orderDetailQty) {
        this.orderDetailId = orderDetailId;
        this.inventoryId = inventoryId;
        this.orderDetailQty = orderDetailQty;
    }

    public String getOrderDetailId() {
        return this.orderDetailId;
    }

    public void setOrderDetailId(String orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    public int getOrderDetailQty() {
        return this.orderDetailQty;
    }

    public void setOrderDetailQty(int orderDetailQty) {
        this.orderDetailQty = orderDetailQty;
    }

    public String getInventoryId() {
        return this.inventoryId;
    }

    public void setInventoryId(String inventoryId) {
        this.inventoryId = inventoryId;
    }

    @Override
    public String toString() {
        return "{" +
            " orderDetailId='" + getOrderDetailId() + "'" +
            ", orderDetailQty='" + getOrderDetailQty() + "'" +
            ", inventoryId='" + getInventoryId() + "'" +
            "}";
    }
}
