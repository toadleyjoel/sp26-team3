package com.example.spartanStudy.controller;

import com.example.spartanStudy.entity.DevLog;
import com.example.spartanStudy.service.DevLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/dev-logs")
public class DevLogController {

    @Autowired
    private DevLogService devLogService;

    @PostMapping
    public ResponseEntity<DevLog> createDevLog(@RequestBody DevLog devLog) {
        DevLog createdDevLog = devLogService.createDevLog(devLog);
        return new ResponseEntity<>(createdDevLog, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<DevLog>> getAllDevLogs() {
        List<DevLog> devLogs = devLogService.getAllDevLogs();
        return new ResponseEntity<>(devLogs, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DevLog> getDevLogById(@PathVariable Long id) {
        Optional<DevLog> devLog = devLogService.getDevLogById(id);
        return devLog.map(log -> new ResponseEntity<>(log, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/admin/{adminId}")
    public ResponseEntity<List<DevLog>> getDevLogsByAdminId(@PathVariable Long adminId) {
        List<DevLog> devLogs = devLogService.getDevLogsByAdminId(adminId);
        return new ResponseEntity<>(devLogs, HttpStatus.OK);
    }

    @GetMapping("/entity-type/{entityType}")
    public ResponseEntity<List<DevLog>> getDevLogsByEntityType(@PathVariable String entityType) {
        List<DevLog> devLogs = devLogService.getDevLogsByEntityType(entityType);
        return new ResponseEntity<>(devLogs, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DevLog> updateDevLog(@PathVariable Long id, @RequestBody DevLog devLogDetails) {
        try {
            DevLog updatedDevLog = devLogService.updateDevLog(id, devLogDetails);
            return new ResponseEntity<>(updatedDevLog, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDevLog(@PathVariable Long id) {
        devLogService.deleteDevLog(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}