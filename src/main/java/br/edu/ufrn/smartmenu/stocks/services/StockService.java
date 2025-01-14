package br.edu.ufrn.smartmenu.stocks.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ufrn.smartmenu.items.models.Item;
import br.edu.ufrn.smartmenu.stocks.exceptions.InsufficientItemsInStockException;
import br.edu.ufrn.smartmenu.stocks.models.Stock;
import br.edu.ufrn.smartmenu.stocks.repositories.StockRepository;

public abstract class StockService<
    T extends Stock<? extends Item>,
    R extends JpaRepository<T, Long> & StockRepository<T>
> {
    
    @Autowired
    protected R repository;

    public List<T> getAllStocks() {
        List<T> allStocks = this.repository.findAll();

        return allStocks;
    }

    public T getStockByItemId(
        Long itemId
    ) {

        T stock = this.repository.findByItemId(itemId).get();

        return stock;
    }

    public void increase(Long itemId, Integer value) {
        T stock = this.getStockByItemId(itemId);

        stock.increase(value);

        this.repository.save(stock);
    }

    public void decrease(Long itemId, Integer value) throws InsufficientItemsInStockException {
        T stock = this.getStockByItemId(itemId);

        stock.decrease(value);

        this.repository.save(stock);
    }

}
