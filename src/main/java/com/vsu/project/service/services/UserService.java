package com.vsu.project.service.services;

import com.vsu.project.service.entity.User;

import java.util.List;

public interface UserService {
    User addUser(User user);
    void delete(long id);
    User getById(long id);
    User updateUser(User user);
    List<User> getAll();
}
