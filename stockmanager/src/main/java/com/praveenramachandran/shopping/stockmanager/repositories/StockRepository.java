package com.praveenramachandran.shopping.stockmanager.repositories;

import com.praveenramachandran.shopping.stockmanager.model.Stock;
import org.springframework.data.repository.CrudRepository;

public interface StockRepository extends CrudRepository<Stock, String> {
}
