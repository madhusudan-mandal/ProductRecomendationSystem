package com.mandal.prs;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ProductService {

	private List<Product> products;
	
	ProductService()
	{
		this.products= new ArrayList<>();	
	}
	
	//Add product
	public void add(Product product)
	{
		products.add(product);
	}
	
	//Remove product by id
	public void removeById(Integer id)
	{
		products.removeIf(product-> product.getId()==id);
	}
	
	//Search product by name
	public List<Product> searchByName(String name)
	{
		return products.stream().filter(product-> product.getName().equalsIgnoreCase(name))
				.collect(Collectors.toList());
	}
	
	//Filter by Category
	public List<Product> filterByCategory(String category)
	{
		return products.stream()
				.filter(product-> product.getCategory().equalsIgnoreCase(category))
				.collect(Collectors.toList());
	}
	//Filter by Price Range
	public List<Product> filterByPriceRange(Float min, Float max)
	{
		return products.stream()
				.filter(product-> product.getPrice()>=min && product.getPrice()<=max)
				.collect(Collectors.toList());
	}
	//Filter by Rating
	public List<Product> filterByRating(Integer rating)
	{
		return products.stream()
				.filter(product-> product.getRating()>=rating)
				.collect(Collectors.toList());
	}
	
	//Sort Products By Price
	public List<Product> sortByPrice()
	{
		return products.stream()
				.sorted((product1, product2)-> product1.getPrice().compareTo(product2.getPrice()))
				.collect(Collectors.toList());
		
		// by default sorted() method uses Comparator object as a argument, here i am using default implementation of Comparable Interface provided
		// by wrapper class
	}
	
	//Sort Products By Rating
	public List<Product> sortByRating()
	{
		return products.stream()
				.sorted((product1, product2)-> product1.getRating().compareTo(product2.getRating()))
				.collect(Collectors.toList());
		
		// by default sorted() method uses Comparator object as a argument, here i am using default implementation of Comparable Interface provided
		// by wrapper class
	}
	
	//Group product by category
	public Map<String, List<Product>> groupByCategory()
	{
		return products.stream()
				.collect(Collectors.groupingBy(Product::getCategory));
	}
	
	//Display all products
	public void displayAllProducts()
	{
		products.stream().forEach(System.out::println);
	}
	
	
}
