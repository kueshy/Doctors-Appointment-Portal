package com.afyagram.docappointment.doctors.Entity;

import com.afyagram.docappointment.bookings.enums.Status;
import com.afyagram.docappointment.commons.identifiable.Auditable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Builder
@Table(name = "booking_doctor_availability")
public class DoctorAvailability extends Auditable {

    @ManyToOne
    @JoinColumn(name = "dr")
    private Doctor doctor;

    @Column(name = "date")
    private Date availableDate;

    @Column(name = "time_from")
    private String timeFrom;

    @Column(name = "time_to")
    private String timeTo;

    @Column(name = "status")
    private Status status;
}
