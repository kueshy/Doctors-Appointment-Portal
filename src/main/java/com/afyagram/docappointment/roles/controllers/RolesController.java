package com.afyagram.docappointment.roles.controllers;


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
@RequestMapping("/apis/v1/roles")
@RequiredArgsConstructor
public class RolesController {

    private final RolesServiceI rolesServiceI;

    @PostMapping
    public ResponseEntity<?> saveRole(@RequestBody Roles role) {
        try {
            Roles response = rolesServiceI.saveRole(role);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }
}
