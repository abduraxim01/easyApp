package com.example.easyApp.mapper;

import com.example.easyApp.dto.StudentDTO;
import com.example.easyApp.model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentMapper {

    public static StudentDTO toDTO(Student model) {
        StudentDTO dto = new StudentDTO();

        dto.setId(model.getId());
        dto.setName(model.getName());
        dto.setGpa(model.getGpa());
        return dto;
    }

    public static Student toModel(StudentDTO dto) {
        Student model = new Student();

        model.setId(dto.getId());
        model.setName(dto.getName());
        model.setGpa(dto.getGpa());
        return model;
    }

    public static List<StudentDTO> toDTO(List<Student> models) {
        List<StudentDTO> dtos = new ArrayList<>();

        for (Student model : models) {
            dtos.add(StudentMapper.toDTO(model));
        }
        return dtos;
    }
}
