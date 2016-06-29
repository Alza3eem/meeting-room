/**
 * 
 */
package com.ps.induction.meeting.room.facade.impl;

import com.ps.induction.meeting.room.domain.entity.User;
import com.ps.induction.meeting.room.domain.repository.UserRepository;
import com.ps.induction.meeting.room.facade.UserFacade;

/**
 * @author u592
 *
 */
public class UserFacadeImpl implements UserFacade{

	
	UserRepository userRepository;
	@Override
	public Iterable<User> getAllUsers() {
		return userRepository.findAll();
	}

}
