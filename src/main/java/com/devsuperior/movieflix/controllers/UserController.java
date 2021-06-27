package com.devsuperior.movieflix.controllers;

import com.devsuperior.movieflix.dto.UserDTO;
import com.devsuperior.movieflix.entities.User;
import com.devsuperior.movieflix.services.AuthService;
import com.devsuperior.movieflix.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users/profile")
public class UserController {

    @Autowired
    private UserService service;

    @Autowired
    private AuthService authService;

    @GetMapping
    public ResponseEntity<UserDTO> userLogged() {
        User user = authService.authenticated();
        return ResponseEntity.ok().body(new UserDTO(user));
    }

}
