package com.nezrinhuseynli.spring_data_jpa.repository;

import com.nezrinhuseynli.spring_data_jpa.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query(value = "select * from students.students where first_name = ?1 and last_name = ?2", nativeQuery = true)
    Student getStudentByNameAndSurname(String firstName, String lastName);


}
