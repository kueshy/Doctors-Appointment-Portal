package com.afyagram.docappointment.patients.controllers;

import com.afyagram.docappointment.bookings.Dto.AppointmentDto;
import com.afyagram.docappointment.bookings.entities.Bookings;
import com.afyagram.docappointment.bookings.services.BookingServiceI;
import com.afyagram.docappointment.doctors.Entity.Doctor;
import com.afyagram.docappointment.doctors.enums.Expertise;
import com.afyagram.docappointment.doctors.services.DoctorServiceI;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Author:Zack Ogoma
 * Since v1.0.0
 */
@RestController
@RequestMapping("/apis/v1/patients")
@RequiredArgsConstructor
public class PatientController {

    private final DoctorServiceI doctorServiceI;
    private final BookingServiceI bookingServiceI;


    @GetMapping("/doctors")
    public ResponseEntity<?> getAllDoctors() {
        try {
            List<Doctor> response = doctorServiceI.findAllDoctors();
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @GetMapping("/doctors/query")
    public ResponseEntity<?> getAllDoctorByExpertees(@RequestParam Expertise expertise, @RequestParam Double years) {
        try {
            List<Doctor> response = doctorServiceI.findDoctorByExpertees(expertise);
            response.addAll(doctorServiceI.findDoctorByPractisingYears(years));
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @PostMapping("/{id}/book")
    public ResponseEntity<?> bookAppointment(@PathVariable Long id, @RequestParam AppointmentDto dto) {
        try {
            AppointmentDto response = bookingServiceI.saveBooking(id, dto);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }


}
