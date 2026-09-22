package com.lms.app.dao;

import com.lms.app.model.User;
import com.lms.app.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO {

    @Override
    public void saveUser(User user) {

        String sql =
                "INSERT INTO users (username, email, password_hash, status, role) " +
                        "VALUES (?, ?, ?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, user.getUsername());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPasswordHash());
            ps.setString(4, user.getStatus());
            ps.setString(5, user.getRole());

            int row = ps.executeUpdate();

            if (row > 0) {
                System.out.println("User added successfully");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public User findById(int userId) {
        String sql="select *from users where user_id=?";
        try(Connection con= DBConnection.getConnection();PreparedStatement ps=con.prepareStatement(sql)) {

          ps.setInt(1,userId);
          ResultSet rs= ps.executeQuery();
          if(rs.next()){
              User user=new User(
                      rs.getInt("user_id"),
                      rs.getString("username"),
                      rs.getString("email"),
                      rs.getString("password_hash"),
                      rs.getString("status"),
                      rs.getString("role"),
                      rs.getTimestamp("created_at"),
                      rs.getTimestamp("updated_at")
              );
              return user;
          }

        }
        catch (Exception e){
            e.printStackTrace();

        }
        return null;
    }

    @Override
    public User findByUsername(String username) {
        String sql="select *from users where username=?";
        try(Connection con=DBConnection.getConnection();PreparedStatement ps=con.prepareStatement(sql)){
            ps.setString(1,username);
            ResultSet rs=ps.executeQuery();
            if(rs.next()) {
                User user = new User(rs.getInt("user_id"),
                        rs.getString("username"),
                        rs.getString("email"),
                        rs.getString("password_hash"),
                        rs.getString("status"),
                        rs.getString("role"),
                        rs.getTimestamp("created_at"),
                        rs.getTimestamp("updated_at"));
                return user;
            }

        } catch (Exception e) {
          e.printStackTrace();
        }
        return null;
    }

    @Override
    public User findByEmail(String email) {
        String sql="select *from users where email=?";
        try(Connection con=DBConnection.getConnection();PreparedStatement ps=con.prepareStatement(sql)){
           ps.setString(1,email);
           ResultSet rs=ps.executeQuery();
           if(rs.next()){
             User user=new User(rs.getInt("user_id"),
                       rs.getString("username"),
                       rs.getString("email"),
                       rs.getString("password_hash"),
                       rs.getString("status"),
                       rs.getString("role"),
                       rs.getTimestamp("created_at"),
                       rs.getTimestamp("updated_at"));
               return user;
           }


        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public void updatePassword(int userId, String passwordHash) {

        String sql = "UPDATE users SET password_hash=? WHERE user_id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, passwordHash);
            ps.setInt(2, userId);

            int row = ps.executeUpdate();

            if (row > 0) {
                System.out.println("Password updated successfully");
            } else {
                System.out.println("User not found");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public void updateStatus(int userId, String status) {

        String sql = "UPDATE users SET status=? WHERE user_id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, status);
            ps.setInt(2, userId);

            int row = ps.executeUpdate();

            if (row > 0) {
                System.out.println("Status updated successfully");
            } else {
                System.out.println("User not found");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public void updateEmail(int userId, String email) {

        String sql = "UPDATE users SET email=? WHERE user_id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, email);
            ps.setInt(2, userId);

            int row = ps.executeUpdate();

            if (row > 0) {
                System.out.println("Email updated successfully");
            } else {
                System.out.println("User not found");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public void updateUsername(int userId, String username) {

        String sql = "UPDATE users SET username=? WHERE user_id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, username);
            ps.setInt(2, userId);

            int row = ps.executeUpdate();

            if (row > 0) {
                System.out.println("Username updated successfully");
            } else {
                System.out.println("User not found");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public List<User> getAllUsers() {

        List<User> users = new ArrayList<>();

        String sql = "SELECT * FROM users";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                User user = new User(
                        rs.getInt("user_id"),
                        rs.getString("username"),
                        rs.getString("email"),
                        rs.getString("password_hash"),
                        rs.getString("status"),
                        rs.getString("role"),
                        rs.getTimestamp("created_at"),
                        rs.getTimestamp("updated_at")
                );

                users.add(user);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return users;
    }
    @Override
    public void deleteUser(int userId) {

        String sql = "DELETE FROM users WHERE user_id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, userId);

            int row = ps.executeUpdate();

            if (row > 0) {
                System.out.println("User deleted successfully");
            } else {
                System.out.println("User not found");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}