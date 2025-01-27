package peaksoft.service;

import peaksoft.entities.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    void delete(Long id);

    void save(User user);

    User findById(Long id);

    void update(User user, Long id);
}
