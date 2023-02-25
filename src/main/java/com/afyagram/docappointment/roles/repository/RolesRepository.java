package com.afyagram.docappointment.roles.repository;

import com.afyagram.docappointment.roles.entities.Roles;
import com.afyagram.docappointment.roles.enums.SystemRoles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Author:Zack Ogoma
 * Since v1.0.0
 */
@Repository
public interface RolesRepository extends JpaRepository<Roles,Long> {

    Roles findBySystemRoles(SystemRoles systemRoles);
}
