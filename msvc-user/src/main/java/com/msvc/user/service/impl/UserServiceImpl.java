package com.msvc.user.service.impl;

import com.msvc.user.entity.UserEntity;
import com.msvc.user.entity.model.AppointmentModel;
import com.msvc.user.entity.model.QualificationModel;
import com.msvc.user.exception.ResourceNotFoundException;
import com.msvc.user.external.services.AppointmentService;
import com.msvc.user.repository.IUserRepository;
import com.msvc.user.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements IUserService {
    private final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private IUserRepository userRepository;

    @Override
    public UserEntity saveUser(UserEntity userEntity) {
        String randomUserId = UUID.randomUUID().toString();
        userEntity.setIdUser(randomUserId);
        return userRepository.save(userEntity);
    }

    @Override
    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public UserEntity getUser(String userId) {
        UserEntity user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with ID: " + userId));

        /*QualificationModel[] getQualificationUser = restTemplate.getForObject("http://msvc-qualification/qualification/user/" + user.getIdUser()
                , QualificationModel[].class);*/
        // logger.info("{}", (Object) getQualificationUser);

        // List<QualificationModel> qualifications = Arrays.stream(getQualificationUser).collect(Collectors.toList());

        /*List<QualificationModel> listQualificationsUser = qualifications.stream().map(qualification -> {
            System.out.println(qualification.getAppointmentId());
            // ResponseEntity<AppointmentModel> forEntity = restTemplate.getForEntity("http://msvc-appointment/appointment/" + qualification.getAppointmentId()
               //     , AppointmentModel.class);
            AppointmentModel appointment = appointmentService.getAppointment(qualification.getAppointmentId());
            // AppointmentModel appointment = forEntity.getBody();
            // logger.info("Response with code status : {}", forEntity.getStatusCode());
            qualification.setAppointment(appointment);
            return qualification;
        }).collect(Collectors.toList());*/

        // logger.info("{}", listQualificationsUser);
        // user.setQualifications(listQualificationsUser);
        return user;
    }
}
