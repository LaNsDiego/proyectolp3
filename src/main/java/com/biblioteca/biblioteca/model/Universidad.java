package com.biblioteca.biblioteca.model;

import javax.persistence.*;

@Entity
public class Universidad {
	@Id	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int Id;
	public String Nombre;
 
}
