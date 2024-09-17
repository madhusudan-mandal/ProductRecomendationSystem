package com.mandal.prs;

public class Product {
	private Integer id;
	private String name;
	private String category;
	private Float price;
	private Float rating;
	
	Product(Integer id, String name, String category, Float price, Float rating)
	{
		this.id=id;
		this.name=name;
		this.category=category;
		this.price=price;
		this.rating=rating;
	}
	
	Product()
	{
		super();
	}
	
	// Getters
	public Integer getId()
	{
		return this.id;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getCategory()
	{
		return category;
	}
	
	public Float getPrice()
	{
		return price;
	}
	
	public Float getRating()
	{
		return rating;
	}
	
	//We do not have requirement to update product, so no need to create a setter here
	
	@Override
	public String toString()
	{
		return "Product [ ID: "+ id + ", Name: "+ name+", Category: "+category+", "
				+ "Price: " + price+", Rating: "+rating+" ]";
	}
	
	
}
