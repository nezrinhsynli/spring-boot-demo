package com.nezrinhuseynli.spring_data_jpa.controller;

import com.nezrinhuseynli.spring_data_jpa.dto.request.StudentRequest;
import com.nezrinhuseynli.spring_data_jpa.dto.response.BaseResponse;
import com.nezrinhuseynli.spring_data_jpa.dto.response.StudentResponse;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface IStudentController {

    BaseResponse saveStudent(StudentRequest studentRequest);

    List<StudentResponse> getAllStudents();

    StudentResponse getStudentById(Long id);

    StudentResponse getStudentByNameAndSurname(@RequestParam String firstName, @RequestParam String lastName);

    BaseResponse updateStudent(Long id, StudentRequest studentRequest);

    BaseResponse deleteStudent(Long id);



}
