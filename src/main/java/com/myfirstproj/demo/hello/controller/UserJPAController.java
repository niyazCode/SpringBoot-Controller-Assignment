package com.myfirstproj.demo.hello.controller;


import com.myfirstproj.demo.hello.model.User;
import com.myfirstproj.demo.hello.service.UserJPAService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
    @RequestMapping("/api/jpa")
    @Slf4j
    public class UserJPAController {
        // dependency injection- spring servelt container
        @Autowired
        UserJPAService userJpaService;
        @Autowired
        private HttpServletRequest request;
        /* public UserController(UserService userService){
             this.userService=userService;
         }*/
        @GetMapping(path = "/users")
        public List<User> getAllUsers(){
            return userJpaService.retrieveAllUsers();
        }
        // get a specific user
       /* @GetMapping(value = "/users/{userId}",consumes = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<User> getSpecificUser(@PathVariable int userId){
            User user = userJpaService.getUser(userId);
            if(user==null) throw new UserNotFoundException("user with id"+ userId+" not found");
            return new ResponseEntity<>(user,HttpStatus.OK);
        }*/

    // create a new user
    // request body, context url, header
    @PostMapping(path = "/users")
    public ResponseEntity<User> createUser( @Valid @RequestBody User user){
        if(user==null) return  ResponseEntity.internalServerError().body(user);
        User newUser = userJpaService.addUser(user);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(newUser.getId())
                .toUri();
        // get a specific user
        return ResponseEntity.created(uri).body(newUser);
    }
    // delete a user
    @DeleteMapping("/users/{userId}")
    public ResponseEntity deleteUser(@PathVariable int userId){
        userJpaService.deleteUser(userId);
        return ResponseEntity.noContent().build();
    }

    // update a user
    /*@PutMapping("/users/{userId}")
    public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable int userId){
        if(user.getName()==null && user.getDob()==null)
            return ResponseEntity.badRequest().build();
        return new ResponseEntity(userJpaService.updateUser(userId, user), HttpStatus.OK);
    }
    // upsert design
    @PutMapping("/users")
    public ResponseEntity<User> updateUpsert(@RequestBody User user){
        // find user
        User returnedUser = userJpaService.getUser(user.getId());
        // if  not exist then create and return
        if(returnedUser==null) {
            ResponseEntity<User> user1 = createUser(user);
            return new ResponseEntity(user1.getBody(), HttpStatus.CREATED);
        }
        // if yes return the updated user
        userJpaService.updateUser(returnedUser,user);
        return new ResponseEntity<>(returnedUser,HttpStatus.OK);
    }*/
}
