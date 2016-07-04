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

	@Override
	public boolean equals(Object obj) {

		Function funTemp = (Function) obj;

		if (funTemp.getFunctionId() == this.functionId) {
			return true;
		} else {
			return false;
		}

	}

}
