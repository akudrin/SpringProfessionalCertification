package repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import model.Product;

@Repository
public class ProductRepository {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void addProduct(Product product) {

		String sql = "INSERT INTO product VALUES (NULL,?,?)";
		jdbcTemplate.update(sql, product.getName(), product.getPrice());
	}

	public List<Product> getProducts() {
		String sql = "SELECT * FROM product";
		return jdbcTemplate.query(sql, new RowMapper<Product>() {

			@Override
			public Product mapRow(ResultSet arg0, int arg1) throws SQLException {
				Product p = new Product();
				p.setId(arg0.getInt("id"));
				p.setName(arg0.getString("name"));
				p.setPrice(arg0.getDouble("price"));
				return p;
			}
		});

	}

}
