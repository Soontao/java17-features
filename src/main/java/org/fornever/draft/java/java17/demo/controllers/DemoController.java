package org.fornever.draft.java.java17.demo.controllers;

import org.fornever.draft.java.java17.demo.dtos.BookDataDto;
import org.fornever.draft.java.java17.demo.models.Book;
import org.fornever.draft.java.java17.demo.services.BookStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/api/v1/demo")
public class DemoController {

    private BookStoreService bookStoreService;

    @Autowired
    public DemoController(BookStoreService bookStoreService) {
        this.bookStoreService = bookStoreService;
    }

    @GetMapping("/")
    public Map<String, List<String>> index() {

        // keyword 'var' and type infer, only in method block
        var name = "demo api"; // String

        // much more convenience factory for Map, Set and List
        return Map.of("api", List.of(name, "v1"));

    }

    @PostMapping("/set")
    public Object pattern(@RequestBody Set<Object> payload) {
        return payload.stream().map(item -> {
            // shorten guarded variable
            if (item instanceof Number n && n.longValue() > 10) {
                return 1;
            }
            return 0;
            //if (item instanceof Number && ((Number) item).longValue() > 10) {
            //    return 0;
            //}
        }).toList(); // shorten of collect(Collectors.toList)

    }

    @GetMapping("/book")
    public Object queryBookAuthorName(@RequestParam Long bookId) {
        var book = bookStoreService.findBookById(bookId);
        // much more clear null pointer exception
        return Map.of("author_name", book.getAuthor().getName());
    }

    @PostMapping("/book")
    public Book createBook(@RequestBody BookDataDto payload) {
        return bookStoreService.save(payload);
    }


}
