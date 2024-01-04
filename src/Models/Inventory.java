package Models;

import java.io.Serializable;

public class Inventory extends Models implements Serializable{
    private String inventoryId;
    private String inventoryName; //!Cannot have duplicate name, must be unique
    private String inventoryLocation;

    public Inventory(String inventoryId, String inventoryName, String inventoryLocation) {
        this.inventoryId = inventoryId;
        this.inventoryName = inventoryName;
        this.inventoryLocation = inventoryLocation;
    }

    public Inventory(String inventoryName, String inventoryLocation) {
        this.inventoryName = inventoryName;
        this.inventoryLocation = inventoryLocation;
    }

    public String getInventoryId() {
        return this.inventoryId;
    }

    public void setInventoryId(String inventoryId) {
        this.inventoryId = inventoryId;
    }

    public String getInventoryName() {
        return this.inventoryName;
    }

    public void setInventoryName(String inventoryName) {
        this.inventoryName = inventoryName;
    }

    public String getInventoryLocation() {
        return this.inventoryLocation;
    }

    public void setInventoryLocation(String inventoryLocation) {
        this.inventoryLocation = inventoryLocation;
    }

    @Override
    public String toString() {
        return "{" +
            " inventoryId='" + getInventoryId() + "'" +
            ", inventoryName='" + getInventoryName() + "'" +
            ", inventoryLocation='" + getInventoryLocation() + "'" +
            "}";
    }

    @Override
    public String getModelId() {
        return this.inventoryId;
    }
}
