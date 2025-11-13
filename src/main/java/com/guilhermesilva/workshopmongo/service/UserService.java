package com.guilhermesilva.workshopmongo.service;

import com.guilhermesilva.workshopmongo.domain.User;
import com.guilhermesilva.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAllUsers(){
        return userRepository.findAll();
    }
}
