package services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import repositories.ProductRepository;

@Service
public class ProductService {

	/**
	 * PROPAGATION LEVELS: REQUIRED (DEFAULT), MANDATORY, NEVER,
	 * SUPPORTS,NOT_SUPPORTED,NESTED
	 * 
	 */

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

	/*
	 * DEFAULT -> READ_COMMITED
	 * 
	 * READ_UNCOMMITED, READ_COMMITTED, REPEATABLE_READ, SERIALIZABLE
	 * 
	 * PROBLEMS: --dirty reads --repeatable reads --phantom reads
	 */

	@Transactional(isolation = Isolation.READ_COMMITTED)
	public void addTenProducts() {
		for (int i = 1; i <= 10; i++) {
			productRepository.addProduct("Product " + i, i * 2);
		}
	}

}
