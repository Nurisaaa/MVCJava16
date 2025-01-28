package peaksoft.repo;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import peaksoft.entities.Book;

import java.util.List;

@Repository  //component
@RequiredArgsConstructor
public class BookRepo {

    private final EntityManager entityManager;

    public List<Book> getAll() {
        entityManager.getTransaction().begin();
        List<Book> books = entityManager.createQuery("select b from Book b", Book.class).getResultList();
        entityManager.getTransaction().commit();
        return books;
    }

    public Book getAll(Long id) {
        return null;
    }


    public void save(Book book) {
        entityManager.getTransaction().begin();
        entityManager.persist(book);
        entityManager.getTransaction().commit();
    }

    public void update(Long id,Book book) {
        entityManager.getTransaction().begin();
        Book book1 = entityManager.find(Book.class, id);
        book1.setName(book.getName());
        book1.setAuthor(book.getAuthor());
        entityManager.merge(book1);
        entityManager.getTransaction().commit();
    }

    public void delete(Long id) {
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.find(Book.class, id));
        entityManager.getTransaction().commit();
    }

    public List<Book> getBooksWithoutUser() {
        entityManager.getTransaction().begin();
        List<Book> books = entityManager.createQuery("select b from Book b where b.user.id is null", Book.class).getResultList();
        entityManager.getTransaction().commit();
        return books;
    }

    public Book getBook(Long id) {
        entityManager.getTransaction().begin();
        Book book = entityManager.find(Book.class, id);
        entityManager.getTransaction().commit();
        return book;
    }
}
