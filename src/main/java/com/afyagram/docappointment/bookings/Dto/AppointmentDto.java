package com.afyagram.docappointment.bookings.Dto;

import com.afyagram.docappointment.bookings.enums.AppointmentCriticality;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Author:Zack Ogoma
 * Since v1.0.0
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class AppointmentDto {

    @JsonProperty(value = "id")
    private Long id;

    @JsonProperty(value = "dr")
    private Long doctorId;

    @JsonProperty(value = "date")
    private Date date;

    @JsonProperty(value = "time_from")
    private String time_from;

    @JsonProperty(value = "time_from")
    private String time_to;

    @JsonProperty(value = "appointment_title")
    private String appointmentTitle;

    @JsonProperty(value = "appointment_description")
    private String appointmentDescription;

    @JsonProperty(value = "criticality")
    private AppointmentCriticality criticality;
}
