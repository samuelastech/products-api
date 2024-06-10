package samuelastech.api.category;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import samuelastech.api.category.dtos.CategoryDTO;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "category")
public class CategoryEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	
	public static CategoryEntity convert(CategoryDTO categoryDTO) {
		CategoryEntity category = new CategoryEntity();
		category.setId(categoryDTO.getId());
		category.setName(categoryDTO.getName());
		return category;
	}
}
