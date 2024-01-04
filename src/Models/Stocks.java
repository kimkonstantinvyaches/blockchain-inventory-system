package Models;

import java.io.Serializable;

public class Stocks extends Models implements Serializable{
    private String stockId;
    private String inventoryId;
    private String stockStatus;
    public static enum StockStatus {AVAILABLE, SOLD, DEFECTIVE, MISSING, NOT_AVAILABLE};
    public static enum StaffStockStatus {AVAILABLE, SOLD, DEFECTIVE, MISSING}; 

    public Stocks(String stockId, String inventoryId, String stockStatus) {
        this.stockId = stockId;
        this.inventoryId = inventoryId;
        this.stockStatus = stockStatus;
    }

    public String getStockId() {
        return this.stockId;
    }

    public void setStockId(String stockId) {
        this.stockId = stockId;
    }

    public String getInventoryId() {
        return this.inventoryId;
    }

    public void setInventoryId(String inventoryId) {
        this.inventoryId = inventoryId;
    }

    public String getStockStatus() {
        return this.stockStatus;
    }

    public void setStockStatus(String stockStatus) {
        this.stockStatus = stockStatus;
    }

    @Override
    public String toString() {
        return "{" +
            " stockId='" + getStockId() + "'" +
            ", inventoryId='" + getInventoryId() + "'" +
            ", stockStatus='" + getStockStatus() + "'" +
            "}";
    }

    @Override
    public String getModelId() {
        return this.stockId;
    }
}
