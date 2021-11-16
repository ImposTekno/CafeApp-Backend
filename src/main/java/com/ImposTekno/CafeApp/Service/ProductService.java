package com.ImposTekno.CafeApp.Service;

import com.ImposTekno.CafeApp.CustomExceptions.ProductNotFoundException;
import com.ImposTekno.CafeApp.Model.Product;
import com.ImposTekno.CafeApp.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepo;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepo = productRepository;
    }

    //Setter of a list of products to a product repository <-- depends on a  private collection of products
    public Product addProduct(Product newProd)
    {
       return productRepo.save(newProd);
    }

    //Get a product by a name attribute
    public Product getProductByName(String _name) {
       return productRepo.findByProductName(_name);
    }

    // Getter for all products from product repository **
    public List<Product> getAllProducts()
    {
        return productRepo.findAll();
    }

    // Update method for existing product
    public Product updateProduct(Product updateProd)
    {
        return productRepo.save(updateProd);
    }

    // Delete product by provided id
    public void deleteById(Long id)
    {
        productRepo.deleteById(id);
    }


}
