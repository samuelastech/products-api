package samuelastech.api.product;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import samuelastech.api.product.dtos.ProductDTO;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {
	private ProductService productService;
	
	@GetMapping
	public List<ProductDTO> get() {
		return productService.get();
	}
	
	@GetMapping("/category/{categoryId}")
	public List<ProductDTO> getByCategoryId(@PathVariable long categoryId) {
		return productService.getByCategoryId(categoryId);
	}
	
	@GetMapping("/{identifier}")
	public ProductDTO getByIdentifier(@PathVariable String identifier) {
		return productService.getByIdentifier(identifier);
	}
	
	@PostMapping
	public ProductDTO create(@Valid @RequestBody ProductDTO product) {
		return productService.create(product);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		productService.delete(id);
	}
	
	@PutMapping("/{id}")
	public ProductDTO update(@PathVariable long id, @Valid @RequestBody ProductDTO product) {
		return productService.update(id, product);
	}
	
	@GetMapping("/pageable")
	public Page<ProductDTO> getProductsPage(Pageable pageable) {
		return productService.getAllPage(pageable);
	}
}
