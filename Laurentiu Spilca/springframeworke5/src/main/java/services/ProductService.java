package services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	// custom settings
	// @Transactional(noRollbackFor = RuntimeException.class)
	// @Transactional(rollbackFor = Exception.class)
	// rollsback the RuntimeException but does not rollback the checked exception
	// with try catch RuntimeException rollback does NOT occur as we catch the
	// exception
	// inside of the transactional method
	@Transactional
	public void addOneProduct() {
		productRepository.addProduct("Beer", 25);
		try {
			throw new RuntimeException(":(");
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
	}
}
