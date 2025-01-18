package br.edu.ufrn.bookstore.orders.models;

import br.edu.ufrn.smartmenu.orders.models.Order;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "book_orders")
public class BookOrder extends Order<BookOrderedItem> {

    @Override
    public Double getDiscount() {
        Double discount;

        if (this.getPrice() > Double.valueOf(200.0)) {
            discount = this.getPrice() * Double.valueOf(0.05);
        } else {
            discount = Double.valueOf(0.0);
        }

        return discount;
    }
    
}
