package com.afyagram.docappointment.auth.controller;

import com.afyagram.docappointment.auth.dto.UserRegistartionDto;
import com.afyagram.docappointment.auth.services.UserRegistationI;
import com.afyagram.docappointment.roles.entities.Roles;
import com.afyagram.docappointment.roles.services.RolesServiceI;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author:Zack Ogoma
 * Since v1.0.0
 */
@RestController
@RequestMapping("/apis/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserRegistationI userRegistationI;

    @PostMapping("/register")
    public ResponseEntity<?> saveUser(@RequestBody UserRegistartionDto registartionDto) {
        try {
            UserRegistartionDto response = userRegistationI.registerUser(registartionDto);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }
}
