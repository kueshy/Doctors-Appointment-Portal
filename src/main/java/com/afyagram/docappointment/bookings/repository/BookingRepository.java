package com.afyagram.docappointment.bookings.repository;

import com.afyagram.docappointment.bookings.entities.Bookings;
import com.afyagram.docappointment.doctors.Entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Bookings, Long> {

    List<Bookings> findByDoctor(Doctor doctor);
}
