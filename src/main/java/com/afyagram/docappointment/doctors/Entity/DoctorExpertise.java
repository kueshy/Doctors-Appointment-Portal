package com.afyagram.docappointment.doctors.Entity;

import com.afyagram.docappointment.commons.identifiable.Auditable;
import com.afyagram.docappointment.doctors.enums.Expertise;
import com.afyagram.docappointment.roles.enums.SystemRoles;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Author:Zack Ogoma
 * Since v1.0.0
 */
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Builder
@Table(name = "usr_doctor_expertise")
public class DoctorExpertise extends Auditable {

    @Column(name = "name")
    @Enumerated
    private Expertise name;

}
