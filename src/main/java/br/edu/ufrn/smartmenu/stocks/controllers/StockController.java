package br.edu.ufrn.smartmenu.stocks.controllers;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.edu.ufrn.smartmenu.items.models.Item;
import br.edu.ufrn.smartmenu.stocks.dtos.StockOperationDTO;
import br.edu.ufrn.smartmenu.stocks.exceptions.InsufficientItemsInStockException;
import br.edu.ufrn.smartmenu.stocks.models.Stock;
import br.edu.ufrn.smartmenu.stocks.services.StockService;

public abstract class StockController<
    T extends Stock<? extends Item>,
    S extends StockService<T, ? extends JpaRepository<T, Long>>
> {

    @Autowired
    private S service;

    @GetMapping
    public ResponseEntity<List<T>> getAllStocks() {
        List<T> stocksList = this.service.getAllStocks();

        return ResponseEntity.status(HttpStatus.OK).body(stocksList);
    }

    @GetMapping("/{itemId}")
    public ResponseEntity<T> getItemById(
        @PathVariable Long itemId
    ) {
        try {
            T stock = this.service.getStockByItemId(itemId);

            return ResponseEntity.status(HttpStatus.OK).body(stock);
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping("/{itemId}/increase")
    public ResponseEntity<Void> increase(
        @PathVariable Long itemId,
        @RequestBody StockOperationDTO dto
    ) {
        try {
            this.service.increase(itemId, dto.getValue());

            return ResponseEntity.status(HttpStatus.ACCEPTED).build();
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping("/{itemId}/decrease")
    public ResponseEntity<Void> decrease(
        @PathVariable Long itemId,
        @RequestBody StockOperationDTO dto
    ) {
        try {
            this.service.decrease(itemId, dto.getValue());

            return ResponseEntity.status(HttpStatus.ACCEPTED).build();
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (InsufficientItemsInStockException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }

}
