package com.jaxb.jaxb.pojo;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;

    @Data
    @XmlAccessorType(value = XmlAccessType.FIELD)
    @XmlRootElement(name = "address")
    public class Address {

        @XmlElement(name = "city")
        private String city;
        @XmlElement(name = "house-no")
        private String houseNo;
        @XmlElement(name = "postal-code")
        private String postalCode;
        @XmlElement(name = "state")
        private String state;


    }

