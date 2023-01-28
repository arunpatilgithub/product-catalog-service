package com.ap.productcatalogservice.profilespecific;

import com.ap.productcatalogservice.dao.BookRepository;
import com.ap.productcatalogservice.model.Book;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Date;


@Component
@Profile("testdata")
public class TestDataLoader {

    private final BookRepository bookRepository;

    public TestDataLoader(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void loadBookTestData() {
        var book1 = Book.of(String.valueOf(LocalDateTime.now()), "Northern " +
                                    "Lights",
                            "Lyra" +
                                    " " +
                                    "Silverstar",
                            9.90, "SomeAuthor");
        var book2 = Book.of(String.valueOf(LocalDateTime.now()), "Polar " +
                                    "Journey", "Iorek Polarson",
                12.90, "SomeAuthor");
        bookRepository.save(book1);
        bookRepository.save(book2);
    }
}
