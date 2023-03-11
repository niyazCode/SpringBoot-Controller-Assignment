package com.myfirstproj.demo.hello.repository;

import com.myfirstproj.demo.hello.model.User;
import com.myfirstproj.demo.hello.service.UserService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserJPARepository extends JpaRepository<User, Integer> {
}
