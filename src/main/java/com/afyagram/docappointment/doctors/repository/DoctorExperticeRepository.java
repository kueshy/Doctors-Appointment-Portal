package com.afyagram.docappointment.doctors.repository;

import com.afyagram.docappointment.doctors.Entity.DoctorExpertise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Author:Zack Ogoma
 * Since v1.0.0
 */
@Repository
public interface DoctorExperticeRepository extends JpaRepository<DoctorExpertise ,Long> {
}
