package br.edu.ufrn.smartmenu.orders.models;

import java.util.ArrayList;
import java.util.List;

import br.edu.ufrn.smartmenu.items.models.Item;
import jakarta.persistence.CascadeType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.OneToMany;

@MappedSuperclass
public abstract class Order<T extends OrderedItem<? extends Item>> {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "order_id")
    private List<T> orderedItems = new ArrayList<>();

    public Order() {}

    public Order(List<T> orderedItems) {
        this.orderedItems = orderedItems;
    }

    public abstract Double getDiscount();

    public Long getId() {
        return id;
    }

    public List<T> getOrderedItems() {
        return orderedItems;
    }

    public void setOrderedItems(List<T> orderedItems) {
        this.orderedItems = orderedItems;
    }

    public void addOrderedItem(T item) {
        this.orderedItems.add(item);
    }

    public void removeOrderedItem(T item) {
        this.orderedItems.remove(item);
    }

    public Double getPrice() {
        Double price = this.orderedItems.stream()
            .mapToDouble(item -> item.getPrice())
            .sum();

        return price;
    }

    public Double getPriceWithDiscount() {
        Double price = this.orderedItems.stream()
            .mapToDouble(item -> item.getPriceWithDiscount())
            .sum();

        return price - this.getDiscount();
    }

}
