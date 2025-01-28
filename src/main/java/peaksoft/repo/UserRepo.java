package peaksoft.repo;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import peaksoft.entities.Book;
import peaksoft.entities.User;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserRepo {
    private final EntityManager em;

    public List<User> findAll() {
        em.getTransaction().begin();
        List<User> users = em.createQuery("select u from User u", User.class).getResultList();
        em.getTransaction().commit();
        return users;
    }

    public void delete(Long id) {
        em.getTransaction().begin();
        User user = em.find(User.class,id);
        em.remove(user);
        em.getTransaction().commit();
    }

    public void save(User user) {
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
    }

    public User findById(Long id) {
        em.getTransaction().begin();
        User user = em.find(User.class,id);
        em.getTransaction().commit();
        return user;
    }

    public void update(User user, Long id) {
        em.getTransaction().begin();
        User editedUser = em.find(User.class, id);
        editedUser.setFirstName(user.getFirstName());
        editedUser.setLastName(user.getLastName());
        editedUser.setEmail(user.getEmail());
        editedUser.setPassword(user.getPassword());
        em.merge(editedUser);
        em.getTransaction().commit();
    }

    public void assignBook(Long id, Long bookId) {
        em.getTransaction().begin();
        User user = em.find(User.class,id);
        Book book = em.find(Book.class,bookId);
        book.setUser(user);
        user.getBooks().add(book);
        em.getTransaction().commit();
    }
}
