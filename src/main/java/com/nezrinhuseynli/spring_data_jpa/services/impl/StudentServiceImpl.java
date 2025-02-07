package com.nezrinhuseynli.spring_data_jpa.services.impl;

import com.nezrinhuseynli.spring_data_jpa.dto.request.StudentRequest;
import com.nezrinhuseynli.spring_data_jpa.dto.response.StudentResponse;
import com.nezrinhuseynli.spring_data_jpa.entities.Student;
import com.nezrinhuseynli.spring_data_jpa.enums.ErrorCodeEnum;
import com.nezrinhuseynli.spring_data_jpa.exception.StudentNotFoundException;
import com.nezrinhuseynli.spring_data_jpa.repository.StudentRepository;
import com.nezrinhuseynli.spring_data_jpa.services.IStudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements IStudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public void saveStudent(StudentRequest studentRequest) {
        Student student = new Student();

        BeanUtils.copyProperties(studentRequest, student);

        studentRepository.save(student);
    }

    @Override
    public List<StudentResponse> getAllStudents() {
        List<Student> students = studentRepository.findAll();

        List<StudentResponse> studentResponses = new ArrayList<>();

        for (Student student : students) {
            studentResponses.add(mapStudentToResponse(student));
        }
        return studentResponses;
    }

    @Override
    public StudentResponse getStudentById(Long id) {
        Optional<Student> optionalStudent = studentRepository.findById(id);

        if (optionalStudent.isPresent()) {
            Student student = optionalStudent.get();
            return mapStudentToResponse(student);
        } else {
            throw new StudentNotFoundException(ErrorCodeEnum.NO_RECORD_EXIST.getMessage());
        }
    }

    @Override
    public StudentResponse getStudentByNameAndSurname(String firstName, String lastName) {

        if(studentRepository.getStudentByNameAndSurname(firstName, lastName)==null){
            throw new StudentNotFoundException(ErrorCodeEnum.NO_RECORD_EXIST.getMessage());
        }
        Student student = studentRepository.getStudentByNameAndSurname(firstName, lastName);

        StudentResponse studentResponse = new StudentResponse();
        BeanUtils.copyProperties(student, studentResponse);
        return studentResponse;
    }

    @Override
    public void updateStudent(Long id, StudentRequest studentRequest) {
        Optional<Student> optionalStudent = studentRepository.findById(id);

        if (optionalStudent.isPresent()) {
            Student student = optionalStudent.get();

            BeanUtils.copyProperties(studentRequest, student);

            studentRepository.save(student);
        }
    }

    @Override
    public void deleteStudent(Long id) {

        studentRepository.deleteById(id);
    }

    private StudentResponse mapStudentToResponse(Student student) {
        StudentResponse studentResponse = new StudentResponse();
        BeanUtils.copyProperties(student, studentResponse);
        return studentResponse;
    }


}
