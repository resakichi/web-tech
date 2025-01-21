package com.webtech.web.tech;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.junit.jupiter.api.Test;

import com.webtech.web.tech.Model.Student;
import com.webtech.web.tech.Model.StudentWrapper;
import com.webtech.web.tech.Repository.StudentXMLMarshall;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

public class TestXMLFile {

    public List<Student> createList(){

        List<Student> students = new ArrayList<>();
        
        Student student = new Student();
        student.setId(1);
        student.setName("Ivan");
        student.setSurname("Ivanov");
        student.setThirdName("Ivanovich");
        students.add(student);

        student = new Student();
        student.setId(1);
        student.setName("Ivan");
        student.setSurname("Ivanov");
        student.setThirdName("Ivanovich");
        students.add(student);

        return students;
    }

    @Test
    void testSerializeList() throws Exception{
        
        StudentWrapper wrapper = new StudentWrapper();
        wrapper.setStudents(createList());

 
        JAXBContext context = JAXBContext.newInstance(StudentWrapper.class, Student.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        
        StringWriter writer = new StringWriter();
        marshaller.marshal(wrapper, writer);

        
        System.out.println(writer.toString());

        try(FileWriter fileWriter = new FileWriter("src/main/resources/database.xml")){
            fileWriter.write(writer.toString());
        }
    }

    @Test
    void testUnserializeList() throws Exception{
        try (BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/database.xml"))) {
           

            JAXBContext context = JAXBContext.newInstance(StudentWrapper.class, Student.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();

            StudentWrapper wrapper = (StudentWrapper) unmarshaller.unmarshal(reader);            
            assertTrue(Objects.nonNull(wrapper));
            System.out.println(wrapper.getStudents().toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void testXMLRepository() throws Exception{
        var list = createList();

        var repository = new StudentXMLMarshall();

        assertTrue(repository.marshallList(list));

    }
}
