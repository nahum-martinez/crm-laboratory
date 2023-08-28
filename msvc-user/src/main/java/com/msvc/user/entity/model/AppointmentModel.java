package com.msvc.user.entity.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentModel {
    private String idAppointment;
    private LocalDate date_appointment;
    private LocalTime hour_appointment;
    private String reason_appointment;
    private boolean isAttended = false;
    private int duration = 0;
    private String ipAddress;
}
