package com.afyagram.docappointment.doctors.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Author:Zack Ogoma
 * Since v1.0.0
 */

@Getter
@AllArgsConstructor
public enum Expertise {

    PREVENTIVE_MEDICINE(" Preventive medicine"),
    PSYCHATRY("Psychiatry"),
    RADIOLOGY_ONCOLOGY("Radiation oncology"),
    SURGERY("Surgery"),
    UROLOGY("Urology");

    private String description;

}
