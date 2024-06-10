package samuelastech.api.product;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
	public List<ProductEntity> getProductByCategory(@Param("categoryId") long categoryId);
	public ProductEntity findByProductIdentifier(String productIdentifier);
}
