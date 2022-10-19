package com.example.demospringsecurity.service;

import com.example.demospringsecurity.mapper.UserMapper;
import com.example.demospringsecurity.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;

public class UserDetailsServiceImpl implements UserDetailsService {

   @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userMapper.select(username);
        if (user == null) {
            throw new UsernameNotFoundException("Could not find user");
        }
        return new MyUserDetails(user);
    }
}