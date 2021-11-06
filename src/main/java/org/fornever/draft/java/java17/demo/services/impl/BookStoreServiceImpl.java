package org.fornever.draft.java.java17.demo.services.impl;

import org.fornever.draft.java.java17.demo.dtos.BookDataDto;
import org.fornever.draft.java.java17.demo.models.Book;
import org.fornever.draft.java.java17.demo.repositories.AuthorRepository;
import org.fornever.draft.java.java17.demo.repositories.BookRepository;
import org.fornever.draft.java.java17.demo.services.BookStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

@Service
public class BookStoreServiceImpl implements BookStoreService {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    @Autowired
    public BookStoreServiceImpl(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public Book save(BookDataDto dto) {
        var b = new Book();
        b.setName(dto.name());
        b.setCategory(dto.category());
        b.setId(dto.id());
        return bookRepository.save(b);
    }

    @Override
    @Nullable
    public Book findBookById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }
}
