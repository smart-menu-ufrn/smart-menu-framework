package br.edu.ufrn.bookstore.items.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ufrn.bookstore.items.models.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    
}
