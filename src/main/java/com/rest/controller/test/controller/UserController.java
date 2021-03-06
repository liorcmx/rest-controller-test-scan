package com.rest.controller.test.controller;

import com.rest.controller.test.model.User;
import com.rest.controller.test.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping("/users/findAll")
    List<User> findAllUsers() {
        System.out.println("findAllUsers");
        return null;
    }

    @PostMapping("/user/insert")
    User createUser(@RequestBody User user, HttpServletRequest servletRequest) {
        System.out.println("insertUser");
        userService.insertUser(user);
        return user;
    }

    @PostMapping("/user/create/password")
    User createUserVar(@RequestBody User user, @RequestParam(required=true) String password) {
        System.out.println("createUserVar");
        user.setInfo("OK");
        System.out.println(user);
        System.out.println("password:" + password);
        return user;
    }

    @GetMapping(value = "/user/get/byEmail/{email}")
    public User getUserByEmail(@PathVariable("email") String email) {
        System.out.println("getUserByEmail");
        System.out.println(email);
        User user = userService.getUserByEmail(email);
        return user;
    }

    @GetMapping(value = "/user/get/byId/{id}")
    public User getUserById(@PathVariable("id") Long id) {
        System.out.println("getUserById");
        System.out.println(id);
        User user = userService.getUserById(id);
        return user;
    }

    @PostMapping(value = "/user/update")
    public void updateUser(@RequestBody User user) {
        System.out.println("updateUserById");
        System.out.println(user);
        userService.updateUser(user);
    }

    @GetMapping(value = "/user/get/firstName/byEmail/{email}")
    public String getUserFirstName(@PathVariable("email") String email) {
        System.out.println("getUserFirstName");
        return "LioR";
    }


}