package com.nezrinhuseynli.spring_data_jpa.controller.impl;

import com.nezrinhuseynli.spring_data_jpa.controller.IStudentController;
import com.nezrinhuseynli.spring_data_jpa.dto.request.StudentRequest;
import com.nezrinhuseynli.spring_data_jpa.dto.response.BaseResponse;
import com.nezrinhuseynli.spring_data_jpa.dto.response.StudentResponse;
import com.nezrinhuseynli.spring_data_jpa.services.IStudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "rest/api/student")
public class StudentControllerImpl implements IStudentController {

    @Autowired
    private IStudentService studentService;

    @PostMapping(path = "/save")
    @Override
    public BaseResponse saveStudent(@RequestBody @Valid StudentRequest studentRequest) {
        studentService.saveStudent(studentRequest);
        return BaseResponse.getSuccessMessage();
    }

    @GetMapping(path = "/get-students")
    @Override
    public List<StudentResponse> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping(path = "/get-student/{id}")
    @Override
    public StudentResponse getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    @GetMapping("/get-student")
    public StudentResponse getStudentByNameAndSurname(@RequestParam String firstName, @RequestParam String lastName){
        return studentService.getStudentByNameAndSurname(firstName,lastName);
    }

    @PutMapping(path = "/update/{id}")
    @Override
    public BaseResponse updateStudent(@PathVariable Long id, @RequestBody StudentRequest studentRequest) {
        studentService.updateStudent(id, studentRequest);
        return BaseResponse.getSuccessMessage();
    }

    @DeleteMapping(path = "/delete/{id}")
    @Override
    public BaseResponse deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return BaseResponse.getSuccessMessage();
    }


}
