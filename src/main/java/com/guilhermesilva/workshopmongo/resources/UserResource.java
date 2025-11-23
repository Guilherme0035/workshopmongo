package com.guilhermesilva.workshopmongo.resources;

import com.guilhermesilva.workshopmongo.domain.Post;
import com.guilhermesilva.workshopmongo.domain.User;
import com.guilhermesilva.workshopmongo.dto.UserDTO;
import com.guilhermesilva.workshopmongo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.Update;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAllUsers(){
       List<User> list = userService.findAllUsers();
       List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable String id){
        User user = userService.findUserById(id);
        return ResponseEntity.ok().body(new UserDTO(user));
    }

    @PostMapping
    public ResponseEntity<User> insertUser(@RequestBody UserDTO objDTO){
        User newUser = userService.fromDTO(objDTO);
        User obj = userService.insertUser(newUser);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<Void> deletedUser(@PathVariable String id){
        userService.deletedUser(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<User> updateUser(@PathVariable String id, @RequestBody User obj){
        User user = userService.updateUser(id,obj);
        return ResponseEntity.ok().body(user);
    }

    @GetMapping(value = "/{id}/posts")
    public ResponseEntity<List<Post>> findByPosts(@PathVariable String id){
        User user = userService.findUserById(id);
        return ResponseEntity.ok().body(user.getPosts());
    }
}

