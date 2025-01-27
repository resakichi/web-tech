package com.webtech.web.tech.Repository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.List;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.webtech.web.tech.Model.Student;
import com.webtech.web.tech.Model.StudentWrapper;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

@Component
@Lazy
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class StudentXMLMarshall {
    
    private final String filename = "src/main/resources/database.xml";

    public boolean marshallList(List<Student> data){
        StudentWrapper wrapper = new StudentWrapper();
        wrapper.setStudents(data);
        try {
            JAXBContext context = JAXBContext.newInstance(StudentWrapper.class, Student.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            StringWriter writer = new StringWriter();
            marshaller.marshal(wrapper, writer);

            try (FileWriter fileWriter = new FileWriter(filename)) {
                fileWriter.write(writer.toString());

            }catch(IOException e){
                e.printStackTrace();
                return false;
            }
        } catch (JAXBException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public List<Student> unmarshallList(){

        try(BufferedReader reader = new BufferedReader(new FileReader(filename))){

            JAXBContext context = JAXBContext.newInstance(StudentWrapper.class, Student.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();

            StudentWrapper wrapper = (StudentWrapper) unmarshaller.unmarshal(reader);
            return wrapper.getStudents();
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }

    }
}
