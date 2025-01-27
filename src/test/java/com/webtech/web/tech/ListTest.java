package com.webtech.web.tech;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.util.ObjectUtils;

import com.webtech.web.tech.Model.Student;
import com.webtech.web.tech.Service.UserServiceList;

public class ListTest {
    private static Student student;
    
    public static void setStudent (){
        student = new Student();
        student.setId(Integer.valueOf(1));
        student.setName("Иван");
        student.setSurname("Иванов");
        student.setThirdName("Иванович");
    }

    @Test
    void getTest(){
        setStudent();
        UserServiceList list = new UserServiceList();
        list.addStudent(student);

        var test = new Student();
        test.setId(Integer.valueOf(1));
        test.setName("Petya");
        test.setSurname("petrov");
        test.setThirdName("testovich");
        list.addStudent(test);
        
        assertTrue(list.getStudent(student.getId()).equals(student));
        assertEquals(test, list.getStudents(test.getName()).get(0));
    }

    @Test
    void addTest(){
        setStudent();
        UserServiceList list = new UserServiceList();
        list.addStudent(student);
        assertTrue(list.getStudent(student.getId()).equals(student));
    }

    @Test
    void editTest(){
        setStudent();
        UserServiceList list = new UserServiceList();
        list.addStudent(student);
        student.setName("TEST");
        assertTrue(list.getStudent(student.getId()).equals(student));
    }

    @Test
    void deleteTest(){
        setStudent();
        UserServiceList list = new UserServiceList();
        list.addStudent(student);
        list.deleteStudent(student.getId());
        assertTrue(ObjectUtils.isEmpty(list.getStudent(student.getId())));
    }

}
