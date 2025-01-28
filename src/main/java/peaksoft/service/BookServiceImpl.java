package peaksoft.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.entities.Book;
import peaksoft.repo.BookRepo;
import peaksoft.repo.UserRepo;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepo bookRepo;
    private final UserRepo userRepo;

    @Override
    public List<Book> getAll() {
        return bookRepo.getAll();
    }

    @Override
    public Book get(Long id) {
        return bookRepo.getBook(id);
    }

    @Override
    public void save(Book book) {
        bookRepo.save(book);
    }

    @Override
    public void update(Long id,Book book) {
        bookRepo.update(id, book);
    }

    @Override
    public void delete(Long id) {
        bookRepo.delete(id);
    }

    @Override
    public List<Book> getBooksWithoutUser() {
        return null;
    }

    @Override
    public void assignBook(Long id, Long bookId) {
        userRepo.assignBook(id, bookId);
    }
}
