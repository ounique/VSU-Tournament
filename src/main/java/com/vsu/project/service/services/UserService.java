package com.vsu.project.service.services;

import com.vsu.project.service.entity.User;
import com.vsu.project.service.entity.enums.UserRole;

import java.util.List;

public interface UserService {
    User addUser(User user);
    void delete(long id);
    User getById(long id);
    User findByUsername(String username);
    User updateUser(User user);
    List<User> getAll();
    List<User> getUsersByRole(UserRole role);
    List<User> getUsersByRole(UserRole role, int count);
}
