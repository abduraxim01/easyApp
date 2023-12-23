package com.example.easyApp.service;

import com.example.easyApp.dto.StudentDTO;
import com.example.easyApp.mapper.StudentMapper;
import com.example.easyApp.model.Student;
import com.example.easyApp.repository.StudentRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository repository;

    public StudentDTO getById(Long id) throws EntityNotFoundException {
        return StudentMapper.toDTO(repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Entity not found by->" + id)));
    }

    public List<StudentDTO> getAll() {
        return StudentMapper.toDTO(repository.findAll());
    }

    public StudentDTO save(StudentDTO dto) {
        return StudentMapper.toDTO(repository.save(StudentMapper.toModel(dto)));
    }

    public void deleteById(Long id) throws EntityNotFoundException {
        Student model = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Entity not found by->" + id));

        repository.delete(model);
    }

}
