package com.guilhermesilva.workshopmongo.service;

import com.guilhermesilva.workshopmongo.domain.User;
import com.guilhermesilva.workshopmongo.dto.UserDTO;
import com.guilhermesilva.workshopmongo.repository.UserRepository;
import com.guilhermesilva.workshopmongo.service.exception.ObjectNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public User findUserById(String id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElseThrow(() -> new ObjectNotFoundException("Usuário não encontrado"));
    }

    public User insertUser(User user) {
        return userRepository.save(user);
    }

    public User fromDTO(UserDTO objDTO) {
        return new User(objDTO.getId(), objDTO.getName(), objDTO.getEmail());
    }

    public void deletedUser(String id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
        } else {
            throw new ObjectNotFoundException("Usuário não foi encontrado");
        }
    }

    public User updateUser(String id, User obj) {
        Optional<User> userFound = userRepository.findById(id);

        if (userFound.isPresent()) {
            User user = userFound.get();

            BeanUtils.copyProperties(obj,user);

            return userRepository.save(user);

        } else
            throw new ObjectNotFoundException("Usuário não encontrado");
        }
    }
