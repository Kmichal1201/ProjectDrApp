package com.DrApp.Service;


import com.DrApp.Model.User;
import com.DrApp.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {


    private UserRepository userRepo;

    @Autowired
    public UserService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    public void saveUser(User theUser) {
        userRepo.save(theUser);
    }

    public List<User> findAllUsers() {
        List<User> userList = userRepo.findAll();
        return userList;
    }

    public User findUserById(int id) {
        Optional<User> result = userRepo.findById(id);
        User theUser = null;
        if (!result.isEmpty()){
            theUser=result.get();
        }else try {
            throw new Exception("Can't find user:"+theUser.getUserInfo());
        } catch (Exception e) {
            throw new RuntimeException("Can't find user");
        }
        return theUser;
    }
    public void deleteUser(Integer id){
        userRepo.deleteById(id);

    }


}
