package com.lms.app.dao;

import com.lms.app.model.Profile;
public interface ProfileDAO {

    void saveProfile(Profile profile);

    Profile findByUserId(int userId);

    void updateFullName(int userId, String fullName);

    void updateBio(int userId, String bio);

    void updatePhone(int userId, String phone);

    void updateProfileImage(int userId, String profileImageUrl);
}