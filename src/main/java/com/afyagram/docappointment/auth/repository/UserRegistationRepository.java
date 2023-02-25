package com.afyagram.docappointment.auth.repository;

import com.afyagram.docappointment.auth.entities.SystemUsers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRegistationRepository extends JpaRepository<SystemUsers,Long> {
}
