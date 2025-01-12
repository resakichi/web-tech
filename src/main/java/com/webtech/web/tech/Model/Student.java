package com.webtech.web.tech.Model;

import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "student")
public class Student {
    
    private Integer id;
    private String name;
    private String surname;
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
