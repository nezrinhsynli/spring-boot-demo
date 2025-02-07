package com.nezrinhuseynli.spring_data_jpa.services;

import com.nezrinhuseynli.spring_data_jpa.dto.request.StudentRequest;
import com.nezrinhuseynli.spring_data_jpa.dto.response.StudentResponse;

import java.util.List;

public interface IStudentService {

     void saveStudent(StudentRequest studentRequest);

     List<StudentResponse> getAllStudents();

     StudentResponse getStudentById(Long id);

     StudentResponse getStudentByNameAndSurname(String firstName, String lastName);

     void updateStudent(Long id, StudentRequest studentRequest);

     void deleteStudent(Long id);


}
