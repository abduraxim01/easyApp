package com.example.easyApp.controller;

import com.example.easyApp.dto.StudentDTO;
import com.example.easyApp.service.StudentService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Component
@RestController
@RequestMapping(value = "/api/v1/studentController", produces = MediaType.APPLICATION_JSON_VALUE)

public class StudentController {

    @Autowired
    StudentService service;

    // id bo'yicha student qidirish

    @GetMapping(value = "/{id}")
    public ResponseEntity<StudentDTO> getById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(service.getById(id));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // barcha studentlarni topish

    @GetMapping
    public ResponseEntity<List<StudentDTO>> getAll() {
        try {
            return ResponseEntity.ok(service.getAll());
        } catch (EntityNotFoundException e) {
            return ResponseEntity.noContent().build();
        }
    }

    // student kiritish

    @PostMapping
    public ResponseEntity<StudentDTO> save(@RequestBody StudentDTO dto) {
        try {
            return ResponseEntity.ok(service.save(dto));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    // id orqali student o'chirish

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable(name = "id") Long id) {
        try {
            service.deleteById(id);
            return ResponseEntity.ok().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

}
