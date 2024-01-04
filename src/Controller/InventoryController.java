package Controller;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.List;

import Blockchain.BlockchainOperation.BlockType;
import Helper.IdGenerator;
import Blockchain.InventoryOperation;
import Models.Inventory;

public class InventoryController {

    InventoryOperation inventoryOperation;
    Logger logger = Logger.getLogger(InventoryController.class.getName());

    public InventoryController() {
        inventoryOperation = new InventoryOperation(BlockType.INVENTORY);
    }

    public void createInventory(String inventoryName, String inventoryLocation) {
        try {
            if (inventoryOperation.chkDuplicateItem(inventoryName)) {
                logger.log(Level.INFO, "Adding new [inventory, "+ inventoryName  +"] to blockchain.");
                inventoryOperation.createBlock(new Inventory("IN" + IdGenerator.generateUUID(), inventoryName, inventoryLocation));
                System.out.println("Inventory added successfully!");
            } else {
                System.out.println("Duplicated Inventory Name Found");
            }

		} catch (Exception e) {
			e.printStackTrace();
		}
    }

    public List<Inventory> getInventory() {
        return inventoryOperation.getInventory();
    }

    public Inventory getSingleInventory(String inventoryId) {
    	return inventoryOperation.getInventory().stream().filter(inventory -> inventory.getInventoryId().equals(inventoryId)).findFirst().orElse(null);
    }
    
    public Inventory getSingleInventoryByName(String inventoryName) {
    	return inventoryOperation.getInventory().stream().filter(inventory -> inventory.getInventoryName().equals(inventoryName)).findFirst().orElse(null);
    }

    public boolean chkDuplicateInventory(String inventoryName) {
    	return inventoryOperation.chkDuplicateItem(inventoryName);
    }
}
