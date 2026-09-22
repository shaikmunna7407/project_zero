package com.lms.app.dao;

import com.lms.app.model.User;

import java.util.List;

public interface UserDAO {

    void saveUser(User user);

    User findById(int userId);

    User findByUsername(String username);

    User findByEmail(String email);
    List<User> getAllUsers();

    void deleteUser(int userId);
    void updateEmail(int userId, String email);

    void updatePassword(int userId, String passwordHash);
     void updateUsername(int userId, String username);

    void updateStatus(int userId, String status);
}