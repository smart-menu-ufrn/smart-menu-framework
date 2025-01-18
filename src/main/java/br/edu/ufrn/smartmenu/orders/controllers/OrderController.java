package br.edu.ufrn.smartmenu.orders.controllers;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.edu.ufrn.smartmenu.items.models.Item;
import br.edu.ufrn.smartmenu.orders.models.Order;
import br.edu.ufrn.smartmenu.orders.models.OrderedItem;
import br.edu.ufrn.smartmenu.orders.services.OrderService;

public abstract class OrderController<
    I extends Item,
    O extends OrderedItem<I>,
    T extends Order<O>,
    S extends OrderService<I, O, T, ?, ?, ?>
> {
    
    @Autowired
    private S service;

    @GetMapping
    public ResponseEntity<List<T>> getAllOrders() {
        List<T> ordersList = service.getAllOrders();

        return ResponseEntity.status(HttpStatus.OK).body(ordersList);
    }

    @PostMapping
    public ResponseEntity<T> createOrder(
        @RequestBody T order
    ) {
        try {
            order = service.createOrder(order);

            return ResponseEntity.status(HttpStatus.CREATED).body(order);
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<T> getOrderById(
        @PathVariable Long id
    ) {
        try {
            T order = service.getOrderById(id);

            return ResponseEntity.status(HttpStatus.OK).body(order);
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

}
