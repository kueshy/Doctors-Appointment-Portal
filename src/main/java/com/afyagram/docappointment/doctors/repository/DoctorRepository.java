package com.afyagram.docappointment.doctors.repository;

import com.afyagram.docappointment.doctors.Entity.Doctor;
import com.afyagram.docappointment.doctors.enums.Expertise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Author:Zack Ogoma
 * Since v1.0.0
 */
@Repository
public interface DoctorRepository  extends JpaRepository<Doctor,Long> {

    List<Doctor> findByExperteesName(Expertise expertise);
    List<Doctor> findByPractisingYears(Double years);



}

