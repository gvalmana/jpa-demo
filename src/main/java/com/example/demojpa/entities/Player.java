package com.example.demojpa.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "players")
public class Player {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long Id;
	
	@Column(name = "name", unique = true)
	private String name;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "age")
	private Short age;
	
	@Column(name = "nationality")
	private String nationality;
	
	@Column(name = "position")
	private String position;
	
	@ManyToOne(targetEntity = Club.class)
	private Club club;
}
