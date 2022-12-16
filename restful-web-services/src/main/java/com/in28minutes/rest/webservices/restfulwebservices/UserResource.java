package com.in28minutes.rest.webservices.restfulwebservices;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;
import java.util.List;

@RestController
public class UserResource {

    private UserDaoService service;

    public UserResource(UserDaoService service){
        this.service = service;
    }

    //GET /users
    @GetMapping("/users")
    public List<User> retrieveAllUsers(){
        return service.getUsers();
    }

    //GET /users
    @GetMapping("/users/{id}")
    public User retrieveUser(@PathVariable int id){
        User user = service.getUser(id);
        if (user == null){
            throw new UserNotFoundException("id: " + id);
        }
        return user;
    }

    //POST /users
    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody User user){
        User savedUser = service.saveUser(user);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }
}
