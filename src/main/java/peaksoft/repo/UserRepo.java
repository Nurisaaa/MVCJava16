package peaksoft.repo;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import peaksoft.entities.User;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserRepo {
    private final EntityManager em;

    public List<User> findAll() {
        return em.createQuery("select u from User u", User.class).getResultList();
    }
}
