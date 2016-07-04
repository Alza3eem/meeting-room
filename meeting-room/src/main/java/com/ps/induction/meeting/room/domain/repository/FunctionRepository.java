package com.ps.induction.meeting.room.domain.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ps.induction.meeting.room.domain.entity.Function;

@Repository
public interface FunctionRepository extends CrudRepository<Function, Long> {

}
