package com.ps.induction.meeting.room.domain.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
	@Column(name = "role_id")
	private Long roleId;

	@Column(name = "role_name")
	private String roleName;

	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name = "roles_funcs", joinColumns = {
			@JoinColumn(name = "role_id", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "function_id", nullable = false, updatable = false) })
	private List<Function> function;

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public List<Function> getFunction() {
		return function;
	}

	public void setFunction(List<Function> function) {
		this.function = function;
	}

}
