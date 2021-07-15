package repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
//all methods are affected by this transactional
@Transactional
public class ProductRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void addProduct(String name, double price) {
		String sql = "INSERT INTO product VALUES (NULL, ?, ?)";
		jdbcTemplate.update(sql, name, price);
	}
}
