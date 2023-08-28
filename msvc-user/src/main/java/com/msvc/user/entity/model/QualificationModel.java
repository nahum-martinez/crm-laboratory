package com.msvc.user.entity.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class QualificationModel {
    private String qualificationId;
    private String userId;
    private String appointmentId;
    private int qualification;
    private String observations;

    private AppointmentModel appointment;
}
