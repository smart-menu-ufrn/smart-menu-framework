package br.edu.ufrn.smartmenu.items.services;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ufrn.smartmenu.items.models.Item;

public abstract class ItemService<
    T extends Item,
    R extends JpaRepository<T, Long>
> {

    @Autowired
    protected R repository;

    public abstract void createStock(T item);

    public abstract T updateEntity(T item, T updatedItem);

    public List<T> getAllItems() {
        List<T> allItems = this.repository.findAll();

        return allItems;
    }

    public T getItemById(
        Long id
    ) throws NoSuchElementException {
        T item = this.repository.findById(id).get();

        return item;
    }

    public T createItem(
        T item
    ) throws NoSuchElementException {
        
        item = this.repository.save(item);
        
        this.createStock(item);

        return item;
    }

    public T updateItem(
        Long id,
        T updatedItem
    ) throws NoSuchElementException {

        T item = this.repository.findById(id).get();

        item = this.updateEntity(item, updatedItem);

        this.repository.save(item);

        return item;
    }

    public void deleteItem(
        Long id
    ) throws NoSuchElementException {
        T item = this.repository.findById(id).get();

        this.repository.delete(item);
    }

}
