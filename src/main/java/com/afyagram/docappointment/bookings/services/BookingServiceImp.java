package com.afyagram.docappointment.bookings.services;

import com.afyagram.docappointment.bookings.Dto.AppointmentDto;
import com.afyagram.docappointment.bookings.entities.Bookings;
import com.afyagram.docappointment.bookings.enums.Status;
import com.afyagram.docappointment.bookings.repository.BookingRepository;
import com.afyagram.docappointment.doctors.Entity.Doctor;
import com.afyagram.docappointment.doctors.repository.DoctorAvailabilityRepository;
import com.afyagram.docappointment.doctors.repository.DoctorRepository;
import com.afyagram.docappointment.patients.Patient;
import com.afyagram.docappointment.patients.repository.PatientRepository;
import lombok.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Author:Zack Ogoma
 * Since v1.0.0
 */
@Service
@RequiredArgsConstructor
public class BookingServiceImp implements BookingServiceI {

    private final BookingRepository bookingRepository;
    private final DoctorAvailabilityRepository availabilityRepository;
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;

    @Override
    public AppointmentDto saveBooking(Long patientId, AppointmentDto dto) throws Exception {
        Optional<Doctor> doctor = doctorRepository.findById(dto.getDoctorId());
        Optional<Patient> patient = patientRepository.findById(patientId);
        if (doctor.isPresent() && patient.isPresent()) {
            Boolean status = availabilityRepository.existsByDoctorAndAvailableDateAndTimeFromAndTimeToAndStatus(doctor.get(),
                    dto.getDate(), dto.getTime_from(), dto.getTime_to(), Status.AVAILABLE);
            if (status) {
                Bookings booking = Bookings.builder()
                        .appointmentDescription(dto.getAppointmentDescription())
                        .appointmentTitle(dto.getAppointmentTitle())
                        .criticality(dto.getCriticality())
                        .date(dto.getDate())
                        .doctor(doctor.get())
                        .patient(patient.get())
                        .criticality(dto.getCriticality())
                        .build();
                booking = bookingRepository.save(booking);
                if (booking.getId() != null) {
                    dto.setId(booking.getId());
                }

            } else {
                throw new Exception("Appointment cant be booked");
            }

        } else {
            throw new Exception("Dr/Patient not found");
        }
        return dto;
    }

    @Override
    public List<Bookings> getBookings(Long doctorId) throws Exception {
        Optional<Doctor> doctor = doctorRepository.findById(doctorId);
        List<Bookings> bookings = null;
        if (doctor.isPresent()) {
            bookings.addAll(bookingRepository.findByDoctor(doctor.get()));

        } else {
            throw new Exception("Dr not found");
        }
        return bookings;
    }
}
