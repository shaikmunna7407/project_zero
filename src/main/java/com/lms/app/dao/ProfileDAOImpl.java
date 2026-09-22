package com.lms.app.dao;

import com.lms.app.model.Profile;
import com.lms.app.util.DBConnection;

import java.sql.*;

public class ProfileDAOImpl implements ProfileDAO{


   public void saveProfile(Profile profile){
      String sql="insert  into profiles(userid,fullname,bio,phone,profileimageurl)"+"values(?,?,?,?,?)";

        try(
                Connection con= DBConnection.getConnection();
                PreparedStatement ps=con.prepareStatement(sql)){
            ps.setInt(1,profile.getUserId());
            ps.setString(2, profile.getFullName());
            ps.setString(3, profile.getBio());

            ps.setString(4, profile.getBio());
            ps.setString(5, profile.getProfileImageUrl());
            int row=ps.executeUpdate();
            if(row>0){
                System.out.println("the profile is saved successfully");
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

  public  Profile findByUserId(int userId){
       String sql="select *from Profile where userid=?";
       try(Connection con=DBConnection.getConnection();PreparedStatement ps=con.prepareStatement(sql)){
           ResultSet rs=ps.executeQuery();
           while(rs.next()){
             Profile ps=new Profile(profile.getName())
           }
      }
       catch (Exception e){
           e.printStackTrace();
       }
  }

    void updateFullName(int userId, String fullName);

    void updateBio(int userId, String bio);

    void updatePhone(int userId, String phone);

    void updateProfileImage(int userId, String profileImageUrl);
}
