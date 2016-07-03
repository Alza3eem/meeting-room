package com.ps.induction.meeting.room.domain.repository;

import org.springframework.data.repository.CrudRepository;

import com.ps.induction.meeting.room.domain.entity.Role;

/**
 * @author Eyad Jarrar
 *
 */
public interface RoleRepository extends CrudRepository<Role, Integer> {
	
}