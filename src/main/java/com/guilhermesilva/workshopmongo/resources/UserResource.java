package com.guilhermesilva.workshopmongo.resources;

import com.guilhermesilva.workshopmongo.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @GetMapping
    public ResponseEntity<List<User>> findAllUsers(){
        User maria = new User("1","Maria silva", "maria@gmail.com");
        User joao = new User("2","Joao sousa", "joao@gmail.com");
        List<User> list = new ArrayList<>();

        list.addAll(Arrays.asList(maria,joao));
        return ResponseEntity.ok().body(list);
    }
}
