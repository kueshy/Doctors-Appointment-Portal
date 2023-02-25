package com.afyagram.docappointment.auth.dto;

import com.afyagram.docappointment.roles.enums.SystemRoles;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Author:Zack Ogoma
 * Since v1.0.0
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserRegistartionDto {

    @JsonProperty(value = "id")
    private Long  id;

    @JsonProperty(value = "name")
    private String  name;

    @JsonProperty(value = "phone_no")
    private String  phoneNumber;

    @JsonProperty(value = "username")
    private String  userName;

    @JsonProperty(value = "password")
    private String  passWord;

    @JsonProperty(value = "role")
    private SystemRoles role;

    @JsonProperty(value = "practising_years")
    private Double practisingYears;
}
