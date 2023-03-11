package com.myfirstproj.demo.hello.service;

import com.myfirstproj.demo.hello.model.User;
import com.myfirstproj.demo.hello.repository.UserJPARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserJPAService {
    @Autowired
    UserJPARepository userJPARepository;
    public static ArrayList<User> users = new ArrayList<>();
    public static int id = 0;

    static {
        users.add(new User(++id, "Roger", LocalDate.now().minusYears(20)));
        users.add(new User(++id, "Rafa", LocalDate.now().minusYears(18)));
        users.add(new User(++id, "Novak", LocalDate.now().minusYears(15)));
    }

    public List<User> retrieveAllUsers() {
        return userJPARepository.findAll();
        //  return users;
    }

    // select * from user_details where id =1;
    public User getUser(int userId) {
        User user = userJPARepository.findById(userId).get();
        /*Optional<User> byId = userJPARepository.findById(userId);
        if (byId.isEmpty()) return null;*/
        return user;
    }

    public User addUser(User user) {
        User save = userJPARepository.save(user);
        return save;
    }

    public void deleteUser(int userId) {
        // user is present or not then delete
        userJPARepository.deleteById(userId);
        //  users.removeIf(x -> x.getId() == userId);
    }

   /* public User updateUser(int userId, User user) {
        User newUser = userJPARepository.findById(userId).get();
        //  User newUser = users.stream().filter(x -> x.getId() == userId).findFirst().orElse(null);
        if (newUser == null) throw new UserNotFoundException("user with " + userId + " not found");
        newUser.setName(user.getName());
        newUser.setDob(user.getDob());
        return newUser;
    }*/
}
