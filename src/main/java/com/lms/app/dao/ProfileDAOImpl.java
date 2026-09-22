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
           ps.setInt(1,userId);
           ResultSet rs=ps.executeQuery();
           if(rs.next()){
             Profile pro=new Profile(rs.getInt("profileid"),
                     rs.getInt("userid"),
                     rs.getString("fullname"),
                     rs.getString("bio"),
                     "phone",
                     "profileimageurl");
               return pro;
           }

      }
       catch (Exception e){
           e.printStackTrace();
       }
       return null;
  }

    public void updateFullName(int userId, String fullName){
       String sql="update profiles set fullname=? where userId=?";
       try(Connection con=DBConnection.getConnection();PreparedStatement ps=con.prepareStatement(sql)){
            ps.setInt(1,userId);
            ps.setString(2,fullName);
           int rs=ps.executeUpdate();
           if(rs>0){
               System.out.println("user updated successfully");
           }


       }
       catch(Exception e){
           e.printStackTrace();
       }
    }


   public  void updateBio(int userId, String bio){
       String sql="update profiles set bio=? where userid=?";
       try(Connection con=DBConnection.getConnection();PreparedStatement ps=con.prepareStatement(sql)){
           ps.setInt(1,userId);
           ps.setString(2,bio);
           int row=ps.executeUpdate();
           if(row>0){
               System.out.println("bio is updated successfully");
           }

       }
       catch(Exception e ){
           e.printStackTrace();
       }
   }

    public void updatePhone(int userId, String phone){
       String sql="update profiles set phone=? where userId=? ";
       try(Connection con=DBConnection.getConnection();PreparedStatement ps=con.prepareStatement(sql)){
           ps.setInt(1,userId);
           ps.setString(2,phone);
           int rs=ps.executeUpdate();
           if(rs>0){
               System.out.println("phone number is excuted successfully");
           }

       }
       catch(Exception e){
           e.printStackTrace();
       }
    }


    public void updateProfileImage(int userId, String profileImageUrl){
       String sql="update profiles set profileImageUrl=? where userUd=?";
       try(Connection con=DBConnection.getConnection();PreparedStatement ps=con.prepareStatement(sql)) {
           ps.setInt(1, userId);
           ps.setString(2, profileImageUrl);
           int rs = ps.executeUpdate();
           if (rs > 0) {
               System.out.println("the profile_image is successfully updated");
           }
       }
           catch(Exception e){
               e.printStackTrace();
           }

    }
}
