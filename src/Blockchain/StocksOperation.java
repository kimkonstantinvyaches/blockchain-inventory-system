package Blockchain;
import java.util.ArrayList;
import java.util.List;
import Models.Stocks;

public class StocksOperation extends BlockchainOperation {

    public StocksOperation(BlockType blockType) {
        super(blockType);
    }

    public List<Stocks> getStocks() {
        List<Stocks> filteredStocks = new ArrayList<Stocks>();
        removeDuplicateData();
        for (Block blockStocks : filteredBlockchain) {
            filteredStocks.add(new Stocks(
                ( (Stocks) blockStocks.getBlockchainData() ).getStockId(),
                ( (Stocks) blockStocks.getBlockchainData() ).getInventoryId(),
                ( (Stocks) blockStocks.getBlockchainData() ).getStockStatus()
                )
            );
        }
        return filteredStocks;
    }
}
