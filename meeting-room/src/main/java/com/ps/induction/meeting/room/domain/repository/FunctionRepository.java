package com.ps.induction.meeting.room.domain.repository;

import org.springframework.stereotype.Repository;

import com.progressoft.meeetingsmanagement.entities.Function;

@Repository
public interface FunctionRepository extends org.springframework.data.repository.Repository<Function, Long> {

	public Function save(Function entity);

	public Function findOne(String id);
	
}
