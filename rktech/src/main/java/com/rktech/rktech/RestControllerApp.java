package com.rktech.rktech;

import com.rktech.rktech.model.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class RestControllerApp {

    @GetMapping("/data/{name}/{id}")
    public ResponseEntity<String> getData(@PathVariable String name, @PathVariable Integer id ) {
        ResponseEntity<String> rs = new ResponseEntity<String>("hello data " + name + " " + id, HttpStatus.OK);
        return rs;
    }



    @RestController
    public class HelloWorldController {

        @GetMapping("/hello")
        public String helloWorld() {
            return "Hello, World!";
        }
    }

}






//@GetMapping("/show")
//    public ResponseEntity<String> getData() {
//        ResponseEntity<String> res = new ResponseEntity<String>("Welcome to rk",HttpStatus.OK);
//        return res;
//    }
//
//    @PostMapping("/create")
//    public  ResponseEntity<String> createData() {
//        ResponseEntity<String> res = new ResponseEntity<String>("from save", HttpStatus.OK);
//        return res;
//    }
//
//    @GetMapping("/find")
//    public  ResponseEntity<String> fetchData() {
//        ResponseEntity<String> res = new ResponseEntity<String>("from fetch", HttpStatus.OK);
//        return res;
//    }
//
//    @PutMapping("/modify")
//    public  ResponseEntity<String> updateData() {
//        ResponseEntity<String> res = new ResponseEntity<String>("from update", HttpStatus.OK);
//        return res;
//    }
//
//    @PatchMapping("/patch")
//    public  ResponseEntity<String> updateEmailData() {
//        ResponseEntity<String> res = new ResponseEntity<String>("from patch", HttpStatus.OK);
//        return res;
//    }
//
//    @DeleteMapping("/delete")
//    public  ResponseEntity<String> removeData() {
//        ResponseEntity<String> res = new ResponseEntity<String>("from delete", HttpStatus.OK);
//        return res;
//    }
//
//    @GetMapping("/show")
//    public ResponseEntity<Employee> fetchObject() {
//        ResponseEntity<Employee> res = new ResponseEntity<Employee>(new Employee(101, "banki", 200.00 ),HttpStatus.OK);
//        return res;
//    }