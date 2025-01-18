package br.edu.ufrn.smartmenu.orders.models;

import br.edu.ufrn.smartmenu.items.models.Item;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class OrderedItem<T extends Item> {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "item_id", nullable = false)
    private T item;

    @Column(nullable = false)
    private Integer quantity;

    public OrderedItem() {}

    public OrderedItem(T item, Integer quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    public OrderedItem(Integer quantity) {
        this.quantity = quantity;
    }

    public abstract Double getDiscount();

    public Long getId() {
        return id;
    }

    public T getItem() {
        return item;
    }
    
    public void setItem(T item) {
        this.item = item;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return item.getPrice() * quantity;
    }

    public Double getPriceWithDiscount() {
        Double price = item.getPriceWithDiscount() * quantity;
        
        return price - this.getDiscount();
    }

}
