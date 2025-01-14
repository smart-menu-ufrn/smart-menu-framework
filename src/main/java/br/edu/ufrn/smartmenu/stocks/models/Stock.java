package br.edu.ufrn.smartmenu.stocks.models;

import br.edu.ufrn.smartmenu.items.models.Item;
import br.edu.ufrn.smartmenu.stocks.exceptions.InsufficientItemsInStockException;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.OneToOne;

@MappedSuperclass
public abstract class Stock<T extends Item> {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "item_id", nullable = false, unique = true)
    private T item;

    @Column(nullable = false)
    private Integer quantity = 0;

    public Stock() {}

    public Stock(T item) {
        this.item = item;
    }

    public abstract void validateDecrease(Integer value) throws InsufficientItemsInStockException;

    public Long getId() {
        return this.id;
    }

    public T getItem() {
        return this.item;
    }

    public void setItem(T item) {
        this.item = item;
    }

    public Integer getQuantity() {
        return this.quantity;
    }

    public void increase(Integer value) {
        this.quantity += value;
    }

    public void decrease(Integer value) throws InsufficientItemsInStockException {
        this.validateDecrease(value);

        this.quantity -= value;
    }

}
