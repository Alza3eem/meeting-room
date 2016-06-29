package com.ps.induction.meeting.room.domain.repository;

import org.springframework.stereotype.Repository;

import com.ps.induction.meeting.room.domain.entity.Function;

@Repository
public interface FunctionRepository extends org.springframework.data.repository.Repository<Function, Long> {

	public Function save(Function entity);

	public Function findOneById(String id);
	
}
