package com.rkProductManager.productManager.controller;

import com.rkProductManager.productManager.exception.ProductNotFoundException;
import com.rkProductManager.productManager.model.Product;
import com.rkProductManager.productManager.service.IProductService;
import com.rkProductManager.productManager.service.serviceImpl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("product")
public class ProductController {

    //for Has-A you have to create an @autowired to autowire the linkage but for Is-A you just implement or extend the  class
    @Autowired
    private IProductService service;


    @PostMapping("/save")
    public ResponseEntity<String> saveProduct (@RequestBody Product prod) {
        Integer id = service.saveProduct(prod);
        String data = "Product data saved " + id ;
        ResponseEntity<String> res = new ResponseEntity<String>(data, HttpStatus.CREATED);
        return res;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Product>> getAllProduct()
    {
        List <Product> list =  service.getAllProduct();
        ResponseEntity<List<Product>> rs = new ResponseEntity<List<Product>>(list, HttpStatus.OK);
        return rs;
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<?> getOneProduct(@PathVariable Integer id )
    {
        ResponseEntity<?> resp = null; //the ? is wildcard generic type because you're expecting diff data types from try-catch.
        try
        {
            Product prd = service.getOneProduct(id);
            resp = new ResponseEntity<Product>(prd, HttpStatus.OK);
        }
        catch(ProductNotFoundException pe)
        {
            pe.printStackTrace();
            resp = new ResponseEntity<String>(pe.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return resp;
    }

    @DeleteMapping("/delete/{id}")
    public  ResponseEntity<String> deleteOneProduct(@PathVariable Integer id)
    {
        ResponseEntity<String> respn = null;
        try
        {
         service.deleteProduct(id);
         respn = new ResponseEntity<String>("product removed " + id ,HttpStatus.OK);

        }
        catch (ProductNotFoundException pe)
        {
            pe.printStackTrace();
            respn = new ResponseEntity<String>(pe.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

        }

        return respn;
    }

    @PutMapping("/modify")
    public ResponseEntity<String> updateProduct(@RequestBody Product prd)
    {
        ResponseEntity<String> res = null;
        try
        {
            service.updateProduct(prd);
            res = new ResponseEntity<String> ("Product " + prd.getProdId() + " updated ", HttpStatus.OK);

        }
        catch (ProductNotFoundException pe)
        {
            pe.printStackTrace();
            res= new ResponseEntity<String>("Product Not Updated " , HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return res;
    }

    @PatchMapping("/update/{id}/{code}")
    public ResponseEntity<String> updateProductCode(@PathVariable Integer id, @PathVariable String code)
    {
        ResponseEntity<String> res = null;
        try
        {
            service.updateproductCodeById(code, id);
            res = new ResponseEntity<String>("Product " +id+ "updated with code", HttpStatus.OK );

        } catch (ProductNotFoundException pe) {

            pe.printStackTrace();
            res = new ResponseEntity<String>(pe.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

            return res;
    }

}
