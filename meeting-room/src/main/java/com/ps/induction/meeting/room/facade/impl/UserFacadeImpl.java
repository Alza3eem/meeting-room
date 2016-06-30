/**
 * 
 */
package com.ps.induction.meeting.room.facade.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.ps.induction.meeting.room.domain.entity.User;
import com.ps.induction.meeting.room.domain.repository.UserRepository;
import com.ps.induction.meeting.room.facade.UserFacade;

/**
 * @author u592
 *
 */
public class UserFacadeImpl implements UserFacade{

	@Autowired
	UserRepository userRepository;
	
	@Override
	public Iterable<User> getAllUsers() {
		return userRepository.findAll();
	}

}
