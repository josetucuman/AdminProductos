package com.vyjsoft.entity;

import java.io.Serializable;

import javax.persistence.*;

import lombok.Data;

@Entity
@Table(name = "categoria")
@Data
public class Category implements Serializable {

	private static final long serialVersionUID = -1131780713813600091L;

	@Id
	@Column(name= "id_categoria")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "nombre")
	private String name;
	
}
