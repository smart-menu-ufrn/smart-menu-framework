package br.edu.ufrn.bookstore.orders.models;

import br.edu.ufrn.bookstore.items.models.Book;
import br.edu.ufrn.smartmenu.orders.models.OrderedItem;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "book_ordered_items")
public class BookOrderedItem extends OrderedItem<Book> {

    @Override
    public Double getDiscount() {
        return Double.valueOf(0.0);
    }
    
}
