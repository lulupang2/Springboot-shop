package springshop.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.web.bind.annotation.RequestBody;

import springshop.domain.Products;
import springshop.repository.ProductRepository;

@Transactional
public class ProductService {
	private final ProductRepository productRepository;
	
	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	public Products create(Products products) { //상품 저장
		return productRepository.save(products);
	}

	public List<Products> findProduct() { // 모든 상품
		return productRepository.findAll();
	}
	
//	public List<Products> findCategory(Products products) {//
//		return productRepository.findByCategory(products.getP_category());
//		
//	}
	
}
