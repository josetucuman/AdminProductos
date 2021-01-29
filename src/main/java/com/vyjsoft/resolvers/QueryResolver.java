package com.vyjsoft.resolvers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vyjsoft.entity.Category;
import com.vyjsoft.entity.Product;
import com.vyjsoft.repository.CategoryRepository;
import com.vyjsoft.repository.ProductRepository;

import graphql.kickstart.tools.GraphQLQueryResolver;


@Component
public class QueryResolver implements GraphQLQueryResolver{
	
	@Autowired
	private CategoryRepository repositorioCategoria;
	
	@Autowired
	private ProductRepository repositorioProducto;
	
	public List<Category> allCaterories() {
		
		return repositorioCategoria.findAll();
		
	}
	
	public List<Product> allProducts(){
		
		return repositorioProducto.findAll();
	}
	
	public Category category(Integer idCategoria) {
		return repositorioCategoria.findById(idCategoria).orElseGet(null);
	}
	
	public Product product(Integer idProducto) {
		return repositorioProducto.findById(idProducto).orElseGet(null);
	}
	
	public Long countCategories() {
		return repositorioCategoria.count();
	}
	
	public Long countProducts() {
		return repositorioProducto.count();
	}

}
