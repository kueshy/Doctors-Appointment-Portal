package com.afyagram.docappointment.auth.services;

import com.afyagram.docappointment.auth.repository.UserRegistationRepository;
import com.afyagram.docappointment.auth.dto.UserRegistartionDto;
import com.afyagram.docappointment.auth.entities.SystemUsers;
import com.afyagram.docappointment.doctors.Entity.Doctor;
import com.afyagram.docappointment.doctors.repository.DoctorRepository;
import com.afyagram.docappointment.patients.Patient;
import com.afyagram.docappointment.patients.repository.PatientRepository;
import com.afyagram.docappointment.roles.entities.Roles;
import com.afyagram.docappointment.roles.repository.RolesRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImp implements UserRegistationI {

    private final UserRegistationRepository userRegistationRepository;
    private final RolesRepository rolesRepository;
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;

    @Override
    public UserRegistartionDto registerUser(UserRegistartionDto registartionDto) throws Exception {
        Roles role = rolesRepository.findBySystemRoles(registartionDto.getRole());

        if (role != null) {
            SystemUsers user = SystemUsers.builder()
                    .name(registartionDto.getName())
                    .passWord(registartionDto.getPassWord())
                    .userName(registartionDto.getUserName())
                    .phoneNumber(registartionDto.getPhoneNumber())
                    .roles(role)
                    .build();
            user = userRegistationRepository.save(user);

            switch (registartionDto.getRole()) {
                case DOCTOR:
                    Doctor doctor = Doctor.of(registartionDto);
                    doctorRepository.save(doctor);
                    break;
                case PATIENT:
                    Patient patient = Patient.of(registartionDto);
                    patientRepository.save(patient);
            }
            if (user.getId() != null) {
                registartionDto.setId(user.getId());
            } else {
                throw new Exception("User not saved");
            }

        } else {
            throw new Exception("Role does not exist");
        }
        return registartionDto;
    }
}
