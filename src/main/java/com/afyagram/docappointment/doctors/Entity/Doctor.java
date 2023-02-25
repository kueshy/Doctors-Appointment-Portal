package com.afyagram.docappointment.doctors.Entity;

import com.afyagram.docappointment.auth.dto.UserRegistartionDto;
import com.afyagram.docappointment.auth.entities.SystemUsers;
import com.afyagram.docappointment.commons.identifiable.Auditable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

/**
 * Author:Zack Ogoma
 * Since v1.0.0
 */
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Builder
@Table(name = "usr_doctor")
public class Doctor extends Auditable {

    @Column(name = "doctor_name")
    private String doctorName;

    @Column(name = "doctor_phone_no")
    private String phoneNumber;

    @Column(name = "doctor_years_of_experience")
    private Double practisingYears;

    @ManyToOne
    @JoinColumn(name = "doctor_expertees")
    private DoctorExpertise expertees;


    public static Doctor of(UserRegistartionDto user) {
        Doctor doctor = Doctor.builder()
                .doctorName(user.getName())
                .phoneNumber(user.getPhoneNumber())
                .practisingYears(user.getPractisingYears())
                .build();
        return doctor;
    }


}
