package com.vyjsoft.entity;

import java.io.Serializable;

import javax.persistence.*;

import lombok.Data;

@Entity
@Table(name = "producto")
@Data
public class Product implements Serializable {

	private static final long serialVersionUID = -438007297927921690L;

	@Id
	@Column(name = "id_producto")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "nombre_producto")
	private String name;
	
	@Column(name = "cod_producto")
	private String code;
	
	@Column(name = "precio_prod")
	private Double price;
	
	@ManyToOne
	@JoinColumn(name = "category_id", nullable = false, updatable = false)
	private Category category;
	
}
