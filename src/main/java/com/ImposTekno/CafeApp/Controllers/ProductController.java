package com.ImposTekno.CafeApp.Controllers;

import com.ImposTekno.CafeApp.Model.Product;
import com.ImposTekno.CafeApp.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService prodService;

    @Autowired
    public ProductController(ProductService prodServ)
    {
        this.prodService = prodServ;
    }


    @GetMapping("/all")
    public ResponseEntity<List<Product>> getAllProducts()
    {
        List<Product> products = prodService.getAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/find/{name}")
    public ResponseEntity<Product> getProductByName(@PathVariable("name") String _name)
    {
        Product prod = prodService.getProductByName(_name);
        return new ResponseEntity<>(prod, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Product> addProduct(@RequestBody Product newProd)
    {
        Product newProduct = prodService.addProduct(newProd);
        return new ResponseEntity<>(newProduct, HttpStatus.CREATED);
    }

    @PostMapping("/multiple")
    public ResponseEntity<List<Product>> addMultipleProducts(@RequestBody List<Product> _pList)
    {
        List<Product> pList = prodService.addMultipleProducts(_pList);
        return new ResponseEntity<>(pList,HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Product> updateProduct(@RequestBody Product updatedProd)
    {
        Product updatedProduct = prodService.updateProduct(updatedProd);
        return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Product> deleteProductById(@PathVariable("id") Long id)
    {
        prodService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete/all")
    public ResponseEntity<Product> deleteAllProducts()
    {
        prodService.deleteAll();
        return new ResponseEntity<>(HttpStatus.OK);
    }



}
