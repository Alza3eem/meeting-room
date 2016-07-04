package com.ps.induction.meeting.room.facade;

import com.ps.induction.meeting.room.domain.entity.Function;

/**
 * @author Loai AlTamimi
 *
 */
public interface FunctionFacade {
	
	Iterable<Function> getAllFunctions();
	
	Iterable<Function> getAllFunctionsByIds(Iterable<Long> ids);
	
	Function getFunctionById(Long id);
	
	void addFuncrion(Function function);
	
	void removeFunctionById(Long id);

}
