package com.afyagram.docappointment.roles.services;

import com.afyagram.docappointment.roles.entities.Roles;
import com.afyagram.docappointment.roles.repository.RolesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;

/**
 * Author:Zack Ogoma
 * Since v1.0.0
 */
@Service
@RequiredArgsConstructor
public class RolesRegistrationService  implements   RolesServiceI{

    private final RolesRepository rolesRepository;

    @Transactional
    @Override
    public Roles saveRole(Roles role) {
        return rolesRepository.save(role);
    }


}
