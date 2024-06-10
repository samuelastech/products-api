package samuelastech.api.category.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import samuelastech.api.category.CategoryEntity;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDTO {
	@NotNull
	private long id;
	private String name;
	
	public static CategoryDTO convert(CategoryEntity category) {
		CategoryDTO categoryDTO = new CategoryDTO();
		categoryDTO.setId(category.getId());
		categoryDTO.setName(category.getName());
		return categoryDTO;
	}
}
