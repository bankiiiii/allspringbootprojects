package com.jaxb.jaxb.converter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jaxb.jaxb.pojo.Student;

import java.util.ArrayList;
import java.util.List;

public class JavaToJsonCon {

    public static void main(String[] args) throws JsonProcessingException {
        Student s1 = new Student();
        s1.setStudId(1);
        s1.setStudName("yoma");
        s1.setStudSkill("javascript");


        Student s2 = new Student();
        s2.setStudId(2);
        s2.setStudName("tao");
        s2.setStudSkill("python");

        List <Student> slist = new ArrayList<>();
        slist.add(s1);
        slist.add(s2);

        ObjectMapper mapper = new ObjectMapper();
        String studJsn = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(slist);

        System.out.println(studJsn);
    }
}
