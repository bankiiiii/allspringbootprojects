package com.jaxb.jaxb;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.io.File;
import java.io.StringWriter;

@XmlRootElement
public class Person {
    private String name;
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @XmlElement
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) throws JAXBException {
        Person person = new Person();
        person.setName("John Doe");
        person.setAge(30);

        JAXBContext context = JAXBContext.newInstance((Person.class));
        Marshaller marshaller = context.createMarshaller();

        StringWriter writer = new StringWriter();
        marshaller.marshal(person, writer);

        System.out.println(writer.toString());

        //Unmarshall
        Unmarshaller unmarshaller = context.createUnmarshaller();
       // String personStr = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><person><age>30</age><name>John Doe</name></person>";

        File file = new File("person.xml");

        Person per = (Person)unmarshaller.unmarshal(file);

        System.out.println(per.toString());

    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
