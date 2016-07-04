package com.ps.induction.meeting.room.facade.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import com.ps.induction.meeting.room.domain.entity.Function;
import com.ps.induction.meeting.room.domain.entity.Meeting;
import com.ps.induction.meeting.room.domain.entity.Role;
import com.ps.induction.meeting.room.domain.repository.FunctionRepository;
import com.ps.induction.meeting.room.domain.repository.MeetingRepository;
import com.ps.induction.meeting.room.domain.repository.RoleRepository;
import com.ps.induction.meeting.room.facade.FunctionFacade;
import com.ps.induction.meeting.room.facade.MeetingFacade;
import com.ps.induction.meeting.room.facade.RoleFacade;

/**
 * @author Loai AlTamimi
 *
 */
@Transactional
public class RoleFacadeImpl implements RoleFacade {
	
	@Autowired
	private RoleRepository roleRepository;

	@Override
	public Role getRoleById(Long id) {
		return roleRepository.findOne(id);
	}

	@Override
	public void addRole(Role role) {
		roleRepository.save(role);
	}

	@Override
	public Iterable<Role> getAllRoles() {
		return roleRepository.findAll();
	}
	
}
