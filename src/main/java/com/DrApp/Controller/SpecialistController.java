package com.DrApp.Controller;

import com.DrApp.Model.Role;
import com.DrApp.Model.Specialist;
import com.DrApp.Model.User;
import com.DrApp.Service.RoleService;
import com.DrApp.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SpecialistController {

    UserService userService;
    RoleService roleService;

    @Autowired
    public SpecialistController(UserService userService,RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("/pro/forProfessionals")
    public String professionalsMain(){
        return "/forProfessionals";
    }
    @GetMapping("/pro/registerSpecialist")
    public String addSpecialist(Model model) {

        model.addAttribute("user", new User());
        model.addAttribute("specialist", new Specialist());

        return "/registerSpecialist";
    }
    @PostMapping("/pro/registerSpecialist/register")
    public String registerSpecialist(@ModelAttribute("user") User theUser, @ModelAttribute("specialist") Specialist theSpecialist) {
        theUser.setSpecialist(theSpecialist);
        userService.saveUser(theUser);
        Role theRole = new Role(theUser,"SPEC");
        roleService.saveRole(theRole);
        return "/index";
    }
}
