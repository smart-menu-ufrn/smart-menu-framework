package br.edu.ufrn.smartmenu.orders.services;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ufrn.smartmenu.items.models.Item;
import br.edu.ufrn.smartmenu.orders.models.Order;
import br.edu.ufrn.smartmenu.orders.models.OrderedItem;
import br.edu.ufrn.smartmenu.stocks.exceptions.InsufficientItemsInStockException;
import br.edu.ufrn.smartmenu.stocks.models.Stock;
import br.edu.ufrn.smartmenu.stocks.services.StockService;

public abstract class OrderService<
    I extends Item,
    O extends OrderedItem<I>,
    T extends Order<O>,
    R extends JpaRepository<T, Long>,
    K extends Stock<I>,
    S extends StockService<K, ?>
> {

    @Autowired
    private R repository;

    @Autowired
    private S stockService;

    public List<T> getAllOrders() {
        List<T> allOrders = this.repository.findAll();

        return allOrders;
    }

    public T getOrderById(
        Long id
    ) throws NoSuchElementException {
        T order = this.repository.findById(id).get();

        return order;
    }

    public T createOrder(
        T order
    ) throws NoSuchElementException {
        
        List<O> orderedItemsToRemove = new ArrayList<O>();

        for (O orderedItem : order.getOrderedItems()) {
            K stock = this.stockService.getStockByItemId(orderedItem.getItem().getId());
            
            I item = stock.getItem();

            orderedItem.setItem(item);

            try {
                this.stockService.decrease(
                    item.getId(),
                    orderedItem.getQuantity()
                );
            } catch (InsufficientItemsInStockException err) {
                orderedItemsToRemove.add(orderedItem);
            }
        }

        for (O orderedItem : orderedItemsToRemove) {
            order.removeOrderedItem(orderedItem);
        };

        this.repository.save(order);

        return order;
    }


}
