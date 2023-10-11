package com.rkProductManager.productManager.repo;

import com.rkProductManager.productManager.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

//    @Modifying
//    @Query(value = "UPDATE prd_tab SET p_code=code WHERE p_id=:id", nativeQuery = true)
//    public  void updateproductCodeById(String code, Integer id);


}
