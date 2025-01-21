package com.webtech.web.tech.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "student")
@Entity
public class Student {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="STUDENT_NAME", length=50, nullable=false, unique=false)
    private String name;

    @Column(name="STUDENT_SURNAME", length=70, nullable=false, unique=false)
    private String surname;

    @Column(name="STUDENT_THIRDNAME", length=70, nullable=false, unique=false)
    private String thirdName;

    public Student(){}

    public Integer getId(){
        return id;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String secondName) {
        this.surname = secondName;
    }

    public String getThirdName() {
        return thirdName;
    }

    public void setThirdName(String thirdName) {
        this.thirdName = thirdName;
    }

    @Override
    public String toString(){
        return "{ \"ID\" : \""+ id +
        "\"\n\"Name\" : \"" + name + 
        "\"\n\"Surname\" : \"" + surname + 
        "\"\n\"Third name\" : \"" + thirdName + "\"}";
    }
}
