package com.lms.app.service;

import com.lms.app.model.User;

import java.util.List;

public interface UserService {

    User registerUser(User user);

    User loginUser(String username, String password);

    void logoutUser(int userId);

    void changePassword(int userId, String oldPassword, String newPassword);

    User getUserById(int userId);

    User getUserByUsername(String username);

    User getUserByEmail(String email);

    void updateUsername(int userId, String username);

    void updateEmail(int userId, String email);

    void updateStatus(int userId, String status);

    void deleteUser(int userId);
    List<User> getAllUsers();
}