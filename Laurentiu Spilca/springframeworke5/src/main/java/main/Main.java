package main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.ProjectConfig;
import services.ProductService;

public class Main {

	public static void main(String[] args) {
		try (var c = new AnnotationConfigApplicationContext(ProjectConfig.class)) {
			ProductService p = c.getBean(ProductService.class);
			// p.addOneProduct();
			p.addTenProducts();
		}
	}
}
