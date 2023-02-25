package com.afyagram.docappointment.patients.repository;

import com.afyagram.docappointment.patients.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Author:Zack Ogoma
 * Since v1.0.0
 */
public interface PatientRepository  extends JpaRepository<Patient,Long> {
}
