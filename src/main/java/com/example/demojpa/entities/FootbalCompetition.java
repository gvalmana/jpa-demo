package com.example.demojpa.entities;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "footbal_competitions")
public class FootbalCompetition {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long Id;
	
	@Column(name = "name", unique = true, length = 10, nullable = false, columnDefinition = "VARCHAR(300)")
	private String name;
	
	@Column(name = "quantity_price")
	private Integer quantityPrice;
	
	@Column(name = "start_date", columnDefinition = "DATE")
	private LocalDate startDate;
	
	@Column(name = "end_date", columnDefinition = "DATE")
	private LocalDate endDate;
	
	@ManyToMany(targetEntity = Club.class, fetch = FetchType.LAZY)
	private List<Club> clubes;
}
