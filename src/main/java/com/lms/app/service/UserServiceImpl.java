package com.lms.app.service;

import com.lms.app.dao.UserDAO;
import com.lms.app.dao.UserDAOImpl;
import com.lms.app.model.User;


import java.util.List;

public class UserServiceImpl implements UserService {

    private UserDAO userDAO = new UserDAOImpl();

    @Override
    public User registerUser(User user) {


        User existingUser = userDAO.findByUsername(user.getUsername());

        if (existingUser != null) {
            throw new IllegalArgumentException("Username already exists");
        }


        User existingEmail = userDAO.findByEmail(user.getEmail());

        if (existingEmail != null) {
            throw new IllegalArgumentException("Email already exists");
        }





        userDAO.saveUser(user);

        return user;
    }

    @Override
    public User loginUser(String username, String password) {

        User user = userDAO.findByUsername(username);

        if (user == null) {
            throw new IllegalArgumentException("Username not found");
        }





        return user;
    }

    @Override
    public void logoutUser(int userId) {

        User user = userDAO.findById(userId);

        if (user == null) {
            throw new IllegalArgumentException("User not found");
        }

        System.out.println("User logged out successfully");
    }
    @Override
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }
    @Override
    public void changePassword(int userId, String oldPassword, String newPassword) {

        User user = userDAO.findById(userId);

        if (user == null) {
            throw new IllegalArgumentException("User not found");
        }


        if (oldPassword.equals(newPassword)) {
            throw new IllegalArgumentException(
                    "Old password and new password cannot be the same"
            );
        }
        userDAO.updatePassword(userId,newPassword);

    }

    @Override
    public User getUserById(int userId) {

        User user = userDAO.findById(userId);

        if (user == null) {
            throw new IllegalArgumentException("User not found");
        }

        return user;
    }

    @Override
    public User getUserByUsername(String username) {

        User user = userDAO.findByUsername(username);

        if (user == null) {
            throw new IllegalArgumentException("User not found");
        }

        return user;
    }

    @Override
    public User getUserByEmail(String email) {

        User user = userDAO.findByEmail(email);

        if (user == null) {
            throw new IllegalArgumentException("User not found");
        }

        return user;
    }

    @Override
    public void updateUsername(int userId, String username) {

        User user = userDAO.findById(userId);

        if (user == null) {
            throw new IllegalArgumentException("User not found");
        }


        User existingUser = userDAO.findByUsername(username);

        if (existingUser != null && existingUser.getUserId() != userId) {
            throw new IllegalArgumentException("Username already exists");
        }

        userDAO.updateUsername(userId, username);
    }

    @Override
    public void updateEmail(int userId, String email) {

        User user = userDAO.findById(userId);

        if (user == null) {
            throw new IllegalArgumentException("User not found");
        }

        User existingUser = userDAO.findByEmail(email);

        if (existingUser != null && existingUser.getUserId() != userId) {
            throw new IllegalArgumentException("Email already exists");
        }

        userDAO.updateEmail(userId, email);
    }

    @Override
    public void updateStatus(int userId, String status) {

        User user = userDAO.findById(userId);

        if (user == null) {
            throw new IllegalArgumentException("User not found");
        }
        if(!user.getRole().equalsIgnoreCase("admin")){
            throw new IllegalArgumentException("User cannot modify the status");
        }


        userDAO.updateStatus(userId, status);
    }

    @Override
    public void deleteUser(int userId) {

        User user = userDAO.findById(userId);

        if (user == null) {
            throw new IllegalArgumentException("User not found");
        }

        userDAO.deleteUser(userId);
    }
}