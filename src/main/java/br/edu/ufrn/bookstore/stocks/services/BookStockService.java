package br.edu.ufrn.bookstore.stocks.services;

import org.springframework.stereotype.Service;

import br.edu.ufrn.bookstore.items.models.Book;
import br.edu.ufrn.bookstore.stocks.models.BookStock;
import br.edu.ufrn.bookstore.stocks.repositories.BookStockRepository;
import br.edu.ufrn.smartmenu.stocks.services.StockService;

@Service
public class BookStockService extends StockService<BookStock, BookStockRepository> {

    @Override
    public void alertIfLowStock(BookStock stock) {
        if (stock.getQuantity() <= 2) {
            Book book = stock.getItem();

            System.out.println(
                String.format(
                    "Stock of book \"%s\" is low and should be increased. "
                    + "Book ID: %d, Quantity: %d.",
                    book.getName(), book.getId(), stock.getQuantity()
                )
            );
        }
    }
    
}
