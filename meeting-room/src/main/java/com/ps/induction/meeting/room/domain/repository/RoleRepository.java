package com.ps.induction.meeting.room.domain.repository;

import org.springframework.data.repository.CrudRepository;

import com.ps.induction.meeting.room.domain.entity.Role;

/**
 * @author u592
 *
 */
public interface RoleRepository extends CrudRepository<Role, Long> {
	
}