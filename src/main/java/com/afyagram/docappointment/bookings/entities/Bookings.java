package com.afyagram.docappointment.bookings.entities;

import com.afyagram.docappointment.bookings.enums.AppointmentCriticality;
import com.afyagram.docappointment.bookings.enums.Status;
import com.afyagram.docappointment.commons.identifiable.Auditable;
import com.afyagram.docappointment.doctors.Entity.Doctor;
import com.afyagram.docappointment.doctors.Entity.DoctorAvailability;
import com.afyagram.docappointment.patients.Patient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.Date;

/**
 * Author:Zack Ogoma
 * Since v1.0.0
 */
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Builder
@Table(name = "sys_bookings")
public class Bookings extends Auditable {

    @ManyToOne
    @JoinColumn(name = "dr")
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name = "patient")
    private Patient patient;

    @Column(name = "date")
    private Date date;

    @Column(name = "time_from")
    private String time_from;

    @Column(name = "time_to")
    private String time_to;

    @Column(name = "appointment_title")
    private String  appointmentTitle;

    @Column(name = "appointment_description")
    private String  appointmentDescription;

    @Column(name = "criticality")
    @Enumerated
    private AppointmentCriticality criticality;



}
