package br.edu.ufrn.bookstore.items.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ufrn.bookstore.items.models.Book;
import br.edu.ufrn.bookstore.items.services.BookService;
import br.edu.ufrn.smartmenu.items.controllers.ItemController;

@RestController
@RequestMapping("/books")
public class BookController extends ItemController<Book, BookService> {
    
}
