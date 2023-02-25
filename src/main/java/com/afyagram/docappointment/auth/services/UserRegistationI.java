package com.afyagram.docappointment.auth.services;

import com.afyagram.docappointment.auth.dto.UserRegistartionDto;

/**
 * Author:Zack Ogoma
 * Since v1.0.0
 */

public interface UserRegistationI {

    public UserRegistartionDto registerUser(UserRegistartionDto registartionDto) throws Exception;
}
