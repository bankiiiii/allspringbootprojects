package com.rkProductManager.productManager.service.serviceImpl;

import com.rkProductManager.productManager.exception.ProductNotFoundException;
import com.rkProductManager.productManager.model.Product;
import com.rkProductManager.productManager.repo.ProductRepository;
import com.rkProductManager.productManager.service.IProductService;
import com.rkProductManager.productManager.util.CalculationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;





@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private  ProductRepository repo;

//    @Autowired
//    public ProductServiceImpl(ProductRepository repo) {
//        this.repo = repo;
//    }

    @Override
    public Integer saveProduct(Product p) {
        CalculationUtil.blogic(p);
        repo.save(p);
        return p.getProdId();
    }

    @Override
    public void updateProduct(Product p) {
        CalculationUtil.blogic(p);
        repo.save(p);
    }

    @Override
    public void deleteProduct(Integer id) {
        repo.delete(getOneProduct(id));
    }

    @Override
    public Product getOneProduct(Integer id) {
        Optional<Product> opt =  repo.findById(id);
        if (opt.isPresent()) {
            return opt.get();
        } else {
            throw new ProductNotFoundException("Product " + id + " doesn't exist");
        }
    }

    @Override
    public List<Product> getAllProduct() {
        return repo.findAll();
    }


    @Override
   @Transactional
   public void updateproductCodeById(String code, Integer id)
   {
//
//       if (!repo.existsById(id)) {
//           throw new ProductNotFoundException("Product " + id + " does not exist");
//       }
//       repo.updateproductCodeById(code,id);
   }
}










