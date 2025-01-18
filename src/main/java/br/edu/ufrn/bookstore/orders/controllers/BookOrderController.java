package br.edu.ufrn.bookstore.orders.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ufrn.bookstore.items.models.Book;
import br.edu.ufrn.bookstore.orders.models.BookOrder;
import br.edu.ufrn.bookstore.orders.models.BookOrderedItem;
import br.edu.ufrn.bookstore.orders.services.BookOrderService;
import br.edu.ufrn.smartmenu.orders.controllers.OrderController;

@RestController
@RequestMapping("/orders")
public class BookOrderController extends OrderController<
    Book,
    BookOrderedItem,
    BookOrder,
    BookOrderService
> {
    
}
