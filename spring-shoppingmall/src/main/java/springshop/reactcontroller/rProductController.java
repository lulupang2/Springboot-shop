package springshop.reactcontroller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import springshop.domain.Products;
import springshop.repository.ProductRepository;
@CrossOrigin (origins = "*")
@RestController
public class rProductController {
	private final ProductRepository repository;

	public rProductController(ProductRepository repository) {
		// TODO Auto-generated constructor stub
		this.repository = repository;
	}

	@GetMapping("/api/products") // 테이블 모든 내용 반환
	List<Products> all() {
		return repository.findAll();
	}

	@PostMapping("api/products") // Post 요청 상품 저장
	Products newProducts(@RequestBody Products newProducts) {
		return repository.save(newProducts);
	}

	@GetMapping("/api/products/{id}") // 단일 개체 조회(상세페이지)
	Products one(@PathVariable Long id) throws Exception {// @PathVariable 어노테이션은 URI에 변수를 넣을때 사용

		return repository.findById(id).orElseThrow(() -> new Exception());
	}

	@PutMapping("/api/products/{id}") // 단일 수정
	Products modifyProducts(@RequestBody Products newProducts, @PathVariable Long id) {
		return repository.findById(id).map(products -> {
			products.setPcategory(newProducts.getPcategory());
			products.setPdetails(newProducts.getPdetails());
			products.setPimg1(newProducts.getPimg1());
			products.setPimg2(newProducts.getPimg2());
			products.setPname(newProducts.getPname());
			products.setPprice(newProducts.getPprice());
			return repository.save(newProducts);
		}).orElseGet(() -> {
			newProducts.setPnum(id);
			return repository.save(newProducts);
		});
	}

	@DeleteMapping("/api/products/{id}") // 단일 삭제
	void deleteProduct(@PathVariable Long id) {
		repository.deleteById(id);
	}

}
