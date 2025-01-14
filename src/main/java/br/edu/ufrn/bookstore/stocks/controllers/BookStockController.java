package br.edu.ufrn.bookstore.stocks.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ufrn.bookstore.stocks.models.BookStock;
import br.edu.ufrn.bookstore.stocks.services.BookStockService;
import br.edu.ufrn.smartmenu.stocks.controllers.StockController;

@RestController
@RequestMapping("/stocks")
public class BookStockController extends StockController<BookStock, BookStockService> {
    
}
