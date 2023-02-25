package com.afyagram.docappointment.doctors.dtos;

import com.afyagram.docappointment.doctors.Entity.Doctor;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class DocAvailabilityDto {


    @JsonProperty(value =  "date")
    private Date availableDate;

    @JsonProperty(value =  "time_from")
    private String timeFrom;

    @JsonProperty(value = "time_to")
    private String timeTo;
}
