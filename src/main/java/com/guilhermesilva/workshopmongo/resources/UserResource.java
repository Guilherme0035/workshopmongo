package com.guilhermesilva.workshopmongo.resources;

import com.guilhermesilva.workshopmongo.domain.User;
import com.guilhermesilva.workshopmongo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> findAllUsers(){
       List<User> list = userService.findAllUsers();
        return ResponseEntity.ok().body(list);
    }
}
