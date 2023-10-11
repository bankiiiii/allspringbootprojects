package com.jaxb.jaxb.converter;

import com.jaxb.jaxb.mapper.EmployeeHelper;
import com.jaxb.jaxb.pojo.Employee;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

import java.io.File;

public class EmployeeUnmarshalling {

    public static void main(String[] args) throws JAXBException {

        //Unmarshaller
        JAXBContext jaxbContext = JAXBContext.newInstance(EmployeeHelper.xmlEmployeeObjects);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        File file = new File("employee.xml");
        Employee per = (Employee) unmarshaller.unmarshal(file);
        System.out.println(per.toString());

    }
}
