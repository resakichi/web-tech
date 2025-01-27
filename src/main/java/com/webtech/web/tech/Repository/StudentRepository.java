package com.webtech.web.tech.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.webtech.web.tech.Model.Student;

public interface StudentRepository extends CrudRepository<Student, Integer> {
    List<Student> findAll();
    Student findById(int id);

      @Query(value = "SELECT * FROM STUDENT WHERE STUDENT_NAME LIKE CONCAT('%', :parameter, '%')", nativeQuery=true)
    List<Student> filterByName(@Param("parameter") String parameter);

}
