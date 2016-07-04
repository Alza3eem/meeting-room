/**
 * 
 */
package com.ps.induction.meeting.room.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Loai AlTamimi
 *
 */
@Entity
@Table(name = "funtions")
public class Function {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "function_id")
	private Long functionId;

	@Column(name = "function_name")
	private String functionName;
	
	@Column(name = "page_name")
	private String pageName;
	
//	@ManyToMany(mappedBy="function")
//	private List<Role> funcInRoles;

	public Long getFunctionId() {
		return functionId;
	}

	public void setFunctionId(Long functionId) {
		this.functionId = functionId;
	}

	public String getFunctionName() {
		return functionName;
	}

	public void setFunctionName(String functionName) {
		this.functionName = functionName;
	}

	public String getPageName() {
		return pageName;
	}

	public void setPageName(String pageName) {
		this.pageName = pageName;
	}

/*	public List<Role> getFuncInRoles() {
		return funcInRoles;
	}

	public void setFuncInRoles(List<Role> funcInRoles) {
		this.funcInRoles = funcInRoles;
	}*/
}
