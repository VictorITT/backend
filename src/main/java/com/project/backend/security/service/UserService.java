package com.project.backend.security.service;


import com.project.backend.model.User;
import com.project.backend.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class UserService {

    @Autowired
    UsersRepository usersRepository;

    public Optional<User> getByUsername(String nombreUsuario){
        return usersRepository.findByUsername(nombreUsuario);
    }

    public boolean existsByUsername(String nombreUsuario){
        return usersRepository.existsByUsername(nombreUsuario);
    }

    public boolean existsByEmail(String email){
        return usersRepository.existsByEmail(email);
    }

    public void save(User user){
        usersRepository.save(user);
    }
}
