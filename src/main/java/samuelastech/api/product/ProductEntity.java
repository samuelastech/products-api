package samuelastech.api.product;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import samuelastech.api.category.CategoryEntity;
import samuelastech.api.product.dtos.ProductDTO;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "product")
public class ProductEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	private String description;
	private float price;
	
	@Column(name = "product_identifier")
	private String productIdentifier;
	
	@ManyToOne
	@JoinColumn(name = "category_id")
	private CategoryEntity category;
	
	public static ProductEntity convert(ProductDTO productDTO) {
		ProductEntity product = new ProductEntity();
		product.setName(productDTO.getName());
		product.setDescription(productDTO.getDescription());
		product.setPrice(productDTO.getPrice());
		product.setProductIdentifier(productDTO.getProductIdentifier());
		
		if (productDTO.getCategoryDTO() != null) {
			product.setCategory(CategoryEntity.convert(productDTO.getCategoryDTO()));
		}
		
		return product;
	}
}
