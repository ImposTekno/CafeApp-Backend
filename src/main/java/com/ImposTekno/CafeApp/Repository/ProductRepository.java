package com.ImposTekno.CafeApp.Repository;

import com.ImposTekno.CafeApp.Model.Product;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Qualifier(value = "products")
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findByProductName(String name);
    //Optional<Product> findByName(String name);
}
