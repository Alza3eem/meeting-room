package com.ps.induction.meeting.room.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Eyad Jarrar
 *
 */
@Entity
@Table(name = "roles")
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "role_name")
	private String roleName;

	// @ManyToMany
	// @JoinColumn(name = "fnc_id")
	// private Function function

}
