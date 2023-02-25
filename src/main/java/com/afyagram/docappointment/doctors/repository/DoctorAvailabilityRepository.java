package com.afyagram.docappointment.doctors.repository;

import com.afyagram.docappointment.bookings.enums.Status;
import com.afyagram.docappointment.doctors.Entity.Doctor;
import com.afyagram.docappointment.doctors.Entity.DoctorAvailability;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.Date;
import java.util.List;

/**
 * Author:Zack Ogoma
 * Since v1.0.0
 */
@Repository
public interface DoctorAvailabilityRepository extends JpaRepository<DoctorAvailability, Long> {

    Boolean existsByDoctorAndAvailableDateAndTimeFromAndTimeToAndStatus(Doctor doctor, Date date, String timeFrom, String timeTo, Status status);
}
