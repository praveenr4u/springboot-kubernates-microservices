package com.praveenramachandran.shopping.stockmanager.resources;

import com.praveenramachandran.shopping.stockmanager.exceptions.StockNotFoundException;
import com.praveenramachandran.shopping.stockmanager.model.Stock;
import com.praveenramachandran.shopping.stockmanager.services.StockService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stocks")
public class StockResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(StockResource.class);

    @Autowired
    private StockService stockService;

    @RequestMapping()
    public List<Stock> getStocks() {
        LOGGER.info("getStocks (All stocks)");
        return stockService.getStocks();
    }

    @RequestMapping("{productId}")
    public Stock getStock(@PathVariable("productId") String productId) throws StockNotFoundException {
        LOGGER.info("getStock with productId: {}", productId);
        return stockService.getStock(productId);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void handleStockNotFound(StockNotFoundException snfe) {
    }
}
