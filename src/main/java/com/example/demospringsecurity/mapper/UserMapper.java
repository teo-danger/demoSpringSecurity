package com.example.demospringsecurity.mapper;

import com.example.demospringsecurity.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserMapper {

    User select(String username);

}
