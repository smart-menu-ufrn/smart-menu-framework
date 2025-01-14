package br.edu.ufrn.bookstore.stocks.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ufrn.bookstore.stocks.models.BookStock;
import br.edu.ufrn.smartmenu.stocks.repositories.StockRepository;

@Repository
public interface BookStockRepository
extends JpaRepository<BookStock, Long>, StockRepository<BookStock> {
    public Optional<BookStock> findByItemId(Long itemId);
}
