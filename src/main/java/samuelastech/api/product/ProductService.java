package samuelastech.api.product;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import samuelastech.api.product.dtos.ProductDTO;

@Service
@RequiredArgsConstructor
public class ProductService {
	private ProductRepository productRepository;
	
	public List<ProductDTO> get() {
		List<ProductEntity> products = productRepository.findAll();
		return products.stream().map(ProductDTO::convert).collect(Collectors.toList());
	}
	
	public List<ProductDTO> getByCategoryId(long categoryId) {
		List<ProductEntity> products = productRepository.getProductByCategory(categoryId);
		return products.stream().map(ProductDTO::convert).collect(Collectors.toList());
	}
	
	public ProductDTO getByIdentifier(String identifier) {
		ProductEntity product = productRepository.findByProductIdentifier(identifier);
		return product != null ? ProductDTO.convert(product) : null;
	}
	
	public ProductDTO create(ProductDTO productDTO) {
		ProductEntity product = productRepository.save(ProductEntity.convert(productDTO));
		return ProductDTO.convert(product);
	}
	
	public void delete(long id) {
		Optional<ProductEntity> product = productRepository.findById(id);
		if (product.isPresent()) productRepository.delete(product.get());
	}
	
	public ProductDTO update(long id, ProductDTO productDTO) {
		ProductEntity product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
		if (productDTO.getName() != null || !productDTO.getName().isEmpty()) {
			product.setName(productDTO.getName());
		}
		
		if (productDTO.getPrice() != null) {
			product.setName(productDTO.getName());
		}
		
		return ProductDTO.convert(productRepository.save(product));
	}
	
	public Page<ProductDTO> getAllPage(Pageable page) {
		Page<ProductEntity> users = productRepository.findAll(page);
		return users.map(ProductDTO::convert);
	}
}
