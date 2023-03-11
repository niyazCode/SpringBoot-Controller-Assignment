package com.myfirstproj.demo.hello.controller;

import com.myfirstproj.demo.hello.model.User;
import com.myfirstproj.demo.hello.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@RestController
public class HelloController {

    @Autowired
    UserService userService;



    @RequestMapping(path = "/api/messages",method = RequestMethod.GET)
    public String greetMessage(){
        return "welcome to  ";
    }

    @GetMapping(path = "/employees")
    public List<Employee> getEmployees(){
        Employee emp1 = Employee.builder().id(1).name("Mohamed").dob(LocalDate.now().minusYears(20)).build();
        Employee emp2 = Employee.builder().id(2).name("Niyaz").dob(LocalDate.now().minusYears(15)).build();
        return Arrays.asList(emp1,emp2);
    }

    @PostMapping(path= "/users")
    public ResponseEntity<User> createUser(@RequestBody @Valid User user)
    {
        User newUser = userService.addUser(user);
        if(newUser==null)
            return ResponseEntity.internalServerError().body(newUser);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(newUser.getId()).toUri();
        return ResponseEntity.created(uri).body(newUser);
    }


}
