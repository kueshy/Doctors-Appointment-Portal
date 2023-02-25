package com.afyagram.docappointment.doctors.services;

import com.afyagram.docappointment.bookings.enums.Status;
import com.afyagram.docappointment.doctors.Entity.Doctor;
import com.afyagram.docappointment.doctors.Entity.DoctorAvailability;
import com.afyagram.docappointment.doctors.Entity.DoctorExpertise;
import com.afyagram.docappointment.doctors.dtos.DocAvailabilityDto;
import com.afyagram.docappointment.doctors.enums.Expertise;
import com.afyagram.docappointment.doctors.repository.DoctorAvailabilityRepository;
import com.afyagram.docappointment.doctors.repository.DoctorExperticeRepository;
import com.afyagram.docappointment.doctors.repository.DoctorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Author:Zack Ogoma
 * Since v1.0.0
 */
@Service
@RequiredArgsConstructor
public class DoctorServiceImp implements DoctorServiceI {

    private final DoctorExperticeRepository doctorExperticeRepository;
    private final DoctorRepository doctorRepository;
    private final DoctorAvailabilityRepository doctorAvailabilityRepository;

    @Override
    public List<DoctorExpertise> getAllExpertise() {
        return doctorExperticeRepository.findAll();
    }

    @Override
    public DoctorExpertise saveExpertise(Long id, DoctorExpertise expertise) {
        return doctorExperticeRepository.save(expertise);
    }

    @Override
    public List<DoctorExpertise> saveAllExperstees(Long id, List<DoctorExpertise> expertise) {
        return doctorExperticeRepository.saveAll(expertise);
    }

    @Override
    public List<Doctor> findAllDoctors() {
        return doctorRepository.findAll();
    }

    @Override
    public List<Doctor> findDoctorByExpertees(Expertise expertise) {
        return doctorRepository.findByExperteesName(expertise);
    }

    @Override
    public List<Doctor> findDoctorByPractisingYears(Double years) {
        return doctorRepository.findByPractisingYears(years);
    }

    @Override
    public List<DoctorAvailability> addAvaialability(Long doctorId, List<DocAvailabilityDto> docAvailabilityDtos) throws Exception {
        Optional<Doctor> doctor = doctorRepository.findById(doctorId);
        List<DoctorAvailability> doctorAvailabilities = new ArrayList<>();

        if (doctor.isPresent()) {
            for (DocAvailabilityDto dto : docAvailabilityDtos) {
                DoctorAvailability doctorAvailability = DoctorAvailability.builder()
                        .doctor(doctor.get())
                        .availableDate(dto.getAvailableDate())
                        .timeFrom(dto.getTimeFrom())
                        .timeTo(dto.getTimeTo())
                        .status(Status.AVAILABLE)
                        .build();
                doctorAvailability=doctorAvailabilityRepository.save(doctorAvailability);
                doctorAvailabilities.add(doctorAvailability);

            }

        } else {
            throw new Exception("Doctor not found");
        }
        return doctorAvailabilities;
    }

}
