package com.DrApp.Service;


import com.DrApp.Model.UserInfo;
import com.DrApp.Repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserInfoService {

    private UserInfoRepository userInfoRepo;

    @Autowired
    public UserInfoService(UserInfoRepository userInfoRepo) {
        this.userInfoRepo = userInfoRepo;
    }

    public void addUserInfo(UserInfo theUserInfo) {
        userInfoRepo.save(theUserInfo);
    }

    public List<UserInfo> showAllUsers() {
        List<UserInfo>allUsers;
        allUsers = userInfoRepo.findAll();
        return allUsers;
    }

    public UserInfo findById(int id){
        Optional<UserInfo> current = userInfoRepo.findById(id);
        UserInfo userInfo = current.get();
        return userInfo;
    }


}
