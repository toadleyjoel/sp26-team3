package com.example.spartanStudy.service;

import com.example.spartanStudy.entity.DevLog;
import com.example.spartanStudy.repository.DevLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DevLogService {

    @Autowired
    private DevLogRepository devLogRepository;

    public DevLog createDevLog(DevLog devLog) {
        return devLogRepository.save(devLog);
    }

    public Optional<DevLog> getDevLogById(Long id) {
        return devLogRepository.findById(id);
    }

    public List<DevLog> getAllDevLogs() {
        return devLogRepository.findAll();
    }

    public List<DevLog> getDevLogsByAdminId(Long adminId) {
        return devLogRepository.findByAdminId(adminId);
    }

    public List<DevLog> getDevLogsByEntityType(String entityType) {
        return devLogRepository.findByEntityType(entityType);
    }

    public DevLog updateDevLog(Long id, DevLog devLogDetails) {
        return devLogRepository.findById(id).map(devLog -> {
            devLog.setAction(devLogDetails.getAction());
            devLog.setDetails(devLogDetails.getDetails());
            return devLogRepository.save(devLog);
        }).orElseThrow(() -> new RuntimeException("DevLog not found"));
    }

    public void deleteDevLog(Long id) {
        devLogRepository.deleteById(id);
    }
}