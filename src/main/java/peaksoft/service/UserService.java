package peaksoft.service;

import peaksoft.entities.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
}
