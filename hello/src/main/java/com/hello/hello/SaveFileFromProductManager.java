package com.hello.hello;

public class SaveFileFromProductManager {


//
//@Service
//public class ProductServiceImpl implements IProductService {
//
//
//    //for Has-A you have to create an @autowired to autowire the linkage but for Is-A you just implement or extend the  class
//    @Autowired
//    private final ProductRepository repo;
//
//
//    public ProductServiceImpl(ProductRepository repo) {
//        this.repo = repo;
//    }
//
//    @Override  //overridding method from the super class (service)
//    public Integer saveProduct(Product p) //saving the object of the class
//    {
//        CalculationUtil.blogic(p);
//        repo.save(p);
//
//        return p.getProdId();
//    }
//
//    @Override
//    public void updateProduct(Product p)
//    {
//        CalculationUtil.blogic(p);
//
//        repo.save(p);
//    }
//
//    @Override
//    public void deleteProduct(Integer id)
//    {
//        repo.delete(getOneProduct(id));
//    }
//
//    @Override
//    public Product getOneProduct(Integer id)
//    {
//        Optional<Product> opt =  repo.findById(id); //the use of Optional is to check null data, if not null then it will return back the data.
//        if(opt.isPresent())
//        {
//
//            return opt.get();
//        }
//        else
//        {
//            throw new ProductNotFoundException("Product " + id + " doesn't exist");
//        }
//
//    }
//
//    @Override
//    public List<Product> getAllProduct()
//    {
//
//        return repo.findAll();
//    }
//
//   @Override
//   @Transactional
//   public void updateproductCodeById(String code, Integer id)
//   {
//
//       if (!repo.existsById(id)) {
//           throw new ProductNotFoundException("Product " + id + " does not exist");
//       }
//       repo.updateproductCodeById(code,id);
//   }
//
//
//
//}

}
