package samuelastech.api.product.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import samuelastech.api.category.dtos.CategoryDTO;
import samuelastech.api.product.ProductEntity;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
	@NotBlank
	private String name;
	
	@NotBlank
	private String description;
	
	@NotNull
	private Float price;
	
	@NotBlank
	private String productIdentifier;
	
	@NotNull
	private CategoryDTO categoryDTO;
	
	public static ProductDTO convert(ProductEntity product) {
		ProductDTO productDTO = new ProductDTO();
		productDTO.setName(product.getName());
		productDTO.setPrice(product.getPrice());
		productDTO.setProductIdentifier(product.getProductIdentifier());
		productDTO.setDescription(product.getDescription());
		if (product.getCategory() != null) {
			productDTO.setCategoryDTO(CategoryDTO.convert(product.getCategory()));
		}
		return productDTO;
	}
}
