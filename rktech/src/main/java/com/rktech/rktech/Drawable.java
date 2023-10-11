////package com.rktech.rktech;
////
////public interface Drawable {
////        void draw();
////    }
////
////    // Circle class implementing the Drawable interface
////    class Circle implements Drawable {
////        @Override
////        public void draw() {
////            //demo implementation
////            System.out.println("Draw a circle");
////        }
////    }
/////////////////////////////////////////////////
////
////
////    public class Main {
////        public static void main(String[] args) {
////            Circle circle = new Circle();
////            circle.draw();
////        }
////    }
////
////
////
////
////import org.json.JSONArray;
////import org.json.JSONException;
////
////public class Main {
////    public static void main(String[] args) {
////        String json = "[\"apple\", \"banana\", \"cherry\"]";
////
////        try {
////            JSONArray js = new JSONArray(json);
////
////            // Extract values from array
////            for (int a = 0; a < js.length(); a++) {
////                String value = js.getString(a);
////                System.out.println("Value at index " + a + ": " + value);
////            }
////        } catch (JSONException e) {
////            e.printStackTrace();
////        }
////    }
////}
//
//
//
//////////////////////
//
//// Abstract Shape class
////abstract class Shape {
////    abstract double area();
////
////    void printInfo() {
////        System.out.println("This is a shape");
////    }
////}
////
////class Rectangle extends Shape {
////    private double length;
////    private double width;
////
////    public Rectangle(double length, double width) {
////        this.length = length;
////        this.width = width;
////    }
////
////    @Override
////    double area() {
////        return length * width;
////    }
////}
////
////public class Main {
////    public static void main(String[] args) {
////        Rectangle r = new Rectangle(4.0, 2.0);
////
////        // Using the area method and printInfo method
////        System.out.println("Rectangle Area: " + r.area());
////        r.printInfo();
////    }
////}
//
//
//import javax.xml.bind.annotation.XmlElement;
//import javax.xml.bind.annotation.XmlRootElement;
//
//@XmlRootElement
//public class Employee {
//    private String name;
//    private int age;
//    private String level;
//
//    @XmlElement
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    @XmlElement
//    public int getAge() {
//        return age;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }
//
//    @XmlElement
//    public String getLevel() {
//        return level;
//    }
//
//    public void setLevel(String level) {
//        this.level = level;
//    }
//}
//
/////////////////////////////////////////////
//
//import javax.xml.bind.JAXBContext;
//        import javax.xml.bind.JAXBException;
//        import javax.xml.bind.Marshaller;
//        import javax.xml.bind.Unmarshaller;
//        import java.io.StringReader;
//        import java.io.StringWriter;
//
//public class Main {
//    public static void main(String[] args) throws JAXBException {
//        // Marshalling (Java object to XML)
//        Employee student = new Employee();
//        student.setName("Sebe Tefiq");
//        student.setAge(25);
//        student.setLevel("A");
//
//        JAXBContext context = JAXBContext.newInstance(Employee.class);
//        Marshaller marshaller = context.createMarshaller();
//
//        StringWriter writer = new StringWriter();
//        marshaller.marshal(student, writer);
//        String xml = writer.toString();
//        System.out.println("Marshalled XML:\n" + xml);
//
//        // Unmarshalling (XML to Java object)
//        String xmlData = "<student><name>Sebe Tefiq</name><age>25</age><level>A</level></student>";
//
//        Unmarshaller unmarshaller = context.createUnmarshaller();
//        Employee unmarshalledStudent = (Employee) unmarshaller.unmarshal(new StringReader(xmlData));
//
//        System.out.println("\nUnmarshalled Employee:");
//        System.out.println("Name: " + unmarshalledStudent.getName());
//        System.out.println("Age: " + unmarshalledStudent.getAge());
//        System.out.println("Level: " + unmarshalledStudent.getLevel());
//    }
//}
//
//
//
//
//
/////////#######################///////////////////
//
////@XmlRootElement
////public class Employee {
////    private String name;
////    private int age;
////    private String level;
////
////    @XmlElement
////    public String getName() {
////        return name;
////    }
////
////    public void setName(String name) {
////        this.name = name;
////    }
////
////    @XmlElement
////    public int getAge() {
////        return age;
////    }
////
////    public void setAge(int age) {
////        this.age = age;
////    }
////
////    @XmlElement
////    public String getLevel() {
////        return level;
////    }
////
////    public void setLevel(String level) {
////        this.level = level;
////    }
////}
////
///////////////////////////////////////////////
////
////import javax.xml.bind.JAXBContext;
////        import javax.xml.bind.JAXBException;
////        import javax.xml.bind.Marshaller;
////        import javax.xml.bind.Unmarshaller;
////        import java.io.StringReader;
////        import java.io.StringWriter;
////
////public class Main {
////    public static void main(String[] args) throws JAXBException {
////        // Marshalling (Java object to XML)
////        Employee student = new Employee();
////        student.setName("Sebe Tefiq");
////        student.setAge(25);
////        student.setLevel("A");
////
////        JAXBContext context = JAXBContext.newInstance(Employee.class);
////        Marshaller marshaller = context.createMarshaller();
////
////        StringWriter writer = new StringWriter();
////        marshaller.marshal(student, writer);
////        String xml = writer.toString();
////        System.out.println("Marshalled XML:\n" + xml);
////
////        // Unmarshalling (XML to Java object)
////        String xmlData = "<student><name>Sebe Tefiq</name><age>25</age><level>A</level></student>";
////
////        Unmarshaller unmarshaller = context.createUnmarshaller();
////        Employee unmarshalledStudent = (Employee) unmarshaller.unmarshal(new StringReader(xmlData));
////
////        System.out.println("\nUnmarshalled Employee:");
////        System.out.println("Name: " + unmarshalledStudent.getName());
////        System.out.println("Age: " + unmarshalledStudent.getAge());
////        System.out.println("Level: " + unmarshalledStudent.getLevel());
////    }
////}
//
//
//public class BankAccount {
//    private String accountNumber;
//    private double balance;
//
//    public BankAccount(String accountNumber, double initialBalance) {
//        this.accountNumber = accountNumber;
//        this.balance = initialBalance;
//    }
//
//    public void deposit(double amount) {
//        if (amount > 0) {
//            balance += amount;
//            System.out.println("Deposited: " + amount);
//        } else {
//            System.out.println("Invalid deposit amount.");
//        }
//    }
//
//    public void withdraw(double amount) {
//        if (amount > 0 && amount <= balance) {
//            balance -= amount;
//            System.out.println("Withdrawn: " + amount);
//        } else {
//            System.out.println("Insufficient balance or invalid withdrawal amount.");
//        }
//    }
//
//    public double getBalance() {
//        return balance;
//    }
//
//    public static void main(String[] args) {
//        BankAccount account = new BankAccount("123456789", 1000.0);
//
//        System.out.println("Initial balance: " + account.getBalance());
//
//        account.deposit(500.0);
//        account.withdraw(300.0);
//        account.withdraw(1500.0); // This should fail due to insufficient balance
//
//        System.out.println("Final balance: " + account.getBalance());
//    }
//}
//
//
//
////    public double calculateAverageGrade(double[] grades) {
////        if (grades.length == 0) {
////            return 0.0;
////        }
////        double sum = 0;
////        for (double g : grades) {
////            sum += g;
////        }
////        return sum / grades.length;
////    }
//
//
//import org.json.JSONObject;
//
//public class Main {
//    public static void main(String[] args) {
//        String jsonData = "{\"name\":\"Alice\",\"age\":30,\"city\":\"New York\"}";
//
//        // Parse JSON data into a JSONObject
//        JSONObject jsonObject = new JSONObject(jsonData);
//
//        // Retrieve values from the JSONObject
//        String name = jsonObject.getString("name");
//        int age = jsonObject.getInt("age");
//        String city = jsonObject.getString("city");
//
//        // Create a Java object from the parsed data
//        Person person = new Person(name, age, city);
//
//        System.out.println("Parsed Java Object: " + person);
//    }
//}
//
//class Person {
//    private String name;
//    private int age;
//    private String city;
//
//    public Person(String name, int age, String city) {
//        this.name = name;
//        this.age = age;
//        this.city = city;
//    }
//
//    @Override
//    public String toString() {
//        return "Person{" +
//                "name='" + name + '\'' +
//                ", age=" + age +
//                ", city='" + city + '\'' +
//                '}';
//    }
//}
