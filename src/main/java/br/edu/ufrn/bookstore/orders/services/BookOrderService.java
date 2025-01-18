package br.edu.ufrn.bookstore.orders.services;

import org.springframework.stereotype.Service;

import br.edu.ufrn.bookstore.items.models.Book;
import br.edu.ufrn.bookstore.orders.models.BookOrder;
import br.edu.ufrn.bookstore.orders.models.BookOrderedItem;
import br.edu.ufrn.bookstore.orders.repositories.BookOrderRepository;
import br.edu.ufrn.bookstore.stocks.models.BookStock;
import br.edu.ufrn.bookstore.stocks.services.BookStockService;
import br.edu.ufrn.smartmenu.orders.services.OrderService;

@Service
public class BookOrderService extends OrderService<
    Book,
    BookOrderedItem,
    BookOrder,
    BookOrderRepository,
    BookStock,
    BookStockService
> {
    
}
