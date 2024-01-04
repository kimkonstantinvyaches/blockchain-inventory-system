package Controller;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import Blockchain.BlockchainOperation.BlockType;
import Blockchain.StocksOperation;
import Models.Stocks;
import Models.Stocks.StockStatus;

public class StocksController {

    public StocksOperation stocksOperation;
    Logger logger = Logger.getLogger(StocksOperation.class.getName());

    public StocksController() {
        stocksOperation = new StocksOperation(BlockType.STOCK);
    }

    //* Manually key in new StockId
    //* addEditStocks handles add and delete operation
    public void createStocks(String stockId, String inventoryId, String stockStatus) {
        try {
        	if (stocksOperation.chkDuplicateItem(stockId)) {
        		 logger.log(Level.INFO, "Adding new [stock, "+ stockId  +"] to blockchain.");
                stocksOperation.createBlock( new Stocks(stockId, inventoryId, stockStatus) );
            } else {
                System.out.println("ERROR: Duplicate Stock Id found");
            }
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

    public void updateStocks(String stockId, String inventoryId, String stockStatus) {
        try {
			stocksOperation.createBlock( new Stocks(stockId, inventoryId, stockStatus) );
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

    public int countInventoryStock(String inventoryId) {
       return (int) stocksOperation.getStocks().stream().filter(stock -> stock.getInventoryId().equals(inventoryId)).count();
    }

    public List<Stocks> getStocks() {
        return stocksOperation.getStocks();
    }
    
    public Stocks getSingleStock(String stockId) {
        return stocksOperation.getStocks().stream().filter(stock -> stock.getStockId().equals(stockId)).findFirst().orElse(null);
    }

    public List<Stocks> getGroupStocks(String inventoryId) {
    	return stocksOperation.getStocks().stream().filter(stock -> stock.getInventoryId().equals(inventoryId)).collect(Collectors.toList());
    }

    public boolean chkDuplicateStock(String stockId) {
    	return stocksOperation.chkDuplicateItem(stockId);
    }
}
