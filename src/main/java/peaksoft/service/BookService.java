package peaksoft.service;

import peaksoft.entities.Book;

import java.util.List;

public interface BookService {
    List<Book> getAll();
    Book get(Long id);
    void save(Book book);
    void update(Long id,Book book);
    void delete(Long id);
    List<Book> getBooksWithoutUser();

    void assignBook(Long id, Long bookId);
}
