package com.jaxb.jaxb.pojo;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;

@Data
@XmlAccessorType(value = XmlAccessType.FIELD)
@XmlRootElement(name = "department")
public class Department {
    @XmlElement(name = "name")
    private String name;
    @XmlElement(name = "manager")
    private Employee manager;

    @Override
    public String toString() {
        Employee emp = new Employee();
        //if(emp.getDepartment()  == null) {
        return "Department{" +
                "name='" + name + '\'' +
                ", manager=" + manager +
                '}';
    }
}