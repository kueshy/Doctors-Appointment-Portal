package com.afyagram.docappointment.doctors.controllers;

import com.afyagram.docappointment.bookings.entities.Bookings;
import com.afyagram.docappointment.bookings.services.BookingServiceI;
import com.afyagram.docappointment.doctors.Entity.DoctorAvailability;
import com.afyagram.docappointment.doctors.Entity.DoctorExpertise;
import com.afyagram.docappointment.doctors.dtos.DocAvailabilityDto;
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
@RequestMapping("/apis/v1/doctors")
@RequiredArgsConstructor
public class DoctorsController {

    private final DoctorServiceI expertiseServiceI;
    private final BookingServiceI bookingServiceI;

    @PutMapping("/{id}/expertees")
    public ResponseEntity<?> addExpress(@PathVariable long id, @RequestBody List<DoctorExpertise> doctorExpertiseList) {
        try {
            List<DoctorExpertise> response = expertiseServiceI.saveAllExperstees(id, doctorExpertiseList);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @PostMapping("/{id}/availability")
    public ResponseEntity<?> addAvailability(@PathVariable long id, @RequestBody List<DocAvailabilityDto> docAvailabilityDtos) {
        try {
            List<DoctorAvailability> response = expertiseServiceI.addAvaialability(id, docAvailabilityDtos);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @GetMapping("/{id}/bookings")
    public ResponseEntity<?> getBookings(@PathVariable long id) {
        try {
            List<Bookings> response = bookingServiceI.getBookings(id);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }
}
