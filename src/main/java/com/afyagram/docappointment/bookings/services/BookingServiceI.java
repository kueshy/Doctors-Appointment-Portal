package com.afyagram.docappointment.bookings.services;

import com.afyagram.docappointment.bookings.Dto.AppointmentDto;
import com.afyagram.docappointment.bookings.entities.Bookings;

import java.util.List;

/**
 * Author:Zack Ogoma
 * Since v1.0.0
 */

public interface BookingServiceI {

    AppointmentDto saveBooking(Long patientId, AppointmentDto dto) throws Exception;

    List<Bookings> getBookings(Long doctorId) throws Exception;
}
