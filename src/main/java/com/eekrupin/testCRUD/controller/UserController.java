package com.eekrupin.testCRUD.controller;

import com.eekrupin.testCRUD.Direction;
import com.eekrupin.testCRUD.model.User;
import com.eekrupin.testCRUD.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    private UserService userService;

    @Autowired(required = true)
    @Qualifier(value = "userService")
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "users", method = RequestMethod.GET)
    public String listUsers(Model model){
        model.addAttribute("user", new User());
        model.addAttribute("listUsers", this.userService.listUsers(""));

        return "users";
    }

    @RequestMapping(value = "/usersPage", method = RequestMethod.POST)
    public String listUsersPage(@RequestParam(required=false, value = "previous") String previous,
                                @RequestParam(required=false, value = "next") String next,
                                @RequestParam("firstId") int firstId,
                                @RequestParam("lastId") int lastId,
                                @RequestParam String searchName, Model model){
        model.addAttribute("user", new User());

        List<User> list = new ArrayList<User>();
        if (previous!=null){
            list = this.userService.listUsers(firstId, Direction.Backward, searchName);
        }
        else if (next!=null){
            list = this.userService.listUsers(lastId, Direction.Forward, searchName);
        }
        model.addAttribute("listUsers", list);
        model.addAttribute("searchName", searchName);

        return "users";
    }

    @RequestMapping(value = "/users/add", method = RequestMethod.POST)
    public String addUser(@ModelAttribute("user") @Validated User user, BindingResult result, Model model){
        if(user.getId() == 0){
            this.userService.addUser(user);
        }else {
            this.userService.updateUser(user);
        }
        return "redirect:/users";
    }

    @RequestMapping("/remove/{id}")
    public String removeUser(@PathVariable("id") int id){
        this.userService.removeUser(id);
        return "redirect:/users";
    }

    @RequestMapping("edit/{id}")
    public String editUser(@PathVariable("id") int id, Model model){
        model.addAttribute("user", this.userService.getUser(id));
        model.addAttribute("listUsers", this.userService.listUsers(""));

        return "users";
    }

    @RequestMapping("userdata/{id}")
    public String userData(@PathVariable("id") int id, Model model){
        model.addAttribute("user", this.userService.getUser(id));
        return "userdata";
    }

}
