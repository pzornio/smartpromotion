package ar.com.learsoft.smartpromotion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.com.learsoft.smartpromotion.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{

}
