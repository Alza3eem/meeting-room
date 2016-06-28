/**
 * 
 */
package com.ps.induction.meeting.room.domain.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * @author u522
 *
 */
@Entity
@Table(name="funtions")
public class Function {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name="function_name")
	private String functionName;
	
	@ManyToMany(cascade=CascadeType.ALL)
	private List<Role> funcInRoles;
}
