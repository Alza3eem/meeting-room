package com.ps.induction.meeting.room.facade;

import java.util.List;

import com.ps.induction.meeting.room.domain.entity.Role;

/**
 * @author Loai AlTamimi
 *
 */
public interface RoleFacade {

	Role getRoleById(Long id);
	void addRole(Role role);
	Iterable<Role> getAllRoles();
}
