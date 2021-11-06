package org.fornever.draft.java.java17.demo.services;

import org.fornever.draft.java.java17.demo.dtos.BookDataDto;
import org.fornever.draft.java.java17.demo.models.Book;

public interface BookStoreService {

    Book save(BookDataDto dto);

    Book findBookById(Long id);

}
