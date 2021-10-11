package springshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import springshop.domain.Products;

public interface ProductRepository extends JpaRepository<Products, Long> {

}
