package config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import beans.Cat;

@Configuration
@ComponentScan(basePackages = "beans")
public class ProjectConfig {

	/*
	 * @Bean public Cat cat() { Cat c = new Cat(); c.setName("Kitty"); return c; }
	 * 
	 * @Bean public Owner owner(Cat cat) { Owner o = new Owner(); o.setCat(cat);
	 * return o; }
	 */

	@Bean
	@Qualifier("cat1")
	public Cat cat1() {
		Cat c = new Cat();
		c.setName("Kitty");
		return c;
	}

	@Bean
	@Qualifier("cat2")
	// @Primary
	public Cat cat2() {
		Cat c = new Cat();
		c.setName("Johny");
		return c;
	}

}
