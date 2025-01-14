package br.edu.ufrn.bookstore.items.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufrn.bookstore.items.models.Book;
import br.edu.ufrn.bookstore.items.repositories.BookRepository;
import br.edu.ufrn.bookstore.stocks.models.BookStock;
import br.edu.ufrn.bookstore.stocks.repositories.BookStockRepository;
import br.edu.ufrn.smartmenu.items.services.ItemService;

@Service
public class BookService extends ItemService<Book, BookRepository> {

    @Autowired
    private BookStockRepository stockRepository;

    @Override
    public Book updateEntity(Book entity, Book updatedEntity) {
        entity.setAuthor(updatedEntity.getAuthor());
        entity.setCategory(updatedEntity.getCategory());
        entity.setDescription(updatedEntity.getDescription());
        entity.setName(updatedEntity.getName());
        entity.setPrice(updatedEntity.getPrice());
        entity.setPublisher(updatedEntity.getPublisher());
        entity.setYear(updatedEntity.getYear());

        return entity;
    }

    @Override
    public void createStock(Book item) {
        BookStock stock = new BookStock();
        
        stock.setItem(item);

        this.stockRepository.save(stock);
    }
    
}
