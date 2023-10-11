package com.jaxb.jaxb.converter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jaxb.jaxb.pojo.Student;

import java.io.File;

public class JsonToJava {

    public static void main(String[] args) throws Exception{

        convertJsonToObjs();
        //convertJsonToObj();
    }

    public static void convertJsonToObj() throws Exception {
        File f = new File("student.json");
        ObjectMapper mapper = new ObjectMapper();
        Student student = mapper.readValue(" {\n" +
                " \"studId\" : 2,\n" +
                " \"studName\" : \"tao\",\n" +
                " \"studSkill\" : \"python\"\n" +
                "}",Student.class);
        System.out.println(student);

    }
        public static void convertJsonToObjs() throws Exception {
            File f = new File("student.json");
            ObjectMapper mapper = new ObjectMapper();
            Student[] students = mapper.readValue(f, Student[].class);
            for(Student s: students)
            System.out.println(s);
    }
}
