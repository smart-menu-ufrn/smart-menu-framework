package br.edu.ufrn.bookstore.orders.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ufrn.bookstore.orders.models.BookOrder;

@Repository
public interface BookOrderRepository extends JpaRepository<BookOrder, Long> {
    
}
