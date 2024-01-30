package com.example.demojpa.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "footbal_associations")
public class FootbalAssociation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long Id;
	
	@Column(name = "name", unique = true)
	private String name;
	
	@Column(name = "country")
	private String country;
	
	@Column(name = "president")
	private String president;
	
	@OneToMany(targetEntity = Club.class, fetch = FetchType.LAZY, mappedBy = "association")
	private List<Club> clubes;
}
