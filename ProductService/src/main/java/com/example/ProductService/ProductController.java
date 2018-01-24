package com.example.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(value = "products")
public class ProductController {
	
	private final RestTemplate restTemplate;

	@Autowired
	public ProductController(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	@GetMapping("/search")
	public Product getProductsByTypeAndName(@RequestParam(value = "name") final String name) {
		System.out.println("name + " + name);
		String url = "http://PRICING-SERVICE/products/price?name=" + name;
		return restTemplate.getForObject(url, Product.class);
	}
}
