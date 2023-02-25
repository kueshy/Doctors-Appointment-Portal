package com.afyagram.docappointment.doctors.services;

import com.afyagram.docappointment.doctors.Entity.Doctor;
import com.afyagram.docappointment.doctors.Entity.DoctorAvailability;
import com.afyagram.docappointment.doctors.Entity.DoctorExpertise;
import com.afyagram.docappointment.doctors.dtos.DocAvailabilityDto;
import com.afyagram.docappointment.doctors.enums.Expertise;

import java.util.List;

public interface DoctorServiceI {

    List<DoctorExpertise> getAllExpertise();

    DoctorExpertise saveExpertise(Long id, DoctorExpertise expertise);

    List<DoctorExpertise> saveAllExperstees(Long id,List<DoctorExpertise> expertise);

    List<Doctor> findAllDoctors();

    List<Doctor> findDoctorByExpertees(Expertise expertise);

    List<Doctor> findDoctorByPractisingYears(Double years);

    List<DoctorAvailability> addAvaialability(Long doctorId, List<DocAvailabilityDto> docAvailabilityDtos) throws Exception;

}
