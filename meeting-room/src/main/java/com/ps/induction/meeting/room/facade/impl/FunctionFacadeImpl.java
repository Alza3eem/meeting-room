package com.ps.induction.meeting.room.facade.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import com.ps.induction.meeting.room.domain.entity.Function;
import com.ps.induction.meeting.room.domain.repository.FunctionRepository;
import com.ps.induction.meeting.room.facade.FunctionFacade;

/**
 * @author Loai AlTamimi
 *
 */
@Transactional
public class FunctionFacadeImpl implements FunctionFacade {

	@Autowired
	private FunctionRepository functionRepository;

	@Override
	public Iterable<Function> getAllFunctions() {
		return functionRepository.findAll();
	}

	@Override
	public void addFuncrion(Function function) {
		functionRepository.save(function);
	}

	@Override
	public Function getFunctionById(Long id) {
		return functionRepository.findOne(id);
	}

	@Override
	public void removeFunctionById(Long id) {
		functionRepository.delete(id);
	}

	@Override
	public Iterable<Function> getAllFunctionsByIds(Iterable<Long> ids) {
		return functionRepository.findAll(ids);
	}
}
