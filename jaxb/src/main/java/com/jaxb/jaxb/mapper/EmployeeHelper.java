package com.jaxb.jaxb.mapper;

import com.jaxb.jaxb.pojo.Address;
import com.jaxb.jaxb.pojo.Department;
import com.jaxb.jaxb.pojo.Employee;
import com.jaxb.jaxb.pojo.PhoneNumber;

public class EmployeeHelper {

    public static Class[] xmlEmployeeObjects = new Class<?>[]
            {
                    Employee.class, Department.class, Address.class, PhoneNumber.class
            };
}
