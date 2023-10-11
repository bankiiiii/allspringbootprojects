package com.jaxb.jaxb.pojo;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import jakarta.xml.bind.annotation.*;
import lombok.Data;

import java.io.File;
import java.io.StringWriter;


//import javax.xml.bind.annotation.XmlElement;
//import javax.xml.bind.annotation.XmlRootElement;

@Data
@XmlAccessorType(value = XmlAccessType.FIELD)
@XmlRootElement(name = "employee")
public class Employee {
    @XmlElement(name = "name")
    private String name;
    @XmlElement(name = "phone-number")
    private PhoneNumber phoneNumber;
    @XmlElement(name = "address")
    private Address address;
    @XmlElement(name = "department")
    private Department department;


    @Override
    public String toString() {
        if (address == null) {
            if (department == null) {
                return "Employee{" +
                        "name='" + name + '\'' +
                        ", phoneNumber=" + phoneNumber +
                        '}';
            } else {
                return "Employee{" +
                        "name='" + name + '\'' +
                        ", phoneNumber=" + phoneNumber +
                        ", department=" + department +
                        '}';
            }
        } else if (department == null) {
            return "Employee{" +
                    "name='" + name + '\'' +
                    ", phoneNumber=" + phoneNumber +
                    ", address=" + address +
                    '}';
        } else {
            return "Employee{" +
                    "name='" + name + '\'' +
                    ", phoneNumber=" + phoneNumber +
                    ", address=" + address +
                    ", department=" + department +
                    '}';
        }
    }
}