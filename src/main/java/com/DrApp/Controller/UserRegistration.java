package com.DrApp.Controller;


import com.DrApp.Model.Role;
import com.DrApp.Model.Specialist;
import com.DrApp.Model.User;
import com.DrApp.Model.UserInfo;
import com.DrApp.Service.RoleService;
import com.DrApp.Service.UserInfoService;
import com.DrApp.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import java.net.http.HttpClient;

@Controller
public class UserRegistration {

    private UserService userService;
    private RoleService roleService;

    @Autowired
    public UserRegistration(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }


    @GetMapping("/registerUser")
    public String addUser(Model model) {
        User theUser = new User();
        UserInfo theUserInfo = new UserInfo();

        model.addAttribute("theUser", theUser);
        model.addAttribute("userInfo", theUserInfo);

        return "/registerUser";
    }

    @PostMapping("/registerUser/register")
    public String registerUser(@ModelAttribute("user") User theUser, @ModelAttribute("userInfo") UserInfo theUserInfo) {
        theUser.setUserInfo(theUserInfo);
        userService.saveUser(theUser);
        Role theRole = new Role(theUser, "USER");
        roleService.saveRole(theRole);

        return "/index";
    }

    @GetMapping("/registerSpecialist")
    public String addSpecialist(Model model) {

        model.addAttribute("user", new User());
        model.addAttribute("specialist", new Specialist());

        return "/registerSpecialist";
    }

    @PostMapping("/registerSpecialist/register")
    public String registerSpecialist(@ModelAttribute("user") User theUser, @ModelAttribute("specialist") Specialist theSpecialist) {
        theUser.setSpecialist(theSpecialist);
        userService.saveUser(theUser);
        Role theRole = new Role(theUser,"SPEC");
        return "/index";
    }
}
