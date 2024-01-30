package com.example.demojpa.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "clubs")
public class Club {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long Id;
	
	@Column(name = "name", unique = true)
	private String name;
	
	@OneToOne(targetEntity = Coach.class, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "id_coach")
	private Coach coach;
	
	@OneToMany(targetEntity = Player.class, fetch = FetchType.LAZY, mappedBy = "club")
	private List<Player> players;
	
	@ManyToOne(targetEntity = FootbalAssociation.class)
	private FootbalAssociation association;
	
	@ManyToMany(targetEntity = FootbalCompetition.class, fetch = FetchType.LAZY)
	@JoinTable(name = "clubs_competitions", joinColumns = @JoinColumn(name="club"), inverseJoinColumns = @JoinColumn(name="competition"))
	private List<FootbalCompetition> competitions;
}
