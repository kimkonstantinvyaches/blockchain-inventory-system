package Models;

import java.io.Serializable;
import java.util.List;

public class Orders extends Models implements Serializable {
    private String orderId;
    private String managerId;
    private String supplierId;
    private List<OrderDetail> ordersList;
    private String ordersStatus;
    public static enum OrdersStatus {PENDING, ACCEPTED, REJECTED, CANCELED}

    public Orders(String orderId, String managerId, String supplierId, List<OrderDetail> ordersList, String ordersStatus) {
        this.orderId = orderId;
        this.managerId = managerId;
        this.supplierId = supplierId;
        this.ordersList = ordersList;
        this.ordersStatus = ordersStatus;
    }

    public Orders(String managerId, String supplierId, List<OrderDetail> ordersList, String ordersStatus) {
        this.managerId = managerId;
        this.supplierId = supplierId;
        this.ordersList = ordersList;
        this.ordersStatus = ordersStatus;
    }

    public String getOrderId() {
        return this.orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getManagerId() {
        return this.managerId;
    }

    public void setManagerId(String managerId) {
        this.managerId = managerId;
    }

    public String getSupplierId() {
        return this.supplierId;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }

    public List<OrderDetail> getOrdersList() {
        return this.ordersList;
    }

    public void setOrdersList(List<OrderDetail> ordersList) {
        this.ordersList = ordersList;
    }

    public String getOrdersStatus() {
        return this.ordersStatus;
    }

    public void setOrdersStatus(String ordersStatus) {
        this.ordersStatus = ordersStatus;
    }

    @Override
    public String toString() {
        return "{" +
            " orderId='" + getOrderId() + "'" +
            ", managerId='" + getManagerId() + "'" +
            ", supplierId='" + getSupplierId() + "'" +
            ", orderList='" + getOrdersList() + "'" +
            ", ordersStatus='" + getOrdersStatus() + "'" +
            "}";
    }   
    
    @Override
    public String getModelId() {
        return this.orderId;
    }
}