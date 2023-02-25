package com.afyagram.docappointment.patients;

import com.afyagram.docappointment.auth.dto.UserRegistartionDto;
import com.afyagram.docappointment.auth.entities.SystemUsers;
import com.afyagram.docappointment.commons.identifiable.Auditable;
import com.afyagram.docappointment.doctors.Entity.Doctor;
import com.afyagram.docappointment.doctors.Entity.DoctorExpertise;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
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
@Table(name = "usr_patient")
public class Patient extends Auditable {

    @Column(name = "patient_name")
    private String patientName;

    @Column(name = "patient_phone_no")
    private String phoneNumber;

    public static Patient of(UserRegistartionDto user) {
        Patient patient = Patient.builder()
                .patientName(user.getName())
                .phoneNumber(user.getPhoneNumber())
                .build();
        return patient;

    }
}
