package com.jaxb.jaxb.pojo;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;

    @Data
    @XmlAccessorType(value = XmlAccessType.FIELD)
    @XmlRootElement(name = "phone-number")

    public class PhoneNumber {
        @XmlElement(name = "work")
        private String work;
        @XmlElement(name = "home")
        private String home;

        @Override
        public String toString() {
            if(home != null) {
                return "PhoneNumber{" +
                        "work='" + work + '\'' +
                        ", home='" + home + '\'' +
                        '}';
            }else {
                return "PhoneNumber{" +
                        "work='" + work + '\'' +
                        '}';

            }
        }
    }
