package com.msvc.user.external.services;

import com.msvc.user.entity.model.QualificationModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient(name = "msvc-qualification")
public interface QualificationService {
    @PostMapping("/qualification")
    public ResponseEntity<QualificationModel> newQualification(QualificationModel qualification);

    @PutMapping("/qualification/{qualificationId}")
    public ResponseEntity<QualificationModel> updateQualification(@PathVariable String qualificationId, QualificationModel qualification);

    @DeleteMapping("/qualification/{qualificationId}")
    public void deleteQualification(@PathVariable String qualificationId);
}
