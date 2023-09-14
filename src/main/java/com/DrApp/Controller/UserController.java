package com.DrApp.Controller;


import com.DrApp.Model.Role;
import com.DrApp.Model.Specialist;
import com.DrApp.Model.User;
import com.DrApp.Model.UserInfo;
import com.DrApp.Service.RoleService;
import com.DrApp.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    private UserService userService;
    private RoleService roleService;

    @Autowired
    public UserController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }


    @GetMapping("/user/registerUser")
    public String addUser(Model model) {
        User theUser = new User();
        UserInfo theUserInfo = new UserInfo();

        model.addAttribute("theUser", theUser);
        model.addAttribute("userInfo", theUserInfo);

        return "/registerUser";
    }

    @PostMapping("/user/registerUser/register")
    public String registerUser(@ModelAttribute("user") User theUser, @ModelAttribute("userInfo") UserInfo theUserInfo) {
        theUser.setUserInfo(theUserInfo);
        userService.saveUser(theUser);
        Role theRole = new Role(theUser, "USER");
        roleService.saveRole(theRole);

        return "/index";
    }



}
