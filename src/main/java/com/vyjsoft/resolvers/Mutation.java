package com.vyjsoft.resolvers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vyjsoft.entity.Category;
import com.vyjsoft.entity.Product;
import com.vyjsoft.repository.CategoryRepository;
import com.vyjsoft.repository.ProductRepository;

import graphql.kickstart.tools.GraphQLMutationResolver;

@Component
public class Mutation implements GraphQLMutationResolver {
	
	@Autowired
	private CategoryRepository cRepo;
	
	@Autowired
	private ProductRepository pRepo;
	
	public Category addCategory(String nombreCategoria) {
		Category categoria = new Category();
		
		categoria.setName(nombreCategoria);
		
		return cRepo.saveAndFlush(categoria);
	}
	
	public Product addProduct(String name, String code, Double price, Integer category_id) {
		
		Category categoria = cRepo.findById(category_id).orElseGet(null);
		
		Product producto = new Product();
		
		producto.setName(name);
		producto.setCode(code);
		producto.setPrice(price);
		producto.setCategory(categoria);
		
		return pRepo.saveAndFlush(producto);
	}
	
	
	public Category updateCategory(Integer idCategoria, String nombreCategoria) {
		
		Category categoria = new Category();
		
		categoria.setId(idCategoria);
		categoria.setName(nombreCategoria);
		
		return cRepo.saveAndFlush(categoria);
	}
	
	public Product updateProduct(Integer id, String name, String code, Double price, Integer category_id) {
		
		Category nCategoria = cRepo.findById(category_id).orElseGet(null);
		
		Product nProducto = new Product();
		nProducto.setCategory(nCategoria);
		nProducto.setCode(code);
		nProducto.setId(id);
		nProducto.setName(name);
		nProducto.setPrice(price);
		
		return pRepo.saveAndFlush(nProducto);
	}
	
	public Boolean deleteCategory(Integer idCategoria) {
		
		cRepo.deleteById(idCategoria);
		return true;
	}
	
	
	
	public Boolean deleteProduct(Integer idProducto) {
		
		pRepo.deleteById(idProducto);
		return true;
	}
	
}
