package com.myfirstproj.demo.hello.service;

import com.myfirstproj.demo.hello.model.User;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@Service
public class UserService {


    public static ArrayList<User> users=new ArrayList<>();
    public static int id=0;

    public User addUser(User user)
    {
        User newUser = User.builder().id(++id).name(user.getName()).dob(user.getDob()).build();
        users.add(newUser);
        return newUser;
    }
}
