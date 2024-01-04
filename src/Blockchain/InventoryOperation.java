package Blockchain;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import Models.Inventory;

public class InventoryOperation extends BlockchainOperation{

    public InventoryOperation(BlockType blockType) {
        super(blockType);
    }

    public List<Inventory> getInventory() {
        List<Inventory> filteredInventory = new ArrayList<Inventory>();
        removeDuplicateData();
        for (Block blockInventory : filteredBlockchain) {
            filteredInventory.add(new Inventory(
                ( (Inventory) blockInventory.getBlockchainData()).getInventoryId(),
                ( (Inventory) blockInventory.getBlockchainData()).getInventoryName(),
                ( (Inventory) blockInventory.getBlockchainData()).getInventoryLocation()
                )
            );
        }
        return filteredInventory;
    }

    @Override
    public boolean chkDuplicateItem(String inventoryName) {
        LinkedList<Block> tempBlockchain = getBlockchain();
        List<Block> listBlockchain = tempBlockchain.stream().collect(Collectors.toList());
        for (Block block : listBlockchain) {
            if ( ((Inventory) block.getBlockchainData()).getInventoryName().equals(inventoryName) )
                return false;
        }
        return true;
    }
}
