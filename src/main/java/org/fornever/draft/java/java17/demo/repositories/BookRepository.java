package org.fornever.draft.java.java17.demo.repositories;

import org.fornever.draft.java.java17.demo.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

}
