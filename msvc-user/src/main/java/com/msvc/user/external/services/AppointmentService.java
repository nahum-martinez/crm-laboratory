package com.msvc.user.external.services;

import com.msvc.user.entity.model.AppointmentModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "msvc-appointment")
public interface AppointmentService {
    @GetMapping("/appointment/{appointmentId}")
    AppointmentModel getAppointment(@PathVariable String appointmentId);
}
