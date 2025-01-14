package br.edu.ufrn.bookstore.stocks.models;

import br.edu.ufrn.bookstore.items.models.Book;
import br.edu.ufrn.smartmenu.stocks.exceptions.InsufficientItemsInStockException;
import br.edu.ufrn.smartmenu.stocks.models.Stock;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "book_stocks")
public class BookStock extends Stock<Book> {

    @Override
    public void validateDecrease(Integer value) throws InsufficientItemsInStockException {
        if (this.getQuantity() < value) {
            throw new InsufficientItemsInStockException();
        }
    }
    
}
