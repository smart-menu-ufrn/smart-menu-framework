package br.edu.ufrn.smartmenu.items.controllers;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import br.edu.ufrn.smartmenu.items.models.Item;
import br.edu.ufrn.smartmenu.items.services.ItemService;

public abstract class ItemController<
    T extends Item,
    S extends ItemService<T, ? extends JpaRepository<T, Long>>
> {
    
    @Autowired
    protected S service;

    @GetMapping
    public ResponseEntity<List<T>> getAllItems() {
        List<T> itemsList = this.service.getAllItems();

        return ResponseEntity.status(HttpStatus.OK).body(itemsList);
    }

    @PostMapping
    public ResponseEntity<T> createItem(
        @RequestBody T item
    ) {
        try {
            item = this.service.createItem(item);
            return ResponseEntity.status(HttpStatus.CREATED).body(item);
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<T> getItemById(
        @PathVariable Long id
    ) {
        try {
            T item = this.service.getItemById(id);

            return ResponseEntity.status(HttpStatus.OK).body(item);
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<T> updateItem(
        @PathVariable Long id,
        @RequestBody T item
    ) {
        try {
            item = this.service.updateItem(id, item);

            return ResponseEntity.status(HttpStatus.ACCEPTED).body(item);
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable Long id) {
        try {
            this.service.deleteItem(id);
            
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

}
