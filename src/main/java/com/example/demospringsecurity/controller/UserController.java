package com.example.demospringsecurity.controller;



import com.example.demospringsecurity.mapper.UserMapper;
import com.example.demospringsecurity.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/user/")
public class UserController {

    private final UserMapper userMapper;

    @Autowired
    public UserController (UserMapper userMapper){
        this.userMapper = userMapper;
    }


    @GetMapping(value = "{username}")
    @ResponseBody
    public User getUsername(@PathVariable(name = "username") String username, Model model){
        User user = userMapper.select(username);
        return user;
    }


}
