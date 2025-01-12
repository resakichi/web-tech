package com.webtech.web.tech.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webtech.web.tech.Repository.StudentXMLSerialize;

@Service
public class UserServiceXML extends UserServiceList{

    @Autowired
    private StudentXMLSerialize serializer;

    
}
