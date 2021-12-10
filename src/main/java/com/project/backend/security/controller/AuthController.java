package com.project.backend.security.controller;


import com.project.backend.dto.Message;
import com.project.backend.dto.JwtDto;
import com.project.backend.dto.UserLogin;
import com.project.backend.dto.NewUser;
import com.project.backend.model.Rol;
import com.project.backend.model.User;
import com.project.backend.security.enums.NameRol;
import com.project.backend.security.jwt.JwtProvider;
import com.project.backend.security.service.RolService;
import com.project.backend.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserService userService;

    @Autowired
    RolService rolService;

    @Autowired
    JwtProvider jwtProvider;

    @PostMapping("/new")
    public ResponseEntity<?> nuevo(@Valid @RequestBody NewUser newUser, BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return new ResponseEntity(new Message("A field contains an error / invalid email"), HttpStatus.BAD_REQUEST);
        if(userService.existsByUsername(newUser.getUsername()))
            return new ResponseEntity(new Message("Name already exists"), HttpStatus.BAD_REQUEST);
        if(userService.existsByEmail(newUser.getEmail()))
            return new ResponseEntity(new Message("Email already exists"), HttpStatus.BAD_REQUEST);
        User user =
                new User(newUser.getName(), newUser.getUsername(), newUser.getEmail(),
                        passwordEncoder.encode(newUser.getPassword()));
        Set<Rol> roles = new HashSet<>();
        roles.add(rolService.getByRolNombre(NameRol.ROLE_USER).get());
        if(newUser.getRoles().contains("admin"))
            roles.add(rolService.getByRolNombre(NameRol.ROLE_ADMIN).get());
        user.setRoles(roles);
        userService.save(user);
        return new ResponseEntity(new Message("User saved"), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<JwtDto> login(@Valid @RequestBody UserLogin userLogin, BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return new ResponseEntity(new Message("A field contains an error"), HttpStatus.BAD_REQUEST);
        Authentication authentication =
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userLogin.getUsername(), userLogin.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtProvider.generateToken(authentication);
        UserDetails userDetails = (UserDetails)authentication.getPrincipal();
        JwtDto jwtDto = new JwtDto(jwt, userDetails.getUsername(), userDetails.getAuthorities());
        return new ResponseEntity(jwtDto, HttpStatus.OK);
    }
}
